package com.huarui.common.utils.sms;

import com.huarui.common.utils.sms.httpclient.*;
import com.huarui.common.utils.sms.utils.SmsSenderUtil;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URISyntaxException;

public class GetReportDataPuller extends SmsBase {

	private String url = "http://api.51welink.com/EncryptionQuery/GetReport.ashx";
	
	public GetReportDataPuller(String account, String password) {
		super(account, password, new DefaultHttpClient());
	}
	
	public GetReportDataPuller(String account, String password, IHttpClient httpClient) {
		super(account, password, httpClient);
	}

	public GetReportDataResult pull(String OutId, String ReportTime) throws HttpException, JSONException, IOException {
		long random = SmsSenderUtil.getRandom();
		long timestamp = SmsSenderUtil.getCurrentTime();
		JSONObject body = new JSONObject()
				.put("AccountId", this.accountId)
				.put("OutId", !SmsSenderUtil.isNotEmpty(OutId) ? OutId : "")
				.put("AccessKey", SmsSenderUtil.calcMoReportSign(accountId, password, random, timestamp))
				.put("Timestamp", timestamp)
				.put("Random", random)
				.put("ReportTime", !SmsSenderUtil.isNotEmpty(ReportTime) ? ReportTime : "");
		
		HttpRequest request = new HttpRequest(HttpMethod.POST, url)
				.addHeader("Content-Type", "application/json")
                //.addQueryParameter("Account", this.accountId)//将登陆账号放入QueryParameter中
                //.addQueryParameter("random", random)//将一个随机数放入QueryParameter中
                .setConnectTimeout(60 * 1000)
                .setRequestTimeout(60 * 1000)
                .setBody(body.toString());
		try {
			HttpResponse response = httpClient.fetch(request);
			
			handleError(response);
			
			return (new GetReportDataResult()).parseFromHttpResponse(response);
			
		} catch (URISyntaxException e) {
			throw new RuntimeException("API url has been modified, current url: " + url);
		}
	}
}

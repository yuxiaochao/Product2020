package com.huarui.common.utils.sms;

import com.huarui.common.utils.sms.httpclient.*;
import com.huarui.common.utils.sms.utils.SmsSenderUtil;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URISyntaxException;

public class GetMoDataPuller extends SmsBase {
	private String url = "http://api.51welink.com/EncryptionQuery/GetMo.ashx";
	
	public GetMoDataPuller(String account, String password) {
		super(account, password, new DefaultHttpClient());
	}
	
	public GetMoDataPuller(String account, String password, IHttpClient httpClient) {
		super(account, password, httpClient);
		// TODO Auto-generated constructor stub
	}

	public GetMoDataResult pull() throws HttpException, JSONException, IOException {
		long Random = SmsSenderUtil.getRandom();
		long Timestamp = SmsSenderUtil.getCurrentTime();
		JSONObject body = new JSONObject()
				.put("AccountId", this.accountId)
				.put("AccessKey", SmsSenderUtil.calcMoReportSign(accountId, password, Random, Timestamp))
				.put("Timestamp", Timestamp)
                .put("Random", Random);
		
		HttpRequest request = new HttpRequest(HttpMethod.POST, url)
				.addHeader("Content-Type", "application/json")
                //.addQueryParameter("AccountId", this.accountId)//将登陆账号放入QueryParameter中
                //.addQueryParameter("random", random)//将一个随机数放入QueryParameter中
                .setConnectTimeout(60 * 1000)
                .setRequestTimeout(60 * 1000)
                .setBody(body.toString());
		
		
		try {
			HttpResponse response = httpClient.fetch(request);
			
			handleError(response);
			
			return (new GetMoDataResult()).parseFromHttpResponse(response);
		} catch (URISyntaxException e) {
			throw new RuntimeException("API url has been modified, current url: " + url);
		}
		
	}
}

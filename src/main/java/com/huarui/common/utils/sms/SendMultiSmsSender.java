package com.huarui.common.utils.sms;

import com.huarui.common.utils.sms.httpclient.*;
import com.huarui.common.utils.sms.utils.SmsSenderUtil;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URISyntaxException;

public class SendMultiSmsSender extends SmsBase {
	private String url = "http://api.51welink.com/EncryptionSubmit/SendMultiSms.ashx";
	
	public SendMultiSmsSender(String accountId, String password) {
		super(accountId, password, new DefaultHttpClient());
	}
	
	public SendMultiSmsSender(String account, String password, IHttpClient httpClient) {
		super(account, password, httpClient);
		// TODO Auto-generated constructor stub
	}
	
	public SendMultiSmsResult send(String ExtendNo, String ProductId,
                                   String TempParams, String TemplateSms, String OutId) throws HttpException, JSONException, IOException {
		long random = SmsSenderUtil.getRandom();
		long timestamp = SmsSenderUtil.getCurrentTime();
		JSONObject body = new JSONObject()
				.put("AccountId", this.accountId)
				.put("ExtendNo", SmsSenderUtil.isNotEmpty(ExtendNo) ? ExtendNo : "")
                .put("ProductId", SmsSenderUtil.isNotEmpty(ProductId) ? ProductId : "")
                .put("TempParams", TempParams)
                .put("TemplateSms", TemplateSms)
                .put("AccessKey", SmsSenderUtil.calcMutilSmsSign(accountId, password, random, timestamp))
                .put("Random", random)
                .put("Timestamp", timestamp)
                .put("OutId", SmsSenderUtil.isNotEmpty(OutId) ? OutId : "");
                
		HttpRequest request = new HttpRequest(HttpMethod.POST, this.url)
				.addHeader("Content-Type", "application/json")
                //.addQueryParameter("Account", this.accountId)//将登陆账号放入QueryParameter中
                //.addQueryParameter("random", random)//将一个随机数放入QueryParameter中
                .setConnectTimeout(60 * 1000)
                .setRequestTimeout(60 * 1000)
                .setBody(body.toString());
		
		try {
			HttpResponse response = httpClient.fetch(request);
			handleError(response);
			
			return (new SendMultiSmsResult()).parseFromHttpResponse(response);
			
		} catch (URISyntaxException e) {
			throw new RuntimeException("API url has been modified, current url: " + url);
		}
	}
}

package com.huarui.common.utils.sms;

import com.huarui.common.utils.sms.httpclient.*;
import com.huarui.common.utils.sms.utils.SmsSenderUtil;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class SendSmsSender extends SmsBase {
	private String url = "http://api.51welink.com/EncryptionSubmit/SendSms.ashx";
	
	public SendSmsSender(String account, String password) {
		super(account, password, new DefaultHttpClient());
	}
	
	public SendSmsSender(String accountId, String password, IHttpClient httpClient) {
		super(accountId, password, httpClient);
	}
	
	public SendSmsResult send(String ExtendNo, String ProductId, ArrayList<String> PhoneNos,
                              String Content, String SendTime, String OutId) throws HttpException, JSONException, IOException {
		
		long Random = SmsSenderUtil.getRandom();
		long Timestamp = SmsSenderUtil.getCurrentTime();
		JSONObject body = new JSONObject()
				.put("AccountId", this.accountId)
				.put("ExtendNo", SmsSenderUtil.isNotEmpty(ExtendNo) ? ExtendNo : "")
                .put("ProductId", SmsSenderUtil.isNotEmpty(ProductId) ? ProductId : "")
                .put("PhoneNos", String.join(",", PhoneNos))
                .put("Content", SmsSenderUtil.isNotEmpty(Content) ? Content : "")
                .put("AccessKey", SmsSenderUtil.calcSendSmsSign(accountId, PhoneNos.get(0), this.password, Random, Timestamp))
                .put("Timestamp", Timestamp)
                .put("Random", Random)
                .put("OutId", SmsSenderUtil.isNotEmpty(OutId) ? OutId : "")
                .put("SendTime", SmsSenderUtil.isNotEmpty(SendTime) ? SendTime : "");
		
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
			
			return (new SendSmsResult()).parseFromHttpResponse(response);
		} catch (URISyntaxException e) {
			throw new RuntimeException("API url has been modified, current url: " + url);
		}
	}
}

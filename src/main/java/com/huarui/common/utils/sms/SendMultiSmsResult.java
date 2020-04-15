package com.huarui.common.utils.sms;


import com.huarui.common.utils.sms.httpclient.HttpResponse;
import org.json.JSONException;
import org.json.JSONObject;

public class SendMultiSmsResult extends SmsResultBase {

	public String Result;      //提交状态值
    public String MsgId;   //短信批次号
    public String Reason;//审查是否通过标记
	
    public SendMultiSmsResult() {
    	Result = "-1";
    	MsgId = "";
		Reason = "";
	}
    
	@Override
	public SendMultiSmsResult parseFromHttpResponse(HttpResponse response) throws JSONException {
		JSONObject jsonObject = parseToJson(response);
		
		if(jsonObject.has("Result")) {
			Result = jsonObject.getString("Result");
		}
		if(jsonObject.has("MsgId")) {
			MsgId = jsonObject.getString("MsgId");
		}
		if(jsonObject.has("Reason")) {
			Reason = jsonObject.getString("Reason");
		}
		
		return this;
	}

}

package com.huarui.common.utils.sms;


import com.huarui.common.utils.sms.httpclient.HttpResponse;
import org.json.JSONException;
import org.json.JSONObject;

public class SendTemplateSmsResult extends SmsResultBase {

	public String Result;      //提交状态值
    public String Reason;//审查是否通过标记
    public long MsgId;   //短信批次号
    public int SplitCount;
    
	
    public SendTemplateSmsResult() {
    	Result = "-1";
    	MsgId = 0;
		Reason = "";
		SplitCount = 0;
	}
    
	@Override
	public SendTemplateSmsResult parseFromHttpResponse(HttpResponse response) throws JSONException {
		// TODO Auto-generated method stub
		JSONObject jsonObject = parseToJson(response);
		
		if(jsonObject.has("Result")) {
			Result = jsonObject.getString("Result");
		}
		if(jsonObject.has("MsgId")) {
			MsgId = jsonObject.getLong("MsgId");
		}
		if(jsonObject.has("Reason")) {
			Reason = jsonObject.getString("Reason");
		}
		if(jsonObject.has("SplitCount")) {
			SplitCount = jsonObject.getInt("SplitCount");
		}
		return this;
	}
}

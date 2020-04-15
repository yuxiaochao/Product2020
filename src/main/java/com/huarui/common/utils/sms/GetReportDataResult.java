package com.huarui.common.utils.sms;

import com.huarui.common.utils.sms.httpclient.HttpResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class GetReportDataResult extends SmsResultBase {

	public class ReportInfo {
		
		public String MsgID;
        public String PhoneNos;
        public String SendTime;
        public String ReportDesc;
        public String ReportCode;
        public String ReportTime;
        public String SpNo;
        public String OutId;
        public String SendCode;
        public String SendDesc;
        public String AccountId;
        public String SourceCode;
        public String SourceDesc;
        
        public String toString() {
        	String[] fields = {"MsgID", "PhoneNos", "SendTime", "ReportDesc",
        			"ReportCode", "ReportTime", "SpNo", "OutId", "SendCode",
        			"SendDesc", "AccountId", "SourceCode", "SourceDesc"};
        	return (new JSONObject(this, fields)).toString();
        }
        
        public ReportInfo parse(JSONObject json) throws JSONException {
        	if(json.has("MsgID")) {
        		MsgID = json.getString("MsgID");
        	}
        	if(json.has("PhoneNos")) {
        		PhoneNos = json.getString("PhoneNos");
        	}
        	if(json.has("SendTime")) {
        		SendTime = json.getString("SendTime");
        	}
        	if(json.has("ReportDesc")) {
        		ReportDesc = json.getString("ReportDesc");
        	}
        	if(json.has("ReportCode")) {
        		ReportCode = json.getString("ReportCode");
        	}
        	if(json.has("ReportTime")) {
        		ReportTime = json.getString("ReportTime");
        	}
        	if(json.has("SpNo")) {
        		SpNo = json.getString("SpNo");
        	}
        	if(json.has("OutId")) {
        		OutId = json.getString("OutId");
        	}
        	if(json.has("SendCode")) {
        		SendCode = json.getString("SendCode");
        	}
        	if(json.has("SendDesc")) {
        		SendDesc = json.getString("SendDesc");
        	}
        	if(json.has("AccountId")) {
        		AccountId = json.getString("AccountId");
        	}
        	if(json.has("SourceCode")) {
        		SourceCode = json.getString("SourceCode");
        	}
        	if(json.has("SourceDesc")) {
        		SourceDesc = json.getString("SourceDesc");
        	}
        	return this;
        }
	}
	
	public String Result;
	
	public String Reason;
	
	public ArrayList<ReportInfo> ReportInfos;
	
	public GetReportDataResult() {
		Result = "-1";
		Reason = "";
		ReportInfos = new ArrayList<ReportInfo>();
	}
	
	@Override
	public GetReportDataResult parseFromHttpResponse(HttpResponse response) throws JSONException {
		
		JSONObject jsonObject = parseToJson(response);
		
		if(jsonObject.has("Result")) {
			Result = jsonObject.getString("Result");
		}
		if(jsonObject.has("Reason")) {
			Reason = jsonObject.getString("Reason");
		}
		
		if(jsonObject.has("ReportInfos") && !jsonObject.isNull("ReportInfos")) {
			JSONArray jsonReportInfos = jsonObject.getJSONArray("ReportInfos");
			for(int i=0; i<jsonReportInfos.length(); i++) {
				ReportInfos.add((new ReportInfo()).parse(jsonReportInfos.getJSONObject(i)));
			}
		}
		
		return this;
	}
	
	
}

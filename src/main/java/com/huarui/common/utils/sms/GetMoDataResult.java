package com.huarui.common.utils.sms;

import com.huarui.common.utils.sms.httpclient.HttpResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class GetMoDataResult extends SmsResultBase {

	public class MoInfo {
		public String MsgID;
		
		public String SpNo;
		
		public String PhoneNos;
		
		public String MoContent;
		
		public String MoTime;
		
		public String ResourceNo;
		
		public String Province;
		
		public String City;
		
		public String OutId;
		
		public String toString() {
			String[] fields = {"MsgID", "SpNo", "PhoneNos", "MoContent", "MoTime", "ResourceNo", "Province", "City", "OutId"};
			return (new JSONObject(this, fields)).toString();
		}
		
		public MoInfo parse(JSONObject json) throws JSONException {
			if(json.has("MsgID")) {
				MsgID = json.getString("MsgID");
			}
			if(json.has("SpNo")) {
				SpNo = json.getString("SpNo");
			}
			if(json.has("PhoneNos")) {
				PhoneNos = json.getString("PhoneNos");
			}
			if(json.has("MoContent")) {
				MoContent = json.getString("MoContent");
			}
			if(json.has("MoTime")) {
				MoTime = json.getString("MoTime");
			}
			if(json.has("ResourceNo")) {
				ResourceNo = json.getString("ResourceNo");
			}
			if(json.has("Province")) {
				Province = json.getString("Province");
			}
			if(json.has("City")) {
				City = json.getString("City");
			}
			if(json.has("OutId")) {
				OutId = json.getString("OutId");
			}
			
			return this;
		}
	}
	
	public String Result;
	
	public String Reason;
	
	public boolean IsFull;
	
	public ArrayList<MoInfo> MoInfos;
	
	public GetMoDataResult() {
		this.Result = "-1";
		this.Reason = "";
		this.IsFull = false;
		this.MoInfos = new ArrayList<MoInfo>();
	}
	
	@Override
	public GetMoDataResult parseFromHttpResponse(HttpResponse response) throws JSONException {
		
		JSONObject jsonObject = parseToJson(response);
		if(jsonObject.has("Result")) {
			Result = jsonObject.getString("Result");
		}
		if(jsonObject.has("MsgState")) {
			Reason = jsonObject.getString("MsgState");
		}
		if(jsonObject.has("IsFull")) {
			IsFull = jsonObject.getBoolean("IsFull");
		}
		if(jsonObject.has("MoInfos") && !jsonObject.isNull("MoInfos")) {
			JSONArray jsonMoInfos = jsonObject.getJSONArray("MoInfos");
			for(int i= 0; i< jsonMoInfos.length(); i++) {
				MoInfos.add((new MoInfo()).parse(jsonMoInfos.getJSONObject(i)));
			}
		}
		return this;
	}
}

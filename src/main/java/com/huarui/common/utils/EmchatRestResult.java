package com.huarui.common.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;

public class EmchatRestResult implements java.io.Serializable {
	
	private int code;
	
	private String message;
	
	private HashMap<String, Object> messageMap;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
		
		messageMap = new Gson().fromJson(message, new TypeToken<HashMap>(){}.getType());
	}
	public HashMap<String, Object> getMessageMap() {
		return messageMap;
	}
	public void setMessageMap(HashMap<String, Object> messageMap) {
		this.messageMap = messageMap;
	}

}

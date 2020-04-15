package com.huarui.product2020.entity;

import java.util.List;
import java.util.Map;

public class Email {
	// 收件人
	private String addressee;
	// 收件人
	private String sender;
	// 收件人列表
	private List recipientList;
	// 附件列表
	private Map emailAttra;
	// 用户名
	private String username;
	// 发送标示
	private String MMode;
	// 是否需要确认
	private String isConfirm;
	// 标题
	private String title;
	// 正文
	private String content;
	//多个附件
	private List<Map<String, Object>> attachList;
	
	//邮件类型
	//0 默认考试
	//1找回密码
	private int type = 0;

	private List<Map> userList;

	private boolean flag;
	
	private Map userMap;

	public String getAddressee() {
		return addressee;
	}

	public void setAddressee(String addressee) {
		this.addressee = addressee;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public List getRecipientList() {
		return recipientList;
	}

	public void setRecipientList(List recipientList) {
		this.recipientList = recipientList;
	}

	public Map getEmailAttra() {
		return emailAttra;
	}

	public void setEmailAttra(Map emailAttra) {
		this.emailAttra = emailAttra;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMMode() {
		return MMode;
	}

	public void setMMode(String mode) {
		MMode = mode;
	}

	public String getIsConfirm() {
		return isConfirm;
	}

	public void setIsConfirm(String isConfirm) {
		this.isConfirm = isConfirm;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<Map> getUserList() {
		return userList;
	}

	public void setUserList(List<Map> userList) {
		this.userList = userList;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Map getUserMap() {
		return userMap;
	}

	public void setUserMap(Map userMap) {
		this.userMap = userMap;
	}

	public List<Map<String, Object>> getAttachList() {
		return attachList;
	}

	public void setAttachList(List<Map<String, Object>> attachList) {
		this.attachList = attachList;
	}
	
	

}

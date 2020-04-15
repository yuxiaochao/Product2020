package com.huarui.product2020.pojo;

import java.util.Date;

public class QuesGrade {
	private String qgta001;
	private String qgta002;	//qid 问卷ID
	private String qgta003;	//userid 用户ID
	private Date qgta004;//qgbegintime 调查开始时间
	private Date qgta005; //qgendtime 调查交卷时间
	private String qgta006;  //wlgid 登录日志ID
	private int qgta007;  //调查状态（1 待提交 2已提交）
	
	
	public String getQgta001() {
		return qgta001;
	}
	public void setQgta001(String qgta001) {
		this.qgta001 = qgta001;
	}
	public String getQgta002() {
		return qgta002;
	}
	public void setQgta002(String qgta002) {
		this.qgta002 = qgta002;
	}
	public String getQgta003() {
		return qgta003;
	}
	public void setQgta003(String qgta003) {
		this.qgta003 = qgta003;
	}
	public Date getQgta004() {
		return qgta004;
	}
	public void setQgta004(Date qgta004) {
		this.qgta004 = qgta004;
	}
	public Date getQgta005() {
		return qgta005;
	}
	public void setQgta005(Date qgta005) {
		this.qgta005 = qgta005;
	}
	public String getQgta006() {
		return qgta006;
	}
	public void setQgta006(String qgta006) {
		this.qgta006 = qgta006;
	}
	public int getQgta007() {
		return qgta007;
	}
	public void setQgta007(int qgta007) {
		this.qgta007 = qgta007;
	}
	
	
}

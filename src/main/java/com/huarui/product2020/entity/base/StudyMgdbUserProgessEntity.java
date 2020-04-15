package com.huarui.product2020.entity.base;

public class StudyMgdbUserProgessEntity implements java.io.Serializable {
	/**
	 * 学员的课件学习当前进度ID
	 */
	private String upro001;
	
	/**
	 * 学习课程结果表id
	 */
	private String upro002;
	
	/**
	 * 用户ID
	 */
	private String upro003;
	
	/**
	 * 章节ID
	 */
	private String upro004;
	
	/**
	 * 课件进度：单位：秒 针对音视频课件
	 */
	private int upro005;
	
	/**
	 * 开始时间
	 */
	private String upro006;
	
	/**
	 * 结束时间
	 */
	private String upro007;
	
	/**
	 * 登录日志ID
	 */
	private String upro008;
	
	/**
	 * 学习端类型：0：PC端 1：IOS手机端 2：Android手机端 3：IOS-Pad 4：Android-Pad
	 */
	private Integer upro009;
	/**
	 * 是否学完（0未完成 1已完成）
	 */
	private Integer upro010;

	public String getUpro001() {
		return upro001;
	}

	public void setUpro001(String upro001) {
		this.upro001 = upro001;
	}

	public String getUpro002() {
		return upro002;
	}

	public void setUpro002(String upro002) {
		this.upro002 = upro002;
	}

	public String getUpro003() {
		return upro003;
	}

	public void setUpro003(String upro003) {
		this.upro003 = upro003;
	}

	public String getUpro004() {
		return upro004;
	}

	public void setUpro004(String upro004) {
		this.upro004 = upro004;
	}

	public String getUpro006() {
		return upro006;
	}

	public void setUpro006(String upro006) {
		this.upro006 = upro006;
	}

	public String getUpro007() {
		return upro007;
	}

	public void setUpro007(String upro007) {
		this.upro007 = upro007;
	}

	public String getUpro008() {
		return upro008;
	}

	public void setUpro008(String upro008) {
		this.upro008 = upro008;
	}

	public Integer getUpro009() {
		return upro009;
	}

	public void setUpro009(Integer upro009) {
		this.upro009 = upro009;
	}

	public int getUpro005() {
		return upro005;
	}

	public void setUpro005(int upro005) {
		this.upro005 = upro005;
	}

	public Integer getUpro010() {
		return upro010;
	}

	public void setUpro010(Integer upro010) {
		this.upro010 = upro010;
	}
}

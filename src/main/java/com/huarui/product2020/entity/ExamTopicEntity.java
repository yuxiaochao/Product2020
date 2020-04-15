package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;

import java.io.Serializable;

public class ExamTopicEntity extends Model<ExamTopicEntity> {

	private static final long serialVersionUID = 6254524214651185342L;
	
	/**
	 * 主键
	 */
	private String ID;
	
	/**
	 * 试卷ID
	 */
	private String TPID;
	
	/**
	 * 试题ID
	 */
	private String TOPICID;
	
	/**
	 * 内容
	 */
	private String TOPIC;
	
	/**
	 * 分数
	 */
	private Float TOPICMARK;
	
	/**
	 * 选项数
	 */
	private Long TOPICCOUNT;
	
	/**
	 * 题目选项
	 */
	private String TOPICOPTION;
	
	/**
	 * K值
	 */
	private String TOPICK;
	
	/**
	 * 客观题标准答案
	 */
	private String TOPICKEY;
	
	/**
	 * 题解
	 */
	private String TOPREMARK;
	
	/**
	 * 自关联ID：主题ID
	 */
	private String PARENTID;
	
	/**
     * 题型标题
     */
	private String BTXTITLE;
	
	/**
     * 基本题型 
	0――填空题
	1――单选题
	2――多选题
	3――判断题
	4――问答题
	5――组合题
	6——优选题
     */
	private Long BASETYPE;

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getTPID() {
		return TPID;
	}

	public void setTPID(String tPID) {
		TPID = tPID;
	}

	public String getTOPICID() {
		return TOPICID;
	}

	public void setTOPICID(String tOPICID) {
		TOPICID = tOPICID;
	}

	public String getTOPIC() {
		return TOPIC;
	}

	public void setTOPIC(String tOPIC) {
		TOPIC = tOPIC;
	}

	public Float getTOPICMARK() {
		return TOPICMARK;
	}

	public void setTOPICMARK(Float tOPICMARK) {
		TOPICMARK = tOPICMARK;
	}

	public Long getTOPICCOUNT() {
		return TOPICCOUNT;
	}

	public void setTOPICCOUNT(Long tOPICCOUNT) {
		TOPICCOUNT = tOPICCOUNT;
	}

	public String getTOPICOPTION() {
		return TOPICOPTION;
	}

	public void setTOPICOPTION(String tOPICOPTION) {
		TOPICOPTION = tOPICOPTION;
	}

	public String getTOPICK() {
		return TOPICK;
	}

	public void setTOPICK(String tOPICK) {
		TOPICK = tOPICK;
	}

	public String getTOPICKEY() {
		return TOPICKEY;
	}

	public void setTOPICKEY(String tOPICKEY) {
		TOPICKEY = tOPICKEY;
	}

	public String getTOPREMARK() {
		return TOPREMARK;
	}

	public void setTOPREMARK(String tOPREMARK) {
		TOPREMARK = tOPREMARK;
	}

	public String getPARENTID() {
		return PARENTID;
	}

	public void setPARENTID(String pARENTID) {
		PARENTID = pARENTID;
	}

	public String getBTXTITLE() {
		return BTXTITLE;
	}

	public void setBTXTITLE(String bTXTITLE) {
		BTXTITLE = bTXTITLE;
	}

	public Long getBASETYPE() {
		return BASETYPE;
	}

	public void setBASETYPE(Long bASETYPE) {
		BASETYPE = bASETYPE;
	}

	@Override
	protected Serializable pkVal() {
		return this.ID;
	}
	
	 /**
     * 题型顺序
     */
//	private Long ttx005;
	
	

	
}

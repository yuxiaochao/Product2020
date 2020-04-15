package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author su
 * @since 2020-02-23
 */
public class Tbclassaskquestions01 extends Model<Tbclassaskquestions01> {

    private static final long serialVersionUID = 1L;

    @TableId("CLAQ0101")
	private String claq0101;
    /**
     * 课程ID
     */
	@TableField("CLAQ0102")
	private String claq0102;
    /**
     * 用户ID
     */
	@TableField("CLAQ0103")
	private String claq0103;
	@TableField("CLAQ0104")
	private String claq0104;
    /**
     * 是否已采纳答案：0、否 1、是
     */
	@TableField("CLAQ0105")
	private Integer claq0105;
    /**
     * 采纳答案ID
     */
	@TableField("CLAQ0106")
	private String claq0106;
	@TableField("CLAQ0107")
	private Date claq0107;
	@TableField("CLAQ0108")
	private Date claq0108;
    /**
     * 一级章节ID
     */
	@TableField("CLAQ0109")
	private String claq0109;
    /**
     * 二级章节ID
     */
	@TableField("CLAQ0110")
	private String claq0110;
	@TableField("CLAQ0111")
	private Integer claq0111;
	@TableField("CLAQ0112")
	private Double claq0112;

	@TableField("CLAQ0113")
	private String claq0113;

	@TableField(exist = false)
	private String user005;
	@TableField(exist = false)
	private String user006;
	@TableField(exist = false)
	private String user028;
	@TableField(exist = false)
	private String ccwe003;
	@TableField(exist = false)
	private String cour002;
	@TableField(exist = false)
	private Integer answerNum;

	//回答列表（被采纳的答案） interviewee
	@TableField(exist = false)
	private List<Tbclassaskquestions02> interviewee;

	//回答列表（最新的答案） theLatestAnswer
	@TableField(exist = false)
	private List<Tbclassaskquestions02> theLatestAnswer;


	public String getClaq0101() {
		return claq0101;
	}

	public void setClaq0101(String claq0101) {
		this.claq0101 = claq0101;
	}

	public String getClaq0102() {
		return claq0102;
	}

	public void setClaq0102(String claq0102) {
		this.claq0102 = claq0102;
	}

	public String getClaq0103() {
		return claq0103;
	}

	public void setClaq0103(String claq0103) {
		this.claq0103 = claq0103;
	}

	public String getClaq0104() {
		return claq0104;
	}

	public void setClaq0104(String claq0104) {
		this.claq0104 = claq0104;
	}

	public Integer getClaq0105() {
		return claq0105;
	}

	public void setClaq0105(Integer claq0105) {
		this.claq0105 = claq0105;
	}

	public String getClaq0106() {
		return claq0106;
	}

	public void setClaq0106(String claq0106) {
		this.claq0106 = claq0106;
	}

	public Date getClaq0107() {
		return claq0107;
	}

	public void setClaq0107(Date claq0107) {
		this.claq0107 = claq0107;
	}

	public Date getClaq0108() {
		return claq0108;
	}

	public void setClaq0108(Date claq0108) {
		this.claq0108 = claq0108;
	}

	public String getClaq0109() {
		return claq0109;
	}

	public void setClaq0109(String claq0109) {
		this.claq0109 = claq0109;
	}

	public String getClaq0110() {
		return claq0110;
	}

	public void setClaq0110(String claq0110) {
		this.claq0110 = claq0110;
	}

	public Integer getClaq0111() {
		return claq0111;
	}

	public void setClaq0111(Integer claq0111) {
		this.claq0111 = claq0111;
	}

	public Double getClaq0112() {
		return claq0112;
	}

	public void setClaq0112(Double claq0112) {
		this.claq0112 = claq0112;
	}

	@Override
	protected Serializable pkVal() {
		return this.claq0101;
	}

	@Override
	public String toString() {
		return "Tbclassaskquestions01{" +
			"claq0101=" + claq0101 +
			", claq0102=" + claq0102 +
			", claq0103=" + claq0103 +
			", claq0104=" + claq0104 +
			", claq0105=" + claq0105 +
			", claq0106=" + claq0106 +
			", claq0107=" + claq0107 +
			", claq0108=" + claq0108 +
			", claq0109=" + claq0109 +
			", claq0110=" + claq0110 +
			", claq0111=" + claq0111 +
			", claq0112=" + claq0112 +
			"}";
	}

	public List<Tbclassaskquestions02> getInterviewee() {
		return interviewee;
	}

	public void setInterviewee(List<Tbclassaskquestions02> interviewee) {
		this.interviewee = interviewee;
	}

	public List<Tbclassaskquestions02> getTheLatestAnswer() {
		return theLatestAnswer;
	}

	public void setTheLatestAnswer(List<Tbclassaskquestions02> theLatestAnswer) {
		this.theLatestAnswer = theLatestAnswer;
	}

	public String getUser005() {
		return user005;
	}

	public void setUser005(String user005) {
		this.user005 = user005;
	}

	public String getUser006() {
		return user006;
	}

	public void setUser006(String user006) {
		this.user006 = user006;
	}

	public String getUser028() {
		return user028;
	}

	public void setUser028(String user028) {
		this.user028 = user028;
	}

	public String getCcwe003() {
		return ccwe003;
	}

	public void setCcwe003(String ccwe003) {
		this.ccwe003 = ccwe003;
	}

	public String getCour002() {
		return cour002;
	}

	public void setCour002(String cour002) {
		this.cour002 = cour002;
	}

	public Integer getAnswerNum() {
		return answerNum;
	}

	public void setAnswerNum(Integer answerNum) {
		this.answerNum = answerNum;
	}

	public String getClaq0113() {
		return claq0113;
	}

	public void setClaq0113(String claq0113) {
		this.claq0113 = claq0113;
	}
}

package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;

import java.io.Serializable;


public class LearnListEntity extends Model<LearnListEntity> {
	
	private static final long serialVersionUID = 6254524214651185342L;
	
	/**
	 * 学习活动ID
	 */
//	@Column(isPK=true)
	private String leac001;
	
	/**
	 * 学习活动名称
	 */
	private String leac004;
	
	/**
	 * 学习活动类型 0、选修 1、必修
	 */
	private String leac005;
	
	/**
	 * 课程封面
	 */
	private String leac009;
	
	/**
	 * 主办单位名称
	 */
	private String leac003text;
	
	/**
	 * 主讲人ID
	 */
	private String cour008;
	
	/**
	 * 主讲人名称
	 */
	private String teac002;
	
	/**
	 * 主讲人名称(文本)
	 */
	private String cour008text;
	
	/**
	 * 学时
	 */
	private float cour005hourse;
	
	/**
	 * 上次学习时间
	 */
	private String lcwr009;
	
	/**
	 * 总学时
	 */
	private float leac029;
	
	/**
	 * 学习进度
	 */
	private String lere005;
	
	/**
	 * 好评数
	 */
	private Integer praisenumber;
	
	/**
	 * 学习人数
	 */
	private Integer learningpeople;
	
	/**
	 * 学习结束时间
	 */
	private String lere007;
	
	

	public String getLeac001() {
		return leac001;
	}

	public void setLeac001(String leac001) {
		this.leac001 = leac001;
	}

	public String getLeac004() {
		return leac004;
	}

	public void setLeac004(String leac004) {
		this.leac004 = leac004;
	}

	public String getLeac005() {
		return leac005;
	}

	public void setLeac005(String leac005) {
		this.leac005 = leac005;
	}

	public String getLeac009() {
		return leac009;
	}

	public void setLeac009(String leac009) {
		this.leac009 = leac009;
	}

	public String getLeac003text() {
		return leac003text;
	}

	public void setLeac003text(String leac003text) {
		this.leac003text = leac003text;
	}

	public String getCour008text() {
		return cour008text;
	}

	public void setCour008text(String cour008text) {
		this.cour008text = cour008text;
	}

	public float getCour005hourse() {
		return cour005hourse;
	}

	public void setCour005hourse(float cour005hourse) {
		this.cour005hourse = cour005hourse;
	}

	public String getLcwr009() {
		return lcwr009;
	}

	public void setLcwr009(String lcwr009) {
		this.lcwr009 = lcwr009;
	}

	public float getLeac029() {
		return leac029;
	}

	public void setLeac029(float leac029) {
		this.leac029 = leac029;
	}

	public String getLere005() {
		return lere005;
	}

	public void setLere005(String lere005) {
		this.lere005 = lere005;
	}

	public Integer getPraisenumber() {
		return praisenumber;
	}

	public void setPraisenumber(Integer praisenumber) {
		this.praisenumber = praisenumber;
	}

	public Integer getLearningpeople() {
		return learningpeople;
	}

	public void setLearningpeople(Integer learningpeople) {
		this.learningpeople = learningpeople;
	}

	public String getCour008() {
		return cour008;
	}

	public void setCour008(String cour008) {
		this.cour008 = cour008;
	}

	public String getTeac002() {
		return teac002;
	}

	public void setTeac002(String teac002) {
		this.teac002 = teac002;
	}

	public String getLere007() {
		return lere007;
	}

	public void setLere007(String lere007) {
		this.lere007 = lere007;
	}

	@Override
	protected Serializable pkVal() {
		return this.leac001;
	}
	
}

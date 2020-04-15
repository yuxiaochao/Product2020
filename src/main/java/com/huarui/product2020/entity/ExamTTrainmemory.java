package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author panlei
 * @since 2018-05-22
 */
@TableName("EXAM_T_TRAINMEMORY")
public class ExamTTrainmemory extends Model<ExamTTrainmemory> {

    private static final long serialVersionUID = 1L;

    /**
     * PK
     */
    @TableId("EXTM001")
	private String extm001;
    /**
     * 训练成绩ID
     */
	@TableField("EXTM002")
	private String extm002;
    /**
     * 用户ID
     */
	@TableField("EXTM003")
	private String extm003;
    /**
     * 试题ID
     */
	@TableField("EXTM004")
	private String extm004;
    /**
     * 登陆日志ID
     */
	@TableField("EXTM005")
	private String extm005;
    /**
     * 是否答对 0、错 1、对
     */
	@TableField("EXTM006")
	private Double extm006;
    /**
     * 备用字段1
     */
	@TableField("EXTM007")
	private Double extm007;
    /**
     * 备用字段2
     */
	@TableField("EXTM008")
	private Double extm008;
    /**
     * 备用字段3
     */
	@TableField("EXTM009")
	private Double extm009;
    /**
     * 备用字段4
     */
	@TableField("EXTM010")
	private String extm010;
    /**
     * 备用字段5
     */
	@TableField("EXTM011")
	private String extm011;
    /**
     * 备用字段6
     */
	@TableField("EXTM012")
	private String extm012;
    /**
     * 备用字段7
     */
	@TableField("EXTM013")
	private String extm013;
    /**
     * 备用字段8
     */
	@TableField("EXTM014")
	private Date extm014;


	public String getExtm001() {
		return extm001;
	}

	public void setExtm001(String extm001) {
		this.extm001 = extm001;
	}

	public String getExtm002() {
		return extm002;
	}

	public void setExtm002(String extm002) {
		this.extm002 = extm002;
	}

	public String getExtm003() {
		return extm003;
	}

	public void setExtm003(String extm003) {
		this.extm003 = extm003;
	}

	public String getExtm004() {
		return extm004;
	}

	public void setExtm004(String extm004) {
		this.extm004 = extm004;
	}

	public String getExtm005() {
		return extm005;
	}

	public void setExtm005(String extm005) {
		this.extm005 = extm005;
	}

	public Double getExtm006() {
		return extm006;
	}

	public void setExtm006(Double extm006) {
		this.extm006 = extm006;
	}

	public Double getExtm007() {
		return extm007;
	}

	public void setExtm007(Double extm007) {
		this.extm007 = extm007;
	}

	public Double getExtm008() {
		return extm008;
	}

	public void setExtm008(Double extm008) {
		this.extm008 = extm008;
	}

	public Double getExtm009() {
		return extm009;
	}

	public void setExtm009(Double extm009) {
		this.extm009 = extm009;
	}

	public String getExtm010() {
		return extm010;
	}

	public void setExtm010(String extm010) {
		this.extm010 = extm010;
	}

	public String getExtm011() {
		return extm011;
	}

	public void setExtm011(String extm011) {
		this.extm011 = extm011;
	}

	public String getExtm012() {
		return extm012;
	}

	public void setExtm012(String extm012) {
		this.extm012 = extm012;
	}

	public String getExtm013() {
		return extm013;
	}

	public void setExtm013(String extm013) {
		this.extm013 = extm013;
	}

	public Date getExtm014() {
		return extm014;
	}

	public void setExtm014(Date extm014) {
		this.extm014 = extm014;
	}

	@Override
	protected Serializable pkVal() {
		return this.extm001;
	}

	@Override
	public String toString() {
		return "ExamTTrainmemory{" +
			"extm001=" + extm001 +
			", extm002=" + extm002 +
			", extm003=" + extm003 +
			", extm004=" + extm004 +
			", extm005=" + extm005 +
			", extm006=" + extm006 +
			", extm007=" + extm007 +
			", extm008=" + extm008 +
			", extm009=" + extm009 +
			", extm010=" + extm010 +
			", extm011=" + extm011 +
			", extm012=" + extm012 +
			", extm013=" + extm013 +
			", extm014=" + extm014 +
			"}";
	}
}

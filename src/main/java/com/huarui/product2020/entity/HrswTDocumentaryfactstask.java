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
 * @since 2018-10-17
 */
@TableName("HRSW_T_DOCUMENTARYFACTSTASK")
public class HrswTDocumentaryfactstask extends Model<HrswTDocumentaryfactstask> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId("DOFA001")
	private String dofa001;
    /**
     * 纪实任务标题
     */
	@TableField("DOFA002")
	private String dofa002;
    /**
     * 开始时间
     */
	@TableField("DOFA003")
	private Date dofa003;
    /**
     * 截止时间
     */
	@TableField("DOFA004")
	private Date dofa004;
    /**
     * 纪实目标说明
     */
	@TableField("DOFA005")
	private String dofa005;
    /**
     * 创建人ID
     */
	@TableField("DOFA006")
	private String dofa006;
    /**
     * 创建人时间
     */
	@TableField("DOFA007")
	private Date dofa007;
	 /**
     * 纪实类型（加 0 履职纪实 1.实绩纪实 2.问题纪实 3所有纪实）
     */
	@TableField("DOFA008")
	private Integer dofa008;
	public Integer getDofa008() {
		return dofa008;
	}

	public void setDofa008(Integer dofa008) {
		this.dofa008 = dofa008;
	}

	public Integer getDofa009() {
		return dofa009;
	}

	public void setDofa009(Integer dofa009) {
		this.dofa009 = dofa009;
	}

	public Date getDofa010() {
		return dofa010;
	}

	public void setDofa010(Date dofa010) {
		this.dofa010 = dofa010;
	}

	public Date getDofa011() {
		return dofa011;
	}

	public void setDofa011(Date dofa011) {
		this.dofa011 = dofa011;
	}

	public Integer getDofa012() {
		return dofa012;
	}

	public void setDofa012(Integer dofa012) {
		this.dofa012 = dofa012;
	}

	public Date getDofa013() {
		return dofa013;
	}

	public void setDofa013(Date dofa013) {
		this.dofa013 = dofa013;
	}

	public Date getDofa014() {
		return dofa014;
	}

	public void setDofa014(Date dofa014) {
		this.dofa014 = dofa014;
	}

	public String getDofa015() {
		return dofa015;
	}

	public void setDofa015(String dofa015) {
		this.dofa015 = dofa015;
	}

	public Date getDofa016() {
		return dofa016;
	}

	public void setDofa016(Date dofa016) {
		this.dofa016 = dofa016;
	}

	public Date getDofa017() {
		return dofa017;
	}

	public void setDofa017(Date dofa017) {
		this.dofa017 = dofa017;
	}

	/**
     * 是否启用初审 0否 1是
     */
	@TableField("DOFA009")
	private Integer dofa009;
	/**
     * 	初审开始时间 (截止时间第二天)
     */
	@TableField("DOFA010")
	private Date dofa010;
	/**
     *	初审结束时间 （截止初审开始时间加14天）
     */
	@TableField("DOFA011")
	private Date dofa011;
	/**
     * 是否启用复审 0否 1是
     */
	@TableField("DOFA012")
	private Integer dofa012;
	/**
     * 复审开始时间 (初审结束时间后一天)
     */
	@TableField("DOFA013")
	private Date dofa013;
	/**
     * 复审结束时间 （复审开始时间加14天）
     */
	@TableField("DOFA014")
	private Date dofa014;
	/**
     * 年度
     */
	@TableField("DOFA015")
	private String dofa015;
	/**
     * 上报开始时间（例如6月1日-6月3日）
     */
	@TableField("DOFA016")
	private Date dofa016;
	/**
     * 	上报结束时间（例如6月1日-6月3日）
     */
	@TableField("DOFA017")
	private Date dofa017;

	public String getDofa001() {
		return dofa001;
	}

	public void setDofa001(String dofa001) {
		this.dofa001 = dofa001;
	}

	public String getDofa002() {
		return dofa002;
	}

	public void setDofa002(String dofa002) {
		this.dofa002 = dofa002;
	}

	public Date getDofa003() {
		return dofa003;
	}

	public void setDofa003(Date dofa003) {
		this.dofa003 = dofa003;
	}

	public Date getDofa004() {
		return dofa004;
	}

	public void setDofa004(Date dofa004) {
		this.dofa004 = dofa004;
	}

	public String getDofa005() {
		return dofa005;
	}

	public void setDofa005(String dofa005) {
		this.dofa005 = dofa005;
	}

	public String getDofa006() {
		return dofa006;
	}

	public void setDofa006(String dofa006) {
		this.dofa006 = dofa006;
	}

	public Date getDofa007() {
		return dofa007;
	}

	public void setDofa007(Date dofa007) {
		this.dofa007 = dofa007;
	}

	@Override
	protected Serializable pkVal() {
		return this.dofa001;
	}

	@Override
	public String toString() {
		return "HrswTDocumentaryfactstask{" +
			"dofa001=" + dofa001 +
			", dofa002=" + dofa002 +
			", dofa003=" + dofa003 +
			", dofa004=" + dofa004 +
			", dofa005=" + dofa005 +
			", dofa006=" + dofa006 +
			", dofa007=" + dofa007 +
			"}";
	}
}

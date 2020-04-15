package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author panlei
 * @since 2018-05-26
 */
@TableName("HRSW_T_USERPREFERENCESETTING")
public class HrswTUserpreferencesetting extends Model<HrswTUserpreferencesetting> {

    private static final long serialVersionUID = 1L;

    @TableId("USPS001")
	private String usps001;
    /**
     * 用户ID
     */
	@TableField("USPS002")
	private String usps002;
    /**
     * 用户别名
     */
	@TableField("USPS003")
	private String usps003;
    /**
     * 个人简介背景图片（路径）
     */
	@TableField("USPS004")
	private String usps004;
    /**
     * 备用字段
     */
	@TableField("USPS005")
	private String usps005;
    /**
     * 备用字段
     */
	@TableField("USPS006")
	private String usps006;
    /**
     * 备用字段
     */
	@TableField("USPS007")
	private String usps007;
    /**
     * 备用字段
     */
	@TableField("USPS008")
	private String usps008;
    /**
     * 备用字段
     */
	@TableField("USPS009")
	private String usps009;
    /**
     * 备用字段
     */
	@TableField("USPS010")
	private String usps010;
    /**
     * 备用字段
     */
	@TableField("USPS011")
	private String usps011;
    /**
     * 备用字段
     */
	@TableField("USPS012")
	private String usps012;
    /**
     * 备用字段
     */
	@TableField("USPS013")
	private String usps013;
	@TableField("USPS014")
	private String usps014;


	public String getUsps001() {
		return usps001;
	}

	public void setUsps001(String usps001) {
		this.usps001 = usps001;
	}

	public String getUsps002() {
		return usps002;
	}

	public void setUsps002(String usps002) {
		this.usps002 = usps002;
	}

	public String getUsps003() {
		return usps003;
	}

	public void setUsps003(String usps003) {
		this.usps003 = usps003;
	}

	public String getUsps004() {
		return usps004;
	}

	public void setUsps004(String usps004) {
		this.usps004 = usps004;
	}

	public String getUsps005() {
		return usps005;
	}

	public void setUsps005(String usps005) {
		this.usps005 = usps005;
	}

	public String getUsps006() {
		return usps006;
	}

	public void setUsps006(String usps006) {
		this.usps006 = usps006;
	}

	public String getUsps007() {
		return usps007;
	}

	public void setUsps007(String usps007) {
		this.usps007 = usps007;
	}

	public String getUsps008() {
		return usps008;
	}

	public void setUsps008(String usps008) {
		this.usps008 = usps008;
	}

	public String getUsps009() {
		return usps009;
	}

	public void setUsps009(String usps009) {
		this.usps009 = usps009;
	}

	public String getUsps010() {
		return usps010;
	}

	public void setUsps010(String usps010) {
		this.usps010 = usps010;
	}

	public String getUsps011() {
		return usps011;
	}

	public void setUsps011(String usps011) {
		this.usps011 = usps011;
	}

	public String getUsps012() {
		return usps012;
	}

	public void setUsps012(String usps012) {
		this.usps012 = usps012;
	}

	public String getUsps013() {
		return usps013;
	}

	public void setUsps013(String usps013) {
		this.usps013 = usps013;
	}

	public String getUsps014() {
		return usps014;
	}

	public void setUsps014(String usps014) {
		this.usps014 = usps014;
	}

	@Override
	protected Serializable pkVal() {
		return this.usps001;
	}

	@Override
	public String toString() {
		return "HrswTUserpreferencesetting{" +
			"usps001=" + usps001 +
			", usps002=" + usps002 +
			", usps003=" + usps003 +
			", usps004=" + usps004 +
			", usps005=" + usps005 +
			", usps006=" + usps006 +
			", usps007=" + usps007 +
			", usps008=" + usps008 +
			", usps009=" + usps009 +
			", usps010=" + usps010 +
			", usps011=" + usps011 +
			", usps012=" + usps012 +
			", usps013=" + usps013 +
			", usps014=" + usps014 +
			"}";
	}
}

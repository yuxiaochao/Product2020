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
 * @author Administrator
 * @since 2019-08-06
 */
@TableName("HR_T_PERSONNELATTRIBUTES")
public class HrTPersonnelattributes extends Model<HrTPersonnelattributes> {

    private static final long serialVersionUID = 1L;

    @TableId("REAT001")
	private String reat001;
    /**
     * 人员分类id
     */
	@TableField("REAT002")
	private String reat002;
    /**
     * 说明
     */
	@TableField("REAT003")
	private String reat003;
    /**
     * 是否启用  基本信息 0否 1是
     */
	@TableField("REAT004")
	private Double reat004;
    /**
     * 是否启用  教育背景 0否 1是
     */
	@TableField("REAT005")
	private Double reat005;
    /**
     * 是否启用  报考信息 0否 1是
     */
	@TableField("REAT006")
	private Double reat006;
    /**
     * 是否启用  工作信息 0否 1是
     */
	@TableField("REAT007")
	private Double reat007;
    /**
     * 是否启用  认定信息 0否 1是
     */
	@TableField("REAT008")
	private Double reat008;
    /**
     * 是否启用  培训履历 0否 1是
     */
	@TableField("REAT009")
	private Double reat009;
    /**
     * 是否启用  命题方向 0否 1是
     */
	@TableField("REAT010")
	private Double reat010;
    /**
     * 是否启用  获奖情况 0否 1是
     */
	@TableField("REAT011")
	private Double reat011;
    /**
     * 是否启用  电子扫描件 
     */
	@TableField("REAT012")
	private Double reat012;
    /**
     * 备用
     */
	@TableField("REAT013")
	private Double reat013;
    /**
     * 备用
     */
	@TableField("REAT014")
	private Double reat014;
    /**
     * 备用
     */
	@TableField("REAT015")
	private Double reat015;
    /**
     * 备用
     */
	@TableField("REAT016")
	private Double reat016;
    /**
     * 创建时间
     */
	@TableField("REAT017")
	private Date reat017;
    /**
     * 最后修改时间
     */
	@TableField("REAT018")
	private Date reat018;
    /**
     * 创建人id
     */
	@TableField("REAT019")
	private String reat019;


	public String getReat001() {
		return reat001;
	}

	public void setReat001(String reat001) {
		this.reat001 = reat001;
	}

	public String getReat002() {
		return reat002;
	}

	public void setReat002(String reat002) {
		this.reat002 = reat002;
	}

	public String getReat003() {
		return reat003;
	}

	public void setReat003(String reat003) {
		this.reat003 = reat003;
	}

	public Double getReat004() {
		return reat004;
	}

	public void setReat004(Double reat004) {
		this.reat004 = reat004;
	}

	public Double getReat005() {
		return reat005;
	}

	public void setReat005(Double reat005) {
		this.reat005 = reat005;
	}

	public Double getReat006() {
		return reat006;
	}

	public void setReat006(Double reat006) {
		this.reat006 = reat006;
	}

	public Double getReat007() {
		return reat007;
	}

	public void setReat007(Double reat007) {
		this.reat007 = reat007;
	}

	public Double getReat008() {
		return reat008;
	}

	public void setReat008(Double reat008) {
		this.reat008 = reat008;
	}

	public Double getReat009() {
		return reat009;
	}

	public void setReat009(Double reat009) {
		this.reat009 = reat009;
	}

	public Double getReat010() {
		return reat010;
	}

	public void setReat010(Double reat010) {
		this.reat010 = reat010;
	}

	public Double getReat011() {
		return reat011;
	}

	public void setReat011(Double reat011) {
		this.reat011 = reat011;
	}

	public Double getReat012() {
		return reat012;
	}

	public void setReat012(Double reat012) {
		this.reat012 = reat012;
	}

	public Double getReat013() {
		return reat013;
	}

	public void setReat013(Double reat013) {
		this.reat013 = reat013;
	}

	public Double getReat014() {
		return reat014;
	}

	public void setReat014(Double reat014) {
		this.reat014 = reat014;
	}

	public Double getReat015() {
		return reat015;
	}

	public void setReat015(Double reat015) {
		this.reat015 = reat015;
	}

	public Double getReat016() {
		return reat016;
	}

	public void setReat016(Double reat016) {
		this.reat016 = reat016;
	}

	public Date getReat017() {
		return reat017;
	}

	public void setReat017(Date reat017) {
		this.reat017 = reat017;
	}

	public Date getReat018() {
		return reat018;
	}

	public void setReat018(Date reat018) {
		this.reat018 = reat018;
	}

	public String getReat019() {
		return reat019;
	}

	public void setReat019(String reat019) {
		this.reat019 = reat019;
	}

	@Override
	protected Serializable pkVal() {
		return this.reat001;
	}

	@Override
	public String toString() {
		return "HrTPersonnelattributes{" +
			"reat001=" + reat001 +
			", reat002=" + reat002 +
			", reat003=" + reat003 +
			", reat004=" + reat004 +
			", reat005=" + reat005 +
			", reat006=" + reat006 +
			", reat007=" + reat007 +
			", reat008=" + reat008 +
			", reat009=" + reat009 +
			", reat010=" + reat010 +
			", reat011=" + reat011 +
			", reat012=" + reat012 +
			", reat013=" + reat013 +
			", reat014=" + reat014 +
			", reat015=" + reat015 +
			", reat016=" + reat016 +
			", reat017=" + reat017 +
			", reat018=" + reat018 +
			", reat019=" + reat019 +
			"}";
	}
}

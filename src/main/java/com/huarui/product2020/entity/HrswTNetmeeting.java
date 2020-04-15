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
 * @since 2018-03-12
 */
@TableName("HRSW_T_NETMEETING")
public class HrswTNetmeeting extends Model<HrswTNetmeeting> {

    private static final long serialVersionUID = 1L;

    @TableId("NETM001")
	private String netm001;
	@TableField("NETM002")
	private String netm002;
	@TableField("NETM003")
	private Date netm003;
	@TableField("NETM004")
	private Date netm004;
	@TableField("NETM005")
	private Double netm005;
	@TableField("NETM006")
	private String netm006;
	@TableField("NETM007")
	private String netm007;
	@TableField("NETM008")
	private String netm008;
	@TableField("NETM009")
	private String netm009;
	@TableField("NETM010")
	private String netm010;
	@TableField("NETM011")
	private String netm011;
	@TableField("NETM012")
	private Date netm012;
	@TableField("NETM013")
	private Date netm013;
	@TableField("NETM014")
	private String netm014;
	@TableField("NETM015")
	private String netm015;
	@TableField("NETM016")
	private String netm016;
    /**
     * 选择学员模式：1、机构 2、学员 3、群组 4、岗位序列
     */
	@TableField("NETM017")
	private Double netm017;
	@TableField("NETM018")
	private String netm018;


	public String getNetm001() {
		return netm001;
	}

	public void setNetm001(String netm001) {
		this.netm001 = netm001;
	}

	public String getNetm002() {
		return netm002;
	}

	public void setNetm002(String netm002) {
		this.netm002 = netm002;
	}

	public Date getNetm003() {
		return netm003;
	}

	public void setNetm003(Date netm003) {
		this.netm003 = netm003;
	}

	public Date getNetm004() {
		return netm004;
	}

	public void setNetm004(Date netm004) {
		this.netm004 = netm004;
	}

	public Double getNetm005() {
		return netm005;
	}

	public void setNetm005(Double netm005) {
		this.netm005 = netm005;
	}

	public String getNetm006() {
		return netm006;
	}

	public void setNetm006(String netm006) {
		this.netm006 = netm006;
	}

	public String getNetm007() {
		return netm007;
	}

	public void setNetm007(String netm007) {
		this.netm007 = netm007;
	}

	public String getNetm008() {
		return netm008;
	}

	public void setNetm008(String netm008) {
		this.netm008 = netm008;
	}

	public String getNetm009() {
		return netm009;
	}

	public void setNetm009(String netm009) {
		this.netm009 = netm009;
	}

	public String getNetm010() {
		return netm010;
	}

	public void setNetm010(String netm010) {
		this.netm010 = netm010;
	}

	public String getNetm011() {
		return netm011;
	}

	public void setNetm011(String netm011) {
		this.netm011 = netm011;
	}

	public Date getNetm012() {
		return netm012;
	}

	public void setNetm012(Date netm012) {
		this.netm012 = netm012;
	}

	public Date getNetm013() {
		return netm013;
	}

	public void setNetm013(Date netm013) {
		this.netm013 = netm013;
	}

	public String getNetm014() {
		return netm014;
	}

	public void setNetm014(String netm014) {
		this.netm014 = netm014;
	}

	public String getNetm015() {
		return netm015;
	}

	public void setNetm015(String netm015) {
		this.netm015 = netm015;
	}

	public String getNetm016() {
		return netm016;
	}

	public void setNetm016(String netm016) {
		this.netm016 = netm016;
	}

	public Double getNetm017() {
		return netm017;
	}

	public void setNetm017(Double netm017) {
		this.netm017 = netm017;
	}

	public String getNetm018() {
		return netm018;
	}

	public void setNetm018(String netm018) {
		this.netm018 = netm018;
	}

	@Override
	protected Serializable pkVal() {
		return this.netm001;
	}

	@Override
	public String toString() {
		return "HrswTNetmeeting{" +
			"netm001=" + netm001 +
			", netm002=" + netm002 +
			", netm003=" + netm003 +
			", netm004=" + netm004 +
			", netm005=" + netm005 +
			", netm006=" + netm006 +
			", netm007=" + netm007 +
			", netm008=" + netm008 +
			", netm009=" + netm009 +
			", netm010=" + netm010 +
			", netm011=" + netm011 +
			", netm012=" + netm012 +
			", netm013=" + netm013 +
			", netm014=" + netm014 +
			", netm015=" + netm015 +
			", netm016=" + netm016 +
			", netm017=" + netm017 +
			", netm018=" + netm018 +
			"}";
	}
}

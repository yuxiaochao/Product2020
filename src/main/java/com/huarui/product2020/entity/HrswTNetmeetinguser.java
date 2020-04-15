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
 * @since 2018-03-13
 */
@TableName("HRSW_T_NETMEETINGUSER")
public class HrswTNetmeetinguser extends Model<HrswTNetmeetinguser> {

    private static final long serialVersionUID = 1L;

    @TableId("NETU001")
	private String netu001;
	@TableField("NETU002")
	private String netu002;
	@TableField("NETU003")
	private String netu003;
	@TableField("NETU004")
	private String netu004;
	@TableField("NETU005")
	private String netu005;
	@TableField("NETU006")
	private String netu006;
	@TableField("NETU007")
	private Double netu007;
	@TableField("NETU008")
	private Double netu008;


	public String getNetu001() {
		return netu001;
	}

	public void setNetu001(String netu001) {
		this.netu001 = netu001;
	}

	public String getNetu002() {
		return netu002;
	}

	public void setNetu002(String netu002) {
		this.netu002 = netu002;
	}

	public String getNetu003() {
		return netu003;
	}

	public void setNetu003(String netu003) {
		this.netu003 = netu003;
	}

	public String getNetu004() {
		return netu004;
	}

	public void setNetu004(String netu004) {
		this.netu004 = netu004;
	}

	public String getNetu005() {
		return netu005;
	}

	public void setNetu005(String netu005) {
		this.netu005 = netu005;
	}

	public String getNetu006() {
		return netu006;
	}

	public void setNetu006(String netu006) {
		this.netu006 = netu006;
	}

	public Double getNetu007() {
		return netu007;
	}

	public void setNetu007(Double netu007) {
		this.netu007 = netu007;
	}

	public Double getNetu008() {
		return netu008;
	}

	public void setNetu008(Double netu008) {
		this.netu008 = netu008;
	}

	@Override
	protected Serializable pkVal() {
		return this.netu001;
	}

	@Override
	public String toString() {
		return "HrswTNetmeetinguser{" +
			"netu001=" + netu001 +
			", netu002=" + netu002 +
			", netu003=" + netu003 +
			", netu004=" + netu004 +
			", netu005=" + netu005 +
			", netu006=" + netu006 +
			", netu007=" + netu007 +
			", netu008=" + netu008 +
			"}";
	}
}

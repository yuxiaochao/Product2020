package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * ${table.comment}
 * </p>
 *
 * @author Chenrui
 * @since 2017-08-13
 */
@TableName("HRSW_T_CWTACTIC")
public class HrswTCwtactic extends Model<HrswTCwtactic> {

    private static final long serialVersionUID = 1L;

    @TableId("CWTA001")
	private String cwta001;
	@TableField("CWTA002")
	private String cwta002;
	@TableField("CWTA003")
	private String cwta003;
	@TableField("CWTA004")
	private String cwta004;
	@TableField("CWTA005")
	private Double cwta005;
	@TableField("CWTA006")
	private Double cwta006;
	@TableField("CWTA007")
	private String cwta007;
	@TableField("CWTA008")
	private Double cwta008;
	@TableField("CWTA009")
	private Double cwta009;
	@TableField("CWTA010")
	private String cwta010;
	@TableField("CWTA011")
	private String cwta011;
	@TableField("CWTA012")
	private String cwta012;


	public String getCwta001() {
		return cwta001;
	}

	public void setCwta001(String cwta001) {
		this.cwta001 = cwta001;
	}

	public String getCwta002() {
		return cwta002;
	}

	public void setCwta002(String cwta002) {
		this.cwta002 = cwta002;
	}

	public String getCwta003() {
		return cwta003;
	}

	public void setCwta003(String cwta003) {
		this.cwta003 = cwta003;
	}

	public String getCwta004() {
		return cwta004;
	}

	public void setCwta004(String cwta004) {
		this.cwta004 = cwta004;
	}

	public Double getCwta005() {
		return cwta005;
	}

	public void setCwta005(Double cwta005) {
		this.cwta005 = cwta005;
	}

	public Double getCwta006() {
		return cwta006;
	}

	public void setCwta006(Double cwta006) {
		this.cwta006 = cwta006;
	}

	public String getCwta007() {
		return cwta007;
	}

	public void setCwta007(String cwta007) {
		this.cwta007 = cwta007;
	}

	public Double getCwta008() {
		return cwta008;
	}

	public void setCwta008(Double cwta008) {
		this.cwta008 = cwta008;
	}

	public Double getCwta009() {
		return cwta009;
	}

	public void setCwta009(Double cwta009) {
		this.cwta009 = cwta009;
	}

	public String getCwta010() {
		return cwta010;
	}

	public void setCwta010(String cwta010) {
		this.cwta010 = cwta010;
	}

	public String getCwta011() {
		return cwta011;
	}

	public void setCwta011(String cwta011) {
		this.cwta011 = cwta011;
	}

	public String getCwta012() {
		return cwta012;
	}

	public void setCwta012(String cwta012) {
		this.cwta012 = cwta012;
	}

	@Override
	protected Serializable pkVal() {
		return this.cwta001;
	}

}

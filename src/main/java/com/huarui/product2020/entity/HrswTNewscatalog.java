package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * ${table.comment}
 * </p>
 *
 * @author Chenrui
 * @since 2017-08-13
 */
@TableName("HRSW_T_NEWSCATALOG")
public class HrswTNewscatalog extends Model<HrswTNewscatalog> {

    private static final long serialVersionUID = 1L;

    @TableId("NCAT001")
	private String ncat001;
	@TableField("NCAT002")
	private String ncat002;
	@TableField("NCAT003")
	private Double ncat003;
	@TableField("NCAT004")
	private String ncat004;
	@TableField("NCAT005")
	private Double ncat005;
	@TableField("NCAT006")
	private Double ncat006;
	@TableField("NCAT007")
	private String ncat007;
	@TableField("NCAT008")
	private String ncat008;
	@TableField("NCAT009")
	private String ncat009;
	@TableField("NCAT010")
	private String ncat010;
	@TableField("NCAT011")
	private Double ncat011;
	@TableField("NCAT012")
	private String ncat012;
	@TableField("NCAT013")
	private Date ncat013;
	@TableField("NCAT014")
	private String ncat014;
	@TableField("NCAT015")
	private String ncat015;


	public String getNcat001() {
		return ncat001;
	}

	public void setNcat001(String ncat001) {
		this.ncat001 = ncat001;
	}

	public String getNcat002() {
		return ncat002;
	}

	public void setNcat002(String ncat002) {
		this.ncat002 = ncat002;
	}

	public Double getNcat003() {
		return ncat003;
	}

	public void setNcat003(Double ncat003) {
		this.ncat003 = ncat003;
	}

	public String getNcat004() {
		return ncat004;
	}

	public void setNcat004(String ncat004) {
		this.ncat004 = ncat004;
	}

	public Double getNcat005() {
		return ncat005;
	}

	public void setNcat005(Double ncat005) {
		this.ncat005 = ncat005;
	}

	public Double getNcat006() {
		return ncat006;
	}

	public void setNcat006(Double ncat006) {
		this.ncat006 = ncat006;
	}

	public String getNcat007() {
		return ncat007;
	}

	public void setNcat007(String ncat007) {
		this.ncat007 = ncat007;
	}

	public String getNcat008() {
		return ncat008;
	}

	public void setNcat008(String ncat008) {
		this.ncat008 = ncat008;
	}

	public String getNcat009() {
		return ncat009;
	}

	public void setNcat009(String ncat009) {
		this.ncat009 = ncat009;
	}

	public String getNcat010() {
		return ncat010;
	}

	public void setNcat010(String ncat010) {
		this.ncat010 = ncat010;
	}

	public Double getNcat011() {
		return ncat011;
	}

	public void setNcat011(Double ncat011) {
		this.ncat011 = ncat011;
	}

	public String getNcat012() {
		return ncat012;
	}

	public void setNcat012(String ncat012) {
		this.ncat012 = ncat012;
	}

	public Date getNcat013() {
		return ncat013;
	}

	public void setNcat013(Date ncat013) {
		this.ncat013 = ncat013;
	}

	public String getNcat014() {
		return ncat014;
	}

	public void setNcat014(String ncat014) {
		this.ncat014 = ncat014;
	}

	public String getNcat015() {
		return ncat015;
	}

	public void setNcat015(String ncat015) {
		this.ncat015 = ncat015;
	}

	@Override
	protected Serializable pkVal() {
		return this.ncat001;
	}

}

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
@TableName("APPLY_T_SIGNUP")
public class ApplyTSignup extends Model<ApplyTSignup> {

    private static final long serialVersionUID = 1L;

    @TableId("SIGN001")
	private String sign001;
	@TableField("SIGN002")
	private String sign002;
	@TableField("SIGN003")
	private String sign003;
	@TableField("SIGN004")
	private String sign004;
	@TableField("SIGN005")
	private String sign005;
	@TableField("SIGN006")
	private String sign006;
	@TableField("SIGN007")
	private Date sign007;
	@TableField("SIGN008")
	private String sign008;
	@TableField("SIGN009")
	private Double sign009;
	@TableField("SIGN010")
	private String sign010;
	@TableField("SIGN011")
	private Date sign011;


	public String getSign001() {
		return sign001;
	}

	public void setSign001(String sign001) {
		this.sign001 = sign001;
	}

	public String getSign002() {
		return sign002;
	}

	public void setSign002(String sign002) {
		this.sign002 = sign002;
	}

	public String getSign003() {
		return sign003;
	}

	public void setSign003(String sign003) {
		this.sign003 = sign003;
	}

	public String getSign004() {
		return sign004;
	}

	public void setSign004(String sign004) {
		this.sign004 = sign004;
	}

	public String getSign005() {
		return sign005;
	}

	public void setSign005(String sign005) {
		this.sign005 = sign005;
	}

	public String getSign006() {
		return sign006;
	}

	public void setSign006(String sign006) {
		this.sign006 = sign006;
	}

	public Date getSign007() {
		return sign007;
	}

	public void setSign007(Date sign007) {
		this.sign007 = sign007;
	}

	public String getSign008() {
		return sign008;
	}

	public void setSign008(String sign008) {
		this.sign008 = sign008;
	}

	public Double getSign009() {
		return sign009;
	}

	public void setSign009(Double sign009) {
		this.sign009 = sign009;
	}

	public String getSign010() {
		return sign010;
	}

	public void setSign010(String sign010) {
		this.sign010 = sign010;
	}

	public Date getSign011() {
		return sign011;
	}

	public void setSign011(Date sign011) {
		this.sign011 = sign011;
	}

	@Override
	protected Serializable pkVal() {
		return this.sign001;
	}

}

package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

import java.io.Serializable;

/**
 * <p>
 * 问卷试题填空要求表
 * </p>
 *
 * @author pl
 * @since 2019-12-21
 */
public class Dcwj06 extends Model<Dcwj06> {

    private static final long serialVersionUID = 1L;

    /**
     * 	pk
     */
    @TableId("DCWJ0601")
	private String dcwj0601;
    /**
     * 	试题ID (DCWJ04)
     */
	@TableField("DCWJ0602")
	private String dcwj0602;
    /**
     * 填空顺序 1：代第一个空；2：第二个……
     */
	@TableField("DCWJ0603")
	private Double dcwj0603;
    /**
     * 	高度
     */
	@TableField("DCWJ0604")
	private Double dcwj0604;
    /**
     * 	宽度
     */
	@TableField("DCWJ0605")
	private Double dcwj0605;
    /**
     * 	验证机制 0：无验证；1：手机……
     */
	@TableField("DCWJ0606")
	private Double dcwj0606;
    /**
     * 最小字数 0：无限制
     */
	@TableField("DCWJ0607")
	private Double dcwj0607;
    /**
     * 	最大字数 0：无限制
     */
	@TableField("DCWJ0608")
	private Double dcwj0608;
	/**
     * 		下划线样式 0：否 1： 是
     */
	@TableField("DCWJ0609")
	private Double dcwj0609;


	public String getDcwj0601() {
		return dcwj0601;
	}

	public void setDcwj0601(String dcwj0601) {
		this.dcwj0601 = dcwj0601;
	}

	public String getDcwj0602() {
		return dcwj0602;
	}

	public void setDcwj0602(String dcwj0602) {
		this.dcwj0602 = dcwj0602;
	}

	public Double getDcwj0603() {
		return dcwj0603;
	}

	public void setDcwj0603(Double dcwj0603) {
		this.dcwj0603 = dcwj0603;
	}

	public Double getDcwj0604() {
		return dcwj0604;
	}

	public void setDcwj0604(Double dcwj0604) {
		this.dcwj0604 = dcwj0604;
	}

	public Double getDcwj0605() {
		return dcwj0605;
	}

	public void setDcwj0605(Double dcwj0605) {
		this.dcwj0605 = dcwj0605;
	}

	public Double getDcwj0606() {
		return dcwj0606;
	}

	public void setDcwj0606(Double dcwj0606) {
		this.dcwj0606 = dcwj0606;
	}

	public Double getDcwj0607() {
		return dcwj0607;
	}

	public void setDcwj0607(Double dcwj0607) {
		this.dcwj0607 = dcwj0607;
	}

	public Double getDcwj0608() {
		return dcwj0608;
	}

	public void setDcwj0608(Double dcwj0608) {
		this.dcwj0608 = dcwj0608;
	}

	@Override
	protected Serializable pkVal() {
		return this.dcwj0601;
	}
	
	

	public Double getDcwj0609() {
		return dcwj0609;
	}

	public void setDcwj0609(Double dcwj0609) {
		this.dcwj0609 = dcwj0609;
	}

	@Override
	public String toString() {
		return "Dcwj06{" +
			"dcwj0601=" + dcwj0601 +
			", dcwj0602=" + dcwj0602 +
			", dcwj0603=" + dcwj0603 +
			", dcwj0604=" + dcwj0604 +
			", dcwj0605=" + dcwj0605 +
			", dcwj0606=" + dcwj0606 +
			", dcwj0607=" + dcwj0607 +
			", dcwj0608=" + dcwj0608 +
			"}";
	}
}

package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author panlei
 * @since 2020-04-07
 */
public class Tbyhqgl07 extends Model<Tbyhqgl07> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("YHQGL0701")
	private String yhqgl0701;
    /**
     * 优惠券下发与优惠券关联表ID
     */
	@TableField("YHQGL0702")
	private String yhqgl0702;
    /**
     * 优惠券卡号ID
     */
	@TableField("YHQGL0703")
	private String yhqgl0703;
    /**
     * 状态：0:未激活 1:已激活
     */
	@TableField("YHQGL0704")
	private Double yhqgl0704;
    /**
     * 绑定人ID
     */
	@TableField("YHQGL0705")
	private String yhqgl0705;
    /**
     * 绑定时间
     */
	@TableField("YHQGL0706")
	private Date yhqgl0706;
    /**
     * 绑定商品（套包ID）
     */
	@TableField("YHQGL0707")
	private String yhqgl0707;
    /**
     * 绑定商品（套包与商品关联表ID）
     */
	@TableField("YHQGL0708")
	private String yhqgl0708;
    /**
     * 操作来源   0：官网  1：天猫
     */
	@TableField("YHQGL0709")
	private Double yhqgl0709;
    /**
     * 状态2  0：未使用  1：已使用
     */
	@TableField("YHQGL0710")
	private Double yhqgl0710;


	public String getYhqgl0701() {
		return yhqgl0701;
	}

	public void setYhqgl0701(String yhqgl0701) {
		this.yhqgl0701 = yhqgl0701;
	}

	public String getYhqgl0702() {
		return yhqgl0702;
	}

	public void setYhqgl0702(String yhqgl0702) {
		this.yhqgl0702 = yhqgl0702;
	}

	public String getYhqgl0703() {
		return yhqgl0703;
	}

	public void setYhqgl0703(String yhqgl0703) {
		this.yhqgl0703 = yhqgl0703;
	}

	public Double getYhqgl0704() {
		return yhqgl0704;
	}

	public void setYhqgl0704(Double yhqgl0704) {
		this.yhqgl0704 = yhqgl0704;
	}

	public String getYhqgl0705() {
		return yhqgl0705;
	}

	public void setYhqgl0705(String yhqgl0705) {
		this.yhqgl0705 = yhqgl0705;
	}

	public Date getYhqgl0706() {
		return yhqgl0706;
	}

	public void setYhqgl0706(Date yhqgl0706) {
		this.yhqgl0706 = yhqgl0706;
	}

	public String getYhqgl0707() {
		return yhqgl0707;
	}

	public void setYhqgl0707(String yhqgl0707) {
		this.yhqgl0707 = yhqgl0707;
	}

	public String getYhqgl0708() {
		return yhqgl0708;
	}

	public void setYhqgl0708(String yhqgl0708) {
		this.yhqgl0708 = yhqgl0708;
	}

	public Double getYhqgl0709() {
		return yhqgl0709;
	}

	public void setYhqgl0709(Double yhqgl0709) {
		this.yhqgl0709 = yhqgl0709;
	}

	public Double getYhqgl0710() {
		return yhqgl0710;
	}

	public void setYhqgl0710(Double yhqgl0710) {
		this.yhqgl0710 = yhqgl0710;
	}

	@Override
	protected Serializable pkVal() {
		return this.yhqgl0701;
	}

	@Override
	public String toString() {
		return "Tbyhqgl07{" +
			"yhqgl0701=" + yhqgl0701 +
			", yhqgl0702=" + yhqgl0702 +
			", yhqgl0703=" + yhqgl0703 +
			", yhqgl0704=" + yhqgl0704 +
			", yhqgl0705=" + yhqgl0705 +
			", yhqgl0706=" + yhqgl0706 +
			", yhqgl0707=" + yhqgl0707 +
			", yhqgl0708=" + yhqgl0708 +
			", yhqgl0709=" + yhqgl0709 +
			", yhqgl0710=" + yhqgl0710 +
			"}";
	}
}

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
 * @author su
 * @since 2020-03-27
 */
public class Tbxxkgl07 extends Model<Tbxxkgl07> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("XXKGL0701")
	private String xxkgl0701;
    /**
     * 学习卡下发与学习卡关联表ID
     */
	@TableField("XXKGL0702")
	private String xxkgl0702;
    /**
     * 学习卡卡号ID
     */
	@TableField("XXKGL0703")
	private String xxkgl0703;
    /**
     * 状态：0:未激活 1:已激活
     */
	@TableField("XXKGL0704")
	private Integer xxkgl0704;
    /**
     * 绑定人ID
     */
	@TableField("XXKGL0705")
	private String xxkgl0705;
    /**
     * 绑定时间
     */
	@TableField("XXKGL0706")
	private Date xxkgl0706;
    /**
     * 绑定商品（套包ID）
     */
	@TableField("XXKGL0707")
	private String xxkgl0707;
    /**
     * 绑定商品（套包与商品关联表ID）
     */
	@TableField("XXKGL0708")
	private String xxkgl0708;


	public String getXxkgl0701() {
		return xxkgl0701;
	}

	public void setXxkgl0701(String xxkgl0701) {
		this.xxkgl0701 = xxkgl0701;
	}

	public String getXxkgl0702() {
		return xxkgl0702;
	}

	public void setXxkgl0702(String xxkgl0702) {
		this.xxkgl0702 = xxkgl0702;
	}

	public String getXxkgl0703() {
		return xxkgl0703;
	}

	public void setXxkgl0703(String xxkgl0703) {
		this.xxkgl0703 = xxkgl0703;
	}

	public Integer getXxkgl0704() {
		return xxkgl0704;
	}

	public void setXxkgl0704(Integer xxkgl0704) {
		this.xxkgl0704 = xxkgl0704;
	}

	public String getXxkgl0705() {
		return xxkgl0705;
	}

	public void setXxkgl0705(String xxkgl0705) {
		this.xxkgl0705 = xxkgl0705;
	}

	public Date getXxkgl0706() {
		return xxkgl0706;
	}

	public void setXxkgl0706(Date xxkgl0706) {
		this.xxkgl0706 = xxkgl0706;
	}

	public String getXxkgl0707() {
		return xxkgl0707;
	}

	public void setXxkgl0707(String xxkgl0707) {
		this.xxkgl0707 = xxkgl0707;
	}

	public String getXxkgl0708() {
		return xxkgl0708;
	}

	public void setXxkgl0708(String xxkgl0708) {
		this.xxkgl0708 = xxkgl0708;
	}

	@Override
	protected Serializable pkVal() {
		return this.xxkgl0701;
	}

	@Override
	public String toString() {
		return "Tbxxkgl07{" +
			"xxkgl0701=" + xxkgl0701 +
			", xxkgl0702=" + xxkgl0702 +
			", xxkgl0703=" + xxkgl0703 +
			", xxkgl0704=" + xxkgl0704 +
			", xxkgl0705=" + xxkgl0705 +
			", xxkgl0706=" + xxkgl0706 +
			", xxkgl0707=" + xxkgl0707 +
			", xxkgl0708=" + xxkgl0708 +
			"}";
	}
}

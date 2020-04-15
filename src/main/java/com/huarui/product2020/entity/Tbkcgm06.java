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
 * @since 2020-04-15
 */
public class Tbkcgm06 extends Model<Tbkcgm06> {

    private static final long serialVersionUID = 1L;

    @TableId("KCGM0601")
	private String kcgm0601;
    /**
     * 购物车ID tbGWC01
     */
	@TableField("KCGM0602")
	private String kcgm0602;
    /**
     * 代理机构ID hrsw_t_organ
     */
	@TableField("KCGM0603")
	private String kcgm0603;
    /**
     * 套包组合ID tbCMDY06
     */
	@TableField("KCGM0604")
	private String kcgm0604;
    /**
     * 套包与商品关联ID tbCMDY07
     */
	@TableField("KCGM0605")
	private String kcgm0605;
    /**
     * 卡号
     */
	@TableField("KCGM0606")
	private String kcgm0606;
    /**
     * 密码
     */
	@TableField("KCGM0607")
	private String kcgm0607;
    /**
     * 生成时间
     */
	@TableField("KCGM0608")
	private Date kcgm0608;
    /**
     * 是否已用 0:未使用 1:已使用
     */
	@TableField("KCGM0609")
	private Long kcgm0609;
    /**
     * 使用时间
     */
	@TableField("KCGM0610")
	private Date kcgm0610;


	public String getKcgm0601() {
		return kcgm0601;
	}

	public void setKcgm0601(String kcgm0601) {
		this.kcgm0601 = kcgm0601;
	}

	public String getKcgm0602() {
		return kcgm0602;
	}

	public void setKcgm0602(String kcgm0602) {
		this.kcgm0602 = kcgm0602;
	}

	public String getKcgm0603() {
		return kcgm0603;
	}

	public void setKcgm0603(String kcgm0603) {
		this.kcgm0603 = kcgm0603;
	}

	public String getKcgm0604() {
		return kcgm0604;
	}

	public void setKcgm0604(String kcgm0604) {
		this.kcgm0604 = kcgm0604;
	}

	public String getKcgm0605() {
		return kcgm0605;
	}

	public void setKcgm0605(String kcgm0605) {
		this.kcgm0605 = kcgm0605;
	}

	public String getKcgm0606() {
		return kcgm0606;
	}

	public void setKcgm0606(String kcgm0606) {
		this.kcgm0606 = kcgm0606;
	}

	public String getKcgm0607() {
		return kcgm0607;
	}

	public void setKcgm0607(String kcgm0607) {
		this.kcgm0607 = kcgm0607;
	}

	public Date getKcgm0608() {
		return kcgm0608;
	}

	public void setKcgm0608(Date kcgm0608) {
		this.kcgm0608 = kcgm0608;
	}

	public Long getKcgm0609() {
		return kcgm0609;
	}

	public void setKcgm0609(Long kcgm0609) {
		this.kcgm0609 = kcgm0609;
	}

	public Date getKcgm0610() {
		return kcgm0610;
	}

	public void setKcgm0610(Date kcgm0610) {
		this.kcgm0610 = kcgm0610;
	}

	@Override
	protected Serializable pkVal() {
		return this.kcgm0601;
	}

	@Override
	public String toString() {
		return "Tbkcgm06{" +
			"kcgm0601=" + kcgm0601 +
			", kcgm0602=" + kcgm0602 +
			", kcgm0603=" + kcgm0603 +
			", kcgm0604=" + kcgm0604 +
			", kcgm0605=" + kcgm0605 +
			", kcgm0606=" + kcgm0606 +
			", kcgm0607=" + kcgm0607 +
			", kcgm0608=" + kcgm0608 +
			", kcgm0609=" + kcgm0609 +
			", kcgm0610=" + kcgm0610 +
			"}";
	}
}

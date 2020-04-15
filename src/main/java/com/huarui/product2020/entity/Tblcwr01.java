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
 * @since 2020-02-13
 */
public class Tblcwr01 extends Model<Tblcwr01> {

    private static final long serialVersionUID = 1L;

    @TableId("LCWR0101")
	private String lcwr0101;
	@TableField("LCWR0102")
	private String lcwr0102;
	@TableField("LCWR0103")
	private String lcwr0103;
	@TableField("LCWR0104")
	private String lcwr0104;
	@TableField("LCWR0105")
	private String lcwr0105;
	@TableField("LCWR0106")
	private Date lcwr0106;
	@TableField("LCWR0107")
	private Double lcwr0107;
	@TableField("LCWR0108")
	private Double lcwr0108;
	@TableField("LCWR0109")
	private Date lcwr0109;
    /**
     * 是否学完 （0未完成 1已完成） 
     */
	@TableField("LCWR0110")
	private Double lcwr0110;
    /**
     * 是否更新完成 （0未更新 1已更新）
进入学习时状态为0，退出学习时更新状态为1。 
     */
	@TableField("LCWR0111")
	private Double lcwr0111;

	@TableField("LCWR0112")
	private Double lcwr0112;

	@TableField("LCWR0113")
	private Date lcwr0113;


	public String getLcwr0101() {
		return lcwr0101;
	}

	public void setLcwr0101(String lcwr0101) {
		this.lcwr0101 = lcwr0101;
	}

	public String getLcwr0102() {
		return lcwr0102;
	}

	public void setLcwr0102(String lcwr0102) {
		this.lcwr0102 = lcwr0102;
	}

	public String getLcwr0103() {
		return lcwr0103;
	}

	public void setLcwr0103(String lcwr0103) {
		this.lcwr0103 = lcwr0103;
	}

	public String getLcwr0104() {
		return lcwr0104;
	}

	public void setLcwr0104(String lcwr0104) {
		this.lcwr0104 = lcwr0104;
	}

	public String getLcwr0105() {
		return lcwr0105;
	}

	public void setLcwr0105(String lcwr0105) {
		this.lcwr0105 = lcwr0105;
	}

	public Date getLcwr0106() {
		return lcwr0106;
	}

	public void setLcwr0106(Date lcwr0106) {
		this.lcwr0106 = lcwr0106;
	}

	public Double getLcwr0107() {
		return lcwr0107;
	}

	public void setLcwr0107(Double lcwr0107) {
		this.lcwr0107 = lcwr0107;
	}

	public Double getLcwr0108() {
		return lcwr0108;
	}

	public void setLcwr0108(Double lcwr0108) {
		this.lcwr0108 = lcwr0108;
	}

	public Date getLcwr0109() {
		return lcwr0109;
	}

	public void setLcwr0109(Date lcwr0109) {
		this.lcwr0109 = lcwr0109;
	}

	public Double getLcwr0110() {
		return lcwr0110;
	}

	public void setLcwr0110(Double lcwr0110) {
		this.lcwr0110 = lcwr0110;
	}

	public Double getLcwr0111() {
		return lcwr0111;
	}

	public void setLcwr0111(Double lcwr0111) {
		this.lcwr0111 = lcwr0111;
	}

	@Override
	protected Serializable pkVal() {
		return this.lcwr0101;
	}

	@Override
	public String toString() {
		return "Tblcwr01{" +
			"lcwr0101=" + lcwr0101 +
			", lcwr0102=" + lcwr0102 +
			", lcwr0103=" + lcwr0103 +
			", lcwr0104=" + lcwr0104 +
			", lcwr0105=" + lcwr0105 +
			", lcwr0106=" + lcwr0106 +
			", lcwr0107=" + lcwr0107 +
			", lcwr0108=" + lcwr0108 +
			", lcwr0109=" + lcwr0109 +
			", lcwr0110=" + lcwr0110 +
			", lcwr0111=" + lcwr0111 +
			"}";
	}

	public Double getLcwr0112() {
		return lcwr0112;
	}

	public void setLcwr0112(Double lcwr0112) {
		this.lcwr0112 = lcwr0112;
	}

	public Date getLcwr0113() {
		return lcwr0113;
	}

	public void setLcwr0113(Date lcwr0113) {
		this.lcwr0113 = lcwr0113;
	}
}

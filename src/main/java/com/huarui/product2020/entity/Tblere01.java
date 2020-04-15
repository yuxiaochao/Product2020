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
public class Tblere01 extends Model<Tblere01> {

    private static final long serialVersionUID = 1L;

    @TableId("LERE0101")
	private String lere0101;
	@TableField("LERE0102")
	private String lere0102;
	@TableField("LERE0103")
	private String lere0103;
	@TableField("LERE0104")
	private Date lere0104;
	@TableField("LERE0105")
	private Double lere0105;
	@TableField("LERE0106")
	private Double lere0106;
	@TableField("LERE0107")
	private Date lere0107;
    /**
     * 是否结业  0 未结业 1、已结业 2、强制结业 
     */
	@TableField("LERE0108")
	private Double lere0108;
    /**
     * 我的课程表主键 
     */
	@TableField("LERE0109")
	private String lere0109;
	/**
	 * 上次学习时间
	 */
	@TableField("lere0110")
	private Date lere0110;


	public String getLere0101() {
		return lere0101;
	}

	public void setLere0101(String lere0101) {
		this.lere0101 = lere0101;
	}

	public String getLere0102() {
		return lere0102;
	}

	public void setLere0102(String lere0102) {
		this.lere0102 = lere0102;
	}

	public String getLere0103() {
		return lere0103;
	}

	public void setLere0103(String lere0103) {
		this.lere0103 = lere0103;
	}

	public Date getLere0104() {
		return lere0104;
	}

	public void setLere0104(Date lere0104) {
		this.lere0104 = lere0104;
	}

	public Double getLere0105() {
		return lere0105;
	}

	public void setLere0105(Double lere0105) {
		this.lere0105 = lere0105;
	}

	public Double getLere0106() {
		return lere0106;
	}

	public void setLere0106(Double lere0106) {
		this.lere0106 = lere0106;
	}

	public Date getLere0107() {
		return lere0107;
	}

	public void setLere0107(Date lere0107) {
		this.lere0107 = lere0107;
	}

	public Double getLere0108() {
		return lere0108;
	}

	public void setLere0108(Double lere0108) {
		this.lere0108 = lere0108;
	}

	public String getLere0109() {
		return lere0109;
	}

	public void setLere0109(String lere0109) {
		this.lere0109 = lere0109;
	}

	@Override
	protected Serializable pkVal() {
		return this.lere0101;
	}

	public Date getLere0110() {
		return lere0110;
	}

	public void setLere0110(Date lere0110) {
		this.lere0110 = lere0110;
	}

	@Override
	public String toString() {
		return "Tblere01{" +
			"lere0101=" + lere0101 +
			", lere0102=" + lere0102 +
			", lere0103=" + lere0103 +
			", lere0104=" + lere0104 +
			", lere0105=" + lere0105 +
			", lere0106=" + lere0106 +
			", lere0107=" + lere0107 +
			", lere0108=" + lere0108 +
			", lere0109=" + lere0109 +
			"}";
	}
}

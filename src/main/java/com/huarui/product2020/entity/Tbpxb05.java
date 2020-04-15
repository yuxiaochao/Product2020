package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yuxiaochao
 * @since 2019-10-25
 */
public class Tbpxb05 extends Model<Tbpxb05> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("PXB0501")
	private String pxb0501;
    /**
     * 培训班ID
     */
	@TableField("PXB0502")
	private String pxb0502;
    /**
     * 类别0：机构；1：群组；2：在班级导入；3：按职务/工种等级
     */
	@TableField("PXB0503")
	private Double pxb0503;
    /**
     * 机构ID
     */
	@TableField("PXB0504")
	private String pxb0504;
    /**
     * 群组ID
     */
	@TableField("PXB0505")
	private String pxb0505;
    /**
     * 人员ID
     */
	@TableField("PXB0506")
	private String pxb0506;
    /**
     * 职务/工种等级ID
     */
	@TableField("PXB0507")
	private String pxb0507;


	public String getPxb0501() {
		return pxb0501;
	}

	public void setPxb0501(String pxb0501) {
		this.pxb0501 = pxb0501;
	}

	public String getPxb0502() {
		return pxb0502;
	}

	public void setPxb0502(String pxb0502) {
		this.pxb0502 = pxb0502;
	}

	public Double getPxb0503() {
		return pxb0503;
	}

	public void setPxb0503(Double pxb0503) {
		this.pxb0503 = pxb0503;
	}

	public String getPxb0504() {
		return pxb0504;
	}

	public void setPxb0504(String pxb0504) {
		this.pxb0504 = pxb0504;
	}

	public String getPxb0505() {
		return pxb0505;
	}

	public void setPxb0505(String pxb0505) {
		this.pxb0505 = pxb0505;
	}

	public String getPxb0506() {
		return pxb0506;
	}

	public void setPxb0506(String pxb0506) {
		this.pxb0506 = pxb0506;
	}

	public String getPxb0507() {
		return pxb0507;
	}

	public void setPxb0507(String pxb0507) {
		this.pxb0507 = pxb0507;
	}

	@Override
	protected Serializable pkVal() {
		return this.pxb0501;
	}

	@Override
	public String toString() {
		return "Tbpxb05{" +
			"pxb0501=" + pxb0501 +
			", pxb0502=" + pxb0502 +
			", pxb0503=" + pxb0503 +
			", pxb0504=" + pxb0504 +
			", pxb0505=" + pxb0505 +
			", pxb0506=" + pxb0506 +
			", pxb0507=" + pxb0507 +
			"}";
	}
}

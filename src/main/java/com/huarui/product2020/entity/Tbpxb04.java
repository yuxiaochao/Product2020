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
public class Tbpxb04 extends Model<Tbpxb04> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("PXB0401")
	private String pxb0401;
    /**
     * 培训班ID
     */
	@TableField("PXB0402")
	private String pxb0402;
    /**
     * 联络员ID
     */
	@TableField("PXB0403")
	private String pxb0403;
    /**
     * 报名单位ID
     */
	@TableField("PXB0404")
	private String pxb0404;
    /**
     * 允许报名人数
     */
	@TableField("PXB0405")
	private Double pxb0405;


	public String getPxb0401() {
		return pxb0401;
	}

	public void setPxb0401(String pxb0401) {
		this.pxb0401 = pxb0401;
	}

	public String getPxb0402() {
		return pxb0402;
	}

	public void setPxb0402(String pxb0402) {
		this.pxb0402 = pxb0402;
	}

	public String getPxb0403() {
		return pxb0403;
	}

	public void setPxb0403(String pxb0403) {
		this.pxb0403 = pxb0403;
	}

	public String getPxb0404() {
		return pxb0404;
	}

	public void setPxb0404(String pxb0404) {
		this.pxb0404 = pxb0404;
	}

	public Double getPxb0405() {
		return pxb0405;
	}

	public void setPxb0405(Double pxb0405) {
		this.pxb0405 = pxb0405;
	}

	@Override
	protected Serializable pkVal() {
		return this.pxb0401;
	}

	@Override
	public String toString() {
		return "Tbpxb04{" +
			"pxb0401=" + pxb0401 +
			", pxb0402=" + pxb0402 +
			", pxb0403=" + pxb0403 +
			", pxb0404=" + pxb0404 +
			", pxb0405=" + pxb0405 +
			"}";
	}
}

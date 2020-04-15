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
public class Tbpxb09 extends Model<Tbpxb09> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("PXB0901")
	private String pxb0901;
    /**
     * 培训班ID
     */
	@TableField("PXB0902")
	private String pxb0902;
    /**
     * 参加效果评估0：否；1：是；
     */
	@TableField("PXB0903")
	private Double pxb0903;
    /**
     * 须管理员确认0：否；1：是；
     */
	@TableField("PXB0904")
	private Double pxb0904;


	public String getPxb0901() {
		return pxb0901;
	}

	public void setPxb0901(String pxb0901) {
		this.pxb0901 = pxb0901;
	}

	public String getPxb0902() {
		return pxb0902;
	}

	public void setPxb0902(String pxb0902) {
		this.pxb0902 = pxb0902;
	}

	public Double getPxb0903() {
		return pxb0903;
	}

	public void setPxb0903(Double pxb0903) {
		this.pxb0903 = pxb0903;
	}

	public Double getPxb0904() {
		return pxb0904;
	}

	public void setPxb0904(Double pxb0904) {
		this.pxb0904 = pxb0904;
	}

	@Override
	protected Serializable pkVal() {
		return this.pxb0901;
	}

	@Override
	public String toString() {
		return "Tbpxb09{" +
			"pxb0901=" + pxb0901 +
			", pxb0902=" + pxb0902 +
			", pxb0903=" + pxb0903 +
			", pxb0904=" + pxb0904 +
			"}";
	}
}

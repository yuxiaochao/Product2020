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
public class Tbpxb08 extends Model<Tbpxb08> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("PXB0801")
	private String pxb0801;
    /**
     * 培训班ID
     */
	@TableField("PXB0802")
	private String pxb0802;
    /**
     * 试卷ID
     */
	@TableField("PXB0803")
	private String pxb0803;
    /**
     * 类别0：结业考试；1：学习考试；
2：课后练习；
     */
	@TableField("PXB0804")
	private Double pxb0804;


	public String getPxb0801() {
		return pxb0801;
	}

	public void setPxb0801(String pxb0801) {
		this.pxb0801 = pxb0801;
	}

	public String getPxb0802() {
		return pxb0802;
	}

	public void setPxb0802(String pxb0802) {
		this.pxb0802 = pxb0802;
	}

	public String getPxb0803() {
		return pxb0803;
	}

	public void setPxb0803(String pxb0803) {
		this.pxb0803 = pxb0803;
	}

	public Double getPxb0804() {
		return pxb0804;
	}

	public void setPxb0804(Double pxb0804) {
		this.pxb0804 = pxb0804;
	}

	@Override
	protected Serializable pkVal() {
		return this.pxb0801;
	}

	@Override
	public String toString() {
		return "Tbpxb08{" +
			"pxb0801=" + pxb0801 +
			", pxb0802=" + pxb0802 +
			", pxb0803=" + pxb0803 +
			", pxb0804=" + pxb0804 +
			"}";
	}
}

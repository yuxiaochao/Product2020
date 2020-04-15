package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author YanZeYang
 * @since 2020-01-15
 */
public class Tbpxjk01 extends Model<Tbpxjk01> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键

     */
	@TableField("PXJK0101")
	private String pxjk0101;
    /**
     * 状态0.未报到1.已报到
     */
	@TableField("PXJK0102")
	private Double pxjk0102;
    /**
     * 报到类型0.人工报到1.自主报到
     */
	@TableField("PXJK0103")
	private Double pxjk0103;
    /**
     * 报到时间
     */
	@TableField("PXJK0104")
	private Date pxjk0104;
    /**
     * 报名学员基本表id
     */
	@TableField("PXJK0105")
	private String pxjk0105;


	public String getPxjk0101() {
		return pxjk0101;
	}

	public void setPxjk0101(String pxjk0101) {
		this.pxjk0101 = pxjk0101;
	}

	public Double getPxjk0102() {
		return pxjk0102;
	}

	public void setPxjk0102(Double pxjk0102) {
		this.pxjk0102 = pxjk0102;
	}

	public Double getPxjk0103() {
		return pxjk0103;
	}

	public void setPxjk0103(Double pxjk0103) {
		this.pxjk0103 = pxjk0103;
	}

	public Date getPxjk0104() {
		return pxjk0104;
	}

	public void setPxjk0104(Date pxjk0104) {
		this.pxjk0104 = pxjk0104;
	}

	public String getPxjk0105() {
		return pxjk0105;
	}

	public void setPxjk0105(String pxjk0105) {
		this.pxjk0105 = pxjk0105;
	}

	@Override
	protected Serializable pkVal() {
		return this.pxjk0101;
	}

	@Override
	public String toString() {
		return "Tbpxjk01{" +
			"pxjk0101=" + pxjk0101 +
			", pxjk0102=" + pxjk0102 +
			", pxjk0103=" + pxjk0103 +
			", pxjk0104=" + pxjk0104 +
			", pxjk0105=" + pxjk0105 +
			"}";
	}
}

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
public class Tbjxsj11 extends Model<Tbjxsj11> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("JXSJ1101")
	private String jxsj1101;
    /**
     * 培训班ID
     */
	@TableField("JXSJ1102")
	private String jxsj1102;
    /**
     * 问卷ID
     */
	@TableField("JXSJ1103")
	private String jxsj1103;
    /**
     * 评估方式  0:按班评估；1：按课程；2：按讲师
     */
	@TableField("JXSJ1104")
	private Double jxsj1104;
    /**
     * 课程ID
     */
	@TableField("JXSJ1105")
	private String jxsj1105;
    /**
     * 讲师ID
     */
	@TableField("JXSJ1106")
	private String jxsj1106;


	public String getJxsj1101() {
		return jxsj1101;
	}

	public void setJxsj1101(String jxsj1101) {
		this.jxsj1101 = jxsj1101;
	}

	public String getJxsj1102() {
		return jxsj1102;
	}

	public void setJxsj1102(String jxsj1102) {
		this.jxsj1102 = jxsj1102;
	}

	public String getJxsj1103() {
		return jxsj1103;
	}

	public void setJxsj1103(String jxsj1103) {
		this.jxsj1103 = jxsj1103;
	}

	public Double getJxsj1104() {
		return jxsj1104;
	}

	public void setJxsj1104(Double jxsj1104) {
		this.jxsj1104 = jxsj1104;
	}

	public String getJxsj1105() {
		return jxsj1105;
	}

	public void setJxsj1105(String jxsj1105) {
		this.jxsj1105 = jxsj1105;
	}

	public String getJxsj1106() {
		return jxsj1106;
	}

	public void setJxsj1106(String jxsj1106) {
		this.jxsj1106 = jxsj1106;
	}

	@Override
	protected Serializable pkVal() {
		return this.jxsj1101;
	}

	@Override
	public String toString() {
		return "Tbjxsj11{" +
			"jxsj1101=" + jxsj1101 +
			", jxsj1102=" + jxsj1102 +
			", jxsj1103=" + jxsj1103 +
			", jxsj1104=" + jxsj1104 +
			", jxsj1105=" + jxsj1105 +
			", jxsj1106=" + jxsj1106 +
			"}";
	}
}

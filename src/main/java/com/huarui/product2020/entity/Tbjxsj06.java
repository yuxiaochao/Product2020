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
public class Tbjxsj06 extends Model<Tbjxsj06> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("JXSJ0601")
	private String jxsj0601;
    /**
     * 培训班ID
     */
	@TableField("JXSJ0602")
	private String jxsj0602;
    /**
     * 课程ID
     */
	@TableField("JXSJ0603")
	private String jxsj0603;
    /**
     * 授课方式0：面授； 2：直播课程
     */
	@TableField("JXSJ0604")
	private Integer jxsj0604;
    /**
     * 启用签到0：否；1：是
     */
	@TableField("JXSJ0605")
	private Integer jxsj0605;


	public String getJxsj0601() {
		return jxsj0601;
	}

	public void setJxsj0601(String jxsj0601) {
		this.jxsj0601 = jxsj0601;
	}

	public String getJxsj0602() {
		return jxsj0602;
	}

	public void setJxsj0602(String jxsj0602) {
		this.jxsj0602 = jxsj0602;
	}

	public String getJxsj0603() {
		return jxsj0603;
	}

	public void setJxsj0603(String jxsj0603) {
		this.jxsj0603 = jxsj0603;
	}

	public Integer getJxsj0604() {
		return jxsj0604;
	}

	public void setJxsj0604(Integer jxsj0604) {
		this.jxsj0604 = jxsj0604;
	}

	public Integer getJxsj0605() {
		return jxsj0605;
	}

	public void setJxsj0605(Integer jxsj0605) {
		this.jxsj0605 = jxsj0605;
	}

	@Override
	protected Serializable pkVal() {
		return this.jxsj0601;
	}

	@Override
	public String toString() {
		return "Tbjxsj06{" +
			"jxsj0601=" + jxsj0601 +
			", jxsj0602=" + jxsj0602 +
			", jxsj0603=" + jxsj0603 +
			", jxsj0604=" + jxsj0604 +
			", jxsj0605=" + jxsj0605 +
			"}";
	}
}

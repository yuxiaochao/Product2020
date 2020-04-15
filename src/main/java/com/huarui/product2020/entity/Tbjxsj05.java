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
public class Tbjxsj05 extends Model<Tbjxsj05> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("JXSJ0501")
	private String jxsj0501;
    /**
     * 培训班ID
     */
	@TableField("JXSJ0502")
	private String jxsj0502;
    /**
     * 开课前默认30分钟
     */
	@TableField("JXSJ0503")
	private Integer jxsj0503;
    /**
     * 开课后默认30分钟
     */
	@TableField("JXSJ0504")
	private Integer jxsj0504;
    /**
     * 下课后默认60分钟
     */
	@TableField("JXSJ0505")
	private Integer jxsj0505;


	public String getJxsj0501() {
		return jxsj0501;
	}

	public void setJxsj0501(String jxsj0501) {
		this.jxsj0501 = jxsj0501;
	}

	public String getJxsj0502() {
		return jxsj0502;
	}

	public void setJxsj0502(String jxsj0502) {
		this.jxsj0502 = jxsj0502;
	}

	public Integer getJxsj0503() {
		return jxsj0503;
	}

	public void setJxsj0503(Integer jxsj0503) {
		this.jxsj0503 = jxsj0503;
	}

	public Integer getJxsj0504() {
		return jxsj0504;
	}

	public void setJxsj0504(Integer jxsj0504) {
		this.jxsj0504 = jxsj0504;
	}

	public Integer getJxsj0505() {
		return jxsj0505;
	}

	public void setJxsj0505(Integer jxsj0505) {
		this.jxsj0505 = jxsj0505;
	}

	@Override
	protected Serializable pkVal() {
		return this.jxsj0501;
	}

	@Override
	public String toString() {
		return "Tbjxsj05{" +
			"jxsj0501=" + jxsj0501 +
			", jxsj0502=" + jxsj0502 +
			", jxsj0503=" + jxsj0503 +
			", jxsj0504=" + jxsj0504 +
			", jxsj0505=" + jxsj0505 +
			"}";
	}
}

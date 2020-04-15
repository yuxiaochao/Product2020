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
 * @author panlei
 * @since 2020-02-15
 */
public class Tbcmdy05 extends Model<Tbcmdy05> {

    private static final long serialVersionUID = 1L;

    @TableId("CMDY0501")
	private String cmdy0501;
	@TableField("CMDY0502")
	private String cmdy0502;
	@TableField("CMDY0503")
	private String cmdy0503;
	@TableField("CMDY0504")
	private Double cmdy0504;


	public String getCmdy0501() {
		return cmdy0501;
	}

	public void setCmdy0501(String cmdy0501) {
		this.cmdy0501 = cmdy0501;
	}

	public String getCmdy0502() {
		return cmdy0502;
	}

	public void setCmdy0502(String cmdy0502) {
		this.cmdy0502 = cmdy0502;
	}

	public String getCmdy0503() {
		return cmdy0503;
	}

	public void setCmdy0503(String cmdy0503) {
		this.cmdy0503 = cmdy0503;
	}

	public Double getCmdy0504() {
		return cmdy0504;
	}

	public void setCmdy0504(Double cmdy0504) {
		this.cmdy0504 = cmdy0504;
	}

	@Override
	protected Serializable pkVal() {
		return this.cmdy0501;
	}

	@Override
	public String toString() {
		return "Tbcmdy05{" +
			"cmdy0501=" + cmdy0501 +
			", cmdy0502=" + cmdy0502 +
			", cmdy0503=" + cmdy0503 +
			", cmdy0504=" + cmdy0504 +
			"}";
	}
}

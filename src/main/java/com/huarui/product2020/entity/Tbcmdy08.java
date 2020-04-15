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
 * @author panlei
 * @since 2020-02-15
 */
public class Tbcmdy08 extends Model<Tbcmdy08> {

    private static final long serialVersionUID = 1L;

    @TableId("CMDY0801")
	private String cmdy0801;
	@TableField("CMDY0802")
	private String cmdy0802;
	@TableField("CMDY0803")
	private Double cmdy0803;
	@TableField("CMDY0804")
	private String cmdy0804;
	@TableField("CMDY0805")
	private String cmdy0805;
	@TableField("CMDY0806")
	private Date cmdy0806;


	public String getCmdy0801() {
		return cmdy0801;
	}

	public void setCmdy0801(String cmdy0801) {
		this.cmdy0801 = cmdy0801;
	}

	public String getCmdy0802() {
		return cmdy0802;
	}

	public void setCmdy0802(String cmdy0802) {
		this.cmdy0802 = cmdy0802;
	}

	public Double getCmdy0803() {
		return cmdy0803;
	}

	public void setCmdy0803(Double cmdy0803) {
		this.cmdy0803 = cmdy0803;
	}

	public String getCmdy0804() {
		return cmdy0804;
	}

	public void setCmdy0804(String cmdy0804) {
		this.cmdy0804 = cmdy0804;
	}

	public String getCmdy0805() {
		return cmdy0805;
	}

	public void setCmdy0805(String cmdy0805) {
		this.cmdy0805 = cmdy0805;
	}

	public Date getCmdy0806() {
		return cmdy0806;
	}

	public void setCmdy0806(Date cmdy0806) {
		this.cmdy0806 = cmdy0806;
	}

	@Override
	protected Serializable pkVal() {
		return this.cmdy0801;
	}

	@Override
	public String toString() {
		return "Tbcmdy08{" +
			"cmdy0801=" + cmdy0801 +
			", cmdy0802=" + cmdy0802 +
			", cmdy0803=" + cmdy0803 +
			", cmdy0804=" + cmdy0804 +
			", cmdy0805=" + cmdy0805 +
			", cmdy0806=" + cmdy0806 +
			"}";
	}
}

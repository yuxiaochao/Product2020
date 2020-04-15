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
public class Tbcmdy07 extends Model<Tbcmdy07> {

    private static final long serialVersionUID = 1L;

    @TableId("CMDY0701")
	private String cmdy0701;
	@TableField("CMDY0702")
	private String cmdy0702;
	@TableField("CMDY0703")
	private String cmdy0703;
	@TableField("CMDY0704")
	private Double cmdy0704;
	@TableField("CMDY0705")
	private Double cmdy0705;
	
	
	@TableField("CMDY0706")
	private String cmdy0706;
	
	@TableField(exist = false)
	private Tbcmdy04 tbcmdy04;


	public String getCmdy0701() {
		return cmdy0701;
	}

	public void setCmdy0701(String cmdy0701) {
		this.cmdy0701 = cmdy0701;
	}

	public String getCmdy0702() {
		return cmdy0702;
	}

	public void setCmdy0702(String cmdy0702) {
		this.cmdy0702 = cmdy0702;
	}

	public String getCmdy0703() {
		return cmdy0703;
	}

	public void setCmdy0703(String cmdy0703) {
		this.cmdy0703 = cmdy0703;
	}

	public Double getCmdy0704() {
		return cmdy0704;
	}

	public void setCmdy0704(Double cmdy0704) {
		this.cmdy0704 = cmdy0704;
	}

	public Double getCmdy0705() {
		return cmdy0705;
	}

	public void setCmdy0705(Double cmdy0705) {
		this.cmdy0705 = cmdy0705;
	}
	
	

	public Tbcmdy04 getTbcmdy04() {
		return tbcmdy04;
	}

	public void setTbcmdy04(Tbcmdy04 tbcmdy04) {
		this.tbcmdy04 = tbcmdy04;
	}

	
	 
	public String getCmdy0706() {
		return cmdy0706;
	}

	public void setCmdy0706(String cmdy0706) {
		this.cmdy0706 = cmdy0706;
	}

	@Override
	protected Serializable pkVal() {
		return this.cmdy0701;
	}
	
	

	@Override
	public String toString() {
		return "Tbcmdy07{" +
			"cmdy0701=" + cmdy0701 +
			", cmdy0702=" + cmdy0702 +
			", cmdy0703=" + cmdy0703 +
			", cmdy0704=" + cmdy0704 +
			", cmdy0705=" + cmdy0705 +
			"}";
	}
}

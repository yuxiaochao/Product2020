package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author panlei
 * @since 2020-02-15
 */
public class Tbcmdy06 extends Model<Tbcmdy06> {

    private static final long serialVersionUID = 1L;

    @TableId("CMDY0601")
	private String cmdy0601;
	@TableField("CMDY0602")
	private String cmdy0602;
	@TableField("CMDY0603")
	private String cmdy0603;
	@TableField("CMDY0604")
	private Double cmdy0604;
	@TableField("CMDY0605")
	private Double cmdy0605;
	
	@TableField("CMDY0606")
	private Date cmdy0606;
	
	//套包学时
	@TableField("CMDY0607")
	private String cmdy0607;
	
	/**
	 * 单科学时
	 */
	@TableField("CMDY0608")
	private String cmdy0608;
	
	/**
	 * 单科价格
	 */
	@TableField("CMDY0609")
	private Double cmdy0609;
	
	@TableField(exist = false)
	private List<Tbcmdy07> tbcmdy07List;
	

	public String getCmdy0601() {
		return cmdy0601;
	}

	public void setCmdy0601(String cmdy0601) {
		this.cmdy0601 = cmdy0601;
	}

	public String getCmdy0602() {
		return cmdy0602;
	}

	public void setCmdy0602(String cmdy0602) {
		this.cmdy0602 = cmdy0602;
	}

	public String getCmdy0603() {
		return cmdy0603;
	}

	public void setCmdy0603(String cmdy0603) {
		this.cmdy0603 = cmdy0603;
	}

	public Double getCmdy0604() {
		return cmdy0604;
	}

	public void setCmdy0604(Double cmdy0604) {
		this.cmdy0604 = cmdy0604;
	}

	public Double getCmdy0605() {
		return cmdy0605;
	}

	public void setCmdy0605(Double cmdy0605) {
		this.cmdy0605 = cmdy0605;
	}
	
	

	public Date getCmdy0606() {
		return cmdy0606;
	}

	public void setCmdy0606(Date cmdy0606) {
		this.cmdy0606 = cmdy0606;
	}

	
	

	public List<Tbcmdy07> getTbcmdy07List() {
		return tbcmdy07List;
	}

	public void setTbcmdy07List(List<Tbcmdy07> tbcmdy07List) {
		this.tbcmdy07List = tbcmdy07List;
	}

	@Override
	protected Serializable pkVal() {
		return this.cmdy0601;
	}

	
	


	public String getCmdy0607() {
		return cmdy0607;
	}

	public void setCmdy0607(String cmdy0607) {
		this.cmdy0607 = cmdy0607;
	}

	public String getCmdy0608() {
		return cmdy0608;
	}

	public void setCmdy0608(String cmdy0608) {
		this.cmdy0608 = cmdy0608;
	}

	public Double getCmdy0609() {
		return cmdy0609;
	}

	public void setCmdy0609(Double cmdy0609) {
		this.cmdy0609 = cmdy0609;
	}

	@Override
	public String toString() {
		return "Tbcmdy06{" +
			"cmdy0601=" + cmdy0601 +
			", cmdy0602=" + cmdy0602 +
			", cmdy0603=" + cmdy0603 +
			", cmdy0604=" + cmdy0604 +
			", cmdy0605=" + cmdy0605 +
			"}";
	}
}

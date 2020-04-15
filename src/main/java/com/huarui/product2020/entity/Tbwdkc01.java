package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author su
 * @since 2020-02-13
 */
public class Tbwdkc01 extends Model<Tbwdkc01> {

    private static final long serialVersionUID = 1L;

    @TableId("WDKC0101")
	private String wdkc0101;
    /**
     * 商品所属商品包ID
     */
	@TableField("WDKC0102")
	private String wdkc0102;
    /**
     * 商品所属套包ID
     */
	@TableField("WDKC0103")
	private String wdkc0103;
    /**
     * 用户ID
     */
	@TableField("WDKC0104")
	private String wdkc0104;
    /**
     * 显示名称 商品包名称+套包名称 
     */
	@TableField("WDKC0105")
	private String wdkc0105;
    /**
     * 状态 0：待学 在学; 1已学完 
     */
	@TableField("WDKC0106")
	private Double wdkc0106;

	@TableField(exist = false)
	private String cmdy0302;
	@TableField(exist = false)
	private String cmdy0303;
	@TableField(exist = false)
	private String cmdy0306;
	@TableField(exist = false)
	private String cmdy0603;

	/**
	 * 课件列表
	 */
	private List<Tbwdkc02> wdkc02List;


	public String getWdkc0101() {
		return wdkc0101;
	}

	public void setWdkc0101(String wdkc0101) {
		this.wdkc0101 = wdkc0101;
	}

	public String getWdkc0102() {
		return wdkc0102;
	}

	public void setWdkc0102(String wdkc0102) {
		this.wdkc0102 = wdkc0102;
	}

	public String getWdkc0103() {
		return wdkc0103;
	}

	public void setWdkc0103(String wdkc0103) {
		this.wdkc0103 = wdkc0103;
	}

	public String getWdkc0104() {
		return wdkc0104;
	}

	public void setWdkc0104(String wdkc0104) {
		this.wdkc0104 = wdkc0104;
	}

	public String getWdkc0105() {
		return wdkc0105;
	}

	public void setWdkc0105(String wdkc0105) {
		this.wdkc0105 = wdkc0105;
	}

	public Double getWdkc0106() {
		return wdkc0106;
	}

	public void setWdkc0106(Double wdkc0106) {
		this.wdkc0106 = wdkc0106;
	}

	@Override
	protected Serializable pkVal() {
		return this.wdkc0101;
	}

	@Override
	public String toString() {
		return "Tbwdkc01{" +
			"wdkc0101=" + wdkc0101 +
			", wdkc0102=" + wdkc0102 +
			", wdkc0103=" + wdkc0103 +
			", wdkc0104=" + wdkc0104 +
			", wdkc0105=" + wdkc0105 +
			", wdkc0106=" + wdkc0106 +
			"}";
	}

	public List<Tbwdkc02> getWdkc02List() {
		return wdkc02List;
	}

	public void setWdkc02List(List<Tbwdkc02> wdkc02List) {
		this.wdkc02List = wdkc02List;
	}

	public String getCmdy0302() {
		return cmdy0302;
	}

	public void setCmdy0302(String cmdy0302) {
		this.cmdy0302 = cmdy0302;
	}

	public String getCmdy0306() {
		return cmdy0306;
	}

	public void setCmdy0306(String cmdy0306) {
		this.cmdy0306 = cmdy0306;
	}

	public String getCmdy0603() {
		return cmdy0603;
	}

	public void setCmdy0603(String cmdy0603) {
		this.cmdy0603 = cmdy0603;
	}

	public String getCmdy0303() {
		return cmdy0303;
	}

	public void setCmdy0303(String cmdy0303) {
		this.cmdy0303 = cmdy0303;
	}

}

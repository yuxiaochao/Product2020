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
 * @author yuxiaochao
 * @since 2020-02-17
 */
public class Tbcmdy01 extends Model<Tbcmdy01> {

    private static final long serialVersionUID = 1L;

    @TableId("CMDY0101")
	private String cmdy0101;
    /**
     * 专业名称
     */
	@TableField("CMDY0102")
	private String cmdy0102;
	@TableField("CMDY0103")
	private String cmdy0103;
	@TableField("CMDY0104")
	private Double cmdy0104;
	@TableField("CMDY0105")
	private String cmdy0105;
	@TableField("CMDY0106")
	private Date cmdy0106;
	@TableField("CMDY0107")
	private Date cmdy0107;
	@TableField("CMDY0108")
	private String cmdy0108;
	@TableField("CMDY0109")
	private String cmdy0109;

	@TableField(exist = false)
	private List<Tbcmdy01> childs;
	
	@TableField(exist = false)
	private List<Tbcmdy03> tbcmdy03List;

	public String getCmdy0101() {
		return cmdy0101;
	}

	public void setCmdy0101(String cmdy0101) {
		this.cmdy0101 = cmdy0101;
	}

	public String getCmdy0102() {
		return cmdy0102;
	}

	public void setCmdy0102(String cmdy0102) {
		this.cmdy0102 = cmdy0102;
	}

	public String getCmdy0103() {
		return cmdy0103;
	}

	public void setCmdy0103(String cmdy0103) {
		this.cmdy0103 = cmdy0103;
	}

	public Double getCmdy0104() {
		return cmdy0104;
	}

	public void setCmdy0104(Double cmdy0104) {
		this.cmdy0104 = cmdy0104;
	}

	public String getCmdy0105() {
		return cmdy0105;
	}

	public void setCmdy0105(String cmdy0105) {
		this.cmdy0105 = cmdy0105;
	}

	public Date getCmdy0106() {
		return cmdy0106;
	}

	public void setCmdy0106(Date cmdy0106) {
		this.cmdy0106 = cmdy0106;
	}

	public Date getCmdy0107() {
		return cmdy0107;
	}

	public void setCmdy0107(Date cmdy0107) {
		this.cmdy0107 = cmdy0107;
	}

	public String getCmdy0108() {
		return cmdy0108;
	}

	public void setCmdy0108(String cmdy0108) {
		this.cmdy0108 = cmdy0108;
	}

	public String getCmdy0109() {
		return cmdy0109;
	}

	public void setCmdy0109(String cmdy0109) {
		this.cmdy0109 = cmdy0109;
	}
	
	

	public List<Tbcmdy01> getChilds() {
		return childs;
	}

	public void setChilds(List<Tbcmdy01> childs) {
		this.childs = childs;
	}

	public List<Tbcmdy03> getTbcmdy03List() {
		return tbcmdy03List;
	}

	public void setTbcmdy03List(List<Tbcmdy03> tbcmdy03List) {
		this.tbcmdy03List = tbcmdy03List;
	}

	@Override
	protected Serializable pkVal() {
		return this.cmdy0101;
	}

	@Override
	public String toString() {
		return "Tbcmdy01{" +
			"cmdy0101=" + cmdy0101 +
			", cmdy0102=" + cmdy0102 +
			", cmdy0103=" + cmdy0103 +
			", cmdy0104=" + cmdy0104 +
			", cmdy0105=" + cmdy0105 +
			", cmdy0106=" + cmdy0106 +
			", cmdy0107=" + cmdy0107 +
			", cmdy0108=" + cmdy0108 +
			", cmdy0109=" + cmdy0109 +
			"}";
	}
}

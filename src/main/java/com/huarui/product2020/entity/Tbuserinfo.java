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
 * @author yuxiaochao
 * @since 2020-02-19
 */
public class Tbuserinfo extends Model<Tbuserinfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键PK
     */
    @TableId("UINF0101")
	private String uinf0101;
    /**
     * 用户帐号表ID
     */
	@TableField("UINF0102")
	private String uinf0102;
    /**
     * 姓名
     */
	@TableField("UINF0103")
	private String uinf0103;
    /**
     * 性别
     */
	@TableField("UINF0104")
	private String uinf0104;
    /**
     * 出生日期
     */
	@TableField("UINF0105")
	private Date uinf0105;
    /**
     * 民族
     */
	@TableField("UINF0106")
	private String uinf0106;
    /**
     * 身份证
     */
	@TableField("UINF0107")
	private String uinf0107;
    /**
     * 居住地（省）
     */
	@TableField("UINF0108")
	private String uinf0108;
    /**
     * 居住地（市）
     */
	@TableField("UINF0109")
	private String uinf0109;
    /**
     * 居住地（区）
     */
	@TableField("UINF0110")
	private String uinf0110;
    /**
     * 家乡（省）
     */
	@TableField("UINF0111")
	private String uinf0111;
    /**
     * 家乡（市）
     */
	@TableField("UINF0112")
	private String uinf0112;
    /**
     * 家乡（区）
     */
	@TableField("UINF0113")
	private String uinf0113;
    /**
     * 头像地址
     */
	@TableField("UINF0114")
	private String uinf0114;
    /**
     * 昵称
     */
	@TableField("UINF0115")
	private String uinf0115;
    /**
     * 所属代理机构ID 
     */
	@TableField("UINF0116")
	private String uinf0116;
    /**
     * QQ号
     */
	@TableField("UINF0117")
	private String uinf0117;
    /**
     * 微信号
     */
	@TableField("UINF0118")
	private String uinf0118;


	public String getUinf0101() {
		return uinf0101;
	}

	public void setUinf0101(String uinf0101) {
		this.uinf0101 = uinf0101;
	}

	public String getUinf0102() {
		return uinf0102;
	}

	public void setUinf0102(String uinf0102) {
		this.uinf0102 = uinf0102;
	}

	public String getUinf0103() {
		return uinf0103;
	}

	public void setUinf0103(String uinf0103) {
		this.uinf0103 = uinf0103;
	}

	public String getUinf0104() {
		return uinf0104;
	}

	public void setUinf0104(String uinf0104) {
		this.uinf0104 = uinf0104;
	}

	public Date getUinf0105() {
		return uinf0105;
	}

	public void setUinf0105(Date uinf0105) {
		this.uinf0105 = uinf0105;
	}

	public String getUinf0106() {
		return uinf0106;
	}

	public void setUinf0106(String uinf0106) {
		this.uinf0106 = uinf0106;
	}

	public String getUinf0107() {
		return uinf0107;
	}

	public void setUinf0107(String uinf0107) {
		this.uinf0107 = uinf0107;
	}

	public String getUinf0108() {
		return uinf0108;
	}

	public void setUinf0108(String uinf0108) {
		this.uinf0108 = uinf0108;
	}

	public String getUinf0109() {
		return uinf0109;
	}

	public void setUinf0109(String uinf0109) {
		this.uinf0109 = uinf0109;
	}

	public String getUinf0110() {
		return uinf0110;
	}

	public void setUinf0110(String uinf0110) {
		this.uinf0110 = uinf0110;
	}

	public String getUinf0111() {
		return uinf0111;
	}

	public void setUinf0111(String uinf0111) {
		this.uinf0111 = uinf0111;
	}

	public String getUinf0112() {
		return uinf0112;
	}

	public void setUinf0112(String uinf0112) {
		this.uinf0112 = uinf0112;
	}

	public String getUinf0113() {
		return uinf0113;
	}

	public void setUinf0113(String uinf0113) {
		this.uinf0113 = uinf0113;
	}

	public String getUinf0114() {
		return uinf0114;
	}

	public void setUinf0114(String uinf0114) {
		this.uinf0114 = uinf0114;
	}

	public String getUinf0115() {
		return uinf0115;
	}

	public void setUinf0115(String uinf0115) {
		this.uinf0115 = uinf0115;
	}

	public String getUinf0116() {
		return uinf0116;
	}

	public void setUinf0116(String uinf0116) {
		this.uinf0116 = uinf0116;
	}

	public String getUinf0117() {
		return uinf0117;
	}

	public void setUinf0117(String uinf0117) {
		this.uinf0117 = uinf0117;
	}

	public String getUinf0118() {
		return uinf0118;
	}

	public void setUinf0118(String uinf0118) {
		this.uinf0118 = uinf0118;
	}

	@Override
	protected Serializable pkVal() {
		return this.uinf0101;
	}

	@Override
	public String toString() {
		return "Tbuserinfo{" +
			"uinf0101=" + uinf0101 +
			", uinf0102=" + uinf0102 +
			", uinf0103=" + uinf0103 +
			", uinf0104=" + uinf0104 +
			", uinf0105=" + uinf0105 +
			", uinf0106=" + uinf0106 +
			", uinf0107=" + uinf0107 +
			", uinf0108=" + uinf0108 +
			", uinf0109=" + uinf0109 +
			", uinf0110=" + uinf0110 +
			", uinf0111=" + uinf0111 +
			", uinf0112=" + uinf0112 +
			", uinf0113=" + uinf0113 +
			", uinf0114=" + uinf0114 +
			", uinf0115=" + uinf0115 +
			", uinf0116=" + uinf0116 +
			", uinf0117=" + uinf0117 +
			", uinf0118=" + uinf0118 +
			"}";
	}
}

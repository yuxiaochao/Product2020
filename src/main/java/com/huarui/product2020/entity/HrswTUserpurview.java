package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * ${table.comment}
 * </p>
 *
 * @author Chenrui
 * @since 2017-08-13
 */
@TableName("HRSW_T_USERPURVIEW")
public class HrswTUserpurview extends Model<HrswTUserpurview> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("UPUR001")
	private String upur001;
    /**
     * 用户id
     */
	@TableField("UPUR002")
	private String upur002;
    /**
     * 角色id
     */
	@TableField("UPUR003")
	private String upur003;
    /**
     * 功能模块id     用于临时授权
     */
	@TableField("UPUR004")
	private String upur004;
    /**
     * 授权人id
     */
	@TableField("UPUR005")
	private String upur005;
    /**
     * 授权时间
     */
	@TableField("UPUR006")
	private Date upur006;
    /**
     * 授权方式  1 自建自管;   2管理所有资源
     */
	@TableField("UPUR007")
	private Long upur007;
    /**
     * 状态  1 正常;2 禁用
     */
	@TableField("UPUR008")
	private Long upur008;
    /**
     * 所代表机构ID
     */
	@TableField("UPUR009")
	private String upur009;
	/**
	 * 类型 1、组织机构 2、职能机构
	 */
	@TableField("UPUR010")
	private Long upur010;
	/**
	 * 来源 1.运管单位 2.认证单位 3.报名单位
	 */
	@TableField("UPUR011")
	private Long upur011;
	/**
	 * 认证单位类型 默认-1 0 中电联 1省级鉴定中心 2市级鉴定站
	 */
	@TableField("UPUR012")
	private Long upur012;
	
	public String getUpur001() {
		return upur001;
	}

	public void setUpur001(String upur001) {
		this.upur001 = upur001;
	}

	public String getUpur002() {
		return upur002;
	}

	public void setUpur002(String upur002) {
		this.upur002 = upur002;
	}

	public String getUpur003() {
		return upur003;
	}

	public void setUpur003(String upur003) {
		this.upur003 = upur003;
	}

	public String getUpur004() {
		return upur004;
	}

	public void setUpur004(String upur004) {
		this.upur004 = upur004;
	}

	public String getUpur005() {
		return upur005;
	}

	public void setUpur005(String upur005) {
		this.upur005 = upur005;
	}

	public Date getUpur006() {
		return upur006;
	}

	public void setUpur006(Date upur006) {
		this.upur006 = upur006;
	}

	public Long getUpur007() {
		return upur007;
	}

	public void setUpur007(Long upur007) {
		this.upur007 = upur007;
	}

	public Long getUpur008() {
		return upur008;
	}

	public void setUpur008(Long upur008) {
		this.upur008 = upur008;
	}

	public String getUpur009() {
		return upur009;
	}

	public void setUpur009(String upur009) {
		this.upur009 = upur009;
	}

	public Long getUpur010() {
		return upur010;
	}

	public void setUpur010(Long upur010) {
		this.upur010 = upur010;
	}

	public Long getUpur011() {
		return upur011;
	}

	public void setUpur011(Long upur011) {
		this.upur011 = upur011;
	}

	public Long getUpur012() {
		return upur012;
	}

	public void setUpur012(Long upur012) {
		this.upur012 = upur012;
	}

	@Override
	protected Serializable pkVal() {
		return this.upur001;
	}

}

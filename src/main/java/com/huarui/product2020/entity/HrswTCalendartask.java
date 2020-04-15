package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author panlei
 * @since 2018-10-17
 */
@TableName("HRSW_T_CALENDARTASK")
public class HrswTCalendartask extends Model<HrswTCalendartask> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId("CALT001")
	private String calt001;
    /**
     * 任务内容
     */
	@TableField("CALT002")
	private String calt002;
    /**
     * 任务类型（数据字典）
     */
	@TableField("CALT003")
	private String calt003;
    /**
     * 任务地点
     */
	@TableField("CALT004")
	private String calt004;
    /**
     * 开始时间
     */
	@TableField("CALT005")
	private Date calt005;
    /**
     * 截止时间
     */
	@TableField("CALT006")
	private Date calt006;
    /**
     * 任务签到 1是 2否
     */
	@TableField("CALT007")
	private Integer calt007;
    /**
     * 创建时间
     */
	@TableField("CALT008")
	private Integer calt008;
    /**
     * 状态：1.正常 2.取消（删除）
     */
	@TableField("CALT009")
	private String calt009;
	@TableField("CALT010")
	private Date calt010;
	@TableField("CALT011")
	private Integer calt011;


	public String getCalt001() {
		return calt001;
	}

	public void setCalt001(String calt001) {
		this.calt001 = calt001;
	}

	public String getCalt002() {
		return calt002;
	}

	public void setCalt002(String calt002) {
		this.calt002 = calt002;
	}

	public String getCalt003() {
		return calt003;
	}

	public void setCalt003(String calt003) {
		this.calt003 = calt003;
	}

	public String getCalt004() {
		return calt004;
	}

	public void setCalt004(String calt004) {
		this.calt004 = calt004;
	}

	public Date getCalt005() {
		return calt005;
	}

	public void setCalt005(Date calt005) {
		this.calt005 = calt005;
	}

	public Date getCalt006() {
		return calt006;
	}

	public void setCalt006(Date calt006) {
		this.calt006 = calt006;
	}

	public Integer getCalt007() {
		return calt007;
	}

	public void setCalt007(Integer calt007) {
		this.calt007 = calt007;
	}

	public Integer getCalt008() {
		return calt008;
	}

	public void setCalt008(Integer calt008) {
		this.calt008 = calt008;
	}

	public String getCalt009() {
		return calt009;
	}

	public void setCalt009(String calt009) {
		this.calt009 = calt009;
	}

	public Date getCalt010() {
		return calt010;
	}

	public void setCalt010(Date calt010) {
		this.calt010 = calt010;
	}

	public Integer getCalt011() {
		return calt011;
	}

	public void setCalt011(Integer calt011) {
		this.calt011 = calt011;
	}

	@Override
	protected Serializable pkVal() {
		return this.calt001;
	}

	@Override
	public String toString() {
		return "HrswTCalendartask{" +
			"calt001=" + calt001 +
			", calt002=" + calt002 +
			", calt003=" + calt003 +
			", calt004=" + calt004 +
			", calt005=" + calt005 +
			", calt006=" + calt006 +
			", calt007=" + calt007 +
			", calt008=" + calt008 +
			", calt009=" + calt009 +
			", calt010=" + calt010 +
			", calt011=" + calt011 +
			"}";
	}
}

package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 餐厅资源
 * </p>
 *
 * @author caifenglin
 * @since 2020-01-06
 */
@TableName("HR_T_CANTEEN")
public class Canteen extends Model<Canteen> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("CANT001")
	private String cant001;
    /**
     * 餐厅编码
     */
	@TableField("CANT002")
	private String cant002;
    /**
     * 餐厅名称
     */
	@TableField("CANT003")
	private String cant003;
    /**
     * 可容纳人数
     */
	@TableField("CANT004")
	private Integer cant004;
    /**
     * 餐厅责任人
     */
	@TableField("CANT005")
	private String cant005;
    /**
     * 餐厅联系电话
     */
	@TableField("CANT006")
	private String cant006;
    /**
     * 备注
     */
	@TableField("CANT007")
	private String cant007;
    /**
     * 创建人id
     */
	@TableField("CANT008")
	private String cant008;
    /**
     * 创建时间
     */
	@TableField("CANT009")
	private Date cant009;
    /**
     * 最后修改时间
     */
	@TableField("CANT010")
	private Date cant010;
    /**
     * 餐厅介绍
     */
	@TableField("CANT011")
	private String cant011;
    /**
     * 餐厅地址
     */
	@TableField("CANT012")
	private String cant012;
    /**
     * 功能点
     */
	@TableField("CANT013")
	private String cant013;


	public String getCant001() {
		return cant001;
	}

	public void setCant001(String cant001) {
		this.cant001 = cant001;
	}

	public String getCant002() {
		return cant002;
	}

	public void setCant002(String cant002) {
		this.cant002 = cant002;
	}

	public String getCant003() {
		return cant003;
	}

	public void setCant003(String cant003) {
		this.cant003 = cant003;
	}

	public Integer getCant004() {
		return cant004;
	}

	public void setCant004(Integer cant004) {
		this.cant004 = cant004;
	}

	public String getCant005() {
		return cant005;
	}

	public void setCant005(String cant005) {
		this.cant005 = cant005;
	}

	public String getCant006() {
		return cant006;
	}

	public void setCant006(String cant006) {
		this.cant006 = cant006;
	}

	public String getCant007() {
		return cant007;
	}

	public void setCant007(String cant007) {
		this.cant007 = cant007;
	}

	public String getCant008() {
		return cant008;
	}

	public void setCant008(String cant008) {
		this.cant008 = cant008;
	}

	public Date getCant009() {
		return cant009;
	}

	public void setCant009(Date cant009) {
		this.cant009 = cant009;
	}

	public Date getCant010() {
		return cant010;
	}

	public void setCant010(Date cant010) {
		this.cant010 = cant010;
	}

	public String getCant011() {
		return cant011;
	}

	public void setCant011(String cant011) {
		this.cant011 = cant011;
	}

	public String getCant012() {
		return cant012;
	}

	public void setCant012(String cant012) {
		this.cant012 = cant012;
	}

	public String getCant013() {
		return cant013;
	}

	public void setCant013(String cant013) {
		this.cant013 = cant013;
	}

	@Override
	protected Serializable pkVal() {
		return this.cant001;
	}

	@Override
	public String toString() {
		return "Canteen{" +
			"cant001=" + cant001 +
			", cant002=" + cant002 +
			", cant003=" + cant003 +
			", cant004=" + cant004 +
			", cant005=" + cant005 +
			", cant006=" + cant006 +
			", cant007=" + cant007 +
			", cant008=" + cant008 +
			", cant009=" + cant009 +
			", cant010=" + cant010 +
			", cant011=" + cant011 +
			", cant012=" + cant012 +
			", cant013=" + cant013 +
			"}";
	}
}

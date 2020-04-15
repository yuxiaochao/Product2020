package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

import java.io.Serializable;

/**
 * <p>
 * 问卷试题候选项表
 * </p>
 *
 * @author pl
 * @since 2019-12-21
 */
public class Dcwj05 extends Model<Dcwj05> {

    private static final long serialVersionUID = 1L;

    /**
     * 	PK
     */
    @TableId("DCWJ0501")
	private String dcwj0501;
    /**
     * 	试题ID（DCWJ04）pk
     */
	@TableField("DCWJ0502")
	private String dcwj0502;
    /**
     * 	候选项
     */
	@TableField("DCWJ0503")
	private String dcwj0503;
    /**
     * 	候选项说明
     */
	@TableField("DCWJ0504")
	private String dcwj0504;
    /**
     * 	允许填空 0：否；1：是；
     */
	@TableField("DCWJ0505")
	private Double dcwj0505;
    /**
     * 填空是否必添 0：否；1：是；
     */
	@TableField("DCWJ0506")
	private Double dcwj0506;
    /**
     * 跳题ID（DCWJ04）
     */
	@TableField("DCWJ0507")
	private String dcwj0507;
    /**
     * 	分值
     */
	@TableField("DCWJ0508")
	private Double dcwj0508;
    /**
     * 类别 0：候选项；1：矩阵纵向；2：矩阵水平
     */
	@TableField("DCWJ0509")
	private Double dcwj0509;
    /**
     * 选项顺序
     */
	@TableField("DCWJ0510")
	private Double dcwj0510;
    /**
     * 	FK 自关联矩阵纵向ID
     */
	@TableField("DCWJ0511")
	private String dcwj0511;
	
	/**
     * 	选项图片地址
     */
	@TableField("DCWJ0512")
	private String dcwj0512;
	
	/**
	 * 是否删除 Y:是 N：否
	 */
	@TableField(exist = false)
	private String deleteFlag;



	public String getDcwj0501() {
		return dcwj0501;
	}

	public void setDcwj0501(String dcwj0501) {
		this.dcwj0501 = dcwj0501;
	}

	public String getDcwj0502() {
		return dcwj0502;
	}

	public void setDcwj0502(String dcwj0502) {
		this.dcwj0502 = dcwj0502;
	}

	public String getDcwj0503() {
		return dcwj0503;
	}

	public void setDcwj0503(String dcwj0503) {
		this.dcwj0503 = dcwj0503;
	}

	public String getDcwj0504() {
		return dcwj0504;
	}

	public void setDcwj0504(String dcwj0504) {
		this.dcwj0504 = dcwj0504;
	}

	public Double getDcwj0505() {
		return dcwj0505;
	}

	public void setDcwj0505(Double dcwj0505) {
		this.dcwj0505 = dcwj0505;
	}

	public Double getDcwj0506() {
		return dcwj0506;
	}

	public void setDcwj0506(Double dcwj0506) {
		this.dcwj0506 = dcwj0506;
	}

	public String getDcwj0507() {
		return dcwj0507;
	}

	public void setDcwj0507(String dcwj0507) {
		this.dcwj0507 = dcwj0507;
	}

	public Double getDcwj0508() {
		return dcwj0508;
	}

	public void setDcwj0508(Double dcwj0508) {
		this.dcwj0508 = dcwj0508;
	}

	public Double getDcwj0509() {
		return dcwj0509;
	}

	public void setDcwj0509(Double dcwj0509) {
		this.dcwj0509 = dcwj0509;
	}

	public Double getDcwj0510() {
		return dcwj0510;
	}

	public void setDcwj0510(Double dcwj0510) {
		this.dcwj0510 = dcwj0510;
	}

	public String getDcwj0511() {
		return dcwj0511;
	}

	public void setDcwj0511(String dcwj0511) {
		this.dcwj0511 = dcwj0511;
	}

	@Override
	protected Serializable pkVal() {
		return this.dcwj0501;
	}
	
	

	public String getDcwj0512() {
		return dcwj0512;
	}

	public void setDcwj0512(String dcwj0512) {
		this.dcwj0512 = dcwj0512;
	}

	
	public String getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	@Override
	public String toString() {
		return "Dcwj05{" +
			"dcwj0501=" + dcwj0501 +
			", dcwj0502=" + dcwj0502 +
			", dcwj0503=" + dcwj0503 +
			", dcwj0504=" + dcwj0504 +
			", dcwj0505=" + dcwj0505 +
			", dcwj0506=" + dcwj0506 +
			", dcwj0507=" + dcwj0507 +
			", dcwj0508=" + dcwj0508 +
			", dcwj0509=" + dcwj0509 +
			", dcwj0510=" + dcwj0510 +
			", dcwj0511=" + dcwj0511 +
			"}";
	}
}

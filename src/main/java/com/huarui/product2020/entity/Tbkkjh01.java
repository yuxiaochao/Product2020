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
 * @since 2019-10-25
 */
public class Tbkkjh01 extends Model<Tbkkjh01> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("KKJH0101")
	private String kkjh0101;
    /**
     * 类型0：正式计划；1：临增计划
     */
	@TableField("KKJH0102")
	private Double kkjh0102;
    /**
     * 名称
     */
	@TableField("KKJH0103")
	private String kkjh0103;
    /**
     * 开始时间
     */
	@TableField("KKJH0104")
	private Date kkjh0104;
    /**
     * 结束时间
     */
	@TableField("KKJH0105")
	private Date kkjh0105;
    /**
     * 类别0：工种；1：等级
     */
	@TableField("KKJH0106")
	private Double kkjh0106;
    /**
     * 委托单位
     */
	@TableField("KKJH0107")
	private String kkjh0107;
    /**
     * 委托人
     */
	@TableField("KKJH0108")
	private String kkjh0108;
    /**
     * 主办单位
     */
	@TableField("KKJH0109")
	private String kkjh0109;
    /**
     * 承办单位0：本级单位；1：下级单位
     */
	@TableField("KKJH0110")
	private Double kkjh0110;
    /**
     * 报名须知
     */
	@TableField("KKJH0111")
	private String kkjh0111;
    /**
     * 报名须知
     */
	@TableField("KKJH0112")
	private String kkjh0112;
    /**
     * 操作人
     */
	@TableField("KKJH0113")
	private String kkjh0113;
    /**
     * 说明
     */
	@TableField("KKJH0114")
	private String kkjh0114;
    /**
     * 创建时间
     */
	@TableField("KKJH0115")
	private Date kkjh0115;
    /**
     * 最后修改时间
     */
	@TableField("KKJH0116")
	private Date kkjh0116;
    /**
     * 状态
     */
	@TableField("KKJH0117")
	private Double kkjh0117;


	public String getKkjh0101() {
		return kkjh0101;
	}

	public void setKkjh0101(String kkjh0101) {
		this.kkjh0101 = kkjh0101;
	}

	public Double getKkjh0102() {
		return kkjh0102;
	}

	public void setKkjh0102(Double kkjh0102) {
		this.kkjh0102 = kkjh0102;
	}

	public String getKkjh0103() {
		return kkjh0103;
	}

	public void setKkjh0103(String kkjh0103) {
		this.kkjh0103 = kkjh0103;
	}

	public Date getKkjh0104() {
		return kkjh0104;
	}

	public void setKkjh0104(Date kkjh0104) {
		this.kkjh0104 = kkjh0104;
	}

	public Date getKkjh0105() {
		return kkjh0105;
	}

	public void setKkjh0105(Date kkjh0105) {
		this.kkjh0105 = kkjh0105;
	}

	public Double getKkjh0106() {
		return kkjh0106;
	}

	public void setKkjh0106(Double kkjh0106) {
		this.kkjh0106 = kkjh0106;
	}

	public String getKkjh0107() {
		return kkjh0107;
	}

	public void setKkjh0107(String kkjh0107) {
		this.kkjh0107 = kkjh0107;
	}

	public String getKkjh0108() {
		return kkjh0108;
	}

	public void setKkjh0108(String kkjh0108) {
		this.kkjh0108 = kkjh0108;
	}

	public String getKkjh0109() {
		return kkjh0109;
	}

	public void setKkjh0109(String kkjh0109) {
		this.kkjh0109 = kkjh0109;
	}

	public Double getKkjh0110() {
		return kkjh0110;
	}

	public void setKkjh0110(Double kkjh0110) {
		this.kkjh0110 = kkjh0110;
	}

	public String getKkjh0111() {
		return kkjh0111;
	}

	public void setKkjh0111(String kkjh0111) {
		this.kkjh0111 = kkjh0111;
	}

	public String getKkjh0112() {
		return kkjh0112;
	}

	public void setKkjh0112(String kkjh0112) {
		this.kkjh0112 = kkjh0112;
	}

	public String getKkjh0113() {
		return kkjh0113;
	}

	public void setKkjh0113(String kkjh0113) {
		this.kkjh0113 = kkjh0113;
	}

	public String getKkjh0114() {
		return kkjh0114;
	}

	public void setKkjh0114(String kkjh0114) {
		this.kkjh0114 = kkjh0114;
	}

	public Date getKkjh0115() {
		return kkjh0115;
	}

	public void setKkjh0115(Date kkjh0115) {
		this.kkjh0115 = kkjh0115;
	}

	public Date getKkjh0116() {
		return kkjh0116;
	}

	public void setKkjh0116(Date kkjh0116) {
		this.kkjh0116 = kkjh0116;
	}

	public Double getKkjh0117() {
		return kkjh0117;
	}

	public void setKkjh0117(Double kkjh0117) {
		this.kkjh0117 = kkjh0117;
	}

	@Override
	protected Serializable pkVal() {
		return this.kkjh0101;
	}

	@Override
	public String toString() {
		return "Tbkkjh01{" +
			"kkjh0101=" + kkjh0101 +
			", kkjh0102=" + kkjh0102 +
			", kkjh0103=" + kkjh0103 +
			", kkjh0104=" + kkjh0104 +
			", kkjh0105=" + kkjh0105 +
			", kkjh0106=" + kkjh0106 +
			", kkjh0107=" + kkjh0107 +
			", kkjh0108=" + kkjh0108 +
			", kkjh0109=" + kkjh0109 +
			", kkjh0110=" + kkjh0110 +
			", kkjh0111=" + kkjh0111 +
			", kkjh0112=" + kkjh0112 +
			", kkjh0113=" + kkjh0113 +
			", kkjh0114=" + kkjh0114 +
			", kkjh0115=" + kkjh0115 +
			", kkjh0116=" + kkjh0116 +
			", kkjh0117=" + kkjh0117 +
			"}";
	}
}

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
 * @author su
 * @since 2020-03-27
 */
public class Tbxxkgl01 extends Model<Tbxxkgl01> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("XXKGL0101")
	private String xxkgl0101;
    /**
     * 批次编码
     */
	@TableField("XXKGL0102")
	private String xxkgl0102;
    /**
     * 学习卡名称
     */
	@TableField("XXKGL0103")
	private String xxkgl0103;
    /**
     * 专业
     */
	@TableField("XXKGL0104")
	private String xxkgl0104;
    /**
     * 学习卡标识
     */
	@TableField("XXKGL0105")
	private String xxkgl0105;
    /**
     * 是否序号生卡
     */
	@TableField("XXKGL0106")
	private String xxkgl0106;
    /**
     * 套包卡卡位
     */
	@TableField("XXKGL0107")
	private Double xxkgl0107;
    /**
     * 生成数量
     */
	@TableField("XXKGL0108")
	private Double xxkgl0108;
    /**
     * 优惠价
     */
	@TableField("XXKGL0109")
	private Double xxkgl0109;
    /**
     * 限制使用开始时间
     */
	@TableField("XXKGL0110")
	private Date xxkgl0110;
    /**
     * 限制使用结束时间
     */
	@TableField("XXKGL0111")
	private Date xxkgl0111;
    /**
     * 有效截止时间
     */
	@TableField("XXKGL0112")
	private Date xxkgl0112;
    /**
     * 学习卡密码格式：0:数字 1: 数字+字母
     */
	@TableField("XXKGL0113")
	private Double xxkgl0113;
    /**
     * 密码位数
     */
	@TableField("XXKGL0114")
	private Double xxkgl0114;
    /**
     * 状态：0:待生成 1:已生成 2:作废 3:失效
     */
	@TableField("XXKGL0115")
	private Double xxkgl0115;
    /**
     * 创建时间
     */
	@TableField("XXKGL0116")
	private Date xxkgl0116;
    /**
     * 最后修改时间
     */
	@TableField("XXKGL0117")
	private Date xxkgl0117;
    /**
     * 创建人
     */
	@TableField("XXKGL0118")
	private String xxkgl0118;
    /**
     * 试听时长（用于试听卡）
     */
	@TableField("XXKGL0119")
	private Double xxkgl0119;
    /**
     * 卡类型：0 学习卡；1 试听卡
     */
	@TableField("XXKGL0120")
	private Double xxkgl0120;


	public String getXxkgl0101() {
		return xxkgl0101;
	}

	public void setXxkgl0101(String xxkgl0101) {
		this.xxkgl0101 = xxkgl0101;
	}

	public String getXxkgl0102() {
		return xxkgl0102;
	}

	public void setXxkgl0102(String xxkgl0102) {
		this.xxkgl0102 = xxkgl0102;
	}

	public String getXxkgl0103() {
		return xxkgl0103;
	}

	public void setXxkgl0103(String xxkgl0103) {
		this.xxkgl0103 = xxkgl0103;
	}

	public String getXxkgl0104() {
		return xxkgl0104;
	}

	public void setXxkgl0104(String xxkgl0104) {
		this.xxkgl0104 = xxkgl0104;
	}

	public String getXxkgl0105() {
		return xxkgl0105;
	}

	public void setXxkgl0105(String xxkgl0105) {
		this.xxkgl0105 = xxkgl0105;
	}

	public String getXxkgl0106() {
		return xxkgl0106;
	}

	public void setXxkgl0106(String xxkgl0106) {
		this.xxkgl0106 = xxkgl0106;
	}

	public Double getXxkgl0107() {
		return xxkgl0107;
	}

	public void setXxkgl0107(Double xxkgl0107) {
		this.xxkgl0107 = xxkgl0107;
	}

	public Double getXxkgl0108() {
		return xxkgl0108;
	}

	public void setXxkgl0108(Double xxkgl0108) {
		this.xxkgl0108 = xxkgl0108;
	}

	public Double getXxkgl0109() {
		return xxkgl0109;
	}

	public void setXxkgl0109(Double xxkgl0109) {
		this.xxkgl0109 = xxkgl0109;
	}

	public Date getXxkgl0110() {
		return xxkgl0110;
	}

	public void setXxkgl0110(Date xxkgl0110) {
		this.xxkgl0110 = xxkgl0110;
	}

	public Date getXxkgl0111() {
		return xxkgl0111;
	}

	public void setXxkgl0111(Date xxkgl0111) {
		this.xxkgl0111 = xxkgl0111;
	}

	public Date getXxkgl0112() {
		return xxkgl0112;
	}

	public void setXxkgl0112(Date xxkgl0112) {
		this.xxkgl0112 = xxkgl0112;
	}

	public Double getXxkgl0113() {
		return xxkgl0113;
	}

	public void setXxkgl0113(Double xxkgl0113) {
		this.xxkgl0113 = xxkgl0113;
	}

	public Double getXxkgl0114() {
		return xxkgl0114;
	}

	public void setXxkgl0114(Double xxkgl0114) {
		this.xxkgl0114 = xxkgl0114;
	}

	public Double getXxkgl0115() {
		return xxkgl0115;
	}

	public void setXxkgl0115(Double xxkgl0115) {
		this.xxkgl0115 = xxkgl0115;
	}

	public Date getXxkgl0116() {
		return xxkgl0116;
	}

	public void setXxkgl0116(Date xxkgl0116) {
		this.xxkgl0116 = xxkgl0116;
	}

	public Date getXxkgl0117() {
		return xxkgl0117;
	}

	public void setXxkgl0117(Date xxkgl0117) {
		this.xxkgl0117 = xxkgl0117;
	}

	public String getXxkgl0118() {
		return xxkgl0118;
	}

	public void setXxkgl0118(String xxkgl0118) {
		this.xxkgl0118 = xxkgl0118;
	}

	public Double getXxkgl0119() {
		return xxkgl0119;
	}

	public void setXxkgl0119(Double xxkgl0119) {
		this.xxkgl0119 = xxkgl0119;
	}

	public Double getXxkgl0120() {
		return xxkgl0120;
	}

	public void setXxkgl0120(Double xxkgl0120) {
		this.xxkgl0120 = xxkgl0120;
	}

	@Override
	protected Serializable pkVal() {
		return this.xxkgl0101;
	}

	@Override
	public String toString() {
		return "Tbxxkgl01{" +
			"xxkgl0101=" + xxkgl0101 +
			", xxkgl0102=" + xxkgl0102 +
			", xxkgl0103=" + xxkgl0103 +
			", xxkgl0104=" + xxkgl0104 +
			", xxkgl0105=" + xxkgl0105 +
			", xxkgl0106=" + xxkgl0106 +
			", xxkgl0107=" + xxkgl0107 +
			", xxkgl0108=" + xxkgl0108 +
			", xxkgl0109=" + xxkgl0109 +
			", xxkgl0110=" + xxkgl0110 +
			", xxkgl0111=" + xxkgl0111 +
			", xxkgl0112=" + xxkgl0112 +
			", xxkgl0113=" + xxkgl0113 +
			", xxkgl0114=" + xxkgl0114 +
			", xxkgl0115=" + xxkgl0115 +
			", xxkgl0116=" + xxkgl0116 +
			", xxkgl0117=" + xxkgl0117 +
			", xxkgl0118=" + xxkgl0118 +
			", xxkgl0119=" + xxkgl0119 +
			", xxkgl0120=" + xxkgl0120 +
			"}";
	}
}

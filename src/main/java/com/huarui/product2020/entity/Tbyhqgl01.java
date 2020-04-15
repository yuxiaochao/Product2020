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
 * @author panlei
 * @since 2020-04-07
 */
public class Tbyhqgl01 extends Model<Tbyhqgl01> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("YHQGL0101")
	private String yhqgl0101;
    /**
     * 批次编码
     */
	@TableField("YHQGL0102")
	private String yhqgl0102;
    /**
     * 优惠券名称
     */
	@TableField("YHQGL0103")
	private String yhqgl0103;
    /**
     * 专业
     */
	@TableField("YHQGL0104")
	private String yhqgl0104;
    /**
     * 优惠券标识
     */
	@TableField("YHQGL0105")
	private String yhqgl0105;
    /**
     * 是否序号生卡
     */
	@TableField("YHQGL0106")
	private String yhqgl0106;
    /**
     * 套包卡卡位
     */
	@TableField("YHQGL0107")
	private Double yhqgl0107;
    /**
     * 生成数量
     */
	@TableField("YHQGL0108")
	private Double yhqgl0108;
    /**
     * 优惠价
     */
	@TableField("YHQGL0109")
	private Double yhqgl0109;
    /**
     * 限制使用开始时间
     */
	@TableField("YHQGL0110")
	private Date yhqgl0110;
    /**
     * 限制使用结束时间
     */
	@TableField("YHQGL0111")
	private Date yhqgl0111;
    /**
     * 有效截止时间
     */
	@TableField("YHQGL0112")
	private Date yhqgl0112;
    /**
     * 优惠券密码格式：0:数字 1: 数字+字母
     */
	@TableField("YHQGL0113")
	private Double yhqgl0113;
    /**
     * 密码位数
     */
	@TableField("YHQGL0114")
	private Double yhqgl0114;
    /**
     * 0:全部商品   1.指定商品
     */
	@TableField("YHQGL0115")
	private Double yhqgl0115;
    /**
     * 状态：0:待生成 1:已生成 2:作废 3:失效
     */
	@TableField("YHQGL0116")
	private Double yhqgl0116;
    /**
     * 创建时间
     */
	@TableField("YHQGL0117")
	private Date yhqgl0117;
    /**
     * 最后修改时间
     */
	@TableField("YHQGL0118")
	private Date yhqgl0118;
    /**
     * 创建人
     */
	@TableField("YHQGL0119")
	private String yhqgl0119;
    /**
     * 优惠券类型  1.购课优惠券
     */
	@TableField("YHQGL0120")
	private Double yhqgl0120;


	public String getYhqgl0101() {
		return yhqgl0101;
	}

	public void setYhqgl0101(String yhqgl0101) {
		this.yhqgl0101 = yhqgl0101;
	}

	public String getYhqgl0102() {
		return yhqgl0102;
	}

	public void setYhqgl0102(String yhqgl0102) {
		this.yhqgl0102 = yhqgl0102;
	}

	public String getYhqgl0103() {
		return yhqgl0103;
	}

	public void setYhqgl0103(String yhqgl0103) {
		this.yhqgl0103 = yhqgl0103;
	}

	public String getYhqgl0104() {
		return yhqgl0104;
	}

	public void setYhqgl0104(String yhqgl0104) {
		this.yhqgl0104 = yhqgl0104;
	}

	public String getYhqgl0105() {
		return yhqgl0105;
	}

	public void setYhqgl0105(String yhqgl0105) {
		this.yhqgl0105 = yhqgl0105;
	}

	public String getYhqgl0106() {
		return yhqgl0106;
	}

	public void setYhqgl0106(String yhqgl0106) {
		this.yhqgl0106 = yhqgl0106;
	}

	public Double getYhqgl0107() {
		return yhqgl0107;
	}

	public void setYhqgl0107(Double yhqgl0107) {
		this.yhqgl0107 = yhqgl0107;
	}

	public Double getYhqgl0108() {
		return yhqgl0108;
	}

	public void setYhqgl0108(Double yhqgl0108) {
		this.yhqgl0108 = yhqgl0108;
	}

	public Double getYhqgl0109() {
		return yhqgl0109;
	}

	public void setYhqgl0109(Double yhqgl0109) {
		this.yhqgl0109 = yhqgl0109;
	}

	public Date getYhqgl0110() {
		return yhqgl0110;
	}

	public void setYhqgl0110(Date yhqgl0110) {
		this.yhqgl0110 = yhqgl0110;
	}

	public Date getYhqgl0111() {
		return yhqgl0111;
	}

	public void setYhqgl0111(Date yhqgl0111) {
		this.yhqgl0111 = yhqgl0111;
	}

	public Date getYhqgl0112() {
		return yhqgl0112;
	}

	public void setYhqgl0112(Date yhqgl0112) {
		this.yhqgl0112 = yhqgl0112;
	}

	public Double getYhqgl0113() {
		return yhqgl0113;
	}

	public void setYhqgl0113(Double yhqgl0113) {
		this.yhqgl0113 = yhqgl0113;
	}

	public Double getYhqgl0114() {
		return yhqgl0114;
	}

	public void setYhqgl0114(Double yhqgl0114) {
		this.yhqgl0114 = yhqgl0114;
	}

	public Double getYhqgl0115() {
		return yhqgl0115;
	}

	public void setYhqgl0115(Double yhqgl0115) {
		this.yhqgl0115 = yhqgl0115;
	}

	public Double getYhqgl0116() {
		return yhqgl0116;
	}

	public void setYhqgl0116(Double yhqgl0116) {
		this.yhqgl0116 = yhqgl0116;
	}

	public Date getYhqgl0117() {
		return yhqgl0117;
	}

	public void setYhqgl0117(Date yhqgl0117) {
		this.yhqgl0117 = yhqgl0117;
	}

	public Date getYhqgl0118() {
		return yhqgl0118;
	}

	public void setYhqgl0118(Date yhqgl0118) {
		this.yhqgl0118 = yhqgl0118;
	}

	public String getYhqgl0119() {
		return yhqgl0119;
	}

	public void setYhqgl0119(String yhqgl0119) {
		this.yhqgl0119 = yhqgl0119;
	}

	public Double getYhqgl0120() {
		return yhqgl0120;
	}

	public void setYhqgl0120(Double yhqgl0120) {
		this.yhqgl0120 = yhqgl0120;
	}

	@Override
	protected Serializable pkVal() {
		return this.yhqgl0101;
	}

	@Override
	public String toString() {
		return "Tbyhqgl01{" +
			"yhqgl0101=" + yhqgl0101 +
			", yhqgl0102=" + yhqgl0102 +
			", yhqgl0103=" + yhqgl0103 +
			", yhqgl0104=" + yhqgl0104 +
			", yhqgl0105=" + yhqgl0105 +
			", yhqgl0106=" + yhqgl0106 +
			", yhqgl0107=" + yhqgl0107 +
			", yhqgl0108=" + yhqgl0108 +
			", yhqgl0109=" + yhqgl0109 +
			", yhqgl0110=" + yhqgl0110 +
			", yhqgl0111=" + yhqgl0111 +
			", yhqgl0112=" + yhqgl0112 +
			", yhqgl0113=" + yhqgl0113 +
			", yhqgl0114=" + yhqgl0114 +
			", yhqgl0115=" + yhqgl0115 +
			", yhqgl0116=" + yhqgl0116 +
			", yhqgl0117=" + yhqgl0117 +
			", yhqgl0118=" + yhqgl0118 +
			", yhqgl0119=" + yhqgl0119 +
			", yhqgl0120=" + yhqgl0120 +
			"}";
	}
}

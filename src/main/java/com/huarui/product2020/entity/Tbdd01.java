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
 * @since 2020-02-18
 */
public class Tbdd01 extends Model<Tbdd01> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("DD0101")
	private String dd0101;
    /**
     * 用户ID
     */
	@TableField("DD0102")
	private String dd0102;
    /**
     * 购物车ID tbGWC01主键
     */
	@TableField("DD0103")
	private String dd0103;
    /**
     * 订单编号
     */
	@TableField("DD0104")
	private String dd0104;
    /**
     * 创建时间
     */
	@TableField("DD0105")
	private Date dd0105;
    /**
     * 状态0：待付款；1：已付款；2：已取消；3：已失效
     */
	@TableField("DD0106")
	private Double dd0106;
    /**
     * 订单金额
     */
	@TableField("DD0107")
	private Double dd0107;

	  /**
     * 微信支付二维码
     */
	@TableField("DD0108")
	private String dd0108;
	
	  /**
     * 代理机构ID
     */
	@TableField("DD0109")
	private String dd0109;
	
	  /**
     * 优惠后金额（使用优惠券或促销活动价格）
     */
	@TableField("DD0110")
	private Double dd0110;
	
	  /**
     * 	实付金额
     */
	@TableField("DD0111")
	private Double dd0111;
	
	/**
	 * 商品名称
	 */
	@TableField(exist = false)
	private String cmdy0306;
	
	/**
	 * 支付费用
	 * @return
	 */
	@TableField(exist = false)
	private String dd0204;
	
	/**
	 * 订单截止时间
	 * @return
	 */
	@TableField(exist = false)
	private String dd0105t;
	
	/**
	 * 支付方式
	 * @return
	 */
	@TableField(exist = false)
	private String dd0205;
	
	/**
	 * 订单状态
	 * @return
	 */
	@TableField(exist = false)
	private String dd0106t;

	public String getDd0101() {
		return dd0101;
	}

	public void setDd0101(String dd0101) {
		this.dd0101 = dd0101;
	}

	public String getDd0102() {
		return dd0102;
	}

	public void setDd0102(String dd0102) {
		this.dd0102 = dd0102;
	}

	public String getDd0103() {
		return dd0103;
	}

	public void setDd0103(String dd0103) {
		this.dd0103 = dd0103;
	}

	public String getDd0104() {
		return dd0104;
	}

	public void setDd0104(String dd0104) {
		this.dd0104 = dd0104;
	}

	public Date getDd0105() {
		return dd0105;
	}

	public void setDd0105(Date dd0105) {
		this.dd0105 = dd0105;
	}

	public Double getDd0106() {
		return dd0106;
	}

	public void setDd0106(Double dd0106) {
		this.dd0106 = dd0106;
	}

	

	public Double getDd0107() {
		return dd0107;
	}

	public void setDd0107(Double dd0107) {
		this.dd0107 = dd0107;
	}
	
	

	public String getDd0108() {
		return dd0108;
	}

	public void setDd0108(String dd0108) {
		this.dd0108 = dd0108;
	}

	@Override
	protected Serializable pkVal() {
		return this.dd0101;
	}
	
	

	public String getCmdy0306() {
		return cmdy0306;
	}

	public void setCmdy0306(String cmdy0306) {
		this.cmdy0306 = cmdy0306;
	}

	public String getDd0204() {
		return dd0204;
	}

	public void setDd0204(String dd0204) {
		this.dd0204 = dd0204;
	}

	public String getDd0105t() {
		return dd0105t;
	}

	public void setDd0105t(String dd0105t) {
		this.dd0105t = dd0105t;
	}

	public String getDd0205() {
		return dd0205;
	}

	public void setDd0205(String dd0205) {
		this.dd0205 = dd0205;
	}

	public String getDd0106t() {
		return dd0106t;
	}

	public void setDd0106t(String dd0106t) {
		this.dd0106t = dd0106t;
	}

	
	public String getDd0109() {
		return dd0109;
	}

	public void setDd0109(String dd0109) {
		this.dd0109 = dd0109;
	}

	
	public Double getDd0110() {
		return dd0110;
	}

	public void setDd0110(Double dd0110) {
		this.dd0110 = dd0110;
	}

	public Double getDd0111() {
		return dd0111;
	}

	public void setDd0111(Double dd0111) {
		this.dd0111 = dd0111;
	}

	@Override
	public String toString() {
		return "Tbdd01{" +
			"dd0101=" + dd0101 +
			", dd0102=" + dd0102 +
			", dd0103=" + dd0103 +
			", dd0104=" + dd0104 +
			", dd0105=" + dd0105 +
			", dd0106=" + dd0106 +
			", dd0107=" + dd0107 +
			", dd0108=" + dd0108 +
			", dd0109=" + dd0109 +
			", dd0110=" + dd0110 +
			", dd0111=" + dd0111 +
			"}";
	}
}

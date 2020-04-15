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
public class Tbdd02 extends Model<Tbdd02> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("DD0201")
	private String dd0201;
    /**
     * 订单ID tbDD01主键
     */
	@TableField("DD0202")
	private String dd0202;
    /**
     * 购物车ID tbGWC01主键
     */
	@TableField("DD0203")
	private String dd0203;
    /**
     * 支付费用
     */
	@TableField("DD0204")
	private Double dd0204;
    /**
     * 支付方式 0：支付宝；1：微信；2：网银
     */
	@TableField("DD0205")
	private Double dd0205;

	/**
	 * 支付时间
	 */
	@TableField("DD0206")
	private Date dd0206;

	public String getDd0201() {
		return dd0201;
	}

	public void setDd0201(String dd0201) {
		this.dd0201 = dd0201;
	}

	public String getDd0202() {
		return dd0202;
	}

	public void setDd0202(String dd0202) {
		this.dd0202 = dd0202;
	}

	public String getDd0203() {
		return dd0203;
	}

	public void setDd0203(String dd0203) {
		this.dd0203 = dd0203;
	}

	public Double getDd0204() {
		return dd0204;
	}

	public void setDd0204(Double dd0204) {
		this.dd0204 = dd0204;
	}

	public Double getDd0205() {
		return dd0205;
	}

	public void setDd0205(Double dd0205) {
		this.dd0205 = dd0205;
	}

	@Override
	protected Serializable pkVal() {
		return this.dd0201;
	}
	
	

	public Date getDd0206() {
		return dd0206;
	}

	public void setDd0206(Date dd0206) {
		this.dd0206 = dd0206;
	}

	@Override
	public String toString() {
		return "Tbdd02{" +
			"dd0201=" + dd0201 +
			", dd0202=" + dd0202 +
			", dd0203=" + dd0203 +
			", dd0204=" + dd0204 +
			", dd0205=" + dd0205 +
			", dd0206=" + dd0206 +
			"}";
	}
}

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
public class Tbgwc02 extends Model<Tbgwc02> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("GWC0201")
	private String gwc0201;
    /**
     * 基础信息ID tbGWC01主键
     */
	@TableField("GWC0202")
	private String gwc0202;
    /**
     * 商品包ID
     */
	@TableField("GWC0203")
	private String gwc0203;
    /**
     * 商品ID
     */
	@TableField("GWC0204")
	private String gwc0204;
    /**
     * 价格
     */
	@TableField("GWC0205")
	private Double gwc0205;
    /**
     * 数量
     */
	@TableField("GWC0206")
	private Double gwc0206;
    /**
     * 加入时间
     */
	@TableField("GWC0207")
	private Date gwc0207;
    /**
     * 购物车ID
     */
	@TableField("GWC0208")
	private String gwc0208;

    /**
     * 	优惠后价格
     */
	@TableField("GWC0209")
	private Double gwc0209;
	
    /**
     * 	购买时价格
     */
	@TableField("GWC0210")
	private Double gwc0210;
	
	 /**
     * 	促销活动id
     */
	@TableField("GWC0211")
	private String gwc0211;
	
	 /**
     * 	订单id
     */
	@TableField("GWC0212")
	private String gwc0212;

	public String getGwc0201() {
		return gwc0201;
	}

	public void setGwc0201(String gwc0201) {
		this.gwc0201 = gwc0201;
	}

	public String getGwc0202() {
		return gwc0202;
	}

	public void setGwc0202(String gwc0202) {
		this.gwc0202 = gwc0202;
	}

	public String getGwc0203() {
		return gwc0203;
	}

	public void setGwc0203(String gwc0203) {
		this.gwc0203 = gwc0203;
	}

	public String getGwc0204() {
		return gwc0204;
	}

	public void setGwc0204(String gwc0204) {
		this.gwc0204 = gwc0204;
	}

	public Double getGwc0205() {
		return gwc0205;
	}

	public void setGwc0205(Double gwc0205) {
		this.gwc0205 = gwc0205;
	}

	public Double getGwc0206() {
		return gwc0206;
	}

	public void setGwc0206(Double gwc0206) {
		this.gwc0206 = gwc0206;
	}

	public Date getGwc0207() {
		return gwc0207;
	}

	public void setGwc0207(Date gwc0207) {
		this.gwc0207 = gwc0207;
	}

	public String getGwc0208() {
		return gwc0208;
	}

	public void setGwc0208(String gwc0208) {
		this.gwc0208 = gwc0208;
	}

	@Override
	protected Serializable pkVal() {
		return this.gwc0201;
	}
	
	

	public Double getGwc0209() {
		return gwc0209;
	}

	public void setGwc0209(Double gwc0209) {
		this.gwc0209 = gwc0209;
	}

	public Double getGwc0210() {
		return gwc0210;
	}

	public void setGwc0210(Double gwc0210) {
		this.gwc0210 = gwc0210;
	}
	
	

	public String getGwc0211() {
		return gwc0211;
	}

	public void setGwc0211(String gwc0211) {
		this.gwc0211 = gwc0211;
	}
	
	

	
	public String getGwc0212() {
		return gwc0212;
	}

	public void setGwc0212(String gwc0212) {
		this.gwc0212 = gwc0212;
	}

	@Override
	public String toString() {
		return "Tbgwc02{" +
			"gwc0201=" + gwc0201 +
			", gwc0202=" + gwc0202 +
			", gwc0203=" + gwc0203 +
			", gwc0204=" + gwc0204 +
			", gwc0205=" + gwc0205 +
			", gwc0206=" + gwc0206 +
			", gwc0207=" + gwc0207 +
			", gwc0208=" + gwc0208 +
			", gwc0209=" + gwc0209 +
			", gwc0210=" + gwc0210 +
			", gwc0211=" + gwc0211 +
			", gwc0212=" + gwc0212 +
			"}";
	}
}

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
public class Tbxxkgl03 extends Model<Tbxxkgl03> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("XXKGL0301")
	private String xxkgl0301;
    /**
     * 学习卡ID
     */
	@TableField("XXKGL0302")
	private String xxkgl0302;
    /**
     * 卡号
     */
	@TableField("XXKGL0303")
	private String xxkgl0303;
    /**
     * 密码
     */
	@TableField("XXKGL0304")
	private String xxkgl0304;
    /**
     * 生成时间
     */
	@TableField("XXKGL0305")
	private Date xxkgl0305;

	//学习卡激活状态
	private Integer xxkgl0704n;
	//卡类型:0、学习卡；1、试听卡
	private Integer xxkgl0120n;
	//有效期
	private Date xxkgl0112n;
	//
	private String userId;
	
	/**
	 * 卡类型：0 学习卡；1 试听卡  2 管理员分配  3 天猫商品自动开卡
	 */
	private Integer cardType;
	
	
	
	
	public String getXxkgl0301() {
		return xxkgl0301;
	}

	public void setXxkgl0301(String xxkgl0301) {
		this.xxkgl0301 = xxkgl0301;
	}

	public String getXxkgl0302() {
		return xxkgl0302;
	}

	public void setXxkgl0302(String xxkgl0302) {
		this.xxkgl0302 = xxkgl0302;
	}

	public String getXxkgl0303() {
		return xxkgl0303;
	}

	public void setXxkgl0303(String xxkgl0303) {
		this.xxkgl0303 = xxkgl0303;
	}

	public String getXxkgl0304() {
		return xxkgl0304;
	}

	public void setXxkgl0304(String xxkgl0304) {
		this.xxkgl0304 = xxkgl0304;
	}

	public Date getXxkgl0305() {
		return xxkgl0305;
	}

	public void setXxkgl0305(Date xxkgl0305) {
		this.xxkgl0305 = xxkgl0305;
	}

	public Integer getXxkgl0704n() {
		return xxkgl0704n;
	}

	public void setXxkgl0704n(Integer xxkgl0704n) {
		this.xxkgl0704n = xxkgl0704n;
	}

	
	public Integer getXxkgl0120n() {
		return xxkgl0120n;
	}

	public void setXxkgl0120n(Integer xxkgl0120n) {
		this.xxkgl0120n = xxkgl0120n;
	}

	public Date getXxkgl0112n() {
		return xxkgl0112n;
	}

	public void setXxkgl0112n(Date xxkgl0112n) {
		this.xxkgl0112n = xxkgl0112n;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	protected Serializable pkVal() {
		return this.xxkgl0301;
	}
	
	

	public Integer getCardType() {
		return cardType;
	}

	public void setCardType(Integer cardType) {
		this.cardType = cardType;
	}

	@Override
	public String toString() {
		return "Tbxxkgl03{" +
			"xxkgl0301=" + xxkgl0301 +
			", xxkgl0302=" + xxkgl0302 +
			", xxkgl0303=" + xxkgl0303 +
			", xxkgl0304=" + xxkgl0304 +
			", xxkgl0305=" + xxkgl0305 +
			"}";
	}
}

package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author panlei
 * @since 2020-04-07
 */
public class Tbyhqgl08 extends Model<Tbyhqgl08> {

    private static final long serialVersionUID = 1L;

    @TableId("YHQGL0801")
	private String yhqgl0801;
    /**
     * 下发卡号表ID
     */
	@TableField("YHQGL0802")
	private String yhqgl0802;
    /**
     * 优惠券ID
     */
	@TableField("YHQGL0803")
	private String yhqgl0803;
    /**
     * 套包ID （tbCMDY06）
     */
	@TableField("YHQGL0804")
	private String yhqgl0804;
    /**
     * 商品ID （tbCMDY07）
     */
	@TableField("YHQGL0805")
	private String yhqgl0805;


	public String getYhqgl0801() {
		return yhqgl0801;
	}

	public void setYhqgl0801(String yhqgl0801) {
		this.yhqgl0801 = yhqgl0801;
	}

	public String getYhqgl0802() {
		return yhqgl0802;
	}

	public void setYhqgl0802(String yhqgl0802) {
		this.yhqgl0802 = yhqgl0802;
	}

	public String getYhqgl0803() {
		return yhqgl0803;
	}

	public void setYhqgl0803(String yhqgl0803) {
		this.yhqgl0803 = yhqgl0803;
	}

	public String getYhqgl0804() {
		return yhqgl0804;
	}

	public void setYhqgl0804(String yhqgl0804) {
		this.yhqgl0804 = yhqgl0804;
	}

	public String getYhqgl0805() {
		return yhqgl0805;
	}

	public void setYhqgl0805(String yhqgl0805) {
		this.yhqgl0805 = yhqgl0805;
	}

	@Override
	protected Serializable pkVal() {
		return this.yhqgl0801;
	}

	@Override
	public String toString() {
		return "Tbyhqgl08{" +
			"yhqgl0801=" + yhqgl0801 +
			", yhqgl0802=" + yhqgl0802 +
			", yhqgl0803=" + yhqgl0803 +
			", yhqgl0804=" + yhqgl0804 +
			", yhqgl0805=" + yhqgl0805 +
			"}";
	}
}

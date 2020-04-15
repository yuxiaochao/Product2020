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
public class Tbyhqgl06 extends Model<Tbyhqgl06> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("YHQGL0601")
	private String yhqgl0601;
    /**
     * 优惠券下发ID：tbYHQGL04
     */
	@TableField("YHQGL0602")
	private String yhqgl0602;
    /**
     * 优惠券ID：tbYHQGL01
     */
	@TableField("YHQGL0603")
	private String yhqgl0603;


	public String getYhqgl0601() {
		return yhqgl0601;
	}

	public void setYhqgl0601(String yhqgl0601) {
		this.yhqgl0601 = yhqgl0601;
	}

	public String getYhqgl0602() {
		return yhqgl0602;
	}

	public void setYhqgl0602(String yhqgl0602) {
		this.yhqgl0602 = yhqgl0602;
	}

	public String getYhqgl0603() {
		return yhqgl0603;
	}

	public void setYhqgl0603(String yhqgl0603) {
		this.yhqgl0603 = yhqgl0603;
	}

	@Override
	protected Serializable pkVal() {
		return this.yhqgl0601;
	}

	@Override
	public String toString() {
		return "Tbyhqgl06{" +
			"yhqgl0601=" + yhqgl0601 +
			", yhqgl0602=" + yhqgl0602 +
			", yhqgl0603=" + yhqgl0603 +
			"}";
	}
}

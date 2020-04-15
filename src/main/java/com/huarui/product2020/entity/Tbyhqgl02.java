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
public class Tbyhqgl02 extends Model<Tbyhqgl02> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("YHQGL0201")
	private String yhqgl0201;
    /**
     * 优惠券ID
     */
	@TableField("YHQGL0202")
	private String yhqgl0202;
    /**
     * 套包ID：tbCMDY06
     */
	@TableField("YHQGL0203")
	private String yhqgl0203;
    /**
     * 套包与商品关联ID：tbCMDY07
     */
	@TableField("YHQGL0204")
	private String yhqgl0204;


	public String getYhqgl0201() {
		return yhqgl0201;
	}

	public void setYhqgl0201(String yhqgl0201) {
		this.yhqgl0201 = yhqgl0201;
	}

	public String getYhqgl0202() {
		return yhqgl0202;
	}

	public void setYhqgl0202(String yhqgl0202) {
		this.yhqgl0202 = yhqgl0202;
	}

	public String getYhqgl0203() {
		return yhqgl0203;
	}

	public void setYhqgl0203(String yhqgl0203) {
		this.yhqgl0203 = yhqgl0203;
	}

	public String getYhqgl0204() {
		return yhqgl0204;
	}

	public void setYhqgl0204(String yhqgl0204) {
		this.yhqgl0204 = yhqgl0204;
	}

	@Override
	protected Serializable pkVal() {
		return this.yhqgl0201;
	}

	@Override
	public String toString() {
		return "Tbyhqgl02{" +
			"yhqgl0201=" + yhqgl0201 +
			", yhqgl0202=" + yhqgl0202 +
			", yhqgl0203=" + yhqgl0203 +
			", yhqgl0204=" + yhqgl0204 +
			"}";
	}
}

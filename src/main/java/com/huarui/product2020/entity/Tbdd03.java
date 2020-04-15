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
 * @since 2020-02-18
 */
public class Tbdd03 extends Model<Tbdd03> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("DD0301")
	private String dd0301;
    /**
     * 订单ID tbDD01主键
     */
	@TableField("DD0302")
	private String dd0302;
    /**
     * 购物车ID tbGWC01主键
     */
	@TableField("DD0303")
	private String dd0303;
    /**
     * 优惠券ID
     */
	@TableField("DD0304")
	private String dd0304;


	public String getDd0301() {
		return dd0301;
	}

	public void setDd0301(String dd0301) {
		this.dd0301 = dd0301;
	}

	public String getDd0302() {
		return dd0302;
	}

	public void setDd0302(String dd0302) {
		this.dd0302 = dd0302;
	}

	public String getDd0303() {
		return dd0303;
	}

	public void setDd0303(String dd0303) {
		this.dd0303 = dd0303;
	}

	public String getDd0304() {
		return dd0304;
	}

	public void setDd0304(String dd0304) {
		this.dd0304 = dd0304;
	}

	@Override
	protected Serializable pkVal() {
		return this.dd0301;
	}

	@Override
	public String toString() {
		return "Tbdd03{" +
			"dd0301=" + dd0301 +
			", dd0302=" + dd0302 +
			", dd0303=" + dd0303 +
			", dd0304=" + dd0304 +
			"}";
	}
}

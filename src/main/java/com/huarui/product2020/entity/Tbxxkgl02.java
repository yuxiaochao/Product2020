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
 * @author su
 * @since 2020-03-27
 */
public class Tbxxkgl02 extends Model<Tbxxkgl02> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("XXKGL0201")
	private String xxkgl0201;
    /**
     * 学习卡ID
     */
	@TableField("XXKGL0202")
	private String xxkgl0202;
    /**
     * 套包ID：tbCMDY06
     */
	@TableField("XXKGL0203")
	private String xxkgl0203;
    /**
     * 套包与商品关联ID：tbCMDY07
     */
	@TableField("XXKGL0204")
	private String xxkgl0204;


	public String getXxkgl0201() {
		return xxkgl0201;
	}

	public void setXxkgl0201(String xxkgl0201) {
		this.xxkgl0201 = xxkgl0201;
	}

	public String getXxkgl0202() {
		return xxkgl0202;
	}

	public void setXxkgl0202(String xxkgl0202) {
		this.xxkgl0202 = xxkgl0202;
	}

	public String getXxkgl0203() {
		return xxkgl0203;
	}

	public void setXxkgl0203(String xxkgl0203) {
		this.xxkgl0203 = xxkgl0203;
	}

	public String getXxkgl0204() {
		return xxkgl0204;
	}

	public void setXxkgl0204(String xxkgl0204) {
		this.xxkgl0204 = xxkgl0204;
	}

	@Override
	protected Serializable pkVal() {
		return this.xxkgl0201;
	}

	@Override
	public String toString() {
		return "Tbxxkgl02{" +
			"xxkgl0201=" + xxkgl0201 +
			", xxkgl0202=" + xxkgl0202 +
			", xxkgl0203=" + xxkgl0203 +
			", xxkgl0204=" + xxkgl0204 +
			"}";
	}
}

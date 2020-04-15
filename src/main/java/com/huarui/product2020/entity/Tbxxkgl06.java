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
public class Tbxxkgl06 extends Model<Tbxxkgl06> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("XXKGL0601")
	private String xxkgl0601;
    /**
     * 学习卡下发ID：tbXXKGL04
     */
	@TableField("XXKGL0602")
	private String xxkgl0602;
    /**
     * 学习卡ID：tbXXKGL01
     */
	@TableField("XXKGL0603")
	private String xxkgl0603;


	public String getXxkgl0601() {
		return xxkgl0601;
	}

	public void setXxkgl0601(String xxkgl0601) {
		this.xxkgl0601 = xxkgl0601;
	}

	public String getXxkgl0602() {
		return xxkgl0602;
	}

	public void setXxkgl0602(String xxkgl0602) {
		this.xxkgl0602 = xxkgl0602;
	}

	public String getXxkgl0603() {
		return xxkgl0603;
	}

	public void setXxkgl0603(String xxkgl0603) {
		this.xxkgl0603 = xxkgl0603;
	}

	@Override
	protected Serializable pkVal() {
		return this.xxkgl0601;
	}

	@Override
	public String toString() {
		return "Tbxxkgl06{" +
			"xxkgl0601=" + xxkgl0601 +
			", xxkgl0602=" + xxkgl0602 +
			", xxkgl0603=" + xxkgl0603 +
			"}";
	}
}

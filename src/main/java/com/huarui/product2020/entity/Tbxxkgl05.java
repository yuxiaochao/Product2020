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
public class Tbxxkgl05 extends Model<Tbxxkgl05> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("XXKGL0501")
	private String xxkgl0501;
    /**
     * 学习卡下发ID：tbXXKGL04
     */
	@TableField("XXKGL0502")
	private String xxkgl0502;
    /**
     * 代理机构ID
     */
	@TableField("XXKGL0503")
	private String xxkgl0503;


	public String getXxkgl0501() {
		return xxkgl0501;
	}

	public void setXxkgl0501(String xxkgl0501) {
		this.xxkgl0501 = xxkgl0501;
	}

	public String getXxkgl0502() {
		return xxkgl0502;
	}

	public void setXxkgl0502(String xxkgl0502) {
		this.xxkgl0502 = xxkgl0502;
	}

	public String getXxkgl0503() {
		return xxkgl0503;
	}

	public void setXxkgl0503(String xxkgl0503) {
		this.xxkgl0503 = xxkgl0503;
	}

	@Override
	protected Serializable pkVal() {
		return this.xxkgl0501;
	}

	@Override
	public String toString() {
		return "Tbxxkgl05{" +
			"xxkgl0501=" + xxkgl0501 +
			", xxkgl0502=" + xxkgl0502 +
			", xxkgl0503=" + xxkgl0503 +
			"}";
	}
}

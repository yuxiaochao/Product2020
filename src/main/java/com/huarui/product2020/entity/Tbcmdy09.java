package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

import java.io.Serializable;

/**
 * <p>
 * 商品价格定义
 * </p>
 *
 * @author panlei
 * @since 2020-02-16
 */
public class Tbcmdy09 extends Model<Tbcmdy09> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("CMDY0901")
	private String cmdy0901;
    /**
     * 基本信息ID

     */
	@TableField("CMDY0902")
	private String cmdy0902;
    /**
     * 价格定义类别 0：可按单科或套包购买；1：按套包购买；
     */
	@TableField("CMDY0903")
	private Double cmdy0903;


	public String getCmdy0901() {
		return cmdy0901;
	}

	public void setCmdy0901(String cmdy0901) {
		this.cmdy0901 = cmdy0901;
	}

	public String getCmdy0902() {
		return cmdy0902;
	}

	public void setCmdy0902(String cmdy0902) {
		this.cmdy0902 = cmdy0902;
	}

	public Double getCmdy0903() {
		return cmdy0903;
	}

	public void setCmdy0903(Double cmdy0903) {
		this.cmdy0903 = cmdy0903;
	}

	@Override
	protected Serializable pkVal() {
		return this.cmdy0901;
	}

	@Override
	public String toString() {
		return "Tbcmdy09{" +
			"cmdy0901=" + cmdy0901 +
			", cmdy0902=" + cmdy0902 +
			", cmdy0903=" + cmdy0903 +
			"}";
	}
}

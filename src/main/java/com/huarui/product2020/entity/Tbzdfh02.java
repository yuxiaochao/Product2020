package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

import java.io.Serializable;

/**
 * <p>
 * 天猫商品与官网商品关联数据表
 * </p>
 *
 * @author panlei
 * @since 2020-03-24
 */
public class Tbzdfh02 extends Model<Tbzdfh02> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("ZDFH0201")
	private String zdfh0201;
    /**
     * 	天猫商品标题
     */
	@TableField("ZDFH0202")
	private String zdfh0202;
    /**
     * 	天猫商品sku属性值
     */
	@TableField("ZDFH0203")
	private String zdfh0203;
    /**
     * 	商品类型为0，套包组合ID tbCMDY06；商品类型为1，套包与商品关联ID tbCMDY07；
     */
	@TableField("ZDFH0204")
	private String zdfh0204;
	
	  /**
     * 		商品类型 0：套包 1：单商品
     */
	@TableField("ZDFH0205")
	private Integer zdfh0205;


	public String getZdfh0201() {
		return zdfh0201;
	}

	public void setZdfh0201(String zdfh0201) {
		this.zdfh0201 = zdfh0201;
	}

	public String getZdfh0202() {
		return zdfh0202;
	}

	public void setZdfh0202(String zdfh0202) {
		this.zdfh0202 = zdfh0202;
	}

	public String getZdfh0203() {
		return zdfh0203;
	}

	public void setZdfh0203(String zdfh0203) {
		this.zdfh0203 = zdfh0203;
	}

	public String getZdfh0204() {
		return zdfh0204;
	}

	public void setZdfh0204(String zdfh0204) {
		this.zdfh0204 = zdfh0204;
	}
	
	

	public Integer getZdfh0205() {
		return zdfh0205;
	}

	public void setZdfh0205(Integer zdfh0205) {
		this.zdfh0205 = zdfh0205;
	}

	@Override
	protected Serializable pkVal() {
		return this.zdfh0201;
	}

	@Override
	public String toString() {
		return "Tbzdfh02{" +
			"zdfh0201=" + zdfh0201 +
			", zdfh0202=" + zdfh0202 +
			", zdfh0203=" + zdfh0203 +
			", zdfh0204=" + zdfh0204 +
			", zdfh0205=" + zdfh0205 +
			"}";
	}
}

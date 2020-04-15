package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

import java.io.Serializable;

/**
 * <p>
 * 天猫返回用户数据日志
 * </p>
 *
 * @author panlei
 * @since 2020-03-25
 */
public class Tbzdfh04 extends Model<Tbzdfh04> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("ZDFH0401")
	private String zdfh0401;
    /**
     * 入参签名
     */
	@TableField("ZDFH0402")
	private String zdfh0402;
    /**
     * 天猫发货返回用户信息

     */
	@TableField("ZDFH0403")
	private String zdfh0403;
    /**
     * 天猫订单号

     */
	@TableField("ZDFH0404")
	private String zdfh0404;

	 /**
     * 0：自动开课 1：卡号开课
     */
	@TableField("ZDFH0405")
	private int zdfh0405;

	public String getZdfh0401() {
		return zdfh0401;
	}

	public void setZdfh0401(String zdfh0401) {
		this.zdfh0401 = zdfh0401;
	}

	public String getZdfh0402() {
		return zdfh0402;
	}

	public void setZdfh0402(String zdfh0402) {
		this.zdfh0402 = zdfh0402;
	}

	public String getZdfh0403() {
		return zdfh0403;
	}

	public void setZdfh0403(String zdfh0403) {
		this.zdfh0403 = zdfh0403;
	}

	public String getZdfh0404() {
		return zdfh0404;
	}

	public void setZdfh0404(String zdfh0404) {
		this.zdfh0404 = zdfh0404;
	}

	


	public int getZdfh0405() {
		return zdfh0405;
	}

	public void setZdfh0405(int zdfh0405) {
		this.zdfh0405 = zdfh0405;
	}

	@Override
	protected Serializable pkVal() {
		return this.zdfh0401;
	}

	@Override
	public String toString() {
		return "Tbzdfh04{" +
			"zdfh0401=" + zdfh0401 +
			", zdfh0402=" + zdfh0402 +
			", zdfh0403=" + zdfh0403 +
			", zdfh0404=" + zdfh0404 +
			"}";
	}
}

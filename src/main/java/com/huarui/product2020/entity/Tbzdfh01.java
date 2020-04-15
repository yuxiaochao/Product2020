package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 天猫推送数据日志表
 * </p>
 *
 * @author panlei
 * @since 2020-03-23
 */
public class Tbzdfh01 extends Model<Tbzdfh01> {

    private static final long serialVersionUID = 1L;

    /**
     * 	主键
     */
    @TableId("ZDFH0101")
	private String zdfh0101;
    /**
     * 	时间戳
     */
	@TableField("ZDFH0102")
	private Double zdfh0102;
    /**
     * 	推送类型
     */
	@TableField("ZDFH0103")
	private Double zdfh0103;
    /**
     * 	签名
     */
	@TableField("ZDFH0104")
	private String zdfh0104;
    /**
     * 	数据内容
     */
	@TableField("ZDFH0105")
	private String zdfh0105;
    /**
     * 	对入参数据加密后的串
     */
	@TableField("ZDFH0106")
	private String zdfh0106;
    /**
     * 	创建时间
     */
	@TableField("ZDFH0107")
	private Date zdfh0107;
    /**
     * 推送状态 0：推送中 1：推送成功 2：推送失败（异常）
     */
	@TableField("ZDFH0108")
	private Double zdfh0108;
	
	/**
	 * 天猫订单id
	 */
	@TableField("ZDFH0109")
	private String zdfh0109;
	
	/**
	 * 备注
	 */
	@TableField("ZDFH0110")
	private String zdfh0110;


	public String getZdfh0101() {
		return zdfh0101;
	}

	public void setZdfh0101(String zdfh0101) {
		this.zdfh0101 = zdfh0101;
	}

	public Double getZdfh0102() {
		return zdfh0102;
	}

	public void setZdfh0102(Double zdfh0102) {
		this.zdfh0102 = zdfh0102;
	}

	public Double getZdfh0103() {
		return zdfh0103;
	}

	public void setZdfh0103(Double zdfh0103) {
		this.zdfh0103 = zdfh0103;
	}

	public String getZdfh0104() {
		return zdfh0104;
	}

	public void setZdfh0104(String zdfh0104) {
		this.zdfh0104 = zdfh0104;
	}

	public String getZdfh0105() {
		return zdfh0105;
	}

	public void setZdfh0105(String zdfh0105) {
		this.zdfh0105 = zdfh0105;
	}

	public String getZdfh0106() {
		return zdfh0106;
	}

	public void setZdfh0106(String zdfh0106) {
		this.zdfh0106 = zdfh0106;
	}

	public Date getZdfh0107() {
		return zdfh0107;
	}

	public void setZdfh0107(Date zdfh0107) {
		this.zdfh0107 = zdfh0107;
	}

	public Double getZdfh0108() {
		return zdfh0108;
	}

	public void setZdfh0108(Double zdfh0108) {
		this.zdfh0108 = zdfh0108;
	}
	
	public String getZdfh0109() {
		return zdfh0109;
	}

	public void setZdfh0109(String zdfh0109) {
		this.zdfh0109 = zdfh0109;
	}

	@Override
	protected Serializable pkVal() {
		return this.zdfh0101;
	}

	
	public String getZdfh0110() {
		return zdfh0110;
	}

	public void setZdfh0110(String zdfh0110) {
		this.zdfh0110 = zdfh0110;
	}

	@Override
	public String toString() {
		return "Tbzdfh01{" +
			"zdfh0101=" + zdfh0101 +
			", zdfh0102=" + zdfh0102 +
			", zdfh0103=" + zdfh0103 +
			", zdfh0104=" + zdfh0104 +
			", zdfh0105=" + zdfh0105 +
			", zdfh0106=" + zdfh0106 +
			", zdfh0107=" + zdfh0107 +
			", zdfh0108=" + zdfh0108 +
			", zdfh0109=" + zdfh0109 +
			", zdfh0110=" + zdfh0110 +
			"}";
	}
}

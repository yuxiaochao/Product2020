package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 天猫商品自动开卡记录
 * </p>
 *
 * @author panlei
 * @since 2020-03-25
 */
public class Tbzdfh03 extends Model<Tbzdfh03> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("ZDFH0301")
	private String zdfh0301;
    /**
     * 充值类型:0 未充值 1 用户充值 2 管理员充值 3 作废 4 回滚卡
     */
	@TableField("ZDFH0302")
	private Double zdfh0302;
    /**
     * 价格
     */
	@TableField("ZDFH0303")
	private Double zdfh0303;
    /**
     * 实付金额
     */
	@TableField("ZDFH0304")
	private Double zdfh0304;
    /**
     * 套包组合ID tbCMDY06
     */
	@TableField("ZDFH0305")
	private String zdfh0305;
    /**
     * 套包与商品关联ID tbCMDY07
     */
	@TableField("ZDFH0306")
	private String zdfh0306;
    /**
     * 	备注
     */
	@TableField("ZDFH0307")
	private String zdfh0307;
    /**
     * 	创建时间
     */
	@TableField("ZDFH0308")
	private Date zdfh0308;
    /**
     * 	使用时间
     */
	@TableField("ZDFH0309")
	private Date zdfh0309;
    /**
     * 	使用人
     */
	@TableField("ZDFH0310")
	private String zdfh0310;
    /**
     * 	天猫订单号
     */
	@TableField("ZDFH0311")
	private String zdfh0311;

	  /**
     * 	卡号
     */
	@TableField("ZDFH0312")
	private String zdfh0312;

	
	  /**
     * 	密码
     */
	@TableField("ZDFH0313")
	private String zdfh0313;

	

	public String getZdfh0301() {
		return zdfh0301;
	}

	public void setZdfh0301(String zdfh0301) {
		this.zdfh0301 = zdfh0301;
	}

	public Double getZdfh0302() {
		return zdfh0302;
	}

	public void setZdfh0302(Double zdfh0302) {
		this.zdfh0302 = zdfh0302;
	}

	public Double getZdfh0303() {
		return zdfh0303;
	}

	public void setZdfh0303(Double zdfh0303) {
		this.zdfh0303 = zdfh0303;
	}

	public Double getZdfh0304() {
		return zdfh0304;
	}

	public void setZdfh0304(Double zdfh0304) {
		this.zdfh0304 = zdfh0304;
	}

	public String getZdfh0305() {
		return zdfh0305;
	}

	public void setZdfh0305(String zdfh0305) {
		this.zdfh0305 = zdfh0305;
	}

	public String getZdfh0306() {
		return zdfh0306;
	}

	public void setZdfh0306(String zdfh0306) {
		this.zdfh0306 = zdfh0306;
	}

	public String getZdfh0307() {
		return zdfh0307;
	}

	public void setZdfh0307(String zdfh0307) {
		this.zdfh0307 = zdfh0307;
	}

	public Date getZdfh0308() {
		return zdfh0308;
	}

	public void setZdfh0308(Date zdfh0308) {
		this.zdfh0308 = zdfh0308;
	}

	public Date getZdfh0309() {
		return zdfh0309;
	}

	public void setZdfh0309(Date zdfh0309) {
		this.zdfh0309 = zdfh0309;
	}

	public String getZdfh0310() {
		return zdfh0310;
	}

	public void setZdfh0310(String zdfh0310) {
		this.zdfh0310 = zdfh0310;
	}

	public String getZdfh0311() {
		return zdfh0311;
	}

	public void setZdfh0311(String zdfh0311) {
		this.zdfh0311 = zdfh0311;
	}

	@Override
	protected Serializable pkVal() {
		return this.zdfh0301;
	}
	
	

	public String getZdfh0312() {
		return zdfh0312;
	}

	public void setZdfh0312(String zdfh0312) {
		this.zdfh0312 = zdfh0312;
	}

	public String getZdfh0313() {
		return zdfh0313;
	}

	public void setZdfh0313(String zdfh0313) {
		this.zdfh0313 = zdfh0313;
	}

	@Override
	public String toString() {
		return "Tbzdfh03{" +
			"zdfh0301=" + zdfh0301 +
			", zdfh0302=" + zdfh0302 +
			", zdfh0303=" + zdfh0303 +
			", zdfh0304=" + zdfh0304 +
			", zdfh0305=" + zdfh0305 +
			", zdfh0306=" + zdfh0306 +
			", zdfh0307=" + zdfh0307 +
			", zdfh0308=" + zdfh0308 +
			", zdfh0309=" + zdfh0309 +
			", zdfh0310=" + zdfh0310 +
			", zdfh0311=" + zdfh0311 +
			", zdfh0312=" + zdfh0312 +
			", zdfh0313=" + zdfh0313 +
			"}";
	}
}

package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * ${table.comment}
 * </p>
 *
 * @author Chenrui
 * @since 2017-08-13
 */
@TableName("HRSW_T_LOGINLOG")
public class HrswTLoginlog extends Model<HrswTLoginlog> {

    private static final long serialVersionUID = 1L;

    @TableId("LLOG001")
	private String llog001;
    /**
     * sessionId
     */
	@TableField("LLOG002")
	private String llog002;
    /**
     * 用户ID
     */
	@TableField("LLOG003")
	private String llog003;
    /**
     * 用户IP
     */
	@TableField("LLOG004")
	private String llog004;
    /**
     * 登录时间
     */
	@TableField("LLOG005")
	private Date llog005;
    /**
     * 浏览器
     */
	@TableField("LLOG006")
	private String llog006;
    /**
     * 分辩率
     */
	@TableField("LLOG007")
	private String llog007;
    /**
     * 操作系统
     */
	@TableField("LLOG008")
	private String llog008;
    /**
     * 登录方式  1、账号 2、手机  3、邮箱;4.qq;5.微信
     */
	@TableField("LLOG009")
	private Long llog009;
    /**
     * 日志来源  1:web 2：android 3: iphone
     */
	@TableField("LLOG010")
	private Long llog010;
    /**
     * 用户身份标识
     */
	@TableField("LLOG011")
	private String llog011;
    /**
     * 设备标识
     */
	@TableField("LLOG012")
	private String llog012;


	public String getLlog001() {
		return llog001;
	}

	public void setLlog001(String llog001) {
		this.llog001 = llog001;
	}

	public String getLlog002() {
		return llog002;
	}

	public void setLlog002(String llog002) {
		this.llog002 = llog002;
	}

	public String getLlog003() {
		return llog003;
	}

	public void setLlog003(String llog003) {
		this.llog003 = llog003;
	}

	public String getLlog004() {
		return llog004;
	}

	public void setLlog004(String llog004) {
		this.llog004 = llog004;
	}

	public Date getLlog005() {
		return llog005;
	}

	public void setLlog005(Date llog005) {
		this.llog005 = llog005;
	}

	public String getLlog006() {
		return llog006;
	}

	public void setLlog006(String llog006) {
		this.llog006 = llog006;
	}

	public String getLlog007() {
		return llog007;
	}

	public void setLlog007(String llog007) {
		this.llog007 = llog007;
	}

	public String getLlog008() {
		return llog008;
	}

	public void setLlog008(String llog008) {
		this.llog008 = llog008;
	}

	public Long getLlog009() {
		return llog009;
	}

	public void setLlog009(Long llog009) {
		this.llog009 = llog009;
	}

	public Long getLlog010() {
		return llog010;
	}

	public void setLlog010(Long llog010) {
		this.llog010 = llog010;
	}

	public String getLlog011() {
		return llog011;
	}

	public void setLlog011(String llog011) {
		this.llog011 = llog011;
	}

	public String getLlog012() {
		return llog012;
	}

	public void setLlog012(String llog012) {
		this.llog012 = llog012;
	}

	@Override
	protected Serializable pkVal() {
		return this.llog001;
	}

}

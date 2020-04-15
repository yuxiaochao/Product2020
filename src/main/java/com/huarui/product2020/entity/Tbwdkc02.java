package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author su
 * @since 2020-02-13
 */
public class Tbwdkc02 extends Model<Tbwdkc02> {

    private static final long serialVersionUID = 1L;

    @TableId("WDKC0201")
	private String wdkc0201;
    /**
     * 我的课程套包表ID
     */
	@TableField("WDKC0202")
	private String wdkc0202;
	@TableField("WDKC0203")
	private String wdkc0203;
	@TableField("WDKC0204")
	private String wdkc0204;
	@TableField("WDKC0205")
	private Date wdkc0205;
    /**
     * 状态 0：在学 1：已完成 
     */
	@TableField("WDKC0206")
	private Double wdkc0206;
	@TableField("WDKC0207")
	private String wdkc0207;

	@TableField(exist = false)
	private String cmdy0401;
	@TableField(exist = false)
	private String cmdy0301;
	@TableField(exist = false)
	private String cmdy0601;
	@TableField(exist = false)
	private String cmdy0406;
	@TableField(exist = false)
	private String cmdy0404;
	@TableField(exist = false)
	private int cmdy0312;
	@TableField(exist = false)
	private String cmdy0313;
	@TableField(exist = false)
	private String cmdy0313n;
	@TableField(exist = false)
	private String cmdy0314n;
	@TableField(exist = false)
	private String lere0110;
	@TableField(exist = false)
	private int lere0105;
	@TableField(exist = false)
	private String cour004;
	@TableField(exist = false)
	private String cour010;
	@TableField(exist = false)
	private String cmdy0503;
	@TableField(exist = false)
	private String classHour;
	@TableField(exist = false)
	private String cmdy0409n;//过期时间
	@TableField(exist = false)
	private String user001;//用户id
	@TableField(exist = false)
	private String user004;//username
	@TableField(exist = false)
	private String leex003;//题库id
	
	@TableField(exist = false)
	private String auth;
	@TableField(exist = false)
	private String appEName;
	@TableField(exist = false)
	private String appName;//
	@TableField(exist = false)
	private String ssoToken;//
	@TableField(exist = false)
	private String uid;//
	
	


	
	
	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public String getAppEName() {
		return appEName;
	}

	public void setAppEName(String appEName) {
		this.appEName = appEName;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getSsoToken() {
		return ssoToken;
	}

	public void setSsoToken(String ssoToken) {
		this.ssoToken = ssoToken;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getCmdy0409n() {
		return cmdy0409n;
	}

	public void setCmdy0409n(String cmdy0409n) {
		this.cmdy0409n = cmdy0409n;
	}

	public String getUser001() {
		return user001;
	}

	public void setUser001(String user001) {
		this.user001 = user001;
	}

	public String getUser004() {
		return user004;
	}

	public void setUser004(String user004) {
		this.user004 = user004;
	}

	public String getLeex003() {
		return leex003;
	}

	public void setLeex003(String leex003) {
		this.leex003 = leex003;
	}

	public String getWdkc0201() {
		return wdkc0201;
	}

	public void setWdkc0201(String wdkc0201) {
		this.wdkc0201 = wdkc0201;
	}

	public String getWdkc0202() {
		return wdkc0202;
	}

	public void setWdkc0202(String wdkc0202) {
		this.wdkc0202 = wdkc0202;
	}

	public String getWdkc0203() {
		return wdkc0203;
	}

	public void setWdkc0203(String wdkc0203) {
		this.wdkc0203 = wdkc0203;
	}

	public String getWdkc0204() {
		return wdkc0204;
	}

	public void setWdkc0204(String wdkc0204) {
		this.wdkc0204 = wdkc0204;
	}

	public Date getWdkc0205() {
		return wdkc0205;
	}

	public void setWdkc0205(Date wdkc0205) {
		this.wdkc0205 = wdkc0205;
	}

	public Double getWdkc0206() {
		return wdkc0206;
	}

	public void setWdkc0206(Double wdkc0206) {
		this.wdkc0206 = wdkc0206;
	}

	public String getWdkc0207() {
		return wdkc0207;
	}

	public void setWdkc0207(String wdkc0207) {
		this.wdkc0207 = wdkc0207;
	}

	@Override
	protected Serializable pkVal() {
		return this.wdkc0201;
	}

	@Override
	public String toString() {
		return "Tbwdkc02{" +
			"wdkc0201=" + wdkc0201 +
			", wdkc0202=" + wdkc0202 +
			", wdkc0203=" + wdkc0203 +
			", wdkc0204=" + wdkc0204 +
			", wdkc0205=" + wdkc0205 +
			", wdkc0206=" + wdkc0206 +
			", wdkc0207=" + wdkc0207 +
			"}";
	}

	public String getCmdy0401() {
		return cmdy0401;
	}

	public void setCmdy0401(String cmdy0401) {
		this.cmdy0401 = cmdy0401;
	}

	public String getCmdy0301() {
		return cmdy0301;
	}

	public void setCmdy0301(String cmdy0301) {
		this.cmdy0301 = cmdy0301;
	}

	public String getCmdy0601() {
		return cmdy0601;
	}

	public void setCmdy0601(String cmdy0601) {
		this.cmdy0601 = cmdy0601;
	}

	public String getCmdy0406() {
		return cmdy0406;
	}

	public void setCmdy0406(String cmdy0406) {
		this.cmdy0406 = cmdy0406;
	}

	public String getCmdy0404() {
		return cmdy0404;
	}

	public void setCmdy0404(String cmdy0404) {
		this.cmdy0404 = cmdy0404;
	}

	public String getCour004() {
		return cour004;
	}

	public void setCour004(String cour004) {
		this.cour004 = cour004;
	}

	public String getCour010() {
		return cour010;
	}

	public void setCour010(String cour010) {
		this.cour010 = cour010;
	}

	public String getCmdy0313() {
		return cmdy0313;
	}

	public void setCmdy0313(String cmdy0313) {
		this.cmdy0313 = cmdy0313;
	}

	public String getCmdy0314n() {
		return cmdy0314n;
	}

	public void setCmdy0314n(String cmdy0314n) {
		this.cmdy0314n = cmdy0314n;
	}

	public String getCmdy0503() {
		return cmdy0503;
	}

	public void setCmdy0503(String cmdy0503) {
		this.cmdy0503 = cmdy0503;
	}

	public String getLere0110() {
		return lere0110;
	}

	public void setLere0110(String lere0110) {
		this.lere0110 = lere0110;
	}

	public int getCmdy0312() {
		return cmdy0312;
	}

	public void setCmdy0312(int cmdy0312) {
		this.cmdy0312 = cmdy0312;
	}

	public int getLere0105() {
		return lere0105;
	}

	public void setLere0105(int lere0105) {
		this.lere0105 = lere0105;
	}

	public String getCmdy0313n() {
		return cmdy0313n;
	}

	public void setCmdy0313n(String cmdy0313n) {
		this.cmdy0313n = cmdy0313n;
	}

	public String getClassHour() {
		return classHour;
	}

	public void setClassHour(String classHour) {
		this.classHour = classHour;
	}
}

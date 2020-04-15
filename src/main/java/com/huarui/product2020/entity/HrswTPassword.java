package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author Administrator
 * @since 2019-08-26
 */
@TableName("HRSW_T_PASSWORD")
public class HrswTPassword extends Model<HrswTPassword> {

    private static final long serialVersionUID = 1L;

    @TableId("PASS001")
	private String pass001;
    /**
     * 用户ID
     */
	@TableField("PASS002")
	private String pass002;
    /**
     * 密码
     */
	@TableField("PASS003")
	private String pass003;
    /**
     * 过期时间
     */
	@TableField("PASS004")
	private Date pass004;
    /**
     * 创建人
     */
	@TableField("PASS005")
	private String pass005;
    /**
     * 创建时间
     */
	@TableField("PASS006")
	private Date pass006;
    /**
     * 最后修改时间
     */
	@TableField("PASS007")
	private Date pass007;


	public String getPass001() {
		return pass001;
	}

	public void setPass001(String pass001) {
		this.pass001 = pass001;
	}

	public String getPass002() {
		return pass002;
	}

	public void setPass002(String pass002) {
		this.pass002 = pass002;
	}

	public String getPass003() {
		return pass003;
	}

	public void setPass003(String pass003) {
		this.pass003 = pass003;
	}

	public Date getPass004() {
		return pass004;
	}

	public void setPass004(Date pass004) {
		this.pass004 = pass004;
	}

	public String getPass005() {
		return pass005;
	}

	public void setPass005(String pass005) {
		this.pass005 = pass005;
	}

	public Date getPass006() {
		return pass006;
	}

	public void setPass006(Date pass006) {
		this.pass006 = pass006;
	}

	public Date getPass007() {
		return pass007;
	}

	public void setPass007(Date pass007) {
		this.pass007 = pass007;
	}

	@Override
	protected Serializable pkVal() {
		return this.pass001;
	}

	@Override
	public String toString() {
		return "HrswTPassword{" +
			"pass001=" + pass001 +
			", pass002=" + pass002 +
			", pass003=" + pass003 +
			", pass004=" + pass004 +
			", pass005=" + pass005 +
			", pass006=" + pass006 +
			", pass007=" + pass007 +
			"}";
	}
}

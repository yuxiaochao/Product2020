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
 * @author panlei
 * @since 2017-09-05
 */
@TableName("HRSW_T_USERGROUP")
public class HrswTUserGroup extends Model<HrswTUserGroup> {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId("USGR001")
	private String usgr001;
    /**
     * 讨论组id
     */
	@TableField("USGR002")
	private String usgr002;
    /**
     * 用户id
     */
	@TableField("USGR003")
	private String usgr003;
    /**
     * 状态(0:待加入 1：已加入)
     */
	@TableField("USGR004")
	private int usgr004;
    /**
     * 加入时间
     */
	@TableField("USGR005")
	private Date usgr005;
    /**
     * 邀请人id
     */
	@TableField("USGR006")
	private String usgr006;


	public String getUsgr001() {
		return usgr001;
	}

	public void setUsgr001(String usgr001) {
		this.usgr001 = usgr001;
	}

	public String getUsgr002() {
		return usgr002;
	}

	public void setUsgr002(String usgr002) {
		this.usgr002 = usgr002;
	}

	public String getUsgr003() {
		return usgr003;
	}

	public void setUsgr003(String usgr003) {
		this.usgr003 = usgr003;
	}

	

	public int getUsgr004() {
		return usgr004;
	}

	public void setUsgr004(int usgr004) {
		this.usgr004 = usgr004;
	}

	public Date getUsgr005() {
		return usgr005;
	}

	public void setUsgr005(Date usgr005) {
		this.usgr005 = usgr005;
	}

	public String getUsgr006() {
		return usgr006;
	}

	public void setUsgr006(String usgr006) {
		this.usgr006 = usgr006;
	}

	@Override
	protected Serializable pkVal() {
		return this.usgr001;
	}

	@Override
	public String toString() {
		return "HrswTUsergroup{" +
			"usgr001=" + usgr001 +
			", usgr002=" + usgr002 +
			", usgr003=" + usgr003 +
			", usgr004=" + usgr004 +
			", usgr005=" + usgr005 +
			", usgr006=" + usgr006 +
			"}";
	}
}

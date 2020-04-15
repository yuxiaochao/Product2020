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
@TableName("HRSW_T_CONTACTS")
public class HrswTContacts extends Model<HrswTContacts> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("CONT001")
	private String cont001;
    /**
     * 用户id
     */
	@TableField("CONT002")
	private String cont002;
    /**
     * 好友id
     */
	@TableField("CONT003")
	private String cont003;
    /**
     * 状态（0：待审核 1：好友 2：黑名单）
     */
	@TableField("CONT004")
	private int cont004;
    /**
     * 最后更新时间
     */
	@TableField("CONT005")
	private Date cont005;

	private HrswTUser user;
	
	private HrswTAttachment attachment;

	public String getCont001() {
		return cont001;
	}

	public void setCont001(String cont001) {
		this.cont001 = cont001;
	}

	public String getCont002() {
		return cont002;
	}

	public void setCont002(String cont002) {
		this.cont002 = cont002;
	}

	public String getCont003() {
		return cont003;
	}

	public void setCont003(String cont003) {
		this.cont003 = cont003;
	}


	public int getCont004() {
		return cont004;
	}

	public void setCont004(int cont004) {
		this.cont004 = cont004;
	}

	public Date getCont005() {
		return cont005;
	}

	public void setCont005(Date cont005) {
		this.cont005 = cont005;
	}

	@Override
	protected Serializable pkVal() {
		return this.cont001;
	}

	@Override
	public String toString() {
		return "HrswTContacts{" +
			"cont001=" + cont001 +
			", cont002=" + cont002 +
			", cont003=" + cont003 +
			", cont004=" + cont004 +
			", cont005=" + cont005 +
			"}";
	}

	public HrswTUser getUser() {
		return user;
	}

	public void setUser(HrswTUser user) {
		this.user = user;
	}

	public HrswTAttachment getAttachment() {
		return attachment;
	}

	public void setAttachment(HrswTAttachment attachment) {
		this.attachment = attachment;
	}
	
	
}

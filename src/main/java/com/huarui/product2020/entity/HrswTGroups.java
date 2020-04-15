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
@TableName("HRSW_T_GROUPS")
public class HrswTGroups extends Model<HrswTGroups> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("GROU001")
	private String grou001;
    /**
     * 	群组名称
     */
	@TableField("GROU002")
	private String grou002;
	
    /**
     * 群组类型(0:讨论组 1：群)
     */
	@TableField("GROU003")
	private int grou003;
	
    /**
     * 编号(环信id)
     */
	@TableField("GROU004")
	private String grou004;
	
    /**
     * 最后修改时间
     */
	@TableField("GROU005")
	private Date grou005;
	
	/**
     * 创建时间
     */
	@TableField("GROU006")
	private Date grou006;
	
	/**
     * 创建人
     */
	@TableField("GROU007")
	private String grou007;
	
	/**
     * 头像
     */
	@TableField("GROU008")
	private String grou008;
	
	/**
     * 群组详情
     */
	@TableField("GROU009")
	private String grou009;
	
	/**
     * 群组公告
     */
	@TableField("GROU010")
	private String grou010;
	
	/**
     * 群组成员上限
     */
	@TableField("GROU011")
	private int grou011;
	
	/**
     * 群组是否公开（0：公开群，1：私有群）
     */
	@TableField("GROU012")
	private int grou012;
	

	private HrswTUserGroup userGroup;

    private HrswTUser user;
	
    private HrswTAttachment attachment;
    
	public String getGrou001() {
		return grou001;
	}





	public void setGrou001(String grou001) {
		this.grou001 = grou001;
	}





	public String getGrou002() {
		return grou002;
	}





	public void setGrou002(String grou002) {
		this.grou002 = grou002;
	}





	public int getGrou003() {
		return grou003;
	}





	public void setGrou003(int grou003) {
		this.grou003 = grou003;
	}





	public String getGrou004() {
		return grou004;
	}





	public void setGrou004(String grou004) {
		this.grou004 = grou004;
	}





	public Date getGrou005() {
		return grou005;
	}





	public void setGrou005(Date grou005) {
		this.grou005 = grou005;
	}



	




	public Date getGrou006() {
		return grou006;
	}





	public void setGrou006(Date grou006) {
		this.grou006 = grou006;
	}





	public String getGrou007() {
		return grou007;
	}





	public void setGrou007(String grou007) {
		this.grou007 = grou007;
	}



	


	public String getGrou008() {
		return grou008;
	}





	public void setGrou008(String grou008) {
		this.grou008 = grou008;
	}





	public String getGrou009() {
		return grou009;
	}





	public void setGrou009(String grou009) {
		this.grou009 = grou009;
	}





	public String getGrou010() {
		return grou010;
	}





	public void setGrou010(String grou010) {
		this.grou010 = grou010;
	}


	


	public int getGrou011() {
		return grou011;
	}





	public void setGrou011(int grou011) {
		this.grou011 = grou011;
	}





	public int getGrou012() {
		return grou012;
	}





	public void setGrou012(int grou012) {
		this.grou012 = grou012;
	}









	public HrswTUserGroup getUserGroup() {
		return userGroup;
	}





	public void setUserGroup(HrswTUserGroup userGroup) {
		this.userGroup = userGroup;
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





	@Override
	public String toString() {
		return "HrswTGroups{" +
			"grou001=" + grou001 +
			", grou002=" + grou002 +
			", grou003=" + grou003 +
			", grou004=" + grou004 +
			", grou005=" + grou005 +
			", grou006=" + grou006 +
			", grou007=" + grou007 +
			"}";
	}





	@Override
	protected Serializable pkVal() {
		return this.grou001;
	}

	
	
	
}

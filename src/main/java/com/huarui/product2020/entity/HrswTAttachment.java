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
@TableName("HRSW_T_ATTACHMENT")
public class HrswTAttachment extends Model<HrswTAttachment> {

    private static final long serialVersionUID = 1L;

    @TableId("ATTA001")
	private String atta001;
    /**
     * 用户ID
     */
	@TableField("ATTA002")
	private String atta002;
    /**
     * 消息ID
     */
	@TableField("ATTA003")
	private String atta003;
    /**
     * 附件类型 1、头像 2、消息附件
     */
	@TableField("ATTA004")
	private Long atta004;
    /**
     * 附件格式
     */
	@TableField("ATTA005")
	private String atta005;
    /**
     * 附件名称
     */
	@TableField("ATTA006")
	private String atta006;
    /**
     * 附件地址
     */
	@TableField("ATTA007")
	private String atta007;
    /**
     * 上传时间
     */
	@TableField("ATTA008")
	private Date atta008;
    /**
     * 备注说明
     */
	@TableField("ATTA009")
	private String atta009;
    /**
     * 字符型备用字段
     */
	@TableField("ATTA010")
	private String atta010;
    /**
     * 字符型备用字段
     */
	@TableField("ATTA011")
	private String atta011;
    /**
     * 字符型备用字段
     */
	@TableField("ATTA012")
	private String atta012;
    /**
     * 字符型备用字段
     */
	@TableField("ATTA013")
	private String atta013;
    /**
     * 字符型备用字段
     */
	@TableField("ATTA014")
	private String atta014;
    /**
     * 字符型备用字段
     */
	@TableField("ATTA015")
	private String atta015;
    /**
     * 字符型备用字段
     */
	@TableField("ATTA016")
	private String atta016;
    /**
     * 字符型备用字段
     */
	@TableField("ATTA017")
	private String atta017;
    /**
     * 字符型备用字段
     */
	@TableField("ATTA018")
	private String atta018;


	public String getAtta001() {
		return atta001;
	}

	public void setAtta001(String atta001) {
		this.atta001 = atta001;
	}

	public String getAtta002() {
		return atta002;
	}

	public void setAtta002(String atta002) {
		this.atta002 = atta002;
	}

	public String getAtta003() {
		return atta003;
	}

	public void setAtta003(String atta003) {
		this.atta003 = atta003;
	}

	public Long getAtta004() {
		return atta004;
	}

	public void setAtta004(Long atta004) {
		this.atta004 = atta004;
	}

	public String getAtta005() {
		return atta005;
	}

	public void setAtta005(String atta005) {
		this.atta005 = atta005;
	}

	public String getAtta006() {
		return atta006;
	}

	public void setAtta006(String atta006) {
		this.atta006 = atta006;
	}

	public String getAtta007() {
		return atta007;
	}

	public void setAtta007(String atta007) {
		this.atta007 = atta007;
	}

	public Date getAtta008() {
		return atta008;
	}

	public void setAtta008(Date atta008) {
		this.atta008 = atta008;
	}

	public String getAtta009() {
		return atta009;
	}

	public void setAtta009(String atta009) {
		this.atta009 = atta009;
	}

	public String getAtta010() {
		return atta010;
	}

	public void setAtta010(String atta010) {
		this.atta010 = atta010;
	}

	public String getAtta011() {
		return atta011;
	}

	public void setAtta011(String atta011) {
		this.atta011 = atta011;
	}

	public String getAtta012() {
		return atta012;
	}

	public void setAtta012(String atta012) {
		this.atta012 = atta012;
	}

	public String getAtta013() {
		return atta013;
	}

	public void setAtta013(String atta013) {
		this.atta013 = atta013;
	}

	public String getAtta014() {
		return atta014;
	}

	public void setAtta014(String atta014) {
		this.atta014 = atta014;
	}

	public String getAtta015() {
		return atta015;
	}

	public void setAtta015(String atta015) {
		this.atta015 = atta015;
	}

	public String getAtta016() {
		return atta016;
	}

	public void setAtta016(String atta016) {
		this.atta016 = atta016;
	}

	public String getAtta017() {
		return atta017;
	}

	public void setAtta017(String atta017) {
		this.atta017 = atta017;
	}

	public String getAtta018() {
		return atta018;
	}

	public void setAtta018(String atta018) {
		this.atta018 = atta018;
	}

	@Override
	protected Serializable pkVal() {
		return this.atta001;
	}

}

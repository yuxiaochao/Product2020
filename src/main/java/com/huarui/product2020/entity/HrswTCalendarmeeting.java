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
 * @since 2018-10-17
 */
@TableName("HRSW_T_CALENDARMEETING")
public class HrswTCalendarmeeting extends Model<HrswTCalendarmeeting> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId("MEET001")
	private String meet001;
    /**
     * 会议内容
     */
	@TableField("MEET002")
	private String meet002;
    /**
     * 开始时间
     */
	@TableField("MEET003")
	private Date meet003;
    /**
     * 结束时间
     */
	@TableField("MEET004")
	private Date meet004;
    /**
     * 会议室（数据字典）
     */
	@TableField("MEET005")
	private String meet005;
    /**
     * 开会地点
     */
	@TableField("MEET006")
	private String meet006;
    /**
     * 提醒：0.不提醒 1.会议开始时 2.提前5分钟 3.提前30分钟 4.提前1小时 5.提前一天
     */
	@TableField("MEET007")
	private Integer meet007;
    /**
     * 创建人id
     */
	@TableField("MEET008")
	private String meet008;
    /**
     * 创建时间
     */
	@TableField("MEET009")
	private Date meet009;
    /**
     * 二维码url
     */
	@TableField("MEET010")
	private String meet010;
    /**
     * 状态：1.正常 2.取消（删除）
     */
	@TableField("MEET011")
	private Integer meet011;
	
	/**
     * 签到次数
     */
	@TableField("MEET012")
	private Integer meet012;
	
	/**
	 *会议室添加方式：1.选择（数据字典）2.手工添加 
	 */
	@TableField("MEET013")
    private Integer meet013;


	public Integer getMeet012() {
		return meet012;
	}

	public void setMeet012(Integer meet012) {
		this.meet012 = meet012;
	}

	public Integer getMeet013() {
		return meet013;
	}

	public void setMeet013(Integer meet013) {
		this.meet013 = meet013;
	}

	public String getMeet001() {
		return meet001;
	}

	public void setMeet001(String meet001) {
		this.meet001 = meet001;
	}

	public String getMeet002() {
		return meet002;
	}

	public void setMeet002(String meet002) {
		this.meet002 = meet002;
	}

	public Date getMeet003() {
		return meet003;
	}

	public void setMeet003(Date meet003) {
		this.meet003 = meet003;
	}

	public Date getMeet004() {
		return meet004;
	}

	public void setMeet004(Date meet004) {
		this.meet004 = meet004;
	}

	public String getMeet005() {
		return meet005;
	}

	public void setMeet005(String meet005) {
		this.meet005 = meet005;
	}

	public String getMeet006() {
		return meet006;
	}

	public void setMeet006(String meet006) {
		this.meet006 = meet006;
	}

	public Integer getMeet007() {
		return meet007;
	}

	public void setMeet007(Integer meet007) {
		this.meet007 = meet007;
	}

	public String getMeet008() {
		return meet008;
	}

	public void setMeet008(String meet008) {
		this.meet008 = meet008;
	}

	public Date getMeet009() {
		return meet009;
	}

	public void setMeet009(Date meet009) {
		this.meet009 = meet009;
	}

	public String getMeet010() {
		return meet010;
	}

	public void setMeet010(String meet010) {
		this.meet010 = meet010;
	}

	public Integer getMeet011() {
		return meet011;
	}

	public void setMeet011(Integer meet011) {
		this.meet011 = meet011;
	}

	@Override
	protected Serializable pkVal() {
		return this.meet001;
	}

	@Override
	public String toString() {
		return "HrswTCalendarmeeting{" +
			"meet001=" + meet001 +
			", meet002=" + meet002 +
			", meet003=" + meet003 +
			", meet004=" + meet004 +
			", meet005=" + meet005 +
			", meet006=" + meet006 +
			", meet007=" + meet007 +
			", meet008=" + meet008 +
			", meet009=" + meet009 +
			", meet010=" + meet010 +
			", meet011=" + meet011 +
			"}";
	}
}

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
 * @author yuxiaochao
 * @since 2018-11-08
 */
@TableName("HRSW_T_ATTENDANCEPLAN")
public class HrswTAttendanceplan extends Model<HrswTAttendanceplan> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId("ATPL001")
	private String atpl001;
    /**
     * 出勤计划名称
     */
	@TableField("ATPL002")
	private String atpl002;
    /**
     * 开始执行时间（可为空）
     */
	@TableField("ATPL003")
	private Date atpl003;
    /**
     * 结束执行时间（可为空）
     */
	@TableField("ATPL004")
	private Date atpl004;
    /**
     * 出勤类型：1.每天 2.每周某天 3.工作日（除法定节假日）
     */
	@TableField("ATPL005")
	private Integer atpl005;
    /**
     * 周日 1.是 0.否
     */
	@TableField("ATPL006")
	private Integer atpl006;
    /**
     * 周一 1.是 0.否
     */
	@TableField("ATPL007")
	private Integer atpl007;
    /**
     * 周二 1.是 0.否
     */
	@TableField("ATPL008")
	private Integer atpl008;
    /**
     * 周三 1.是 0.否
     */
	@TableField("ATPL009")
	private Integer atpl009;
    /**
     * 周四 1.是 0.否
     */
	@TableField("ATPL010")
	private Integer atpl010;
    /**
     * 周五 1.是 0.否
     */
	@TableField("ATPL011")
	private Integer atpl011;
    /**
     * 周六 1.是 0.否
     */
	@TableField("ATPL012")
	private Integer atpl012;
    /**
     * 上班签到时间
     */
	@TableField("ATPL013")
	private String atpl013;
    /**
     * 下班签到时间
     */
	@TableField("ATPL014")
	private String atpl014;
    /**
     * 创建人id
     */
	@TableField("ATPL015")
	private String atpl015;
    /**
     * 创建时间
     */
	@TableField("ATPL016")
	private Date atpl016;
    /**
     * 状态：1.禁用 2.启用
     */
	@TableField("ATPL017")
	private Integer atpl017;
    /**
     * 经纬度
     */
	@TableField("ATPL018")
	private String atpl018;
    /**
     * 确认半径（米）
     */
	@TableField("ATPL019")
	private Integer atpl019;
    /**
     * 发布对象 1、个人 2、机构
     */
	@TableField("ATPL020")
	private Integer atpl020;
    /**
     * 计划类型 1.正常计划 2.补充计划
     */
	@TableField("ATPL021")
	private Integer atpl021;
    /**
     * 	加班确认，下班后多久打卡算加班（分钟）
     */
	@TableField("ATPL022")
	private Integer atpl022;
    /**
     * 地址名称
     */
	@TableField("ATPL023")
	private String atpl023;
	
	/**
     * 发布对象
     */
	private String userid;


	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getAtpl001() {
		return atpl001;
	}

	public void setAtpl001(String atpl001) {
		this.atpl001 = atpl001;
	}

	public String getAtpl002() {
		return atpl002;
	}

	public void setAtpl002(String atpl002) {
		this.atpl002 = atpl002;
	}

	public Date getAtpl003() {
		return atpl003;
	}

	public void setAtpl003(Date atpl003) {
		this.atpl003 = atpl003;
	}

	public Date getAtpl004() {
		return atpl004;
	}

	public void setAtpl004(Date atpl004) {
		this.atpl004 = atpl004;
	}

	public Integer getAtpl005() {
		return atpl005;
	}

	public void setAtpl005(Integer atpl005) {
		this.atpl005 = atpl005;
	}

	public Integer getAtpl006() {
		return atpl006;
	}

	public void setAtpl006(Integer atpl006) {
		this.atpl006 = atpl006;
	}

	public Integer getAtpl007() {
		return atpl007;
	}

	public void setAtpl007(Integer atpl007) {
		this.atpl007 = atpl007;
	}

	public Integer getAtpl008() {
		return atpl008;
	}

	public void setAtpl008(Integer atpl008) {
		this.atpl008 = atpl008;
	}

	public Integer getAtpl009() {
		return atpl009;
	}

	public void setAtpl009(Integer atpl009) {
		this.atpl009 = atpl009;
	}

	public Integer getAtpl010() {
		return atpl010;
	}

	public void setAtpl010(Integer atpl010) {
		this.atpl010 = atpl010;
	}

	public Integer getAtpl011() {
		return atpl011;
	}

	public void setAtpl011(Integer atpl011) {
		this.atpl011 = atpl011;
	}

	public Integer getAtpl012() {
		return atpl012;
	}

	public void setAtpl012(Integer atpl012) {
		this.atpl012 = atpl012;
	}

	public String getAtpl013() {
		return atpl013;
	}

	public void setAtpl013(String atpl013) {
		this.atpl013 = atpl013;
	}

	public String getAtpl014() {
		return atpl014;
	}

	public void setAtpl014(String atpl014) {
		this.atpl014 = atpl014;
	}

	public String getAtpl015() {
		return atpl015;
	}

	public void setAtpl015(String atpl015) {
		this.atpl015 = atpl015;
	}

	public Date getAtpl016() {
		return atpl016;
	}

	public void setAtpl016(Date atpl016) {
		this.atpl016 = atpl016;
	}

	public Integer getAtpl017() {
		return atpl017;
	}

	public void setAtpl017(Integer atpl017) {
		this.atpl017 = atpl017;
	}

	public String getAtpl018() {
		return atpl018;
	}

	public void setAtpl018(String atpl018) {
		this.atpl018 = atpl018;
	}

	public Integer getAtpl019() {
		return atpl019;
	}

	public void setAtpl019(Integer atpl019) {
		this.atpl019 = atpl019;
	}

	public Integer getAtpl020() {
		return atpl020;
	}

	public void setAtpl020(Integer atpl020) {
		this.atpl020 = atpl020;
	}

	public Integer getAtpl021() {
		return atpl021;
	}

	public void setAtpl021(Integer atpl021) {
		this.atpl021 = atpl021;
	}

	public Integer getAtpl022() {
		return atpl022;
	}

	public void setAtpl022(Integer atpl022) {
		this.atpl022 = atpl022;
	}

	public String getAtpl023() {
		return atpl023;
	}

	public void setAtpl023(String atpl023) {
		this.atpl023 = atpl023;
	}

	@Override
	protected Serializable pkVal() {
		return this.atpl001;
	}

	@Override
	public String toString() {
		return "HrswTAttendanceplan{" +
			"atpl001=" + atpl001 +
			", atpl002=" + atpl002 +
			", atpl003=" + atpl003 +
			", atpl004=" + atpl004 +
			", atpl005=" + atpl005 +
			", atpl006=" + atpl006 +
			", atpl007=" + atpl007 +
			", atpl008=" + atpl008 +
			", atpl009=" + atpl009 +
			", atpl010=" + atpl010 +
			", atpl011=" + atpl011 +
			", atpl012=" + atpl012 +
			", atpl013=" + atpl013 +
			", atpl014=" + atpl014 +
			", atpl015=" + atpl015 +
			", atpl016=" + atpl016 +
			", atpl017=" + atpl017 +
			", atpl018=" + atpl018 +
			", atpl019=" + atpl019 +
			", atpl020=" + atpl020 +
			", atpl021=" + atpl021 +
			", atpl022=" + atpl022 +
			", atpl023=" + atpl023 +
			"}";
	}
}

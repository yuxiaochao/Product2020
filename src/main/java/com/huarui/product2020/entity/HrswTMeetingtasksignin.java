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
@TableName("HRSW_T_MEETINGTASKSIGNIN")
public class HrswTMeetingtasksignin extends Model<HrswTMeetingtasksignin> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId("MTSI001")
	private String mtsi001;
    /**
     * 会议id/任务id
     */
	@TableField("MTSI002")
	private String mtsi002;
    /**
     * 类型：1.会议 2.任务
     */
	@TableField("MTSI003")
	private Integer mtsi003;
    /**
     * 人员id
     */
	@TableField("MTSI004")
	private String mtsi004;
    /**
     * 签到时间
     */
	@TableField("MTSI005")
	private Date mtsi005;
    /**
     * 签到地址
     */
	@TableField("MTSI006")
	private String mtsi006;
    /**
     * 签到经纬度
     */
	@TableField("MTSI007")
	private String mtsi007;
    /**
     * 0.正常 1.早到 2.迟到 3.早退 4.加班
     */
	@TableField("MTSI008")
	private Integer mtsi008;
    /**
     * 	早到、迟到、早退或加班等时长（分钟）
     */
	@TableField("MTSI009")
	private Integer mtsi009;
    /**
     * 	加班或早退、不在打卡范围说明
     */
	@TableField("MTSI010")
	private String mtsi010;
    /**
     * 	是否在签到确认范围内 1.是 2.否
     */
	@TableField("MTSI011")
	private Integer mtsi011;
	
	/**
     * 	任务签到说明
     */
	@TableField("MTSI012")
	private String mtsi012;


	public String getMtsi012() {
		return mtsi012;
	}

	public void setMtsi012(String mtsi012) {
		this.mtsi012 = mtsi012;
	}

	public String getMtsi001() {
		return mtsi001;
	}

	public void setMtsi001(String mtsi001) {
		this.mtsi001 = mtsi001;
	}

	public String getMtsi002() {
		return mtsi002;
	}

	public void setMtsi002(String mtsi002) {
		this.mtsi002 = mtsi002;
	}

	public Integer getMtsi003() {
		return mtsi003;
	}

	public void setMtsi003(Integer mtsi003) {
		this.mtsi003 = mtsi003;
	}

	public String getMtsi004() {
		return mtsi004;
	}

	public void setMtsi004(String mtsi004) {
		this.mtsi004 = mtsi004;
	}

	public Date getMtsi005() {
		return mtsi005;
	}

	public void setMtsi005(Date mtsi005) {
		this.mtsi005 = mtsi005;
	}

	public String getMtsi006() {
		return mtsi006;
	}

	public void setMtsi006(String mtsi006) {
		this.mtsi006 = mtsi006;
	}

	public String getMtsi007() {
		return mtsi007;
	}

	public void setMtsi007(String mtsi007) {
		this.mtsi007 = mtsi007;
	}

	public Integer getMtsi008() {
		return mtsi008;
	}

	public void setMtsi008(Integer mtsi008) {
		this.mtsi008 = mtsi008;
	}

	public Integer getMtsi009() {
		return mtsi009;
	}

	public void setMtsi009(Integer mtsi009) {
		this.mtsi009 = mtsi009;
	}

	public String getMtsi010() {
		return mtsi010;
	}

	public void setMtsi010(String mtsi010) {
		this.mtsi010 = mtsi010;
	}

	public Integer getMtsi011() {
		return mtsi011;
	}

	public void setMtsi011(Integer mtsi011) {
		this.mtsi011 = mtsi011;
	}

	@Override
	protected Serializable pkVal() {
		return this.mtsi001;
	}

	@Override
	public String toString() {
		return "HrswTMeetingtasksignin{" +
			"mtsi001=" + mtsi001 +
			", mtsi002=" + mtsi002 +
			", mtsi003=" + mtsi003 +
			", mtsi004=" + mtsi004 +
			", mtsi005=" + mtsi005 +
			", mtsi006=" + mtsi006 +
			", mtsi007=" + mtsi007 +
			", mtsi008=" + mtsi008 +
			", mtsi009=" + mtsi009 +
			", mtsi010=" + mtsi010 +
			", mtsi011=" + mtsi011 +
			"}";
	}
}

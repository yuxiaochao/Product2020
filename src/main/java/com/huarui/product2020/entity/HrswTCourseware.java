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
@TableName("HRSW_T_COURSEWARE")
public class HrswTCourseware extends Model<HrswTCourseware> {

    private static final long serialVersionUID = 1L;

    @TableId("COUR001")
	private String cour001;
	@TableField("COUR002")
	private String cour002;
	@TableField("COUR003")
	private Double cour003;
	@TableField("COUR004")
	private String cour004;
	@TableField("COUR005")
	private Double cour005;
	@TableField("COUR006")
	private String cour006;
	@TableField("COUR007")
	private String cour007;
	@TableField("COUR008")
	private String cour008;
	@TableField("COUR009")
	private Double cour009;
	@TableField("COUR010")
	private Double cour010;
	@TableField("COUR011")
	private Double cour011;
	@TableField("COUR012")
	private String cour012;
	@TableField("COUR013")
	private Date cour013;
	@TableField("COUR014")
	private Date cour014;
	@TableField("COUR015")
	private String cour015;
	@TableField("COUR016")
	private String cour016;
    /**
     * 课件编号
     */
	@TableField("COUR017")
	private String cour017;
    /**
     * 若该课件是三分屏，是否生成了手机识别的xml 0否 1是
     */
	@TableField("COUR018")
	private Double cour018;
    /**
     * 若该课件是文档，该文档总页数
     */
	@TableField("COUR019")
	private String cour019;


	public String getCour001() {
		return cour001;
	}

	public void setCour001(String cour001) {
		this.cour001 = cour001;
	}

	public String getCour002() {
		return cour002;
	}

	public void setCour002(String cour002) {
		this.cour002 = cour002;
	}

	public Double getCour003() {
		return cour003;
	}

	public void setCour003(Double cour003) {
		this.cour003 = cour003;
	}

	public String getCour004() {
		return cour004;
	}

	public void setCour004(String cour004) {
		this.cour004 = cour004;
	}

	public Double getCour005() {
		return cour005;
	}

	public void setCour005(Double cour005) {
		this.cour005 = cour005;
	}

	public String getCour006() {
		return cour006;
	}

	public void setCour006(String cour006) {
		this.cour006 = cour006;
	}

	public String getCour007() {
		return cour007;
	}

	public void setCour007(String cour007) {
		this.cour007 = cour007;
	}

	public String getCour008() {
		return cour008;
	}

	public void setCour008(String cour008) {
		this.cour008 = cour008;
	}

	public Double getCour009() {
		return cour009;
	}

	public void setCour009(Double cour009) {
		this.cour009 = cour009;
	}

	public Double getCour010() {
		return cour010;
	}

	public void setCour010(Double cour010) {
		this.cour010 = cour010;
	}

	public Double getCour011() {
		return cour011;
	}

	public void setCour011(Double cour011) {
		this.cour011 = cour011;
	}

	public String getCour012() {
		return cour012;
	}

	public void setCour012(String cour012) {
		this.cour012 = cour012;
	}

	public Date getCour013() {
		return cour013;
	}

	public void setCour013(Date cour013) {
		this.cour013 = cour013;
	}

	public Date getCour014() {
		return cour014;
	}

	public void setCour014(Date cour014) {
		this.cour014 = cour014;
	}

	public String getCour015() {
		return cour015;
	}

	public void setCour015(String cour015) {
		this.cour015 = cour015;
	}

	public String getCour016() {
		return cour016;
	}

	public void setCour016(String cour016) {
		this.cour016 = cour016;
	}

	public String getCour017() {
		return cour017;
	}

	public void setCour017(String cour017) {
		this.cour017 = cour017;
	}

	public Double getCour018() {
		return cour018;
	}

	public void setCour018(Double cour018) {
		this.cour018 = cour018;
	}

	public String getCour019() {
		return cour019;
	}

	public void setCour019(String cour019) {
		this.cour019 = cour019;
	}

	@Override
	protected Serializable pkVal() {
		return this.cour001;
	}

}

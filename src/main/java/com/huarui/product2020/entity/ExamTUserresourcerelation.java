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
@TableName("EXAM_T_USERRESOURCERELATION")
public class ExamTUserresourcerelation extends Model<ExamTUserresourcerelation> {

    private static final long serialVersionUID = 1L;

	@TableField("URRE004")
	private String urre004;
    /**
     * 学习ID
     */
	@TableField("URRE005")
	private String urre005;
    /**
     * 问卷调查ID
     */
	@TableField("URRE006")
	private String urre006;
    /**
     * 热点调查ID
     */
	@TableField("URRE007")
	private String urre007;
    /**
     * 培训ID
     */
	@TableField("URRE008")
	private String urre008;
    /**
     * 责任人ID
     */
	@TableField("URRE009")
	private String urre009;
    /**
     * 操作时间
     */
	@TableField("URRE010")
	private Date urre010;
    /**
     * 是否当前责任人   1、是  2、否
     */
	@TableField("URRE011")
	private Integer urre011;
    /**
     * 课件ID
     */
	@TableField("URRE012")
	private String urre012;
    /**
     * 题库练习ID
     */
	@TableField("URRE013")
	private String urre013;
    /**
     * 主讲人ID
     */
	@TableField("URRE014")
	private String urre014;
    @TableId("URRE001")
	private String urre001;
    /**
     * 试题ID
     */
	@TableField("URRE002")
	private String urre002;
	@TableField("URRE003")
	private String urre003;


	public String getUrre004() {
		return urre004;
	}

	public void setUrre004(String urre004) {
		this.urre004 = urre004;
	}

	public String getUrre005() {
		return urre005;
	}

	public void setUrre005(String urre005) {
		this.urre005 = urre005;
	}

	public String getUrre006() {
		return urre006;
	}

	public void setUrre006(String urre006) {
		this.urre006 = urre006;
	}

	public String getUrre007() {
		return urre007;
	}

	public void setUrre007(String urre007) {
		this.urre007 = urre007;
	}

	public String getUrre008() {
		return urre008;
	}

	public void setUrre008(String urre008) {
		this.urre008 = urre008;
	}

	public String getUrre009() {
		return urre009;
	}

	public void setUrre009(String urre009) {
		this.urre009 = urre009;
	}

	public Date getUrre010() {
		return urre010;
	}

	public void setUrre010(Date urre010) {
		this.urre010 = urre010;
	}

	public Integer getUrre011() {
		return urre011;
	}

	public void setUrre011(Integer urre011) {
		this.urre011 = urre011;
	}

	public String getUrre012() {
		return urre012;
	}

	public void setUrre012(String urre012) {
		this.urre012 = urre012;
	}

	public String getUrre013() {
		return urre013;
	}

	public void setUrre013(String urre013) {
		this.urre013 = urre013;
	}

	public String getUrre014() {
		return urre014;
	}

	public void setUrre014(String urre014) {
		this.urre014 = urre014;
	}

	public String getUrre001() {
		return urre001;
	}

	public void setUrre001(String urre001) {
		this.urre001 = urre001;
	}

	public String getUrre002() {
		return urre002;
	}

	public void setUrre002(String urre002) {
		this.urre002 = urre002;
	}

	public String getUrre003() {
		return urre003;
	}

	public void setUrre003(String urre003) {
		this.urre003 = urre003;
	}

	@Override
	protected Serializable pkVal() {
		return this.urre001;
	}

}

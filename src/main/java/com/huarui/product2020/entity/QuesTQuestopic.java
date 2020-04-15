package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * ${table.comment}
 * </p>
 *
 * @author Chenrui
 * @since 2017-08-13
 */
@TableName("QUES_T_QUESTOPIC")
public class QuesTQuestopic extends Model<QuesTQuestopic> {

    private static final long serialVersionUID = 1L;

    @TableId("QTOP001")
	private String qtop001;
    /**
     * 试卷ID
     */
	@TableField("QTOP002")
	private String qtop002;
    /**
     * 目录ID：用于统计策略试题分布
     */
	@TableField("QTOP003")
	private String qtop003;
    /**
     * 试题ID
     */
	@TableField("QTOP004")
	private String qtop004;
    /**
     * 	题号
     */
	@TableField("QTOP005")
	private String qtop005;
    /**
     * 	一级分项
     */
	@TableField("QTOP006")
	private String qtop006;
    /**
     * 	二级分项
     */
	@TableField("QTOP007")
	private String qtop007;
    /**
     * 	题型ID
     */
	@TableField("QTOP008")
	private String qtop008;
    /**
     * 题型标题
     */
	@TableField("QTOP009")
	private String qtop009;
    /**
     * 	内容
     */
	@TableField("QTOP010")
	private String qtop010;
    /**
     * 内容纯文本
     */
	@TableField("QTOP011")
	private String qtop011;
    /**
     * 选项数
     */
	@TableField("QTOP012")
	private Double qtop012;
    /**
     * 题目选项
     */
	@TableField("QTOP013")
	private String qtop013;
    /**
     * 题目选项纯文本
     */
	@TableField("QTOP014")
	private String qtop014;
    /**
     * 	K值
     */
	@TableField("QTOP015")
	private String qtop015;
    /**
     * 	说明
     */
	@TableField("QTOP016")
	private String qtop016;
    /**
     * 	试题状态：1、启用 2、禁用 def(1)
     */
	@TableField("QTOP017")
	private Double qtop017;
    /**
     * 	顺序号
     */
	@TableField("QTOP018")
	private Double qtop018;


	public String getQtop001() {
		return qtop001;
	}

	public void setQtop001(String qtop001) {
		this.qtop001 = qtop001;
	}

	public String getQtop002() {
		return qtop002;
	}

	public void setQtop002(String qtop002) {
		this.qtop002 = qtop002;
	}

	public String getQtop003() {
		return qtop003;
	}

	public void setQtop003(String qtop003) {
		this.qtop003 = qtop003;
	}

	public String getQtop004() {
		return qtop004;
	}

	public void setQtop004(String qtop004) {
		this.qtop004 = qtop004;
	}

	public String getQtop005() {
		return qtop005;
	}

	public void setQtop005(String qtop005) {
		this.qtop005 = qtop005;
	}

	public String getQtop006() {
		return qtop006;
	}

	public void setQtop006(String qtop006) {
		this.qtop006 = qtop006;
	}

	public String getQtop007() {
		return qtop007;
	}

	public void setQtop007(String qtop007) {
		this.qtop007 = qtop007;
	}

	public String getQtop008() {
		return qtop008;
	}

	public void setQtop008(String qtop008) {
		this.qtop008 = qtop008;
	}

	public String getQtop009() {
		return qtop009;
	}

	public void setQtop009(String qtop009) {
		this.qtop009 = qtop009;
	}

	public String getQtop010() {
		return qtop010;
	}

	public void setQtop010(String qtop010) {
		this.qtop010 = qtop010;
	}

	public String getQtop011() {
		return qtop011;
	}

	public void setQtop011(String qtop011) {
		this.qtop011 = qtop011;
	}

	public Double getQtop012() {
		return qtop012;
	}

	public void setQtop012(Double qtop012) {
		this.qtop012 = qtop012;
	}

	public String getQtop013() {
		return qtop013;
	}

	public void setQtop013(String qtop013) {
		this.qtop013 = qtop013;
	}

	public String getQtop014() {
		return qtop014;
	}

	public void setQtop014(String qtop014) {
		this.qtop014 = qtop014;
	}

	public String getQtop015() {
		return qtop015;
	}

	public void setQtop015(String qtop015) {
		this.qtop015 = qtop015;
	}

	public String getQtop016() {
		return qtop016;
	}

	public void setQtop016(String qtop016) {
		this.qtop016 = qtop016;
	}

	public Double getQtop017() {
		return qtop017;
	}

	public void setQtop017(Double qtop017) {
		this.qtop017 = qtop017;
	}

	public Double getQtop018() {
		return qtop018;
	}

	public void setQtop018(Double qtop018) {
		this.qtop018 = qtop018;
	}

	@Override
	protected Serializable pkVal() {
		return this.qtop001;
	}

}

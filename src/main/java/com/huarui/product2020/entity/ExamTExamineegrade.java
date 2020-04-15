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
@TableName("EXAM_T_EXAMINEEGRADE")
public class ExamTExamineegrade extends Model<ExamTExamineegrade> {

    private static final long serialVersionUID = 1L;

    @TableId("EGRA001")
	private String egra001;
    /**
     * 考生ID
     */
	@TableField("EGRA002")
	private String egra002;
    /**
     * 登录日志ID
     */
	@TableField("EGRA003")
	private String egra003;
    /**
     * 试卷ID
     */
	@TableField("EGRA004")
	private String egra004;
    /**
     * 序号
     */
	@TableField("EGRA005")
	private Long egra005;
    /**
     * 考试次数
     */
	@TableField("EGRA006")
	private Long egra006;
    /**
     * 考生状态
1:待考 
2:考试中未提交 
3:已提交
4:已提交未判卷 
5:已提交已判卷
     */
	@TableField("EGRA007")
	private Long egra007;
    /**
     * 考试开始时间
     */
	@TableField("EGRA008")
	private Date egra008;
    /**
     * 考试结束时间
     */
	@TableField("EGRA009")
	private Date egra009;
    /**
     * 考试用时
     */
	@TableField("EGRA010")
	private Long egra010;
    /**
     * 客观题得分
     */
	@TableField("EGRA011")
	private Float egra011;
    /**
     * 主观题得分
     */
	@TableField("EGRA012")
	private Float egra012;
    /**
     * 考试成绩
     */
	@TableField("EGRA013")
	private Float egra013;
    /**
     * 修改说明
     */
	@TableField("EGRA014")
	private String egra014;
    /**
     * 成绩来源
DEF（0）
0：参加机考
1：参加笔考（直接导入）
     */
	@TableField("EGRA015")
	private Long egra015;
    /**
     * 导入时间
     */
	@TableField("EGRA016")
	private Date egra016;
    /**
     * 评价等级
     */
	@TableField("EGRA017")
	private String egra017;
    /**
     * 评价内容
     */
	@TableField("EGRA018")
	private String egra018;
    /**
     * 成绩状态：1 正常状态 2 异常退出
     */
	@TableField("EGRA019")
	private Integer egra019;
    /**
     * 最后响应时间
     */
	@TableField("EGRA020")
	private Date egra020;


	public String getEgra001() {
		return egra001;
	}

	public void setEgra001(String egra001) {
		this.egra001 = egra001;
	}

	public String getEgra002() {
		return egra002;
	}

	public void setEgra002(String egra002) {
		this.egra002 = egra002;
	}

	public String getEgra003() {
		return egra003;
	}

	public void setEgra003(String egra003) {
		this.egra003 = egra003;
	}

	public String getEgra004() {
		return egra004;
	}

	public void setEgra004(String egra004) {
		this.egra004 = egra004;
	}

	public Long getEgra005() {
		return egra005;
	}

	public void setEgra005(Long egra005) {
		this.egra005 = egra005;
	}

	public Long getEgra006() {
		return egra006;
	}

	public void setEgra006(Long egra006) {
		this.egra006 = egra006;
	}

	public Long getEgra007() {
		return egra007;
	}

	public void setEgra007(Long egra007) {
		this.egra007 = egra007;
	}

	public Date getEgra008() {
		return egra008;
	}

	public void setEgra008(Date egra008) {
		this.egra008 = egra008;
	}

	public Date getEgra009() {
		return egra009;
	}

	public void setEgra009(Date egra009) {
		this.egra009 = egra009;
	}

	public Long getEgra010() {
		return egra010;
	}

	public void setEgra010(Long egra010) {
		this.egra010 = egra010;
	}

	public Float getEgra011() {
		return egra011;
	}

	public void setEgra011(Float egra011) {
		this.egra011 = egra011;
	}

	public Float getEgra012() {
		return egra012;
	}

	public void setEgra012(Float egra012) {
		this.egra012 = egra012;
	}

	public Float getEgra013() {
		return egra013;
	}

	public void setEgra013(Float egra013) {
		this.egra013 = egra013;
	}

	public String getEgra014() {
		return egra014;
	}

	public void setEgra014(String egra014) {
		this.egra014 = egra014;
	}

	public Long getEgra015() {
		return egra015;
	}

	public void setEgra015(Long egra015) {
		this.egra015 = egra015;
	}

	public Date getEgra016() {
		return egra016;
	}

	public void setEgra016(Date egra016) {
		this.egra016 = egra016;
	}

	public String getEgra017() {
		return egra017;
	}

	public void setEgra017(String egra017) {
		this.egra017 = egra017;
	}

	public String getEgra018() {
		return egra018;
	}

	public void setEgra018(String egra018) {
		this.egra018 = egra018;
	}

	public Integer getEgra019() {
		return egra019;
	}

	public void setEgra019(Integer egra019) {
		this.egra019 = egra019;
	}

	public Date getEgra020() {
		return egra020;
	}

	public void setEgra020(Date egra020) {
		this.egra020 = egra020;
	}

	@Override
	protected Serializable pkVal() {
		return this.egra001;
	}

}

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
@TableName("EXAM_T_TESTTOPIC")
public class ExamTTesttopic extends Model<ExamTTesttopic> {

    private static final long serialVersionUID = 1L;

    @TableId("TTOP001")
	private String ttop001;
    /**
     * 出题方式   1、固定 2、随机
     */
	@TableField("TTOP002")
	private Integer ttop002;
    /**
     * 试卷ID
     */
	@TableField("TTOP003")
	private String ttop003;
    /**
     * 试卷编号   用于随机试卷
     */
	@TableField("TTOP004")
	private Long ttop004;
    /**
     * 目录ID
     */
	@TableField("TTOP005")
	private String ttop005;
	@TableField("TTOP006")
	private String ttop006;
    /**
     * 题号
     */
	@TableField("TTOP007")
	private String ttop007;
    /**
     * 知识点
     */
	@TableField("TTOP008")
	private String ttop008;
    /**
     * 题型
     */
	@TableField("TTOP009")
	private String ttop009;
    /**
     * 题型标题
     */
	@TableField("TTOP010")
	private String ttop010;
    /**
     * 内容
     */
	@TableField("TTOP011")
	private String ttop011;
    /**
     * 内容纯文本
     */
	@TableField("TTOP012")
	private String ttop012;
    /**
     * 难度  5：难,4：较难,3：中等,2：较易,1：易
     */
	@TableField("TTOP013")
	private Long ttop013;
    /**
     * 认知层次    识记,理解,简单应用,综合应用
     */
	@TableField("TTOP014")
	private String ttop014;
    /**
     * 考试要求   了解,熟悉,掌握,熟练掌握
     */
	@TableField("TTOP015")
	private String ttop015;
    /**
     * 分数
     */
	@TableField("TTOP016")
	private Float ttop016;
    /**
     * 选项数
     */
	@TableField("TTOP017")
	private Long ttop017;
    /**
     * 题目选项
     */
	@TableField("TTOP018")
	private String ttop018;
    /**
     * 题目选项纯文本
     */
	@TableField("TTOP019")
	private String ttop019;
    /**
     * K值
     */
	@TableField("TTOP020")
	private String ttop020;
    /**
     * 主观题标准答案
     */
	@TableField("TTOP021")
	private String ttop021;
    /**
     * 客观题标准答案
     */
	@TableField("TTOP022")
	private String ttop022;
    /**
     * 题解
     */
	@TableField("TTOP023")
	private String ttop023;
    /**
     * 自关联ID
     */
	@TableField("TTOP024")
	private String ttop024;
    /**
     * 答题限制时间  （秒）
     */
	@TableField("TTOP025")
	private Long ttop025;
    /**
     * 试题状态   1、启用  2、禁用 def(1)
     */
	@TableField("TTOP026")
	private Long ttop026;
    /**
     * 顺序号
     */
	@TableField("TTOP027")
	private Long ttop027;
    /**
     * 字符型备用字段
     */
	@TableField("TTOP028")
	private String ttop028;
    /**
     * 字符型备用字段
     */
	@TableField("TTOP029")
	private String ttop029;
    /**
     * 字符型备用字段
     */
	@TableField("TTOP030")
	private String ttop030;
    /**
     * 字符型备用字段
     */
	@TableField("TTOP031")
	private String ttop031;
    /**
     * 数字型备用字段
     */
	@TableField("TTOP032")
	private Long ttop032;
    /**
     * 数字型备用字段
     */
	@TableField("TTOP033")
	private Long ttop033;
    /**
     * 日期型备用字段
     */
	@TableField("TTOP034")
	private Date ttop034;
    /**
     * 日期型备用字段
     */
	@TableField("TTOP035")
	private Date ttop035;


	public String getTtop001() {
		return ttop001;
	}

	public void setTtop001(String ttop001) {
		this.ttop001 = ttop001;
	}

	public Integer getTtop002() {
		return ttop002;
	}

	public void setTtop002(Integer ttop002) {
		this.ttop002 = ttop002;
	}

	public String getTtop003() {
		return ttop003;
	}

	public void setTtop003(String ttop003) {
		this.ttop003 = ttop003;
	}

	public Long getTtop004() {
		return ttop004;
	}

	public void setTtop004(Long ttop004) {
		this.ttop004 = ttop004;
	}

	public String getTtop005() {
		return ttop005;
	}

	public void setTtop005(String ttop005) {
		this.ttop005 = ttop005;
	}

	public String getTtop006() {
		return ttop006;
	}

	public void setTtop006(String ttop006) {
		this.ttop006 = ttop006;
	}

	public String getTtop007() {
		return ttop007;
	}

	public void setTtop007(String ttop007) {
		this.ttop007 = ttop007;
	}

	public String getTtop008() {
		return ttop008;
	}

	public void setTtop008(String ttop008) {
		this.ttop008 = ttop008;
	}

	public String getTtop009() {
		return ttop009;
	}

	public void setTtop009(String ttop009) {
		this.ttop009 = ttop009;
	}

	public String getTtop010() {
		return ttop010;
	}

	public void setTtop010(String ttop010) {
		this.ttop010 = ttop010;
	}

	public String getTtop011() {
		return ttop011;
	}

	public void setTtop011(String ttop011) {
		this.ttop011 = ttop011;
	}

	public String getTtop012() {
		return ttop012;
	}

	public void setTtop012(String ttop012) {
		this.ttop012 = ttop012;
	}

	public Long getTtop013() {
		return ttop013;
	}

	public void setTtop013(Long ttop013) {
		this.ttop013 = ttop013;
	}

	public String getTtop014() {
		return ttop014;
	}

	public void setTtop014(String ttop014) {
		this.ttop014 = ttop014;
	}

	public String getTtop015() {
		return ttop015;
	}

	public void setTtop015(String ttop015) {
		this.ttop015 = ttop015;
	}

	public Float getTtop016() {
		return ttop016;
	}

	public void setTtop016(Float ttop016) {
		this.ttop016 = ttop016;
	}

	public Long getTtop017() {
		return ttop017;
	}

	public void setTtop017(Long ttop017) {
		this.ttop017 = ttop017;
	}

	public String getTtop018() {
		return ttop018;
	}

	public void setTtop018(String ttop018) {
		this.ttop018 = ttop018;
	}

	public String getTtop019() {
		return ttop019;
	}

	public void setTtop019(String ttop019) {
		this.ttop019 = ttop019;
	}

	public String getTtop020() {
		return ttop020;
	}

	public void setTtop020(String ttop020) {
		this.ttop020 = ttop020;
	}

	public String getTtop021() {
		return ttop021;
	}

	public void setTtop021(String ttop021) {
		this.ttop021 = ttop021;
	}

	public String getTtop022() {
		return ttop022;
	}

	public void setTtop022(String ttop022) {
		this.ttop022 = ttop022;
	}

	public String getTtop023() {
		return ttop023;
	}

	public void setTtop023(String ttop023) {
		this.ttop023 = ttop023;
	}

	public String getTtop024() {
		return ttop024;
	}

	public void setTtop024(String ttop024) {
		this.ttop024 = ttop024;
	}

	public Long getTtop025() {
		return ttop025;
	}

	public void setTtop025(Long ttop025) {
		this.ttop025 = ttop025;
	}

	public Long getTtop026() {
		return ttop026;
	}

	public void setTtop026(Long ttop026) {
		this.ttop026 = ttop026;
	}

	public Long getTtop027() {
		return ttop027;
	}

	public void setTtop027(Long ttop027) {
		this.ttop027 = ttop027;
	}

	public String getTtop028() {
		return ttop028;
	}

	public void setTtop028(String ttop028) {
		this.ttop028 = ttop028;
	}

	public String getTtop029() {
		return ttop029;
	}

	public void setTtop029(String ttop029) {
		this.ttop029 = ttop029;
	}

	public String getTtop030() {
		return ttop030;
	}

	public void setTtop030(String ttop030) {
		this.ttop030 = ttop030;
	}

	public String getTtop031() {
		return ttop031;
	}

	public void setTtop031(String ttop031) {
		this.ttop031 = ttop031;
	}

	public Long getTtop032() {
		return ttop032;
	}

	public void setTtop032(Long ttop032) {
		this.ttop032 = ttop032;
	}

	public Long getTtop033() {
		return ttop033;
	}

	public void setTtop033(Long ttop033) {
		this.ttop033 = ttop033;
	}

	public Date getTtop034() {
		return ttop034;
	}

	public void setTtop034(Date ttop034) {
		this.ttop034 = ttop034;
	}

	public Date getTtop035() {
		return ttop035;
	}

	public void setTtop035(Date ttop035) {
		this.ttop035 = ttop035;
	}

	@Override
	protected Serializable pkVal() {
		return this.ttop001;
	}

}

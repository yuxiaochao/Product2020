package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
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
@TableName("EXAM_T_TOPIC")
public class ExamTTopic extends Model<ExamTTopic> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@TableField("TOPI001")
	private String topi001;
    /**
     * 试题编号
     */
	@TableField("TOPI002")
	private String topi002;
    /**
     * 知识点
     */
	@TableField("TOPI003")
	private String topi003;
    /**
     * 题型
     */
	@TableField("TOPI004")
	private String topi004;
    /**
     * 题型标题
     */
	@TableField("TOPI005")
	private String topi005;
    /**
     * 内容
     */
	@TableField("TOPI006")
	private String topi006;
    /**
     * 内容纯文本
     */
	@TableField("TOPI007")
	private String topi007;
    /**
     * 难度  5：难,4：较难,3：中等,2：较易,1：易
     */
	@TableField("TOPI008")
	private Long topi008;
    /**
     * 认知层次   识记,理解,简单应用,综合应用
     */
	@TableField("TOPI009")
	private String topi009;
    /**
     * 考试要求 了解,熟悉,掌握,熟练掌握
     */
	@TableField("TOPI010")
	private String topi010;
    /**
     * 分数
     */
	@TableField("TOPI011")
	private Float topi011;
    /**
     * 选项数
     */
	@TableField("TOPI012")
	private Long topi012;
    /**
     * 题目选项
     */
	@TableField("TOPI013")
	private String topi013;
    /**
     * 题目选项纯文本
     */
	@TableField("TOPI014")
	private String topi014;
    /**
     * K值
     */
	@TableField("TOPI015")
	private String topi015;
    /**
     * 主观题标准答案
     */
	@TableField("TOPI016")
	private String topi016;
    /**
     * 客观题标准答案
     */
	@TableField("TOPI017")
	private String topi017;
    /**
     * 题解
     */
	@TableField("TOPI018")
	private String topi018;
    /**
     * 自关联ID
     */
	@TableField("TOPI019")
	private String topi019;
    /**
     * 答题限制时间（秒）
     */
	@TableField("TOPI020")
	private Long topi020;
    /**
     * 试题状态 1、启用  2、禁用 def(1)
     */
	@TableField("TOPI021")
	private Long topi021;
    /**
     * 顺序号
     */
	@TableField("TOPI022")
	private Long topi022;
    /**
     * 字符型备用字段
     */
	@TableField("TOPI023")
	private String topi023;
    /**
     * 字符型备用字段
     */
	@TableField("TOPI024")
	private String topi024;
    /**
     * 字符型备用字段
     */
	@TableField("TOPI025")
	private String topi025;
    /**
     * 字符型备用字段
     */
	@TableField("TOPI026")
	private String topi026;
    /**
     * 数字型备用字段
     */
	@TableField("TOPI027")
	private Long topi027;
    /**
     * 数字型备用字段
     */
	@TableField("TOPI028")
	private Long topi028;
    /**
     * 日期型备用字段
     */
	@TableField("TOPI029")
	private Date topi029;
    /**
     * 日期型备用字段
     */
	@TableField("TOPI030")
	private Date topi030;

	private String organname;
	
	/**
	 * 共享人
	 */
	private String tosh002name;

	private Date tosh003;
	
	public String getTopi001() {
		return topi001;
	}

	public void setTopi001(String topi001) {
		this.topi001 = topi001;
	}

	public String getTopi002() {
		return topi002;
	}

	public void setTopi002(String topi002) {
		this.topi002 = topi002;
	}

	public String getTopi003() {
		return topi003;
	}

	public void setTopi003(String topi003) {
		this.topi003 = topi003;
	}

	public String getTopi004() {
		return topi004;
	}

	public void setTopi004(String topi004) {
		this.topi004 = topi004;
	}

	public String getTopi005() {
		return topi005;
	}

	public void setTopi005(String topi005) {
		this.topi005 = topi005;
	}

	public String getTopi006() {
		return topi006;
	}

	public void setTopi006(String topi006) {
		this.topi006 = topi006;
	}

	public String getTopi007() {
		return topi007;
	}

	public void setTopi007(String topi007) {
		this.topi007 = topi007;
	}

	public Long getTopi008() {
		return topi008;
	}

	public void setTopi008(Long topi008) {
		this.topi008 = topi008;
	}

	public String getTopi009() {
		return topi009;
	}

	public void setTopi009(String topi009) {
		this.topi009 = topi009;
	}

	public String getTopi010() {
		return topi010;
	}

	public void setTopi010(String topi010) {
		this.topi010 = topi010;
	}

	public Float getTopi011() {
		return topi011;
	}

	public void setTopi011(Float topi011) {
		this.topi011 = topi011;
	}

	public Long getTopi012() {
		return topi012;
	}

	public void setTopi012(Long topi012) {
		this.topi012 = topi012;
	}

	public String getTopi013() {
		return topi013;
	}

	public void setTopi013(String topi013) {
		this.topi013 = topi013;
	}

	public String getTopi014() {
		return topi014;
	}

	public void setTopi014(String topi014) {
		this.topi014 = topi014;
	}

	public String getTopi015() {
		return topi015;
	}

	public void setTopi015(String topi015) {
		this.topi015 = topi015;
	}

	public String getTopi016() {
		return topi016;
	}

	public void setTopi016(String topi016) {
		this.topi016 = topi016;
	}

	public String getTopi017() {
		return topi017;
	}

	public void setTopi017(String topi017) {
		this.topi017 = topi017;
	}

	public String getTopi018() {
		return topi018;
	}

	public void setTopi018(String topi018) {
		this.topi018 = topi018;
	}

	public String getTopi019() {
		return topi019;
	}

	public void setTopi019(String topi019) {
		this.topi019 = topi019;
	}

	public Long getTopi020() {
		return topi020;
	}

	public void setTopi020(Long topi020) {
		this.topi020 = topi020;
	}

	public Long getTopi021() {
		return topi021;
	}

	public void setTopi021(Long topi021) {
		this.topi021 = topi021;
	}

	public Long getTopi022() {
		return topi022;
	}

	public void setTopi022(Long topi022) {
		this.topi022 = topi022;
	}

	public String getTopi023() {
		return topi023;
	}

	public void setTopi023(String topi023) {
		this.topi023 = topi023;
	}

	public String getTopi024() {
		return topi024;
	}

	public void setTopi024(String topi024) {
		this.topi024 = topi024;
	}

	public String getTopi025() {
		return topi025;
	}

	public void setTopi025(String topi025) {
		this.topi025 = topi025;
	}

	public String getTopi026() {
		return topi026;
	}

	public void setTopi026(String topi026) {
		this.topi026 = topi026;
	}

	public Long getTopi027() {
		return topi027;
	}

	public void setTopi027(Long topi027) {
		this.topi027 = topi027;
	}

	public Long getTopi028() {
		return topi028;
	}

	public void setTopi028(Long topi028) {
		this.topi028 = topi028;
	}

	public Date getTopi029() {
		return topi029;
	}

	public void setTopi029(Date topi029) {
		this.topi029 = topi029;
	}

	public Date getTopi030() {
		return topi030;
	}

	public void setTopi030(Date topi030) {
		this.topi030 = topi030;
	}

	@Override
	protected Serializable pkVal() {
		return this.topi001;
	}

	public String getOrganname() {
		return organname;
	}

	public void setOrganname(String organname) {
		this.organname = organname;
	}

	public String getTosh002name() {
		return tosh002name;
	}

	public void setTosh002name(String tosh002name) {
		this.tosh002name = tosh002name;
	}

	public Date getTosh003() {
		return tosh003;
	}

	public void setTosh003(Date tosh003) {
		this.tosh003 = tosh003;
	}

	
}

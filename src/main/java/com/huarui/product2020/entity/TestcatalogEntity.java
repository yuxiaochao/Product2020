package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

public class TestcatalogEntity extends Model<TestcatalogEntity> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6247684373183351788L;
	
	 /**
	 * 主键
	 */
	private String cata001;
	 /**
	 * 目录名称
	 */
	private String cata002;
	 /**
	 * 目录编码
	 */
	private String cata003;
	 /**
	 * Parent ID
	 */
	private String cata004;
	 /**
	 * parent编码
	 */
	private String cata005;
	 /**
	 * 排序号
	 */
	private Integer cata006;
	 /**
	 * 目录类型：1、试卷目录（在线考试-岸端） 2、试卷目录（在线考试-船端）
	 */
	private Integer cata008;
	
	/**
	 * 目录类型 1、数据字典 2、岗位序列 3、群组目录 4、题库目录等
	 */
	private String cata008_2;
	
	/**
	 * 数量
	 */
	private Integer resnum;
	
	 /**
	 * 主办单位ID
	 */
	private String cata009;
	/**
	 * 主办单位
	 */
	private String organname;
	
	/**
	 * 责任人ID
	 */
	private String user001;
	
	/**
	 * 主办单位ID
	 */
	private String orga001;
	
	 /**
	 * 目录路径
	 */
	private String cata010;
	 /**
	 * 目录层级
	 */
	private Integer cata011;
	
	 /**
	 * 创建人ID
	 */
	private String cata013;
	
	private String user005;
	
	/**
	 * 目录状态：1、启用 2、禁用
	 */
	private Integer cata012;
	
	/**
	 * 最后修改时间
	 */
	private Date cata014;
	
	/**
	 * 说明
	 */
//	@Column(displayName = "说明", hideType = ColumnHideType.TABLEPHONE, fixedWidth=15, order = 15)
	private String cata015;
	
	/**
	 * 图片路径（面向学习主题）
	 */
	private String cata016;
	
	/**
	 * 题库对应的题目数量
	 */
	private String counts;

	/**
	 * 题库练习已答题目数量
	 */
	private String YD;

	/**
	 * 题库练习未答题目数量
	 */
	private String WD;

	/**
	 * 题库练习答错题目数量
	 */
	private String CW;

	/**
	 * 题库练习答对题目数量
	 */
	private String ZQ;

	/**
	 * 题库练习正确率
	 */
	private String ZQL;

	/**
	 * 题库练习掌握率
	 */
	private String ZWL;
	
	/**
	 * 子节点数量
	 */
	private Integer childcount;
	
	/**
	 * 用于控制查询类型，当编辑时，校验排除自己，1是，0不是
	 */
	private Integer isEdit;
	
	public String getCata001() {
		return cata001;
	}
	public void setCata001(String cata001) {
		this.cata001 = cata001;
	}
	public String getCata002() {
		return cata002;
	}
	public void setCata002(String cata002) {
		this.cata002 = cata002;
	}
	public String getCata003() {
		return cata003;
	}
	public void setCata003(String cata003) {
		this.cata003 = cata003;
	}
	public String getCata004() {
		return cata004;
	}
	public void setCata004(String cata004) {
		this.cata004 = cata004;
	}
	public String getCata005() {
		return cata005;
	}
	public void setCata005(String cata005) {
		this.cata005 = cata005;
	}
	public Integer getCata006() {
		return cata006;
	}
	public void setCata006(Integer cata006) {
		this.cata006 = cata006;
	}
	public Integer getCata008() {
		return cata008;
	}
	public void setCata008(Integer cata008) {
		this.cata008 = cata008;
	}
	public String getCata009() {
		return cata009;
	}
	public void setCata009(String cata009) {
		this.cata009 = cata009;
	}
	public String getUser001() {
		return user001;
	}
	public void setUser001(String user001) {
		this.user001 = user001;
	}
	public String getOrga001() {
		return orga001;
	}
	public void setOrga001(String orga001) {
		this.orga001 = orga001;
	}
	public String getOrganname() {
		return organname;
	}
	public void setOrganname(String organname) {
		this.organname = organname;
	}
	public String getCata010() {
		return cata010;
	}
	public void setCata010(String cata010) {
		this.cata010 = cata010;
	}
	public Integer getCata011() {
		return cata011;
	}
	public void setCata011(Integer cata011) {
		this.cata011 = cata011;
	}
	public Integer getCata012() {
		return cata012;
	}
	public void setCata012(Integer cata012) {
		this.cata012 = cata012;
	}
	public String getCata013() {
		return cata013;
	}
	public void setCata013(String cata013) {
		this.cata013 = cata013;
	}
	public String getUser005() {
		return user005;
	}
	public void setUser005(String user005) {
		this.user005 = user005;
	}
	public Integer getResnum() {
		return resnum;
	}
	public void setResnum(Integer resnum) {
		this.resnum = resnum;
	}
	public Date getCata014() {
		return cata014;
	}
	public void setCata014(Date cata014) {
		this.cata014 = cata014;
	}
	public String getCata015() {
		return cata015;
	}
	public void setCata015(String cata015) {
		this.cata015 = cata015;
	}
	public String getCounts() {
		return counts;
	}
	public void setCounts(String counts) {
		this.counts = counts;
	}
	public String getYD() {
		return YD;
	}
	public void setYD(String yD) {
		YD = yD;
	}
	public String getWD() {
		return WD;
	}
	public void setWD(String wD) {
		WD = wD;
	}
	public String getCW() {
		return CW;
	}
	public void setCW(String cW) {
		CW = cW;
	}
	public String getZQ() {
		return ZQ;
	}
	public void setZQ(String zQ) {
		ZQ = zQ;
	}
	public String getZQL() {
		return ZQL;
	}
	public void setZQL(String zQL) {
		ZQL = zQL;
	}
	public String getZWL() {
		return ZWL;
	}
	public void setZWL(String zWL) {
		ZWL = zWL;
	}
	public Integer getChildcount() {
		return childcount;
	}
	public void setChildcount(Integer childcount) {
		this.childcount = childcount;
	}
	public String getCata008_2() {
		return cata008_2;
	}
	public void setCata008_2(String cata008_2) {
		this.cata008_2 = cata008_2;
	}
	public String getCata016() {
		return cata016;
	}
	public void setCata016(String cata016) {
		this.cata016 = cata016;
	}
	public Integer getIsEdit() {
		return isEdit;
	}
	public void setIsEdit(Integer isEdit) {
		this.isEdit = isEdit;
	}
	@Override
	protected Serializable pkVal() {
		return this.cata001;
	}
	
}

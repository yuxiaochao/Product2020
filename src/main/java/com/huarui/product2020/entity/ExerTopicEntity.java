package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;

import java.io.Serializable;

public class ExerTopicEntity extends Model<ExerTopicEntity>{

	private static final long serialVersionUID = 375952943435715436L;
	
	private String exto001;

	/**
	 * 练习ID
	 */
	private String exto002;

	/**
	 * 成绩ID
	 */
	private String exto003;

	/**
	 * 抽题ID
	 */
	private String exto004;

	/**
	 * 试题ID
	 */
	private String exto005;

	/**
	 * 题号
	 */
	private String exto006;

	/**
	 * 知识点
	 */
	private String exto007;

	/**
	 * 题型ID
	 */
	private String exto008;

	/**
	 * 题型标题
	 */
	private String exto009;

	/**
	 * 试题内容
	 */
	private String exto010;

	/**
	 * 内容纯文本
	 */
	private String exto011;

	/**
	 * 难度：5、难 4、较难 3、中等 2、较易 1、容易
	 */
	private Integer exto012;

	/**
	 * 认知层次：识记,理解,简单应用,综合应用
	 */
	private String exto013;

	/**
	 * 考试要求：了解,熟悉,掌握,熟练掌握
	 */
	private String exto014;

	/**
	 * 分数
	 */
	private Integer exto015;

	/**
	 * 选项数
	 */
	private Integer exto016;

	/**
	 * 题目选项
	 */
	private String exto017;

	/**
	 * 题目选项纯文本
	 */
	private String exto018;

	/**
	 * K值
	 */
	private String exto019;

	/**
	 * 主观题标准答案
	 */
	private String exto020;

	/**
	 * 客观题标准答案
	 */
	private String exto021;

	/**
	 * 题解
	 */
	private String exto022;

	/**
	 * 自关联ID
	 */
	private String exto023;

	/**
	 * 答题限制时间（秒）
	 */
	private Integer exto024;

	/**
	 * 试题状态：1、启用 2、禁用 def(1)
	 */
	private Integer exto025;

	/**
	 * 顺序号
	 */
	private Integer exto026;


	public void setExto001(String exto001){
		this.exto001 = exto001;
	}

	public String getExto001(){
		return exto001;
	}
	public void setExto002(String exto002){
		this.exto002 = exto002;
	}

	public String getExto002(){
		return exto002;
	}
	public void setExto003(String exto003){
		this.exto003 = exto003;
	}

	public String getExto003(){
		return exto003;
	}
	public void setExto004(String exto004){
		this.exto004 = exto004;
	}

	public String getExto004(){
		return exto004;
	}
	public void setExto005(String exto005){
		this.exto005 = exto005;
	}

	public String getExto005(){
		return exto005;
	}
	public void setExto006(String exto006){
		this.exto006 = exto006;
	}

	public String getExto006(){
		return exto006;
	}
	public void setExto007(String exto007){
		this.exto007 = exto007;
	}

	public String getExto007(){
		return exto007;
	}
	public void setExto008(String exto008){
		this.exto008 = exto008;
	}

	public String getExto008(){
		return exto008;
	}
	public void setExto009(String exto009){
		this.exto009 = exto009;
	}

	public String getExto009(){
		return exto009;
	}
	public void setExto010(String exto010){
		this.exto010 = exto010;
	}

	public String getExto010(){
		return exto010;
	}
	public void setExto011(String exto011){
		this.exto011 = exto011;
	}

	public String getExto011(){
		return exto011;
	}
	public void setExto012(Integer exto012){
		this.exto012 = exto012;
	}

	public Integer getExto012(){
		return exto012;
	}
	public void setExto013(String exto013){
		this.exto013 = exto013;
	}

	public String getExto013(){
		return exto013;
	}
	public void setExto014(String exto014){
		this.exto014 = exto014;
	}

	public String getExto014(){
		return exto014;
	}
	public void setExto015(Integer exto015){
		this.exto015 = exto015;
	}

	public Integer getExto015(){
		return exto015;
	}
	public void setExto016(Integer exto016){
		this.exto016 = exto016;
	}

	public Integer getExto016(){
		return exto016;
	}
	public void setExto017(String exto017){
		this.exto017 = exto017;
	}

	public String getExto017(){
		return exto017;
	}
	public void setExto018(String exto018){
		this.exto018 = exto018;
	}

	public String getExto018(){
		return exto018;
	}
	public void setExto019(String exto019){
		this.exto019 = exto019;
	}

	public String getExto019(){
		return exto019;
	}
	public void setExto020(String exto020){
		this.exto020 = exto020;
	}

	public String getExto020(){
		return exto020;
	}
	public void setExto021(String exto021){
		this.exto021 = exto021;
	}

	public String getExto021(){
		return exto021;
	}
	public void setExto022(String exto022){
		this.exto022 = exto022;
	}

	public String getExto022(){
		return exto022;
	}
	public void setExto023(String exto023){
		this.exto023 = exto023;
	}

	public String getExto023(){
		return exto023;
	}
	public void setExto024(Integer exto024){
		this.exto024 = exto024;
	}

	public Integer getExto024(){
		return exto024;
	}
	public void setExto025(Integer exto025){
		this.exto025 = exto025;
	}

	public Integer getExto025(){
		return exto025;
	}
	public void setExto026(Integer exto026){
		this.exto026 = exto026;
	}

	public Integer getExto026(){
		return exto026;
	}

	protected Serializable pkVal() {
		return this.exto001;
	}
	
}
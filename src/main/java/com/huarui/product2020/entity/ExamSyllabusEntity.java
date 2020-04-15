package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

public class ExamSyllabusEntity extends Model<ExamTBasetx>{

	private static final long serialVersionUID = 59740906504634816L;
	
	/**
	 * 主键
	 */
	private String exsy001;

	/**
	 * 大纲名称
	 */
	private String exsy002;

	/**
	 * 大纲父id
	 */
	private String exsy003;

	/**
	 * 大纲层级
	 */
	private Integer exsy004;

	/**
	 * 适用科目分类（1.理论考试大纲 2.实操考试大纲 3.业绩评价大纲 4.潜在能力大纲 5.综合评价大纲）
	 */
	private Integer exsy005;

	/**
	 * 大纲类别：（1.工种考试大纲 2.技能考试大纲）
	 */
	private Integer exsy006;

	/**
	 * 发布单位
	 */
	private String exsy007;

	/**
	 * 创建人
	 */
	private String exsy008;

	/**
	 * 创建时间
	 */
	private Date exsy009;

	/**
	 * 最后修改时间
	 */
	private Date exsy010;
	
	/**
	 * 大纲目录路径
	 */
	private String exsy011;

	//工种-等级
	private String tywolevw;
	
	private String childCount;
	
	/**
	 * 设置 主键 的值
	 */
	public void setExsy001(String exsy001){
		this.exsy001 = exsy001;
	}

	/**
	 * 获取 主键 的值
	 */
	public String getExsy001(){
		return exsy001;
	}
	/**
	 * 设置 大纲名称 的值
	 */
	public void setExsy002(String exsy002){
		this.exsy002 = exsy002;
	}

	/**
	 * 获取 大纲名称 的值
	 */
	public String getExsy002(){
		return exsy002;
	}
	/**
	 * 设置 大纲父id 的值
	 */
	public void setExsy003(String exsy003){
		this.exsy003 = exsy003;
	}

	/**
	 * 获取 大纲父id 的值
	 */
	public String getExsy003(){
		return exsy003;
	}
	/**
	 * 设置 大纲层级 的值
	 */
	public void setExsy004(Integer exsy004){
		this.exsy004 = exsy004;
	}

	/**
	 * 获取 大纲层级 的值
	 */
	public Integer getExsy004(){
		return exsy004;
	}
	/**
	 * 设置 适用科目分类（1.理论考试大纲 2.实操考试大纲 3.业绩评价大纲 4.潜在能力大纲 5.综合评价大纲） 的值
	 */
	public void setExsy005(Integer exsy005){
		this.exsy005 = exsy005;
	}

	/**
	 * 获取 适用科目分类（1.理论考试大纲 2.实操考试大纲 3.业绩评价大纲 4.潜在能力大纲 5.综合评价大纲） 的值
	 */
	public Integer getExsy005(){
		return exsy005;
	}
	/**
	 * 设置 大纲类别：（1.工种考试大纲 2.技能考试大纲） 的值
	 */
	public void setExsy006(Integer exsy006){
		this.exsy006 = exsy006;
	}

	/**
	 * 获取 大纲类别：（1.工种考试大纲 2.技能考试大纲） 的值
	 */
	public Integer getExsy006(){
		return exsy006;
	}
	/**
	 * 设置 发布单位 的值
	 */
	public void setExsy007(String exsy007){
		this.exsy007 = exsy007;
	}

	/**
	 * 获取 发布单位 的值
	 */
	public String getExsy007(){
		return exsy007;
	}
	/**
	 * 设置 创建人 的值
	 */
	public void setExsy008(String exsy008){
		this.exsy008 = exsy008;
	}

	/**
	 * 获取 创建人 的值
	 */
	public String getExsy008(){
		return exsy008;
	}
	/**
	 * 设置 创建时间 的值
	 */
	public void setExsy009(Date exsy009){
		this.exsy009 = exsy009;
	}

	/**
	 * 获取 创建时间 的值
	 */
	public Date getExsy009(){
		return exsy009;
	}
	/**
	 * 设置 最后修改时间 的值
	 */
	public void setExsy010(Date exsy010){
		this.exsy010 = exsy010;
	}
	
	/**
	 * 获取 最后修改时间 的值
	 */
	public Date getExsy010(){
		return exsy010;
	}

	public String getExsy011() {
		return exsy011;
	}

	public void setExsy011(String exsy011) {
		this.exsy011 = exsy011;
	}


	public String getTywolevw() {
		return tywolevw;
	}

	public void setTywolevw(String tywolevw) {
		this.tywolevw = tywolevw;
	}

	public String getChildCount() {
		return childCount;
	}

	public void setChildCount(String childCount) {
		this.childCount = childCount;
	}

	@Override
	protected Serializable pkVal() {
		return this.exsy001;
	}
	
}
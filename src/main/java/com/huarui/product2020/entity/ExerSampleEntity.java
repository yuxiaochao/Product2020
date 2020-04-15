package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

public class ExerSampleEntity extends Model<ExamTExergrade>{

	private static final long serialVersionUID = 256321001628769907L;
	
	private String exsa001;

	/**
	 * 题库练习ID
	 */
	private String exsa002;

	/**
	 * 成绩ID
	 */
	private String exsa003;

	/**
	 * 用户ID
	 */
	private String exsa004;

	/**
	 * 题库ID
	 */
	private String exsa005;

	/**
	 * 知识点
	 */
	private String exsa006;

	/**
	 * 1、答题模式 2、背题模式 def(1)
	 */
	private Integer exsa007;

	/**
	 * 抽题数量
	 */
	private Integer exsa008;

	/**
	 * 抽题时间
	 */
	private Date exsa009;
	
	/**
	 * 练习类型
	 */
	private Integer exsa010;


	public void setExsa001(String exsa001){
		this.exsa001 = exsa001;
	}

	public String getExsa001(){
		return exsa001;
	}
	public void setExsa002(String exsa002){
		this.exsa002 = exsa002;
	}

	public String getExsa002(){
		return exsa002;
	}
	public void setExsa003(String exsa003){
		this.exsa003 = exsa003;
	}

	public String getExsa003(){
		return exsa003;
	}
	public void setExsa004(String exsa004){
		this.exsa004 = exsa004;
	}

	public String getExsa004(){
		return exsa004;
	}
	public void setExsa005(String exsa005){
		this.exsa005 = exsa005;
	}

	public String getExsa005(){
		return exsa005;
	}
	public void setExsa006(String exsa006){
		this.exsa006 = exsa006;
	}

	public String getExsa006(){
		return exsa006;
	}
	public void setExsa007(Integer exsa007){
		this.exsa007 = exsa007;
	}

	public Integer getExsa007(){
		return exsa007;
	}
	public void setExsa008(Integer exsa008){
		this.exsa008 = exsa008;
	}

	public Integer getExsa008(){
		return exsa008;
	}
	public void setExsa009(Date exsa009){
		this.exsa009 = exsa009;
	}

	public Date getExsa009(){
		return exsa009;
	}

	public Integer getExsa010() {
		return exsa010;
	}

	public void setExsa010(Integer exsa010) {
		this.exsa010 = exsa010;
	}

	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return this.exsa001;
	}
	
}
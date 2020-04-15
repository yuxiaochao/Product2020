package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.huarui.common.utils.IPage;

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
@TableName("EXAM_T_EXERCISE")
public class ExamTExercise extends Model<ExamTExercise> {

    private static final long serialVersionUID = 1L;

    @TableId("EXER001")
	private String exer001;
    /**
     * 练习编号
     */
	@TableField("EXER002")
	private String exer002;
    /**
     * 主办单位ID
     */
	@TableField("EXER003")
	private String exer003;
    /**
     * 练习名称
     */
	@TableField("EXER004")
	private String exer004;
    /**
     * 开始时间
     */
	@TableField("EXER005")
	private Date exer005;
    /**
     * 结束时间
     */
	@TableField("EXER006")
	private Date exer006;
    /**
     * 状态 1、编辑中 2、未发布 3、已发布 4、已归档
     */
	@TableField("EXER007")
	private Double exer007;
    /**
     * 顺序号
     */
	@TableField("EXER008")
	private Double exer008;
    /**
     * 目录ID
     */
	@TableField("EXER009")
	private String exer009;
    /**
     * 封面
     */
	@TableField("EXER010")
	private String exer010;
    /**
     * 练习类型：0、题库练习，1、在线测评
     */
	@TableField("EXER011")
	private Double exer011;
    /**
     * 说明
     */
	@TableField("EXER012")
	private String exer012;
    /**
     * 允许考生参加考试次数
     */
	@TableField("EXER013")
	private Double exer013;
    /**
     * 所属类型（数据字典，练习类型）
     */
	@TableField("EXER014")
	private String exer014;

	/**
	 * 结束时间（数据库格式化后的数据）
	 */
	private String exer015;

	/**
	 * 用户id
	 */
	private String user001;
	
	/**
	 * 责任人
	 */
	private String user005;
	
	/**
	 * 知识点
	 */
	private String topi003;
	
	private IPage<?> page;
	
	public String getExer001() {
		return exer001;
	}

	public void setExer001(String exer001) {
		this.exer001 = exer001;
	}

	public String getExer002() {
		return exer002;
	}

	public void setExer002(String exer002) {
		this.exer002 = exer002;
	}

	public String getExer003() {
		return exer003;
	}

	public void setExer003(String exer003) {
		this.exer003 = exer003;
	}

	public String getExer004() {
		return exer004;
	}

	public void setExer004(String exer004) {
		this.exer004 = exer004;
	}

	public Date getExer005() {
		return exer005;
	}

	public void setExer005(Date exer005) {
		this.exer005 = exer005;
	}

	public Date getExer006() {
		return exer006;
	}

	public void setExer006(Date exer006) {
		this.exer006 = exer006;
	}

	public Double getExer007() {
		return exer007;
	}

	public void setExer007(Double exer007) {
		this.exer007 = exer007;
	}

	public Double getExer008() {
		return exer008;
	}

	public void setExer008(Double exer008) {
		this.exer008 = exer008;
	}

	public String getExer009() {
		return exer009;
	}

	public void setExer009(String exer009) {
		this.exer009 = exer009;
	}

	public String getExer010() {
		return exer010;
	}

	public void setExer010(String exer010) {
		this.exer010 = exer010;
	}

	public Double getExer011() {
		return exer011;
	}

	public void setExer011(Double exer011) {
		this.exer011 = exer011;
	}

	public String getExer012() {
		return exer012;
	}

	public void setExer012(String exer012) {
		this.exer012 = exer012;
	}

	public Double getExer013() {
		return exer013;
	}

	public void setExer013(Double exer013) {
		this.exer013 = exer013;
	}

	public String getExer014() {
		return exer014;
	}

	public void setExer014(String exer014) {
		this.exer014 = exer014;
	}

	@Override
	protected Serializable pkVal() {
		return this.exer001;
	}

	public String getExer015() {
		return exer015;
	}

	public void setExer015(String exer015) {
		this.exer015 = exer015;
	}

	public String getUser001() {
		return user001;
	}

	public void setUser001(String user001) {
		this.user001 = user001;
	}
	
	

	public String getTopi003() {
		return topi003;
	}

	public void setTopi003(String topi003) {
		this.topi003 = topi003;
	}

	public IPage<?> getPage() {
		return page;
	}

	public IPage<?> setPage(IPage<?> page) {
		this.page = page;
		return page;
	}

	
	
}

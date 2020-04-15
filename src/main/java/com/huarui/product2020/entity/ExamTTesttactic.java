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
@TableName("EXAM_T_TESTTACTIC")
public class ExamTTesttactic extends Model<ExamTTesttactic> {

    private static final long serialVersionUID = 1L;

    @TableId("TTAC001")
	private String ttac001;
    /**
     * 试卷ID
     */
	@TableField("TTAC002")
	private String ttac002;
    /**
     * 目录ID
     */
	@TableField("TTAC003")
	private String ttac003;
    /**
     * 知识点
     */
	@TableField("TTAC004")
	private String ttac004;
    /**
     * 难度等级
     */
	@TableField("TTAC005")
	private Long ttac005;
    /**
     * 基本题型
     */
	@TableField("TTAC006")
	private Integer ttac006;
    /**
     * 题型标题
     */
	@TableField("TTAC007")
	private String ttac007;
    /**
     * 抽取数量
     */
	@TableField("TTAC008")
	private Long ttac008;
    /**
     * 分数
     */
	@TableField("TTAC009")
	private Float ttac009;
    /**
     * 认知层次
     */
	@TableField("TTAC010")
	private String ttac010;
    /**
     * 考试要求 
     */
	@TableField("TTAC011")
	private String ttac011;
    /**
     * 基本题型ID
     */
	@TableField("TTAC012")
	private String ttac012;
    /**
     * 来源 0、所有 1、非共享 2、共享  
     */
	@TableField("TTAC013")
	private Long ttac013;
	@TableField("TTAC016")
	private String ttac016;
	@TableField(exist=false)
	private String ttac016text;
	/**
	 * 策略试题题数
	 */
	@TableField(exist=false)
	private Integer autonum;
	public String getTtac001() {
		return ttac001;
	}

	public void setTtac001(String ttac001) {
		this.ttac001 = ttac001;
	}

	public String getTtac002() {
		return ttac002;
	}

	public void setTtac002(String ttac002) {
		this.ttac002 = ttac002;
	}

	public String getTtac003() {
		return ttac003;
	}

	public void setTtac003(String ttac003) {
		this.ttac003 = ttac003;
	}

	public String getTtac004() {
		return ttac004;
	}

	public void setTtac004(String ttac004) {
		this.ttac004 = ttac004;
	}

	public Long getTtac005() {
		return ttac005;
	}

	public void setTtac005(Long ttac005) {
		this.ttac005 = ttac005;
	}

	public Integer getTtac006() {
		return ttac006;
	}

	public void setTtac006(Integer ttac006) {
		this.ttac006 = ttac006;
	}

	public String getTtac007() {
		return ttac007;
	}

	public void setTtac007(String ttac007) {
		this.ttac007 = ttac007;
	}

	public Long getTtac008() {
		return ttac008;
	}

	public void setTtac008(Long ttac008) {
		this.ttac008 = ttac008;
	}

	public Float getTtac009() {
		return ttac009;
	}

	public void setTtac009(Float ttac009) {
		this.ttac009 = ttac009;
	}

	public String getTtac010() {
		return ttac010;
	}

	public void setTtac010(String ttac010) {
		this.ttac010 = ttac010;
	}

	public String getTtac011() {
		return ttac011;
	}

	public void setTtac011(String ttac011) {
		this.ttac011 = ttac011;
	}

	public String getTtac012() {
		return ttac012;
	}

	public void setTtac012(String ttac012) {
		this.ttac012 = ttac012;
	}

	public Long getTtac013() {
		return ttac013;
	}

	public void setTtac013(Long ttac013) {
		this.ttac013 = ttac013;
	}
	
	public String getTtac016() {
		return ttac016;
	}

	public void setTtac016(String ttac016) {
		this.ttac016 = ttac016;
	}

	public Integer getAutonum() {
		return autonum;
	}

	public void setAutonum(Integer autonum) {
		this.autonum = autonum;
	}

	@Override
	protected Serializable pkVal() {
		return this.ttac001;
	}

	public String getTtac016text() {
		return ttac016text;
	}

	public void setTtac016text(String ttac016text) {
		this.ttac016text = ttac016text;
	}
	
}

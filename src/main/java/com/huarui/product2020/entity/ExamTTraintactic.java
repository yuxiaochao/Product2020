package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author panlei
 * @since 2018-05-22
 */
@TableName("EXAM_T_TRAINTACTIC")
public class ExamTTraintactic extends Model<ExamTTraintactic> {

    private static final long serialVersionUID = 1L;

    @TableId("ETAC001")
	private String etac001;
    /**
     * 训练ID
     */
	@TableField("ETAC002")
	private String etac002;
    /**
     * 目录ID
     */
	@TableField("ETAC003")
	private String etac003;
    /**
     * 知识点
     */
	@TableField("ETAC004")
	private String etac004;
    /**
     * 难度等级
     */
	@TableField("ETAC005")
	private Long etac005;
    /**
     * 基本题型
     */
	@TableField("ETAC006")
	private Integer etac006;
    /**
     * 题型标题
     */
	@TableField("ETAC007")
	private String etac007;
    /**
     * 抽取数量
     */
	@TableField("ETAC008")
	private Long etac008;
    /**
     * 分数
     */
	@TableField("ETAC009")
	private Float etac009;
    /**
     * 认知层次
     */
	@TableField("ETAC010")
	private String etac010;
    /**
     * 考试要求 
     */
	@TableField("ETAC011")
	private String etac011;
    /**
     * 基本题型ID
     */
	@TableField("ETAC012")
	private String etac012;
    /**
     * 来源 0、所有 1、非共享 2、共享  
     */
	@TableField("ETAC013")
	private Long etac013;


	public String getEtac001() {
		return etac001;
	}

	public void setEtac001(String etac001) {
		this.etac001 = etac001;
	}

	public String getEtac002() {
		return etac002;
	}

	public void setEtac002(String etac002) {
		this.etac002 = etac002;
	}

	public String getEtac003() {
		return etac003;
	}

	public void setEtac003(String etac003) {
		this.etac003 = etac003;
	}

	public String getEtac004() {
		return etac004;
	}

	public void setEtac004(String etac004) {
		this.etac004 = etac004;
	}

	public Long getEtac005() {
		return etac005;
	}

	public void setEtac005(Long etac005) {
		this.etac005 = etac005;
	}

	public Integer getEtac006() {
		return etac006;
	}

	public void setEtac006(Integer etac006) {
		this.etac006 = etac006;
	}

	public String getEtac007() {
		return etac007;
	}

	public void setEtac007(String etac007) {
		this.etac007 = etac007;
	}

	public Long getEtac008() {
		return etac008;
	}

	public void setEtac008(Long etac008) {
		this.etac008 = etac008;
	}

	public Float getEtac009() {
		return etac009;
	}

	public void setEtac009(Float etac009) {
		this.etac009 = etac009;
	}

	public String getEtac010() {
		return etac010;
	}

	public void setEtac010(String etac010) {
		this.etac010 = etac010;
	}

	public String getEtac011() {
		return etac011;
	}

	public void setEtac011(String etac011) {
		this.etac011 = etac011;
	}

	public String getEtac012() {
		return etac012;
	}

	public void setEtac012(String etac012) {
		this.etac012 = etac012;
	}

	public Long getEtac013() {
		return etac013;
	}

	public void setEtac013(Long etac013) {
		this.etac013 = etac013;
	}

	@Override
	protected Serializable pkVal() {
		return this.etac001;
	}

	@Override
	public String toString() {
		return "ExamTTraintactic{" +
			"etac001=" + etac001 +
			", etac002=" + etac002 +
			", etac003=" + etac003 +
			", etac004=" + etac004 +
			", etac005=" + etac005 +
			", etac006=" + etac006 +
			", etac007=" + etac007 +
			", etac008=" + etac008 +
			", etac009=" + etac009 +
			", etac010=" + etac010 +
			", etac011=" + etac011 +
			", etac012=" + etac012 +
			", etac013=" + etac013 +
			"}";
	}
}

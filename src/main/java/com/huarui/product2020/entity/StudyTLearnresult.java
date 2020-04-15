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
@TableName("STUDY_T_LEARNRESULT")
public class StudyTLearnresult extends Model<StudyTLearnresult> {

    private static final long serialVersionUID = 1L;

    @TableId("LERE001")
	private String lere001;
	@TableField("LERE002")
	private String lere002;
	@TableField("LERE003")
	private String lere003;
	@TableField("LERE004")
	private Date lere004;
	@TableField("LERE005")
	private Float lere005;
	@TableField("LERE006")
	private Double lere006;
	@TableField("LERE007")
	private Date lere007;
	@TableField("LERE008")
	private Double lere008;
    /**
     * 评价等级
     */
	@TableField("LERE009")
	private String lere009;
    /**
     * 评价内容
     */
	@TableField("LERE010")
	private String lere010;
    /**
     * 学习状态：1 学习中 2 已离开
     */
	@TableField("LERE011")
	private Integer lere011;
    /**
     * 最后响应时间
     */
	@TableField("LERE012")
	private Date lere012;


	public String getLere001() {
		return lere001;
	}

	public void setLere001(String lere001) {
		this.lere001 = lere001;
	}

	public String getLere002() {
		return lere002;
	}

	public void setLere002(String lere002) {
		this.lere002 = lere002;
	}

	public String getLere003() {
		return lere003;
	}

	public void setLere003(String lere003) {
		this.lere003 = lere003;
	}

	public Date getLere004() {
		return lere004;
	}

	public void setLere004(Date lere004) {
		this.lere004 = lere004;
	}

	public Float getLere005() {
		return lere005;
	}

	public void setLere005(Float lere005) {
		this.lere005 = lere005;
	}

	public Double getLere006() {
		return lere006;
	}

	public void setLere006(Double lere006) {
		this.lere006 = lere006;
	}

	public Date getLere007() {
		return lere007;
	}

	public void setLere007(Date lere007) {
		this.lere007 = lere007;
	}

	public Double getLere008() {
		return lere008;
	}

	public void setLere008(Double lere008) {
		this.lere008 = lere008;
	}

	public String getLere009() {
		return lere009;
	}

	public void setLere009(String lere009) {
		this.lere009 = lere009;
	}

	public String getLere010() {
		return lere010;
	}

	public void setLere010(String lere010) {
		this.lere010 = lere010;
	}

	public Integer getLere011() {
		return lere011;
	}

	public void setLere011(Integer lere011) {
		this.lere011 = lere011;
	}

	public Date getLere012() {
		return lere012;
	}

	public void setLere012(Date lere012) {
		this.lere012 = lere012;
	}

	@Override
	protected Serializable pkVal() {
		return this.lere001;
	}

}

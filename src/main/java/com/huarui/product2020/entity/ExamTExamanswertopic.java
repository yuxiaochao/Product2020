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
@TableName("EXAM_T_EXAMANSWERTOPIC")
public class ExamTExamanswertopic extends Model<ExamTExamanswertopic> {

    private static final long serialVersionUID = 1L;

    @TableId("EATO001")
	private String eato001;
    /**
     * 成绩ID
     */
	@TableField("EATO002")
	private String eato002;
    /**
     * 试卷内容ID
     */
	@TableField("EATO003")
	private String eato003;
    /**
     * 试卷题目ID
     */
	@TableField("EATO004")
	private String eato004;
    /**
     * 答题情况
     */
	@TableField("EATO005")
	private String eato005;
    /**
     * 考生得分
     */
	@TableField("EATO006")
	private Float eato006;
    /**
     * 打分状态（0 不需要打分 1待打分 2已打分）
     */
	@TableField("EATO007")
	private Integer eato007;
	
	 /**
	 * 打分评语
	 */
	@TableField("EATO008")
	private String eato008;
	
	private Float topicscore;


	public String getEato001() {
		return eato001;
	}

	public void setEato001(String eato001) {
		this.eato001 = eato001;
	}

	public String getEato002() {
		return eato002;
	}

	public void setEato002(String eato002) {
		this.eato002 = eato002;
	}

	public String getEato003() {
		return eato003;
	}

	public void setEato003(String eato003) {
		this.eato003 = eato003;
	}

	public String getEato004() {
		return eato004;
	}

	public void setEato004(String eato004) {
		this.eato004 = eato004;
	}

	public String getEato005() {
		return eato005;
	}

	public void setEato005(String eato005) {
		this.eato005 = eato005;
	}

	public Float getEato006() {
		return eato006;
	}

	public void setEato006(Float eato006) {
		this.eato006 = eato006;
	}


	public Integer getEato007() {
		return eato007;
	}

	public void setEato007(Integer eato007) {
		this.eato007 = eato007;
	}

	@Override
	protected Serializable pkVal() {
		return this.eato001;
	}

	public Float getTopicscore() {
		return topicscore;
	}

	public void setTopicscore(Float topicscore) {
		this.topicscore = topicscore;
	}

	public String getEato008() {
		return eato008;
	}

	public void setEato008(String eato008) {
		this.eato008 = eato008;
	}

	
}

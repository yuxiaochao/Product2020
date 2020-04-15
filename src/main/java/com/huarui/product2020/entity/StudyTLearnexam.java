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
@TableName("STUDY_T_LEARNEXAM")
public class StudyTLearnexam extends Model<StudyTLearnexam> {

    private static final long serialVersionUID = 1L;

    @TableId("LEEX001")
	private String leex001;
	@TableField("LEEX002")
	private String leex002;
	@TableField("LEEX003")
	private String leex003;
	@TableField("LEEX004")
	private Double leex004;
	@TableField("LEEX005")
	private Double leex005;


	public String getLeex001() {
		return leex001;
	}

	public void setLeex001(String leex001) {
		this.leex001 = leex001;
	}

	public String getLeex002() {
		return leex002;
	}

	public void setLeex002(String leex002) {
		this.leex002 = leex002;
	}

	public String getLeex003() {
		return leex003;
	}

	public void setLeex003(String leex003) {
		this.leex003 = leex003;
	}

	public Double getLeex004() {
		return leex004;
	}

	public void setLeex004(Double leex004) {
		this.leex004 = leex004;
	}

	public Double getLeex005() {
		return leex005;
	}

	public void setLeex005(Double leex005) {
		this.leex005 = leex005;
	}

	@Override
	protected Serializable pkVal() {
		return this.leex001;
	}

}

package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
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
@TableName("STUDY_T_LEARNARCHIVEUSER")
public class StudyTLearnarchiveuser extends Model<StudyTLearnarchiveuser> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@TableField("STLAU001")
	private String stlau001;
    /**
     * 学习ID
     */
	@TableField("STLAU002")
	private String stlau002;
    /**
     * 用户ID
     */
	@TableField("STLAU003")
	private String stlau003;
    /**
     * 状态：0、未学 1、以学
     */
	@TableField("STLAU004")
	private Double stlau004;


	public String getStlau001() {
		return stlau001;
	}

	public void setStlau001(String stlau001) {
		this.stlau001 = stlau001;
	}

	public String getStlau002() {
		return stlau002;
	}

	public void setStlau002(String stlau002) {
		this.stlau002 = stlau002;
	}

	public String getStlau003() {
		return stlau003;
	}

	public void setStlau003(String stlau003) {
		this.stlau003 = stlau003;
	}

	public Double getStlau004() {
		return stlau004;
	}

	public void setStlau004(Double stlau004) {
		this.stlau004 = stlau004;
	}

	@Override
	protected Serializable pkVal() {
		return this.stlau001;
	}

}

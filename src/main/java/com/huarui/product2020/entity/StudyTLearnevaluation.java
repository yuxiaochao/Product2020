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
@TableName("STUDY_T_LEARNEVALUATION")
public class StudyTLearnevaluation extends Model<StudyTLearnevaluation> {

    private static final long serialVersionUID = 1L;

    @TableId("LEEV001")
	private String leev001;
	@TableField("LEEV002")
	private String leev002;
	@TableField("LEEV003")
	private String leev003;
	@TableField("LEEV004")
	private Double leev004;


	public String getLeev001() {
		return leev001;
	}

	public void setLeev001(String leev001) {
		this.leev001 = leev001;
	}

	public String getLeev002() {
		return leev002;
	}

	public void setLeev002(String leev002) {
		this.leev002 = leev002;
	}

	public String getLeev003() {
		return leev003;
	}

	public void setLeev003(String leev003) {
		this.leev003 = leev003;
	}

	public Double getLeev004() {
		return leev004;
	}

	public void setLeev004(Double leev004) {
		this.leev004 = leev004;
	}

	@Override
	protected Serializable pkVal() {
		return this.leev001;
	}

}

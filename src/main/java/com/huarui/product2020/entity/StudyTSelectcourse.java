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
@TableName("STUDY_T_SELECTCOURSE")
public class StudyTSelectcourse extends Model<StudyTSelectcourse> {

    private static final long serialVersionUID = 1L;

    @TableId("SECO001")
	private String seco001;
	@TableField("SECO002")
	private String seco002;
	@TableField("SECO003")
	private String seco003;
	@TableField("SECO004")
	private Date seco004;
	@TableField("SECO005")
	private Double seco005;
	@TableField("SECO006")
	private Double seco006;


	public String getSeco001() {
		return seco001;
	}

	public void setSeco001(String seco001) {
		this.seco001 = seco001;
	}

	public String getSeco002() {
		return seco002;
	}

	public void setSeco002(String seco002) {
		this.seco002 = seco002;
	}

	public String getSeco003() {
		return seco003;
	}

	public void setSeco003(String seco003) {
		this.seco003 = seco003;
	}

	public Date getSeco004() {
		return seco004;
	}

	public void setSeco004(Date seco004) {
		this.seco004 = seco004;
	}

	public Double getSeco005() {
		return seco005;
	}

	public void setSeco005(Double seco005) {
		this.seco005 = seco005;
	}

	public Double getSeco006() {
		return seco006;
	}

	public void setSeco006(Double seco006) {
		this.seco006 = seco006;
	}

	@Override
	protected Serializable pkVal() {
		return this.seco001;
	}

}

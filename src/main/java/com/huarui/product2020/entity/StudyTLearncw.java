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
@TableName("STUDY_T_LEARNCW")
public class StudyTLearncw extends Model<StudyTLearncw> {

    private static final long serialVersionUID = 1L;

    @TableId("LECW001")
	private String lecw001;
	@TableField("LECW002")
	private String lecw002;
	@TableField("LECW003")
	private String lecw003;
	@TableField("LECW004")
	private Double lecw004;
	@TableField("LECW005")
	private Double lecw005;
	@TableField("LECW006")
	private String lecw006;
	@TableField("LECW007")
	private Double lecw007;
	@TableField("LECW008")
	private Double lecw008;
	@TableField("LECW009")
	private Double lecw009;


	public String getLecw001() {
		return lecw001;
	}

	public void setLecw001(String lecw001) {
		this.lecw001 = lecw001;
	}

	public String getLecw002() {
		return lecw002;
	}

	public void setLecw002(String lecw002) {
		this.lecw002 = lecw002;
	}

	public String getLecw003() {
		return lecw003;
	}

	public void setLecw003(String lecw003) {
		this.lecw003 = lecw003;
	}

	public Double getLecw004() {
		return lecw004;
	}

	public void setLecw004(Double lecw004) {
		this.lecw004 = lecw004;
	}

	public Double getLecw005() {
		return lecw005;
	}

	public void setLecw005(Double lecw005) {
		this.lecw005 = lecw005;
	}

	public String getLecw006() {
		return lecw006;
	}

	public void setLecw006(String lecw006) {
		this.lecw006 = lecw006;
	}

	public Double getLecw007() {
		return lecw007;
	}

	public void setLecw007(Double lecw007) {
		this.lecw007 = lecw007;
	}

	public Double getLecw008() {
		return lecw008;
	}

	public void setLecw008(Double lecw008) {
		this.lecw008 = lecw008;
	}

	public Double getLecw009() {
		return lecw009;
	}

	public void setLecw009(Double lecw009) {
		this.lecw009 = lecw009;
	}

	@Override
	protected Serializable pkVal() {
		return this.lecw001;
	}

}

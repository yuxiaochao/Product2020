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
@TableName("STUDY_T_LEARNTEACHER")
public class StudyTLearnteacher extends Model<StudyTLearnteacher> {

    private static final long serialVersionUID = 1L;

    @TableId("LETE001")
	private String lete001;
	@TableField("LETE002")
	private String lete002;
	@TableField("LETE003")
	private String lete003;
	@TableField("LETE004")
	private String lete004;
	@TableField("LETE005")
	private String lete005;
	@TableField("LETE006")
	private Date lete006;
	@TableField("LETE007")
	private Double lete007;


	public String getLete001() {
		return lete001;
	}

	public void setLete001(String lete001) {
		this.lete001 = lete001;
	}

	public String getLete002() {
		return lete002;
	}

	public void setLete002(String lete002) {
		this.lete002 = lete002;
	}

	public String getLete003() {
		return lete003;
	}

	public void setLete003(String lete003) {
		this.lete003 = lete003;
	}

	public String getLete004() {
		return lete004;
	}

	public void setLete004(String lete004) {
		this.lete004 = lete004;
	}

	public String getLete005() {
		return lete005;
	}

	public void setLete005(String lete005) {
		this.lete005 = lete005;
	}

	public Date getLete006() {
		return lete006;
	}

	public void setLete006(Date lete006) {
		this.lete006 = lete006;
	}

	public Double getLete007() {
		return lete007;
	}

	public void setLete007(Double lete007) {
		this.lete007 = lete007;
	}

	@Override
	protected Serializable pkVal() {
		return this.lete001;
	}

}

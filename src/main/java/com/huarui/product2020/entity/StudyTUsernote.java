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
@TableName("STUDY_T_USERNOTE")
public class StudyTUsernote extends Model<StudyTUsernote> {

	private static final long serialVersionUID = 1L;

	@TableId("UNOT001")
	private String unot001;
	@TableField("UNOT002")
	private String unot002;
	@TableField("UNOT003")
	private String unot003;
	@TableField("UNOT004")
	private String unot004;
	@TableField("UNOT005")
	private String unot005;
	@TableField("UNOT006")
	private String unot006;
	@TableField("UNOT007")
	private String unot007;
	@TableField("UNOT008")
	private Date unot008;
	@TableField("UNOT009")
	private String unot009;
	@TableField("UNOT010")
	private String unot010;

	public String getUnot001() {
		return unot001;
	}

	public void setUnot001(String unot001) {
		this.unot001 = unot001;
	}

	public String getUnot002() {
		return unot002;
	}

	public void setUnot002(String unot002) {
		this.unot002 = unot002;
	}

	public String getUnot003() {
		return unot003;
	}

	public void setUnot003(String unot003) {
		this.unot003 = unot003;
	}

	public String getUnot004() {
		return unot004;
	}

	public void setUnot004(String unot004) {
		this.unot004 = unot004;
	}

	public String getUnot005() {
		return unot005;
	}

	public void setUnot005(String unot005) {
		this.unot005 = unot005;
	}

	public String getUnot006() {
		return unot006;
	}

	public void setUnot006(String unot006) {
		this.unot006 = unot006;
	}

	public String getUnot007() {
		return unot007;
	}

	public void setUnot007(String unot007) {
		this.unot007 = unot007;
	}

	public Date getUnot008() {
		return unot008;
	}

	public void setUnot008(Date unot008) {
		this.unot008 = unot008;
	}

	public String getUnot009() {
		return unot009;
	}

	public void setUnot009(String unot009) {
		this.unot009 = unot009;
	}


	public String getUnot010() {
		return unot010;
	}

	public void setUnot010(String unot010) {
		this.unot010 = unot010;
	}
	@Override
	protected Serializable pkVal() {
		return this.unot001;
	}

}

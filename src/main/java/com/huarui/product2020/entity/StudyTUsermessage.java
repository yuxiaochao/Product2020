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
@TableName("STUDY_T_USERMESSAGE")
public class StudyTUsermessage extends Model<StudyTUsermessage> {

    private static final long serialVersionUID = 1L;

    @TableId("UMES001")
	private String umes001;
	@TableField("UMES002")
	private String umes002;
	@TableField("UMES003")
	private String umes003;
	@TableField("UMES004")
	private String umes004;
	@TableField("UMES005")
	private Double umes005;
	@TableField("UMES006")
	private String umes006;
	@TableField("UMES007")
	private Date umes007;
	@TableField("UMES008")
	private Integer umes008;


	public String getUmes001() {
		return umes001;
	}

	public void setUmes001(String umes001) {
		this.umes001 = umes001;
	}

	public String getUmes002() {
		return umes002;
	}

	public void setUmes002(String umes002) {
		this.umes002 = umes002;
	}

	public String getUmes003() {
		return umes003;
	}

	public void setUmes003(String umes003) {
		this.umes003 = umes003;
	}

	public String getUmes004() {
		return umes004;
	}

	public void setUmes004(String umes004) {
		this.umes004 = umes004;
	}

	public Double getUmes005() {
		return umes005;
	}

	public void setUmes005(Double umes005) {
		this.umes005 = umes005;
	}

	public String getUmes006() {
		return umes006;
	}

	public void setUmes006(String umes006) {
		this.umes006 = umes006;
	}

	public Date getUmes007() {
		return umes007;
	}

	public void setUmes007(Date umes007) {
		this.umes007 = umes007;
	}

	@Override
	protected Serializable pkVal() {
		return this.umes001;
	}

	public Integer getUmes008() {
		return umes008;
	}

	public void setUmes008(Integer umes008) {
		this.umes008 = umes008;
	}
}

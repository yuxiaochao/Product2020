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
@TableName("STUDY_T_RECOMMENDCOURSE")
public class StudyTRecommendcourse extends Model<StudyTRecommendcourse> {

    private static final long serialVersionUID = 1L;

    @TableId("RECO001")
	private String reco001;
	@TableField("RECO002")
	private String reco002;
	@TableField("RECO003")
	private String reco003;
	@TableField("RECO004")
	private String reco004;
	@TableField("RECO005")
	private Date reco005;
	@TableField("RECO006")
	private String reco006;


	public String getReco001() {
		return reco001;
	}

	public void setReco001(String reco001) {
		this.reco001 = reco001;
	}

	public String getReco002() {
		return reco002;
	}

	public void setReco002(String reco002) {
		this.reco002 = reco002;
	}

	public String getReco003() {
		return reco003;
	}

	public void setReco003(String reco003) {
		this.reco003 = reco003;
	}

	public String getReco004() {
		return reco004;
	}

	public void setReco004(String reco004) {
		this.reco004 = reco004;
	}

	public Date getReco005() {
		return reco005;
	}

	public void setReco005(Date reco005) {
		this.reco005 = reco005;
	}

	public String getReco006() {
		return reco006;
	}

	public void setReco006(String reco006) {
		this.reco006 = reco006;
	}

	@Override
	protected Serializable pkVal() {
		return this.reco001;
	}

}

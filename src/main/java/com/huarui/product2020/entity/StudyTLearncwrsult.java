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
@TableName("STUDY_T_LEARNCWRSULT")
public class StudyTLearncwrsult extends Model<StudyTLearncwrsult> {

    private static final long serialVersionUID = 1L;

    @TableId("LCWR001")
	private String lcwr001;
	@TableField("LCWR002")
	private String lcwr002;
	@TableField("LCWR003")
	private String lcwr003;
	@TableField("LCWR004")
	private String lcwr004;
	@TableField("LCWR005")
	private String lcwr005;
	@TableField("LCWR006")
	private Date lcwr006;
	@TableField("LCWR007")
	private Float lcwr007;
	@TableField("LCWR008")
	private Double lcwr008;
	@TableField("LCWR009")
	private Date lcwr009;
	@TableField("LCWR010")
	private Double lcwr010;
	@TableField("LCWR011")
	private Double lcwr011;


	public String getLcwr001() {
		return lcwr001;
	}

	public void setLcwr001(String lcwr001) {
		this.lcwr001 = lcwr001;
	}

	public String getLcwr002() {
		return lcwr002;
	}

	public void setLcwr002(String lcwr002) {
		this.lcwr002 = lcwr002;
	}

	public String getLcwr003() {
		return lcwr003;
	}

	public void setLcwr003(String lcwr003) {
		this.lcwr003 = lcwr003;
	}

	public String getLcwr004() {
		return lcwr004;
	}

	public void setLcwr004(String lcwr004) {
		this.lcwr004 = lcwr004;
	}

	public String getLcwr005() {
		return lcwr005;
	}

	public void setLcwr005(String lcwr005) {
		this.lcwr005 = lcwr005;
	}

	public Date getLcwr006() {
		return lcwr006;
	}

	public void setLcwr006(Date lcwr006) {
		this.lcwr006 = lcwr006;
	}

	public Float getLcwr007() {
		return lcwr007;
	}

	public void setLcwr007(Float lcwr007) {
		this.lcwr007 = lcwr007;
	}

	public Double getLcwr008() {
		return lcwr008;
	}

	public void setLcwr008(Double lcwr008) {
		this.lcwr008 = lcwr008;
	}

	public Date getLcwr009() {
		return lcwr009;
	}

	public void setLcwr009(Date lcwr009) {
		this.lcwr009 = lcwr009;
	}

	public Double getLcwr010() {
		return lcwr010;
	}

	public void setLcwr010(Double lcwr010) {
		this.lcwr010 = lcwr010;
	}

	public Double getLcwr011() {
		return lcwr011;
	}

	public void setLcwr011(Double lcwr011) {
		this.lcwr011 = lcwr011;
	}

	@Override
	protected Serializable pkVal() {
		return this.lcwr001;
	}

}

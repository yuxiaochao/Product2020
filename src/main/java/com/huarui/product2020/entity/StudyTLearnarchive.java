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
@TableName("STUDY_T_LEARNARCHIVE")
public class StudyTLearnarchive extends Model<StudyTLearnarchive> {

    private static final long serialVersionUID = 1L;

    /**
     * 学习活动ID
     */
    @TableId("STLA001")
	private String stla001;
    /**
     * 学习名称
     */
	@TableField("STLA002")
	private String stla002;
    /**
     * 类型：1、学习归档-岸端 2、学习归档-船端
     */
	@TableField("STLA003")
	private Double stla003;
    /**
     * 主办单位ID
     */
	@TableField("STLA004")
	private String stla004;
    /**
     * 主办单位
     */
	@TableField("STLA005")
	private String stla005;
    /**
     * 责任人（名称）
     */
	@TableField("STLA006")
	private String stla006;
    /**
     * 应学人数
     */
	@TableField("STLA007")
	private Double stla007;
    /**
     * 参学人数
     */
	@TableField("STLA008")
	private Double stla008;
    /**
     * 结业人数
     */
	@TableField("STLA009")
	private Double stla009;
    /**
     * 参学率
     */
	@TableField("STLA010")
	private String stla010;
    /**
     * 结业率
     */
	@TableField("STLA011")
	private String stla011;
    /**
     * 归档时间
     */
	@TableField("STLA012")
	private Date stla012;


	public String getStla001() {
		return stla001;
	}

	public void setStla001(String stla001) {
		this.stla001 = stla001;
	}

	public String getStla002() {
		return stla002;
	}

	public void setStla002(String stla002) {
		this.stla002 = stla002;
	}

	public Double getStla003() {
		return stla003;
	}

	public void setStla003(Double stla003) {
		this.stla003 = stla003;
	}

	public String getStla004() {
		return stla004;
	}

	public void setStla004(String stla004) {
		this.stla004 = stla004;
	}

	public String getStla005() {
		return stla005;
	}

	public void setStla005(String stla005) {
		this.stla005 = stla005;
	}

	public String getStla006() {
		return stla006;
	}

	public void setStla006(String stla006) {
		this.stla006 = stla006;
	}

	public Double getStla007() {
		return stla007;
	}

	public void setStla007(Double stla007) {
		this.stla007 = stla007;
	}

	public Double getStla008() {
		return stla008;
	}

	public void setStla008(Double stla008) {
		this.stla008 = stla008;
	}

	public Double getStla009() {
		return stla009;
	}

	public void setStla009(Double stla009) {
		this.stla009 = stla009;
	}

	public String getStla010() {
		return stla010;
	}

	public void setStla010(String stla010) {
		this.stla010 = stla010;
	}

	public String getStla011() {
		return stla011;
	}

	public void setStla011(String stla011) {
		this.stla011 = stla011;
	}

	public Date getStla012() {
		return stla012;
	}

	public void setStla012(Date stla012) {
		this.stla012 = stla012;
	}

	@Override
	protected Serializable pkVal() {
		return this.stla001;
	}

}

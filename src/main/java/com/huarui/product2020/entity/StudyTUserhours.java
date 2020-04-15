package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
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
@TableName("STUDY_T_USERHOURS")
public class StudyTUserhours extends Model<StudyTUserhours> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@TableField("UHOU001")
	private String uhou001;
    /**
     * 学时类型 1、学习活动 2、培训活动
     */
	@TableField("UHOU002")
	private String uhou002;
    /**
     * 用户ID
     */
	@TableField("UHOU003")
	private String uhou003;
    /**
     * 学习活动ID
     */
	@TableField("UHOU004")
	private String uhou004;
    /**
     * 获取模式 1、自动 2、手动
     */
	@TableField("UHOU005")
	private Double uhou005;
    /**
     * 学时
     */
	@TableField("UHOU006")
	private Double uhou006;
    /**
     * 学时形式 1、必修 2、选修
     */
	@TableField("UHOU007")
	private Double uhou007;
    /**
     * 获取时间
     */
	@TableField("UHOU008")
	private Date uhou008;
    /**
     * 备用字段
     */
	@TableField("UHOU009")
	private String uhou009;
    /**
     * 备用字段
     */
	@TableField("UHOU010")
	private String uhou010;
    /**
     * 备用字段
     */
	@TableField("UHOU011")
	private String uhou011;


	public String getUhou001() {
		return uhou001;
	}

	public void setUhou001(String uhou001) {
		this.uhou001 = uhou001;
	}

	public String getUhou002() {
		return uhou002;
	}

	public void setUhou002(String uhou002) {
		this.uhou002 = uhou002;
	}

	public String getUhou003() {
		return uhou003;
	}

	public void setUhou003(String uhou003) {
		this.uhou003 = uhou003;
	}

	public String getUhou004() {
		return uhou004;
	}

	public void setUhou004(String uhou004) {
		this.uhou004 = uhou004;
	}

	public Double getUhou005() {
		return uhou005;
	}

	public void setUhou005(Double uhou005) {
		this.uhou005 = uhou005;
	}

	public Double getUhou006() {
		return uhou006;
	}

	public void setUhou006(Double uhou006) {
		this.uhou006 = uhou006;
	}

	public Double getUhou007() {
		return uhou007;
	}

	public void setUhou007(Double uhou007) {
		this.uhou007 = uhou007;
	}

	public Date getUhou008() {
		return uhou008;
	}

	public void setUhou008(Date uhou008) {
		this.uhou008 = uhou008;
	}

	public String getUhou009() {
		return uhou009;
	}

	public void setUhou009(String uhou009) {
		this.uhou009 = uhou009;
	}

	public String getUhou010() {
		return uhou010;
	}

	public void setUhou010(String uhou010) {
		this.uhou010 = uhou010;
	}

	public String getUhou011() {
		return uhou011;
	}

	public void setUhou011(String uhou011) {
		this.uhou011 = uhou011;
	}

	@Override
	protected Serializable pkVal() {
		return this.uhou001;
	}

}

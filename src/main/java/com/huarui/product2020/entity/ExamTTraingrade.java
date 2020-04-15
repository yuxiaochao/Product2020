package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author panlei
 * @since 2018-05-22
 */
@TableName("EXAM_T_TRAINGRADE")
public class ExamTTraingrade extends Model<ExamTTraingrade> {

    private static final long serialVersionUID = 1L;

    /**
     * PK
     */
    @TableId("EXTG001")
	private String extg001;
    /**
     * 训练ID
     */
	@TableField("EXTG002")
	private String extg002;
    /**
     * 用户ID
     */
	@TableField("EXTG003")
	private String extg003;
    /**
     * 登录日志ID
     */
	@TableField("EXTG004")
	private String extg004;
    /**
     * 开始时间
     */
	@TableField("EXTG005")
	private Date extg005;
    /**
     * 结束时间
     */
	@TableField("EXTG006")
	private Date extg006;
    /**
     * 是否达标 0、未达标 1、已达标
     */
	@TableField("EXTG007")
	private int extg007;
    /**
     * 达标时间
     */
	@TableField("EXTG008")
	private Date extg008;
    /**
     * 答题进度
     */
	@TableField("EXTG009")
	private Double extg009;


	public String getExtg001() {
		return extg001;
	}

	public void setExtg001(String extg001) {
		this.extg001 = extg001;
	}

	public String getExtg002() {
		return extg002;
	}

	public void setExtg002(String extg002) {
		this.extg002 = extg002;
	}

	public String getExtg003() {
		return extg003;
	}

	public void setExtg003(String extg003) {
		this.extg003 = extg003;
	}

	public String getExtg004() {
		return extg004;
	}

	public void setExtg004(String extg004) {
		this.extg004 = extg004;
	}

	public Date getExtg005() {
		return extg005;
	}

	public void setExtg005(Date extg005) {
		this.extg005 = extg005;
	}

	public Date getExtg006() {
		return extg006;
	}

	public void setExtg006(Date extg006) {
		this.extg006 = extg006;
	}

	public int getExtg007() {
		return extg007;
	}

	public void setExtg007(int extg007) {
		this.extg007 = extg007;
	}

	public Date getExtg008() {
		return extg008;
	}

	public void setExtg008(Date extg008) {
		this.extg008 = extg008;
	}

	public Double getExtg009() {
		return extg009;
	}

	public void setExtg009(Double extg009) {
		this.extg009 = extg009;
	}

	@Override
	protected Serializable pkVal() {
		return this.extg001;
	}

	@Override
	public String toString() {
		return "ExamTTraingrade{" +
			"extg001=" + extg001 +
			", extg002=" + extg002 +
			", extg003=" + extg003 +
			", extg004=" + extg004 +
			", extg005=" + extg005 +
			", extg006=" + extg006 +
			", extg007=" + extg007 +
			", extg008=" + extg008 +
			", extg009=" + extg009 +
			"}";
	}
}

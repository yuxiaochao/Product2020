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
@TableName("EXAM_T_TESTCATALOG")
public class ExamTTestcatalog extends Model<ExamTTestcatalog> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("TSCA001")
	private String tsca001;
    /**
     * 目录名称
     */
	@TableField("TSCA002")
	private String tsca002;
    /**
     * 目录编码
     */
	@TableField("TSCA003")
	private String tsca003;
    /**
     * Parent ID
     */
	@TableField("TSCA004")
	private String tsca004;
    /**
     * parent编码
     */
	@TableField("TSCA005")
	private String tsca005;
    /**
     * 排序号
     */
	@TableField("TSCA006")
	private Double tsca006;
    /**
     * 目录类型：1、试卷目录（在线考试-岸端） 2、试卷目录（在线考试-船端）
     */
	@TableField("TSCA007")
	private Double tsca007;
    /**
     * 归属单位ID
     */
	@TableField("TSCA008")
	private String tsca008;
    /**
     * 目录路径
     */
	@TableField("TSCA009")
	private String tsca009;
    /**
     * 目录层级
     */
	@TableField("TSCA010")
	private Double tsca010;
    /**
     * 目录状态：1、启用 2、禁用
     */
	@TableField("TSCA011")
	private Double tsca011;
    /**
     * 创建人ID
     */
	@TableField("TSCA012")
	private String tsca012;


	public String getTsca001() {
		return tsca001;
	}

	public void setTsca001(String tsca001) {
		this.tsca001 = tsca001;
	}

	public String getTsca002() {
		return tsca002;
	}

	public void setTsca002(String tsca002) {
		this.tsca002 = tsca002;
	}

	public String getTsca003() {
		return tsca003;
	}

	public void setTsca003(String tsca003) {
		this.tsca003 = tsca003;
	}

	public String getTsca004() {
		return tsca004;
	}

	public void setTsca004(String tsca004) {
		this.tsca004 = tsca004;
	}

	public String getTsca005() {
		return tsca005;
	}

	public void setTsca005(String tsca005) {
		this.tsca005 = tsca005;
	}

	public Double getTsca006() {
		return tsca006;
	}

	public void setTsca006(Double tsca006) {
		this.tsca006 = tsca006;
	}

	public Double getTsca007() {
		return tsca007;
	}

	public void setTsca007(Double tsca007) {
		this.tsca007 = tsca007;
	}

	public String getTsca008() {
		return tsca008;
	}

	public void setTsca008(String tsca008) {
		this.tsca008 = tsca008;
	}

	public String getTsca009() {
		return tsca009;
	}

	public void setTsca009(String tsca009) {
		this.tsca009 = tsca009;
	}

	public Double getTsca010() {
		return tsca010;
	}

	public void setTsca010(Double tsca010) {
		this.tsca010 = tsca010;
	}

	public Double getTsca011() {
		return tsca011;
	}

	public void setTsca011(Double tsca011) {
		this.tsca011 = tsca011;
	}

	public String getTsca012() {
		return tsca012;
	}

	public void setTsca012(String tsca012) {
		this.tsca012 = tsca012;
	}

	@Override
	protected Serializable pkVal() {
		return this.tsca001;
	}

}

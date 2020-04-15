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
@TableName("EXAM_T_TOPICCORRECTION")
public class ExamTTopiccorrection extends Model<ExamTTopiccorrection> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("TCOR001")
	private String tcor001;
    /**
     * 试题ID
     */
	@TableField("TCOR002")
	private String tcor002;
    /**
     * 纠错人ID
     */
	@TableField("TCOR003")
	private String tcor003;
    /**
     * 提交时间
     */
	@TableField("TCOR004")
	private Date tcor004;
    /**
     * 错误描述
     */
	@TableField("TCOR005")
	private String tcor005;
    /**
     * 错误截图
     */
	@TableField("TCOR006")
	private String tcor006;
    /**
     * 状态  0、待处理  1、已处理
     */
	@TableField("TCOR007")
	private Long tcor007;
    /**
     * 处理人ID
     */
	@TableField("TCOR008")
	private String tcor008;
    /**
     * 处理时间
     */
	@TableField("TCOR009")
	private Date tcor009;
    /**
     * 备注说明
     */
	@TableField("TCOR010")
	private String tcor010;


	public String getTcor001() {
		return tcor001;
	}

	public void setTcor001(String tcor001) {
		this.tcor001 = tcor001;
	}

	public String getTcor002() {
		return tcor002;
	}

	public void setTcor002(String tcor002) {
		this.tcor002 = tcor002;
	}

	public String getTcor003() {
		return tcor003;
	}

	public void setTcor003(String tcor003) {
		this.tcor003 = tcor003;
	}

	public Date getTcor004() {
		return tcor004;
	}

	public void setTcor004(Date tcor004) {
		this.tcor004 = tcor004;
	}

	public String getTcor005() {
		return tcor005;
	}

	public void setTcor005(String tcor005) {
		this.tcor005 = tcor005;
	}

	public String getTcor006() {
		return tcor006;
	}

	public void setTcor006(String tcor006) {
		this.tcor006 = tcor006;
	}

	public Long getTcor007() {
		return tcor007;
	}

	public void setTcor007(Long tcor007) {
		this.tcor007 = tcor007;
	}

	public String getTcor008() {
		return tcor008;
	}

	public void setTcor008(String tcor008) {
		this.tcor008 = tcor008;
	}

	public Date getTcor009() {
		return tcor009;
	}

	public void setTcor009(Date tcor009) {
		this.tcor009 = tcor009;
	}

	public String getTcor010() {
		return tcor010;
	}

	public void setTcor010(String tcor010) {
		this.tcor010 = tcor010;
	}

	@Override
	protected Serializable pkVal() {
		return this.tcor001;
	}

}

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
@TableName("EXAM_T_EXAMMONITOR")
public class ExamTExammonitor extends Model<ExamTExammonitor> {

    private static final long serialVersionUID = 1L;

    /**
     * 违纪时间
     */
	@TableField("EMON011")
	private Date emon011;
    /**
     * 违纪原因
     */
	@TableField("EMON012")
	private String emon012;
    @TableId("EMON001")
	private String emon001;
    /**
     * 试卷ID
     */
	@TableField("EMON002")
	private String emon002;
    /**
     * 监控类型
1延长考试时间
2 强制交卷
3 作废试题
4 取消考试成绩
     */
	@TableField("EMON003")
	private Long emon003;
    /**
     * 延长时间
     */
	@TableField("EMON004")
	private Long emon004;
    /**
     * 成绩ID
     */
	@TableField("EMON005")
	private String emon005;
    /**
     * 试卷试题ID
     */
	@TableField("EMON006")
	private String emon006;
    /**
     * 考生ID
     */
	@TableField("EMON007")
	private String emon007;
    /**
     * 关联违纪类型
     */
	@TableField("EMON008")
	private String emon008;
    /**
     * 响应状态  0 待响应 1 已响应
     */
	@TableField("EMON009")
	private Long emon009;
    /**
     * 经办人ID
     */
	@TableField("EMON010")
	private String emon010;


	public Date getEmon011() {
		return emon011;
	}

	public void setEmon011(Date emon011) {
		this.emon011 = emon011;
	}

	public String getEmon012() {
		return emon012;
	}

	public void setEmon012(String emon012) {
		this.emon012 = emon012;
	}

	public String getEmon001() {
		return emon001;
	}

	public void setEmon001(String emon001) {
		this.emon001 = emon001;
	}

	public String getEmon002() {
		return emon002;
	}

	public void setEmon002(String emon002) {
		this.emon002 = emon002;
	}

	public Long getEmon003() {
		return emon003;
	}

	public void setEmon003(Long emon003) {
		this.emon003 = emon003;
	}

	public Long getEmon004() {
		return emon004;
	}

	public void setEmon004(Long emon004) {
		this.emon004 = emon004;
	}

	public String getEmon005() {
		return emon005;
	}

	public void setEmon005(String emon005) {
		this.emon005 = emon005;
	}

	public String getEmon006() {
		return emon006;
	}

	public void setEmon006(String emon006) {
		this.emon006 = emon006;
	}

	public String getEmon007() {
		return emon007;
	}

	public void setEmon007(String emon007) {
		this.emon007 = emon007;
	}

	public String getEmon008() {
		return emon008;
	}

	public void setEmon008(String emon008) {
		this.emon008 = emon008;
	}

	public Long getEmon009() {
		return emon009;
	}

	public void setEmon009(Long emon009) {
		this.emon009 = emon009;
	}

	public String getEmon010() {
		return emon010;
	}

	public void setEmon010(String emon010) {
		this.emon010 = emon010;
	}

	@Override
	protected Serializable pkVal() {
		return this.emon001;
	}

}

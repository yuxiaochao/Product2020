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
@TableName("EXAM_T_EXERGRADE")
public class ExamTExergrade extends Model<ExamTExergrade> {

    private static final long serialVersionUID = 1L;

    @TableId("EXGR001")
	private String exgr001;
    /**
     * 练习ID
     */
	@TableField("EXGR002")
	private String exgr002;
    /**
     * 用户ID
     */
	@TableField("EXGR003")
	private String exgr003;
    /**
     * 登录日志ID
     */
	@TableField("EXGR004")
	private String exgr004;
    /**
     * 开始时间
     */
	@TableField("EXGR005")
	private Date exgr005;
    /**
     * 结束时间
     */
	@TableField("EXGR006")
	private Date exgr006;
    /**
     * 状态 1、未完成 2、已完成
     */
	@TableField("EXGR007")
	private int exgr007;


	public String getExgr001() {
		return exgr001;
	}

	public void setExgr001(String exgr001) {
		this.exgr001 = exgr001;
	}

	public String getExgr002() {
		return exgr002;
	}

	public void setExgr002(String exgr002) {
		this.exgr002 = exgr002;
	}

	public String getExgr003() {
		return exgr003;
	}

	public void setExgr003(String exgr003) {
		this.exgr003 = exgr003;
	}

	public String getExgr004() {
		return exgr004;
	}

	public void setExgr004(String exgr004) {
		this.exgr004 = exgr004;
	}

	public Date getExgr005() {
		return exgr005;
	}

	public void setExgr005(Date exgr005) {
		this.exgr005 = exgr005;
	}

	public Date getExgr006() {
		return exgr006;
	}

	public void setExgr006(Date exgr006) {
		this.exgr006 = exgr006;
	}
	
	

	public int getExgr007() {
		return exgr007;
	}

	public void setExgr007(int exgr007) {
		this.exgr007 = exgr007;
	}

	@Override
	protected Serializable pkVal() {
		return this.exgr001;
	}

}

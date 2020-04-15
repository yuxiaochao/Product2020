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
@TableName("EXAM_T_TESTARCHIVEUSER")
public class ExamTTestarchiveuser extends Model<ExamTTestarchiveuser> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("TAUS001")
	private String taus001;
    /**
     * 试卷ID
     */
	@TableField("TAUS002")
	private String taus002;
    /**
     * 用户ID
     */
	@TableField("TAUS003")
	private String taus003;
    /**
     * 状态：0、未考 1、已考 2、在考
     */
	@TableField("TAUS004")
	private Double taus004;


	public String getTaus001() {
		return taus001;
	}

	public void setTaus001(String taus001) {
		this.taus001 = taus001;
	}

	public String getTaus002() {
		return taus002;
	}

	public void setTaus002(String taus002) {
		this.taus002 = taus002;
	}

	public String getTaus003() {
		return taus003;
	}

	public void setTaus003(String taus003) {
		this.taus003 = taus003;
	}

	public Double getTaus004() {
		return taus004;
	}

	public void setTaus004(Double taus004) {
		this.taus004 = taus004;
	}

	@Override
	protected Serializable pkVal() {
		return this.taus001;
	}

}

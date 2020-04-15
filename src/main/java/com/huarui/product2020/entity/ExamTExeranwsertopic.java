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
@TableName("EXAM_T_EXERANWSERTOPIC")
public class ExamTExeranwsertopic extends Model<ExamTExeranwsertopic> {

    private static final long serialVersionUID = 1L;

    @TableId("EATO001")
	private String eato001;
    /**
     * 练习ID
     */
	@TableField("EATO002")
	private String eato002;
    /**
     * 成绩ID
     */
	@TableField("EATO003")
	private String eato003;
    /**
     * 用户ID
     */
	@TableField("EATO004")
	private String eato004;
    /**
     * 试题ID
     */
	@TableField("EATO005")
	private String eato005;
    /**
     * 答题情况
     */
	@TableField("EATO006")
	private String eato006;
    /**
     * 结果 1、未掌握 2、已掌握
     */
	@TableField("EATO007")
	private int eato007;
    /**
     * 答题次数
     */
	@TableField("EATO008")
	private int eato008;


	public String getEato001() {
		return eato001;
	}

	public void setEato001(String eato001) {
		this.eato001 = eato001;
	}

	public String getEato002() {
		return eato002;
	}

	public void setEato002(String eato002) {
		this.eato002 = eato002;
	}

	public String getEato003() {
		return eato003;
	}

	public void setEato003(String eato003) {
		this.eato003 = eato003;
	}

	public String getEato004() {
		return eato004;
	}

	public void setEato004(String eato004) {
		this.eato004 = eato004;
	}

	public String getEato005() {
		return eato005;
	}

	public void setEato005(String eato005) {
		this.eato005 = eato005;
	}

	public String getEato006() {
		return eato006;
	}

	public void setEato006(String eato006) {
		this.eato006 = eato006;
	}

	
	public int getEato007() {
		return eato007;
	}

	public void setEato007(int eato007) {
		this.eato007 = eato007;
	}

	public int getEato008() {
		return eato008;
	}

	public void setEato008(int eato008) {
		this.eato008 = eato008;
	}

	@Override
	protected Serializable pkVal() {
		return this.eato001;
	}

}

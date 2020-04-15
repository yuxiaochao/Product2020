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
@TableName("EXAM_T_TESTMARKTOPIC")
public class ExamTTestmarktopic extends Model<ExamTTestmarktopic> {

    private static final long serialVersionUID = 1L;

    @TableId("TMTO001")
	private String tmto001;
    /**
     * 试卷ID
     */
	@TableField("TMTO002")
	private String tmto002;
    /**
     * 成绩ID
     */
	@TableField("TMTO003")
	private String tmto003;
    /**
     * 考生ID
     */
	@TableField("TMTO004")
	private String tmto004;
    /**
     * 试卷试题ID
     */
	@TableField("TMTO005")
	private String tmto005;
    /**
     * 评分人ID
     */
	@TableField("TMTO006")
	private String tmto006;
    /**
     * 本题得分
     */
	@TableField("TMTO007")
	private Float tmto007;
    /**
     * 阅卷时间
     */
	@TableField("TMTO008")
	private Date tmto008;
    /**
     * 评语
     */
	@TableField("TMTO009")
	private String tmto009;


	public String getTmto001() {
		return tmto001;
	}

	public void setTmto001(String tmto001) {
		this.tmto001 = tmto001;
	}

	public String getTmto002() {
		return tmto002;
	}

	public void setTmto002(String tmto002) {
		this.tmto002 = tmto002;
	}

	public String getTmto003() {
		return tmto003;
	}

	public void setTmto003(String tmto003) {
		this.tmto003 = tmto003;
	}

	public String getTmto004() {
		return tmto004;
	}

	public void setTmto004(String tmto004) {
		this.tmto004 = tmto004;
	}

	public String getTmto005() {
		return tmto005;
	}

	public void setTmto005(String tmto005) {
		this.tmto005 = tmto005;
	}

	public String getTmto006() {
		return tmto006;
	}

	public void setTmto006(String tmto006) {
		this.tmto006 = tmto006;
	}

	public Float getTmto007() {
		return tmto007;
	}

	public void setTmto007(Float tmto007) {
		this.tmto007 = tmto007;
	}

	public Date getTmto008() {
		return tmto008;
	}

	public void setTmto008(Date tmto008) {
		this.tmto008 = tmto008;
	}

	public String getTmto009() {
		return tmto009;
	}

	public void setTmto009(String tmto009) {
		this.tmto009 = tmto009;
	}

	@Override
	protected Serializable pkVal() {
		return this.tmto001;
	}

}

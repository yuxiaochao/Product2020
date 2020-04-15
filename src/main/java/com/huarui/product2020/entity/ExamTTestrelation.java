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
@TableName("EXAM_T_TESTRELATION")
public class ExamTTestrelation extends Model<ExamTTestrelation> {

    private static final long serialVersionUID = 1L;

    @TableId("TREL001")
	private String trel001;
    /**
     * 试卷ID
     */
	@TableField("TREL002")
	private String trel002;
    /**
     * 学习ID
     */
	@TableField("TREL003")
	private String trel003;
    /**
     * 培训ID
     */
	@TableField("TREL004")
	private String trel004;
    /**
     * 课程ID
     */
	@TableField("TREL005")
	private String trel005;


	public String getTrel001() {
		return trel001;
	}

	public void setTrel001(String trel001) {
		this.trel001 = trel001;
	}

	public String getTrel002() {
		return trel002;
	}

	public void setTrel002(String trel002) {
		this.trel002 = trel002;
	}

	public String getTrel003() {
		return trel003;
	}

	public void setTrel003(String trel003) {
		this.trel003 = trel003;
	}

	public String getTrel004() {
		return trel004;
	}

	public void setTrel004(String trel004) {
		this.trel004 = trel004;
	}

	public String getTrel005() {
		return trel005;
	}

	public void setTrel005(String trel005) {
		this.trel005 = trel005;
	}

	@Override
	protected Serializable pkVal() {
		return this.trel001;
	}

}

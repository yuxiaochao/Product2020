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
@TableName("EXAM_T_TESTTX")
public class ExamTTesttx extends Model<ExamTTesttx> {

    private static final long serialVersionUID = 1L;

    @TableId("TTX001")
	private String ttx001;
    /**
     * 试卷ID
     */
	@TableField("TTX002")
	private String ttx002;
    /**
     * 题型
0――填空题
1――单选题
2――多选题
3――判断题
4――问答题
5――组合题
6——优选题
7——不定项题
     */
	@TableField("TTX003")
	private Integer ttx003;
    /**
     * 题型标题
     */
	@TableField("TTX004")
	private String ttx004;
    /**
     * 题型顺序
     */
	@TableField("TTX005")
	private Long ttx005;
    /**
     * 题型说明
     */
	@TableField("TTX006")
	private String ttx006;
    /**
     * 题型分数
     */
	@TableField("TTX007")
	private Float ttx007;
    /**
     * 基本题型ID
     */
	@TableField("TTX008")
	private String ttx008;


	public String getTtx001() {
		return ttx001;
	}

	public void setTtx001(String ttx001) {
		this.ttx001 = ttx001;
	}

	public String getTtx002() {
		return ttx002;
	}

	public void setTtx002(String ttx002) {
		this.ttx002 = ttx002;
	}

	public Integer getTtx003() {
		return ttx003;
	}

	public void setTtx003(Integer ttx003) {
		this.ttx003 = ttx003;
	}

	public String getTtx004() {
		return ttx004;
	}

	public void setTtx004(String ttx004) {
		this.ttx004 = ttx004;
	}

	public Long getTtx005() {
		return ttx005;
	}

	public void setTtx005(Long ttx005) {
		this.ttx005 = ttx005;
	}

	public String getTtx006() {
		return ttx006;
	}

	public void setTtx006(String ttx006) {
		this.ttx006 = ttx006;
	}

	public Float getTtx007() {
		return ttx007;
	}

	public void setTtx007(Float ttx007) {
		this.ttx007 = ttx007;
	}

	public String getTtx008() {
		return ttx008;
	}

	public void setTtx008(String ttx008) {
		this.ttx008 = ttx008;
	}

	@Override
	protected Serializable pkVal() {
		return this.ttx001;
	}

}

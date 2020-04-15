package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author panlei
 * @since 2018-05-22
 */
@TableName("EXAM_T_TRAINSUBJECT")
public class ExamTTrainsubject extends Model<ExamTTrainsubject> {

    private static final long serialVersionUID = 1L;

    /**
     * PK
     */
    @TableId("EXTS001")
	private String exts001;
    /**
     * 训练ID
     */
	@TableField("EXTS002")
	private String exts002;
    /**
     * 题库ID
     */
	@TableField("EXTS003")
	private String exts003;
    /**
     * 知识点
     */
	@TableField("EXTS004")
	private String exts004;
    /**
     *    掌握数
     */
	@TableField("EXTS005")
	private Double exts005;
    /**
     * 基本题型：0、填空题 1、单选题 2、多选题 3、判断题 4、问答题 5、组合题 6、优选题 7、不定项题
     */
	@TableField("EXTS006")
	private Double exts006;
    /**
     * 题型标题
     */
	@TableField("EXTS007")
	private String exts007;
    /**
     * 题型顺序
     */
	@TableField("EXTS008")
	private Double exts008;
    /**
     * 题型说明
     */
	@TableField("EXTS009")
	private String exts009;


	public String getExts001() {
		return exts001;
	}

	public void setExts001(String exts001) {
		this.exts001 = exts001;
	}

	public String getExts002() {
		return exts002;
	}

	public void setExts002(String exts002) {
		this.exts002 = exts002;
	}

	public String getExts003() {
		return exts003;
	}

	public void setExts003(String exts003) {
		this.exts003 = exts003;
	}

	public String getExts004() {
		return exts004;
	}

	public void setExts004(String exts004) {
		this.exts004 = exts004;
	}

	public Double getExts005() {
		return exts005;
	}

	public void setExts005(Double exts005) {
		this.exts005 = exts005;
	}

	public Double getExts006() {
		return exts006;
	}

	public void setExts006(Double exts006) {
		this.exts006 = exts006;
	}

	public String getExts007() {
		return exts007;
	}

	public void setExts007(String exts007) {
		this.exts007 = exts007;
	}

	public Double getExts008() {
		return exts008;
	}

	public void setExts008(Double exts008) {
		this.exts008 = exts008;
	}

	public String getExts009() {
		return exts009;
	}

	public void setExts009(String exts009) {
		this.exts009 = exts009;
	}

	@Override
	protected Serializable pkVal() {
		return this.exts001;
	}

	@Override
	public String toString() {
		return "ExamTTrainsubject{" +
			"exts001=" + exts001 +
			", exts002=" + exts002 +
			", exts003=" + exts003 +
			", exts004=" + exts004 +
			", exts005=" + exts005 +
			", exts006=" + exts006 +
			", exts007=" + exts007 +
			", exts008=" + exts008 +
			", exts009=" + exts009 +
			"}";
	}
}

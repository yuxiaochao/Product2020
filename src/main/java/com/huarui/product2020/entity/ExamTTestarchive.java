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
@TableName("EXAM_T_TESTARCHIVE")
public class ExamTTestarchive extends Model<ExamTTestarchive> {

    private static final long serialVersionUID = 1L;

    /**
     * 试卷ID
     */
    @TableId("TACT001")
	private String tact001;
    /**
     * 试卷名称
     */
	@TableField("TACT004")
	private String tact004;
    /**
     * 类型：1、正式考试-岸端 2、正式考试-船端
     */
	@TableField("TACT005")
	private Double tact005;
    /**
     * 主办单位ID
     */
	@TableField("ORGA001")
	private String orga001;
    /**
     * 主办单位
     */
	@TableField("TACT003NAME")
	private String tact003name;
    /**
     * 责任人
     */
	@TableField("USER005")
	private String user005;
    /**
     * 应考人数
     */
	@TableField("EXAMNUM")
	private Double examnum;
    /**
     * 参考人数
     */
	@TableField("JOINNUM")
	private Double joinnum;
    /**
     * 缺考人数
     */
	@TableField("PASSNUM")
	private Double passnum;
    /**
     * 通过率
     */
	@TableField("PASSRATE")
	private String passrate;
    /**
     * 平均分
     */
	@TableField("AVGSCORE")
	private Double avgscore;
    /**
     * 最高分
     */
	@TableField("MAXSCORE")
	private Double maxscore;
    /**
     * 最低分
     */
	@TableField("MINSCORE")
	private Double minscore;
    /**
     * 归档时间
     */
	@TableField("ARCHIVETIME")
	private Date archivetime;


	public String getTact001() {
		return tact001;
	}

	public void setTact001(String tact001) {
		this.tact001 = tact001;
	}

	public String getTact004() {
		return tact004;
	}

	public void setTact004(String tact004) {
		this.tact004 = tact004;
	}

	public Double getTact005() {
		return tact005;
	}

	public void setTact005(Double tact005) {
		this.tact005 = tact005;
	}

	public String getOrga001() {
		return orga001;
	}

	public void setOrga001(String orga001) {
		this.orga001 = orga001;
	}

	public String getTact003name() {
		return tact003name;
	}

	public void setTact003name(String tact003name) {
		this.tact003name = tact003name;
	}

	public String getUser005() {
		return user005;
	}

	public void setUser005(String user005) {
		this.user005 = user005;
	}

	public Double getExamnum() {
		return examnum;
	}

	public void setExamnum(Double examnum) {
		this.examnum = examnum;
	}

	public Double getJoinnum() {
		return joinnum;
	}

	public void setJoinnum(Double joinnum) {
		this.joinnum = joinnum;
	}

	public Double getPassnum() {
		return passnum;
	}

	public void setPassnum(Double passnum) {
		this.passnum = passnum;
	}

	public String getPassrate() {
		return passrate;
	}

	public void setPassrate(String passrate) {
		this.passrate = passrate;
	}

	public Double getAvgscore() {
		return avgscore;
	}

	public void setAvgscore(Double avgscore) {
		this.avgscore = avgscore;
	}

	public Double getMaxscore() {
		return maxscore;
	}

	public void setMaxscore(Double maxscore) {
		this.maxscore = maxscore;
	}

	public Double getMinscore() {
		return minscore;
	}

	public void setMinscore(Double minscore) {
		this.minscore = minscore;
	}

	public Date getArchivetime() {
		return archivetime;
	}

	public void setArchivetime(Date archivetime) {
		this.archivetime = archivetime;
	}

	@Override
	protected Serializable pkVal() {
		return this.tact001;
	}

}

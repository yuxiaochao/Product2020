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
@TableName("QUES_T_QUESARCHIVE")
public class QuesTQuesarchive extends Model<QuesTQuesarchive> {

    private static final long serialVersionUID = 1L;

    /**
     * PK
     */
    @TableId("QUES001")
	private String ques001;
    /**
     * 问卷名称
     */
	@TableField("QUES003")
	private String ques003;
    /**
     * 类型 1、岸端 2、船端
     */
	@TableField("QUES015")
	private Double ques015;
    /**
     * 发布日期
     */
	@TableField("QUES004")
	private Date ques004;
    /**
     * 主办单位ID
     */
	@TableField("ORGA001")
	private String orga001;
    /**
     * 主办单位
     */
	@TableField("ORGA006")
	private String orga006;
	@TableField("USER005")
	private String user005;
    /**
     * 应参人数
     */
	@TableField("QUESNUM")
	private Double quesnum;
    /**
     * 实参人数
     */
	@TableField("JOINNUM")
	private Double joinnum;
    /**
     * 通过率
     */
	@TableField("JOINRATE")
	private String joinrate;
    /**
     * 归档日期
     */
	@TableField("ARCHIVEDATE")
	private Date archivedate;
    /**
     * 归档人ID
     */
	@TableField("ARCHIVEUSERID")
	private String archiveuserid;


	public String getQues001() {
		return ques001;
	}

	public void setQues001(String ques001) {
		this.ques001 = ques001;
	}

	public String getQues003() {
		return ques003;
	}

	public void setQues003(String ques003) {
		this.ques003 = ques003;
	}

	public Double getQues015() {
		return ques015;
	}

	public void setQues015(Double ques015) {
		this.ques015 = ques015;
	}

	public Date getQues004() {
		return ques004;
	}

	public void setQues004(Date ques004) {
		this.ques004 = ques004;
	}

	public String getOrga001() {
		return orga001;
	}

	public void setOrga001(String orga001) {
		this.orga001 = orga001;
	}

	public String getOrga006() {
		return orga006;
	}

	public void setOrga006(String orga006) {
		this.orga006 = orga006;
	}

	public String getUser005() {
		return user005;
	}

	public void setUser005(String user005) {
		this.user005 = user005;
	}

	public Double getQuesnum() {
		return quesnum;
	}

	public void setQuesnum(Double quesnum) {
		this.quesnum = quesnum;
	}

	public Double getJoinnum() {
		return joinnum;
	}

	public void setJoinnum(Double joinnum) {
		this.joinnum = joinnum;
	}

	public String getJoinrate() {
		return joinrate;
	}

	public void setJoinrate(String joinrate) {
		this.joinrate = joinrate;
	}

	public Date getArchivedate() {
		return archivedate;
	}

	public void setArchivedate(Date archivedate) {
		this.archivedate = archivedate;
	}

	public String getArchiveuserid() {
		return archiveuserid;
	}

	public void setArchiveuserid(String archiveuserid) {
		this.archiveuserid = archiveuserid;
	}

	@Override
	protected Serializable pkVal() {
		return this.ques001;
	}

}

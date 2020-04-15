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
@TableName("EXAM_T_TOPICSHARE")
public class ExamTTopicshare extends Model<ExamTTopicshare> {

    private static final long serialVersionUID = 1L;

    /**
     * PK
     */
    @TableId("TOSH001")
	private String tosh001;
    /**
     * 共享人ID
     */
	@TableField("TOSH002")
	private String tosh002;
    /**
     * 共享时间
     */
	@TableField("TOSH003")
	private Date tosh003;
    /**
     * 共享说明
     */
	@TableField("TOSH004")
	private String tosh004;


	public String getTosh001() {
		return tosh001;
	}

	public void setTosh001(String tosh001) {
		this.tosh001 = tosh001;
	}

	public String getTosh002() {
		return tosh002;
	}

	public void setTosh002(String tosh002) {
		this.tosh002 = tosh002;
	}

	public Date getTosh003() {
		return tosh003;
	}

	public void setTosh003(Date tosh003) {
		this.tosh003 = tosh003;
	}

	public String getTosh004() {
		return tosh004;
	}

	public void setTosh004(String tosh004) {
		this.tosh004 = tosh004;
	}

	@Override
	protected Serializable pkVal() {
		return this.tosh001;
	}

}

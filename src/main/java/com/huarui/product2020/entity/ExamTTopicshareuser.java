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
@TableName("EXAM_T_TOPICSHAREUSER")
public class ExamTTopicshareuser extends Model<ExamTTopicshareuser> {

    private static final long serialVersionUID = 1L;

    /**
     * PK
     */
    @TableId("TSUS001")
	private String tsus001;
    /**
     * 被共享人ID
     */
	@TableField("TSUS002")
	private String tsus002;
    /**
     * 被共享单位ID
     */
	@TableField("TSUS003")
	private String tsus003;
    /**
     * 共享ID
     */
	@TableField("TSUS004")
	private String tsus004;
    /**
     * 共享对象 1、用户 2、单位
     */
	@TableField("TSUS005")
	private Double tsus005;


	public String getTsus001() {
		return tsus001;
	}

	public void setTsus001(String tsus001) {
		this.tsus001 = tsus001;
	}

	public String getTsus002() {
		return tsus002;
	}

	public void setTsus002(String tsus002) {
		this.tsus002 = tsus002;
	}

	public String getTsus003() {
		return tsus003;
	}

	public void setTsus003(String tsus003) {
		this.tsus003 = tsus003;
	}

	public String getTsus004() {
		return tsus004;
	}

	public void setTsus004(String tsus004) {
		this.tsus004 = tsus004;
	}

	public Double getTsus005() {
		return tsus005;
	}

	public void setTsus005(Double tsus005) {
		this.tsus005 = tsus005;
	}

	@Override
	protected Serializable pkVal() {
		return this.tsus001;
	}

}

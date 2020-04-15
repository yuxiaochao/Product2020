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
@TableName("EXAM_T_TESTMARKUSER")
public class ExamTTestmarkuser extends Model<ExamTTestmarkuser> {

    private static final long serialVersionUID = 1L;

    @TableId("TMUS001")
	private String tmus001;
    /**
     * 阅卷方式     1：按试卷 2：按试题
     */
	@TableField("TMUS002")
	private Integer tmus002;
    /**
     * 考试活动ID
     */
	@TableField("TMUS003")
	private String tmus003;
    /**
     * 试题ID
     */
	@TableField("TMUS004")
	private String tmus004;
    /**
     * 阅卷人ID
     */
	@TableField("TMUS005")
	private String tmus005;


	public String getTmus001() {
		return tmus001;
	}

	public void setTmus001(String tmus001) {
		this.tmus001 = tmus001;
	}

	public Integer getTmus002() {
		return tmus002;
	}

	public void setTmus002(Integer tmus002) {
		this.tmus002 = tmus002;
	}

	public String getTmus003() {
		return tmus003;
	}

	public void setTmus003(String tmus003) {
		this.tmus003 = tmus003;
	}

	public String getTmus004() {
		return tmus004;
	}

	public void setTmus004(String tmus004) {
		this.tmus004 = tmus004;
	}

	public String getTmus005() {
		return tmus005;
	}

	public void setTmus005(String tmus005) {
		this.tmus005 = tmus005;
	}

	@Override
	protected Serializable pkVal() {
		return this.tmus001;
	}

}

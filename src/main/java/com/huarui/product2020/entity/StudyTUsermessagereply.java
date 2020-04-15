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
@TableName("STUDY_T_USERMESSAGEREPLY")
public class StudyTUsermessagereply extends Model<StudyTUsermessagereply> {

    private static final long serialVersionUID = 1L;

    @TableId("UMRE001")
	private String umre001;
    /**
     * messageID
     */
	@TableField("UMRE002")
	private String umre002;
    /**
     * 用户ID
     */
	@TableField("UMRE003")
	private String umre003;
    /**
     * 学员点评：0、赞 1、吐槽
     */
	@TableField("UMRE004")
	private Double umre004;


	public String getUmre001() {
		return umre001;
	}

	public void setUmre001(String umre001) {
		this.umre001 = umre001;
	}

	public String getUmre002() {
		return umre002;
	}

	public void setUmre002(String umre002) {
		this.umre002 = umre002;
	}

	public String getUmre003() {
		return umre003;
	}

	public void setUmre003(String umre003) {
		this.umre003 = umre003;
	}

	public Double getUmre004() {
		return umre004;
	}

	public void setUmre004(Double umre004) {
		this.umre004 = umre004;
	}

	@Override
	protected Serializable pkVal() {
		return this.umre001;
	}

}

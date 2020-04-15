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
@TableName("QUES_T_QUESARCHIVEUSER")
public class QuesTQuesarchiveuser extends Model<QuesTQuesarchiveuser> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("QAUS001")
	private String qaus001;
    /**
     * 试卷ID
     */
	@TableField("QAUS002")
	private String qaus002;
    /**
     * 用户ID
     */
	@TableField("QAUS003")
	private String qaus003;
    /**
     * 状态：0、未参加 1、已参加
     */
	@TableField("QAUS004")
	private Double qaus004;


	public String getQaus001() {
		return qaus001;
	}

	public void setQaus001(String qaus001) {
		this.qaus001 = qaus001;
	}

	public String getQaus002() {
		return qaus002;
	}

	public void setQaus002(String qaus002) {
		this.qaus002 = qaus002;
	}

	public String getQaus003() {
		return qaus003;
	}

	public void setQaus003(String qaus003) {
		this.qaus003 = qaus003;
	}

	public Double getQaus004() {
		return qaus004;
	}

	public void setQaus004(Double qaus004) {
		this.qaus004 = qaus004;
	}

	@Override
	protected Serializable pkVal() {
		return this.qaus001;
	}

}

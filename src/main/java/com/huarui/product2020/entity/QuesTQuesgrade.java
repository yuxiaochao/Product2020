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
@TableName("QUES_T_QUESGRADE")
public class QuesTQuesgrade extends Model<QuesTQuesgrade> {

    private static final long serialVersionUID = 1L;

    @TableId("QGTA001")
	private String qgta001;
	@TableField("QGTA002")
	private String qgta002;
	@TableField("QGTA003")
	private String qgta003;
	@TableField("QGTA004")
	private Date qgta004;
	@TableField("QGTA005")
	private Date qgta005;
	@TableField("QGTA006")
	private String qgta006;
    /**
     * 调查状态（1 待提交 2已提交）
     */
	@TableField("QGTA007")
	private Integer qgta007;


	public String getQgta001() {
		return qgta001;
	}

	public void setQgta001(String qgta001) {
		this.qgta001 = qgta001;
	}

	public String getQgta002() {
		return qgta002;
	}

	public void setQgta002(String qgta002) {
		this.qgta002 = qgta002;
	}

	public String getQgta003() {
		return qgta003;
	}

	public void setQgta003(String qgta003) {
		this.qgta003 = qgta003;
	}

	public Date getQgta004() {
		return qgta004;
	}

	public void setQgta004(Date qgta004) {
		this.qgta004 = qgta004;
	}

	public Date getQgta005() {
		return qgta005;
	}

	public void setQgta005(Date qgta005) {
		this.qgta005 = qgta005;
	}

	public String getQgta006() {
		return qgta006;
	}

	public void setQgta006(String qgta006) {
		this.qgta006 = qgta006;
	}

	public Integer getQgta007() {
		return qgta007;
	}

	public void setQgta007(Integer qgta007) {
		this.qgta007 = qgta007;
	}

	@Override
	protected Serializable pkVal() {
		return this.qgta001;
	}

}

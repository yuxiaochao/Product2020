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
@TableName("HRSW_T_NOTE")
public class HrswTNote extends Model<HrswTNote> {

    private static final long serialVersionUID = 1L;

    @TableId("NOTE001")
	private String note001;
	@TableField("NOTE002")
	private String note002;
	@TableField("NOTE003")
	private String note003;
	@TableField("NOTE004")
	private String note004;
	@TableField("NOTE005")
	private String note005;
	@TableField("NOTE006")
	private Date note006;
	@TableField("NOTE007")
	private String note007;


	public String getNote001() {
		return note001;
	}

	public void setNote001(String note001) {
		this.note001 = note001;
	}

	public String getNote002() {
		return note002;
	}

	public void setNote002(String note002) {
		this.note002 = note002;
	}

	public String getNote003() {
		return note003;
	}

	public void setNote003(String note003) {
		this.note003 = note003;
	}

	public String getNote004() {
		return note004;
	}

	public void setNote004(String note004) {
		this.note004 = note004;
	}

	public String getNote005() {
		return note005;
	}

	public void setNote005(String note005) {
		this.note005 = note005;
	}

	public Date getNote006() {
		return note006;
	}

	public void setNote006(Date note006) {
		this.note006 = note006;
	}

	public String getNote007() {
		return note007;
	}

	public void setNote007(String note007) {
		this.note007 = note007;
	}

	@Override
	protected Serializable pkVal() {
		return this.note001;
	}

}

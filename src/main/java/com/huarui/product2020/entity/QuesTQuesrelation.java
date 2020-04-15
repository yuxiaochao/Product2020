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
@TableName("QUES_T_QUESRELATION")
public class QuesTQuesrelation extends Model<QuesTQuesrelation> {

    private static final long serialVersionUID = 1L;

    @TableId("QREL001")
	private String qrel001;
	@TableField("QREL002")
	private String qrel002;
	@TableField("QREL003")
	private String qrel003;
	@TableField("QREL004")
	private String qrel004;
	@TableField("QREL005")
	private String qrel005;
	@TableField("QREL006")
	private String qrel006;
	@TableField("QREL007")
	private String qrel007;


	public String getQrel001() {
		return qrel001;
	}

	public void setQrel001(String qrel001) {
		this.qrel001 = qrel001;
	}

	public String getQrel002() {
		return qrel002;
	}

	public void setQrel002(String qrel002) {
		this.qrel002 = qrel002;
	}

	public String getQrel003() {
		return qrel003;
	}

	public void setQrel003(String qrel003) {
		this.qrel003 = qrel003;
	}

	public String getQrel004() {
		return qrel004;
	}

	public void setQrel004(String qrel004) {
		this.qrel004 = qrel004;
	}

	public String getQrel005() {
		return qrel005;
	}

	public void setQrel005(String qrel005) {
		this.qrel005 = qrel005;
	}

	public String getQrel006() {
		return qrel006;
	}

	public void setQrel006(String qrel006) {
		this.qrel006 = qrel006;
	}

	public String getQrel007() {
		return qrel007;
	}

	public void setQrel007(String qrel007) {
		this.qrel007 = qrel007;
	}

	@Override
	protected Serializable pkVal() {
		return this.qrel001;
	}

}

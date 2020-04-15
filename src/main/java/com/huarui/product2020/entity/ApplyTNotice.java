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
@TableName("APPLY_T_NOTICE")
public class ApplyTNotice extends Model<ApplyTNotice> {

    private static final long serialVersionUID = 1L;

    @TableId("NOTI001")
	private String noti001;
	@TableField("NOTI002")
	private String noti002;
	@TableField("NOTI003")
	private String noti003;
	@TableField("NOTI004")
	private String noti004;
	@TableField("NOTI005")
	private String noti005;
	@TableField("NOTI006")
	private String noti006;
	@TableField("NOTI007")
	private String noti007;
	@TableField("NOTI008")
	private String noti008;
	@TableField("NOTI009")
	private Date noti009;


	public String getNoti001() {
		return noti001;
	}

	public void setNoti001(String noti001) {
		this.noti001 = noti001;
	}

	public String getNoti002() {
		return noti002;
	}

	public void setNoti002(String noti002) {
		this.noti002 = noti002;
	}

	public String getNoti003() {
		return noti003;
	}

	public void setNoti003(String noti003) {
		this.noti003 = noti003;
	}

	public String getNoti004() {
		return noti004;
	}

	public void setNoti004(String noti004) {
		this.noti004 = noti004;
	}

	public String getNoti005() {
		return noti005;
	}

	public void setNoti005(String noti005) {
		this.noti005 = noti005;
	}

	public String getNoti006() {
		return noti006;
	}

	public void setNoti006(String noti006) {
		this.noti006 = noti006;
	}

	public String getNoti007() {
		return noti007;
	}

	public void setNoti007(String noti007) {
		this.noti007 = noti007;
	}

	public String getNoti008() {
		return noti008;
	}

	public void setNoti008(String noti008) {
		this.noti008 = noti008;
	}

	public Date getNoti009() {
		return noti009;
	}

	public void setNoti009(Date noti009) {
		this.noti009 = noti009;
	}

	@Override
	protected Serializable pkVal() {
		return this.noti001;
	}

}

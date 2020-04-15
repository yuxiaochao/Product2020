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
@TableName("QUES_T_QUESTACTIC")
public class QuesTQuestactic extends Model<QuesTQuestactic> {

    private static final long serialVersionUID = 1L;

    @TableId("QTAC001")
	private String qtac001;
	@TableField("QTAC002")
	private String qtac002;
	@TableField("QTAC003")
	private String qtac003;
	@TableField("QTAC004")
	private String qtac004;
	@TableField("QTAC005")
	private Double qtac005;
	@TableField("QTAC006")
	private Double qtac006;
	@TableField("QTAC007")
	private String qtac007;
	@TableField("QTAC008")
	private Double qtac008;
	@TableField("QTAC009")
	private String qtac009;
	@TableField("QTAC010")
	private String qtac010;
	@TableField("QTAC011")
	private String qtac011;


	public String getQtac001() {
		return qtac001;
	}

	public void setQtac001(String qtac001) {
		this.qtac001 = qtac001;
	}

	public String getQtac002() {
		return qtac002;
	}

	public void setQtac002(String qtac002) {
		this.qtac002 = qtac002;
	}

	public String getQtac003() {
		return qtac003;
	}

	public void setQtac003(String qtac003) {
		this.qtac003 = qtac003;
	}

	public String getQtac004() {
		return qtac004;
	}

	public void setQtac004(String qtac004) {
		this.qtac004 = qtac004;
	}

	public Double getQtac005() {
		return qtac005;
	}

	public void setQtac005(Double qtac005) {
		this.qtac005 = qtac005;
	}

	public Double getQtac006() {
		return qtac006;
	}

	public void setQtac006(Double qtac006) {
		this.qtac006 = qtac006;
	}

	public String getQtac007() {
		return qtac007;
	}

	public void setQtac007(String qtac007) {
		this.qtac007 = qtac007;
	}

	public Double getQtac008() {
		return qtac008;
	}

	public void setQtac008(Double qtac008) {
		this.qtac008 = qtac008;
	}

	public String getQtac009() {
		return qtac009;
	}

	public void setQtac009(String qtac009) {
		this.qtac009 = qtac009;
	}

	public String getQtac010() {
		return qtac010;
	}

	public void setQtac010(String qtac010) {
		this.qtac010 = qtac010;
	}

	public String getQtac011() {
		return qtac011;
	}

	public void setQtac011(String qtac011) {
		this.qtac011 = qtac011;
	}

	@Override
	protected Serializable pkVal() {
		return this.qtac001;
	}

}

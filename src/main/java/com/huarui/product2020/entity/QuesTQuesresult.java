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
@TableName("QUES_T_QUESRESULT")
public class QuesTQuesresult extends Model<QuesTQuesresult> {

    private static final long serialVersionUID = 1L;

    @TableId("URES001")
	private String ures001;
	@TableField("URES002")
	private String ures002;
	@TableField("URES003")
	private String ures003;
	@TableField("URES004")
	private String ures004;
	@TableField("URES005")
	private String ures005;
	@TableField("URES006")
	private String ures006;
	@TableField("URES007")
	private String ures007;
	@TableField("URES008")
	private String ures008;
	@TableField("URES009")
	private String ures009;
	@TableField("URES010")
	private String ures010;
	@TableField("URES011")
	private Double ures011;


	public String getUres001() {
		return ures001;
	}

	public void setUres001(String ures001) {
		this.ures001 = ures001;
	}

	public String getUres002() {
		return ures002;
	}

	public void setUres002(String ures002) {
		this.ures002 = ures002;
	}

	public String getUres003() {
		return ures003;
	}

	public void setUres003(String ures003) {
		this.ures003 = ures003;
	}

	public String getUres004() {
		return ures004;
	}

	public void setUres004(String ures004) {
		this.ures004 = ures004;
	}

	public String getUres005() {
		return ures005;
	}

	public void setUres005(String ures005) {
		this.ures005 = ures005;
	}

	public String getUres006() {
		return ures006;
	}

	public void setUres006(String ures006) {
		this.ures006 = ures006;
	}

	public String getUres007() {
		return ures007;
	}

	public void setUres007(String ures007) {
		this.ures007 = ures007;
	}

	public String getUres008() {
		return ures008;
	}

	public void setUres008(String ures008) {
		this.ures008 = ures008;
	}

	public String getUres009() {
		return ures009;
	}

	public void setUres009(String ures009) {
		this.ures009 = ures009;
	}

	public String getUres010() {
		return ures010;
	}

	public void setUres010(String ures010) {
		this.ures010 = ures010;
	}

	public Double getUres011() {
		return ures011;
	}

	public void setUres011(Double ures011) {
		this.ures011 = ures011;
	}

	@Override
	protected Serializable pkVal() {
		return this.ures001;
	}

}

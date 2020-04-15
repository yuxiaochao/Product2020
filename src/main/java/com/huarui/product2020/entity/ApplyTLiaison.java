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
@TableName("APPLY_T_LIAISON")
public class ApplyTLiaison extends Model<ApplyTLiaison> {

    private static final long serialVersionUID = 1L;

    @TableId("LIAI001")
	private String liai001;
	@TableField("LIAI002")
	private String liai002;
	@TableField("LIAI003")
	private String liai003;
	@TableField("LIAI004")
	private String liai004;
	@TableField("LIAI005")
	private String liai005;
	@TableField("LIAI006")
	private String liai006;
	@TableField("LIAI007")
	private String liai007;
	@TableField("LIAI008")
	private String liai008;
	@TableField("LIAI009")
	private Date liai009;


	public String getLiai001() {
		return liai001;
	}

	public void setLiai001(String liai001) {
		this.liai001 = liai001;
	}

	public String getLiai002() {
		return liai002;
	}

	public void setLiai002(String liai002) {
		this.liai002 = liai002;
	}

	public String getLiai003() {
		return liai003;
	}

	public void setLiai003(String liai003) {
		this.liai003 = liai003;
	}

	public String getLiai004() {
		return liai004;
	}

	public void setLiai004(String liai004) {
		this.liai004 = liai004;
	}

	public String getLiai005() {
		return liai005;
	}

	public void setLiai005(String liai005) {
		this.liai005 = liai005;
	}

	public String getLiai006() {
		return liai006;
	}

	public void setLiai006(String liai006) {
		this.liai006 = liai006;
	}

	public String getLiai007() {
		return liai007;
	}

	public void setLiai007(String liai007) {
		this.liai007 = liai007;
	}

	public String getLiai008() {
		return liai008;
	}

	public void setLiai008(String liai008) {
		this.liai008 = liai008;
	}

	public Date getLiai009() {
		return liai009;
	}

	public void setLiai009(Date liai009) {
		this.liai009 = liai009;
	}

	@Override
	protected Serializable pkVal() {
		return this.liai001;
	}

}

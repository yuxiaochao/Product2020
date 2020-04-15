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
@TableName("APPLY_T_FINALUSER")
public class ApplyTFinaluser extends Model<ApplyTFinaluser> {

    private static final long serialVersionUID = 1L;

    @TableId("FIUS001")
	private String fius001;
	@TableField("FIUS002")
	private String fius002;
	@TableField("FIUS003")
	private String fius003;
	@TableField("FIUS004")
	private String fius004;
	@TableField("FIUS005")
	private String fius005;
	@TableField("FIUS006")
	private String fius006;
	@TableField("FIUS007")
	private String fius007;


	public String getFius001() {
		return fius001;
	}

	public void setFius001(String fius001) {
		this.fius001 = fius001;
	}

	public String getFius002() {
		return fius002;
	}

	public void setFius002(String fius002) {
		this.fius002 = fius002;
	}

	public String getFius003() {
		return fius003;
	}

	public void setFius003(String fius003) {
		this.fius003 = fius003;
	}

	public String getFius004() {
		return fius004;
	}

	public void setFius004(String fius004) {
		this.fius004 = fius004;
	}

	public String getFius005() {
		return fius005;
	}

	public void setFius005(String fius005) {
		this.fius005 = fius005;
	}

	public String getFius006() {
		return fius006;
	}

	public void setFius006(String fius006) {
		this.fius006 = fius006;
	}

	public String getFius007() {
		return fius007;
	}

	public void setFius007(String fius007) {
		this.fius007 = fius007;
	}

	@Override
	protected Serializable pkVal() {
		return this.fius001;
	}

}

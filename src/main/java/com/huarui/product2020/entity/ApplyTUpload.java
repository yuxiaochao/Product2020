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
@TableName("APPLY_T_UPLOAD")
public class ApplyTUpload extends Model<ApplyTUpload> {

    private static final long serialVersionUID = 1L;

    @TableId("UPLO001")
	private String uplo001;
	@TableField("UPLO002")
	private String uplo002;
	@TableField("UPLO003")
	private String uplo003;
	@TableField("UPLO004")
	private String uplo004;
	@TableField("UPLO005")
	private String uplo005;
	@TableField("UPLO006")
	private String uplo006;
	@TableField("UPLO007")
	private String uplo007;
	@TableField("UPLO008")
	private Date uplo008;


	public String getUplo001() {
		return uplo001;
	}

	public void setUplo001(String uplo001) {
		this.uplo001 = uplo001;
	}

	public String getUplo002() {
		return uplo002;
	}

	public void setUplo002(String uplo002) {
		this.uplo002 = uplo002;
	}

	public String getUplo003() {
		return uplo003;
	}

	public void setUplo003(String uplo003) {
		this.uplo003 = uplo003;
	}

	public String getUplo004() {
		return uplo004;
	}

	public void setUplo004(String uplo004) {
		this.uplo004 = uplo004;
	}

	public String getUplo005() {
		return uplo005;
	}

	public void setUplo005(String uplo005) {
		this.uplo005 = uplo005;
	}

	public String getUplo006() {
		return uplo006;
	}

	public void setUplo006(String uplo006) {
		this.uplo006 = uplo006;
	}

	public String getUplo007() {
		return uplo007;
	}

	public void setUplo007(String uplo007) {
		this.uplo007 = uplo007;
	}

	public Date getUplo008() {
		return uplo008;
	}

	public void setUplo008(Date uplo008) {
		this.uplo008 = uplo008;
	}

	@Override
	protected Serializable pkVal() {
		return this.uplo001;
	}

}

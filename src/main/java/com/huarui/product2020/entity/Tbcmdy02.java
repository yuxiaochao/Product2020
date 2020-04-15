package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author panlei
 * @since 2020-02-15
 */
public class Tbcmdy02 extends Model<Tbcmdy02> {

    private static final long serialVersionUID = 1L;

    @TableId("CMDY0201")
	private String cmdy0201;
    /**
     * 分类名称
     */
	@TableField("CMDY0202")
	private String cmdy0202;
    /**
     * 专业字典ID
     */
	@TableField("CMDY0203")
	private String cmdy0203;
	@TableField("CMDY0204")
	private String cmdy0204;
	@TableField("CMDY0205")
	private Date cmdy0205;
	@TableField("CMDY0206")
	private Date cmdy0206;
	@TableField("CMDY0207")
	private String cmdy0207;
	@TableField("CMDY0208")
	private String cmdy0208;


	public String getCmdy0201() {
		return cmdy0201;
	}

	public void setCmdy0201(String cmdy0201) {
		this.cmdy0201 = cmdy0201;
	}

	public String getCmdy0202() {
		return cmdy0202;
	}

	public void setCmdy0202(String cmdy0202) {
		this.cmdy0202 = cmdy0202;
	}

	public String getCmdy0203() {
		return cmdy0203;
	}

	public void setCmdy0203(String cmdy0203) {
		this.cmdy0203 = cmdy0203;
	}

	public String getCmdy0204() {
		return cmdy0204;
	}

	public void setCmdy0204(String cmdy0204) {
		this.cmdy0204 = cmdy0204;
	}

	public Date getCmdy0205() {
		return cmdy0205;
	}

	public void setCmdy0205(Date cmdy0205) {
		this.cmdy0205 = cmdy0205;
	}

	public Date getCmdy0206() {
		return cmdy0206;
	}

	public void setCmdy0206(Date cmdy0206) {
		this.cmdy0206 = cmdy0206;
	}

	public String getCmdy0207() {
		return cmdy0207;
	}

	public void setCmdy0207(String cmdy0207) {
		this.cmdy0207 = cmdy0207;
	}

	public String getCmdy0208() {
		return cmdy0208;
	}

	public void setCmdy0208(String cmdy0208) {
		this.cmdy0208 = cmdy0208;
	}

	@Override
	protected Serializable pkVal() {
		return this.cmdy0201;
	}

	@Override
	public String toString() {
		return "Tbcmdy02{" +
			"cmdy0201=" + cmdy0201 +
			", cmdy0202=" + cmdy0202 +
			", cmdy0203=" + cmdy0203 +
			", cmdy0204=" + cmdy0204 +
			", cmdy0205=" + cmdy0205 +
			", cmdy0206=" + cmdy0206 +
			", cmdy0207=" + cmdy0207 +
			", cmdy0208=" + cmdy0208 +
			"}";
	}
}

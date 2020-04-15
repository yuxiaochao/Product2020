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
 * @author su
 * @since 2020-02-23
 */
public class Tbclassaskquestions02 extends Model<Tbclassaskquestions02> {

    private static final long serialVersionUID = 1L;

    @TableId("CLAQ0201")
	private String claq0201;
    /**
     * 问题ID
     */
	@TableField("CLAQ0202")
	private String claq0202;
    /**
     * 课程ID
     */
	@TableField("CLAQ0203")
	private String claq0203;
    /**
     * 用户ID
     */
	@TableField("CLAQ0204")
	private String claq0204;
	@TableField("CLAQ0205")
	private String claq0205;
    /**
     * 内容类型：0、回答问题 1、回复答案
     */
	@TableField("CLAQ0206")
	private Integer claq0206;
    /**
     * 被回复的答案ID
     */
	@TableField("CLAQ0207")
	private String claq0207;
	@TableField("CLAQ0208")
	private Date claq0208;
	@TableField("CLAQ0209")
	private String claq0209;

	@TableField(exist = false)
	private String user001;
	@TableField(exist = false)
	private String user005;
	@TableField(exist = false)
	private String user028;
	@TableField(exist = false)
	private String user005_02;
	@TableField(exist = false)
	private Integer isAdopted;


	public String getClaq0201() {
		return claq0201;
	}

	public void setClaq0201(String claq0201) {
		this.claq0201 = claq0201;
	}

	public String getClaq0202() {
		return claq0202;
	}

	public void setClaq0202(String claq0202) {
		this.claq0202 = claq0202;
	}

	public String getClaq0203() {
		return claq0203;
	}

	public void setClaq0203(String claq0203) {
		this.claq0203 = claq0203;
	}

	public String getClaq0204() {
		return claq0204;
	}

	public void setClaq0204(String claq0204) {
		this.claq0204 = claq0204;
	}

	public String getClaq0205() {
		return claq0205;
	}

	public void setClaq0205(String claq0205) {
		this.claq0205 = claq0205;
	}

	public Integer getClaq0206() {
		return claq0206;
	}

	public void setClaq0206(Integer claq0206) {
		this.claq0206 = claq0206;
	}

	public String getClaq0207() {
		return claq0207;
	}

	public void setClaq0207(String claq0207) {
		this.claq0207 = claq0207;
	}

	public Date getClaq0208() {
		return claq0208;
	}

	public void setClaq0208(Date claq0208) {
		this.claq0208 = claq0208;
	}

	@Override
	protected Serializable pkVal() {
		return this.claq0201;
	}

	@Override
	public String toString() {
		return "Tbclassaskquestions02{" +
			"claq0201=" + claq0201 +
			", claq0202=" + claq0202 +
			", claq0203=" + claq0203 +
			", claq0204=" + claq0204 +
			", claq0205=" + claq0205 +
			", claq0206=" + claq0206 +
			", claq0207=" + claq0207 +
			", claq0208=" + claq0208 +
			"}";
	}

	public String getUser001() {
		return user001;
	}

	public void setUser001(String user001) {
		this.user001 = user001;
	}

	public String getUser005() {
		return user005;
	}

	public void setUser005(String user005) {
		this.user005 = user005;
	}

	public String getUser005_02() {
		return user005_02;
	}

	public void setUser005_02(String user005_02) {
		this.user005_02 = user005_02;
	}

	public String getClaq0209() {
		return claq0209;
	}

	public void setClaq0209(String claq0209) {
		this.claq0209 = claq0209;
	}

	public String getUser028() {
		return user028;
	}

	public void setUser028(String user028) {
		this.user028 = user028;
	}

	public Integer getIsAdopted() {
		return isAdopted;
	}

	public void setIsAdopted(Integer isAdopted) {
		this.isAdopted = isAdopted;
	}
}

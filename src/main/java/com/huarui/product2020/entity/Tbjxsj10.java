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
 * @author yuxiaochao
 * @since 2019-10-25
 */
public class Tbjxsj10 extends Model<Tbjxsj10> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("JXSJ1001")
	private String jxsj1001;
    /**
     * 培训班ID
     */
	@TableField("JXSJ1002")
	private String jxsj1002;
    /**
     * 小组A ID   可按班也可按组
     */
	@TableField("JXSJ1003")
	private String jxsj1003;
    /**
     * 标题
     */
	@TableField("JXSJ1004")
	private String jxsj1004;
    /**
     * 正文
     */
	@TableField("JXSJ1005")
	private String jxsj1005;
    /**
     * 提交方式0：按学员；1：按小组
     */
	@TableField("JXSJ1006")
	private Integer jxsj1006;
    /**
     * 课程ID    可关联课程，允许为空；
     */
	@TableField("JXSJ1007")
	private String jxsj1007;
    /**
     * 上传人
     */
	@TableField("JXSJ1008")
	private String jxsj1008;
    /**
     * 说明
     */
	@TableField("JXSJ1009")
	private String jxsj1009;
    /**
     * 创建时间
     */
	@TableField("JXSJ1010")
	private Date jxsj1010;
    /**
     * 最后修改时间
     */
	@TableField("JXSJ1011")
	private Date jxsj1011;
	/**
	 * 最后修改时间
	 */
	@TableField("JXSJ1012")
	private Integer jxsj1012;

	private String cour010;
	private String jxsj1006n;
	
	public String getCour010() {
		return cour010;
	}

	public void setCour010(String cour010) {
		this.cour010 = cour010;
	}

	public String getJxsj1006n() {
		return jxsj1006n;
	}

	public void setJxsj1006n(String jxsj1006n) {
		this.jxsj1006n = jxsj1006n;
	}

	public String getJxsj1001() {
		return jxsj1001;
	}

	public void setJxsj1001(String jxsj1001) {
		this.jxsj1001 = jxsj1001;
	}

	public String getJxsj1002() {
		return jxsj1002;
	}

	public void setJxsj1002(String jxsj1002) {
		this.jxsj1002 = jxsj1002;
	}

	public String getJxsj1003() {
		return jxsj1003;
	}

	public void setJxsj1003(String jxsj1003) {
		this.jxsj1003 = jxsj1003;
	}

	public String getJxsj1004() {
		return jxsj1004;
	}

	public void setJxsj1004(String jxsj1004) {
		this.jxsj1004 = jxsj1004;
	}

	public String getJxsj1005() {
		return jxsj1005;
	}

	public void setJxsj1005(String jxsj1005) {
		this.jxsj1005 = jxsj1005;
	}

	public Integer getJxsj1006() {
		return jxsj1006;
	}

	public void setJxsj1006(Integer jxsj1006) {
		this.jxsj1006 = jxsj1006;
	}

	public String getJxsj1007() {
		return jxsj1007;
	}

	public void setJxsj1007(String jxsj1007) {
		this.jxsj1007 = jxsj1007;
	}

	public String getJxsj1008() {
		return jxsj1008;
	}

	public void setJxsj1008(String jxsj1008) {
		this.jxsj1008 = jxsj1008;
	}

	public String getJxsj1009() {
		return jxsj1009;
	}

	public void setJxsj1009(String jxsj1009) {
		this.jxsj1009 = jxsj1009;
	}

	public Date getJxsj1010() {
		return jxsj1010;
	}

	public void setJxsj1010(Date jxsj1010) {
		this.jxsj1010 = jxsj1010;
	}

	public Date getJxsj1011() {
		return jxsj1011;
	}

	public void setJxsj1011(Date jxsj1011) {
		this.jxsj1011 = jxsj1011;
	}
	
	public Integer getJxsj1012() {
		return jxsj1012;
	}

	public void setJxsj1012(Integer jxsj1012) {
		this.jxsj1012 = jxsj1012;
	}

	@Override
	protected Serializable pkVal() {
		return this.jxsj1001;
	}

	@Override
	public String toString() {
		return "Tbjxsj10{" +
			"jxsj1001=" + jxsj1001 +
			", jxsj1002=" + jxsj1002 +
			", jxsj1003=" + jxsj1003 +
			", jxsj1004=" + jxsj1004 +
			", jxsj1005=" + jxsj1005 +
			", jxsj1006=" + jxsj1006 +
			", jxsj1007=" + jxsj1007 +
			", jxsj1008=" + jxsj1008 +
			", jxsj1009=" + jxsj1009 +
			", jxsj1010=" + jxsj1010 +
			", jxsj1011=" + jxsj1011 +
			"}";
	}
}

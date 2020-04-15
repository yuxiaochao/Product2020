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
public class Tbjxsj02 extends Model<Tbjxsj02> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("JXSJ0201")
	private String jxsj0201;
    /**
     * 培训班ID
     */
	@TableField("JXSJ0202")
	private String jxsj0202;
    /**
     * 标题
     */
	@TableField("JXSJ0203")
	private String jxsj0203;
    /**
     * 正文
     */
	@TableField("JXSJ0204")
	private String jxsj0204;
    /**
     * 操作人
     */
	@TableField("JXSJ0205")
	private String jxsj0205;
    /**
     * 创建时间
     */
	@TableField("JXSJ0206")
	private Date jxsj0206;
    /**
     * 最后修改时间
     */
	@TableField("JXSJ0207")
	private Date jxsj0207;
	/**
	 * 发布人
	 */
	@TableField("JXSJ0208")
	private String jxsj0208;
	/**
	 * 发布状态(0：待发布；1：已发布。)
	 */
	@TableField("JXSJ0209")
	private Integer jxsj0209;
	/**
	 * 发布时间
	 */
	@TableField("JXSJ0210")
	private Date jxsj0210;
	@TableField(exist=false)
	private String jxsj0210n;
	@TableField("JXSJ0207")
	private String user005;
	
	public String getUser005() {
		return user005;
	}

	public void setUser005(String user005) {
		this.user005 = user005;
	}

	public String getJxsj0210n() {
		return jxsj0210n;
	}

	public void setJxsj0210n(String jxsj0210n) {
		this.jxsj0210n = jxsj0210n;
	}

	public String getJxsj0201() {
		return jxsj0201;
	}

	public void setJxsj0201(String jxsj0201) {
		this.jxsj0201 = jxsj0201;
	}

	public String getJxsj0202() {
		return jxsj0202;
	}

	public void setJxsj0202(String jxsj0202) {
		this.jxsj0202 = jxsj0202;
	}

	public String getJxsj0203() {
		return jxsj0203;
	}

	public void setJxsj0203(String jxsj0203) {
		this.jxsj0203 = jxsj0203;
	}

	public String getJxsj0204() {
		return jxsj0204;
	}

	public void setJxsj0204(String jxsj0204) {
		this.jxsj0204 = jxsj0204;
	}

	public String getJxsj0205() {
		return jxsj0205;
	}

	public void setJxsj0205(String jxsj0205) {
		this.jxsj0205 = jxsj0205;
	}

	public Date getJxsj0206() {
		return jxsj0206;
	}

	public void setJxsj0206(Date jxsj0206) {
		this.jxsj0206 = jxsj0206;
	}

	public Date getJxsj0207() {
		return jxsj0207;
	}

	public void setJxsj0207(Date jxsj0207) {
		this.jxsj0207 = jxsj0207;
	}
	
	public String getJxsj0208() {
		return jxsj0208;
	}

	public void setJxsj0208(String jxsj0208) {
		this.jxsj0208 = jxsj0208;
	}

	public Integer getJxsj0209() {
		return jxsj0209;
	}

	public void setJxsj0209(Integer jxsj0209) {
		this.jxsj0209 = jxsj0209;
	}

	public Date getJxsj0210() {
		return jxsj0210;
	}

	public void setJxsj0210(Date jxsj0210) {
		this.jxsj0210 = jxsj0210;
	}

	@Override
	protected Serializable pkVal() {
		return this.jxsj0201;
	}

	@Override
	public String toString() {
		return "Tbjxsj02{" +
			"jxsj0201=" + jxsj0201 +
			", jxsj0202=" + jxsj0202 +
			", jxsj0203=" + jxsj0203 +
			", jxsj0204=" + jxsj0204 +
			", jxsj0205=" + jxsj0205 +
			", jxsj0206=" + jxsj0206 +
			", jxsj0207=" + jxsj0207 +
			"}";
	}
}

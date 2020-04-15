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
public class Tbjxsj07 extends Model<Tbjxsj07> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("JXSJ0701")
	private String jxsj0701;
    /**
     * 培训班ID
     */
	@TableField("JXSJ0702")
	private String jxsj0702;
    /**
     * 学员ID
     */
	@TableField("JXSJ0703")
	private String jxsj0703;
    /**
     * 学员角色从数据字典读取
     */
	@TableField("JXSJ0704")
	private String jxsj0704;
	/**
	 * 最后修改时间
	 */
	@TableField("JXSJ0705")
	private Date jxsj0705;


	public String getJxsj0701() {
		return jxsj0701;
	}

	public void setJxsj0701(String jxsj0701) {
		this.jxsj0701 = jxsj0701;
	}

	public String getJxsj0702() {
		return jxsj0702;
	}

	public void setJxsj0702(String jxsj0702) {
		this.jxsj0702 = jxsj0702;
	}

	public String getJxsj0703() {
		return jxsj0703;
	}

	public void setJxsj0703(String jxsj0703) {
		this.jxsj0703 = jxsj0703;
	}

	public String getJxsj0704() {
		return jxsj0704;
	}

	public void setJxsj0704(String jxsj0704) {
		this.jxsj0704 = jxsj0704;
	}
	
	public Date getJxsj0705() {
		return jxsj0705;
	}

	public void setJxsj0705(Date jxsj0705) {
		this.jxsj0705 = jxsj0705;
	}

	@Override
	protected Serializable pkVal() {
		return this.jxsj0701;
	}

	@Override
	public String toString() {
		return "Tbjxsj07{" +
			"jxsj0701=" + jxsj0701 +
			", jxsj0702=" + jxsj0702 +
			", jxsj0703=" + jxsj0703 +
			", jxsj0704=" + jxsj0704 +
			"}";
	}
}

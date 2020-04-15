package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yuxiaochao
 * @since 2019-10-25
 */
public class Tbjxsj09 extends Model<Tbjxsj09> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("JXSJ0901")
	private String jxsj0901;
    /**
     * 培训班ID
     */
	@TableField("JXSJ0902")
	private String jxsj0902;
    /**
     * 小组A ID
     */
	@TableField("JXSJ0903")
	private String jxsj0903;
    /**
     * 角色
     */
	@TableField("JXSJ0904")
	private Integer jxsj0904;
    /**
     * 学员ID
     */
	@TableField("JXSJ0905")
	private String jxsj0905;


	public String getJxsj0901() {
		return jxsj0901;
	}

	public void setJxsj0901(String jxsj0901) {
		this.jxsj0901 = jxsj0901;
	}

	public String getJxsj0902() {
		return jxsj0902;
	}

	public void setJxsj0902(String jxsj0902) {
		this.jxsj0902 = jxsj0902;
	}

	public String getJxsj0903() {
		return jxsj0903;
	}

	public void setJxsj0903(String jxsj0903) {
		this.jxsj0903 = jxsj0903;
	}

	public Integer getJxsj0904() {
		return jxsj0904;
	}

	public void setJxsj0904(Integer jxsj0904) {
		this.jxsj0904 = jxsj0904;
	}

	public String getJxsj0905() {
		return jxsj0905;
	}

	public void setJxsj0905(String jxsj0905) {
		this.jxsj0905 = jxsj0905;
	}

	@Override
	protected Serializable pkVal() {
		return this.jxsj0901;
	}

	@Override
	public String toString() {
		return "Tbjxsj09{" +
			"jxsj0901=" + jxsj0901 +
			", jxsj0902=" + jxsj0902 +
			", jxsj0903=" + jxsj0903 +
			", jxsj0904=" + jxsj0904 +
			", jxsj0905=" + jxsj0905 +
			"}";
	}
}

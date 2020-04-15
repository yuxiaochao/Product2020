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
public class Tbjxsj03 extends Model<Tbjxsj03> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("JXSJ0301")
	private String jxsj0301;
    /**
     * 培训班ID
     */
	@TableField("JXSJ0302")
	private String jxsj0302;
    /**
     * 通知ID
     */
	@TableField("JXSJ0303")
	private String jxsj0303;
    /**
     * 附件名称
     */
	@TableField("JXSJ0304")
	private String jxsj0304;
    /**
     * 附件路径
     */
	@TableField("JXSJ0305")
	private String jxsj0305;


	public String getJxsj0301() {
		return jxsj0301;
	}

	public void setJxsj0301(String jxsj0301) {
		this.jxsj0301 = jxsj0301;
	}

	public String getJxsj0302() {
		return jxsj0302;
	}

	public void setJxsj0302(String jxsj0302) {
		this.jxsj0302 = jxsj0302;
	}

	public String getJxsj0303() {
		return jxsj0303;
	}

	public void setJxsj0303(String jxsj0303) {
		this.jxsj0303 = jxsj0303;
	}

	public String getJxsj0304() {
		return jxsj0304;
	}

	public void setJxsj0304(String jxsj0304) {
		this.jxsj0304 = jxsj0304;
	}

	public String getJxsj0305() {
		return jxsj0305;
	}

	public void setJxsj0305(String jxsj0305) {
		this.jxsj0305 = jxsj0305;
	}

	@Override
	protected Serializable pkVal() {
		return this.jxsj0301;
	}

	@Override
	public String toString() {
		return "Tbjxsj03{" +
			"jxsj0301=" + jxsj0301 +
			", jxsj0302=" + jxsj0302 +
			", jxsj0303=" + jxsj0303 +
			", jxsj0304=" + jxsj0304 +
			", jxsj0305=" + jxsj0305 +
			"}";
	}
}

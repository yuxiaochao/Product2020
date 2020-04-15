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
public class Tbjxsj08 extends Model<Tbjxsj08> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("JXSJ0801")
	private String jxsj0801;
    /**
     * 培训班ID
     */
	@TableField("JXSJ0802")
	private String jxsj0802;
    /**
     * 小组名称
     */
	@TableField("JXSJ0803")
	private String jxsj0803;


	public String getJxsj0801() {
		return jxsj0801;
	}

	public void setJxsj0801(String jxsj0801) {
		this.jxsj0801 = jxsj0801;
	}

	public String getJxsj0802() {
		return jxsj0802;
	}

	public void setJxsj0802(String jxsj0802) {
		this.jxsj0802 = jxsj0802;
	}

	public String getJxsj0803() {
		return jxsj0803;
	}

	public void setJxsj0803(String jxsj0803) {
		this.jxsj0803 = jxsj0803;
	}

	@Override
	protected Serializable pkVal() {
		return this.jxsj0801;
	}

	@Override
	public String toString() {
		return "Tbjxsj08{" +
			"jxsj0801=" + jxsj0801 +
			", jxsj0802=" + jxsj0802 +
			", jxsj0803=" + jxsj0803 +
			"}";
	}
}

package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yuxiaochao
 * @since 2019-01-05
 */
@TableName("HRSW_T_JOBRIGHTSASSIGCHILD")
public class HrswTJobrightsassigchild extends Model<HrswTJobrightsassigchild> {

    private static final long serialVersionUID = 1L;

	@TableField("JRAC001")
	private String jrac001;
    /**
     * 权限分配表ID
     */
	@TableField("JRAC002")
	private String jrac002;
    /**
     *   科室ID
     */
	@TableField("JRAC003")
	private String jrac003;
    /**
     *   科室责任人ID
     */
	@TableField("JRAC004")
	private String jrac004;


	public String getJrac001() {
		return jrac001;
	}

	public void setJrac001(String jrac001) {
		this.jrac001 = jrac001;
	}

	public String getJrac002() {
		return jrac002;
	}

	public void setJrac002(String jrac002) {
		this.jrac002 = jrac002;
	}

	public String getJrac003() {
		return jrac003;
	}

	public void setJrac003(String jrac003) {
		this.jrac003 = jrac003;
	}

	public String getJrac004() {
		return jrac004;
	}

	public void setJrac004(String jrac004) {
		this.jrac004 = jrac004;
	}

	@Override
	protected Serializable pkVal() {
		return this.jrac001;
	}

	@Override
	public String toString() {
		return "HrswTJobrightsassigchild{" +
			"jrac001=" + jrac001 +
			", jrac002=" + jrac002 +
			", jrac003=" + jrac003 +
			", jrac004=" + jrac004 +
			"}";
	}
}

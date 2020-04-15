package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author yuxiaochao
 * @since 2019-01-05
 */
@TableName("HRSW_T_JOBRIGHTSASSIGNMENT")
public class HrswTJobrightsassignment extends Model<HrswTJobrightsassignment> {

    private static final long serialVersionUID = 1L;

	@TableField("JRAT001")
	private String jrat001;
    /**
     *   名称
     */
	@TableField("JRAT002")
	private String jrat002;
    /**
     *   分管领导ID
     */
	@TableField("JRAT003")
	private String jrat003;
    /**
     *   创建时间
     */
	@TableField("JRAT004")
	private Date jrat004;
    /**
     *   最后修改时间
     */
	@TableField("JRAT005")
	private Date jrat005;
    /**
     *   说明
     */
	@TableField("JRAT006")
	private Date jrat006;


	public String getJrat001() {
		return jrat001;
	}

	public void setJrat001(String jrat001) {
		this.jrat001 = jrat001;
	}

	public String getJrat002() {
		return jrat002;
	}

	public void setJrat002(String jrat002) {
		this.jrat002 = jrat002;
	}

	public String getJrat003() {
		return jrat003;
	}

	public void setJrat003(String jrat003) {
		this.jrat003 = jrat003;
	}

	public Date getJrat004() {
		return jrat004;
	}

	public void setJrat004(Date jrat004) {
		this.jrat004 = jrat004;
	}

	public Date getJrat005() {
		return jrat005;
	}

	public void setJrat005(Date jrat005) {
		this.jrat005 = jrat005;
	}

	public Date getJrat006() {
		return jrat006;
	}

	public void setJrat006(Date jrat006) {
		this.jrat006 = jrat006;
	}

	@Override
	protected Serializable pkVal() {
		return this.jrat001;
	}

	@Override
	public String toString() {
		return "HrswTJobrightsassignment{" +
			"jrat001=" + jrat001 +
			", jrat002=" + jrat002 +
			", jrat003=" + jrat003 +
			", jrat004=" + jrat004 +
			", jrat005=" + jrat005 +
			", jrat006=" + jrat006 +
			"}";
	}
}

package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author yuxiaochao
 * @since 2018-11-02
 */
@TableName("HRSW_T_TOPCONTACTS")
public class HrswTTopcontacts extends Model<HrswTTopcontacts> {

	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId("TOCT001")
	private String toct001;
	/**
	 * 用户id（自己）
	 */
	@TableField("TOCT002")
	private String toct002;
	/**
	 * 联系人id（对方）
	 */
	@TableField("TOCT003")
	private String toct003;
	/**
	 * 建立联系总次数
	 */
	@TableField("TOCT004")
	private Double toct004;
	/**
	 * 建立联系近一周次数
	 */
	@TableField("TOCT005")
	private Double toct005;
	/**
	 * 最后建立联系时间
	 */
	@TableField("TOCT006")
	private Date toct006;

	public String getToct001() {
		return toct001;
	}

	public void setToct001(String toct001) {
		this.toct001 = toct001;
	}

	public String getToct002() {
		return toct002;
	}

	public void setToct002(String toct002) {
		this.toct002 = toct002;
	}

	public String getToct003() {
		return toct003;
	}

	public void setToct003(String toct003) {
		this.toct003 = toct003;
	}

	public Double getToct004() {
		return toct004;
	}

	public void setToct004(Double toct004) {
		this.toct004 = toct004;
	}

	public Double getToct005() {
		return toct005;
	}

	public void setToct005(Double toct005) {
		this.toct005 = toct005;
	}

	public Date getToct006() {
		return toct006;
	}

	public void setToct006(Date toct006) {
		this.toct006 = toct006;
	}

	@Override
	protected Serializable pkVal() {
		return this.toct001;
	}

	@Override
	public String toString() {
		return "HrswTTopcontacts{" + "toct001=" + toct001 + ", toct002=" + toct002 + ", toct003=" + toct003
				+ ", toct004=" + toct004 + ", toct005=" + toct005 + ", toct006=" + toct006 + "}";
	}
}

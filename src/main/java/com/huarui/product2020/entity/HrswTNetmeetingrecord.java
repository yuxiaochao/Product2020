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
 * @author panlei
 * @since 2018-03-13
 */
@TableName("HRSW_T_NETMEETINGRECORD")
public class HrswTNetmeetingrecord extends Model<HrswTNetmeetingrecord> {

    private static final long serialVersionUID = 1L;

    @TableId("NETR001")
	private String netr001;
	@TableField("NETR002")
	private String netr002;
	@TableField("NETR003")
	private String netr003;
	@TableField("NETR004")
	private Date netr004;
	@TableField("NETR005")
	private Date netr005;


	public String getNetr001() {
		return netr001;
	}

	public void setNetr001(String netr001) {
		this.netr001 = netr001;
	}

	public String getNetr002() {
		return netr002;
	}

	public void setNetr002(String netr002) {
		this.netr002 = netr002;
	}

	public String getNetr003() {
		return netr003;
	}

	public void setNetr003(String netr003) {
		this.netr003 = netr003;
	}

	public Date getNetr004() {
		return netr004;
	}

	public void setNetr004(Date netr004) {
		this.netr004 = netr004;
	}

	public Date getNetr005() {
		return netr005;
	}

	public void setNetr005(Date netr005) {
		this.netr005 = netr005;
	}

	@Override
	protected Serializable pkVal() {
		return this.netr001;
	}

	@Override
	public String toString() {
		return "HrswTNetmeetingrecord{" +
			"netr001=" + netr001 +
			", netr002=" + netr002 +
			", netr003=" + netr003 +
			", netr004=" + netr004 +
			", netr005=" + netr005 +
			"}";
	}
}

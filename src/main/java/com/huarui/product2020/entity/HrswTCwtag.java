package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * ${table.comment}
 * </p>
 *
 * @author Chenrui
 * @since 2017-08-13
 */
@TableName("HRSW_T_CWTAG")
public class HrswTCwtag extends Model<HrswTCwtag> {

    private static final long serialVersionUID = 1L;

    @TableId("CWTA001")
	private String cwta001;
	@TableField("CWTA002")
	private String cwta002;
	@TableField("CWTA003")
	private String cwta003;


	public String getCwta001() {
		return cwta001;
	}

	public void setCwta001(String cwta001) {
		this.cwta001 = cwta001;
	}

	public String getCwta002() {
		return cwta002;
	}

	public void setCwta002(String cwta002) {
		this.cwta002 = cwta002;
	}

	public String getCwta003() {
		return cwta003;
	}

	public void setCwta003(String cwta003) {
		this.cwta003 = cwta003;
	}

	@Override
	protected Serializable pkVal() {
		return this.cwta001;
	}

}

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
@TableName("HRSW_T_CWSHAREUSER")
public class HrswTCwshareuser extends Model<HrswTCwshareuser> {

    private static final long serialVersionUID = 1L;

    /**
     * PK
     */
    @TableId("CWSU001")
	private String cwsu001;
    /**
     * 被共享人ID
     */
	@TableField("CWSU002")
	private String cwsu002;
    /**
     * 共享对象 1、用户 2、单位
     */
	@TableField("CWSU003")
	private String cwsu003;
	@TableField("CWSU004")
	private String cwsu004;
	@TableField("CWSU005")
	private Double cwsu005;


	public String getCwsu001() {
		return cwsu001;
	}

	public void setCwsu001(String cwsu001) {
		this.cwsu001 = cwsu001;
	}

	public String getCwsu002() {
		return cwsu002;
	}

	public void setCwsu002(String cwsu002) {
		this.cwsu002 = cwsu002;
	}

	public String getCwsu003() {
		return cwsu003;
	}

	public void setCwsu003(String cwsu003) {
		this.cwsu003 = cwsu003;
	}

	public String getCwsu004() {
		return cwsu004;
	}

	public void setCwsu004(String cwsu004) {
		this.cwsu004 = cwsu004;
	}

	public Double getCwsu005() {
		return cwsu005;
	}

	public void setCwsu005(Double cwsu005) {
		this.cwsu005 = cwsu005;
	}

	@Override
	protected Serializable pkVal() {
		return this.cwsu001;
	}

}

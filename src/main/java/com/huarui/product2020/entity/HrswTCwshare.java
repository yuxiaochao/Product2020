package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * ${table.comment}
 * </p>
 *
 * @author Chenrui
 * @since 2017-08-13
 */
@TableName("HRSW_T_CWSHARE")
public class HrswTCwshare extends Model<HrswTCwshare> {

    private static final long serialVersionUID = 1L;

    /**
     * PK
     */
    @TableId("CWSH001")
	private String cwsh001;
    /**
     * 共享人ID
     */
	@TableField("CWSH002")
	private String cwsh002;
    /**
     * 共享时间
     */
	@TableField("CWSH003")
	private Date cwsh003;
    /**
     * 共享说明
     */
	@TableField("CWSH004")
	private String cwsh004;


	public String getCwsh001() {
		return cwsh001;
	}

	public void setCwsh001(String cwsh001) {
		this.cwsh001 = cwsh001;
	}

	public String getCwsh002() {
		return cwsh002;
	}

	public void setCwsh002(String cwsh002) {
		this.cwsh002 = cwsh002;
	}

	public Date getCwsh003() {
		return cwsh003;
	}

	public void setCwsh003(Date cwsh003) {
		this.cwsh003 = cwsh003;
	}

	public String getCwsh004() {
		return cwsh004;
	}

	public void setCwsh004(String cwsh004) {
		this.cwsh004 = cwsh004;
	}

	@Override
	protected Serializable pkVal() {
		return this.cwsh001;
	}

}

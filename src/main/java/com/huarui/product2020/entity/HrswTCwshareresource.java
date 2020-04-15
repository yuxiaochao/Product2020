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
@TableName("HRSW_T_CWSHARERESOURCE")
public class HrswTCwshareresource extends Model<HrswTCwshareresource> {

    private static final long serialVersionUID = 1L;

    /**
     * PK
     */
    @TableId("CWSR001")
	private String cwsr001;
    /**
     * 目录ID
     */
	@TableField("CWSR002")
	private String cwsr002;
    /**
     * 课件ID
     */
	@TableField("CWSR003")
	private String cwsr003;
    /**
     * 共享ID
     */
	@TableField("CWSR004")
	private String cwsr004;
    /**
     * 资源类型 1、目录 2、课件
     */
	@TableField("CWSR005")
	private Double cwsr005;


	public String getCwsr001() {
		return cwsr001;
	}

	public void setCwsr001(String cwsr001) {
		this.cwsr001 = cwsr001;
	}

	public String getCwsr002() {
		return cwsr002;
	}

	public void setCwsr002(String cwsr002) {
		this.cwsr002 = cwsr002;
	}

	public String getCwsr003() {
		return cwsr003;
	}

	public void setCwsr003(String cwsr003) {
		this.cwsr003 = cwsr003;
	}

	public String getCwsr004() {
		return cwsr004;
	}

	public void setCwsr004(String cwsr004) {
		this.cwsr004 = cwsr004;
	}

	public Double getCwsr005() {
		return cwsr005;
	}

	public void setCwsr005(Double cwsr005) {
		this.cwsr005 = cwsr005;
	}

	@Override
	protected Serializable pkVal() {
		return this.cwsr001;
	}

}

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
@TableName("HRSW_T_CWCHAPTER")
public class HrswTCwchapter extends Model<HrswTCwchapter> {

    private static final long serialVersionUID = 1L;

    /**
     * PK
     */
    @TableId("CWCH001")
	private String cwch001;
    /**
     * 课件ID
     */
	@TableField("CWCH002")
	private String cwch002;
    /**
     * 章节目录编码
     */
	@TableField("CWCH003")
	private String cwch003;
    /**
     * 章节目录名称
     */
	@TableField("CWCH004")
	private String cwch004;
    /**
     * 父章节ID
     */
	@TableField("CWCH005")
	private String cwch005;
    /**
     * 层级
     */
	@TableField("CWCH006")
	private Double cwch006;
    /**
     * 顺序号
     */
	@TableField("CWCH007")
	private Double cwch007;
    /**
     * 课件章节讲义内容
     */
	@TableField("CWCH008")
	private String cwch008;
    /**
     * 课件章节视频URL
     */
	@TableField("CWCH009")
	private String cwch009;
    /**
     * 计划用时（单位：分钟）
     */
	@TableField("CWCH010")
	private Double cwch010;


	public String getCwch001() {
		return cwch001;
	}

	public void setCwch001(String cwch001) {
		this.cwch001 = cwch001;
	}

	public String getCwch002() {
		return cwch002;
	}

	public void setCwch002(String cwch002) {
		this.cwch002 = cwch002;
	}

	public String getCwch003() {
		return cwch003;
	}

	public void setCwch003(String cwch003) {
		this.cwch003 = cwch003;
	}

	public String getCwch004() {
		return cwch004;
	}

	public void setCwch004(String cwch004) {
		this.cwch004 = cwch004;
	}

	public String getCwch005() {
		return cwch005;
	}

	public void setCwch005(String cwch005) {
		this.cwch005 = cwch005;
	}

	public Double getCwch006() {
		return cwch006;
	}

	public void setCwch006(Double cwch006) {
		this.cwch006 = cwch006;
	}

	public Double getCwch007() {
		return cwch007;
	}

	public void setCwch007(Double cwch007) {
		this.cwch007 = cwch007;
	}

	public String getCwch008() {
		return cwch008;
	}

	public void setCwch008(String cwch008) {
		this.cwch008 = cwch008;
	}

	public String getCwch009() {
		return cwch009;
	}

	public void setCwch009(String cwch009) {
		this.cwch009 = cwch009;
	}

	public Double getCwch010() {
		return cwch010;
	}

	public void setCwch010(Double cwch010) {
		this.cwch010 = cwch010;
	}

	@Override
	protected Serializable pkVal() {
		return this.cwch001;
	}

}

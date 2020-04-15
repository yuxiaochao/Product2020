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
 * @since 2018-10-17
 */
@TableName("HRSW_T_USERSTATUS")
public class HrswTUserstatus extends Model<HrswTUserstatus> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId("USST001")
	private String usst001;
    /**
     * 用户id
     */
	@TableField("USST002")
	private String usst002;
    /**
     * 当前状态：1工作 2会议 3下班 4休假 5出差
     */
	@TableField("USST003")
	private Integer usst003;
    /**
     * 触发方式：1手工 2系统自动
     */
	@TableField("USST004")
	private Integer usst004;
    /**
     * 触发时间
     */
	@TableField("USST005")
	private Date usst005;
    /**
     * 开始时间
     */
	@TableField("USST006")
	private Date usst006;
    /**
     * 结束时间
     */
	@TableField("USST007")
	private Date usst007;
    /**
     * 来源类型： 1会议 2任务 3假条 0其他
     */
	@TableField("USST008")
	private Integer usst008;
    /**
     * 会议id
     */
	@TableField("USST009")
	private String usst009;
    /**
     * 任务id
     */
	@TableField("USST010")
	private String usst010;
    /**
     * 假条id
     */
	@TableField("USST011")
	private String usst011;


	public String getUsst001() {
		return usst001;
	}

	public void setUsst001(String usst001) {
		this.usst001 = usst001;
	}

	public String getUsst002() {
		return usst002;
	}

	public void setUsst002(String usst002) {
		this.usst002 = usst002;
	}

	public Integer getUsst003() {
		return usst003;
	}

	public void setUsst003(Integer usst003) {
		this.usst003 = usst003;
	}

	public Integer getUsst004() {
		return usst004;
	}

	public void setUsst004(Integer usst004) {
		this.usst004 = usst004;
	}

	public Date getUsst005() {
		return usst005;
	}

	public void setUsst005(Date usst005) {
		this.usst005 = usst005;
	}

	public Date getUsst006() {
		return usst006;
	}

	public void setUsst006(Date usst006) {
		this.usst006 = usst006;
	}

	public Date getUsst007() {
		return usst007;
	}

	public void setUsst007(Date usst007) {
		this.usst007 = usst007;
	}

	public Integer getUsst008() {
		return usst008;
	}

	public void setUsst008(Integer usst008) {
		this.usst008 = usst008;
	}

	public String getUsst009() {
		return usst009;
	}

	public void setUsst009(String usst009) {
		this.usst009 = usst009;
	}

	public String getUsst010() {
		return usst010;
	}

	public void setUsst010(String usst010) {
		this.usst010 = usst010;
	}

	public String getUsst011() {
		return usst011;
	}

	public void setUsst011(String usst011) {
		this.usst011 = usst011;
	}

	@Override
	protected Serializable pkVal() {
		return this.usst001;
	}

	@Override
	public String toString() {
		return "HrswTUserstatus{" +
			"usst001=" + usst001 +
			", usst002=" + usst002 +
			", usst003=" + usst003 +
			", usst004=" + usst004 +
			", usst005=" + usst005 +
			", usst006=" + usst006 +
			", usst007=" + usst007 +
			", usst008=" + usst008 +
			", usst009=" + usst009 +
			", usst010=" + usst010 +
			", usst011=" + usst011 +
			"}";
	}
}

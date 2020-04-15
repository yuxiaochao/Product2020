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
@TableName("HRSW_T_TASKRESULT")
public class HrswTTaskresult extends Model<HrswTTaskresult> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId("TARE001")
	private String tare001;
    /**
     * 任务id
     */
	@TableField("TARE002")
	private String tare002;
    /**
     * 人员id
     */
	@TableField("TARE003")
	private String tare003;
    /**
     * 任务状态：1.执行中 2.已完成
     */
	@TableField("TARE004")
	private Integer tare004;
    /**
     * 完成时间
     */
	@TableField("TARE005")
	private Date tare005;


	public String getTare001() {
		return tare001;
	}

	public void setTare001(String tare001) {
		this.tare001 = tare001;
	}

	public String getTare002() {
		return tare002;
	}

	public void setTare002(String tare002) {
		this.tare002 = tare002;
	}

	public String getTare003() {
		return tare003;
	}

	public void setTare003(String tare003) {
		this.tare003 = tare003;
	}

	public Integer getTare004() {
		return tare004;
	}

	public void setTare004(Integer tare004) {
		this.tare004 = tare004;
	}

	public Date getTare005() {
		return tare005;
	}

	public void setTare005(Date tare005) {
		this.tare005 = tare005;
	}

	@Override
	protected Serializable pkVal() {
		return this.tare001;
	}

	@Override
	public String toString() {
		return "HrswTTaskresult{" +
			"tare001=" + tare001 +
			", tare002=" + tare002 +
			", tare003=" + tare003 +
			", tare004=" + tare004 +
			", tare005=" + tare005 +
			"}";
	}
}

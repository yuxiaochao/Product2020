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
@TableName("HRSW_T_PERSONNELSINKING")
public class HrswTPersonnelsinking extends Model<HrswTPersonnelsinking> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId("PESI001")
	private String pesi001;
    /**
     * 原单位
     */
	@TableField("PESI002")
	private String pesi002;
    /**
     * 下沉开始时间
     */
	@TableField("PESI003")
	private Date pesi003;
    /**
     * 下沉结束时间
     */
	@TableField("PESI004")
	private Date pesi004;
    /**
     * 原单位部门
     */
	@TableField("PESI005")
	private String pesi005;
    /**
     * 迁入单位id
     */
	@TableField("PESI006")
	private String pesi006;
    /**
     * 用户id
     */
	@TableField("PESI007")
	private String pesi007;
    /**
     * 说明
     */
	@TableField("PESI008")
	private String pesi008;
    /**
     * 创建时间
     */
	@TableField("PESI009")
	private Date pesi009;


	public String getPesi001() {
		return pesi001;
	}

	public void setPesi001(String pesi001) {
		this.pesi001 = pesi001;
	}

	public String getPesi002() {
		return pesi002;
	}

	public void setPesi002(String pesi002) {
		this.pesi002 = pesi002;
	}

	public Date getPesi003() {
		return pesi003;
	}

	public void setPesi003(Date pesi003) {
		this.pesi003 = pesi003;
	}

	public Date getPesi004() {
		return pesi004;
	}

	public void setPesi004(Date pesi004) {
		this.pesi004 = pesi004;
	}

	public String getPesi005() {
		return pesi005;
	}

	public void setPesi005(String pesi005) {
		this.pesi005 = pesi005;
	}

	public String getPesi006() {
		return pesi006;
	}

	public void setPesi006(String pesi006) {
		this.pesi006 = pesi006;
	}

	public String getPesi007() {
		return pesi007;
	}

	public void setPesi007(String pesi007) {
		this.pesi007 = pesi007;
	}

	public String getPesi008() {
		return pesi008;
	}

	public void setPesi008(String pesi008) {
		this.pesi008 = pesi008;
	}

	public Date getPesi009() {
		return pesi009;
	}

	public void setPesi009(Date pesi009) {
		this.pesi009 = pesi009;
	}

	@Override
	protected Serializable pkVal() {
		return this.pesi001;
	}

	@Override
	public String toString() {
		return "HrswTPersonnelsinking{" +
			"pesi001=" + pesi001 +
			", pesi002=" + pesi002 +
			", pesi003=" + pesi003 +
			", pesi004=" + pesi004 +
			", pesi005=" + pesi005 +
			", pesi006=" + pesi006 +
			", pesi007=" + pesi007 +
			", pesi008=" + pesi008 +
			", pesi009=" + pesi009 +
			"}";
	}
}

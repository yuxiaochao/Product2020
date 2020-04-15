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
@TableName("HRSW_T_CACHE")
public class HrswTCache extends Model<HrswTCache> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("CACH001")
	private String cach001;
    /**
     * 缓存名称
     */
	@TableField("CACH002")
	private String cach002;
    /**
     * 缓存编码
     */
	@TableField("CACH003")
	private String cach003;
    /**
     * 缓存KEY
     */
	@TableField("CACH004")
	private String cach004;
    /**
     * 功能模块路径
     */
	@TableField("CACH005")
	private String cach005;
    /**
     * 更新时间
     */
	@TableField("CACH006")
	private Date cach006;
    /**
     * 备注说明
     */
	@TableField("CACH007")
	private String cach007;


	public String getCach001() {
		return cach001;
	}

	public void setCach001(String cach001) {
		this.cach001 = cach001;
	}

	public String getCach002() {
		return cach002;
	}

	public void setCach002(String cach002) {
		this.cach002 = cach002;
	}

	public String getCach003() {
		return cach003;
	}

	public void setCach003(String cach003) {
		this.cach003 = cach003;
	}

	public String getCach004() {
		return cach004;
	}

	public void setCach004(String cach004) {
		this.cach004 = cach004;
	}

	public String getCach005() {
		return cach005;
	}

	public void setCach005(String cach005) {
		this.cach005 = cach005;
	}

	public Date getCach006() {
		return cach006;
	}

	public void setCach006(Date cach006) {
		this.cach006 = cach006;
	}

	public String getCach007() {
		return cach007;
	}

	public void setCach007(String cach007) {
		this.cach007 = cach007;
	}

	@Override
	protected Serializable pkVal() {
		return this.cach001;
	}

}

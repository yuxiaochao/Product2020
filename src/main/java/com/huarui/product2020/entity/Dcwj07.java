package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

import java.io.Serializable;

/**
 * <p>
 * 问卷与试题关系表
 * </p>
 *
 * @author pl
 * @since 2020-01-08
 */
public class Dcwj07 extends Model<Dcwj07> {

    private static final long serialVersionUID = 1L;

    /**
     * 	pk
     */
    @TableId("DCWJ0701")
	private String dcwj0701;
    /**
     * 	试题ID (DCWJ04)
     */
	@TableField("DCWJ0702")
	private String dcwj0702;
    /**
     * 	问卷ID (DCWJ02)
     */
	@TableField("DCWJ0703")
	private String dcwj0703;
    /**
     * 问卷分类ID (DCWJ01)
     */
	@TableField("DCWJ0704")
	private String dcwj0704;


	public String getDcwj0701() {
		return dcwj0701;
	}

	public void setDcwj0701(String dcwj0701) {
		this.dcwj0701 = dcwj0701;
	}

	public String getDcwj0702() {
		return dcwj0702;
	}

	public void setDcwj0702(String dcwj0702) {
		this.dcwj0702 = dcwj0702;
	}

	public String getDcwj0703() {
		return dcwj0703;
	}

	public void setDcwj0703(String dcwj0703) {
		this.dcwj0703 = dcwj0703;
	}

	public String getDcwj0704() {
		return dcwj0704;
	}

	public void setDcwj0704(String dcwj0704) {
		this.dcwj0704 = dcwj0704;
	}

	@Override
	protected Serializable pkVal() {
		return this.dcwj0701;
	}

	@Override
	public String toString() {
		return "Dcwj07{" +
			"dcwj0701=" + dcwj0701 +
			", dcwj0702=" + dcwj0702 +
			", dcwj0703=" + dcwj0703 +
			", dcwj0704=" + dcwj0704 +
			"}";
	}
}

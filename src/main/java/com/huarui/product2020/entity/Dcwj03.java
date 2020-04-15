package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 问卷共享表
 * </p>
 *
 * @author pl
 * @since 2019-12-21
 */
public class Dcwj03 extends Model<Dcwj03> {

    private static final long serialVersionUID = 1L;

    /**
     * 	PK
     */
    @TableId("DCWJ0301")
	private String dcwj0301;
    /**
     * 问卷分类ID (DCWJ01)
     */
	@TableField("DCWJ0302")
	private String dcwj0302;
    /**
     * 问卷表ID (DCWJ02)
     */
	@TableField("DCWJ0303")
	private String dcwj0303;
    /**
     * 	机构ID (hrsw_t_organ)
     */
	@TableField("DCWJ0304")
	private String dcwj0304;
    /**
     * 人员ID (hrsw_t_user)
     */
	@TableField("DCWJ0305")
	private String dcwj0305;
    /**
     * 	加入时间
     */
	@TableField("DCWJ0306")
	private Date dcwj0306;


	public String getDcwj0301() {
		return dcwj0301;
	}

	public void setDcwj0301(String dcwj0301) {
		this.dcwj0301 = dcwj0301;
	}

	public String getDcwj0302() {
		return dcwj0302;
	}

	public void setDcwj0302(String dcwj0302) {
		this.dcwj0302 = dcwj0302;
	}

	public String getDcwj0303() {
		return dcwj0303;
	}

	public void setDcwj0303(String dcwj0303) {
		this.dcwj0303 = dcwj0303;
	}

	public String getDcwj0304() {
		return dcwj0304;
	}

	public void setDcwj0304(String dcwj0304) {
		this.dcwj0304 = dcwj0304;
	}

	public String getDcwj0305() {
		return dcwj0305;
	}

	public void setDcwj0305(String dcwj0305) {
		this.dcwj0305 = dcwj0305;
	}

	public Date getDcwj0306() {
		return dcwj0306;
	}

	public void setDcwj0306(Date dcwj0306) {
		this.dcwj0306 = dcwj0306;
	}

	@Override
	protected Serializable pkVal() {
		return this.dcwj0301;
	}

	@Override
	public String toString() {
		return "Dcwj03{" +
			"dcwj0301=" + dcwj0301 +
			", dcwj0302=" + dcwj0302 +
			", dcwj0303=" + dcwj0303 +
			", dcwj0304=" + dcwj0304 +
			", dcwj0305=" + dcwj0305 +
			", dcwj0306=" + dcwj0306 +
			"}";
	}
}

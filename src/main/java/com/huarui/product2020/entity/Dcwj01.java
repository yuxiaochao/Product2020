package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 问卷分类表
 * </p>
 *
 * @author pl
 * @since 2019-12-21
 */
public class Dcwj01 extends Model<Dcwj01> {

    private static final long serialVersionUID = 1L;

    /**
     * pk
     */
    @TableId("DCWJ0101")
	private String dcwj0101;
    /**
     * 名称（DCWJ0102+ DCWJ0103（UQ））
     */
	@TableField("DCWJ0102")
	private String dcwj0102;
    /**
     * 责任单位(hrsw_t_organ）FK
     */
	@TableField("DCWJ0103")
	private String dcwj0103;
    /**
     * 责任人
     */
	@TableField("DCWJ0104")
	private String dcwj0104;
    /**
     * 说明
     */
	@TableField("DCWJ0105")
	private String dcwj0105;
    /**
     * 	创建时间
     */
	@TableField("DCWJ0106")
	private Date dcwj0106;
    /**
     * 	最后修改时间
     */
	@TableField("DCWJ0107")
	private Date dcwj0107;
    /**
     * 创建人
     */
	@TableField("DCWJ0108")
	private String dcwj0108;


	public String getDcwj0101() {
		return dcwj0101;
	}

	public void setDcwj0101(String dcwj0101) {
		this.dcwj0101 = dcwj0101;
	}

	public String getDcwj0102() {
		return dcwj0102;
	}

	public void setDcwj0102(String dcwj0102) {
		this.dcwj0102 = dcwj0102;
	}

	public String getDcwj0103() {
		return dcwj0103;
	}

	public void setDcwj0103(String dcwj0103) {
		this.dcwj0103 = dcwj0103;
	}

	public String getDcwj0104() {
		return dcwj0104;
	}

	public void setDcwj0104(String dcwj0104) {
		this.dcwj0104 = dcwj0104;
	}

	public String getDcwj0105() {
		return dcwj0105;
	}

	public void setDcwj0105(String dcwj0105) {
		this.dcwj0105 = dcwj0105;
	}

	public Date getDcwj0106() {
		return dcwj0106;
	}

	public void setDcwj0106(Date dcwj0106) {
		this.dcwj0106 = dcwj0106;
	}

	public Date getDcwj0107() {
		return dcwj0107;
	}

	public void setDcwj0107(Date dcwj0107) {
		this.dcwj0107 = dcwj0107;
	}

	public String getDcwj0108() {
		return dcwj0108;
	}

	public void setDcwj0108(String dcwj0108) {
		this.dcwj0108 = dcwj0108;
	}

	@Override
	protected Serializable pkVal() {
		return this.dcwj0101;
	}

	@Override
	public String toString() {
		return "Dcwj01{" +
			"dcwj0101=" + dcwj0101 +
			", dcwj0102=" + dcwj0102 +
			", dcwj0103=" + dcwj0103 +
			", dcwj0104=" + dcwj0104 +
			", dcwj0105=" + dcwj0105 +
			", dcwj0106=" + dcwj0106 +
			", dcwj0107=" + dcwj0107 +
			", dcwj0108=" + dcwj0108 +
			"}";
	}
}

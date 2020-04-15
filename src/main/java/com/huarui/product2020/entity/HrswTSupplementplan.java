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
@TableName("HRSW_T_SUPPLEMENTPLAN")
public class HrswTSupplementplan extends Model<HrswTSupplementplan> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId("SUPL001")
	private String supl001;
    /**
     * 补充计划日期（某天）
     */
	@TableField("SUPL002")
	private String supl002;
    /**
     * 类型：1.不用出勤 2.临时出勤 3.出勤时间调整
     */
	@TableField("SUPL003")
	private Double supl003;
    /**
     * 上班签到时间
     */
	@TableField("SUPL004")
	private String supl004;
    /**
     * 下班签到时间
     */
	@TableField("SUPL005")
	private String supl005;
    /**
     * 创建人id
     */
	@TableField("SUPL006")
	private String supl006;
    /**
     * 创建时间

     */
	@TableField("SUPL007")
	private Date supl007;


	public String getSupl001() {
		return supl001;
	}

	public void setSupl001(String supl001) {
		this.supl001 = supl001;
	}

	public String getSupl002() {
		return supl002;
	}

	public void setSupl002(String supl002) {
		this.supl002 = supl002;
	}

	public Double getSupl003() {
		return supl003;
	}

	public void setSupl003(Double supl003) {
		this.supl003 = supl003;
	}

	public String getSupl004() {
		return supl004;
	}

	public void setSupl004(String supl004) {
		this.supl004 = supl004;
	}

	public String getSupl005() {
		return supl005;
	}

	public void setSupl005(String supl005) {
		this.supl005 = supl005;
	}

	public String getSupl006() {
		return supl006;
	}

	public void setSupl006(String supl006) {
		this.supl006 = supl006;
	}

	public Date getSupl007() {
		return supl007;
	}

	public void setSupl007(Date supl007) {
		this.supl007 = supl007;
	}

	@Override
	protected Serializable pkVal() {
		return this.supl001;
	}

	@Override
	public String toString() {
		return "HrswTSupplementplan{" +
			"supl001=" + supl001 +
			", supl002=" + supl002 +
			", supl003=" + supl003 +
			", supl004=" + supl004 +
			", supl005=" + supl005 +
			", supl006=" + supl006 +
			", supl007=" + supl007 +
			"}";
	}
}

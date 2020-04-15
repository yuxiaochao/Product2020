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
@TableName("HRSW_T_CADREPOST")
public class HrswTCadrepost extends Model<HrswTCadrepost> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId("CAPO001")
	private String capo001;
    /**
     * 职务名称
     */
	@TableField("CAPO002")
	private String capo002;
    /**
     * 职务代码
     */
	@TableField("CAPO003")
	private String capo003;
    /**
     * 分工
     */
	@TableField("CAPO004")
	private String capo004;
    /**
     * 主要职责
     */
	@TableField("CAPO005")
	private String capo005;
    /**
     * 创建时间
     */
	@TableField("CAPO006")
	private Date capo006;
    /**
     * 创建人id
     */
	@TableField("CAPO007")
	private String capo007;


	public String getCapo001() {
		return capo001;
	}

	public void setCapo001(String capo001) {
		this.capo001 = capo001;
	}

	public String getCapo002() {
		return capo002;
	}

	public void setCapo002(String capo002) {
		this.capo002 = capo002;
	}

	public String getCapo003() {
		return capo003;
	}

	public void setCapo003(String capo003) {
		this.capo003 = capo003;
	}

	public String getCapo004() {
		return capo004;
	}

	public void setCapo004(String capo004) {
		this.capo004 = capo004;
	}

	public String getCapo005() {
		return capo005;
	}

	public void setCapo005(String capo005) {
		this.capo005 = capo005;
	}

	public Date getCapo006() {
		return capo006;
	}

	public void setCapo006(Date capo006) {
		this.capo006 = capo006;
	}

	public String getCapo007() {
		return capo007;
	}

	public void setCapo007(String capo007) {
		this.capo007 = capo007;
	}

	@Override
	protected Serializable pkVal() {
		return this.capo001;
	}

	@Override
	public String toString() {
		return "HrswTCadrepost{" +
			"capo001=" + capo001 +
			", capo002=" + capo002 +
			", capo003=" + capo003 +
			", capo004=" + capo004 +
			", capo005=" + capo005 +
			", capo006=" + capo006 +
			", capo007=" + capo007 +
			"}";
	}
}

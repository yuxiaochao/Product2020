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
@TableName("HRSW_T_DOCUMENTARYFACTSREPORT")
public class HrswTDocumentaryfactsreport extends Model<HrswTDocumentaryfactsreport> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId("DOFR001")
	private String dofr001;
    /**
     * 纪实任务id
     */
	@TableField("DOFR002")
	private String dofr002;
    /**
     * 上报人id
     */
	@TableField("DOFR003")
	private String dofr003;
    /**
     * 上报时间
     */
	@TableField("DOFR004")
	private Date dofr004;
    /**
     * 确认人id
     */
	@TableField("DOFR005")
	private String dofr005;
    /**
     * 确认时间
     */
	@TableField("DOFR006")
	private Date dofr006;
	
	public Integer getDofr007() {
		return dofr007;
	}

	public void setDofr007(Integer dofr007) {
		this.dofr007 = dofr007;
	}

	private Integer dofr007;


	public String getDofr001() {
		return dofr001;
	}

	public void setDofr001(String dofr001) {
		this.dofr001 = dofr001;
	}

	public String getDofr002() {
		return dofr002;
	}

	public void setDofr002(String dofr002) {
		this.dofr002 = dofr002;
	}

	public String getDofr003() {
		return dofr003;
	}

	public void setDofr003(String dofr003) {
		this.dofr003 = dofr003;
	}

	public Date getDofr004() {
		return dofr004;
	}

	public void setDofr004(Date dofr004) {
		this.dofr004 = dofr004;
	}

	public String getDofr005() {
		return dofr005;
	}

	public void setDofr005(String dofr005) {
		this.dofr005 = dofr005;
	}

	public Date getDofr006() {
		return dofr006;
	}

	public void setDofr006(Date dofr006) {
		this.dofr006 = dofr006;
	}

	@Override
	protected Serializable pkVal() {
		return this.dofr001;
	}

	@Override
	public String toString() {
		return "HrswTDocumentaryfactsreport{" +
			"dofr001=" + dofr001 +
			", dofr002=" + dofr002 +
			", dofr003=" + dofr003 +
			", dofr004=" + dofr004 +
			", dofr005=" + dofr005 +
			", dofr006=" + dofr006 +
			"}";
	}
}

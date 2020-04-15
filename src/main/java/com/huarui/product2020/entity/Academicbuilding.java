package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 教学楼表
 * </p>
 *
 * @author caifenglin
 * @since 2019-12-23
 */
@TableName("HR_T_ACADEMICBUILDING")
public class Academicbuilding extends Model<Academicbuilding> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("ACAD001")
	private String acad001;
    /**
     * 教学楼名称
     */
	@TableField("ACAD002")
	private String acad002;
    /**
     * 地点描述
     */
	@TableField("ACAD003")
	private String acad003;
    /**
     * 说明
     */
	@TableField("ACAD004")
	private String acad004;
    /**
     * 操作人
     */
	@TableField("ACAD005")
	private String acad005;
    /**
     * 创建时间
     */
	@TableField("ACAD006")
	private Date acad006;
    /**
     * 最后修改时间
     */
	@TableField("ACAD007")
	private Date acad007;


	public String getAcad001() {
		return acad001;
	}

	public void setAcad001(String acad001) {
		this.acad001 = acad001;
	}

	public String getAcad002() {
		return acad002;
	}

	public void setAcad002(String acad002) {
		this.acad002 = acad002;
	}

	public String getAcad003() {
		return acad003;
	}

	public void setAcad003(String acad003) {
		this.acad003 = acad003;
	}

	public String getAcad004() {
		return acad004;
	}

	public void setAcad004(String acad004) {
		this.acad004 = acad004;
	}

	public String getAcad005() {
		return acad005;
	}

	public void setAcad005(String acad005) {
		this.acad005 = acad005;
	}

	public Date getAcad006() {
		return acad006;
	}

	public void setAcad006(Date acad006) {
		this.acad006 = acad006;
	}

	public Date getAcad007() {
		return acad007;
	}

	public void setAcad007(Date acad007) {
		this.acad007 = acad007;
	}

	@Override
	protected Serializable pkVal() {
		return this.acad001;
	}

	@Override
	public String toString() {
		return "Academicbuilding{" +
			"acad001=" + acad001 +
			", acad002=" + acad002 +
			", acad003=" + acad003 +
			", acad004=" + acad004 +
			", acad005=" + acad005 +
			", acad006=" + acad006 +
			", acad007=" + acad007 +
			"}";
	}
}

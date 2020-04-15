package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhangyalong
 * @since 2018-12-19
 */
@TableName("HRSW_T_DOCUMENTARYFACTSPICTURE")
public class HrswTDocumentaryfactspicture extends Model<HrswTDocumentaryfactspicture> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("DOFP001")
	private String dofp001;
    /**
     * 照片类型
     */
	@TableField("DOFP002")
	private Integer dofp002;
    /**
     * 纪实ID
     */
	@TableField("DOFP003")
	private String dofp003;
    /**
     * 照片url
     */
	@TableField("DOFP004")
	private String dofp004;


	public String getDofp001() {
		return dofp001;
	}

	public void setDofp001(String dofp001) {
		this.dofp001 = dofp001;
	}

	public Integer getDofp002() {
		return dofp002;
	}

	public void setDofp002(Integer dofp002) {
		this.dofp002 = dofp002;
	}

	public String getDofp003() {
		return dofp003;
	}

	public void setDofp003(String dofp003) {
		this.dofp003 = dofp003;
	}

	public String getDofp004() {
		return dofp004;
	}

	public void setDofp004(String dofp004) {
		this.dofp004 = dofp004;
	}

	@Override
	protected Serializable pkVal() {
		return this.dofp001;
	}

	@Override
	public String toString() {
		return "HrswTDocumentaryfactspicture{" +
			"dofp001=" + dofp001 +
			", dofp002=" + dofp002 +
			", dofp003=" + dofp003 +
			", dofp004=" + dofp004 +
			"}";
	}
}

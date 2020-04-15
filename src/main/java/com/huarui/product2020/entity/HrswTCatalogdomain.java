package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * ${table.comment}
 * </p>
 *
 * @author Chenrui
 * @since 2017-08-13
 */
@TableName("HRSW_T_CATALOGDOMAIN")
public class HrswTCatalogdomain extends Model<HrswTCatalogdomain> {

    private static final long serialVersionUID = 1L;

    @TableId("CDOM001")
	private String cdom001;
    /**
     * 目录ID
     */
	@TableField("CDOM002")
	private String cdom002;
    /**
     * 机构ID
     */
	@TableField("CDOM003")
	private String cdom003;
    /**
     * 群组ID
     */
	@TableField("CDOM004")
	private String cdom004;
    /**
     * 岗位ID
     */
	@TableField("CDOM005")
	private String cdom005;
    /**
     * 用户ID
     */
	@TableField("CDOM006")
	private String cdom006;


	public String getCdom001() {
		return cdom001;
	}

	public void setCdom001(String cdom001) {
		this.cdom001 = cdom001;
	}

	public String getCdom002() {
		return cdom002;
	}

	public void setCdom002(String cdom002) {
		this.cdom002 = cdom002;
	}

	public String getCdom003() {
		return cdom003;
	}

	public void setCdom003(String cdom003) {
		this.cdom003 = cdom003;
	}

	public String getCdom004() {
		return cdom004;
	}

	public void setCdom004(String cdom004) {
		this.cdom004 = cdom004;
	}

	public String getCdom005() {
		return cdom005;
	}

	public void setCdom005(String cdom005) {
		this.cdom005 = cdom005;
	}

	public String getCdom006() {
		return cdom006;
	}

	public void setCdom006(String cdom006) {
		this.cdom006 = cdom006;
	}

	@Override
	protected Serializable pkVal() {
		return this.cdom001;
	}

}

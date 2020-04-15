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
@TableName("HRSW_T_LEVELRELATION")
public class HrswTLevelrelation extends Model<HrswTLevelrelation> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("LREL001")
	private String lrel001;
    /**
     * ID
     */
	@TableField("LREL002")
	private String lrel002;
    /**
     * 层级
     */
	@TableField("LREL003")
	private Integer lrel003;
    /**
     * 关联ID
     */
	@TableField("LREL004")
	private String lrel004;
    /**
     * 关联层级
     */
	@TableField("LREL005")
	private Integer lrel005;
    /**
     * 关联类型 1、上级2、本级
     */
	@TableField("LREL006")
	private Integer lrel006;
    /**
     * 层级类型 1、机构2、目录
     */
	@TableField("LREL007")
	private Integer lrel007;


	public String getLrel001() {
		return lrel001;
	}

	public void setLrel001(String lrel001) {
		this.lrel001 = lrel001;
	}

	public String getLrel002() {
		return lrel002;
	}

	public void setLrel002(String lrel002) {
		this.lrel002 = lrel002;
	}

	public Integer getLrel003() {
		return lrel003;
	}

	public void setLrel003(Integer lrel003) {
		this.lrel003 = lrel003;
	}

	public String getLrel004() {
		return lrel004;
	}

	public void setLrel004(String lrel004) {
		this.lrel004 = lrel004;
	}

	public Integer getLrel005() {
		return lrel005;
	}

	public void setLrel005(Integer lrel005) {
		this.lrel005 = lrel005;
	}

	public Integer getLrel006() {
		return lrel006;
	}

	public void setLrel006(Integer lrel006) {
		this.lrel006 = lrel006;
	}

	public Integer getLrel007() {
		return lrel007;
	}

	public void setLrel007(Integer lrel007) {
		this.lrel007 = lrel007;
	}

	@Override
	protected Serializable pkVal() {
		return this.lrel001;
	}

}

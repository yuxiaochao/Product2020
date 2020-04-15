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
@TableName("HRSW_T_ROLE")
public class HrswTRole extends Model<HrswTRole> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("ROLE001")
	private String role001;
    /**
     * 机构ID
     */
	@TableField("ROLE002")
	private String role002;
    /**
     * 角色名称
     */
	@TableField("ROLE003")
	private String role003;
    /**
     * 角色编码
     */
	@TableField("ROLE004")
	private String role004;
    /**
     * 排序号
     */
	@TableField("ROLE005")
	private Long role005;
    /**
     * 备注
     */
	@TableField("ROLE006")
	private String role006;
    /**
     * 状态 1 启用、2 禁用
     */
	@TableField("ROLE007")
	private Long role007;


	public String getRole001() {
		return role001;
	}

	public void setRole001(String role001) {
		this.role001 = role001;
	}

	public String getRole002() {
		return role002;
	}

	public void setRole002(String role002) {
		this.role002 = role002;
	}

	public String getRole003() {
		return role003;
	}

	public void setRole003(String role003) {
		this.role003 = role003;
	}

	public String getRole004() {
		return role004;
	}

	public void setRole004(String role004) {
		this.role004 = role004;
	}

	public Long getRole005() {
		return role005;
	}

	public void setRole005(Long role005) {
		this.role005 = role005;
	}

	public String getRole006() {
		return role006;
	}

	public void setRole006(String role006) {
		this.role006 = role006;
	}

	public Long getRole007() {
		return role007;
	}

	public void setRole007(Long role007) {
		this.role007 = role007;
	}

	@Override
	protected Serializable pkVal() {
		return this.role001;
	}

}

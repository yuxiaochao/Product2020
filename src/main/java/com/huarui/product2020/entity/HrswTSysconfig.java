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
@TableName("HRSW_T_SYSCONFIG")
public class HrswTSysconfig extends Model<HrswTSysconfig> {

    private static final long serialVersionUID = 1L;

    @TableId("SYSC001")
	private String sysc001;
	@TableField("SYSC002")
	private String sysc002;
    /**
     * 配置项类型  1、WEB  2、Android  3、IOS
     */
	@TableField("SYSC003")
	private Integer sysc003;
    /**
     * 模块编码
     */
	@TableField("SYSC004")
	private String sysc004;
    /**
     * 配置项KEY
     */
	@TableField("SYSC005")
	private String sysc005;
    /**
     * 配置项名称
     */
	@TableField("SYSC006")
	private String sysc006;
    /**
     * 配置项值  多个使用‘;’分割
     */
	@TableField("SYSC007")
	private String sysc007;
    /**
     * 是否必填  1:必填  2：非必填
     */
	@TableField("SYSC008")
	private Integer sysc008;
    /**
     * 配置项描述
     */
	@TableField("SYSC009")
	private String sysc009;
    /**
     * 排序号
     */
	@TableField("SYSC010")
	private Long sysc010;
    /**
     * 配置项分组
     */
	@TableField("SYSC011")
	private String sysc011;
    /**
     * 配置项状态 1、 启用 2、禁用
     */
	@TableField("SYSC012")
	private Integer sysc012;


	public String getSysc001() {
		return sysc001;
	}

	public void setSysc001(String sysc001) {
		this.sysc001 = sysc001;
	}

	public String getSysc002() {
		return sysc002;
	}

	public void setSysc002(String sysc002) {
		this.sysc002 = sysc002;
	}

	public Integer getSysc003() {
		return sysc003;
	}

	public void setSysc003(Integer sysc003) {
		this.sysc003 = sysc003;
	}

	public String getSysc004() {
		return sysc004;
	}

	public void setSysc004(String sysc004) {
		this.sysc004 = sysc004;
	}

	public String getSysc005() {
		return sysc005;
	}

	public void setSysc005(String sysc005) {
		this.sysc005 = sysc005;
	}

	public String getSysc006() {
		return sysc006;
	}

	public void setSysc006(String sysc006) {
		this.sysc006 = sysc006;
	}

	public String getSysc007() {
		return sysc007;
	}

	public void setSysc007(String sysc007) {
		this.sysc007 = sysc007;
	}

	public Integer getSysc008() {
		return sysc008;
	}

	public void setSysc008(Integer sysc008) {
		this.sysc008 = sysc008;
	}

	public String getSysc009() {
		return sysc009;
	}

	public void setSysc009(String sysc009) {
		this.sysc009 = sysc009;
	}

	public Long getSysc010() {
		return sysc010;
	}

	public void setSysc010(Long sysc010) {
		this.sysc010 = sysc010;
	}

	public String getSysc011() {
		return sysc011;
	}

	public Integer getSysc012() {
		return sysc012;
	}

	public void setSysc012(Integer sysc012) {
		this.sysc012 = sysc012;
	}

	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * ${table.comment}
 * </p>
 *
 * @author Chenrui
 * @since 2017-08-13
 */
@TableName("HRSW_T_WEBLOG")
public class HrswTWeblog extends Model<HrswTWeblog> {

    private static final long serialVersionUID = 1L;

    @TableId("WLOG001")
	private String wlog001;
    /**
     * 登陆ID
     */
	@TableField("WLOG002")
	private String wlog002;
    /**
     * 日志类型  1、系统事件2、业务事件3、成功事件4、失败事件等
     */
	@TableField("WLOG003")
	private Long wlog003;
    /**
     * 用户ID
     */
	@TableField("WLOG004")
	private String wlog004;
    /**
     * 发起者信息
     */
	@TableField("WLOG005")
	private String wlog005;
    /**
     * 操作时间
     */
	@TableField("WLOG006")
	private Date wlog006;
    /**
     * 业务模块
     */
	@TableField("WLOG007")
	private String wlog007;
    /**
     * 操作类型   1、查询2、新增3、修改4、删除、5导入6、导出7、预览等
     */
	@TableField("WLOG008")
	private Long wlog008;
    /**
     * 详细信息
     */
	@TableField("WLOG009")
	private String wlog009;
    /**
     * 具体方法（仅对内，不对外）
     */
	@TableField("WLOG010")
	private String wlog010;


	public String getWlog001() {
		return wlog001;
	}

	public void setWlog001(String wlog001) {
		this.wlog001 = wlog001;
	}

	public String getWlog002() {
		return wlog002;
	}

	public void setWlog002(String wlog002) {
		this.wlog002 = wlog002;
	}

	public Long getWlog003() {
		return wlog003;
	}

	public void setWlog003(Long wlog003) {
		this.wlog003 = wlog003;
	}

	public String getWlog004() {
		return wlog004;
	}

	public void setWlog004(String wlog004) {
		this.wlog004 = wlog004;
	}

	public String getWlog005() {
		return wlog005;
	}

	public void setWlog005(String wlog005) {
		this.wlog005 = wlog005;
	}

	public Date getWlog006() {
		return wlog006;
	}

	public void setWlog006(Date wlog006) {
		this.wlog006 = wlog006;
	}

	public String getWlog007() {
		return wlog007;
	}

	public void setWlog007(String wlog007) {
		this.wlog007 = wlog007;
	}

	public Long getWlog008() {
		return wlog008;
	}

	public void setWlog008(Long wlog008) {
		this.wlog008 = wlog008;
	}

	public String getWlog009() {
		return wlog009;
	}

	public void setWlog009(String wlog009) {
		this.wlog009 = wlog009;
	}

	public String getWlog010() {
		return wlog010;
	}

	public void setWlog010(String wlog010) {
		this.wlog010 = wlog010;
	}

	@Override
	protected Serializable pkVal() {
		return this.wlog001;
	}

}

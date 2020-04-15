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
 * @author Administrator
 * @since 2019-07-20
 */
@TableName("HRSW_T_RESOURCES")
public class HrswTResources extends Model<HrswTResources> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("RESO001")
	private String reso001;
    /**
     * 模块名称
     */
	@TableField("RESO002")
	private String reso002;
    /**
     * 模块编码
     */
	@TableField("RESO003")
	private String reso003;
    /**
     * 模块url
     */
	@TableField("RESO004")
	private String reso004;
    /**
     * 层级
     */
	@TableField("RESO005")
	private Long reso005;
    /**
     * 类型  1 菜单  2 CRUD
     */
	@TableField("RESO006")
	private Long reso006;
    /**
     * 状态 1 启用、2 禁用
     */
	@TableField("RESO007")
	private Long reso007;
    /**
     * 排序号
     */
	@TableField("RESO008")
	private Long reso008;
    /**
     * 父模块id
     */
	@TableField("RESO009")
	private String reso009;
    /**
     * 父模块编码
     */
	@TableField("RESO010")
	private String reso010;
    /**
     * 备注
     */
	@TableField("RESO011")
	private String reso011;
	@TableField("RESO012")
	private String reso012;
    /**
     * 图标
     */
	@TableField("RESO013")
	private String reso013;
	


	@TableField(exist=false)
	private int serialNumber;

	public String getReso001() {
		return reso001;
	}

	public void setReso001(String reso001) {
		this.reso001 = reso001;
	}

	public String getReso002() {
		return reso002;
	}

	public void setReso002(String reso002) {
		this.reso002 = reso002;
	}

	public String getReso003() {
		return reso003;
	}

	public void setReso003(String reso003) {
		this.reso003 = reso003;
	}

	public String getReso004() {
		return reso004;
	}

	public void setReso004(String reso004) {
		this.reso004 = reso004;
	}

	public Long getReso005() {
		return reso005;
	}

	public void setReso005(Long reso005) {
		this.reso005 = reso005;
	}

	public Long getReso006() {
		return reso006;
	}

	public void setReso006(Long reso006) {
		this.reso006 = reso006;
	}

	public Long getReso007() {
		return reso007;
	}

	public void setReso007(Long reso007) {
		this.reso007 = reso007;
	}

	public Long getReso008() {
		return reso008;
	}

	public void setReso008(Long reso008) {
		this.reso008 = reso008;
	}

	public String getReso009() {
		return reso009;
	}

	public void setReso009(String reso009) {
		this.reso009 = reso009;
	}

	public String getReso010() {
		return reso010;
	}

	public void setReso010(String reso010) {
		this.reso010 = reso010;
	}

	public String getReso011() {
		return reso011;
	}

	public void setReso011(String reso011) {
		this.reso011 = reso011;
	}

	public String getReso012() {
		return reso012;
	}

	public void setReso012(String reso012) {
		this.reso012 = reso012;
	}

	public String getReso013() {
		return reso013;
	}

	public void setReso013(String reso013) {
		this.reso013 = reso013;
	}

	
	@Override
	protected Serializable pkVal() {
		return this.reso001;
	}
	
	

	public int getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}

	@Override
	public String toString() {
		return "HrswTResources{" +
			"reso001=" + reso001 +
			", reso002=" + reso002 +
			", reso003=" + reso003 +
			", reso004=" + reso004 +
			", reso005=" + reso005 +
			", reso006=" + reso006 +
			", reso007=" + reso007 +
			", reso008=" + reso008 +
			", reso009=" + reso009 +
			", reso010=" + reso010 +
			", reso011=" + reso011 +
			", reso012=" + reso012 +
			", reso013=" + reso013 +			
			"}";
	}

}

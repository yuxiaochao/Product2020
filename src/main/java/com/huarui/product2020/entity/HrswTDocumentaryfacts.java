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
@TableName("HRSW_T_DOCUMENTARYFACTS")
public class HrswTDocumentaryfacts extends Model<HrswTDocumentaryfacts> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId("DOFA001")
	private String dofa001;
    /**
     * 纪实任务id
     */
	@TableField("DOFA002")
	private String dofa002;
    /**
     * 纪实内容
     */
	@TableField("DOFA003")
	private String dofa003;
    /**
     * 纪实来源 1.系统生成 2.手写
     */
	@TableField("DOFA004")
	private Integer dofa004;
    /**
     * 类型：1.履职纪实 2.实际纪实 3.问题纪实
     */
	@TableField("DOFA005")
	private Integer dofa005;
    /**
     * 编写人id
     */
	@TableField("DOFA006")
	private String dofa006;
    /**
     * 最后修改时间
     */
	@TableField("DOFA007")
	private Date dofa007;
    /**
     * 修改次数
     */
	@TableField("DOFA008")
	private Integer dofa008;
	
	@TableField("DOFA009")
	private String dofa009;
	
	@TableField("DOFA010")
	private Integer dofa010;
	
	public Integer getDofa010() {
		return dofa010;
	}

	public void setDofa010(Integer dofa010) {
		this.dofa010 = dofa010;
	}

	@TableField("DOFA011")
	private String dofa011;
	
	@TableField("DOFA012")
	private String dofa012;

	public String getDofa011() {
		return dofa011;
	}

	public void setDofa011(String dofa011) {
		this.dofa011 = dofa011;
	}

	public String getDofa012() {
		return dofa012;
	}

	public void setDofa012(String dofa012) {
		this.dofa012 = dofa012;
	}

	public String getDofa009() {
		return dofa009;
	}

	public void setDofa009(String dofa009) {
		this.dofa009 = dofa009;
	}

	public String getDofa001() {
		return dofa001;
	}

	public void setDofa001(String dofa001) {
		this.dofa001 = dofa001;
	}

	public String getDofa002() {
		return dofa002;
	}

	public void setDofa002(String dofa002) {
		this.dofa002 = dofa002;
	}

	public String getDofa003() {
		return dofa003;
	}

	public void setDofa003(String dofa003) {
		this.dofa003 = dofa003;
	}

	public Integer getDofa004() {
		return dofa004;
	}

	public void setDofa004(Integer dofa004) {
		this.dofa004 = dofa004;
	}

	public Integer getDofa005() {
		return dofa005;
	}

	public void setDofa005(Integer dofa005) {
		this.dofa005 = dofa005;
	}

	public String getDofa006() {
		return dofa006;
	}

	public void setDofa006(String dofa006) {
		this.dofa006 = dofa006;
	}

	public Date getDofa007() {
		return dofa007;
	}

	public void setDofa007(Date dofa007) {
		this.dofa007 = dofa007;
	}

	public Integer getDofa008() {
		return dofa008;
	}

	public void setDofa008(Integer dofa008) {
		this.dofa008 = dofa008;
	}

	@Override
	protected Serializable pkVal() {
		return this.dofa001;
	}

	@Override
	public String toString() {
		return "HrswTDocumentaryfacts{" +
			"dofa001=" + dofa001 +
			", dofa002=" + dofa002 +
			", dofa003=" + dofa003 +
			", dofa004=" + dofa004 +
			", dofa005=" + dofa005 +
			", dofa006=" + dofa006 +
			", dofa007=" + dofa007 +
			", dofa008=" + dofa008 +
			"}";
	}
}

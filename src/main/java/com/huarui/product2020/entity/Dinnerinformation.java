package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 就餐信息
 * </p>
 *
 * @author caifenglin
 * @since 2020-01-06
 */
@TableName("HR_T_DINNERINFORMATION")
public class Dinnerinformation extends Model<Dinnerinformation> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("DINN001")
	private String dinn001;
    
    /**
     * 餐厅id
     */
	@TableField("DINN002")
	private String dinn002;
	
    /**
     * 就餐类型（’jiucanziyuan_jiucanleixing’,早餐、中餐、晚餐）
     */
	@TableField("DINN003")
	private String dinn003;
	
	/**
	 * 就餐类型数据字典名称
	 */
	@TableField(exist = false)
	private String dinn003n;
	
    /**
     * 就餐开始时间
     */
	@TableField("DINN004")
	private String dinn004;
	
    /**
     * 就餐结束时间
     */
	@TableField("DINN005")
	private String dinn005;
	
    /**
     * 就餐特色
     */
	@TableField("DINN006")
	private String dinn006;
    /**
     * 说明
     */
	@TableField("DINN007")
	private String dinn007;
	
    /**
     * 操作人
     */
	@TableField("DINN008")
	private String dinn008;
	
    /**
     * 创建时间
     */
	@TableField("DINN009")
	private Date dinn009;
	
    /**
     * 最后修改时间
     */
	@TableField("DINN010")
	private Date dinn010;
	
	@TableField(exist = false)
	private String cant003;
	
	@TableField(exist = false)
    private Integer cant004;


	public String getDinn001() {
		return dinn001;
	}

	public void setDinn001(String dinn001) {
		this.dinn001 = dinn001;
	}

	public String getDinn002() {
		return dinn002;
	}

	public void setDinn002(String dinn002) {
		this.dinn002 = dinn002;
	}

	public String getDinn003() {
		return dinn003;
	}

	public void setDinn003(String dinn003) {
		this.dinn003 = dinn003;
	}

	public String getDinn004() {
		return dinn004;
	}

	public void setDinn004(String dinn004) {
		this.dinn004 = dinn004;
	}

	public String getDinn005() {
		return dinn005;
	}

	public void setDinn005(String dinn005) {
		this.dinn005 = dinn005;
	}

	public String getDinn006() {
		return dinn006;
	}

	public void setDinn006(String dinn006) {
		this.dinn006 = dinn006;
	}

	public String getDinn007() {
		return dinn007;
	}

	public void setDinn007(String dinn007) {
		this.dinn007 = dinn007;
	}

	public String getDinn008() {
		return dinn008;
	}

	public void setDinn008(String dinn008) {
		this.dinn008 = dinn008;
	}

	public Date getDinn009() {
		return dinn009;
	}

	public void setDinn009(Date dinn009) {
		this.dinn009 = dinn009;
	}

	public Date getDinn010() {
		return dinn010;
	}

	public void setDinn010(Date dinn010) {
		this.dinn010 = dinn010;
	}
	
	
	public String getCant003() {
        return cant003;
    }

    public void setCant003(String cant003) {
        this.cant003 = cant003;
    }

    public Integer getCant004() {
        return cant004;
    }

    public void setCant004(Integer cant004) {
        this.cant004 = cant004;
    }
    

    public String getDinn003n() {
        return dinn003n;
    }

    public void setDinn003n(String dinn003n) {
        this.dinn003n = dinn003n;
    }

    @Override
	protected Serializable pkVal() {
		return this.dinn001;
	}

	@Override
	public String toString() {
		return "Dinnerinformation{" +
			"dinn001=" + dinn001 +
			", dinn002=" + dinn002 +
			", dinn003=" + dinn003 +
			", dinn004=" + dinn004 +
			", dinn005=" + dinn005 +
			", dinn006=" + dinn006 +
			", dinn007=" + dinn007 +
			", dinn008=" + dinn008 +
			", dinn009=" + dinn009 +
			", dinn010=" + dinn010 +
			"}";
	}
}

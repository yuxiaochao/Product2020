package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 问卷表
 * </p>
 *
 * @author pl
 * @since 2019-12-21
 */
public class Dcwj02 extends Model<Dcwj02> {

    private static final long serialVersionUID = 1L;

    /**
     * 	pk
     */
    @TableId("DCWJ0201")
	private String dcwj0201;
    /**
     * 问卷分类ID （DCWJ01）FK
     */
	@TableField("DCWJ0202")
	private String dcwj0202;
    /**
     * 	问卷名称 （DCWJ0202+ DCWJ0203（UQ））
     */
	@TableField("DCWJ0203")
	private String dcwj0203;
    /**
     * 	启用共享 0：未启用；1：启用
     */
	@TableField("DCWJ0204")
	private Double dcwj0204;
    /**
     * 共享机制 -1：未共享；0：按单位；1：按人
     */
	@TableField("DCWJ0205")
	private Double dcwj0205;
    /**
     * 	说明
     */
	@TableField("DCWJ0206")
	private String dcwj0206;
    /**
     * 创建时间
     */
	@TableField("DCWJ0207")
	private Date dcwj0207;
    /**
     * 最后修改时间
     */
	@TableField("DCWJ0208")
	private Date dcwj0208;
    /**
     * 创建人
     */
	@TableField("DCWJ0209")
	private String dcwj0209;
	
	  /**
     * 状态 0：草稿；1：待发布；2：已发布
     */
	@TableField("DCWJ0210")
	private int dcwj0210;

	/**
	 * 
	 * 主办单位
	 */
	@TableField(exist=false)
	private String orga005;
	
	/**
	 * 
	 * 责任人user005
	 */
	@TableField(exist=false)
	private String user005;
	
	/**
	 * 引用次数
	 */
	@TableField(exist=false)
	private int quoteNum;
	
	/**
	 * 序号
	 */
	@TableField(exist=false)
	private int serialNumber;
	
	public String getDcwj0201() {
		return dcwj0201;
	}
	
	public void setDcwj0201(String dcwj0201) {
		this.dcwj0201 = dcwj0201;
	}

	public String getDcwj0202() {
		return dcwj0202;
	}

	public void setDcwj0202(String dcwj0202) {
		this.dcwj0202 = dcwj0202;
	}

	public String getDcwj0203() {
		return dcwj0203;
	}

	public void setDcwj0203(String dcwj0203) {
		this.dcwj0203 = dcwj0203;
	}

	public Double getDcwj0204() {
		return dcwj0204;
	}

	public void setDcwj0204(Double dcwj0204) {
		this.dcwj0204 = dcwj0204;
	}

	public Double getDcwj0205() {
		return dcwj0205;
	}

	public void setDcwj0205(Double dcwj0205) {
		this.dcwj0205 = dcwj0205;
	}

	public String getDcwj0206() {
		return dcwj0206;
	}

	public void setDcwj0206(String dcwj0206) {
		this.dcwj0206 = dcwj0206;
	}

	

	public Date getDcwj0207() {
		return dcwj0207;
	}

	public void setDcwj0207(Date dcwj0207) {
		this.dcwj0207 = dcwj0207;
	}

	public Date getDcwj0208() {
		return dcwj0208;
	}

	public void setDcwj0208(Date dcwj0208) {
		this.dcwj0208 = dcwj0208;
	}

	public String getDcwj0209() {
		return dcwj0209;
	}

	public void setDcwj0209(String dcwj0209) {
		this.dcwj0209 = dcwj0209;
	}

	public int getDcwj0210() {
		return dcwj0210;
	}

	public void setDcwj0210(int dcwj0210) {
		this.dcwj0210 = dcwj0210;
	}

	@Override
	protected Serializable pkVal() {
		return this.dcwj0201;
	}

	
	
	public String getOrga005() {
		return orga005;
	}

	public void setOrga005(String orga005) {
		this.orga005 = orga005;
	}

	public String getUser005() {
		return user005;
	}

	public void setUser005(String user005) {
		this.user005 = user005;
	}

	
	public int getQuoteNum() {
		return quoteNum;
	}

	public void setQuoteNum(int quoteNum) {
		this.quoteNum = quoteNum;
	}
	

	public int getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}

	@Override
	public String toString() {
		return "Dcwj02{" +
			"dcwj0201=" + dcwj0201 +
			", dcwj0202=" + dcwj0202 +
			", dcwj0203=" + dcwj0203 +
			", dcwj0204=" + dcwj0204 +
			", dcwj0205=" + dcwj0205 +
			", dcwj0206=" + dcwj0206 +
			", dcwj0207=" + dcwj0207 +
			", dcwj0208=" + dcwj0208 +
			", dcwj0209=" + dcwj0209 +
			"}";
	}
}

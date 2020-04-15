package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author yuxiaochao
 * @since 2019-10-25
 */
public class Tbpxb01 extends Model<Tbpxb01> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("PXB0101")
	private String pxb0101;
    /**
     * 培训班名称
     */
	@TableField("PXB0102")
	private String pxb0102;
    /**
     * 培训方式0：线上；1：面授；2：混和
     */
	@TableField("PXB0103")
	private Double pxb0103;
    /**
     * 期数
     */
	@TableField("PXB0104")
	private String pxb0104;
    /**
     * 开始时间
     */
	@TableField("PXB0105")
	private Date pxb0105;
    /**
     * 结束时间
     */
	@TableField("PXB0106")
	private Date pxb0106;
    /**
     * 培训类型  与数据字典关联
     */
	@TableField("PXB0107")
	private String pxb0107;
    /**
     * 鉴定类别0：否；1：是
     */
	@TableField("PXB0108")
	private Double pxb0108;
    /**
     * 主办单位
     */
	@TableField("PXB0109")
	private String pxb0109;
	
	/**
	 * 主办单位名称
	 */
	@TableField(exist = false)
	private String pxb0109n;
	
    /**
     * 委托单位
     */
	@TableField("PXB0110")
	private String pxb0110;
	
	/**
	 * 委托单位名称
	 */
	@TableField(exist = false)
	private String pxb0110n;
	
    /**
     * 委托人
     */
	@TableField("PXB0111")
	private String pxb0111;
    /**
     * 培训要点
     */
	@TableField("PXB0112")
	private String pxb0112;
    /**
     * 培训地点
     */
	@TableField("PXB0113")
	private String pxb0113;
    /**
     * 启用联络员报名0：否；1：是
     */
	@TableField("PXB0114")
	private Double pxb0114;
    /**
     * 报名须知CLOB
     */
	@TableField("PXB0115")
	private String pxb0115;
    /**
     * 报名开始时间
     */
	@TableField("PXB0116")
	private Date pxb0116;
    /**
     * 报名结束时间
     */
	@TableField("PXB0117")
	private Date pxb0117;
    /**
     * 培训班类型0：选修；1：必修； 
     */
	@TableField("PXB0118")
	private Double pxb0118;
    /**
     * 说明
     */
	@TableField("PXB0119")
	private String pxb0119;
    /**
     * 操作人
     */
	@TableField("PXB0120")
	private String pxb0120;
    /**
     * 创建时间
     */
	@TableField("PXB0121")
	private Date pxb0121;
    /**
     * 最后修改时间
     */
	@TableField("PXB0122")
	private Date pxb0122;
	
	/**
	 * 状态
	 */
	@TableField("PXB0123")
    private Integer pxb0123;


	public String getPxb0101() {
		return pxb0101;
	}

	public void setPxb0101(String pxb0101) {
		this.pxb0101 = pxb0101;
	}

	public String getPxb0102() {
		return pxb0102;
	}

	public void setPxb0102(String pxb0102) {
		this.pxb0102 = pxb0102;
	}

	public Double getPxb0103() {
		return pxb0103;
	}

	public void setPxb0103(Double pxb0103) {
		this.pxb0103 = pxb0103;
	}

	public String getPxb0104() {
		return pxb0104;
	}

	public void setPxb0104(String pxb0104) {
		this.pxb0104 = pxb0104;
	}

	public Date getPxb0105() {
		return pxb0105;
	}

	public void setPxb0105(Date pxb0105) {
		this.pxb0105 = pxb0105;
	}

	public Date getPxb0106() {
		return pxb0106;
	}

	public void setPxb0106(Date pxb0106) {
		this.pxb0106 = pxb0106;
	}

	public String getPxb0107() {
		return pxb0107;
	}

	public void setPxb0107(String pxb0107) {
		this.pxb0107 = pxb0107;
	}

	public Double getPxb0108() {
		return pxb0108;
	}

	public void setPxb0108(Double pxb0108) {
		this.pxb0108 = pxb0108;
	}

	public String getPxb0109() {
		return pxb0109;
	}

	public void setPxb0109(String pxb0109) {
		this.pxb0109 = pxb0109;
	}

	public String getPxb0110() {
		return pxb0110;
	}

	public void setPxb0110(String pxb0110) {
		this.pxb0110 = pxb0110;
	}

	public String getPxb0111() {
		return pxb0111;
	}

	public void setPxb0111(String pxb0111) {
		this.pxb0111 = pxb0111;
	}

	public String getPxb0112() {
		return pxb0112;
	}

	public void setPxb0112(String pxb0112) {
		this.pxb0112 = pxb0112;
	}

	public String getPxb0113() {
		return pxb0113;
	}

	public void setPxb0113(String pxb0113) {
		this.pxb0113 = pxb0113;
	}

	public Double getPxb0114() {
		return pxb0114;
	}

	public void setPxb0114(Double pxb0114) {
		this.pxb0114 = pxb0114;
	}

	public String getPxb0115() {
		return pxb0115;
	}

	public void setPxb0115(String pxb0115) {
		this.pxb0115 = pxb0115;
	}

	public Date getPxb0116() {
		return pxb0116;
	}

	public void setPxb0116(Date pxb0116) {
		this.pxb0116 = pxb0116;
	}

	public Date getPxb0117() {
		return pxb0117;
	}

	public void setPxb0117(Date pxb0117) {
		this.pxb0117 = pxb0117;
	}

	public Double getPxb0118() {
		return pxb0118;
	}

	public void setPxb0118(Double pxb0118) {
		this.pxb0118 = pxb0118;
	}

	public String getPxb0119() {
		return pxb0119;
	}

	public void setPxb0119(String pxb0119) {
		this.pxb0119 = pxb0119;
	}

	public String getPxb0120() {
		return pxb0120;
	}

	public void setPxb0120(String pxb0120) {
		this.pxb0120 = pxb0120;
	}

	public Date getPxb0121() {
		return pxb0121;
	}

	public void setPxb0121(Date pxb0121) {
		this.pxb0121 = pxb0121;
	}

	public Date getPxb0122() {
		return pxb0122;
	}

	public void setPxb0122(Date pxb0122) {
		this.pxb0122 = pxb0122;
	}

	public String getPxb0109n() {
        return pxb0109n;
    }

    public void setPxb0109n(String pxb0109n) {
        this.pxb0109n = pxb0109n;
    }

    public String getPxb0110n() {
        return pxb0110n;
    }

    public void setPxb0110n(String pxb0110n) {
        this.pxb0110n = pxb0110n;
    }
    
	
	public Integer getPxb0123() {
        return pxb0123;
    }

    public void setPxb0123(Integer pxb0123) {
        this.pxb0123 = pxb0123;
    }

    @Override
	protected Serializable pkVal() {
		return this.pxb0101;
	}
	
    @Override
	public String toString() {
		return "Tbpxb01{" +
			"pxb0101=" + pxb0101 +
			", pxb0102=" + pxb0102 +
			", pxb0103=" + pxb0103 +
			", pxb0104=" + pxb0104 +
			", pxb0105=" + pxb0105 +
			", pxb0106=" + pxb0106 +
			", pxb0107=" + pxb0107 +
			", pxb0108=" + pxb0108 +
			", pxb0109=" + pxb0109 +
			", pxb0110=" + pxb0110 +
			", pxb0111=" + pxb0111 +
			", pxb0112=" + pxb0112 +
			", pxb0113=" + pxb0113 +
			", pxb0114=" + pxb0114 +
			", pxb0115=" + pxb0115 +
			", pxb0116=" + pxb0116 +
			", pxb0117=" + pxb0117 +
			", pxb0118=" + pxb0118 +
			", pxb0119=" + pxb0119 +
			", pxb0120=" + pxb0120 +
			", pxb0121=" + pxb0121 +
			", pxb0122=" + pxb0122 +
			"}";
	}
}

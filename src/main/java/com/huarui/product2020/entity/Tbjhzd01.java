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
public class Tbjhzd01 extends Model<Tbjhzd01> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("JHZD0101")
	private String jhzd0101;
    /**
     * 计划类别0：月度计划；1：季计划；2：年计划
     */
	@TableField("JHZD0102")
	private Double jhzd0102;
    /**
     * 计划名称
     */
	@TableField("JHZD0103")
	private String jhzd0103;
    /**
     * 类型0：正式计划；1：临增计划
     */
	@TableField("JHZD0104")
	private Double jhzd0104;
    /**
     * 开始时间
     */
	@TableField("JHZD0105")
	private Date jhzd0105;
    /**
     * 结束时间
     */
	@TableField("JHZD0106")
	private Date jhzd0106;
    /**
     * 培训对像
     */
	@TableField("JHZD0107")
	private String jhzd0107;
    /**
     * 委托单位
     */
	@TableField("JHZD0108")
	private String jhzd0108;
    /**
     * 主办单位
     */
	@TableField("JHZD0109")
	private String jhzd0109;
    /**
     * 承办单位0：本级单位；1：下级单位
     */
	@TableField("JHZD0110")
	private Double jhzd0110;
    /**
     * 操作人
     */
	@TableField("JHZD0111")
	private String jhzd0111;
    /**
     * 创建时间
     */
	@TableField("JHZD0112")
	private Date jhzd0112;
    /**
     * 最后修改时间
     */
	@TableField("JHZD0113")
	private Date jhzd0113;
    /**
     * 状态
     */
	@TableField("JHZD0114")
	private Double jhzd0114;


	public String getJhzd0101() {
		return jhzd0101;
	}

	public void setJhzd0101(String jhzd0101) {
		this.jhzd0101 = jhzd0101;
	}

	public Double getJhzd0102() {
		return jhzd0102;
	}

	public void setJhzd0102(Double jhzd0102) {
		this.jhzd0102 = jhzd0102;
	}

	public String getJhzd0103() {
		return jhzd0103;
	}

	public void setJhzd0103(String jhzd0103) {
		this.jhzd0103 = jhzd0103;
	}

	public Double getJhzd0104() {
		return jhzd0104;
	}

	public void setJhzd0104(Double jhzd0104) {
		this.jhzd0104 = jhzd0104;
	}

	public Date getJhzd0105() {
		return jhzd0105;
	}

	public void setJhzd0105(Date jhzd0105) {
		this.jhzd0105 = jhzd0105;
	}

	public Date getJhzd0106() {
		return jhzd0106;
	}

	public void setJhzd0106(Date jhzd0106) {
		this.jhzd0106 = jhzd0106;
	}

	public String getJhzd0107() {
		return jhzd0107;
	}

	public void setJhzd0107(String jhzd0107) {
		this.jhzd0107 = jhzd0107;
	}

	public String getJhzd0108() {
		return jhzd0108;
	}

	public void setJhzd0108(String jhzd0108) {
		this.jhzd0108 = jhzd0108;
	}

	public String getJhzd0109() {
		return jhzd0109;
	}

	public void setJhzd0109(String jhzd0109) {
		this.jhzd0109 = jhzd0109;
	}

	public Double getJhzd0110() {
		return jhzd0110;
	}

	public void setJhzd0110(Double jhzd0110) {
		this.jhzd0110 = jhzd0110;
	}

	public String getJhzd0111() {
		return jhzd0111;
	}

	public void setJhzd0111(String jhzd0111) {
		this.jhzd0111 = jhzd0111;
	}

	public Date getJhzd0112() {
		return jhzd0112;
	}

	public void setJhzd0112(Date jhzd0112) {
		this.jhzd0112 = jhzd0112;
	}

	public Date getJhzd0113() {
		return jhzd0113;
	}

	public void setJhzd0113(Date jhzd0113) {
		this.jhzd0113 = jhzd0113;
	}

	public Double getJhzd0114() {
		return jhzd0114;
	}

	public void setJhzd0114(Double jhzd0114) {
		this.jhzd0114 = jhzd0114;
	}

	@Override
	protected Serializable pkVal() {
		return this.jhzd0101;
	}

	@Override
	public String toString() {
		return "Tbjhzd01{" +
			"jhzd0101=" + jhzd0101 +
			", jhzd0102=" + jhzd0102 +
			", jhzd0103=" + jhzd0103 +
			", jhzd0104=" + jhzd0104 +
			", jhzd0105=" + jhzd0105 +
			", jhzd0106=" + jhzd0106 +
			", jhzd0107=" + jhzd0107 +
			", jhzd0108=" + jhzd0108 +
			", jhzd0109=" + jhzd0109 +
			", jhzd0110=" + jhzd0110 +
			", jhzd0111=" + jhzd0111 +
			", jhzd0112=" + jhzd0112 +
			", jhzd0113=" + jhzd0113 +
			", jhzd0114=" + jhzd0114 +
			"}";
	}
}

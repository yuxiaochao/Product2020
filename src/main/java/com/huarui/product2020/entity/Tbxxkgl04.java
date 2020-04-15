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
 * @author su
 * @since 2020-03-27
 */
public class Tbxxkgl04 extends Model<Tbxxkgl04> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("XXKGL0401")
	private String xxkgl0401;
    /**
     * 标题
     */
	@TableField("XXKGL0402")
	private String xxkgl0402;
    /**
     * 发布对象：0:出版社 1:代理机构 2:天猫
     */
	@TableField("XXKGL0403")
	private Double xxkgl0403;
    /**
     * 状态：0:待分发 1:已分发
     */
	@TableField("XXKGL0404")
	private Double xxkgl0404;
    /**
     * 创建时间
     */
	@TableField("XXKGL0405")
	private Date xxkgl0405;
    /**
     * 最后修改时间
     */
	@TableField("XXKGL0406")
	private Date xxkgl0406;
    /**
     * 创建人
     */
	@TableField("XXKGL0407")
	private String xxkgl0407;


	public String getXxkgl0401() {
		return xxkgl0401;
	}

	public void setXxkgl0401(String xxkgl0401) {
		this.xxkgl0401 = xxkgl0401;
	}

	public String getXxkgl0402() {
		return xxkgl0402;
	}

	public void setXxkgl0402(String xxkgl0402) {
		this.xxkgl0402 = xxkgl0402;
	}

	public Double getXxkgl0403() {
		return xxkgl0403;
	}

	public void setXxkgl0403(Double xxkgl0403) {
		this.xxkgl0403 = xxkgl0403;
	}

	public Double getXxkgl0404() {
		return xxkgl0404;
	}

	public void setXxkgl0404(Double xxkgl0404) {
		this.xxkgl0404 = xxkgl0404;
	}

	public Date getXxkgl0405() {
		return xxkgl0405;
	}

	public void setXxkgl0405(Date xxkgl0405) {
		this.xxkgl0405 = xxkgl0405;
	}

	public Date getXxkgl0406() {
		return xxkgl0406;
	}

	public void setXxkgl0406(Date xxkgl0406) {
		this.xxkgl0406 = xxkgl0406;
	}

	public String getXxkgl0407() {
		return xxkgl0407;
	}

	public void setXxkgl0407(String xxkgl0407) {
		this.xxkgl0407 = xxkgl0407;
	}

	@Override
	protected Serializable pkVal() {
		return this.xxkgl0401;
	}

	@Override
	public String toString() {
		return "Tbxxkgl04{" +
			"xxkgl0401=" + xxkgl0401 +
			", xxkgl0402=" + xxkgl0402 +
			", xxkgl0403=" + xxkgl0403 +
			", xxkgl0404=" + xxkgl0404 +
			", xxkgl0405=" + xxkgl0405 +
			", xxkgl0406=" + xxkgl0406 +
			", xxkgl0407=" + xxkgl0407 +
			"}";
	}
}

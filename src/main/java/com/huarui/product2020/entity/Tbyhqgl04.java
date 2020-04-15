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
 * @author panlei
 * @since 2020-04-07
 */
public class Tbyhqgl04 extends Model<Tbyhqgl04> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("YHQGL0401")
	private String yhqgl0401;
    /**
     * 标题
     */
	@TableField("YHQGL0402")
	private String yhqgl0402;
    /**
     * 发布对象：0:出版社 1:代理机构 2:天猫
     */
	@TableField("YHQGL0403")
	private Double yhqgl0403;
    /**
     * 状态：0:待分发 1:已分发
     */
	@TableField("YHQGL0404")
	private Double yhqgl0404;
    /**
     * 创建时间
     */
	@TableField("YHQGL0405")
	private Date yhqgl0405;
    /**
     * 最后修改时间
     */
	@TableField("YHQGL0406")
	private Date yhqgl0406;
    /**
     * 创建人
     */
	@TableField("YHQGL0407")
	private String yhqgl0407;


	public String getYhqgl0401() {
		return yhqgl0401;
	}

	public void setYhqgl0401(String yhqgl0401) {
		this.yhqgl0401 = yhqgl0401;
	}

	public String getYhqgl0402() {
		return yhqgl0402;
	}

	public void setYhqgl0402(String yhqgl0402) {
		this.yhqgl0402 = yhqgl0402;
	}

	public Double getYhqgl0403() {
		return yhqgl0403;
	}

	public void setYhqgl0403(Double yhqgl0403) {
		this.yhqgl0403 = yhqgl0403;
	}

	public Double getYhqgl0404() {
		return yhqgl0404;
	}

	public void setYhqgl0404(Double yhqgl0404) {
		this.yhqgl0404 = yhqgl0404;
	}

	public Date getYhqgl0405() {
		return yhqgl0405;
	}

	public void setYhqgl0405(Date yhqgl0405) {
		this.yhqgl0405 = yhqgl0405;
	}

	public Date getYhqgl0406() {
		return yhqgl0406;
	}

	public void setYhqgl0406(Date yhqgl0406) {
		this.yhqgl0406 = yhqgl0406;
	}

	public String getYhqgl0407() {
		return yhqgl0407;
	}

	public void setYhqgl0407(String yhqgl0407) {
		this.yhqgl0407 = yhqgl0407;
	}

	@Override
	protected Serializable pkVal() {
		return this.yhqgl0401;
	}

	@Override
	public String toString() {
		return "Tbyhqgl04{" +
			"yhqgl0401=" + yhqgl0401 +
			", yhqgl0402=" + yhqgl0402 +
			", yhqgl0403=" + yhqgl0403 +
			", yhqgl0404=" + yhqgl0404 +
			", yhqgl0405=" + yhqgl0405 +
			", yhqgl0406=" + yhqgl0406 +
			", yhqgl0407=" + yhqgl0407 +
			"}";
	}
}

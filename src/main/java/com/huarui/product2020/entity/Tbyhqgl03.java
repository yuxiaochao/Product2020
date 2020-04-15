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
public class Tbyhqgl03 extends Model<Tbyhqgl03> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("YHQGL0301")
	private String yhqgl0301;
    /**
     * 优惠券ID
     */
	@TableField("YHQGL0302")
	private String yhqgl0302;
    /**
     * 卡号
     */
	@TableField("YHQGL0303")
	private String yhqgl0303;
    /**
     * 密码
     */
	@TableField("YHQGL0304")
	private String yhqgl0304;
    /**
     * 生成时间
     */
	@TableField("YHQGL0305")
	private Date yhqgl0305;

	//激活状态
	private Integer yhqgl0704n;
	
	
	
	
	
	public String getYhqgl0301() {
		return yhqgl0301;
	}

	public void setYhqgl0301(String yhqgl0301) {
		this.yhqgl0301 = yhqgl0301;
	}

	public String getYhqgl0302() {
		return yhqgl0302;
	}

	public void setYhqgl0302(String yhqgl0302) {
		this.yhqgl0302 = yhqgl0302;
	}

	public String getYhqgl0303() {
		return yhqgl0303;
	}

	public void setYhqgl0303(String yhqgl0303) {
		this.yhqgl0303 = yhqgl0303;
	}

	public String getYhqgl0304() {
		return yhqgl0304;
	}

	public void setYhqgl0304(String yhqgl0304) {
		this.yhqgl0304 = yhqgl0304;
	}

	public Date getYhqgl0305() {
		return yhqgl0305;
	}

	public void setYhqgl0305(Date yhqgl0305) {
		this.yhqgl0305 = yhqgl0305;
	}

	public Integer getYhqgl0704n() {
		return yhqgl0704n;
	}

	public void setYhqgl0704n(Integer yhqgl0704n) {
		this.yhqgl0704n = yhqgl0704n;
	}

	@Override
	protected Serializable pkVal() {
		return this.yhqgl0301;
	}

	@Override
	public String toString() {
		return "Tbyhqgl03{" +
			"yhqgl0301=" + yhqgl0301 +
			", yhqgl0302=" + yhqgl0302 +
			", yhqgl0303=" + yhqgl0303 +
			", yhqgl0304=" + yhqgl0304 +
			", yhqgl0305=" + yhqgl0305 +
			"}";
	}
}

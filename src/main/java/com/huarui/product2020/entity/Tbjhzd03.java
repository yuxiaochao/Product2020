package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yuxiaochao
 * @since 2019-10-25
 */
public class Tbjhzd03 extends Model<Tbjhzd03> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("JHZD0301")
	private String jhzd0301;
    /**
     * 计划制定主键
     */
	@TableField("JHZD0302")
	private String jhzd0302;
    /**
     * 课程ID
     */
	@TableField("JHZD0303")
	private String jhzd0303;
    /**
     * 授课方式0：面授；1：线上课程；2：直播课程
     */
	@TableField("JHZD0304")
	private Double jhzd0304;
    /**
     * 课程类型0：必修；1：选修；
     */
	@TableField("JHZD0305")
	private Double jhzd0305;
	
	private String cour010;
	
	public String getCour010() {
		return cour010;
	}

	public void setCour010(String cour010) {
		this.cour010 = cour010;
	}

	public String getJhzd0301() {
		return jhzd0301;
	}

	public void setJhzd0301(String jhzd0301) {
		this.jhzd0301 = jhzd0301;
	}

	public String getJhzd0302() {
		return jhzd0302;
	}

	public void setJhzd0302(String jhzd0302) {
		this.jhzd0302 = jhzd0302;
	}

	public String getJhzd0303() {
		return jhzd0303;
	}

	public void setJhzd0303(String jhzd0303) {
		this.jhzd0303 = jhzd0303;
	}

	public Double getJhzd0304() {
		return jhzd0304;
	}

	public void setJhzd0304(Double jhzd0304) {
		this.jhzd0304 = jhzd0304;
	}

	public Double getJhzd0305() {
		return jhzd0305;
	}

	public void setJhzd0305(Double jhzd0305) {
		this.jhzd0305 = jhzd0305;
	}

	@Override
	protected Serializable pkVal() {
		return this.jhzd0301;
	}

	@Override
	public String toString() {
		return "Tbjhzd03{" +
			"jhzd0301=" + jhzd0301 +
			", jhzd0302=" + jhzd0302 +
			", jhzd0303=" + jhzd0303 +
			", jhzd0304=" + jhzd0304 +
			", jhzd0305=" + jhzd0305 +
			"}";
	}
}

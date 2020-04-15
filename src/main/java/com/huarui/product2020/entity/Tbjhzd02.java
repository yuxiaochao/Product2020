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
public class Tbjhzd02 extends Model<Tbjhzd02> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("JHZD0201")
	private String jhzd0201;
    /**
     * 计划制定主键
     */
	@TableField("JHZD0202")
	private String jhzd0202;
    /**
     * 单位
     */
	@TableField("JHZD0203")
	private String jhzd0203;
    /**
     * 类别0： 承办单位；1：报名单位
     */
	@TableField("JHZD0204")
	private Double jhzd0204;


	public String getJhzd0201() {
		return jhzd0201;
	}

	public void setJhzd0201(String jhzd0201) {
		this.jhzd0201 = jhzd0201;
	}

	public String getJhzd0202() {
		return jhzd0202;
	}

	public void setJhzd0202(String jhzd0202) {
		this.jhzd0202 = jhzd0202;
	}

	public String getJhzd0203() {
		return jhzd0203;
	}

	public void setJhzd0203(String jhzd0203) {
		this.jhzd0203 = jhzd0203;
	}

	public Double getJhzd0204() {
		return jhzd0204;
	}

	public void setJhzd0204(Double jhzd0204) {
		this.jhzd0204 = jhzd0204;
	}

	@Override
	protected Serializable pkVal() {
		return this.jhzd0201;
	}

	@Override
	public String toString() {
		return "Tbjhzd02{" +
			"jhzd0201=" + jhzd0201 +
			", jhzd0202=" + jhzd0202 +
			", jhzd0203=" + jhzd0203 +
			", jhzd0204=" + jhzd0204 +
			"}";
	}
}

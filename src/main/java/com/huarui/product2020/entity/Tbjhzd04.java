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
public class Tbjhzd04 extends Model<Tbjhzd04> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("JHZD0401")
	private String jhzd0401;
    /**
     * 计划制定主键
     */
	@TableField("JHZD0402")
	private String jhzd0402;
    /**
     * 文件名称
     */
	@TableField("JHZD0403")
	private String jhzd0403;
    /**
     * 上传文件路径
     */
	@TableField("JHZD0404")
	private String jhzd0404;


	public String getJhzd0401() {
		return jhzd0401;
	}

	public void setJhzd0401(String jhzd0401) {
		this.jhzd0401 = jhzd0401;
	}

	public String getJhzd0402() {
		return jhzd0402;
	}

	public void setJhzd0402(String jhzd0402) {
		this.jhzd0402 = jhzd0402;
	}

	public String getJhzd0403() {
		return jhzd0403;
	}

	public void setJhzd0403(String jhzd0403) {
		this.jhzd0403 = jhzd0403;
	}

	public String getJhzd0404() {
		return jhzd0404;
	}

	public void setJhzd0404(String jhzd0404) {
		this.jhzd0404 = jhzd0404;
	}

	@Override
	protected Serializable pkVal() {
		return this.jhzd0401;
	}

	@Override
	public String toString() {
		return "Tbjhzd04{" +
			"jhzd0401=" + jhzd0401 +
			", jhzd0402=" + jhzd0402 +
			", jhzd0403=" + jhzd0403 +
			", jhzd0404=" + jhzd0404 +
			"}";
	}
}

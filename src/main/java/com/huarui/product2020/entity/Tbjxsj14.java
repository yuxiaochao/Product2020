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
 * @author YanZeYang
 * @since 2019-12-17
 */
public class Tbjxsj14 extends Model<Tbjxsj14> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("TBJXSJ1401")
	private String tbjxsj1401;
    /**
     * 是否允许考生自主打印证书:0是1否
     */
	@TableField("TBJXSJ1402")
	private Integer tbjxsj1402;
    /**
     * 证书模板id
     */
	@TableField("TBJXSJ1403")
	private String tbjxsj1403;
    /**
     * 培训班id
     */
	@TableField("TBJXSJ1404")
	private String tbjxsj1404;


	public String getTbjxsj1401() {
		return tbjxsj1401;
	}

	public void setTbjxsj1401(String tbjxsj1401) {
		this.tbjxsj1401 = tbjxsj1401;
	}

	public Integer getTbjxsj1402() {
		return tbjxsj1402;
	}

	public void setTbjxsj1402(Integer tbjxsj1402) {
		this.tbjxsj1402 = tbjxsj1402;
	}

	public String getTbjxsj1403() {
		return tbjxsj1403;
	}

	public void setTbjxsj1403(String tbjxsj1403) {
		this.tbjxsj1403 = tbjxsj1403;
	}

	public String getTbjxsj1404() {
		return tbjxsj1404;
	}

	public void setTbjxsj1404(String tbjxsj1404) {
		this.tbjxsj1404 = tbjxsj1404;
	}

	@Override
	protected Serializable pkVal() {
		return this.tbjxsj1401;
	}

	@Override
	public String toString() {
		return "Tbjxsj14{" +
			"tbjxsj1401=" + tbjxsj1401 +
			", tbjxsj1402=" + tbjxsj1402 +
			", tbjxsj1403=" + tbjxsj1403 +
			", tbjxsj1404=" + tbjxsj1404 +
			"}";
	}
}

package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author YanZeYang
 * @since 2019-12-30
 */
public class Tbjxsj15 extends Model<Tbjxsj15> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@TableField("TBJXSJ1501")
	private String tbjxsj1501;
    /**
     * 案例id
     */
	@TableField("TBJXSJ1502")
	private String tbjxsj1502;
    /**
     * 附件名称
     */
	@TableField("TBJXSJ1503")
	private String tbjxsj1503;
    /**
     * 附件地址
     */
	@TableField("TBJXSJ1504")
	private String tbjxsj1504;


	public String getTbjxsj1501() {
		return tbjxsj1501;
	}

	public void setTbjxsj1501(String tbjxsj1501) {
		this.tbjxsj1501 = tbjxsj1501;
	}

	public String getTbjxsj1502() {
		return tbjxsj1502;
	}

	public void setTbjxsj1502(String tbjxsj1502) {
		this.tbjxsj1502 = tbjxsj1502;
	}

	public String getTbjxsj1503() {
		return tbjxsj1503;
	}

	public void setTbjxsj1503(String tbjxsj1503) {
		this.tbjxsj1503 = tbjxsj1503;
	}

	public String getTbjxsj1504() {
		return tbjxsj1504;
	}

	public void setTbjxsj1504(String tbjxsj1504) {
		this.tbjxsj1504 = tbjxsj1504;
	}

	@Override
	protected Serializable pkVal() {
		return this.tbjxsj1501;
	}

	@Override
	public String toString() {
		return "Tbjxsj15{" +
			"tbjxsj1501=" + tbjxsj1501 +
			", tbjxsj1502=" + tbjxsj1502 +
			", tbjxsj1503=" + tbjxsj1503 +
			", tbjxsj1504=" + tbjxsj1504 +
			"}";
	}
}

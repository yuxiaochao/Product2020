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
 * @since 2019-12-11
 */
public class Tbjxsj13 extends Model<Tbjxsj13> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("TBJXSJ1301")
	private String tbjxsj1301;
    /**
     * 仪式id
     */
	@TableField("TBJXSJ1302")
	private String tbjxsj1302;
    /**
     * 附件名称
     */
	@TableField("TBJXSJ1303")
	private String tbjxsj1303;
    /**
     * 附件路径
     */
	@TableField("TBJXSJ1304")
	private String tbjxsj1304;

	/**
	 * 附件别名
	 */
	@TableField("TBJXSJ1305")
	private String tbjxsj1305;


	public String getTbjxsj1301() {
		return tbjxsj1301;
	}

	public void setTbjxsj1301(String tbjxsj1301) {
		this.tbjxsj1301 = tbjxsj1301;
	}

	public String getTbjxsj1302() {
		return tbjxsj1302;
	}

	public void setTbjxsj1302(String tbjxsj1302) {
		this.tbjxsj1302 = tbjxsj1302;
	}

	public String getTbjxsj1303() {
		return tbjxsj1303;
	}

	public void setTbjxsj1303(String tbjxsj1303) {
		this.tbjxsj1303 = tbjxsj1303;
	}

	public String getTbjxsj1304() {
		return tbjxsj1304;
	}

	public void setTbjxsj1304(String tbjxsj1304) {
		this.tbjxsj1304 = tbjxsj1304;
	}

	@Override
	protected Serializable pkVal() {
		return this.tbjxsj1301;
	}

	public String getTbjxsj1305() {
		return tbjxsj1305;
	}

	public void setTbjxsj1305(String tbjxsj1305) {
		this.tbjxsj1305 = tbjxsj1305;
	}

	@Override
	public String toString() {
		return "Tbjxsj13{" +
			"tbjxsj1301=" + tbjxsj1301 +
			", tbjxsj1302=" + tbjxsj1302 +
			", tbjxsj1303=" + tbjxsj1303 +
			", tbjxsj1304=" + tbjxsj1304 +
			", tbjxsj1305=" + tbjxsj1305 +
			"}";
	}
}

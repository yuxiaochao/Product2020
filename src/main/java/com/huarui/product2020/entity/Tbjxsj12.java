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
 * @author YanZeYang
 * @since 2019-12-10
 */
public class Tbjxsj12 extends Model<Tbjxsj12> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("TBJXSJ1201")
	private String tbjxsj1201;
    /**
     * 标题
     */
	@TableField("TBJXSJ1202")
	private String tbjxsj1202;
    /**
     * 时间
     */
	@TableField("TBJXSJ1203")
	private Date tbjxsj1203;
    /**
     * 地点
     */
	@TableField("TBJXSJ1204")
	private String tbjxsj1204;
    /**
     * 出席领导
     */
	@TableField("TBJXSJ1205")
	private String tbjxsj1205;
    /**
     * 备注
     */
	@TableField("TBJXSJ1206")
	private String tbjxsj1206;
    /**
     * 仪式类型0开班仪式1结业仪式
     */
	@TableField("TBJXSJ1207")
	private Integer tbjxsj1207;
	 /**
     * 培训班id
     */
	@TableField("TBJXSJ1208")
	private String tbjxsj1208;

	public String getTbjxsj1201() {
		return tbjxsj1201;
	}

	public void setTbjxsj1201(String tbjxsj1201) {
		this.tbjxsj1201 = tbjxsj1201;
	}

	public String getTbjxsj1202() {
		return tbjxsj1202;
	}

	public void setTbjxsj1202(String tbjxsj1202) {
		this.tbjxsj1202 = tbjxsj1202;
	}

	public Date getTbjxsj1203() {
		return tbjxsj1203;
	}

	public void setTbjxsj1203(Date tbjxsj1203) {
		this.tbjxsj1203 = tbjxsj1203;
	}

	public String getTbjxsj1204() {
		return tbjxsj1204;
	}

	public void setTbjxsj1204(String tbjxsj1204) {
		this.tbjxsj1204 = tbjxsj1204;
	}

	public String getTbjxsj1205() {
		return tbjxsj1205;
	}

	public void setTbjxsj1205(String tbjxsj1205) {
		this.tbjxsj1205 = tbjxsj1205;
	}

	public String getTbjxsj1206() {
		return tbjxsj1206;
	}

	public void setTbjxsj1206(String tbjxsj1206) {
		this.tbjxsj1206 = tbjxsj1206;
	}

	public Integer getTbjxsj1207() {
		return tbjxsj1207;
	}

	public void setTbjxsj1207(Integer tbjxsj1207) {
		this.tbjxsj1207 = tbjxsj1207;
	}
	
	public String getTbjxsj1208() {
		return tbjxsj1208;
	}

	public void setTbjxsj1208(String tbjxsj1208) {
		this.tbjxsj1208 = tbjxsj1208;
	}

	@Override
	protected Serializable pkVal() {
		return this.tbjxsj1201;
	}

	@Override
	public String toString() {
		return "Tbjxsj12{" +
			"tbjxsj1201=" + tbjxsj1201 +
			", tbjxsj1202=" + tbjxsj1202 +
			", tbjxsj1203=" + tbjxsj1203 +
			", tbjxsj1204=" + tbjxsj1204 +
			", tbjxsj1205=" + tbjxsj1205 +
			", tbjxsj1206=" + tbjxsj1206 +
			", tbjxsj1207=" + tbjxsj1207 +
			"}";
	}
}

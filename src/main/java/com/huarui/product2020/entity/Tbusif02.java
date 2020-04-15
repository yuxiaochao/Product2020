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
 * @since 2020-02-16
 */
public class Tbusif02 extends Model<Tbusif02> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键PK
     */
    @TableId("USIF0201")
	private String usif0201;
    /**
     * 用户账号表ID
     */
	@TableField("USIF0202")
	private String usif0202;
    /**
     * 收货人
     */
	@TableField("USIF0203")
	private String usif0203;
    /**
     * 居住地（省）
     */
	@TableField("USIF0204")
	private String usif0204;
    /**
     * 居住地（市）
     */
	@TableField("USIF0205")
	private String usif0205;
    /**
     * 居住地（区）
     */
	@TableField("USIF0206")
	private String usif0206;
    /**
     * 详细地址
     */
	@TableField("USIF0207")
	private String usif0207;
    /**
     * 邮编号
     */
	@TableField("USIF0208")
	private String usif0208;
    /**
     * 手机号
     */
	@TableField("USIF0209")
	private String usif0209;
    /**
     * 固定电话
     */
	@TableField("USIF0210")
	private String usif0210;
    /**
     * 电子邮箱
     */
	@TableField("USIF0211")
	private String usif0211;
    /**
     * 是否默认地址 0否  1是 
     */
	@TableField("USIF0212")
	private Double usif0212;


	public String getUsif0201() {
		return usif0201;
	}

	public void setUsif0201(String usif0201) {
		this.usif0201 = usif0201;
	}

	public String getUsif0202() {
		return usif0202;
	}

	public void setUsif0202(String usif0202) {
		this.usif0202 = usif0202;
	}

	public String getUsif0203() {
		return usif0203;
	}

	public void setUsif0203(String usif0203) {
		this.usif0203 = usif0203;
	}

	public String getUsif0204() {
		return usif0204;
	}

	public void setUsif0204(String usif0204) {
		this.usif0204 = usif0204;
	}

	public String getUsif0205() {
		return usif0205;
	}

	public void setUsif0205(String usif0205) {
		this.usif0205 = usif0205;
	}

	public String getUsif0206() {
		return usif0206;
	}

	public void setUsif0206(String usif0206) {
		this.usif0206 = usif0206;
	}

	public String getUsif0207() {
		return usif0207;
	}

	public void setUsif0207(String usif0207) {
		this.usif0207 = usif0207;
	}

	public String getUsif0208() {
		return usif0208;
	}

	public void setUsif0208(String usif0208) {
		this.usif0208 = usif0208;
	}

	public String getUsif0209() {
		return usif0209;
	}

	public void setUsif0209(String usif0209) {
		this.usif0209 = usif0209;
	}

	public String getUsif0210() {
		return usif0210;
	}

	public void setUsif0210(String usif0210) {
		this.usif0210 = usif0210;
	}

	public String getUsif0211() {
		return usif0211;
	}

	public void setUsif0211(String usif0211) {
		this.usif0211 = usif0211;
	}

	public Double getUsif0212() {
		return usif0212;
	}

	public void setUsif0212(Double usif0212) {
		this.usif0212 = usif0212;
	}

	@Override
	protected Serializable pkVal() {
		return this.usif0201;
	}

	@Override
	public String toString() {
		return "Tbusif02{" +
			"usif0201=" + usif0201 +
			", usif0202=" + usif0202 +
			", usif0203=" + usif0203 +
			", usif0204=" + usif0204 +
			", usif0205=" + usif0205 +
			", usif0206=" + usif0206 +
			", usif0207=" + usif0207 +
			", usif0208=" + usif0208 +
			", usif0209=" + usif0209 +
			", usif0210=" + usif0210 +
			", usif0211=" + usif0211 +
			", usif0212=" + usif0212 +
			"}";
	}
}

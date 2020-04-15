package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author panlei
 * @since 2018-05-26
 */
@TableName("HRSW_T_FRIENDRELATEDSETTING")
public class HrswTFriendrelatedsetting extends Model<HrswTFriendrelatedsetting> {

    private static final long serialVersionUID = 1L;

    @TableId("FRRS001")
	private String frrs001;
    /**
     * 用户ID
     */
	@TableField("FRRS002")
	private String frrs002;
    /**
     * 好友ID
     */
	@TableField("FRRS003")
	private String frrs003;
    /**
     * 对好友的备注
     */
	@TableField("FRRS004")
	private String frrs004;
    /**
     * 对好友简介是否点赞
     */
	@TableField("FRRS005")
	private String frrs005;
    /**
     * 备用字段
     */
	@TableField("FRRS006")
	private String frrs006;
    /**
     * 备用字段
     */
	@TableField("FRRS007")
	private String frrs007;
    /**
     * 备用字段
     */
	@TableField("FRRS008")
	private String frrs008;
    /**
     * 备用字段
     */
	@TableField("FRRS009")
	private String frrs009;
    /**
     * 备用字段
     */
	@TableField("FRRS010")
	private String frrs010;
    /**
     * 备用字段
     */
	@TableField("FRRS011")
	private String frrs011;
    /**
     * 备用字段
     */
	@TableField("FRRS012")
	private String frrs012;
    /**
     * 备用字段
     */
	@TableField("FRRS013")
	private String frrs013;


	public String getFrrs001() {
		return frrs001;
	}

	public void setFrrs001(String frrs001) {
		this.frrs001 = frrs001;
	}

	public String getFrrs002() {
		return frrs002;
	}

	public void setFrrs002(String frrs002) {
		this.frrs002 = frrs002;
	}

	public String getFrrs003() {
		return frrs003;
	}

	public void setFrrs003(String frrs003) {
		this.frrs003 = frrs003;
	}

	public String getFrrs004() {
		return frrs004;
	}

	public void setFrrs004(String frrs004) {
		this.frrs004 = frrs004;
	}

	public String getFrrs005() {
		return frrs005;
	}

	public void setFrrs005(String frrs005) {
		this.frrs005 = frrs005;
	}

	public String getFrrs006() {
		return frrs006;
	}

	public void setFrrs006(String frrs006) {
		this.frrs006 = frrs006;
	}

	public String getFrrs007() {
		return frrs007;
	}

	public void setFrrs007(String frrs007) {
		this.frrs007 = frrs007;
	}

	public String getFrrs008() {
		return frrs008;
	}

	public void setFrrs008(String frrs008) {
		this.frrs008 = frrs008;
	}

	public String getFrrs009() {
		return frrs009;
	}

	public void setFrrs009(String frrs009) {
		this.frrs009 = frrs009;
	}

	public String getFrrs010() {
		return frrs010;
	}

	public void setFrrs010(String frrs010) {
		this.frrs010 = frrs010;
	}

	public String getFrrs011() {
		return frrs011;
	}

	public void setFrrs011(String frrs011) {
		this.frrs011 = frrs011;
	}

	public String getFrrs012() {
		return frrs012;
	}

	public void setFrrs012(String frrs012) {
		this.frrs012 = frrs012;
	}

	public String getFrrs013() {
		return frrs013;
	}

	public void setFrrs013(String frrs013) {
		this.frrs013 = frrs013;
	}

	@Override
	protected Serializable pkVal() {
		return this.frrs001;
	}

	@Override
	public String toString() {
		return "HrswTFriendrelatedsetting{" +
			"frrs001=" + frrs001 +
			", frrs002=" + frrs002 +
			", frrs003=" + frrs003 +
			", frrs004=" + frrs004 +
			", frrs005=" + frrs005 +
			", frrs006=" + frrs006 +
			", frrs007=" + frrs007 +
			", frrs008=" + frrs008 +
			", frrs009=" + frrs009 +
			", frrs010=" + frrs010 +
			", frrs011=" + frrs011 +
			", frrs012=" + frrs012 +
			", frrs013=" + frrs013 +
			"}";
	}
}

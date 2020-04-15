package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 课程库
 * </p>
 *
 * @author caifenglin
 * @since 2019-12-31
 */
@TableName("XZXY_T_COURSE")
public class Course extends Model<Course> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("COUR001")
	private String cour001;
    /**
     * 课程状态（1正常 0禁用）
     */
	@TableField("COUR002")
	private Integer cour002;
    /**
     * 开发年度
     */
	@TableField("COUR003")
	private String cour003;
    /**
     * 课程封面路径
     */
	@TableField("COUR004")
	private String cour004;
    /**
     * 使用目录表分类  |   所属分类
     */
	@TableField("COUR005")
	private String cour005;
    /**
     * 来源于字典表  |   教学形式
     */
	@TableField("COUR006")
	private String cour006;
    /**
     * 课程简介
     */
	@TableField("COUR007")
	private String cour007;
    /**
     * 创建人id
     */
	@TableField("COUR008")
	private String cour008;
    /**
     * 创建时间
     */
	@TableField("COUR009")
	private Date cour009;
    /**
     * 课程名称
     */
	@TableField("COUR010")
	private String cour010;
    /**
     * 最后修改时间
     */
	@TableField("COUR011")
	private Date cour011;
    /**
     * 课程被引用次数
     */
	@TableField("COUR013")
	private Long cour013;
    /**
     * 课程编码
     */
	@TableField("COUR012")
	private String cour012;
    /**
     * 课程来源（0院内，1院外）
     */
	@TableField("COUR014")
	private Integer cour014;
    /**
     * 状态 0：不共享 ；1：共享
     */
	@TableField("COUR015")
	private Integer cour015;
    /**
     * 课程类型 0：在线课程 ；1：面授课程
     */
	@TableField("COUR016")
	private Integer cour016;
    /**
     * 课程学时
     */
	@TableField("COUR017")
	private Long cour017;
    /**
     * 入库时间
     */
	@TableField("COUR018")
	private Date cour018;


	public String getCour001() {
		return cour001;
	}

	public void setCour001(String cour001) {
		this.cour001 = cour001;
	}

	public Integer getCour002() {
		return cour002;
	}

	public void setCour002(Integer cour002) {
		this.cour002 = cour002;
	}

	public String getCour003() {
		return cour003;
	}

	public void setCour003(String cour003) {
		this.cour003 = cour003;
	}

	public String getCour004() {
		return cour004;
	}

	public void setCour004(String cour004) {
		this.cour004 = cour004;
	}

	public String getCour005() {
		return cour005;
	}

	public void setCour005(String cour005) {
		this.cour005 = cour005;
	}

	public String getCour006() {
		return cour006;
	}

	public void setCour006(String cour006) {
		this.cour006 = cour006;
	}

	public String getCour007() {
		return cour007;
	}

	public void setCour007(String cour007) {
		this.cour007 = cour007;
	}

	public String getCour008() {
		return cour008;
	}

	public void setCour008(String cour008) {
		this.cour008 = cour008;
	}

	public Date getCour009() {
		return cour009;
	}

	public void setCour009(Date cour009) {
		this.cour009 = cour009;
	}

	public String getCour010() {
		return cour010;
	}

	public void setCour010(String cour010) {
		this.cour010 = cour010;
	}

	public Date getCour011() {
		return cour011;
	}

	public void setCour011(Date cour011) {
		this.cour011 = cour011;
	}

	public Long getCour013() {
		return cour013;
	}

	public void setCour013(Long cour013) {
		this.cour013 = cour013;
	}

	public String getCour012() {
		return cour012;
	}

	public void setCour012(String cour012) {
		this.cour012 = cour012;
	}

	public Integer getCour014() {
		return cour014;
	}

	public void setCour014(Integer cour014) {
		this.cour014 = cour014;
	}

	public Integer getCour015() {
		return cour015;
	}

	public void setCour015(Integer cour015) {
		this.cour015 = cour015;
	}

	public Integer getCour016() {
		return cour016;
	}

	public void setCour016(Integer cour016) {
		this.cour016 = cour016;
	}

	public Long getCour017() {
		return cour017;
	}

	public void setCour017(Long cour017) {
		this.cour017 = cour017;
	}

	public Date getCour018() {
		return cour018;
	}

	public void setCour018(Date cour018) {
		this.cour018 = cour018;
	}

	@Override
	protected Serializable pkVal() {
		return this.cour001;
	}

	@Override
	public String toString() {
		return "Course{" +
			"cour001=" + cour001 +
			", cour002=" + cour002 +
			", cour003=" + cour003 +
			", cour004=" + cour004 +
			", cour005=" + cour005 +
			", cour006=" + cour006 +
			", cour007=" + cour007 +
			", cour008=" + cour008 +
			", cour009=" + cour009 +
			", cour010=" + cour010 +
			", cour011=" + cour011 +
			", cour013=" + cour013 +
			", cour012=" + cour012 +
			", cour014=" + cour014 +
			", cour015=" + cour015 +
			", cour016=" + cour016 +
			", cour017=" + cour017 +
			", cour018=" + cour018 +
			"}";
	}
}

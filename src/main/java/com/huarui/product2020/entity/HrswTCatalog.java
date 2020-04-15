package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * ${table.comment}
 * </p>
 *
 * @author Chenrui
 * @since 2017-08-13
 */
@TableName("HRSW_T_CATALOG")
public class HrswTCatalog extends Model<HrswTCatalog> {

    private static final long serialVersionUID = 1L;

    @TableId("CATA001")
	private String cata001;
    /**
     * 目录名称
     */
	@TableField("CATA002")
	private String cata002;
    /**
     * 目录编码
     */
	@TableField("CATA003")
	private String cata003;
    /**
     * Parent ID
     */
	@TableField("CATA004")
	private String cata004;
    /**
     * parent编码
     */
	@TableField("CATA005")
	private String cata005;
    /**
     * 排序号
     */
	@TableField("CATA006")
	private Long cata006;
    /**
     * 权重
     */
	@TableField("CATA007")
	private Float cata007;
    /**
     * 目录类型  1、数据字典 2、岗位序列 3、群组目录 4、题库目录等
     */
	@TableField("CATA008")
	private Long cata008;
    /**
     * 归属单位ID
     */
	@TableField("CATA009")
	private String cata009;
    /**
     * 目录路径
     */
	@TableField("CATA010")
	private String cata010;
    /**
     * 目录层级
     */
	@TableField("CATA011")
	private Long cata011;
    /**
     * 目录状态  1、启用 2、禁用
     */
	@TableField("CATA012")
	private Long cata012;
    /**
     * 创建人ID
     */
	@TableField("CATA013")
	private String cata013;
    /**
     * 最后修改时间
     */
	@TableField("CATA014")
	private Date cata014;
    /**
     * 说明
     */
	@TableField("CATA015")
	private String cata015;
    /**
     * 学习主题封面地址（路径格式：“#{ftpServicePath}/xxx/yyy.jpg”，“#{ftpServicePath}”是ftp服务路径，在jsp手动替换）
     */
	@TableField("CATA016")
	private String cata016;


	public String getCata001() {
		return cata001;
	}

	public void setCata001(String cata001) {
		this.cata001 = cata001;
	}

	public String getCata002() {
		return cata002;
	}

	public void setCata002(String cata002) {
		this.cata002 = cata002;
	}

	public String getCata003() {
		return cata003;
	}

	public void setCata003(String cata003) {
		this.cata003 = cata003;
	}

	public String getCata004() {
		return cata004;
	}

	public void setCata004(String cata004) {
		this.cata004 = cata004;
	}

	public String getCata005() {
		return cata005;
	}

	public void setCata005(String cata005) {
		this.cata005 = cata005;
	}

	public Long getCata006() {
		return cata006;
	}

	public void setCata006(Long cata006) {
		this.cata006 = cata006;
	}

	public Float getCata007() {
		return cata007;
	}

	public void setCata007(Float cata007) {
		this.cata007 = cata007;
	}

	public Long getCata008() {
		return cata008;
	}

	public void setCata008(Long cata008) {
		this.cata008 = cata008;
	}

	public String getCata009() {
		return cata009;
	}

	public void setCata009(String cata009) {
		this.cata009 = cata009;
	}

	public String getCata010() {
		return cata010;
	}

	public void setCata010(String cata010) {
		this.cata010 = cata010;
	}

	public Long getCata011() {
		return cata011;
	}

	public void setCata011(Long cata011) {
		this.cata011 = cata011;
	}

	public Long getCata012() {
		return cata012;
	}

	public void setCata012(Long cata012) {
		this.cata012 = cata012;
	}

	public String getCata013() {
		return cata013;
	}

	public void setCata013(String cata013) {
		this.cata013 = cata013;
	}

	public Date getCata014() {
		return cata014;
	}

	public void setCata014(Date cata014) {
		this.cata014 = cata014;
	}

	public String getCata015() {
		return cata015;
	}

	public void setCata015(String cata015) {
		this.cata015 = cata015;
	}

	public String getCata016() {
		return cata016;
	}

	public void setCata016(String cata016) {
		this.cata016 = cata016;
	}

	@Override
	protected Serializable pkVal() {
		return this.cata001;
	}

}

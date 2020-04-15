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
@TableName("HRSW_T_NEWS")
public class HrswTNews extends Model<HrswTNews> {

    private static final long serialVersionUID = 1L;

    @TableId("NEWS001")
	private String news001;
	@TableField("NEWS002")
	private String news002;
	@TableField("NEWS003")
	private String news003;
	@TableField("NEWS004")
	private String news004;
	@TableField("NEWS005")
	private Date news005;
	@TableField("NEWS006")
	private String news006;
	@TableField("NEWS007")
	private Double news007;
	@TableField("NEWS008")
	private String news008;
	@TableField("NEWS009")
	private String news009;
	@TableField("NEWS010")
	private String news010;
	@TableField("NEWS011")
	private Double news011;
	@TableField("NEWS012")
	private Date news012;
	@TableField("NEWS013")
	private String news013;
	@TableField("NEWS014")
	private Double news014;
	@TableField("NEWS015")
	private String news015;
    /**
     * 所属分中心
     */
	@TableField("NEWS016")
	private String news016;
    /**
     * 文档新闻swf地址
     */
	@TableField("NEWS017")
	private String news017;
    /**
     * 文档新闻源文件地址
     */
	@TableField("NEWS018")
	private String news018;
    /**
     * 文档页数
     */
	@TableField("NEWS019")
	private String news019;
    /**
     * 转换状态：0、未转换，1、已转换，2、转换失败。
     */
	@TableField("NEWS020")
	private Double news020;
    /**
     * 新闻附件源文件名称
     */
	@TableField("NEWS021")
	private String news021;
    /**
     * 新闻发布对象
	 0、无发布对象限制  1、机构   2、学员   3、群组   4、职务
     */
	@TableField("NEWS022")
	private Integer news022;
	/**
	 * 发稿人ID
	 */
	@TableField("NEWS023")
	private String news023;
	/**
	 * 文档新闻pdf地址
	 */
	@TableField("NEWS024")
	private String news024;
	/**
	 * 新闻附件地址
	 */
	@TableField("NEWS025")
	private String news025;
	/**
	 * 新闻来源（手动输入）
	 */
	@TableField("NEWS026")
	private String news026;
	/**
	 * 是否允许评论（1允许 0不允许）
	 */
	@TableField("NEWS027")
	private Integer news027;
	/**
	 * 	是否允许在APP首页展示（1允许 0不允许）（廉政教育）
	 */
	@TableField("NEWS028")
	private Integer news028;
	/**
	 * 新闻内容简介
	 */
	@TableField("NEWS029")
	private String news029;
	/**
	 * 新闻附件源文件名称
	 */
	@TableField("NEWS030")
	private String news030;
	/**
	 * 	新闻关键字 （药监局）
	 */
	@TableField("NEWS031")
	private String news031;
	
	/**
	 * 新闻总数
	 */
	@TableField(exist = false)
	private String total;


	public String getNews001() {
		return news001;
	}

	public void setNews001(String news001) {
		this.news001 = news001;
	}

	public String getNews002() {
		return news002;
	}

	public void setNews002(String news002) {
		this.news002 = news002;
	}

	public String getNews003() {
		return news003;
	}

	public void setNews003(String news003) {
		this.news003 = news003;
	}

	public String getNews004() {
		return news004;
	}

	public void setNews004(String news004) {
		this.news004 = news004;
	}

	public Date getNews005() {
		return news005;
	}

	public void setNews005(Date news005) {
		this.news005 = news005;
	}

	public String getNews006() {
		return news006;
	}

	public void setNews006(String news006) {
		this.news006 = news006;
	}

	public Double getNews007() {
		return news007;
	}

	public void setNews007(Double news007) {
		this.news007 = news007;
	}

	public String getNews008() {
		return news008;
	}

	public void setNews008(String news008) {
		this.news008 = news008;
	}

	public String getNews009() {
		return news009;
	}

	public void setNews009(String news009) {
		this.news009 = news009;
	}

	public String getNews010() {
		return news010;
	}

	public void setNews010(String news010) {
		this.news010 = news010;
	}

	public Double getNews011() {
		return news011;
	}

	public void setNews011(Double news011) {
		this.news011 = news011;
	}

	public Date getNews012() {
		return news012;
	}

	public void setNews012(Date news012) {
		this.news012 = news012;
	}

	public String getNews013() {
		return news013;
	}

	public void setNews013(String news013) {
		this.news013 = news013;
	}

	public Double getNews014() {
		return news014;
	}

	public void setNews014(Double news014) {
		this.news014 = news014;
	}

	public String getNews015() {
		return news015;
	}

	public void setNews015(String news015) {
		this.news015 = news015;
	}

	public String getNews016() {
		return news016;
	}

	public void setNews016(String news016) {
		this.news016 = news016;
	}

	public String getNews017() {
		return news017;
	}

	public void setNews017(String news017) {
		this.news017 = news017;
	}

	public String getNews018() {
		return news018;
	}

	public void setNews018(String news018) {
		this.news018 = news018;
	}

	public String getNews019() {
		return news019;
	}

	public void setNews019(String news019) {
		this.news019 = news019;
	}

	public Double getNews020() {
		return news020;
	}

	public void setNews020(Double news020) {
		this.news020 = news020;
	}

	public String getNews021() {
		return news021;
	}

	public void setNews021(String news021) {
		this.news021 = news021;
	}

	public Integer getNews022() {
		return news022;
	}

	public void setNews022(Integer news022) {
		this.news022 = news022;
	}

	public String getNews023() {
		return news023;
	}

	public void setNews023(String news023) {
		this.news023 = news023;
	}

	@Override
	protected Serializable pkVal() {
		return this.news001;
	}

	public String getNews024() {
		return news024;
	}

	public void setNews024(String news024) {
		this.news024 = news024;
	}

	public String getNews025() {
		return news025;
	}

	public void setNews025(String news025) {
		this.news025 = news025;
	}

	public String getNews026() {
		return news026;
	}

	public void setNews026(String news026) {
		this.news026 = news026;
	}

	public Integer getNews027() {
		return news027;
	}

	public void setNews027(Integer news027) {
		this.news027 = news027;
	}

	public Integer getNews028() {
		return news028;
	}

	public void setNews028(Integer news028) {
		this.news028 = news028;
	}

	public String getNews029() {
		return news029;
	}

	public void setNews029(String news029) {
		this.news029 = news029;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getNews030() {
		return news030;
	}

	public void setNews030(String news030) {
		this.news030 = news030;
	}

	public String getNews031() {
		return news031;
	}

	public void setNews031(String news031) {
		this.news031 = news031;
	}

	
}

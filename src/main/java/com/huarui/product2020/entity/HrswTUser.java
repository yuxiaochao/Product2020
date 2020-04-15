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
@TableName("HRSW_T_USER")
public class HrswTUser extends Model<HrswTUser> {

    private static final long serialVersionUID = 1L;

    @TableId("USER001")
	private String user001;
    /**
     * 机构ID
     */
	@TableField("USER002")
	private String user002;
	
	/**
     * 机构名称
     */
	@TableField(exist = false)
	private String user002n;
    /**
     * 用户编号
     */
	@TableField("USER003")
	private String user003;
    /**
     * 账号
     */
	@TableField("USER004")
	private String user004;
    /**
     * 姓名
     */
	@TableField("USER005")
	private String user005;
    /**
     * 性别
     */
	@TableField("USER006")
	private String user006;
    /**
     * 出生日期
     */
	@TableField("USER007")
	private Date user007;
    /**
     * 入职日期
     */
	@TableField("USER008")
	private Date user008;
    /**
     * 民族
     */
	@TableField("USER009")
	private String user009;
    /**
     * 身份证
     */
	@TableField("USER010")
	private String user010;
    /**
     * 职级
     */
	@TableField("USER011")
	private String user011;
    /**
     * 最高学历
     */
	@TableField("USER012")
	private String user012;
    /**
     * 座机号
     */
	@TableField("USER013")
	private String user013;
    /**
     * 手机号
     */
	@TableField("USER014")
	private String user014;
    /**
     * 邮箱
     */
	@TableField("USER015")
	private String user015;
    /**
     * 密码
     */
	@TableField("USER016")
	private String user016;
    /**
     * 用户状态  (1 正常  2 虚拟   3 禁用)
     */
	@TableField("USER017")
	private Long user017;
    /**
     * 登录方式 (1、账号 2、手机  3、邮箱)  可多选
     */
	@TableField("USER018")
	private String user018;
    /**
     * 操作时间
     */
	@TableField("USER019")
	private Date user019;
    /**
     * 错误密码次数
     */
	@TableField("USER020")
	private Long user020;
    /**
     * 冻结时间
     */
	@TableField("USER021")
	private Date user021;
    /**
     * 年龄
     */
	private String user022;
    /**
     * 头拼音字母
     */
	@TableField("USER023")
	private String user023;
    /**
     * 拼音字母
     */
	@TableField("USER024")
	private String user024;
    /**
     * 字符型备用字段
     */
	@TableField("USER025")
	private String user025;

	@TableField(exist = false)
	private String user025n;
    /**
     * 字符型备用字段
     */
	@TableField("USER026")
	private String user026;
    /**
     * 字符型备用字段
     */
	@TableField("USER027")
	private String user027;
    /**
     * 字符型备用字段
     */
	@TableField("USER028")
	private String user028;
    /**
     * 字符型备用字段  Unicode
     */
	@TableField("USER029")
	private String user029;
    /**
     * 字符型备用字段  Unicode
     */
	@TableField("USER030")
	private String user030;
    /**
     * 字符型备用字段  Unicode
     */
	@TableField("USER031")
	private String user031;
    /**
     * 数字型备用字段
     */
	@TableField("USER032")
	private Long user032;
    /**
     * 数字型备用字段
     */
	@TableField("USER033")
	private Long user033;
    /**
     * 数字型备用字段
     */
	@TableField("USER034")
	private Long user034;
    /**
     * 数字型备用字段
     */
	@TableField("USER035")
	private Long user035;
    /**
     * 数字型备用字段
     */
	@TableField("USER036")
	private Long user036;
    /**
     * 日期型备用字段
     */
	@TableField("USER037")
	private Date user037;
    /**
     * 日期型备用字段
     */
	@TableField("USER038")
	private Date user038;
    /**
     * 日期型备用字段
     */
	@TableField("USER039")
	private Date user039;
    /**
     * 日期型备用字段
     */
	@TableField("USER040")
	private Date user040;
	/**
	 * 创建时间
	 */
	@TableField("USER041")
	private Date user041;
	/**
	 * 最后修改时间
	 */
	@TableField("USER042")
	private Date user042;
	/**
	 * 	创建人
	 */
	@TableField("USER043")
	private String user043;

	@TableField(exist = false)
	private String organname;


	public String getUser001() {
		return user001;
	}

	public void setUser001(String user001) {
		this.user001 = user001;
	}

	public String getUser002() {
		return user002;
	}

	public void setUser002(String user002) {
		this.user002 = user002;
	}

	public String getUser003() {
		return user003;
	}

	public void setUser003(String user003) {
		this.user003 = user003;
	}

	public String getUser004() {
		return user004;
	}

	public void setUser004(String user004) {
		this.user004 = user004;
	}

	public String getUser005() {
		return user005;
	}

	public void setUser005(String user005) {
		this.user005 = user005;
	}

	public String getUser006() {
		return user006;
	}

	public void setUser006(String user006) {
		this.user006 = user006;
	}

	public Date getUser007() {
		return user007;
	}

	public void setUser007(Date user007) {
		this.user007 = user007;
	}

	public Date getUser008() {
		return user008;
	}

	public void setUser008(Date user008) {
		this.user008 = user008;
	}

	public String getUser009() {
		return user009;
	}

	public void setUser009(String user009) {
		this.user009 = user009;
	}

	public String getUser010() {
		return user010;
	}

	public void setUser010(String user010) {
		this.user010 = user010;
	}

	public String getUser011() {
		return user011;
	}

	public void setUser011(String user011) {
		this.user011 = user011;
	}

	public String getUser012() {
		return user012;
	}

	public void setUser012(String user012) {
		this.user012 = user012;
	}

	public String getUser013() {
		return user013;
	}

	public void setUser013(String user013) {
		this.user013 = user013;
	}

	public String getUser014() {
		return user014;
	}

	public void setUser014(String user014) {
		this.user014 = user014;
	}

	public String getUser015() {
		return user015;
	}

	public void setUser015(String user015) {
		this.user015 = user015;
	}

	public String getUser016() {
		return user016;
	}

	public void setUser016(String user016) {
		this.user016 = user016;
	}

	public Long getUser017() {
		return user017;
	}

	public void setUser017(Long user017) {
		this.user017 = user017;
	}

	public String getUser018() {
		return user018;
	}

	public void setUser018(String user018) {
		this.user018 = user018;
	}

	public Date getUser019() {
		return user019;
	}

	public void setUser019(Date user019) {
		this.user019 = user019;
	}

	public Long getUser020() {
		return user020;
	}

	public void setUser020(Long user020) {
		this.user020 = user020;
	}

	public Date getUser021() {
		return user021;
	}

	public void setUser021(Date user021) {
		this.user021 = user021;
	}

	public String getUser022() {
		return user022;
	}

	public void setUser022(String user022) {
		this.user022 = user022;
	}

	public String getUser023() {
		return user023;
	}

	public void setUser023(String user023) {
		this.user023 = user023;
	}

	public String getUser024() {
		return user024;
	}

	public void setUser024(String user024) {
		this.user024 = user024;
	}

	public String getUser025() {
		return user025;
	}

	public void setUser025(String user025) {
		this.user025 = user025;
	}

	public String getUser026() {
		return user026;
	}

	public void setUser026(String user026) {
		this.user026 = user026;
	}

	public String getUser027() {
		return user027;
	}

	public void setUser027(String user027) {
		this.user027 = user027;
	}

	public String getUser028() {
		return user028;
	}

	public void setUser028(String user028) {
		this.user028 = user028;
	}

	public String getUser029() {
		return user029;
	}

	public void setUser029(String user029) {
		this.user029 = user029;
	}

	public String getUser030() {
		return user030;
	}

	public void setUser030(String user030) {
		this.user030 = user030;
	}

	public String getUser031() {
		return user031;
	}

	public void setUser031(String user031) {
		this.user031 = user031;
	}

	public Long getUser032() {
		return user032;
	}

	public void setUser032(Long user032) {
		this.user032 = user032;
	}

	public Long getUser033() {
		return user033;
	}

	public void setUser033(Long user033) {
		this.user033 = user033;
	}

	public Long getUser034() {
		return user034;
	}

	public void setUser034(Long user034) {
		this.user034 = user034;
	}

	public Long getUser035() {
		return user035;
	}

	public void setUser035(Long user035) {
		this.user035 = user035;
	}

	public Long getUser036() {
		return user036;
	}

	public void setUser036(Long user036) {
		this.user036 = user036;
	}

	public Date getUser037() {
		return user037;
	}

	public void setUser037(Date user037) {
		this.user037 = user037;
	}

	public Date getUser038() {
		return user038;
	}

	public void setUser038(Date user038) {
		this.user038 = user038;
	}

	public Date getUser039() {
		return user039;
	}

	public void setUser039(Date user039) {
		this.user039 = user039;
	}

	public Date getUser040() {
		return user040;
	}

	public void setUser040(Date user040) {
		this.user040 = user040;
	}

	@Override
	protected Serializable pkVal() {
		return this.user001;
	}

	public Date getUser041() {
		return user041;
	}

	public void setUser041(Date user041) {
		this.user041 = user041;
	}

	public Date getUser042() {
		return user042;
	}

	public void setUser042(Date user042) {
		this.user042 = user042;
	}

	public String getUser043() {
		return user043;
	}

	public void setUser043(String user043) {
		this.user043 = user043;
	}

	public String getUser002n() {
		return user002n;
	}

	public void setUser002n(String user002n) {
		this.user002n = user002n;
	}

	public String getOrganname() {
		return organname;
	}

	public void setOrganname(String organname) {
		this.organname = organname;
	}

	public String getUser025n() {
		return user025n;
	}

	public void setUser025n(String user025n) {
		this.user025n = user025n;
	}
}

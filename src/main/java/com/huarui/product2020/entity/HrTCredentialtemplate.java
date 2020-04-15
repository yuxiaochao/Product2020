package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author YanZeYang
 * @since 2019-12-12
 */
@TableName("HR_T_CREDENTIALTEMPLATE")
public class HrTCredentialtemplate extends Model<HrTCredentialtemplate> {

    private static final long serialVersionUID = 1L;

    /**
     * 自动编号
     */
    @TableId("CRTE001")
	private String crte001;
    /**
     * 证书名称
     */
	@TableField("CRTE002")
	private String crte002;
    /**
     * 模版路径
     */
	@TableField("CRTE003")
	private String crte003;
    /**
     * 姓名字体
     */
	@TableField("CRTE004")
	private String crte004;
    /**
     * 姓名字体样式
     */
	@TableField("CRTE005")
	private String crte005;
    /**
     * 姓名字体颜色
     */
	@TableField("CRTE006")
	private String crte006;
    /**
     * 姓名字体大小
     */
	@TableField("CRTE007")
	private String crte007;
    /**
     * 姓名X坐标
     */
	@TableField("CRTE008")
	private Integer crte008;
    /**
     * 姓名Y坐标
     */
	@TableField("CRTE009")
	private Integer crte009;
    /**
     * 参培日期开始字体
     */
	@TableField("CRTE010")
	private String crte010;
    /**
     * 参培日期开始字体样式
     */
	@TableField("CRTE011")
	private String crte011;
    /**
     * 参培日期开始字体颜色
     */
	@TableField("CRTE012")
	private String crte012;
    /**
     * 参培日期开始字体大小
     */
	@TableField("CRTE013")
	private String crte013;
    /**
     * 参培日期开始X坐标
     */
	@TableField("CRTE014")
	private Integer crte014;
    /**
     * 参培日期开始Y坐标
     */
	@TableField("CRTE015")
	private Integer crte015;
    /**
     * 参培日期结束字体
     */
	@TableField("CRTE016")
	private String crte016;
    /**
     * 参培日期结束字体样式
     */
	@TableField("CRTE017")
	private String crte017;
    /**
     * 参培日期结束字体颜色
     */
	@TableField("CRTE018")
	private String crte018;
    /**
     * 参培日期结束字体大小
     */
	@TableField("CRTE019")
	private String crte019;
    /**
     * 参培日期结束X坐标
     */
	@TableField("CRTE020")
	private Integer crte020;
    /**
     * 参培日期结束Y坐标
     */
	@TableField("CRTE021")
	private Integer crte021;
    /**
     * 培训班名字字体
     */
	@TableField("CRTE022")
	private String crte022;
    /**
     * 培训班名字字体样式
     */
	@TableField("CRTE023")
	private String crte023;
    /**
     * 培训班名字字体颜色
     */
	@TableField("CRTE024")
	private String crte024;
    /**
     * 培训班名字字体大小
     */
	@TableField("CRTE025")
	private String crte025;
    /**
     * 培训班名字X坐标
     */
	@TableField("CRTE026")
	private Integer crte026;
    /**
     * 培训班名字Y坐标
     */
	@TableField("CRTE027")
	private Integer crte027;
    /**
     * 发证日期字体
     */
	@TableField("CRTE028")
	private String crte028;
    /**
     * 发证日期字体样式
     */
	@TableField("CRTE029")
	private String crte029;
    /**
     * 发证日期字体颜色
     */
	@TableField("CRTE030")
	private String crte030;
    /**
     * 发证日期字体大小
     */
	@TableField("CRTE031")
	private String crte031;
    /**
     * 发证日期X坐标
     */
	@TableField("CRTE032")
	private Integer crte032;
    /**
     * 发证日期Y坐标
     */
	@TableField("CRTE033")
	private Integer crte033;
    /**
     * 证书编码字体
     */
	@TableField("CRTE034")
	private String crte034;
    /**
     * 证书编码字体样式
     */
	@TableField("CRTE035")
	private String crte035;
    /**
     * 证书编码字体颜色
     */
	@TableField("CRTE036")
	private String crte036;
    /**
     * 证书编码字体大小
     */
	@TableField("CRTE037")
	private String crte037;
    /**
     * 证书编码X坐标
     */
	@TableField("CRTE038")
	private Integer crte038;
    /**
     * 证书编码Y坐标
     */
	@TableField("CRTE039")
	private Integer crte039;
    /**
     * 照片X坐标
     */
	@TableField("CRTE040")
	private Integer crte040;
    /**
     * 照片Y坐标
     */
	@TableField("CRTE041")
	private Integer crte041;
    /**
     * 最后修改时间
     */
	@TableField("CRTE042")
	private Date crte042;
    /**
     * 创建人
     */
	@TableField("CRTE043")
	private String crte043;
    /**
     * 证书类型0线上1面授2混合
     */
	@TableField("CRTE044")
	private Integer crte044;
	 /**
     * 证书编码
     */
	@TableField("CRTE045")
	private String crte045;
	 /**
     * 模板宽度
     */
	@TableField("CRTE046")
	private Integer crte046;
	 /**
     * 模板长度
     */
	@TableField("CRTE047")
	private Integer crte047;
	/**
	 * 模板名称
	 */
	@TableField("CRTE048")
	private String crte048;
	public String getCrte001() {
		return crte001;
	}

	public void setCrte001(String crte001) {
		this.crte001 = crte001;
	}

	public String getCrte002() {
		return crte002;
	}

	public void setCrte002(String crte002) {
		this.crte002 = crte002;
	}

	public String getCrte003() {
		return crte003;
	}

	public void setCrte003(String crte003) {
		this.crte003 = crte003;
	}

	public String getCrte004() {
		return crte004;
	}

	public void setCrte004(String crte004) {
		this.crte004 = crte004;
	}

	public String getCrte005() {
		return crte005;
	}

	public void setCrte005(String crte005) {
		this.crte005 = crte005;
	}

	public String getCrte006() {
		return crte006;
	}

	public void setCrte006(String crte006) {
		this.crte006 = crte006;
	}

	public String getCrte007() {
		return crte007;
	}

	public void setCrte007(String crte007) {
		this.crte007 = crte007;
	}

	public Integer getCrte008() {
		return crte008;
	}

	public void setCrte008(Integer crte008) {
		this.crte008 = crte008;
	}

	public Integer getCrte009() {
		return crte009;
	}

	public void setCrte009(Integer crte009) {
		this.crte009 = crte009;
	}

	public String getCrte010() {
		return crte010;
	}

	public void setCrte010(String crte010) {
		this.crte010 = crte010;
	}

	public String getCrte011() {
		return crte011;
	}

	public void setCrte011(String crte011) {
		this.crte011 = crte011;
	}

	public String getCrte012() {
		return crte012;
	}

	public void setCrte012(String crte012) {
		this.crte012 = crte012;
	}

	public String getCrte013() {
		return crte013;
	}

	public void setCrte013(String crte013) {
		this.crte013 = crte013;
	}

	public Integer getCrte014() {
		return crte014;
	}

	public void setCrte014(Integer crte014) {
		this.crte014 = crte014;
	}

	public Integer getCrte015() {
		return crte015;
	}

	public void setCrte015(Integer crte015) {
		this.crte015 = crte015;
	}

	public String getCrte016() {
		return crte016;
	}

	public void setCrte016(String crte016) {
		this.crte016 = crte016;
	}

	public String getCrte017() {
		return crte017;
	}

	public void setCrte017(String crte017) {
		this.crte017 = crte017;
	}

	public String getCrte018() {
		return crte018;
	}

	public void setCrte018(String crte018) {
		this.crte018 = crte018;
	}

	public String getCrte019() {
		return crte019;
	}

	public void setCrte019(String crte019) {
		this.crte019 = crte019;
	}

	public Integer getCrte020() {
		return crte020;
	}

	public void setCrte020(Integer crte020) {
		this.crte020 = crte020;
	}

	public Integer getCrte021() {
		return crte021;
	}

	public void setCrte021(Integer crte021) {
		this.crte021 = crte021;
	}

	public String getCrte022() {
		return crte022;
	}

	public void setCrte022(String crte022) {
		this.crte022 = crte022;
	}

	public String getCrte023() {
		return crte023;
	}

	public void setCrte023(String crte023) {
		this.crte023 = crte023;
	}

	public String getCrte024() {
		return crte024;
	}

	public void setCrte024(String crte024) {
		this.crte024 = crte024;
	}

	public String getCrte025() {
		return crte025;
	}

	public void setCrte025(String crte025) {
		this.crte025 = crte025;
	}

	public Integer getCrte026() {
		return crte026;
	}

	public void setCrte026(Integer crte026) {
		this.crte026 = crte026;
	}

	public Integer getCrte027() {
		return crte027;
	}

	public void setCrte027(Integer crte027) {
		this.crte027 = crte027;
	}

	public String getCrte028() {
		return crte028;
	}

	public void setCrte028(String crte028) {
		this.crte028 = crte028;
	}

	public String getCrte029() {
		return crte029;
	}

	public void setCrte029(String crte029) {
		this.crte029 = crte029;
	}

	public String getCrte030() {
		return crte030;
	}

	public void setCrte030(String crte030) {
		this.crte030 = crte030;
	}

	public String getCrte031() {
		return crte031;
	}

	public void setCrte031(String crte031) {
		this.crte031 = crte031;
	}

	public Integer getCrte032() {
		return crte032;
	}

	public void setCrte032(Integer crte032) {
		this.crte032 = crte032;
	}

	public Integer getCrte033() {
		return crte033;
	}

	public void setCrte033(Integer crte033) {
		this.crte033 = crte033;
	}

	public String getCrte034() {
		return crte034;
	}

	public void setCrte034(String crte034) {
		this.crte034 = crte034;
	}

	public String getCrte035() {
		return crte035;
	}

	public void setCrte035(String crte035) {
		this.crte035 = crte035;
	}

	public String getCrte036() {
		return crte036;
	}

	public void setCrte036(String crte036) {
		this.crte036 = crte036;
	}

	public String getCrte037() {
		return crte037;
	}

	public void setCrte037(String crte037) {
		this.crte037 = crte037;
	}

	public Integer getCrte038() {
		return crte038;
	}

	public void setCrte038(Integer crte038) {
		this.crte038 = crte038;
	}

	public Integer getCrte039() {
		return crte039;
	}

	public void setCrte039(Integer crte039) {
		this.crte039 = crte039;
	}

	public Integer getCrte040() {
		return crte040;
	}

	public void setCrte040(Integer crte040) {
		this.crte040 = crte040;
	}

	public Integer getCrte041() {
		return crte041;
	}

	public void setCrte041(Integer crte041) {
		this.crte041 = crte041;
	}

	public Date getCrte042() {
		return crte042;
	}

	public void setCrte042(Date crte042) {
		this.crte042 = crte042;
	}

	public String getCrte043() {
		return crte043;
	}

	public void setCrte043(String crte043) {
		this.crte043 = crte043;
	}

	public Integer getCrte044() {
		return crte044;
	}

	public void setCrte044(Integer crte044) {
		this.crte044 = crte044;
	}

	public String getCrte045() {
		return crte045;
	}

	public void setCrte045(String crte045) {
		this.crte045 = crte045;
	}
	
	public Integer getCrte046() {
		return crte046;
	}

	public void setCrte046(Integer crte046) {
		this.crte046 = crte046;
	}

	public Integer getCrte047() {
		return crte047;
	}

	public void setCrte047(Integer crte047) {
		this.crte047 = crte047;
	}
	
	public String getCrte048() {
		return crte048;
	}

	public void setCrte048(String crte048) {
		this.crte048 = crte048;
	}

	@Override
	protected Serializable pkVal() {
		return this.crte001;
	}

	@Override
	public String toString() {
		return "HrTCredentialtemplate{" +
			"crte001=" + crte001 +
			", crte002=" + crte002 +
			", crte003=" + crte003 +
			", crte004=" + crte004 +
			", crte005=" + crte005 +
			", crte006=" + crte006 +
			", crte007=" + crte007 +
			", crte008=" + crte008 +
			", crte009=" + crte009 +
			", crte010=" + crte010 +
			", crte011=" + crte011 +
			", crte012=" + crte012 +
			", crte013=" + crte013 +
			", crte014=" + crte014 +
			", crte015=" + crte015 +
			", crte016=" + crte016 +
			", crte017=" + crte017 +
			", crte018=" + crte018 +
			", crte019=" + crte019 +
			", crte020=" + crte020 +
			", crte021=" + crte021 +
			", crte022=" + crte022 +
			", crte023=" + crte023 +
			", crte024=" + crte024 +
			", crte025=" + crte025 +
			", crte026=" + crte026 +
			", crte027=" + crte027 +
			", crte028=" + crte028 +
			", crte029=" + crte029 +
			", crte030=" + crte030 +
			", crte031=" + crte031 +
			", crte032=" + crte032 +
			", crte033=" + crte033 +
			", crte034=" + crte034 +
			", crte035=" + crte035 +
			", crte036=" + crte036 +
			", crte037=" + crte037 +
			", crte038=" + crte038 +
			", crte039=" + crte039 +
			", crte040=" + crte040 +
			", crte041=" + crte041 +
			", crte042=" + crte042 +
			", crte043=" + crte043 +
			", crte044=" + crte044 +
			"}";
	}
}

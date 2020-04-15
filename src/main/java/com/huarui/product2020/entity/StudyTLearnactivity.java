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
@TableName("STUDY_T_LEARNACTIVITY")
public class StudyTLearnactivity extends Model<StudyTLearnactivity> {

    private static final long serialVersionUID = 1L;

    @TableId("LEAC001")
	private String leac001;
	@TableField("LEAC002")
	private String leac002;
	@TableField("LEAC003")
	private String leac003;
	@TableField("LEAC004")
	private String leac004;
	@TableField("LEAC005")
	private Double leac005;
	@TableField("LEAC006")
	private Double leac006;
	@TableField("LEAC007")
	private Date leac007;
	@TableField("LEAC008")
	private Date leac008;
	@TableField("LEAC009")
	private String leac009;
	@TableField("LEAC010")
	private String leac010;
	@TableField("LEAC011")
	private Date leac011;
	@TableField("LEAC012")
	private Date leac012;
	@TableField("LEAC013")
	private Double leac013;
	@TableField("LEAC014")
	private Double leac014;
	@TableField("LEAC015")
	private Double leac015;
	@TableField("LEAC016")
	private Double leac016;
	@TableField("LEAC017")
	private String leac017;
	@TableField("LEAC018")
	private Double leac018;
    /**
     * 学习活动类型 1、公共课程-岸端 2、职务课程-岸端 3、公共课程-船端 4、职务课程-船端
     */
	@TableField("LEAC019")
	private Double leac019;
    /**
     * 学员提问
     */
	@TableField("LEAC020")
	private Double leac020;
	@TableField("LEAC021")
	private Double leac021;
	@TableField("LEAC022")
	private Double leac022;
	@TableField("LEAC023")
	private Double leac023;
	@TableField("LEAC024")
	private Double leac024;
	@TableField("LEAC025")
	private Double leac025;
    /**
     * 来源 1、岸端 2、船端
     */
	@TableField("LEAC026")
	private Double leac026;
    /**
     * 课程通知
     */
	@TableField("LEUS022")
	private Double leus022;
    /**
     * 在线作业
     */
	@TableField("LEUS023")
	private Double leus023;
    /**
     * 效果评估
     */
	@TableField("LEUS024")
	private Double leus024;
    /**
     * 结业考试
     */
	@TableField("LEUS025")
	private Double leus025;
	@TableField("LEAC027")
	private String leac027;
	@TableField("LEAC028")
	private String leac028;
	@TableField("LEAC029")
	private String leac029;
	@TableField("LEAC030")
	private Date leac030;
    /**
     * 学习活动编号
     */
	@TableField("LEAC031")
	private String leac031;
    /**
     * 归档方式：0、手动归档 1、自动归档
     */
	@TableField("LEAC032")
	private Double leac032;


	public String getLeac001() {
		return leac001;
	}

	public void setLeac001(String leac001) {
		this.leac001 = leac001;
	}

	public String getLeac002() {
		return leac002;
	}

	public void setLeac002(String leac002) {
		this.leac002 = leac002;
	}

	public String getLeac003() {
		return leac003;
	}

	public void setLeac003(String leac003) {
		this.leac003 = leac003;
	}

	public String getLeac004() {
		return leac004;
	}

	public void setLeac004(String leac004) {
		this.leac004 = leac004;
	}

	public Double getLeac005() {
		return leac005;
	}

	public void setLeac005(Double leac005) {
		this.leac005 = leac005;
	}

	public Double getLeac006() {
		return leac006;
	}

	public void setLeac006(Double leac006) {
		this.leac006 = leac006;
	}

	public Date getLeac007() {
		return leac007;
	}

	public void setLeac007(Date leac007) {
		this.leac007 = leac007;
	}

	public Date getLeac008() {
		return leac008;
	}

	public void setLeac008(Date leac008) {
		this.leac008 = leac008;
	}

	public String getLeac009() {
		return leac009;
	}

	public void setLeac009(String leac009) {
		this.leac009 = leac009;
	}

	public String getLeac010() {
		return leac010;
	}

	public void setLeac010(String leac010) {
		this.leac010 = leac010;
	}

	public Date getLeac011() {
		return leac011;
	}

	public void setLeac011(Date leac011) {
		this.leac011 = leac011;
	}

	public Date getLeac012() {
		return leac012;
	}

	public void setLeac012(Date leac012) {
		this.leac012 = leac012;
	}

	public Double getLeac013() {
		return leac013;
	}

	public void setLeac013(Double leac013) {
		this.leac013 = leac013;
	}

	public Double getLeac014() {
		return leac014;
	}

	public void setLeac014(Double leac014) {
		this.leac014 = leac014;
	}

	public Double getLeac015() {
		return leac015;
	}

	public void setLeac015(Double leac015) {
		this.leac015 = leac015;
	}

	public Double getLeac016() {
		return leac016;
	}

	public void setLeac016(Double leac016) {
		this.leac016 = leac016;
	}

	public String getLeac017() {
		return leac017;
	}

	public void setLeac017(String leac017) {
		this.leac017 = leac017;
	}

	public Double getLeac018() {
		return leac018;
	}

	public void setLeac018(Double leac018) {
		this.leac018 = leac018;
	}

	public Double getLeac019() {
		return leac019;
	}

	public void setLeac019(Double leac019) {
		this.leac019 = leac019;
	}

	public Double getLeac020() {
		return leac020;
	}

	public void setLeac020(Double leac020) {
		this.leac020 = leac020;
	}

	public Double getLeac021() {
		return leac021;
	}

	public void setLeac021(Double leac021) {
		this.leac021 = leac021;
	}

	public Double getLeac022() {
		return leac022;
	}

	public void setLeac022(Double leac022) {
		this.leac022 = leac022;
	}

	public Double getLeac023() {
		return leac023;
	}

	public void setLeac023(Double leac023) {
		this.leac023 = leac023;
	}

	public Double getLeac024() {
		return leac024;
	}

	public void setLeac024(Double leac024) {
		this.leac024 = leac024;
	}

	public Double getLeac025() {
		return leac025;
	}

	public void setLeac025(Double leac025) {
		this.leac025 = leac025;
	}

	public Double getLeac026() {
		return leac026;
	}

	public void setLeac026(Double leac026) {
		this.leac026 = leac026;
	}

	public Double getLeus022() {
		return leus022;
	}

	public void setLeus022(Double leus022) {
		this.leus022 = leus022;
	}

	public Double getLeus023() {
		return leus023;
	}

	public void setLeus023(Double leus023) {
		this.leus023 = leus023;
	}

	public Double getLeus024() {
		return leus024;
	}

	public void setLeus024(Double leus024) {
		this.leus024 = leus024;
	}

	public Double getLeus025() {
		return leus025;
	}

	public void setLeus025(Double leus025) {
		this.leus025 = leus025;
	}

	public String getLeac027() {
		return leac027;
	}

	public void setLeac027(String leac027) {
		this.leac027 = leac027;
	}

	public String getLeac028() {
		return leac028;
	}

	public void setLeac028(String leac028) {
		this.leac028 = leac028;
	}

	public String getLeac029() {
		return leac029;
	}

	public void setLeac029(String leac029) {
		this.leac029 = leac029;
	}

	public Date getLeac030() {
		return leac030;
	}

	public void setLeac030(Date leac030) {
		this.leac030 = leac030;
	}

	public String getLeac031() {
		return leac031;
	}

	public void setLeac031(String leac031) {
		this.leac031 = leac031;
	}

	public Double getLeac032() {
		return leac032;
	}

	public void setLeac032(Double leac032) {
		this.leac032 = leac032;
	}

	@Override
	protected Serializable pkVal() {
		return this.leac001;
	}

}

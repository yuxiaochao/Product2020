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
@TableName("HRSW_T_ORGAN")
public class HrswTOrgan extends Model<HrswTOrgan> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("ORGA001")
	private String orga001;
    /**
     * 父机构ID
     */
	@TableField("ORGA002")
	private String orga002;
    /**
     * 机构编码
     */
	@TableField("ORGA003")
	private String orga003;
    /**
     * 父机构编码
     */
	@TableField("ORGA004")
	private String orga004;
    /**
     * 机构名称
     */
	@TableField("ORGA005")
	private String orga005;
    /**
     * 机构简称
     */
	@TableField("ORGA006")
	private String orga006;
    /**
     * 机构分类
		0：机构 
		1：部门 
		2：虚拟（不统计）
		def(0)
     */
	@TableField("ORGA007")
	private Long orga007;
    /**
     * 排序编号
     */
	@TableField("ORGA008")
	private Long orga008;
    /**
     * 备注说明
     */
	@TableField("ORGA009")
	private String orga009;
    /**
     * 机构层级
     */
	@TableField("ORGA010")
	private Long orga010;
    /**
     * 机构简介
     */
	@TableField("ORGA011")
	private String orga011;
    /**
     * 机构路径
     */
	@TableField("ORGA012")
	private String orga012;
    /**
     * 机构状态 1：正常 2：禁用
     */
	@TableField("ORGA013")
	private Long orga013;
    /**
     * 是否纳入统计 1：是 2：否
     */
	@TableField("ORGA014")
	private Long orga014;
    /**
     * 操作时间  用于第三方数据增量同步
     */
	@TableField("ORGA015")
	private Date orga015;
    /**
     * 字符型备用字段
     */
	@TableField("ORGA016")
	private String orga016;
    /**
     * 字符型备用字段
     */
	@TableField("ORGA017")
	private String orga017;
    /**
     * 字符型备用字段
     */
	@TableField("ORGA018")
	private String orga018;
    /**
     * 字符型备用字段  Unicode
     */
	@TableField("ORGA019")
	private String orga019;
    /**
     * 数字型备用字段
     */
	@TableField("ORGA020")
	private Long orga020;
    /**
     * 数字型备用字段
     */
	@TableField("ORGA021")
	private Long orga021;
    /**
     * 日期型备用字段
     */
	@TableField("ORGA022")
	private Date orga022;
    /**
     * 日期型备用字段
     */
	@TableField("ORGA023")
	private Date orga023;
	
	/**
	 * 字符型备用字段
	 */
	private String orga024;
	/**
	 * 字符型备用字段
	 */
	private String orga025;
	/**
	 * 认证单位类型 默认-1 0 中电联 1省级鉴定中心 2市级鉴定站
	 */
	private String orga026;
	
	/**
	 * 课程id
	 */
	@TableField(exist = false)
	private String leac001;
	
	/**
	 * 应参加人数
	 */
	@TableField(exist = false)
	private String ycrs;
	
	/**
	 * 实参加人数
	 */
	@TableField(exist = false)
	private String scrs;
	
	/**
	 * 结业人数
	 */
	@TableField(exist = false)
	private String jyrs;
	
	/**
	 * 参学率
	 */
	@TableField(exist = false)
	private String cxl;
	
	/**
	 * 结业率
	 */
	@TableField(exist = false)
	private String jyl;
	
	/**
	 * 总学时
	 */
	@TableField(exist = false)
	private String zxs;
	
	/**
	 * 平均学时
	 */
	@TableField(exist = false)
	private String pjxs;
	
	@TableField(exist = false)
	private Integer childcount;
	
	/**
	 * 行业id
	 */
	@TableField(exist = false)
	private String selectJobId;
	
	/**
	 * 行业名称
	 */
	@TableField(exist = false)
	private String selectJobName;
	
	/**
	 * 用户id
	 */
	@TableField(exist = false)
	private String userId;
	
	/**
	 * 用户名称
	 */
	@TableField(exist = false)
	private String userName;
	
	@TableField(exist = false)
	private String mest003;
	
	
	/**
	 * 培训机构
	 * 单位ID
	 */
	@TableField(exist = false)
	private String bmdw001;


	public String getOrga001() {
		return orga001;
	}

	public void setOrga001(String orga001) {
		this.orga001 = orga001;
	}

	public String getOrga002() {
		return orga002;
	}

	public void setOrga002(String orga002) {
		this.orga002 = orga002;
	}

	public String getOrga003() {
		return orga003;
	}

	public void setOrga003(String orga003) {
		this.orga003 = orga003;
	}

	public String getOrga004() {
		return orga004;
	}

	public void setOrga004(String orga004) {
		this.orga004 = orga004;
	}

	public String getOrga005() {
		return orga005;
	}

	public void setOrga005(String orga005) {
		this.orga005 = orga005;
	}

	public String getOrga006() {
		return orga006;
	}

	public void setOrga006(String orga006) {
		this.orga006 = orga006;
	}

	public Long getOrga007() {
		return orga007;
	}

	public void setOrga007(Long orga007) {
		this.orga007 = orga007;
	}

	public Long getOrga008() {
		return orga008;
	}

	public void setOrga008(Long orga008) {
		this.orga008 = orga008;
	}

	public String getOrga009() {
		return orga009;
	}

	public void setOrga009(String orga009) {
		this.orga009 = orga009;
	}

	public Long getOrga010() {
		return orga010;
	}

	public void setOrga010(Long orga010) {
		this.orga010 = orga010;
	}

	public String getOrga011() {
		return orga011;
	}

	public void setOrga011(String orga011) {
		this.orga011 = orga011;
	}

	public String getOrga012() {
		return orga012;
	}

	public void setOrga012(String orga012) {
		this.orga012 = orga012;
	}

	public Long getOrga013() {
		return orga013;
	}

	public void setOrga013(Long orga013) {
		this.orga013 = orga013;
	}

	public Long getOrga014() {
		return orga014;
	}

	public void setOrga014(Long orga014) {
		this.orga014 = orga014;
	}

	public Date getOrga015() {
		return orga015;
	}

	public void setOrga015(Date orga015) {
		this.orga015 = orga015;
	}

	public String getOrga016() {
		return orga016;
	}

	public void setOrga016(String orga016) {
		this.orga016 = orga016;
	}

	public String getOrga017() {
		return orga017;
	}

	public void setOrga017(String orga017) {
		this.orga017 = orga017;
	}

	public String getOrga018() {
		return orga018;
	}

	public void setOrga018(String orga018) {
		this.orga018 = orga018;
	}

	public String getOrga019() {
		return orga019;
	}

	public void setOrga019(String orga019) {
		this.orga019 = orga019;
	}

	public Long getOrga020() {
		return orga020;
	}

	public void setOrga020(Long orga020) {
		this.orga020 = orga020;
	}

	public Long getOrga021() {
		return orga021;
	}

	public void setOrga021(Long orga021) {
		this.orga021 = orga021;
	}

	public Date getOrga022() {
		return orga022;
	}

	public void setOrga022(Date orga022) {
		this.orga022 = orga022;
	}

	public Date getOrga023() {
		return orga023;
	}

	public void setOrga023(Date orga023) {
		this.orga023 = orga023;
	}

	@Override
	protected Serializable pkVal() {
		return this.orga001;
	}

	public String getOrga024() {
		return orga024;
	}

	public void setOrga024(String orga024) {
		this.orga024 = orga024;
	}

	public String getOrga025() {
		return orga025;
	}

	public void setOrga025(String orga025) {
		this.orga025 = orga025;
	}

	public String getOrga026() {
		return orga026;
	}

	public void setOrga026(String orga026) {
		this.orga026 = orga026;
	}

	public String getLeac001() {
		return leac001;
	}

	public void setLeac001(String leac001) {
		this.leac001 = leac001;
	}

	public String getYcrs() {
		return ycrs;
	}

	public void setYcrs(String ycrs) {
		this.ycrs = ycrs;
	}

	public String getScrs() {
		return scrs;
	}

	public void setScrs(String scrs) {
		this.scrs = scrs;
	}

	public String getJyrs() {
		return jyrs;
	}

	public void setJyrs(String jyrs) {
		this.jyrs = jyrs;
	}

	public String getCxl() {
		return cxl;
	}

	public void setCxl(String cxl) {
		this.cxl = cxl;
	}

	public String getJyl() {
		return jyl;
	}

	public void setJyl(String jyl) {
		this.jyl = jyl;
	}

	public String getZxs() {
		return zxs;
	}

	public void setZxs(String zxs) {
		this.zxs = zxs;
	}

	public String getPjxs() {
		return pjxs;
	}

	public void setPjxs(String pjxs) {
		this.pjxs = pjxs;
	}

	public Integer getChildcount() {
		return childcount;
	}

	public void setChildcount(Integer childcount) {
		this.childcount = childcount;
	}

	public String getSelectJobId() {
		return selectJobId;
	}

	public void setSelectJobId(String selectJobId) {
		this.selectJobId = selectJobId;
	}

	public String getSelectJobName() {
		return selectJobName;
	}

	public void setSelectJobName(String selectJobName) {
		this.selectJobName = selectJobName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMest003() {
		return mest003;
	}

	public void setMest003(String mest003) {
		this.mest003 = mest003;
	}

	public String getBmdw001() {
		return bmdw001;
	}

	public void setBmdw001(String bmdw001) {
		this.bmdw001 = bmdw001;
	}

}

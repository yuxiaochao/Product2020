package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author yuxiaochao
 * @since 2019-01-05
 */
@TableName("HRSW_T_DOCUMENTARYREPORT")
public class HrswTDocumentaryreport extends Model<HrswTDocumentaryreport> {

    private static final long serialVersionUID = 1L;

	@TableField("DORE001")
	private String dore001;
    /**
     * 流水单号(年月日+4位流水号)
     */
	@TableField("DORE002")
	private String dore002;
    /**
     * 纪实填报人id
     */
	@TableField("DORE003")
	private String dore003;
    /**
     * 上报时间
     */
	@TableField("DORE004")
	private Date dore004;
    /**
     * 初审人ID
     */
	@TableField("DORE005")
	private String dore005;
    /**
     *   初审时间
     */
	@TableField("DORE006")
	private Date dore006;
    /**
     *   初审结果(0：待审核；1：未通过；2：通过)
     */
	@TableField("DORE007")
	private Integer dore007;
    /**
     *   初审审核意见
     */
	@TableField("DORE008")
	private String dore008;
    /**
     *   复审人ID
     */
	@TableField("DORE009")
	private String dore009;
    /**
     * 复审时间
     */
	@TableField("DORE010")
	private Date dore010;
    /**
     *   复审结果(0：待审核；1：未通过；2：通过)
     */
	@TableField("DORE011")
	private Integer dore011;
    /**
     *   复审审核意见
     */
	@TableField("DORE012")
	private String dore012;
    /**
     * 最终结果(0：待审；1：未通过；2：已通过)
     */
	@TableField("DORE013")
	private Integer dore013;
	/**
     *纪实任务id
     */
	@TableField("DORE014")
	private String dore014;
	/**
     *上报状态（0已上报 1待上报）
     */
	@TableField("DORE015")
	private Integer dore015;

	public Integer getDore015() {
		return dore015;
	}

	public void setDore015(Integer dore015) {
		this.dore015 = dore015;
	}

	public String getDore014() {
		return dore014;
	}

	public void setDore014(String dore014) {
		this.dore014 = dore014;
	}

	public String getDore001() {
		return dore001;
	}

	public void setDore001(String dore001) {
		this.dore001 = dore001;
	}

	public String getDore002() {
		return dore002;
	}

	public void setDore002(String dore002) {
		this.dore002 = dore002;
	}

	public String getDore003() {
		return dore003;
	}

	public void setDore003(String dore003) {
		this.dore003 = dore003;
	}

	public Date getDore004() {
		return dore004;
	}

	public void setDore004(Date dore004) {
		this.dore004 = dore004;
	}

	public String getDore005() {
		return dore005;
	}

	public void setDore005(String dore005) {
		this.dore005 = dore005;
	}

	public Date getDore006() {
		return dore006;
	}

	public void setDore006(Date dore006) {
		this.dore006 = dore006;
	}

	public Integer getDore007() {
		return dore007;
	}

	public void setDore007(Integer dore007) {
		this.dore007 = dore007;
	}

	public String getDore008() {
		return dore008;
	}

	public void setDore008(String dore008) {
		this.dore008 = dore008;
	}

	public String getDore009() {
		return dore009;
	}

	public void setDore009(String dore009) {
		this.dore009 = dore009;
	}

	public Date getDore010() {
		return dore010;
	}

	public void setDore010(Date dore010) {
		this.dore010 = dore010;
	}

	public Integer getDore011() {
		return dore011;
	}

	public void setDore011(Integer dore011) {
		this.dore011 = dore011;
	}

	public String getDore012() {
		return dore012;
	}

	public void setDore012(String dore012) {
		this.dore012 = dore012;
	}

	public Integer getDore013() {
		return dore013;
	}

	public void setDore013(Integer dore013) {
		this.dore013 = dore013;
	}

	@Override
	protected Serializable pkVal() {
		return this.dore001;
	}

	@Override
	public String toString() {
		return "HrswTDocumentaryreport{" +
			"dore001=" + dore001 +
			", dore002=" + dore002 +
			", dore003=" + dore003 +
			", dore004=" + dore004 +
			", dore005=" + dore005 +
			", dore006=" + dore006 +
			", dore007=" + dore007 +
			", dore008=" + dore008 +
			", dore009=" + dore009 +
			", dore010=" + dore010 +
			", dore011=" + dore011 +
			", dore012=" + dore012 +
			", dore013=" + dore013 +
			"}";
	}
}

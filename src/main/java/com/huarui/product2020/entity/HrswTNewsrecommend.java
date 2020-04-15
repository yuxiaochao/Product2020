package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 新闻推荐表
 * </p>
 *
 * @author Chenrui
 * @since 2017-08-13
 */
@TableName("HRSW_T_NEWSRECOMMEND")
public class HrswTNewsrecommend extends Model<HrswTNewsrecommend> {

    private static final long serialVersionUID = 1L;

    @TableId("NERE001")
	private String nere001;
    /**
     * 新闻ID
     */
	@TableField("NERE002")
	private String nere002;
    /**
     * 推荐人ID
     */
	@TableField("NERE003")
	private String nere003;
    /**
     * 推荐时间
     */
	@TableField("NERE004")
	private Date nere004;
    /**
     * 审批人ID
     */
	@TableField("NERE005")
	private String nere005;
    /**
     * 审批时间
     */
	@TableField("NERE006")
	private Date nere006;
    /**
     * 审批状态:0、草稿（未通过） 1、已提交 2、已通过
     */
	@TableField("NERE007")
	private Integer nere007;


	public String getNere001() {
		return nere001;
	}

	public void setNere001(String nere001) {
		this.nere001 = nere001;
	}

	public String getNere002() {
		return nere002;
	}

	public void setNere002(String nere002) {
		this.nere002 = nere002;
	}

	public String getNere003() {
		return nere003;
	}

	public void setNere003(String nere003) {
		this.nere003 = nere003;
	}

	public Date getNere004() {
		return nere004;
	}

	public void setNere004(Date nere004) {
		this.nere004 = nere004;
	}

	public String getNere005() {
		return nere005;
	}

	public void setNere005(String nere005) {
		this.nere005 = nere005;
	}

	public Date getNere006() {
		return nere006;
	}

	public void setNere006(Date nere006) {
		this.nere006 = nere006;
	}

	public Integer getNere007() {
		return nere007;
	}

	public void setNere007(Integer nere007) {
		this.nere007 = nere007;
	}

	@Override
	protected Serializable pkVal() {
		return this.nere001;
	}

}

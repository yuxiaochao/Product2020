package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * ${table.comment}
 * </p>
 *
 * @author Chenrui
 * @since 2017-08-13
 */
@TableName("HRSW_T_NEWSUSER")
public class HrswTNewsuser extends Model<HrswTNewsuser> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("NEUS001")
	private String neus001;
    /**
     * 新闻ID
     */
	@TableField("NEUS002")
	private String neus002;
    /**
     * 发布机构ID
     */
	@TableField("NEUS003")
	private String neus003;
    /**
     * 发布用户ID
     */
	@TableField("NEUS004")
	private String neus004;
    /**
     * 发布群组ID
     */
	@TableField("NEUS005")
	private String neus005;
    /**
     * 发布岗位ID
     */
	@TableField("NEUS006")
	private String neus006;
    /**
     * 发布类型
0：全体
1：机构
2：学员
3：群组
4：岗位序列
     */
	@TableField("NEUS007")
	private Integer neus007;


	public String getNeus001() {
		return neus001;
	}

	public void setNeus001(String neus001) {
		this.neus001 = neus001;
	}

	public String getNeus002() {
		return neus002;
	}

	public void setNeus002(String neus002) {
		this.neus002 = neus002;
	}

	public String getNeus003() {
		return neus003;
	}

	public void setNeus003(String neus003) {
		this.neus003 = neus003;
	}

	public String getNeus004() {
		return neus004;
	}

	public void setNeus004(String neus004) {
		this.neus004 = neus004;
	}

	public String getNeus005() {
		return neus005;
	}

	public void setNeus005(String neus005) {
		this.neus005 = neus005;
	}

	public String getNeus006() {
		return neus006;
	}

	public void setNeus006(String neus006) {
		this.neus006 = neus006;
	}

	public Integer getNeus007() {
		return neus007;
	}

	public void setNeus007(Integer neus007) {
		this.neus007 = neus007;
	}

	@Override
	protected Serializable pkVal() {
		return this.neus001;
	}

}

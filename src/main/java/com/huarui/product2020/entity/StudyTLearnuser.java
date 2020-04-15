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
@TableName("STUDY_T_LEARNUSER")
public class StudyTLearnuser extends Model<StudyTLearnuser> {

    private static final long serialVersionUID = 1L;

    @TableId("LEUS001")
	private String leus001;
	@TableField("LEUS002")
	private String leus002;
	@TableField("LEUS003")
	private String leus003;
	@TableField("LEUS004")
	private String leus004;
	@TableField("LEUS005")
	private String leus005;
	@TableField("LEUS006")
	private String leus006;
    /**
     * 船舶ID
     */
	@TableField("LEUS007")
	private String leus007;
    /**
     * 类型
1：机构
2：学员
3：群组
4：岗位序列
5：船舶
     */
	@TableField("LEUS008")
	private Integer leus008;


	public String getLeus001() {
		return leus001;
	}

	public void setLeus001(String leus001) {
		this.leus001 = leus001;
	}

	public String getLeus002() {
		return leus002;
	}

	public void setLeus002(String leus002) {
		this.leus002 = leus002;
	}

	public String getLeus003() {
		return leus003;
	}

	public void setLeus003(String leus003) {
		this.leus003 = leus003;
	}

	public String getLeus004() {
		return leus004;
	}

	public void setLeus004(String leus004) {
		this.leus004 = leus004;
	}

	public String getLeus005() {
		return leus005;
	}

	public void setLeus005(String leus005) {
		this.leus005 = leus005;
	}

	public String getLeus006() {
		return leus006;
	}

	public void setLeus006(String leus006) {
		this.leus006 = leus006;
	}

	public String getLeus007() {
		return leus007;
	}

	public void setLeus007(String leus007) {
		this.leus007 = leus007;
	}

	public Integer getLeus008() {
		return leus008;
	}

	public void setLeus008(Integer leus008) {
		this.leus008 = leus008;
	}

	@Override
	protected Serializable pkVal() {
		return this.leus001;
	}

}

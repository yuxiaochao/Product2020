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
@TableName("EXAM_T_EXERUSER")
public class ExamTExeruser extends Model<ExamTExeruser> {

    private static final long serialVersionUID = 1L;

    @TableId("EXUS001")
	private String exus001;
    /**
     * 练习ID
     */
	@TableField("EXUS002")
	private String exus002;
    /**
     * 机构ID
     */
	@TableField("EXUS003")
	private String exus003;
    /**
     * 学员ID
     */
	@TableField("EXUS004")
	private String exus004;
    /**
     * 群组ID
     */
	@TableField("EXUS005")
	private String exus005;
    /**
     * 职务ID
     */
	@TableField("EXUS006")
	private String exus006;


	public String getExus001() {
		return exus001;
	}

	public void setExus001(String exus001) {
		this.exus001 = exus001;
	}

	public String getExus002() {
		return exus002;
	}

	public void setExus002(String exus002) {
		this.exus002 = exus002;
	}

	public String getExus003() {
		return exus003;
	}

	public void setExus003(String exus003) {
		this.exus003 = exus003;
	}

	public String getExus004() {
		return exus004;
	}

	public void setExus004(String exus004) {
		this.exus004 = exus004;
	}

	public String getExus005() {
		return exus005;
	}

	public void setExus005(String exus005) {
		this.exus005 = exus005;
	}

	public String getExus006() {
		return exus006;
	}

	public void setExus006(String exus006) {
		this.exus006 = exus006;
	}

	@Override
	protected Serializable pkVal() {
		return this.exus001;
	}

}

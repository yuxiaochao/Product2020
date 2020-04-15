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
@TableName("EXAM_T_BASETX")
public class ExamTBasetx extends Model<ExamTBasetx> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("BTX001")
	private String btx001;
    /**
     * 题型标题
     */
	@TableField("BTX002")
	private String btx002;
    /**
     * 基本题型 
0――填空题
1――单选题
2――多选题
3――判断题
4――问答题
5――组合题
6——优选题
     */
	@TableField("BTX003")
	private Long btx003;
    /**
     * 缺省分值
     */
	@TableField("BTX004")
	private Float btx004;
    /**
     * 备注说明
     */
	@TableField("BTX005")
	private String btx005;
    /**
     * 二级机构ID
     */
	@TableField("BTX006")
	private String btx006;
    /**
     * 题型序号
     */
	@TableField("BTX007")
	private Long btx007;


	public String getBtx001() {
		return btx001;
	}

	public void setBtx001(String btx001) {
		this.btx001 = btx001;
	}

	public String getBtx002() {
		return btx002;
	}

	public void setBtx002(String btx002) {
		this.btx002 = btx002;
	}

	public Long getBtx003() {
		return btx003;
	}

	public void setBtx003(Long btx003) {
		this.btx003 = btx003;
	}

	public Float getBtx004() {
		return btx004;
	}

	public void setBtx004(Float btx004) {
		this.btx004 = btx004;
	}

	public String getBtx005() {
		return btx005;
	}

	public void setBtx005(String btx005) {
		this.btx005 = btx005;
	}

	public String getBtx006() {
		return btx006;
	}

	public void setBtx006(String btx006) {
		this.btx006 = btx006;
	}

	public Long getBtx007() {
		return btx007;
	}

	public void setBtx007(Long btx007) {
		this.btx007 = btx007;
	}

	@Override
	protected Serializable pkVal() {
		return this.btx001;
	}

}

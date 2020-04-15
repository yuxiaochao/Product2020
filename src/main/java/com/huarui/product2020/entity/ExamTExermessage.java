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
@TableName("EXAM_T_EXERMESSAGE")
public class ExamTExermessage extends Model<ExamTExermessage> {

    private static final long serialVersionUID = 1L;

    @TableId("EMES001")
	private String emes001;
    /**
     * 用户id
     */
	@TableField("EMES002")
	private String emes002;
    /**
     * 试题id
     */
	@TableField("EMES003")
	private String emes003;
    /**
     * 评论内容
     */
	@TableField("EMES004")
	private String emes004;
    /**
     * 评论时间
     */
	@TableField("EMES005")
	private Date emes005;
    /**
     * 父ID
     */
	@TableField("EMES006")
	private String emes006;
	
	/**
     * 回复方式 1、点赞 2、回复
     */
	@TableField("EMES007")
	private int emes007;


	public String getEmes001() {
		return emes001;
	}

	public void setEmes001(String emes001) {
		this.emes001 = emes001;
	}

	public String getEmes002() {
		return emes002;
	}

	public void setEmes002(String emes002) {
		this.emes002 = emes002;
	}

	public String getEmes003() {
		return emes003;
	}

	public void setEmes003(String emes003) {
		this.emes003 = emes003;
	}

	public String getEmes004() {
		return emes004;
	}

	public void setEmes004(String emes004) {
		this.emes004 = emes004;
	}

	public Date getEmes005() {
		return emes005;
	}

	public void setEmes005(Date emes005) {
		this.emes005 = emes005;
	}

	public String getEmes006() {
		return emes006;
	}

	public void setEmes006(String emes006) {
		this.emes006 = emes006;
	}

	
	public int getEmes007() {
		return emes007;
	}

	public void setEmes007(int emes007) {
		this.emes007 = emes007;
	}

	@Override
	protected Serializable pkVal() {
		return this.emes001;
	}

}

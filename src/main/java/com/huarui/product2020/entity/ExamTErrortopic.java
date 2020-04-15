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
@TableName("EXAM_T_ERRORTOPIC")
public class ExamTErrortopic extends Model<ExamTErrortopic> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键：PK
     */
    @TableId("ERTO001")
	private String erto001;
    /**
     * 试题ID
     */
	@TableField("ERTO002")
	private String erto002;
    /**
     * 用户ID
     */
	@TableField("ERTO003")
	private String erto003;
    /**
     * 试题来源：题库练习 2、模拟练习
     */
	@TableField("ERTO004")
	private Integer erto004;
    /**
     * 加入时间
     */
	@TableField("ERTO005")
	private Date erto005;


	public String getErto001() {
		return erto001;
	}

	public void setErto001(String erto001) {
		this.erto001 = erto001;
	}

	public String getErto002() {
		return erto002;
	}

	public void setErto002(String erto002) {
		this.erto002 = erto002;
	}

	public String getErto003() {
		return erto003;
	}

	public void setErto003(String erto003) {
		this.erto003 = erto003;
	}

	public Integer getErto004() {
		return erto004;
	}

	public void setErto004(Integer erto004) {
		this.erto004 = erto004;
	}


	public Date getErto005() {
		return erto005;
	}

	public void setErto005(Date erto005) {
		this.erto005 = erto005;
	}

	@Override
	protected Serializable pkVal() {
		return this.erto001;
	}

}

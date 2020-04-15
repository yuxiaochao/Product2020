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
@TableName("EXAM_T_EXERSUBJECT")
public class ExamTExersubject extends Model<ExamTExersubject> {

    private static final long serialVersionUID = 1L;

    @TableId("EXSU001")
	private String exsu001;
    /**
     * 练习ID
     */
	@TableField("EXSU002")
	private String exsu002;
    /**
     * 题库ID
     */
	@TableField("EXSU003")
	private String exsu003;


	public String getExsu001() {
		return exsu001;
	}

	public void setExsu001(String exsu001) {
		this.exsu001 = exsu001;
	}

	public String getExsu002() {
		return exsu002;
	}

	public void setExsu002(String exsu002) {
		this.exsu002 = exsu002;
	}

	public String getExsu003() {
		return exsu003;
	}

	public void setExsu003(String exsu003) {
		this.exsu003 = exsu003;
	}

	@Override
	protected Serializable pkVal() {
		return this.exsu001;
	}

}

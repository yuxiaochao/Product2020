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
@TableName("STUDY_T_LEARNTHEME")
public class StudyTLearntheme extends Model<StudyTLearntheme> {

    private static final long serialVersionUID = 1L;

    @TableId("LTHE001")
	private String lthe001;
	@TableField("LTHE002")
	private String lthe002;
	@TableField("LTHE003")
	private String lthe003;


	public String getLthe001() {
		return lthe001;
	}

	public void setLthe001(String lthe001) {
		this.lthe001 = lthe001;
	}

	public String getLthe002() {
		return lthe002;
	}

	public void setLthe002(String lthe002) {
		this.lthe002 = lthe002;
	}

	public String getLthe003() {
		return lthe003;
	}

	public void setLthe003(String lthe003) {
		this.lthe003 = lthe003;
	}

	@Override
	protected Serializable pkVal() {
		return this.lthe001;
	}

}

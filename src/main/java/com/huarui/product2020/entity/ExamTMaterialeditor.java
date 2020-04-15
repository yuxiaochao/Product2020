package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
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
@TableName("EXAM_T_MATERIALEDITOR")
public class ExamTMaterialeditor extends Model<ExamTMaterialeditor> {

    private static final long serialVersionUID = 1L;

	@TableField("MAED001")
	private String maed001;
	@TableField("MAED002")
	private String maed002;
	@TableField("MAED003")
	private String maed003;


	public String getMaed001() {
		return maed001;
	}

	public void setMaed001(String maed001) {
		this.maed001 = maed001;
	}

	public String getMaed002() {
		return maed002;
	}

	public void setMaed002(String maed002) {
		this.maed002 = maed002;
	}

	public String getMaed003() {
		return maed003;
	}

	public void setMaed003(String maed003) {
		this.maed003 = maed003;
	}

	@Override
	protected Serializable pkVal() {
		return this.maed001;
	}

}

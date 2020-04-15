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
@TableName("EXAM_T_TOPICCATALOG")
public class ExamTTopiccatalog extends Model<ExamTTopiccatalog> {

    private static final long serialVersionUID = 1L;

    @TableId("TCAT001")
	private String tcat001;
    /**
     * 试题ID
     */
	@TableField("TCAT002")
	private String tcat002;
    /**
     * 目录ID
     */
	@TableField("TCAT003")
	private String tcat003;


	public String getTcat001() {
		return tcat001;
	}

	public void setTcat001(String tcat001) {
		this.tcat001 = tcat001;
	}

	public String getTcat002() {
		return tcat002;
	}

	public void setTcat002(String tcat002) {
		this.tcat002 = tcat002;
	}

	public String getTcat003() {
		return tcat003;
	}

	public void setTcat003(String tcat003) {
		this.tcat003 = tcat003;
	}

	@Override
	protected Serializable pkVal() {
		return this.tcat001;
	}

}

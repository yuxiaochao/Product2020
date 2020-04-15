package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author panlei
 * @since 2018-05-22
 */
@TableName("EXAM_T_TRAINUSER")
public class ExamTTrainuser extends Model<ExamTTrainuser> {

    private static final long serialVersionUID = 1L;

    /**
     * PK
     */
    @TableId("EXTU001")
	private String extu001;
    /**
     * 训练ID
     */
	@TableField("EXTU002")
	private String extu002;
    /**
     * 机构ID
     */
	@TableField("EXTU003")
	private String extu003;
    /**
     * 学员ID
     */
	@TableField("EXTU004")
	private String extu004;
    /**
     * 群组ID
     */
	@TableField("EXTU005")
	private String extu005;
    /**
     * 岗位序列ID
     */
	@TableField("EXTU006")
	private String extu006;


	public String getExtu001() {
		return extu001;
	}

	public void setExtu001(String extu001) {
		this.extu001 = extu001;
	}

	public String getExtu002() {
		return extu002;
	}

	public void setExtu002(String extu002) {
		this.extu002 = extu002;
	}

	public String getExtu003() {
		return extu003;
	}

	public void setExtu003(String extu003) {
		this.extu003 = extu003;
	}

	public String getExtu004() {
		return extu004;
	}

	public void setExtu004(String extu004) {
		this.extu004 = extu004;
	}

	public String getExtu005() {
		return extu005;
	}

	public void setExtu005(String extu005) {
		this.extu005 = extu005;
	}

	public String getExtu006() {
		return extu006;
	}

	public void setExtu006(String extu006) {
		this.extu006 = extu006;
	}

	@Override
	protected Serializable pkVal() {
		return this.extu001;
	}

	@Override
	public String toString() {
		return "ExamTTrainuser{" +
			"extu001=" + extu001 +
			", extu002=" + extu002 +
			", extu003=" + extu003 +
			", extu004=" + extu004 +
			", extu005=" + extu005 +
			", extu006=" + extu006 +
			"}";
	}
}

package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author Administrator
 * @since 2019-09-04
 */
@TableName("HR_T_EDUCATIONAL")
public class HrTEducational extends Model<HrTEducational> {

    private static final long serialVersionUID = 1L;

    @TableId("EDUC001")
	private String educ001;
    /**
     * 人员ID
     */
	@TableField("EDUC002")
	private String educ002;
    /**
     * 毕业学校
     */
	@TableField("EDUC003")
	private String educ003;
    /**
     * 专业
     */
	@TableField("EDUC004")
	private String educ004;
    /**
     * 最高学历
     */
	@TableField("EDUC005")
	private String educ005;
	
	@TableField(exist = false)
	private String educ005n;
	
    /**
     * 毕业时间
     */
	@TableField("EDUC006")
	private Date educ006;
    /**
     * 毕业证书（地址）
     */
	@TableField("EDUC007")
	private String educ007;


	public String getEduc001() {
		return educ001;
	}

	public void setEduc001(String educ001) {
		this.educ001 = educ001;
	}

	public String getEduc002() {
		return educ002;
	}

	public void setEduc002(String educ002) {
		this.educ002 = educ002;
	}

	public String getEduc003() {
		return educ003;
	}

	public void setEduc003(String educ003) {
		this.educ003 = educ003;
	}

	public String getEduc004() {
		return educ004;
	}

	public void setEduc004(String educ004) {
		this.educ004 = educ004;
	}

	public String getEduc005() {
		return educ005;
	}

	public void setEduc005(String educ005) {
		this.educ005 = educ005;
	}

	public Date getEduc006() {
		return educ006;
	}

	public void setEduc006(Date educ006) {
		this.educ006 = educ006;
	}

	public String getEduc007() {
		return educ007;
	}

	public void setEduc007(String educ007) {
		this.educ007 = educ007;
	}

	@Override
	protected Serializable pkVal() {
		return this.educ001;
	}

	public String getEduc005n() {
		return educ005n;
	}

	public void setEduc005n(String educ005n) {
		this.educ005n = educ005n;
	}

	@Override
	public String toString() {
		return "HrTEducational{" +
			"educ001=" + educ001 +
			", educ002=" + educ002 +
			", educ003=" + educ003 +
			", educ004=" + educ004 +
			", educ005=" + educ005 +
			", educ006=" + educ006 +
			", educ007=" + educ007 +
			"}";
	}
}

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
 * @since 2018-10-17
 */
@TableName("HRSW_T_DUTYLABELRELATION")
public class HrswTDutylabelrelation extends Model<HrswTDutylabelrelation> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId("DLRE001")
	private String dlre001;
    /**
     * 岗位表id
     */
	@TableField("DLRE002")
	private String dlre002;
    /**
     * 标签表id
     */
	@TableField("DLRE003")
	private String dlre003;


	public String getDlre001() {
		return dlre001;
	}

	public void setDlre001(String dlre001) {
		this.dlre001 = dlre001;
	}

	public String getDlre002() {
		return dlre002;
	}

	public void setDlre002(String dlre002) {
		this.dlre002 = dlre002;
	}

	public String getDlre003() {
		return dlre003;
	}

	public void setDlre003(String dlre003) {
		this.dlre003 = dlre003;
	}

	@Override
	protected Serializable pkVal() {
		return this.dlre001;
	}

	@Override
	public String toString() {
		return "HrswTDutylabelrelation{" +
			"dlre001=" + dlre001 +
			", dlre002=" + dlre002 +
			", dlre003=" + dlre003 +
			"}";
	}
}

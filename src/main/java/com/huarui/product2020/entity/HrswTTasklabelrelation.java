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
@TableName("HRSW_T_TASKLABELRELATION")
public class HrswTTasklabelrelation extends Model<HrswTTasklabelrelation> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId("TLRE001")
	private String tlre001;
    /**
     * 日程任务id
     */
	@TableField("TLRE002")
	private String tlre002;
    /**
     * 标签id
     */
	@TableField("TLRE003")
	private String tlre003;


	public String getTlre001() {
		return tlre001;
	}

	public void setTlre001(String tlre001) {
		this.tlre001 = tlre001;
	}

	public String getTlre002() {
		return tlre002;
	}

	public void setTlre002(String tlre002) {
		this.tlre002 = tlre002;
	}

	public String getTlre003() {
		return tlre003;
	}

	public void setTlre003(String tlre003) {
		this.tlre003 = tlre003;
	}

	@Override
	protected Serializable pkVal() {
		return this.tlre001;
	}

	@Override
	public String toString() {
		return "HrswTTasklabelrelation{" +
			"tlre001=" + tlre001 +
			", tlre002=" + tlre002 +
			", tlre003=" + tlre003 +
			"}";
	}
}

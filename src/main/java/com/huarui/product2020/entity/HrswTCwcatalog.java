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
@TableName("HRSW_T_CWCATALOG")
public class HrswTCwcatalog extends Model<HrswTCwcatalog> {

    private static final long serialVersionUID = 1L;

    @TableId("CWCA001")
	private String cwca001;
	@TableField("CWCA002")
	private String cwca002;
	@TableField("CWCA003")
	private String cwca003;


	public String getCwca001() {
		return cwca001;
	}

	public void setCwca001(String cwca001) {
		this.cwca001 = cwca001;
	}

	public String getCwca002() {
		return cwca002;
	}

	public void setCwca002(String cwca002) {
		this.cwca002 = cwca002;
	}

	public String getCwca003() {
		return cwca003;
	}

	public void setCwca003(String cwca003) {
		this.cwca003 = cwca003;
	}

	@Override
	protected Serializable pkVal() {
		return this.cwca001;
	}

}

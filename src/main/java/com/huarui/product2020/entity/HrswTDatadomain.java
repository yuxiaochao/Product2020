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
@TableName("HRSW_T_DATADOMAIN")
public class HrswTDatadomain extends Model<HrswTDatadomain> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("DDOM001")
	private String ddom001;
    /**
     * 用户权限分配id
     */
	@TableField("DDOM002")
	private String ddom002;
    /**
     * 机构id
     */
	@TableField("DDOM003")
	private String ddom003;


	public String getDdom001() {
		return ddom001;
	}

	public void setDdom001(String ddom001) {
		this.ddom001 = ddom001;
	}

	public String getDdom002() {
		return ddom002;
	}

	public void setDdom002(String ddom002) {
		this.ddom002 = ddom002;
	}

	public String getDdom003() {
		return ddom003;
	}

	public void setDdom003(String ddom003) {
		this.ddom003 = ddom003;
	}

	@Override
	protected Serializable pkVal() {
		return this.ddom001;
	}

}

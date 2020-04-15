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
@TableName("HRSW_T_ROLEPURVIEW")
public class HrswTRolepurview extends Model<HrswTRolepurview> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("RPUR001")
	private String rpur001;
    /**
     * 角色id
     */
	@TableField("RPUR002")
	private String rpur002;
    /**
     * 功能模块id
     */
	@TableField("RPUR003")
	private String rpur003;


	public String getRpur001() {
		return rpur001;
	}

	public void setRpur001(String rpur001) {
		this.rpur001 = rpur001;
	}

	public String getRpur002() {
		return rpur002;
	}

	public void setRpur002(String rpur002) {
		this.rpur002 = rpur002;
	}

	public String getRpur003() {
		return rpur003;
	}

	public void setRpur003(String rpur003) {
		this.rpur003 = rpur003;
	}

	@Override
	protected Serializable pkVal() {
		return this.rpur001;
	}

}

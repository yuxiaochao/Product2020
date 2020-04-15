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
 * @author panlei
 * @since 2018-10-17
 */
@TableName("HRSW_T_TAGLIBRARY")
public class HrswTTaglibrary extends Model<HrswTTaglibrary> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId("TALI001")
	private String tali001;
    /**
     * 标签名称
     */
	@TableField("TALI002")
	private String tali002;
    /**
     * 创建时间
     */
	@TableField("TALI003")
	private Date tali003;
    /**
     * 创建人id
     */
	@TableField("TALI004")
	private String tali004;


	public String getTali001() {
		return tali001;
	}

	public void setTali001(String tali001) {
		this.tali001 = tali001;
	}

	public String getTali002() {
		return tali002;
	}

	public void setTali002(String tali002) {
		this.tali002 = tali002;
	}

	public Date getTali003() {
		return tali003;
	}

	public void setTali003(Date tali003) {
		this.tali003 = tali003;
	}

	public String getTali004() {
		return tali004;
	}

	public void setTali004(String tali004) {
		this.tali004 = tali004;
	}

	@Override
	protected Serializable pkVal() {
		return this.tali001;
	}

	@Override
	public String toString() {
		return "HrswTTaglibrary{" +
			"tali001=" + tali001 +
			", tali002=" + tali002 +
			", tali003=" + tali003 +
			", tali004=" + tali004 +
			"}";
	}
}

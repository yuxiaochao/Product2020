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
 * @since 2017-09-05
 */
@TableName("HRSW_T_APPLYFOR")
public class HrswTApplyfor extends Model<HrswTApplyfor> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("APPL001")
	private String appl001;
    /**
     * 申请人id
     */
	@TableField("APPL002")
	private String appl002;
    /**
     * 接收人id
     */
	@TableField("APPL003")
	private String appl003;
    /**
     * 申请时间
     */
	@TableField("APPL004")
	private Date appl004;
    /**
     * 状态（0:待验证 1:同意 2:不同意 3:已拒绝）
     */
	@TableField("APPL005")
	private int appl005;


	
	
	public String getAppl001() {
		return appl001;
	}




	public void setAppl001(String appl001) {
		this.appl001 = appl001;
	}




	public String getAppl002() {
		return appl002;
	}




	public void setAppl002(String appl002) {
		this.appl002 = appl002;
	}




	public String getAppl003() {
		return appl003;
	}




	public void setAppl003(String appl003) {
		this.appl003 = appl003;
	}




	public Date getAppl004() {
		return appl004;
	}




	public void setAppl004(Date appl004) {
		this.appl004 = appl004;
	}




	public int getAppl005() {
		return appl005;
	}




	public void setAppl005(int appl005) {
		this.appl005 = appl005;
	}




	@Override
	public String toString() {
		return "HrswTApplyfor{" +
			"appl001=" + appl001 +
			", appl002=" + appl002 +
			", appl003=" + appl003 +
			", appl004=" + appl004 +
			", appl005=" + appl005 +
			"}";
	}

	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return this.appl001;
	}
	
	
}

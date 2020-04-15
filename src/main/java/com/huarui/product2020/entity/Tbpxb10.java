package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yuxiaochao
 * @since 2019-10-25
 */
public class Tbpxb10 extends Model<Tbpxb10> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("PXB1001")
	private String pxb1001;
    /**
     * 培训班ID
     */
	@TableField("PXB1002")
	private String pxb1002;
    /**
     * 考试要求-1ID
     */
	@TableField("PXB1003")
	private String pxb1003;
    /**
     * 课程ID
     */
	@TableField("PXB1004")
	private String pxb1004;


	public String getPxb1001() {
		return pxb1001;
	}

	public void setPxb1001(String pxb1001) {
		this.pxb1001 = pxb1001;
	}

	public String getPxb1002() {
		return pxb1002;
	}

	public void setPxb1002(String pxb1002) {
		this.pxb1002 = pxb1002;
	}

	public String getPxb1003() {
		return pxb1003;
	}

	public void setPxb1003(String pxb1003) {
		this.pxb1003 = pxb1003;
	}

	public String getPxb1004() {
		return pxb1004;
	}

	public void setPxb1004(String pxb1004) {
		this.pxb1004 = pxb1004;
	}

	@Override
	protected Serializable pkVal() {
		return this.pxb1001;
	}

	@Override
	public String toString() {
		return "Tbpxb10{" +
			"pxb1001=" + pxb1001 +
			", pxb1002=" + pxb1002 +
			", pxb1003=" + pxb1003 +
			", pxb1004=" + pxb1004 +
			"}";
	}
}

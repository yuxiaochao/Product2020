package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author yuxiaochao
 * @since 2019-10-25
 */
public class Tbpxb06 extends Model<Tbpxb06> {

    private static final long serialVersionUID = 1L;
    
    @TableField(exist = false)
    private String num;

    /**
     * 主键
     */
    @TableId("PXB0601")
	private String pxb0601;
    
    /**
     * 培训班ID
     */
	@TableField("PXB0602")
	private String pxb0602;
	
    /**
     * 身份证号
     */
	@TableField("PXB0603")
	private String pxb0603;
	
    /**
     * 学号
     */
	@TableField("PXB0604")
	private String pxb0604;
	
    /**
     * 姓名
     */
	@TableField("PXB0605")
	private String pxb0605;
	
    /**
     * 性别
     */
	@TableField("PXB0606")
	private String pxb0606;
	
    /**
     * 工作单位
     */
	@TableField("PXB0607")
	private String pxb0607;
	
	
	/**
	 * 机构名称
	 */
	@TableField(exist = false)
	private String pxb0607n;
	
    /**
     * 职务
     */
	@TableField("PXB0608")
	private String pxb0608;
    /**
     * 手机号
     */
	@TableField("PXB0609")
	private String pxb0609;
    /**
     * 电子邮箱
     */
	@TableField("PXB0610")
	private String pxb0610;
	
	/**
	 * 学历
	 */
	@TableField("PXB0611")
	private String pxb0611;
	
	/**
	 * 参加工作时间
	 */
	@TableField("PXB0612")
	private Date pxb0612;
	
	/**
	 * 人员ID
	 */
	@TableField("PXB0613")
	private String pxb0613;


	public String getPxb0601() {
		return pxb0601;
	}

	public void setPxb0601(String pxb0601) {
		this.pxb0601 = pxb0601;
	}

	public String getPxb0602() {
		return pxb0602;
	}

	public void setPxb0602(String pxb0602) {
		this.pxb0602 = pxb0602;
	}

	public String getPxb0603() {
		return pxb0603;
	}

	public void setPxb0603(String pxb0603) {
		this.pxb0603 = pxb0603;
	}

	public String getPxb0604() {
		return pxb0604;
	}

	public void setPxb0604(String pxb0604) {
		this.pxb0604 = pxb0604;
	}

	public String getPxb0605() {
		return pxb0605;
	}

	public void setPxb0605(String pxb0605) {
		this.pxb0605 = pxb0605;
	}

	public String getPxb0606() {
		return pxb0606;
	}

	public void setPxb0606(String pxb0606) {
		this.pxb0606 = pxb0606;
	}

	public String getPxb0607() {
		return pxb0607;
	}

	public void setPxb0607(String pxb0607) {
		this.pxb0607 = pxb0607;
	}

	public String getPxb0608() {
		return pxb0608;
	}

	public void setPxb0608(String pxb0608) {
		this.pxb0608 = pxb0608;
	}

	public String getPxb0609() {
		return pxb0609;
	}

	public void setPxb0609(String pxb0609) {
		this.pxb0609 = pxb0609;
	}

	public String getPxb0610() {
		return pxb0610;
	}

	public void setPxb0610(String pxb0610) {
		this.pxb0610 = pxb0610;
	}
	

    public String getPxb0611() {
        return pxb0611;
    }

    public void setPxb0611(String pxb0611) {
        this.pxb0611 = pxb0611;
    }

    public Date getPxb0612() {
        return pxb0612;
    }

    public void setPxb0612(Date pxb0612) {
        this.pxb0612 = pxb0612;
    }

    public String getPxb0613() {
        return pxb0613;
    }

    public void setPxb0613(String pxb0613) {
        this.pxb0613 = pxb0613;
    }
    
    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getPxb0607n() {
        return pxb0607n;
    }

    public void setPxb0607n(String pxb0607n) {
        this.pxb0607n = pxb0607n;
    }

    @Override
	protected Serializable pkVal() {
		return this.pxb0601;
	}

    @Override
    public String toString() {
        return "Tbpxb06 [pxb0601=" + pxb0601 + ", pxb0602=" + pxb0602 + ", pxb0603=" + pxb0603 + ", pxb0604=" + pxb0604
                + ", pxb0605=" + pxb0605 + ", pxb0606=" + pxb0606 + ", pxb0607=" + pxb0607 + ", pxb0608=" + pxb0608
                + ", pxb0609=" + pxb0609 + ", pxb0610=" + pxb0610 + ", pxb0611=" + pxb0611 + ", pxb0612=" + pxb0612
                + ", pxb0613=" + pxb0613 + "]";
    }
	
}

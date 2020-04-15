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
 * @author panlei
 * @since 2020-02-18
 */
public class Tbgwc01 extends Model<Tbgwc01> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("GWC0101")
	private String gwc0101;
    /**
     * 用户ID
     */
	@TableField("GWC0102")
	private String gwc0102;
    /**
     *  创建时间
     */
	@TableField("GWC0103")
	private Date gwc0103;
    /**
     * 日志ID
     */
	@TableField("GWC0104")
	private String gwc0104;
    /**
     * 状态 1：正常；0：过期DEF（1），如清空购物车或已产生交易都置为0；
     */
	@TableField("GWC0105")
	private Double gwc0105;

	/**
	 * 代理机构id
	 * @return
	 */
	@TableField("GWC0106")
	private String gwc0106;
	
	/**
	 * 类别
	 * 0:学员  1:代理机构
	 * @return
	 */
	@TableField("GWC0107")
	private Double gwc0107;
	

	public String getGwc0101() {
		return gwc0101;
	}

	public void setGwc0101(String gwc0101) {
		this.gwc0101 = gwc0101;
	}

	public String getGwc0102() {
		return gwc0102;
	}

	public void setGwc0102(String gwc0102) {
		this.gwc0102 = gwc0102;
	}

	public Date getGwc0103() {
		return gwc0103;
	}

	public void setGwc0103(Date gwc0103) {
		this.gwc0103 = gwc0103;
	}

	public String getGwc0104() {
		return gwc0104;
	}

	public void setGwc0104(String gwc0104) {
		this.gwc0104 = gwc0104;
	}

	public Double getGwc0105() {
		return gwc0105;
	}

	public void setGwc0105(Double gwc0105) {
		this.gwc0105 = gwc0105;
	}

	
	
	public String getGwc0106() {
		return gwc0106;
	}

	public void setGwc0106(String gwc0106) {
		this.gwc0106 = gwc0106;
	}

	

	public Double getGwc0107() {
		return gwc0107;
	}

	public void setGwc0107(Double gwc0107) {
		this.gwc0107 = gwc0107;
	}

	@Override
	protected Serializable pkVal() {
		return this.gwc0101;
	}
	
	

	@Override
	public String toString() {
		return "Tbgwc01{" +
			"gwc0101=" + gwc0101 +
			", gwc0102=" + gwc0102 +
			", gwc0103=" + gwc0103 +
			", gwc0104=" + gwc0104 +
			", gwc0105=" + gwc0105 +
			", gwc0106=" + gwc0106 +
			", gwc0107=" + gwc0107 +
			"}";
	}
}

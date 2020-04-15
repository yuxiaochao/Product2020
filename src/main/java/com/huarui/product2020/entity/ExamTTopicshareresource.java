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
@TableName("EXAM_T_TOPICSHARERESOURCE")
public class ExamTTopicshareresource extends Model<ExamTTopicshareresource> {

    private static final long serialVersionUID = 1L;

    /**
     * PK
     */
    @TableId("TSRE001")
	private String tsre001;
    /**
     * 目录ID
     */
	@TableField("TSRE002")
	private String tsre002;
    /**
     * 试题ID
     */
	@TableField("TSRE003")
	private String tsre003;
    /**
     * 共享ID
     */
	@TableField("TSRE004")
	private String tsre004;
    /**
     * 资源类型 1、目录 2、试题
     */
	@TableField("TSRE005")
	private Double tsre005;


	public String getTsre001() {
		return tsre001;
	}

	public void setTsre001(String tsre001) {
		this.tsre001 = tsre001;
	}

	public String getTsre002() {
		return tsre002;
	}

	public void setTsre002(String tsre002) {
		this.tsre002 = tsre002;
	}

	public String getTsre003() {
		return tsre003;
	}

	public void setTsre003(String tsre003) {
		this.tsre003 = tsre003;
	}

	public String getTsre004() {
		return tsre004;
	}

	public void setTsre004(String tsre004) {
		this.tsre004 = tsre004;
	}

	public Double getTsre005() {
		return tsre005;
	}

	public void setTsre005(Double tsre005) {
		this.tsre005 = tsre005;
	}

	@Override
	protected Serializable pkVal() {
		return this.tsre001;
	}

}

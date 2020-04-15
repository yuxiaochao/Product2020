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
 * @author yuxiaochao
 * @since 2020-01-10
 */
@TableName("HRSW_T_GROUPPOOL")
public class HrswTGrouppool extends Model<HrswTGrouppool> {

    private static final long serialVersionUID = 1L;

    /**
     * 群组缓存id
     */
    @TableId("GRPO001")
	private String grpo001;
    /**
     * 创建时间
     */
	@TableField("GRPO002")
	private Date grpo002;
    /**
     * 最后拉取时间
     */
	@TableField("GRPO003")
	private Date grpo003;
    /**
     * 	组内用户id集合（以，隔开）
     */
	@TableField("GRPO004")
	private String grpo004;
    /**
     * 群组创建人
     */
	@TableField("GRPO005")
	private String grpo005;
    /**
     * (redis标号)groupPoolKey
     */
	@TableField("GRPO006")
	private String grpo006;


	public String getGrpo001() {
		return grpo001;
	}

	public void setGrpo001(String grpo001) {
		this.grpo001 = grpo001;
	}

	public Date getGrpo002() {
		return grpo002;
	}

	public void setGrpo002(Date grpo002) {
		this.grpo002 = grpo002;
	}

	public Date getGrpo003() {
		return grpo003;
	}

	public void setGrpo003(Date grpo003) {
		this.grpo003 = grpo003;
	}

	public String getGrpo004() {
		return grpo004;
	}

	public void setGrpo004(String grpo004) {
		this.grpo004 = grpo004;
	}

	public String getGrpo005() {
		return grpo005;
	}

	public void setGrpo005(String grpo005) {
		this.grpo005 = grpo005;
	}

	public String getGrpo006() {
		return grpo006;
	}

	public void setGrpo006(String grpo006) {
		this.grpo006 = grpo006;
	}

	@Override
	protected Serializable pkVal() {
		return this.grpo001;
	}

	@Override
	public String toString() {
		return "HrswTGrouppool{" +
			"grpo001=" + grpo001 +
			", grpo002=" + grpo002 +
			", grpo003=" + grpo003 +
			", grpo004=" + grpo004 +
			", grpo005=" + grpo005 +
			", grpo006=" + grpo006 +
			"}";
	}
}

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
@TableName("HRSW_T_MEETINGTASKMODIFY")
public class HrswTMeetingtaskmodify extends Model<HrswTMeetingtaskmodify> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId("MTMO001")
	private String mtmo001;
    /**
     * 会议id/任务id
     */
	@TableField("MTMO002")
	private String mtmo002;
    /**
     * 类型：1.会议 2.任务
     */
	@TableField("MTMO003")
	private Integer mtmo003;
    /**
     * 修改人id
     */
	@TableField("MTMO004")
	private String mtmo004;
    /**
     * 修改时间
     */
	@TableField("MTMO005")
	private Date mtmo005;
    /**
     * 修改内容
     */
	@TableField("MTMO006")
	private String mtmo006;


	public String getMtmo001() {
		return mtmo001;
	}

	public void setMtmo001(String mtmo001) {
		this.mtmo001 = mtmo001;
	}

	public String getMtmo002() {
		return mtmo002;
	}

	public void setMtmo002(String mtmo002) {
		this.mtmo002 = mtmo002;
	}

	public Integer getMtmo003() {
		return mtmo003;
	}

	public void setMtmo003(Integer mtmo003) {
		this.mtmo003 = mtmo003;
	}

	public String getMtmo004() {
		return mtmo004;
	}

	public void setMtmo004(String mtmo004) {
		this.mtmo004 = mtmo004;
	}

	public Date getMtmo005() {
		return mtmo005;
	}

	public void setMtmo005(Date mtmo005) {
		this.mtmo005 = mtmo005;
	}

	public String getMtmo006() {
		return mtmo006;
	}

	public void setMtmo006(String mtmo006) {
		this.mtmo006 = mtmo006;
	}

	@Override
	protected Serializable pkVal() {
		return this.mtmo001;
	}

	@Override
	public String toString() {
		return "HrswTMeetingtaskmodify{" +
			"mtmo001=" + mtmo001 +
			", mtmo002=" + mtmo002 +
			", mtmo003=" + mtmo003 +
			", mtmo004=" + mtmo004 +
			", mtmo005=" + mtmo005 +
			", mtmo006=" + mtmo006 +
			"}";
	}
}

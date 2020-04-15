package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author panlei
 * @since 2018-10-17
 */
@TableName("HRSW_T_MEETINGTASKPEOPLE")
public class HrswTMeetingtaskpeople extends Model<HrswTMeetingtaskpeople> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId("METP001")
	private String metp001;
    /**
     * 会议id/任务id
     */
	@TableField("METP002")
	private String metp002;
    /**
     * 类型：1.会议 2.任务
     */
	@TableField("METP003")
	private Integer metp003;
    /**
     * 人员类型：1.会议组织人 2.参会人 3.执行人 4.协助人 5.主管领导
     */
	@TableField("METP004")
	private Integer metp004;
    /**
     * 人员id
     */
	@TableField("METP005")
	private String metp005;


	public String getMetp001() {
		return metp001;
	}

	public void setMetp001(String metp001) {
		this.metp001 = metp001;
	}

	public String getMetp002() {
		return metp002;
	}

	public void setMetp002(String metp002) {
		this.metp002 = metp002;
	}

	public Integer getMetp003() {
		return metp003;
	}

	public void setMetp003(Integer metp003) {
		this.metp003 = metp003;
	}

	public Integer getMetp004() {
		return metp004;
	}

	public void setMetp004(Integer metp004) {
		this.metp004 = metp004;
	}

	public String getMetp005() {
		return metp005;
	}

	public void setMetp005(String metp005) {
		this.metp005 = metp005;
	}

	@Override
	protected Serializable pkVal() {
		return this.metp001;
	}

	@Override
	public String toString() {
		return "HrswTMeetingtaskpeople{" +
			"metp001=" + metp001 +
			", metp002=" + metp002 +
			", metp003=" + metp003 +
			", metp004=" + metp004 +
			", metp005=" + metp005 +
			"}";
	}
}

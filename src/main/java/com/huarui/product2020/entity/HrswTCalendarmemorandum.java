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
@TableName("HRSW_T_CALENDARMEMORANDUM")
public class HrswTCalendarmemorandum extends Model<HrswTCalendarmemorandum> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId("CAME001")
	private String came001;
    /**
     * 记事内容
     */
	@TableField("CAME002")
	private String came002;
    /**
     * 开始时间
     */
	@TableField("CAME003")
	private Date came003;
    /**
     * 结束时间
     */
	@TableField("CAME004")
	private Date came004;
    /**
     * 创建人
     */
	@TableField("CAME005")
	private String came005;
    /**
     * 创建时间
     */
	@TableField("CAME006")
	private Date came006;
    /**
     * 备注
     */
	@TableField("CAME007")
	private String came007;
    /**
     * 提醒：0.不提醒 1.日程开始时 2.提前5分钟 3.提前30分钟 4.提前1小时 5.提前1天
     */
	@TableField("CAME008")
	private Integer came008;
    /**
     * 重复：0.不重复 1.每天 2.每周 3.每两周 4.每月 5.每年
     */
	@TableField("CAME009")
	private Integer came009;


	public String getCame001() {
		return came001;
	}

	public void setCame001(String came001) {
		this.came001 = came001;
	}

	public String getCame002() {
		return came002;
	}

	public void setCame002(String came002) {
		this.came002 = came002;
	}

	public Date getCame003() {
		return came003;
	}

	public void setCame003(Date came003) {
		this.came003 = came003;
	}

	public Date getCame004() {
		return came004;
	}

	public void setCame004(Date came004) {
		this.came004 = came004;
	}

	public String getCame005() {
		return came005;
	}

	public void setCame005(String came005) {
		this.came005 = came005;
	}

	public Date getCame006() {
		return came006;
	}

	public void setCame006(Date came006) {
		this.came006 = came006;
	}

	public String getCame007() {
		return came007;
	}

	public void setCame007(String came007) {
		this.came007 = came007;
	}

	public Integer getCame008() {
		return came008;
	}

	public void setCame008(Integer came008) {
		this.came008 = came008;
	}

	public Integer getCame009() {
		return came009;
	}

	public void setCame009(Integer came009) {
		this.came009 = came009;
	}

	@Override
	protected Serializable pkVal() {
		return this.came001;
	}

	@Override
	public String toString() {
		return "HrswTCalendarmemorandum{" +
			"came001=" + came001 +
			", came002=" + came002 +
			", came003=" + came003 +
			", came004=" + came004 +
			", came005=" + came005 +
			", came006=" + came006 +
			", came007=" + came007 +
			", came008=" + came008 +
			", came009=" + came009 +
			"}";
	}
}

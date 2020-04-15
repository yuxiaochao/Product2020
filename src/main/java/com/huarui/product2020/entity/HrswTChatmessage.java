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
 * @since 2018-12-27
 */
@TableName("HRSW_T_CHATMESSAGE")
public class HrswTChatmessage extends Model<HrswTChatmessage> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("CHME001")
	private String chme001;
    /**
     * 消息类型：1、系统消息 2、群组消息 3、一对一消息等 4、新的好友消息 5、党建办消息
     */
	@TableField("CHME002")
	private int chme002;
    /**
     * 发送人ID
     */
	@TableField("CHME003")
	private String chme003;
    /**
     * 发送人环信ID
     */
	@TableField("CHME004")
	private String chme004;
    /**
     * 发送时间
     */
	@TableField("CHME005")
	private Date chme005;
    /**
     * 接收者id/群id
     */
	@TableField("CHME006")
	private String chme006;
    /**
     * 接收者环信id/环信群id
     */
	@TableField("CHME007")
	private String chme007;
    /**
     * 消息内容
     */
	@TableField("CHME008")
	private String chme008;
    /**
     * 外键类型(系统消息专用)：1.任务 2.日程 3.会议 4.评价 5.待我确认 6.纪实 7.出勤 8.任务签到 9.会议签到
     */
	@TableField("CHME009")
	private int chme009;
    /**
     * 外键key(系统消息专用)
     */
	@TableField("CHME010")
	private String chme010;
    /**
     * 消息标题(系统消息专用)
     */
	@TableField("CHME011")
	private String chme011;
	
	/**
     * 消息内容json串
     */
	@TableField("CHME012")
	private String chme012;


	public String getChme001() {
		return chme001;
	}

	public void setChme001(String chme001) {
		this.chme001 = chme001;
	}

	public int getChme002() {
		return chme002;
	}

	public void setChme002(int chme002) {
		this.chme002 = chme002;
	}

	public String getChme003() {
		return chme003;
	}

	public void setChme003(String chme003) {
		this.chme003 = chme003;
	}

	public String getChme004() {
		return chme004;
	}

	public void setChme004(String chme004) {
		this.chme004 = chme004;
	}

	public Date getChme005() {
		return chme005;
	}

	public void setChme005(Date chme005) {
		this.chme005 = chme005;
	}

	public String getChme006() {
		return chme006;
	}

	public void setChme006(String chme006) {
		this.chme006 = chme006;
	}

	public String getChme007() {
		return chme007;
	}

	public void setChme007(String chme007) {
		this.chme007 = chme007;
	}

	public String getChme008() {
		return chme008;
	}

	public void setChme008(String chme008) {
		this.chme008 = chme008;
	}

	public int getChme009() {
		return chme009;
	}

	public void setChme009(int chme009) {
		this.chme009 = chme009;
	}

	public String getChme010() {
		return chme010;
	}

	public void setChme010(String chme010) {
		this.chme010 = chme010;
	}

	public String getChme011() {
		return chme011;
	}

	public void setChme011(String chme011) {
		this.chme011 = chme011;
	}
	
	

	public String getChme012() {
		return chme012;
	}

	public void setChme012(String chme012) {
		this.chme012 = chme012;
	}

	@Override
	protected Serializable pkVal() {
		return this.chme001;
	}

	@Override
	public String toString() {
		return "HrswTChatmessage{" +
			"chme001=" + chme001 +
			", chme002=" + chme002 +
			", chme003=" + chme003 +
			", chme004=" + chme004 +
			", chme005=" + chme005 +
			", chme006=" + chme006 +
			", chme007=" + chme007 +
			", chme008=" + chme008 +
			", chme009=" + chme009 +
			", chme010=" + chme010 +
			", chme011=" + chme011 +
			"}";
	}
}

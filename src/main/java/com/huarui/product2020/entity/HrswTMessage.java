package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * ${table.comment}
 * </p>
 *
 * @author Chenrui
 * @since 2017-08-13
 */
@TableName("HRSW_T_MESSAGE")
public class HrswTMessage extends Model<HrswTMessage> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("MESS001")
	private String mess001;
    /**
     * 消息类型  1、系统消息2、群组消息3、一对一消息等
     */
	@TableField("MESS002")
	private Long mess002;
    /**
     * 发送人ID
     */
	@TableField("MESS003")
	private String mess003;
    /**
     * 发送时间
     */
	@TableField("MESS004")
	private Date mess004;
    /**
     * 消息标题
     */
	@TableField("MESS005")
	private String mess005;
    /**
     * 消息内容
     */
	@TableField("MESS006")
	private String mess006;
    /**
     * 消息推送方式
     */
	@TableField("MESS007")
	private String mess007;
    /**
     * 消息状态 1、草稿 2、已发送
     */
	@TableField("MESS008")
	private Double mess008;


	public String getMess001() {
		return mess001;
	}

	public void setMess001(String mess001) {
		this.mess001 = mess001;
	}

	public Long getMess002() {
		return mess002;
	}

	public void setMess002(Long mess002) {
		this.mess002 = mess002;
	}

	public String getMess003() {
		return mess003;
	}

	public void setMess003(String mess003) {
		this.mess003 = mess003;
	}

	public Date getMess004() {
		return mess004;
	}

	public void setMess004(Date mess004) {
		this.mess004 = mess004;
	}

	public String getMess005() {
		return mess005;
	}

	public void setMess005(String mess005) {
		this.mess005 = mess005;
	}

	public String getMess006() {
		return mess006;
	}

	public void setMess006(String mess006) {
		this.mess006 = mess006;
	}

	public String getMess007() {
		return mess007;
	}

	public void setMess007(String mess007) {
		this.mess007 = mess007;
	}

	public Double getMess008() {
		return mess008;
	}

	public void setMess008(Double mess008) {
		this.mess008 = mess008;
	}

	@Override
	protected Serializable pkVal() {
		return this.mess001;
	}

}

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
@TableName("HRSW_T_MESSAGEREADER")
public class HrswTMessagereader extends Model<HrswTMessagereader> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("MREA001")
	private String mrea001;
    /**
     * 消息ID
     */
	@TableField("MREA002")
	private String mrea002;
    /**
     * 阅读者ID
     */
	@TableField("MREA003")
	private String mrea003;
    /**
     * 阅读终端   Android、IPhone、WEB
     */
	@TableField("MREA004")
	private String mrea004;
    /**
     * 阅读时间
     */
	@TableField("MREA005")
	private Date mrea005;


	public String getMrea001() {
		return mrea001;
	}

	public void setMrea001(String mrea001) {
		this.mrea001 = mrea001;
	}

	public String getMrea002() {
		return mrea002;
	}

	public void setMrea002(String mrea002) {
		this.mrea002 = mrea002;
	}

	public String getMrea003() {
		return mrea003;
	}

	public void setMrea003(String mrea003) {
		this.mrea003 = mrea003;
	}

	public String getMrea004() {
		return mrea004;
	}

	public void setMrea004(String mrea004) {
		this.mrea004 = mrea004;
	}

	public Date getMrea005() {
		return mrea005;
	}

	public void setMrea005(Date mrea005) {
		this.mrea005 = mrea005;
	}

	@Override
	protected Serializable pkVal() {
		return this.mrea001;
	}

}

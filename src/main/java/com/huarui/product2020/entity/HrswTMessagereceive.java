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
@TableName("HRSW_T_MESSAGERECEIVE")
public class HrswTMessagereceive extends Model<HrswTMessagereceive> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("MREC001")
	private String mrec001;
    /**
     * 消息ID
     */
	@TableField("MREC002")
	private String mrec002;
	@TableField("MREC003")
	private String mrec003;
	@TableField("MREC004")
	private String mrec004;
	@TableField("MREC005")
	private String mrec005;
	@TableField("MREC006")
	private String mrec006;


	public String getMrec001() {
		return mrec001;
	}

	public void setMrec001(String mrec001) {
		this.mrec001 = mrec001;
	}

	public String getMrec002() {
		return mrec002;
	}

	public void setMrec002(String mrec002) {
		this.mrec002 = mrec002;
	}

	public String getMrec003() {
		return mrec003;
	}

	public void setMrec003(String mrec003) {
		this.mrec003 = mrec003;
	}

	public String getMrec004() {
		return mrec004;
	}

	public void setMrec004(String mrec004) {
		this.mrec004 = mrec004;
	}

	public String getMrec005() {
		return mrec005;
	}

	public void setMrec005(String mrec005) {
		this.mrec005 = mrec005;
	}

	public String getMrec006() {
		return mrec006;
	}

	public void setMrec006(String mrec006) {
		this.mrec006 = mrec006;
	}

	@Override
	protected Serializable pkVal() {
		return this.mrec001;
	}

}

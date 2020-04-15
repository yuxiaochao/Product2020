package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 宿舍楼资源
 * </p>
 *
 * @author caifenglin
 * @since 2020-01-06
 */
@TableName("HR_T_HOTEL")
public class Hotel extends Model<Hotel> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("HOTE001")
	private String hote001;
    /**
     * 宿舍名称
     */
	@TableField("HOTE002")
	private String hote002;
    /**
     * 宿舍楼层数
     */
	@TableField("HOTE003")
	private Integer hote003;
    /**
     * 宿舍位置
     */
	@TableField("HOTE004")
	private String hote004;
    /**
     * 宿舍责任人
     */
	@TableField("HOTE005")
	private String hote005;
    /**
     * 宿舍联系电话
     */
	@TableField("HOTE006")
	private String hote006;
    /**
     * 备注
     */
	@TableField("HOTE007")
	private String hote007;
    /**
     * 创建人
     */
	@TableField("HOTE008")
	private String hote008;
    /**
     * 创建时间
     */
	@TableField("HOTE009")
	private Date hote009;
    /**
     * 最后修改时间
     */
	@TableField("HOTE010")
	private Date hote010;
    /**
     * 功能点
     */
	@TableField("HOTE011")
	private String hote011;
	
	@TableField(exist = false)
	private Integer hotelroomnum;

	public String getHote001() {
		return hote001;
	}

	public void setHote001(String hote001) {
		this.hote001 = hote001;
	}

	public String getHote002() {
		return hote002;
	}

	public void setHote002(String hote002) {
		this.hote002 = hote002;
	}

	public Integer getHote003() {
		return hote003;
	}

	public void setHote003(Integer hote003) {
		this.hote003 = hote003;
	}

	public String getHote004() {
		return hote004;
	}

	public void setHote004(String hote004) {
		this.hote004 = hote004;
	}

	public String getHote005() {
		return hote005;
	}

	public void setHote005(String hote005) {
		this.hote005 = hote005;
	}

	public String getHote006() {
		return hote006;
	}

	public void setHote006(String hote006) {
		this.hote006 = hote006;
	}

	public String getHote007() {
		return hote007;
	}

	public void setHote007(String hote007) {
		this.hote007 = hote007;
	}

	public String getHote008() {
		return hote008;
	}

	public void setHote008(String hote008) {
		this.hote008 = hote008;
	}

	public Date getHote009() {
		return hote009;
	}

	public void setHote009(Date hote009) {
		this.hote009 = hote009;
	}

	public Date getHote010() {
		return hote010;
	}

	public void setHote010(Date hote010) {
		this.hote010 = hote010;
	}

	public String getHote011() {
		return hote011;
	}

	public void setHote011(String hote011) {
		this.hote011 = hote011;
	}
	

	public Integer getHotelroomnum() {
        return hotelroomnum;
    }

    public void setHotelroomnum(Integer hotelroomnum) {
        this.hotelroomnum = hotelroomnum;
    }

    @Override
	protected Serializable pkVal() {
		return this.hote001;
	}

	@Override
	public String toString() {
		return "Hotel{" +
			"hote001=" + hote001 +
			", hote002=" + hote002 +
			", hote003=" + hote003 +
			", hote004=" + hote004 +
			", hote005=" + hote005 +
			", hote006=" + hote006 +
			", hote007=" + hote007 +
			", hote008=" + hote008 +
			", hote009=" + hote009 +
			", hote010=" + hote010 +
			", hote011=" + hote011 +
			"}";
	}
}

package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 住宿安排
 * </p>
 *
 * @author caifenglin
 * @since 2020-01-15
 */
@TableName("HR_T_ACCOMMODATIONARRANGE")
public class Accommodationarrange extends Model<Accommodationarrange> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("HCAR001")
	private String hcar001;
    
    /**
     * 培训班ID
     */
	@TableField("HCAR002")
	private String hcar002;
	
    /**
     * 宿舍楼ID
     */
	@TableField("HCAR003")
	private String hcar003;
	
	/**
	 * 宿舍名称
	 */
	@TableField(exist = false)
	private String hcar003n;
	
    /**
     * 房间ID
     */
	@TableField("HCAR004")
	private String hcar004;
	
	/**
	 * 房间名称
	 */
	@TableField(exist = false)
	private String hcar004n;
	
    /**
     * 入住时间
     */
	@TableField("HCAR005")
	private Date hcar005;
	
    /**
     * 退房时间
     */
	@TableField("HCAR006")
	private Date hcar006;
	
	/**
	 * 房间类型
	 */
	@TableField(exist = false)
	private String hcar007;
	
	/**
     * 容纳人数
     */
    @TableField(exist = false)
    private Integer hcar008;
    
    /**
     * 学员ID
     */
    @TableField(exist = false)
    private String hcar009;
    
    /**
     * 学员名称
     */
    private String hcar009n;
    
    
    @TableField(exist = false)
    private List<Hotelroom> hotelroomList;


	public String getHcar001() {
		return hcar001;
	}

	public void setHcar001(String hcar001) {
		this.hcar001 = hcar001;
	}

	public String getHcar002() {
		return hcar002;
	}

	public void setHcar002(String hcar002) {
		this.hcar002 = hcar002;
	}

	public String getHcar003() {
		return hcar003;
	}

	public void setHcar003(String hcar003) {
		this.hcar003 = hcar003;
	}

	public String getHcar004() {
		return hcar004;
	}

	public void setHcar004(String hcar004) {
		this.hcar004 = hcar004;
	}

	public Date getHcar005() {
		return hcar005;
	}

	public void setHcar005(Date hcar005) {
		this.hcar005 = hcar005;
	}

	public Date getHcar006() {
		return hcar006;
	}

	public void setHcar006(Date hcar006) {
		this.hcar006 = hcar006;
	}
	
	

	public String getHcar003n() {
        return hcar003n;
    }

    public void setHcar003n(String hcar003n) {
        this.hcar003n = hcar003n;
    }

    public String getHcar004n() {
        return hcar004n;
    }

    public void setHcar004n(String hcar004n) {
        this.hcar004n = hcar004n;
    }

    public String getHcar007() {
        return hcar007;
    }

    public void setHcar007(String hcar007) {
        this.hcar007 = hcar007;
    }

    public Integer getHcar008() {
        return hcar008;
    }

    public void setHcar008(Integer hcar008) {
        this.hcar008 = hcar008;
    }

    public String getHcar009() {
        return hcar009;
    }

    public void setHcar009(String hcar009) {
        this.hcar009 = hcar009;
    }
    
    public String getHcar009n() {
        return hcar009n;
    }

    public void setHcar009n(String hcar009n) {
        this.hcar009n = hcar009n;
    }

    public List<Hotelroom> getHotelroomList() {
        return hotelroomList;
    }

    public void setHotelroomList(List<Hotelroom> hotelroomList) {
        this.hotelroomList = hotelroomList;
    }

    @Override
	protected Serializable pkVal() {
		return this.hcar001;
	}

    @Override
    public String toString() {
        return "Accommodationarrange [hcar001=" + hcar001 + ", hcar002=" + hcar002 + ", hcar003=" + hcar003
                + ", hcar003n=" + hcar003n + ", hcar004=" + hcar004 + ", hcar004n=" + hcar004n + ", hcar005=" + hcar005
                + ", hcar006=" + hcar006 + ", hcar007=" + hcar007 + ", hcar008=" + hcar008 + ", hcar009=" + hcar009
                + "]";
    }

}

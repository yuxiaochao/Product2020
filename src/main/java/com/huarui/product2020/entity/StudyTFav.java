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
 * @author cyx
 * @since 2019-08-28
 */
@TableName("STUDY_T_FAV")
public class StudyTFav extends Model<StudyTFav> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键 
     */
    @TableId("FAV001")
	private String fav001;
    /**
     * 学习id
     */
	@TableField("FAV002")
	private String fav002;
    /**
     *  用户id
     */
	@TableField("FAV003")
	private String fav003;
    /**
     *  收藏时间
     */
	@TableField("FAV004")
	private Date fav004;


	public String getFav001() {
		return fav001;
	}

	public void setFav001(String fav001) {
		this.fav001 = fav001;
	}

	public String getFav002() {
		return fav002;
	}

	public void setFav002(String fav002) {
		this.fav002 = fav002;
	}

	public String getFav003() {
		return fav003;
	}

	public void setFav003(String fav003) {
		this.fav003 = fav003;
	}

	public Date getFav004() {
		return fav004;
	}

	public void setFav004(Date fav004) {
		this.fav004 = fav004;
	}

	@Override
	protected Serializable pkVal() {
		return this.fav001;
	}

	@Override
	public String toString() {
		return "StudyTFav{" +
			"fav001=" + fav001 +
			", fav002=" + fav002 +
			", fav003=" + fav003 +
			", fav004=" + fav004 +
			"}";
	}
}

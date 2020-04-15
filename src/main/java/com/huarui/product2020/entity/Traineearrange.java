package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * 学员安排
 * </p>
 *
 * @author caifenglin
 * @since 2020-01-14
 */
@TableName("HR_T_TRAINEEARRANGE")
public class Traineearrange extends Model<Traineearrange> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("TRAR001")
	private String trar001;
    /**
     * 住宿安排ID
     */
	@TableField("TRAR002")
	private String trar002;
    /**
     * 人员ID
     */
	@TableField("TRAR003")
	private String trar003;


	public String getTrar001() {
		return trar001;
	}

	public void setTrar001(String trar001) {
		this.trar001 = trar001;
	}

	public String getTrar002() {
		return trar002;
	}

	public void setTrar002(String trar002) {
		this.trar002 = trar002;
	}

	public String getTrar003() {
		return trar003;
	}

	public void setTrar003(String trar003) {
		this.trar003 = trar003;
	}

	@Override
	protected Serializable pkVal() {
		return this.trar001;
	}

	@Override
	public String toString() {
		return "Traineearrange{" +
			"trar001=" + trar001 +
			", trar002=" + trar002 +
			", trar003=" + trar003 +
			"}";
	}
}

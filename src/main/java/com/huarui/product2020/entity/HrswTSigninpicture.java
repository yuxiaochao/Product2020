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
@TableName("HRSW_T_SIGNINPICTURE")
public class HrswTSigninpicture extends Model<HrswTSigninpicture> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId("SIPI001")
	private String sipi001;
    /**
     * 签到id
     */
	@TableField("SIPI002")
	private String sipi002;
    /**
     * 签到图片url
     */
	@TableField("SIPI003")
	private String sipi003;


	public String getSipi001() {
		return sipi001;
	}

	public void setSipi001(String sipi001) {
		this.sipi001 = sipi001;
	}

	public String getSipi002() {
		return sipi002;
	}

	public void setSipi002(String sipi002) {
		this.sipi002 = sipi002;
	}

	public String getSipi003() {
		return sipi003;
	}

	public void setSipi003(String sipi003) {
		this.sipi003 = sipi003;
	}

	@Override
	protected Serializable pkVal() {
		return this.sipi001;
	}

	@Override
	public String toString() {
		return "HrswTSigninpicture{" +
			"sipi001=" + sipi001 +
			", sipi002=" + sipi002 +
			", sipi003=" + sipi003 +
			"}";
	}
}

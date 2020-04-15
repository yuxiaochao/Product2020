package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
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
@TableName("HRUX_T_CONFIRMATIONSENDING")
public class HruxTConfirmationsending extends Model<HruxTConfirmationsending> {

    private static final long serialVersionUID = 1L;

	@TableField("COSE001")
	private String cose001;
    /**
     * 消息id
     */
	@TableField("COSE002")
	private String cose002;
    /**
     * 发送时间
     */
	@TableField("COSE003")
	private Date cose003;


	public String getCose001() {
		return cose001;
	}

	public void setCose001(String cose001) {
		this.cose001 = cose001;
	}

	public String getCose002() {
		return cose002;
	}

	public void setCose002(String cose002) {
		this.cose002 = cose002;
	}

	public Date getCose003() {
		return cose003;
	}

	public void setCose003(Date cose003) {
		this.cose003 = cose003;
	}

	@Override
	protected Serializable pkVal() {
		return this.cose001;
	}

	@Override
	public String toString() {
		return "HruxTConfirmationsending{" +
			"cose001=" + cose001 +
			", cose002=" + cose002 +
			", cose003=" + cose003 +
			"}";
	}
}

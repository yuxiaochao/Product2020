package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yuxiaochao
 * @since 2019-01-05
 */
@TableName("HRSW_T_DOCUMENTARYREPORTCHILD")
public class HrswTDocumentaryreportchild extends Model<HrswTDocumentaryreportchild> {

    private static final long serialVersionUID = 1L;

	@TableField("DORC001")
	private String dorc001;
    /**
     * 纪实上报表ID
     */
	@TableField("DORC002")
	private String dorc002;
    /**
     *   流水单号
     */
	@TableField("DORC003")
	private String dorc003;
    /**
     *   纪实表ID
     */
	@TableField("DORC004")
	private String dorc004;


	public String getDorc001() {
		return dorc001;
	}

	public void setDorc001(String dorc001) {
		this.dorc001 = dorc001;
	}

	public String getDorc002() {
		return dorc002;
	}

	public void setDorc002(String dorc002) {
		this.dorc002 = dorc002;
	}

	public String getDorc003() {
		return dorc003;
	}

	public void setDorc003(String dorc003) {
		this.dorc003 = dorc003;
	}

	public String getDorc004() {
		return dorc004;
	}

	public void setDorc004(String dorc004) {
		this.dorc004 = dorc004;
	}

	@Override
	protected Serializable pkVal() {
		return this.dorc001;
	}

	@Override
	public String toString() {
		return "HrswTDocumentaryreportchild{" +
			"dorc001=" + dorc001 +
			", dorc002=" + dorc002 +
			", dorc003=" + dorc003 +
			", dorc004=" + dorc004 +
			"}";
	}
}

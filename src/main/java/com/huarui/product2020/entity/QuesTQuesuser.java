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
@TableName("QUES_T_QUESUSER")
public class QuesTQuesuser extends Model<QuesTQuesuser> {

    private static final long serialVersionUID = 1L;

    @TableId("QUSE001")
	private String quse001;
	@TableField("QUSE002")
	private String quse002;
	@TableField("QUSE003")
	private String quse003;
	@TableField("QUSE004")
	private String quse004;
	@TableField("QUSE005")
	private String quse005;
	@TableField("QUSE006")
	private String quse006;
	@TableField("QUSE007")
	private String quse007;
    /**
     * 类型
1：机构
2：学员
3：群组
4：岗位序列
5：船舶
     */
	@TableField("QUSE008")
	private Integer quse008;


	public String getQuse001() {
		return quse001;
	}

	public void setQuse001(String quse001) {
		this.quse001 = quse001;
	}

	public String getQuse002() {
		return quse002;
	}

	public void setQuse002(String quse002) {
		this.quse002 = quse002;
	}

	public String getQuse003() {
		return quse003;
	}

	public void setQuse003(String quse003) {
		this.quse003 = quse003;
	}

	public String getQuse004() {
		return quse004;
	}

	public void setQuse004(String quse004) {
		this.quse004 = quse004;
	}

	public String getQuse005() {
		return quse005;
	}

	public void setQuse005(String quse005) {
		this.quse005 = quse005;
	}

	public String getQuse006() {
		return quse006;
	}

	public void setQuse006(String quse006) {
		this.quse006 = quse006;
	}

	public String getQuse007() {
		return quse007;
	}

	public void setQuse007(String quse007) {
		this.quse007 = quse007;
	}

	public Integer getQuse008() {
		return quse008;
	}

	public void setQuse008(Integer quse008) {
		this.quse008 = quse008;
	}

	@Override
	protected Serializable pkVal() {
		return this.quse001;
	}

}

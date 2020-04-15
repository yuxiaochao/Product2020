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
@TableName("EXAM_T_TESTUSER")
public class ExamTTestuser extends Model<ExamTTestuser> {

    private static final long serialVersionUID = 1L;

    @TableId("TUSE001")
	private String tuse001;
    /**
     * 试卷ID
     */
	@TableField("TUSE002")
	private String tuse002;
    /**
     * 机构ID
     */
	@TableField("TUSE003")
	private String tuse003;
    /**
     * 学员ID
     */
	@TableField("TUSE004")
	private String tuse004;
    /**
     * 群组ID
     */
	@TableField("TUSE005")
	private String tuse005;
    /**
     * 岗位序列ID
     */
	@TableField("TUSE006")
	private String tuse006;
    /**
     * 船舶ID
     */
	@TableField("TUSE007")
	private String tuse007;
    /**
     * 类型
1：机构
2：学员
3：群组
4：岗位序列
5：船舶
     */
	@TableField("TUSE008")
	private Integer tuse008;


	public String getTuse001() {
		return tuse001;
	}

	public void setTuse001(String tuse001) {
		this.tuse001 = tuse001;
	}

	public String getTuse002() {
		return tuse002;
	}

	public void setTuse002(String tuse002) {
		this.tuse002 = tuse002;
	}

	public String getTuse003() {
		return tuse003;
	}

	public void setTuse003(String tuse003) {
		this.tuse003 = tuse003;
	}

	public String getTuse004() {
		return tuse004;
	}

	public void setTuse004(String tuse004) {
		this.tuse004 = tuse004;
	}

	public String getTuse005() {
		return tuse005;
	}

	public void setTuse005(String tuse005) {
		this.tuse005 = tuse005;
	}

	public String getTuse006() {
		return tuse006;
	}

	public void setTuse006(String tuse006) {
		this.tuse006 = tuse006;
	}

	public String getTuse007() {
		return tuse007;
	}

	public void setTuse007(String tuse007) {
		this.tuse007 = tuse007;
	}

	public Integer getTuse008() {
		return tuse008;
	}

	public void setTuse008(Integer tuse008) {
		this.tuse008 = tuse008;
	}

	@Override
	protected Serializable pkVal() {
		return this.tuse001;
	}

}

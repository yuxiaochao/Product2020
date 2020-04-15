package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yuxiaochao
 * @since 2019-10-25
 */
public class Tbjxsj01 extends Model<Tbjxsj01> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("JXSJ0101")
	private String jxsj0101;
    /**
     * 培训班ID
     */
	@TableField("JXSJ0102")
	private String jxsj0102;
    /**
     * 启用功能ID0：通知；1：学前考试；2：学习材料；
3：签到设置；4：班委设置；
5：学员分组；6：成果上报；
7：小组讨论；8：课后练习；
9：案例分析；10：班级交流；
11：班级相册；12：效果评估；13：结业证书；
     */
	@TableField("JXSJ0103")
	private Integer jxsj0103;
    /**
     * 功能开关0：否；1：是
     */
	@TableField("JXSJ0104")
	private Integer jxsj0104;


	public String getJxsj0101() {
		return jxsj0101;
	}

	public void setJxsj0101(String jxsj0101) {
		this.jxsj0101 = jxsj0101;
	}

	public String getJxsj0102() {
		return jxsj0102;
	}

	public void setJxsj0102(String jxsj0102) {
		this.jxsj0102 = jxsj0102;
	}

	public Integer getJxsj0103() {
		return jxsj0103;
	}

	public void setJxsj0103(Integer jxsj0103) {
		this.jxsj0103 = jxsj0103;
	}

	public Integer getJxsj0104() {
		return jxsj0104;
	}

	public void setJxsj0104(Integer jxsj0104) {
		this.jxsj0104 = jxsj0104;
	}

	@Override
	protected Serializable pkVal() {
		return this.jxsj0101;
	}

	@Override
	public String toString() {
		return "Tbjxsj01{" +
			"jxsj0101=" + jxsj0101 +
			", jxsj0102=" + jxsj0102 +
			", jxsj0103=" + jxsj0103 +
			", jxsj0104=" + jxsj0104 +
			"}";
	}
}

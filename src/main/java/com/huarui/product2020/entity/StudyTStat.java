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
 * @author cyx
 * @since 2019-08-28
 */
@TableName("STUDY_T_STAT")
public class StudyTStat extends Model<StudyTStat> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键 
     */
    @TableId("STAT001")
	private String stat001;
    /**
     * 学习id
     */
	@TableField("STAT002")
	private String stat002;
    /**
     *  点赞数
     */
	@TableField("STAT003")
	private Double stat003;
    /**
     *  收藏数
     */
	@TableField("STAT004")
	private Double stat004;


	public String getStat001() {
		return stat001;
	}

	public void setStat001(String stat001) {
		this.stat001 = stat001;
	}

	public String getStat002() {
		return stat002;
	}

	public void setStat002(String stat002) {
		this.stat002 = stat002;
	}

	public Double getStat003() {
		return stat003;
	}

	public void setStat003(Double stat003) {
		this.stat003 = stat003;
	}

	public Double getStat004() {
		return stat004;
	}

	public void setStat004(Double stat004) {
		this.stat004 = stat004;
	}

	@Override
	protected Serializable pkVal() {
		return this.stat001;
	}

	@Override
	public String toString() {
		return "StudyTStat{" +
			"stat001=" + stat001 +
			", stat002=" + stat002 +
			", stat003=" + stat003 +
			", stat004=" + stat004 +
			"}";
	}
}

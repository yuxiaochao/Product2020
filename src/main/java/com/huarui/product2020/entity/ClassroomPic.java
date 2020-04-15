package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * 教室资源图片
 * </p>
 *
 * @author caifenglin
 * @since 2019-12-23
 */
@TableName("HR_T_CLASSROOM_PIC")
public class ClassroomPic extends Model<ClassroomPic> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("CLPI001")
	private String clpi001;
    /**
     * 所属教室
     */
	@TableField("CLPI002")
	private String clpi002;
    /**
     * 图片名称
     */
	@TableField("CLPI003")
	private String clpi003;
    /**
     * 图片路径
     */
	@TableField("CLPI004")
	private String clpi004;


	public String getClpi001() {
		return clpi001;
	}

	public void setClpi001(String clpi001) {
		this.clpi001 = clpi001;
	}

	public String getClpi002() {
		return clpi002;
	}

	public void setClpi002(String clpi002) {
		this.clpi002 = clpi002;
	}

	public String getClpi003() {
		return clpi003;
	}

	public void setClpi003(String clpi003) {
		this.clpi003 = clpi003;
	}

	public String getClpi004() {
		return clpi004;
	}

	public void setClpi004(String clpi004) {
		this.clpi004 = clpi004;
	}

	@Override
	protected Serializable pkVal() {
		return this.clpi001;
	}

	@Override
	public String toString() {
		return "ClassroomPic{" +
			"clpi001=" + clpi001 +
			", clpi002=" + clpi002 +
			", clpi003=" + clpi003 +
			", clpi004=" + clpi004 +
			"}";
	}
}

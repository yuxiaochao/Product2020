package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 参考资料表
 * </p>
 *
 * @author Chenrui
 * @since 2017-08-13
 */
@TableName("EXAM_T_REFERENCEMATERIAL")
public class ExamTReferencematerial extends Model<ExamTReferencematerial> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键，参考资料ID
     */
    @TableId("REMA001")
	private String rema001;
    /**
     * 参考资料类别ID
     */
	@TableField("REMA002")
	private String rema002;
    /**
     * 参考资料名称
     */
	@TableField("REMA003")
	private String rema003;
    /**
     * 资料层级，1,国家,2,行业,3,总公司,4,地方,5,铁科院
     */
	@TableField("REMA004")
	private Double rema004;
    /**
     * 是否发布，1、发布，2、未发布
     */
	@TableField("REMA005")
	private Double rema005;
    /**
     * 资料文件上传路径
     */
	@TableField("REMA006")
	private String rema006;
    /**
     * 创建人ID
     */
	@TableField("REMA007")
	private String rema007;
    /**
     * 资料创建时间
     */
	@TableField("REMA008")
	private Date rema008;
    /**
     * 最后发布时间
     */
	@TableField("REMA009")
	private Date rema009;
    /**
     * 备注信息
     */
	@TableField("REMA010")
	private String rema010;
    /**
     * 资料文件原名
     */
	@TableField("REMA011")
	private String rema011;
    /**
     * 转换后文件路径
     */
	@TableField("REMA012")
	private String rema012;
    /**
     * 转换状态：0、未转换，1、已转换，2、转换失败。
     */
	@TableField("REMA013")
	private Integer rema013;
    /**
     * 文档页数
     */
	@TableField("REMA014")
	private String rema014;
	@TableField("REMA015")
	private String rema015;


	public String getRema001() {
		return rema001;
	}

	public void setRema001(String rema001) {
		this.rema001 = rema001;
	}

	public String getRema002() {
		return rema002;
	}

	public void setRema002(String rema002) {
		this.rema002 = rema002;
	}

	public String getRema003() {
		return rema003;
	}

	public void setRema003(String rema003) {
		this.rema003 = rema003;
	}

	public Double getRema004() {
		return rema004;
	}

	public void setRema004(Double rema004) {
		this.rema004 = rema004;
	}

	public Double getRema005() {
		return rema005;
	}

	public void setRema005(Double rema005) {
		this.rema005 = rema005;
	}

	public String getRema006() {
		return rema006;
	}

	public void setRema006(String rema006) {
		this.rema006 = rema006;
	}

	public String getRema007() {
		return rema007;
	}

	public void setRema007(String rema007) {
		this.rema007 = rema007;
	}

	public Date getRema008() {
		return rema008;
	}

	public void setRema008(Date rema008) {
		this.rema008 = rema008;
	}

	public Date getRema009() {
		return rema009;
	}

	public void setRema009(Date rema009) {
		this.rema009 = rema009;
	}

	public String getRema010() {
		return rema010;
	}

	public void setRema010(String rema010) {
		this.rema010 = rema010;
	}

	public String getRema011() {
		return rema011;
	}

	public void setRema011(String rema011) {
		this.rema011 = rema011;
	}

	public String getRema012() {
		return rema012;
	}

	public void setRema012(String rema012) {
		this.rema012 = rema012;
	}

	public Integer getRema013() {
		return rema013;
	}

	public void setRema013(Integer rema013) {
		this.rema013 = rema013;
	}

	public String getRema014() {
		return rema014;
	}

	public void setRema014(String rema014) {
		this.rema014 = rema014;
	}

	public String getRema015() {
		return rema015;
	}

	public void setRema015(String rema015) {
		this.rema015 = rema015;
	}

	@Override
	protected Serializable pkVal() {
		return this.rema001;
	}

}

package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author panlei
 * @since 2018-05-22
 */
@TableName("EXAM_T_STANDARDTRAINING")
public class ExamTStandardtraining extends Model<ExamTStandardtraining> {

    private static final long serialVersionUID = 1L;

    /**
     * PK
     */
    @TableId("EST001")
	private String est001;
    /**
     * 训练编号
     */
	@TableField("EST002")
	private String est002;
    /**
     * 主办单位ID
     */
	@TableField("EST003")
	private String est003;
    /**
     * 训练名称
     */
	@TableField("EST004")
	private String est004;
    /**
     * 开始时间
     */
	@TableField("EST005")
	private Date est005;
    /**
     * 结束时间
     */
	@TableField("EST006")
	private Date est006;
    /**
     * 状态 1、编辑中 2、未发布 3、已发布 4、已归档
     */
	@TableField("EST007")
	private Double est007;
    /**
     * 顺序号
     */
	@TableField("EST008")
	private Double est008;
    /**
     * 目录ID
     */
	@TableField("EST009")
	private String est009;
    /**
     * 封面
     */
	@TableField("EST010")
	private String est010;
    /**
     * 说明
     */
	@TableField("EST011")
	private String est011;
    /**
     * 所属类型（数据字典，训练类型）
     */
	@TableField("EST012")
	private String est012;
    /**
     * 答题正确率高于N%时即为达标
     */
	@TableField("EST013")
	private Double est013;
    /**
     * 允许学员查看答卷 0 不允许 1 允许
     */
	@TableField("EST014")
	private Double est014;
    /**
     * 发布时间
     */
	@TableField("EST015")
	private Date est015;
    /**
     * 最后修改时间
     */
	@TableField("EST016")
	private Date est016;
    /**
     * 创建人ID
     */
	@TableField("EST017")
	private String est017;
    /**
     * 菜单完成状态
     */
	@TableField("EST018")
	private String est018;
	@TableField("EST019")
	private Double est019;

	@TableField(exist=false)
	private String organname;
	
	@TableField(exist=false)
	private String est017str;
	
	@TableField(exist=false)
	private String extg007;
	
	@TableField(exist=false)
	private String extg007str;

	public String getEst001() {
		return est001;
	}

	public void setEst001(String est001) {
		this.est001 = est001;
	}

	public String getEst002() {
		return est002;
	}

	public void setEst002(String est002) {
		this.est002 = est002;
	}

	public String getEst003() {
		return est003;
	}

	public void setEst003(String est003) {
		this.est003 = est003;
	}

	public String getEst004() {
		return est004;
	}

	public void setEst004(String est004) {
		this.est004 = est004;
	}

	public Date getEst005() {
		return est005;
	}

	public void setEst005(Date est005) {
		this.est005 = est005;
	}

	public Date getEst006() {
		return est006;
	}

	public void setEst006(Date est006) {
		this.est006 = est006;
	}

	public Double getEst007() {
		return est007;
	}

	public void setEst007(Double est007) {
		this.est007 = est007;
	}

	public Double getEst008() {
		return est008;
	}

	public void setEst008(Double est008) {
		this.est008 = est008;
	}

	public String getEst009() {
		return est009;
	}

	public void setEst009(String est009) {
		this.est009 = est009;
	}

	public String getEst010() {
		return est010;
	}

	public void setEst010(String est010) {
		this.est010 = est010;
	}

	public String getEst011() {
		return est011;
	}

	public void setEst011(String est011) {
		this.est011 = est011;
	}

	public String getEst012() {
		return est012;
	}

	public void setEst012(String est012) {
		this.est012 = est012;
	}

	public Double getEst013() {
		return est013;
	}

	public void setEst013(Double est013) {
		this.est013 = est013;
	}

	public Double getEst014() {
		return est014;
	}

	public void setEst014(Double est014) {
		this.est014 = est014;
	}

	public Date getEst015() {
		return est015;
	}

	public void setEst015(Date est015) {
		this.est015 = est015;
	}

	public Date getEst016() {
		return est016;
	}

	public void setEst016(Date est016) {
		this.est016 = est016;
	}

	public String getEst017() {
		return est017;
	}

	public void setEst017(String est017) {
		this.est017 = est017;
	}

	public String getEst018() {
		return est018;
	}

	public void setEst018(String est018) {
		this.est018 = est018;
	}

	public Double getEst019() {
		return est019;
	}

	public void setEst019(Double est019) {
		this.est019 = est019;
	}

	@Override
	protected Serializable pkVal() {
		return this.est001;
	}
	
	

	public String getOrganname() {
		return organname;
	}

	public void setOrganname(String organname) {
		this.organname = organname;
	}

	public String getEst017str() {
		return est017str;
	}

	public void setEst017str(String est017str) {
		this.est017str = est017str;
	}

	public String getExtg007() {
		return extg007;
	}

	public void setExtg007(String extg007) {
		this.extg007 = extg007;
	}

	public String getExtg007str() {
		return extg007str;
	}

	public void setExtg007str(String extg007str) {
		this.extg007str = extg007str;
	}

}

package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * ${table.comment}
 * </p>
 *
 * @author Chenrui
 * @since 2017-08-13
 */
@TableName("QUES_T_QUESTIONNAIRE")
public class QuesTQuestionnaire extends Model<QuesTQuestionnaire> {

    private static final long serialVersionUID = 1L;

    @TableId("QUES001")
	private String ques001;
	@TableField("QUES002")
	private String ques002;
	@TableField("QUES003")
	private String ques003;
	@TableField("QUES004")
	private Date ques004;
	@TableField("QUES005")
	private Date ques005;
    /**
     * 计时选项：1：不计时 2：计时
     */
	@TableField("QUES006")
	private Double ques006;
	@TableField("QUES007")
	private Double ques007;
	@TableField("QUES008")
	private Double ques008;
	@TableField("QUES009")
	private Double ques009;
	@TableField("QUES010")
	private Double ques010;
	@TableField("QUES011")
	private String ques011;
    /**
     * 调查模式：1、问卷调查-整体调查 2、问卷调查-讲师评估 3、问卷调查-课程评估 4、问卷调查-用户  5、360度评估
     */
	@TableField("QUES012")
	private Double ques012;
	@TableField("QUES013")
	private String ques013;
    /**
     * 来源：1、岸端 2、船端
     */
	@TableField("QUES014")
	private Double ques014;
    /**
     * 调查类别：1、问卷调查-岸端 2、问卷调查-船端
     */
	@TableField("QUES015")
	private Double ques015;
    /**
     * 问卷编号
     */
	@TableField("QUES016")
	private String ques016;
    /**
     * 问卷状态:1、待发布 2、已发布 3、已归档
     */
	@TableField("QUES018")
	private Double ques018;
    /**
     * 试题来源:1、题库 2、Excel
     */
	@TableField("QUES017")
	private Double ques017;
    /**
     * 答题时间(分钟)
     */
	@TableField("QUES019")
	private Double ques019;
    /**
     * 调查封面地址（路径格式：“#{ftpServicePath}/xxx/yyy.jpg”，“#{ftpServicePath}”是ftp服务路径，在jsp手动替换）
     */
	@TableField("QUES020")
	private String ques020;


	public String getQues001() {
		return ques001;
	}

	public void setQues001(String ques001) {
		this.ques001 = ques001;
	}

	public String getQues002() {
		return ques002;
	}

	public void setQues002(String ques002) {
		this.ques002 = ques002;
	}

	public String getQues003() {
		return ques003;
	}

	public void setQues003(String ques003) {
		this.ques003 = ques003;
	}

	public Date getQues004() {
		return ques004;
	}

	public void setQues004(Date ques004) {
		this.ques004 = ques004;
	}

	public Date getQues005() {
		return ques005;
	}

	public void setQues005(Date ques005) {
		this.ques005 = ques005;
	}

	public Double getQues006() {
		return ques006;
	}

	public void setQues006(Double ques006) {
		this.ques006 = ques006;
	}

	public Double getQues007() {
		return ques007;
	}

	public void setQues007(Double ques007) {
		this.ques007 = ques007;
	}

	public Double getQues008() {
		return ques008;
	}

	public void setQues008(Double ques008) {
		this.ques008 = ques008;
	}

	public Double getQues009() {
		return ques009;
	}

	public void setQues009(Double ques009) {
		this.ques009 = ques009;
	}

	public Double getQues010() {
		return ques010;
	}

	public void setQues010(Double ques010) {
		this.ques010 = ques010;
	}

	public String getQues011() {
		return ques011;
	}

	public void setQues011(String ques011) {
		this.ques011 = ques011;
	}

	public Double getQues012() {
		return ques012;
	}

	public void setQues012(Double ques012) {
		this.ques012 = ques012;
	}

	public String getQues013() {
		return ques013;
	}

	public void setQues013(String ques013) {
		this.ques013 = ques013;
	}

	public Double getQues014() {
		return ques014;
	}

	public void setQues014(Double ques014) {
		this.ques014 = ques014;
	}

	public Double getQues015() {
		return ques015;
	}

	public void setQues015(Double ques015) {
		this.ques015 = ques015;
	}

	public String getQues016() {
		return ques016;
	}

	public void setQues016(String ques016) {
		this.ques016 = ques016;
	}

	public Double getQues018() {
		return ques018;
	}

	public void setQues018(Double ques018) {
		this.ques018 = ques018;
	}

	public Double getQues017() {
		return ques017;
	}

	public void setQues017(Double ques017) {
		this.ques017 = ques017;
	}

	public Double getQues019() {
		return ques019;
	}

	public void setQues019(Double ques019) {
		this.ques019 = ques019;
	}

	public String getQues020() {
		return ques020;
	}

	public void setQues020(String ques020) {
		this.ques020 = ques020;
	}

	@Override
	protected Serializable pkVal() {
		return this.ques001;
	}

}

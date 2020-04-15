package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * ${table.comment}
 * </p>
 *
 * @author Chenrui
 * @since 2017-08-13
 */
@TableName("EXAM_T_TESTACTIVITY")
public class ExamTTestactivity extends Model<ExamTTestactivity> {

    private static final long serialVersionUID = 1L;

    @TableId("TACT001")
	private String tact001;
    /**
     * 目录ID
     */
	@TableField("TACT002")
	private String tact002;
    /**
     * 主办单位ID
     */
	@TableField("TACT003")
	private String tact003;
    /**
     * 考试活动名称
     */
	@TableField("TACT004")
	private String tact004;
    /**
     * 类型：1、正式考试-岸端 2、正式考试-船端 3、学习结业考试
     */
	@TableField("TACT005")
	private Integer tact005;
    /**
     * 考试活动开始时间
     */
	@TableField("TACT006")
	private Date tact006;
    /**
     * 考试活动结束时间
     */
	@TableField("TACT007")
	private Date tact007;
    /**
     * 考试计时方式  
1: 不计时交卷 
2：计时交卷 
3：统一交卷
4：试题计时
     */
	@TableField("TACT008")
	private Integer tact008;
    /**
     * 考试时长（分）   对应计时交卷
     */
	@TableField("TACT009")
	private Long tact009;
    /**
     * 考试开始时间    用于统一交卷
     */
	@TableField("TACT010")
	private String tact010;
    /**
     * 考试结束时间    用于统一交卷
     */
	@TableField("TACT011")
	private String tact011;
    /**
     * 允许考试次数   0：代表无限次
     */
	@TableField("TACT012")
	private Long tact012;
    /**
     * 至少答题X分钟，则可交卷      0：代表可随时交卷
     */
	@TableField("TACT013")
	private Long tact013;
    /**
     * 成绩公示方式    1:不公示成绩 2：考试结束后公示成绩 3：指定时间公示成绩
     */
	@TableField("TACT014")
	private Integer tact014;
    /**
     * 成绩公示开始时间
     */
	@TableField("TACT015")
	private Date tact015;
    /**
     * 成绩公示结束时间
     */
	@TableField("TACT016")
	private Date tact016;
    /**
     * 允许查看答卷及分析
     */
	@TableField("TACT017")
	private Integer tact017;
    /**
     * 卷首语
     */
	@TableField("TACT018")
	private String tact018;
    /**
     * 试卷须知
     */
	@TableField("TACT019")
	private String tact019;
    /**
     * 试卷总分
     */
	@TableField("TACT020")
	private Float tact020;
    /**
     * 通过分数
     */
	@TableField("TACT021")
	private Float tact021;
    /**
     * 出题方式  1、固定 2、随机
     */
	@TableField("TACT022")
	private Integer tact022;
    /**
     * 随机试卷份数
     */
	@TableField("TACT023")
	private Long tact023;
    /**
     * 试卷来源  1、题库 2、Excel  3、策略库4、试卷库
     */
	@TableField("TACT024")
	private Integer tact024;
    /**
     * 页面显示方式    
1：全部显示
2：仅显示一道题
3：一屏显示一种题型
     */
	@TableField("TACT025")
	private Integer tact025;
    /**
     * 分数定义模式   1、使用题库中的试题分数，并按试卷总分进行相应折算  2、忽略试题原分数，按题型指定分数
     */
	@TableField("TACT026")
	private Integer tact026;
    /**
     * 题目随机   1:不随机 2：随机
     */
	@TableField("TACT027")
	private Integer tact027;
    /**
     * 选择题候选项随机  1:不随机 2：随机
     */
	@TableField("TACT028")
	private Integer tact028;
    /**
     * 移出页面限制   1、不限制 2、限制
     */
	@TableField("TACT029")
	private Integer tact029;
    /**
     * 移出WEB页面次数
     */
	@TableField("TACT030")
	private Long tact030;
    /**
     * 启用安全组件  1：启用 2：禁用
     */
	@TableField("TACT031")
	private Integer tact031;
    /**
     * 启用指纹识别   1：启用 2：禁用
     */
	@TableField("TACT032")
	private Integer tact032;
    /**
     * 选择考生模式   
1：机构
2：学员
3：群组
4：岗位序列
     */
	@TableField("TACT033")
	private Integer tact033;
    /**
     * 判分方式  1: 自动评分 2: 手工评分
     */
	@TableField("TACT034")
	private Integer tact034;
    /**
     * 允许实名阅卷  1：匿名 （DEF（0）） 2:实名
     */
	@TableField("TACT035")
	private Integer tact035;
    /**
     * 阅卷方式  1：按试卷 2：按试题
     */
	@TableField("TACT036")
	private Integer tact036;
    /**
     * 顺序号
     */
	@TableField("TACT037")
	private Long tact037;
    /**
     * 状态  1、组卷中 2、发布 3、归档
     */
	@TableField("TACT038")
	private Integer tact038;
    /**
     * 试卷编号
     */
	@TableField("TACT039")
	private String tact039;
    /**
     * 来源 1、岸端 2、船端
     */
	@TableField("TACT040")
	private Double tact040;
    /**
     * 试卷封面地址（路径格式：“#{ftpServicePath}/xxx/yyy.jpg”，“#{ftpServicePath}”是ftp服务路径，在jsp手动替换）
     */
	@TableField("TACT041")
	private String tact041;
    /**
     * 平均分配试卷：1、平均 2、不平均
     */
	@TableField("TACT042")
	private Double tact042;
    /**
     * 归档方式：1、手动归档 2、自动归档
     */
	@TableField("TACT043")
	private Integer tact043;
	/**
     * 每题答题时限（秒）
     */
	@TableField("TACT047")
	private Integer tact047;
	/**
	 * 开考X分钟，禁止入场：DEF（0） 0：代表可随时入场
	 */
	@TableField("TACT049")
	private Integer tact049;
	/**
	 * 培训班id
	 */
	@TableField("TACT054")
	private String tact054;
	@TableField(exist=false)
	private List<ExamTTesttx> data1;
	public String getTact001() {
		return tact001;
	}

	public void setTact001(String tact001) {
		this.tact001 = tact001;
	}

	public String getTact002() {
		return tact002;
	}

	public void setTact002(String tact002) {
		this.tact002 = tact002;
	}

	public String getTact003() {
		return tact003;
	}

	public void setTact003(String tact003) {
		this.tact003 = tact003;
	}

	public String getTact004() {
		return tact004;
	}

	public void setTact004(String tact004) {
		this.tact004 = tact004;
	}

	public Integer getTact005() {
		return tact005;
	}

	public void setTact005(Integer tact005) {
		this.tact005 = tact005;
	}

	public Date getTact006() {
		return tact006;
	}

	public void setTact006(Date tact006) {
		this.tact006 = tact006;
	}

	public Date getTact007() {
		return tact007;
	}

	public void setTact007(Date tact007) {
		this.tact007 = tact007;
	}

	public Integer getTact008() {
		return tact008;
	}

	public void setTact008(Integer tact008) {
		this.tact008 = tact008;
	}

	public Long getTact009() {
		return tact009;
	}

	public void setTact009(Long tact009) {
		this.tact009 = tact009;
	}

	public String getTact010() {
		return tact010;
	}

	public void setTact010(String tact010) {
		this.tact010 = tact010;
	}

	public String getTact011() {
		return tact011;
	}

	public void setTact011(String tact011) {
		this.tact011 = tact011;
	}

	public Long getTact012() {
		return tact012;
	}

	public void setTact012(Long tact012) {
		this.tact012 = tact012;
	}

	public Long getTact013() {
		return tact013;
	}

	public void setTact013(Long tact013) {
		this.tact013 = tact013;
	}

	public Integer getTact014() {
		return tact014;
	}

	public void setTact014(Integer tact014) {
		this.tact014 = tact014;
	}

	public Date getTact015() {
		return tact015;
	}

	public void setTact015(Date tact015) {
		this.tact015 = tact015;
	}

	public Date getTact016() {
		return tact016;
	}

	public void setTact016(Date tact016) {
		this.tact016 = tact016;
	}

	public Integer getTact017() {
		return tact017;
	}

	public void setTact017(Integer tact017) {
		this.tact017 = tact017;
	}

	public String getTact018() {
		return tact018;
	}

	public void setTact018(String tact018) {
		this.tact018 = tact018;
	}

	public String getTact019() {
		return tact019;
	}

	public void setTact019(String tact019) {
		this.tact019 = tact019;
	}

	public Float getTact020() {
		return tact020;
	}

	public void setTact020(Float tact020) {
		this.tact020 = tact020;
	}

	public Float getTact021() {
		return tact021;
	}

	public void setTact021(Float tact021) {
		this.tact021 = tact021;
	}

	public Integer getTact022() {
		return tact022;
	}

	public void setTact022(Integer tact022) {
		this.tact022 = tact022;
	}

	public Long getTact023() {
		return tact023;
	}

	public void setTact023(Long tact023) {
		this.tact023 = tact023;
	}

	public Integer getTact024() {
		return tact024;
	}

	public void setTact024(Integer tact024) {
		this.tact024 = tact024;
	}

	public Integer getTact025() {
		return tact025;
	}

	public void setTact025(Integer tact025) {
		this.tact025 = tact025;
	}

	public Integer getTact026() {
		return tact026;
	}

	public void setTact026(Integer tact026) {
		this.tact026 = tact026;
	}

	public Integer getTact027() {
		return tact027;
	}

	public void setTact027(Integer tact027) {
		this.tact027 = tact027;
	}

	public Integer getTact028() {
		return tact028;
	}

	public void setTact028(Integer tact028) {
		this.tact028 = tact028;
	}

	public Integer getTact029() {
		return tact029;
	}

	public void setTact029(Integer tact029) {
		this.tact029 = tact029;
	}

	public Long getTact030() {
		return tact030;
	}

	public void setTact030(Long tact030) {
		this.tact030 = tact030;
	}

	public Integer getTact031() {
		return tact031;
	}

	public void setTact031(Integer tact031) {
		this.tact031 = tact031;
	}

	public Integer getTact032() {
		return tact032;
	}

	public void setTact032(Integer tact032) {
		this.tact032 = tact032;
	}

	public Integer getTact033() {
		return tact033;
	}

	public void setTact033(Integer tact033) {
		this.tact033 = tact033;
	}

	public Integer getTact034() {
		return tact034;
	}

	public void setTact034(Integer tact034) {
		this.tact034 = tact034;
	}

	public Integer getTact035() {
		return tact035;
	}

	public void setTact035(Integer tact035) {
		this.tact035 = tact035;
	}

	public Integer getTact036() {
		return tact036;
	}

	public void setTact036(Integer tact036) {
		this.tact036 = tact036;
	}

	public Long getTact037() {
		return tact037;
	}

	public void setTact037(Long tact037) {
		this.tact037 = tact037;
	}

	public Integer getTact038() {
		return tact038;
	}

	public void setTact038(Integer tact038) {
		this.tact038 = tact038;
	}

	public String getTact039() {
		return tact039;
	}

	public void setTact039(String tact039) {
		this.tact039 = tact039;
	}

	public Double getTact040() {
		return tact040;
	}

	public void setTact040(Double tact040) {
		this.tact040 = tact040;
	}

	public String getTact041() {
		return tact041;
	}

	public void setTact041(String tact041) {
		this.tact041 = tact041;
	}

	public Double getTact042() {
		return tact042;
	}

	public void setTact042(Double tact042) {
		this.tact042 = tact042;
	}

	public Integer getTact043() {
		return tact043;
	}

	public void setTact043(Integer tact043) {
		this.tact043 = tact043;
	}
	
	public Integer getTact047() {
		return tact047;
	}

	public void setTact047(Integer tact047) {
		this.tact047 = tact047;
	}

	public Integer getTact049() {
		return tact049;
	}

	public void setTact049(Integer tact049) {
		this.tact049 = tact049;
	}
	
	public String getTact054() {
		return tact054;
	}

	public void setTact054(String tact054) {
		this.tact054 = tact054;
	}

	public List<ExamTTesttx> getData1() {
		return data1;
	}

	public void setData1(List<ExamTTesttx> data1) {
		this.data1 = data1;
	}

	@Override
	protected Serializable pkVal() {
		return this.tact001;
	}
	
}

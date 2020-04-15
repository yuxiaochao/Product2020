package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 教室资源
 * </p>
 *
 * @author caifenglin
 * @since 2019-12-23
 */
@TableName("HR_T_CLASSROOM")
public class Classroom extends Model<Classroom> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("CLAS001")
    private String clas001;
    /**
     * 教室名称
     */
    @TableField("CLAS002")
    private String clas002;
    /**
     * 教室状态（1启用 0禁用）
     */
    @TableField("CLAS003")
    private Integer clas003;
    /**
     * 所在场地
     */
    @TableField("CLAS004")
    private String clas004;
    /**
     * 教室类型(‘0001-20180104-638’)
     */
    @TableField("CLAS005")
    private String clas005;
    
    @TableField(exist = false)
    private String clas005n;
    
    /**
     * 经纬度
     */
    @TableField("CLAS006")
    private String clas006;
    /**
     * 教室容量
     */
    @TableField("CLAS007")
    private Long clas007;
    /**
     * 投影数
     */
    @TableField("CLAS008")
    private Long clas008;
    /**
     * 计算机数量
     */
    @TableField("CLAS009")
    private Long clas009;
    /**
     * 负责人
     */
    @TableField("CLAS010")
    private String clas010;
    /**
     * 联系方式
     */
    @TableField("CLAS011")
    private String clas011;
    /**
     * 备注
     */
    @TableField("CLAS012")
    private String clas012;
    /**
     * 归属单位
     */
    @TableField("CLAS013")
    private String clas013;
    /**
     * 创建人
     */
    @TableField("CLAS014")
    private String clas014;
    /**
     * 创建时间
     */
    @TableField("CLAS015")
    private Date clas015;
    /**
     * 最后修改时间
     */
    @TableField("CLAS016")
    private Date clas016;
    /**
     * 所在楼宇id
     */
    @TableField("CLAS017")
    private String clas017;
    
    @TableField(exist = false)
    private String clas017n;
    
    /**
     * 价格
     */
    @TableField("CLAS018")
    private String clas018;
    /**
     * 价格类型 1.小时 2.半天
     */
    @TableField("CLAS019")
    private Double clas019;
    /**
     * 教室高度（米）
     */
    @TableField("CLAS020")
    private Double clas020;
    /**
     * 经纬度精度范围（米）
     */
    @TableField("CLAS021")
    private Double clas021;

    public String getClas001() {
        return clas001;
    }

    public void setClas001(String clas001) {
        this.clas001 = clas001;
    }

    public String getClas002() {
        return clas002;
    }

    public void setClas002(String clas002) {
        this.clas002 = clas002;
    }

    public Integer getClas003() {
        return clas003;
    }

    public void setClas003(Integer clas003) {
        this.clas003 = clas003;
    }

    public String getClas004() {
        return clas004;
    }

    public void setClas004(String clas004) {
        this.clas004 = clas004;
    }

    public String getClas005() {
        return clas005;
    }

    public void setClas005(String clas005) {
        this.clas005 = clas005;
    }

    public String getClas006() {
        return clas006;
    }

    public void setClas006(String clas006) {
        this.clas006 = clas006;
    }

    public Long getClas007() {
        return clas007;
    }

    public void setClas007(Long clas007) {
        this.clas007 = clas007;
    }

    public Long getClas008() {
        return clas008;
    }

    public void setClas008(Long clas008) {
        this.clas008 = clas008;
    }

    public Long getClas009() {
        return clas009;
    }

    public void setClas009(Long clas009) {
        this.clas009 = clas009;
    }

    public String getClas010() {
        return clas010;
    }

    public void setClas010(String clas010) {
        this.clas010 = clas010;
    }

    public String getClas011() {
        return clas011;
    }

    public void setClas011(String clas011) {
        this.clas011 = clas011;
    }

    public String getClas012() {
        return clas012;
    }

    public void setClas012(String clas012) {
        this.clas012 = clas012;
    }

    public String getClas013() {
        return clas013;
    }

    public void setClas013(String clas013) {
        this.clas013 = clas013;
    }

    public String getClas014() {
        return clas014;
    }

    public void setClas014(String clas014) {
        this.clas014 = clas014;
    }

    public Date getClas015() {
        return clas015;
    }

    public void setClas015(Date clas015) {
        this.clas015 = clas015;
    }

    public Date getClas016() {
        return clas016;
    }

    public void setClas016(Date clas016) {
        this.clas016 = clas016;
    }

    public String getClas017() {
        return clas017;
    }

    public void setClas017(String clas017) {
        this.clas017 = clas017;
    }

    public String getClas018() {
        return clas018;
    }

    public void setClas018(String clas018) {
        this.clas018 = clas018;
    }

    public Double getClas019() {
        return clas019;
    }

    public void setClas019(Double clas019) {
        this.clas019 = clas019;
    }

    public Double getClas020() {
        return clas020;
    }

    public void setClas020(Double clas020) {
        this.clas020 = clas020;
    }

    public Double getClas021() {
        return clas021;
    }

    public void setClas021(Double clas021) {
        this.clas021 = clas021;
    }

    @Override
    protected Serializable pkVal() {
        return this.clas001;
    }
    
    public String getClas005n() {
        return clas005n;
    }

    public void setClas005n(String clas005n) {
        this.clas005n = clas005n;
    }

    public String getClas017n() {
        return clas017n;
    }

    public void setClas017n(String clas017n) {
        this.clas017n = clas017n;
    }

    @Override
    public String toString() {
        return "Classroom{" + "clas001=" + clas001 + ", clas002=" + clas002 + ", clas003=" + clas003 + ", clas004="
                + clas004 + ", clas005=" + clas005 + ", clas006=" + clas006 + ", clas007=" + clas007 + ", clas008="
                + clas008 + ", clas009=" + clas009 + ", clas010=" + clas010 + ", clas011=" + clas011 + ", clas012="
                + clas012 + ", clas013=" + clas013 + ", clas014=" + clas014 + ", clas015=" + clas015 + ", clas016="
                + clas016 + ", clas017=" + clas017 + ", clas018=" + clas018 + ", clas019=" + clas019 + ", clas020="
                + clas020 + ", clas021=" + clas021 + "}";
    }
}

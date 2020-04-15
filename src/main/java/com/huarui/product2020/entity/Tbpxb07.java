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
public class Tbpxb07 extends Model<Tbpxb07> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("PXB0701")
    private String pxb0701;
    /**
     * 培训班ID
     */
    @TableField("PXB0702")
    private String pxb0702;
    /**
     * 课程ID
     */
    @TableField("PXB0703")
    private String pxb0703;
    /**
     * 课程类型0：面授；1：线上课程；2：直播课程
     */
    @TableField("PXB0704")
    private Integer pxb0704;
    /**
     * 达到标准学时 精确到2位小数；
     */
    @TableField("PXB0705")
    private Double pxb0705;
    /**
     * 考核出勤0：否；1：是；DEF（-1）
     */
    @TableField("PXB0706")
    private Double pxb0706;

    /**
     * 课程ID
     */
    @TableField(exist = false)
    private String pxb0203;

    /**
     * 课程名称
     */
    @TableField(exist = false)
    private String pxb0203n;

    /**
     * 培训内容（手动输入的值）
     */
    @TableField(exist = false)
    private String pxb0211;

    /**
     * 培训类型(1:选择，2：手动输入)
     */
    @TableField(exist = false)
    private Integer pxb0212;

    /**
     * 课程形式（面授:0;线上:1;直播:2）
     */
    @TableField(exist = false)
    private Integer pxb0204;

    /**
     * 讲师ID
     */
    @TableField(exist = false)
    private String pxb0210;

    /**
     * 讲师名称
     */
    @TableField(exist = false)
    private String pxb0210n;

    /**
     * 讲师名称(手动输入)
     */
    @TableField(exist = false)
    private String pxb0213;

    /**
     * 讲师类型(1:选择，2：手动输入)
     */
    @TableField(exist = false)
    private Integer pxb0214;

    /**
     * 课程类型0：必修；1：选修；
     */
    @TableField(exist = false)
    private Integer pxb0205;

    /**
     * 学时精确到2位小数；
     */
    @TableField(exist = false)
    private Double pxb0208;

    public String getPxb0701() {
        return pxb0701;
    }

    public void setPxb0701(String pxb0701) {
        this.pxb0701 = pxb0701;
    }

    public String getPxb0702() {
        return pxb0702;
    }

    public void setPxb0702(String pxb0702) {
        this.pxb0702 = pxb0702;
    }

    public String getPxb0703() {
        return pxb0703;
    }

    public void setPxb0703(String pxb0703) {
        this.pxb0703 = pxb0703;
    }

    public Integer getPxb0704() {
        return pxb0704;
    }

    public void setPxb0704(Integer pxb0704) {
        this.pxb0704 = pxb0704;
    }

    public Double getPxb0705() {
        return pxb0705;
    }

    public void setPxb0705(Double pxb0705) {
        this.pxb0705 = pxb0705;
    }

    public Double getPxb0706() {
        return pxb0706;
    }

    public void setPxb0706(Double pxb0706) {
        this.pxb0706 = pxb0706;
    }
    
    public String getPxb0203() {
        return pxb0203;
    }

    public void setPxb0203(String pxb0203) {
        this.pxb0203 = pxb0203;
    }

    public String getPxb0203n() {
        return pxb0203n;
    }

    public void setPxb0203n(String pxb0203n) {
        this.pxb0203n = pxb0203n;
    }

    public String getPxb0211() {
        return pxb0211;
    }

    public void setPxb0211(String pxb0211) {
        this.pxb0211 = pxb0211;
    }

    public Integer getPxb0212() {
        return pxb0212;
    }

    public void setPxb0212(Integer pxb0212) {
        this.pxb0212 = pxb0212;
    }

    public Integer getPxb0204() {
        return pxb0204;
    }

    public void setPxb0204(Integer pxb0204) {
        this.pxb0204 = pxb0204;
    }

    public String getPxb0210() {
        return pxb0210;
    }

    public void setPxb0210(String pxb0210) {
        this.pxb0210 = pxb0210;
    }

    public String getPxb0210n() {
        return pxb0210n;
    }

    public void setPxb0210n(String pxb0210n) {
        this.pxb0210n = pxb0210n;
    }

    public String getPxb0213() {
        return pxb0213;
    }

    public void setPxb0213(String pxb0213) {
        this.pxb0213 = pxb0213;
    }

    public Integer getPxb0214() {
        return pxb0214;
    }

    public void setPxb0214(Integer pxb0214) {
        this.pxb0214 = pxb0214;
    }

    public Integer getPxb0205() {
        return pxb0205;
    }

    public void setPxb0205(Integer pxb0205) {
        this.pxb0205 = pxb0205;
    }

    public Double getPxb0208() {
        return pxb0208;
    }

    public void setPxb0208(Double pxb0208) {
        this.pxb0208 = pxb0208;
    }

    @Override
    protected Serializable pkVal() {
        return this.pxb0701;
    }
    
    

    @Override
    public String toString() {
        return "Tbpxb07{" + "pxb0701=" + pxb0701 + ", pxb0702=" + pxb0702 + ", pxb0703=" + pxb0703 + ", pxb0704="
                + pxb0704 + ", pxb0705=" + pxb0705 + ", pxb0706=" + pxb0706 + "}";
    }
}

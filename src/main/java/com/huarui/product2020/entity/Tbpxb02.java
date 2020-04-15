package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author yuxiaochao
 * @since 2019-10-25
 */
public class Tbpxb02 extends Model<Tbpxb02> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("PXB0201")
    private String pxb0201;
    /**
     * 培训班ID
     */
    @TableField("PXB0202")
    private String pxb0202;

    /**
     * (培训内容)课程ID
     */
    @TableField("PXB0203")
    private String pxb0203;

    /**
     * 培训课程名称
     */
    @TableField(exist = false)
    private String pxb0203n;

    /**
     * 授课方式0：面授；1：线上课程；2：直播课程
     */
    @TableField("PXB0204")
    private Integer pxb0204;

    /**
     * 课程类型0：必修；1：选修；
     */
    @TableField("PXB0205")
    private Integer pxb0205;

    /**
     * 开始时间
     */
    @TableField("PXB0206")
    private Date pxb0206;

    /**
     * 结束时间
     */
    @TableField("PXB0207")
    private Date pxb0207;

    /**
     * 学时精确到2位小数；
     */
    @TableField("PXB0208")
    private Double pxb0208;

    /**
     * 教室主键
     */
    @TableField("PXB0209")
    private String pxb0209;

    /**
     * 教室名称
     */
    @TableField(exist = false)
    private String pxb0209n;

    /**
     * 讲师ID(选择值)
     */
    @TableField("PXB0210")
    private String pxb0210;

    /**
     * 讲师名称
     */
    @TableField(exist = false)
    private String pxb0210n;

    /**
     * 培训内容(手动输入值)
     */
    @TableField("PXB0211")
    private String pxb0211;

    /**
     * 培训类型1:选择；2:手动输入；
     */
    @TableField("PXB0212")
    private Integer pxb0212;

    /**
     * 讲师名称(手动输入值)
     */
    @TableField("PXB0213")
    private String pxb0213;

    /**
     * 讲师类型1:选择；2:手动输入；
     */
    @TableField("PXB0214")
    private Integer pxb0214;

    @Override
    protected Serializable pkVal() {
        return this.pxb0201;
    }

    public String getPxb0201() {
        return pxb0201;
    }

    public void setPxb0201(String pxb0201) {
        this.pxb0201 = pxb0201;
    }

    public String getPxb0202() {
        return pxb0202;
    }

    public void setPxb0202(String pxb0202) {
        this.pxb0202 = pxb0202;
    }

    public String getPxb0203() {
        return pxb0203;
    }

    public void setPxb0203(String pxb0203) {
        this.pxb0203 = pxb0203;
    }

    public Integer getPxb0204() {
        return pxb0204;
    }

    public void setPxb0204(Integer pxb0204) {
        this.pxb0204 = pxb0204;
    }

    public Integer getPxb0205() {
        return pxb0205;
    }

    public void setPxb0205(Integer pxb0205) {
        this.pxb0205 = pxb0205;
    }

    public Date getPxb0206() {
        return pxb0206;
    }

    public void setPxb0206(Date pxb0206) {
        this.pxb0206 = pxb0206;
    }

    public Date getPxb0207() {
        return pxb0207;
    }

    public void setPxb0207(Date pxb0207) {
        this.pxb0207 = pxb0207;
    }

    public Double getPxb0208() {
        return pxb0208;
    }

    public void setPxb0208(Double pxb0208) {
        this.pxb0208 = pxb0208;
    }

    public String getPxb0209() {
        return pxb0209;
    }

    public void setPxb0209(String pxb0209) {
        this.pxb0209 = pxb0209;
    }

    public String getPxb0209n() {
        return pxb0209n;
    }

    public void setPxb0209n(String pxb0209n) {
        this.pxb0209n = pxb0209n;
    }

    public String getPxb0210() {
        return pxb0210;
    }

    public void setPxb0210(String pxb0210) {
        this.pxb0210 = pxb0210;
    }

    public String getPxb0211() {
        return pxb0211;
    }

    public String getPxb0210n() {
        return pxb0210n;
    }

    public void setPxb0210n(String pxb0210n) {
        this.pxb0210n = pxb0210n;
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

    public String getPxb0203n() {
        return pxb0203n;
    }

    public void setPxb0203n(String pxb0203n) {
        this.pxb0203n = pxb0203n;
    }

    @Override
    public String toString() {
        return "Tbpxb02 [pxb0201=" + pxb0201 + ", pxb0202=" + pxb0202 + ", pxb0203=" + pxb0203 + ", pxb0204=" + pxb0204
                + ", pxb0205=" + pxb0205 + ", pxb0206=" + pxb0206 + ", pxb0207=" + pxb0207 + ", pxb0208=" + pxb0208
                + ", pxb0209=" + pxb0209 + ", pxb0210=" + pxb0210 + ", pxb0211=" + pxb0211 + ", pxb0212=" + pxb0212
                + ", pxb0213=" + pxb0213 + ", pxb0214=" + pxb0214 + "]";
    }

}

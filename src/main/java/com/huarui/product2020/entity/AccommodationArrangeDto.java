package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

public class AccommodationArrangeDto extends Model<Academicbuilding> {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String acard001;

    /**
     * 培训班名称
     */
    private String acard002;

    /**
     * 培训开始时间
     */
    private Date acard003;

    /**
     * 培训结束时间
     */
    private Date acard004;

    /**
     * 主办单位
     */
    private String acard005;

    /**
     * 主办单位名称
     */
    private String acard005n;

    /**
     * 班主任ID
     */
    private String acard006;

    /**
     * 班主任名称
     */
    private String acard006n;

    /**
     * 学员数量
     */
    private Integer acard007;

    /**
     * 班主任助理ID
     */
    private String acard008;

    /**
     * 班主任助理名称
     */
    private String acard008n;

    /**
     * 班务助理
     */
    private String acard009;

    /**
     * 班务助理名称
     */
    private String acard009n;

    public String getAcard001() {
        return acard001;
    }

    public void setAcard001(String acard001) {
        this.acard001 = acard001;
    }

    /**
     * 获取培训班名称
     * 
     * @return
     */
    public String getAcard002() {
        return acard002;
    }

    /**
     * 设置培训班名称
     * 
     * @return
     */
    public void setAcard002(String acard002) {
        this.acard002 = acard002;
    }

    public Date getAcard003() {
        return acard003;
    }

    public void setAcard003(Date acard003) {
        this.acard003 = acard003;
    }

    public Date getAcard004() {
        return acard004;
    }

    public void setAcard004(Date acard004) {
        this.acard004 = acard004;
    }

    public String getAcard005() {
        return acard005;
    }

    public void setAcard005(String acard005) {
        this.acard005 = acard005;
    }

    public String getAcard005n() {
        return acard005n;
    }

    public void setAcard005n(String acard005n) {
        this.acard005n = acard005n;
    }

    public String getAcard006() {
        return acard006;
    }

    public void setAcard006(String acard006) {
        this.acard006 = acard006;
    }

    public String getAcard006n() {
        return acard006n;
    }

    public void setAcard006n(String acard006n) {
        this.acard006n = acard006n;
    }

    public Integer getAcard007() {
        return acard007;
    }

    public void setAcard007(Integer acard007) {
        this.acard007 = acard007;
    }

    public String getAcard008() {
        return acard008;
    }

    public void setAcard008(String acard008) {
        this.acard008 = acard008;
    }

    public String getAcard008n() {
        return acard008n;
    }

    public void setAcard008n(String acard008n) {
        this.acard008n = acard008n;
    }

    public String getAcard009() {
        return acard009;
    }

    public void setAcard009(String acard009) {
        this.acard009 = acard009;
    }

    public String getAcard009n() {
        return acard009n;
    }

    public void setAcard009n(String acard009n) {
        this.acard009n = acard009n;
    }

    @Override
    public String toString() {
        return "AccommodationArrangeDto [acard001=" + acard001 + ", acard002=" + acard002 + ", acard003=" + acard003
                + ", acard004=" + acard004 + ", acard005=" + acard005 + ", acard005n=" + acard005n + ", acard006="
                + acard006 + ", acard006n=" + acard006n + ", acard007=" + acard007 + ", acard008=" + acard008
                + ", acard008n=" + acard008n + ", acard009=" + acard009 + ", acard009n=" + acard009n + "]";
    }

    @Override
    protected Serializable pkVal() {
        return this.acard001;
    }

}

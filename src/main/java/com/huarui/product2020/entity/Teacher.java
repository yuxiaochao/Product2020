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
 * @author caifenglin
 * @since 2020-01-07
 */
@TableName("HRSW_T_TEACHER")
public class Teacher extends Model<Teacher> {

    private static final long serialVersionUID = 1L;

    @TableId("TEAC001")
    private String teac001;
    @TableField("TEAC002")
    private String teac002;
    @TableField("TEAC003")
    private String teac003;
    @TableField("TEAC004")
    private String teac004;
    @TableField("TEAC005")
    private String teac005;
    @TableField("TEAC006")
    private Double teac006;
    @TableField("TEAC007")
    private String teac007;
    @TableField("TEAC008")
    private String teac008;
    @TableField("TEAC009")
    private String teac009;
    @TableField("TEAC010")
    private String teac010;
    @TableField("TEAC011")
    private String teac011;
    @TableField("TEAC012")
    private String teac012;
    @TableField("TEAC013")
    private String teac013;
    @TableField("TEAC014")
    private Date teac014;
    @TableField("TEAC015")
    private Date teac015;
    /**
     * 职务
     */
    @TableField("TEAC016")
    private String teac016;
    /**
     * 联系方式
     */
    @TableField("TEAC017")
    private String teac017;
    /**
     * 邮箱
     */
    @TableField("TEAC018")
    private String teac018;
    /**
     * 出生日期
     */
    @TableField("TEAC019")
    private Date teac019;
    /**
     * 地址
     */
    @TableField("TEAC020")
    private String teac020;
    /**
     * 主办单位(ID)
     */
    @TableField("TEAC021")
    private String teac021;
    /**
     * 证件类型
     */
    @TableField("TEAC022")
    private String teac022;
    /**
     * 证件号码
     */
    @TableField("TEAC023")
    private String teac023;
    /**
     * 手机号
     */
    @TableField("TEAC024")
    private String teac024;
    /**
     * 办公电话
     */
    @TableField("TEAC025")
    private String teac025;
    /**
     * 创建人
     */
    @TableField("TEAC026")
    private String teac026;
    /**
     * 是否白名单；0是，1否，默认0
     */
    @TableField("TEAC027")
    private String teac027;

    public String getTeac001() {
        return teac001;
    }

    public void setTeac001(String teac001) {
        this.teac001 = teac001;
    }

    public String getTeac002() {
        return teac002;
    }

    public void setTeac002(String teac002) {
        this.teac002 = teac002;
    }

    public String getTeac003() {
        return teac003;
    }

    public void setTeac003(String teac003) {
        this.teac003 = teac003;
    }

    public String getTeac004() {
        return teac004;
    }

    public void setTeac004(String teac004) {
        this.teac004 = teac004;
    }

    public String getTeac005() {
        return teac005;
    }

    public void setTeac005(String teac005) {
        this.teac005 = teac005;
    }

    public Double getTeac006() {
        return teac006;
    }

    public void setTeac006(Double teac006) {
        this.teac006 = teac006;
    }

    public String getTeac007() {
        return teac007;
    }

    public void setTeac007(String teac007) {
        this.teac007 = teac007;
    }

    public String getTeac008() {
        return teac008;
    }

    public void setTeac008(String teac008) {
        this.teac008 = teac008;
    }

    public String getTeac009() {
        return teac009;
    }

    public void setTeac009(String teac009) {
        this.teac009 = teac009;
    }

    public String getTeac010() {
        return teac010;
    }

    public void setTeac010(String teac010) {
        this.teac010 = teac010;
    }

    public String getTeac011() {
        return teac011;
    }

    public void setTeac011(String teac011) {
        this.teac011 = teac011;
    }

    public String getTeac012() {
        return teac012;
    }

    public void setTeac012(String teac012) {
        this.teac012 = teac012;
    }

    public String getTeac013() {
        return teac013;
    }

    public void setTeac013(String teac013) {
        this.teac013 = teac013;
    }

    public Date getTeac014() {
        return teac014;
    }

    public void setTeac014(Date teac014) {
        this.teac014 = teac014;
    }

    public Date getTeac015() {
        return teac015;
    }

    public void setTeac015(Date teac015) {
        this.teac015 = teac015;
    }

    public String getTeac016() {
        return teac016;
    }

    public void setTeac016(String teac016) {
        this.teac016 = teac016;
    }

    public String getTeac017() {
        return teac017;
    }

    public void setTeac017(String teac017) {
        this.teac017 = teac017;
    }

    public String getTeac018() {
        return teac018;
    }

    public void setTeac018(String teac018) {
        this.teac018 = teac018;
    }

    public Date getTeac019() {
        return teac019;
    }

    public void setTeac019(Date teac019) {
        this.teac019 = teac019;
    }

    public String getTeac020() {
        return teac020;
    }

    public void setTeac020(String teac020) {
        this.teac020 = teac020;
    }

    public String getTeac021() {
        return teac021;
    }

    public void setTeac021(String teac021) {
        this.teac021 = teac021;
    }

    public String getTeac022() {
        return teac022;
    }

    public void setTeac022(String teac022) {
        this.teac022 = teac022;
    }

    public String getTeac023() {
        return teac023;
    }

    public void setTeac023(String teac023) {
        this.teac023 = teac023;
    }

    public String getTeac024() {
        return teac024;
    }

    public void setTeac024(String teac024) {
        this.teac024 = teac024;
    }

    public String getTeac025() {
        return teac025;
    }

    public void setTeac025(String teac025) {
        this.teac025 = teac025;
    }

    public String getTeac026() {
        return teac026;
    }

    public void setTeac026(String teac026) {
        this.teac026 = teac026;
    }

    public String getTeac027() {
        return teac027;
    }

    public void setTeac027(String teac027) {
        this.teac027 = teac027;
    }

    @Override
    protected Serializable pkVal() {
        return this.teac001;
    }

    @Override
    public String toString() {
        return "Teacher{" + "teac001=" + teac001 + ", teac002=" + teac002 + ", teac003=" + teac003 + ", teac004="
                + teac004 + ", teac005=" + teac005 + ", teac006=" + teac006 + ", teac007=" + teac007 + ", teac008="
                + teac008 + ", teac009=" + teac009 + ", teac010=" + teac010 + ", teac011=" + teac011 + ", teac012="
                + teac012 + ", teac013=" + teac013 + ", teac014=" + teac014 + ", teac015=" + teac015 + ", teac016="
                + teac016 + ", teac017=" + teac017 + ", teac018=" + teac018 + ", teac019=" + teac019 + ", teac020="
                + teac020 + ", teac021=" + teac021 + ", teac022=" + teac022 + ", teac023=" + teac023 + ", teac024="
                + teac024 + ", teac025=" + teac025 + ", teac026=" + teac026 + ", teac027=" + teac027 + "}";
    }
}

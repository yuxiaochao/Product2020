package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 宿舍房间资源
 * </p>
 *
 * @author caifenglin
 * @since 2020-01-06
 */
@TableName("HR_T_HOTELROOM")
public class Hotelroom extends Model<Hotelroom> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("HORO001")
    private String horo001;
    
    /**
     * 所属宿舍id
     */
    @TableField("HORO002")
    private String horo002;
    
    /**
     * 房间号
     */
    @TableField("HORO003")
    private String horo003;
    
    /**
     * 宿舍类型（数据字典：(目录表)标准间、套间）
     */
    @TableField("HORO004")
    private String horo004;

    /**
     * 宿舍类型数据字典名称
     */
    @TableField(exist = false)
    private String horo004n;

    /**
     * 所在楼层
     */
    @TableField("HORO005")
    private Integer horo005;
    
    /**
     * 可容纳人数
     */
    @TableField("HORO006")
    private Integer horo006;
    
    /**
     * 上网密码
     */
    @TableField("HORO007")
    private String horo007;
    
    /**
     * 房间电话
     */
    @TableField("HORO008")
    private String horo008;
    
    /**
     * 备注
     */
    @TableField("HORO009")
    private String horo009;
    
    /**
     * 创建人
     */
    @TableField("HORO010")
    private String horo010;
    
    /**
     * 创建时间
     * 
     */
    @TableField("HORO011")
    private Date horo011;
    
    /**
     * 最后修改时间
     */
    @TableField("HORO012")
    private Date horo012;

    public String getHoro001() {
        return horo001;
    }

    public void setHoro001(String horo001) {
        this.horo001 = horo001;
    }

    public String getHoro002() {
        return horo002;
    }

    public void setHoro002(String horo002) {
        this.horo002 = horo002;
    }

    public String getHoro003() {
        return horo003;
    }

    public void setHoro003(String horo003) {
        this.horo003 = horo003;
    }

    public String getHoro004() {
        return horo004;
    }

    public void setHoro004(String horo004) {
        this.horo004 = horo004;
    }

    public Integer getHoro005() {
        return horo005;
    }

    public void setHoro005(Integer horo005) {
        this.horo005 = horo005;
    }

    public Integer getHoro006() {
        return horo006;
    }

    public void setHoro006(Integer horo006) {
        this.horo006 = horo006;
    }

    public String getHoro007() {
        return horo007;
    }

    public void setHoro007(String horo007) {
        this.horo007 = horo007;
    }

    public String getHoro008() {
        return horo008;
    }

    public void setHoro008(String horo008) {
        this.horo008 = horo008;
    }

    public String getHoro009() {
        return horo009;
    }

    public void setHoro009(String horo009) {
        this.horo009 = horo009;
    }

    public String getHoro010() {
        return horo010;
    }

    public void setHoro010(String horo010) {
        this.horo010 = horo010;
    }

    public Date getHoro011() {
        return horo011;
    }

    public void setHoro011(Date horo011) {
        this.horo011 = horo011;
    }

    public Date getHoro012() {
        return horo012;
    }

    public void setHoro012(Date horo012) {
        this.horo012 = horo012;
    }

    @Override
    protected Serializable pkVal() {
        return this.horo001;
    }

    public String getHoro004n() {
        return horo004n;
    }

    public void setHoro004n(String horo004n) {
        this.horo004n = horo004n;
    }

    @Override
    public String toString() {
        return "Hotelroom [horo001=" + horo001 + ", horo002=" + horo002 + ", horo003=" + horo003 + ", horo004="
                + horo004 + ", horo004n=" + horo004n + ", horo005=" + horo005 + ", horo006=" + horo006 + ", horo007="
                + horo007 + ", horo008=" + horo008 + ", horo009=" + horo009 + ", horo010=" + horo010 + ", horo011="
                + horo011 + ", horo012=" + horo012 + "]";
    }

    
}

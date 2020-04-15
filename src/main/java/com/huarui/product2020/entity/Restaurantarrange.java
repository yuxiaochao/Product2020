package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * 餐厅安排
 * </p>
 *
 * @author caifenglin
 * @since 2020-01-14
 */
@TableName("HR_T_RESTAURANTARRANGE")
public class Restaurantarrange extends Model<Restaurantarrange> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("REAR001")
    private String rear001;

    /**
     * 培训班ID
     */
    @TableField("REAR002")
    private String rear002;

    /**
     * 学员数量
     */
    @TableField("REAR003")
    private Integer rear003;

    /**
     * 餐厅ID
     */
    @TableField("REAR004")
    private String rear004;

    /**
     * 餐厅名称
     */
    @TableField(exist = false)
    private String rear004n;

    /**
     * 餐厅地点
     */
    @TableField("REAR005")
    private String rear005;

    /**
     * 发布状态(0:未发布;1:已发布)
     */
    @TableField("REAR006")
    private Integer rear006;

    public String getRear001() {
        return rear001;
    }

    public void setRear001(String rear001) {
        this.rear001 = rear001;
    }

    public String getRear002() {
        return rear002;
    }

    public void setRear002(String rear002) {
        this.rear002 = rear002;
    }

    public Integer getRear003() {
        return rear003;
    }

    public void setRear003(Integer rear003) {
        this.rear003 = rear003;
    }

    public String getRear004() {
        return rear004;
    }

    public void setRear004(String rear004) {
        this.rear004 = rear004;
    }

    public String getRear004n() {
        return rear004n;
    }

    public void setRear004n(String rear004n) {
        this.rear004n = rear004n;
    }

    public String getRear005() {
        return rear005;
    }

    public void setRear005(String rear005) {
        this.rear005 = rear005;
    }

    public Integer getRear006() {
        return rear006;
    }

    public void setRear006(Integer rear006) {
        this.rear006 = rear006;
    }

    @Override
    protected Serializable pkVal() {
        return this.rear001;
    }

    @Override
    public String toString() {
        return "Restaurantarrange [rear001=" + rear001 + ", rear002=" + rear002 + ", rear003=" + rear003 + ", rear004="
                + rear004 + ", rear004n=" + rear004n + ", rear005=" + rear005 + ", rear006=" + rear006 + "]";
    }



}

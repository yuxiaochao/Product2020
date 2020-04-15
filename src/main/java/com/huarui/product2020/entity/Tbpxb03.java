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
public class Tbpxb03 extends Model<Tbpxb03> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("PXB0301")
    private String pxb0301;
    /**
     * 培训班ID
     */
    @TableField("PXB0302")
    private String pxb0302;
    /**
     * 角色类型0：班主任；1：班主任助理； 2：班务助理
     */
    @TableField("PXB0303")
    private Integer pxb0303;
    /**
     * 人员ID
     */
    @TableField("PXB0304")
    private String pxb0304;

    @TableField(exist = false)
    private String pxb0304n;

    @TableField("PXB0305")
    private String pxb0305;

    public String getPxb0301() {
        return pxb0301;
    }

    public void setPxb0301(String pxb0301) {
        this.pxb0301 = pxb0301;
    }

    public String getPxb0302() {
        return pxb0302;
    }

    public void setPxb0302(String pxb0302) {
        this.pxb0302 = pxb0302;
    }

    public Integer getPxb0303() {
        return pxb0303;
    }

    public void setPxb0303(Integer pxb0303) {
        this.pxb0303 = pxb0303;
    }

    public String getPxb0304() {
        return pxb0304;
    }

    public void setPxb0304(String pxb0304) {
        this.pxb0304 = pxb0304;
    }

    public String getPxb0305() {
        return pxb0305;
    }

    public void setPxb0305(String pxb0305) {
        this.pxb0305 = pxb0305;
    }
    

    public String getPxb0304n() {
        return pxb0304n;
    }

    public void setPxb0304n(String pxb0304n) {
        this.pxb0304n = pxb0304n;
    }

    @Override
    protected Serializable pkVal() {
        return this.pxb0301;
    }

    @Override
    public String toString() {
        return "Tbpxb03{" + "pxb0301=" + pxb0301 + ", pxb0302=" + pxb0302 + ", pxb0303=" + pxb0303 + ", pxb0304="
                + pxb0304 + ", pxb0305=" + pxb0305 + "}";
    }
}

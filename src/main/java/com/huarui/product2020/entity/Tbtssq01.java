package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;

import java.io.Serializable;

/**
 * <p>
 * 图书申请
 * </p>
 *
 * @author caifl
 * @since 2020-04-01
 */
public class Tbtssq01 extends Model<Tbtssq01> {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 订单ID
     */
    @TableField(exist = false)
    private String tssq0101;

    /**
     * 订单号
     */
    @TableField(exist = false)
    private String tssq0102;

    /**
     * 商品名称
     */
    @TableField(exist = false)
    private String tssq0103;

    /**
     * 图书名称
     */
    @TableField(exist = false)
    private String tssq0104;

    public String getTssq0101() {
        return tssq0101;
    }

    public void setTssq0101(String tssq0101) {
        this.tssq0101 = tssq0101;
    }

    public String getTssq0102() {
        return tssq0102;
    }

    public void setTssq0102(String tssq0102) {
        this.tssq0102 = tssq0102;
    }

    public String getTssq0103() {
        return tssq0103;
    }

    public void setTssq0103(String tssq0103) {
        this.tssq0103 = tssq0103;
    }

    public String getTssq0104() {
        return tssq0104;
    }

    public void setTssq0104(String tssq0104) {
        this.tssq0104 = tssq0104;
    }

    @Override
    protected Serializable pkVal() {
        return this.tssq0101;
    }

    @Override
    public String toString() {
        return "Tbtssq01 [tssq0101=" + tssq0101 + ", tssq0102=" + tssq0102 + ", tssq0103=" + tssq0103 + ", tssq0104="
                + tssq0104 + "]";
    }
    

}

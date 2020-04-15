package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 图书申请记录
 * </p>
 *
 * @author caifl
 * @since 2020-04-03
 */
public class Tbtssq02 extends Model<Tbtssq02> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("TSSQ0201")
    private String tssq0201;
    
    /**
     * 订单ID（tbDD01）
     */
    @TableField("TSSQ0202")
    private String tssq0202;
    
    /**
     * 快递
     */
    @TableField("TSSQ0203")
    private String tssq0203;
    
    /**
     * 快递单号
     */
    @TableField("TSSQ0204")
    private String tssq0204;
    
    /**
     * 快递时间
     */
    @TableField("TSSQ0205")
    private Date tssq0205;
    
    /**
     * 状态(0:待邮寄;1:已邮寄)
     */
    @TableField("TSSQ0206")
    private Integer tssq0206;
    
    /**
     * 调书单号
     */
    @TableField("TSSQ0207")
    private String tssq0207;
    
    /**
     * 申请时间
     */
    @TableField("TSSQ0208")
    private Date tssq0208;
    
    @TableField(exist = false)
    private String tssq0208n;
    
    /**
     * 用户邮寄地址表tbUSIF02
     */
    @TableField("TSSQ0209")
    private String tssq0209;
    
    /**
     * 用户ID（HRSW_T_USER）
     */
    @TableField("TSSQ0210")
    private String tssq0210;
    
    /**
     * 代理机构ID（HRSW_T_ORGAN）
     */
    @TableField("TSSQ0211")
    private String tssq0211;
    
    /**
     * 订单号
     */
    @TableField(exist = false)
    private String orderNumber;
    
    /**
     * 商品
     */
    @TableField(exist = false)
    private String bookName;

    public String getTssq0201() {
        return tssq0201;
    }

    public void setTssq0201(String tssq0201) {
        this.tssq0201 = tssq0201;
    }

    public String getTssq0202() {
        return tssq0202;
    }

    public void setTssq0202(String tssq0202) {
        this.tssq0202 = tssq0202;
    }

    public String getTssq0203() {
        return tssq0203;
    }

    public void setTssq0203(String tssq0203) {
        this.tssq0203 = tssq0203;
    }

    public String getTssq0204() {
        return tssq0204;
    }

    public void setTssq0204(String tssq0204) {
        this.tssq0204 = tssq0204;
    }

    public Date getTssq0205() {
        return tssq0205;
    }

    public void setTssq0205(Date tssq0205) {
        this.tssq0205 = tssq0205;
    }

    public Integer getTssq0206() {
        return tssq0206;
    }

    public void setTssq0206(Integer tssq0206) {
        this.tssq0206 = tssq0206;
    }

    public String getTssq0207() {
        return tssq0207;
    }

    public void setTssq0207(String tssq0207) {
        this.tssq0207 = tssq0207;
    }

    public Date getTssq0208() {
        return tssq0208;
    }

    public void setTssq0208(Date tssq0208) {
        this.tssq0208 = tssq0208;
    }

    public String getTssq0209() {
        return tssq0209;
    }

    public void setTssq0209(String tssq0209) {
        this.tssq0209 = tssq0209;
    }

    public String getTssq0210() {
        return tssq0210;
    }

    public void setTssq0210(String tssq0210) {
        this.tssq0210 = tssq0210;
    }

    public String getTssq0211() {
        return tssq0211;
    }

    public void setTssq0211(String tssq0211) {
        this.tssq0211 = tssq0211;
    }
    

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getTssq0208n() {
        return tssq0208n;
    }

    public void setTssq0208n(String tssq0208n) {
        this.tssq0208n = tssq0208n;
    }

    @Override
    protected Serializable pkVal() {
        return this.tssq0201;
    }

    @Override
    public String toString() {
        return "Tbtssq02{" + "tssq0201=" + tssq0201 + ", tssq0202=" + tssq0202 + ", tssq0203=" + tssq0203
                + ", tssq0204=" + tssq0204 + ", tssq0205=" + tssq0205 + ", tssq0206=" + tssq0206 + ", tssq0207="
                + tssq0207 + ", tssq0208=" + tssq0208 + ", tssq0209=" + tssq0209 + ", tssq0210=" + tssq0210
                + ", tssq0211=" + tssq0211 + "}";
    }
}

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
 * @author caifl
 * @since 2020-04-03
 */
public class Tbcmdy11 extends Model<Tbcmdy11> {

    private static final long serialVersionUID = 1L;

    @TableId("CMDY1101")
	private String cmdy1101;
    
	@TableField("CMDY1102")
	private String cmdy1102;
	
	@TableField("CMDY1103")
	private String cmdy1103;
	
	@TableField(exist = false)
	private String cmdy1103n;
	
	@TableField("CMDY1104")
	private Integer cmdy1104;
	
	@TableField(exist = false)
	private String productImage;
	
	@TableField(exist = false)
	private Double productPrice;


	public String getCmdy1101() {
		return cmdy1101;
	}

	public void setCmdy1101(String cmdy1101) {
		this.cmdy1101 = cmdy1101;
	}

	public String getCmdy1102() {
		return cmdy1102;
	}

	public void setCmdy1102(String cmdy1102) {
		this.cmdy1102 = cmdy1102;
	}

	public String getCmdy1103() {
		return cmdy1103;
	}

	public void setCmdy1103(String cmdy1103) {
		this.cmdy1103 = cmdy1103;
	}

	public Integer getCmdy1104() {
		return cmdy1104;
	}

	public void setCmdy1104(Integer cmdy1104) {
		this.cmdy1104 = cmdy1104;
	}
	

	public String getCmdy1103n() {
        return cmdy1103n;
    }

    public void setCmdy1103n(String cmdy1103n) {
        this.cmdy1103n = cmdy1103n;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    @Override
	protected Serializable pkVal() {
		return this.cmdy1101;
	}

	@Override
	public String toString() {
		return "Tbcmdy11{" +
			"cmdy1101=" + cmdy1101 +
			", cmdy1102=" + cmdy1102 +
			", cmdy1103=" + cmdy1103 +
			", cmdy1104=" + cmdy1104 +
			"}";
	}
}

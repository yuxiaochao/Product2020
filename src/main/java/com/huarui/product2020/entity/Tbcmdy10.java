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
 * @since 2020-04-07
 */
public class Tbcmdy10 extends Model<Tbcmdy10> {

    private static final long serialVersionUID = 1L;

    @TableId("CMDY1001")
	private String cmdy1001;
    
	@TableField("CMDY1002")
	private String cmdy1002;
	
	@TableField("CMDY1003")
	private String cmdy1003;
	
	@TableField("CMDY1004")
	private Double cmdy1004;
	
	@TableField("CMDY1005")
	private String cmdy1005;
	
	/**
	 * 商品图片地址
	 */
	@TableField(exist = false)
    private String productImage;
	
	/**
     * 商品名称
     */
	@TableField(exist = false)
    private String productName;
	
	/**
	 * 商品价格
	 */
	@TableField(exist = false)
    private Double productPrice;
	
	/**
	 * 套包ID
	 */
	@TableField(exist = false)
	private String cmdy0601;
	
	/**
	 * 套包组合名称
	 */
	@TableField(exist = false)
	private String cmdy0603;
	
	/**
	 * 课程ID
	 */
	@TableField(exist = false)
    private String cour001;
	
	/**
	 * 我的商品套包表tbWDKC01
	 */
	@TableField(exist = false)
    private String wdkc0101;
	
	


	public String getCmdy1001() {
		return cmdy1001;
	}

	public void setCmdy1001(String cmdy1001) {
		this.cmdy1001 = cmdy1001;
	}

	public String getCmdy1002() {
		return cmdy1002;
	}

	public void setCmdy1002(String cmdy1002) {
		this.cmdy1002 = cmdy1002;
	}

	public String getCmdy1003() {
		return cmdy1003;
	}

	public void setCmdy1003(String cmdy1003) {
		this.cmdy1003 = cmdy1003;
	}

	public Double getCmdy1004() {
		return cmdy1004;
	}

	public void setCmdy1004(Double cmdy1004) {
		this.cmdy1004 = cmdy1004;
	}

	public String getCmdy1005() {
		return cmdy1005;
	}

	public void setCmdy1005(String cmdy1005) {
		this.cmdy1005 = cmdy1005;
	}
	
	public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    
    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }
    

    public String getCmdy0601() {
        return cmdy0601;
    }

    public void setCmdy0601(String cmdy0601) {
        this.cmdy0601 = cmdy0601;
    }

    public String getCmdy0603() {
        return cmdy0603;
    }

    public void setCmdy0603(String cmdy0603) {
        this.cmdy0603 = cmdy0603;
    }
    
    public String getCour001() {
        return cour001;
    }

    public void setCour001(String cour001) {
        this.cour001 = cour001;
    }

    public String getWdkc0101() {
        return wdkc0101;
    }

    public void setWdkc0101(String wdkc0101) {
        this.wdkc0101 = wdkc0101;
    }

    @Override
	protected Serializable pkVal() {
		return this.cmdy1001;
	}

    @Override
    public String toString() {
        return "Tbcmdy10 [cmdy1001=" + cmdy1001 + ", cmdy1002=" + cmdy1002 + ", cmdy1003=" + cmdy1003 + ", cmdy1004="
                + cmdy1004 + ", cmdy1005=" + cmdy1005 + ", productImage=" + productImage + ", productName="
                + productName + "]";
    }
	
}

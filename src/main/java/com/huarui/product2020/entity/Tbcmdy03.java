package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author panlei
 * @since 2020-02-15
 */
public class Tbcmdy03 extends Model<Tbcmdy03> {

    private static final long serialVersionUID = 1L;

    @TableId("CMDY0301")
	private String cmdy0301;
	@TableField("CMDY0302")
	private Double cmdy0302;
	@TableField("CMDY0303")
	private String cmdy0303;
	@TableField("CMDY0304")
	private String cmdy0304;
	@TableField("CMDY0305")
	private String cmdy0305;
	@TableField("CMDY0306")
	private String cmdy0306;
    /**
     * 目录类型 1.  批量添加，商品分类ID和专业字典ID从商品字典中选择，目录名称是年度和分类的拼接。
2.  手动添加，不从商品字典中选择，所以商品分类ID为空，保存的是分项名称和目录名称，均为手填。

     */
	@TableField("CMDY0307")
	private Double cmdy0307;
	@TableField("CMDY0308")
	private Date cmdy0308;
	@TableField("CMDY0309")
	private String cmdy0309;
	@TableField("CMDY0310")
	private String cmdy0310;
	@TableField("CMDY0311")
	private String cmdy0311;
    /**
     * 有效期类型 0：时间段；1：时长
     */
	@TableField("CMDY0312")
	private Double cmdy0312;
	@TableField("CMDY0313")
	private Date cmdy0313;
	@TableField("CMDY0314")
	private Double cmdy0314;
    /**
     * 显示方式 0：不显示；1：PC显示，APP不显示；2：PC不显示，APP显示；
3：PC显示，APP显示；
     */
	@TableField("CMDY0315")
	private Double cmdy0315;
	@TableField("CMDY0316")
	private String cmdy0316;
	@TableField("CMDY0317")
	private String cmdy0317;
	@TableField("CMDY0318")
	private String cmdy0318;
	@TableField("CMDY0319")
	private String cmdy0319;
    /**
     * 状态 1.未上架   2.已上架  3.已下架
     */
	@TableField("CMDY0320")
	private Double cmdy0320;
	@TableField("CMDY0321")
	private Date cmdy0321;
    /**
     * 首页显示  0.否  1.是
     */
	@TableField("CMDY0322")
	private Double cmdy0322;
	
	@TableField("CMDY0326")
	private String cmdy0326;
	
	@TableField("CMDY0325")
	private String cmdy0325;
	
	/**
	 * 有效期
	 */
	@TableField(exist = false)
	private String cmdy0312t;

	@TableField(exist = false)
	private Tbcmdy09 tbcmdy09;
	
	@TableField(exist = false)
    List<Tbcmdy06> tbcmdy06List;

	public String getCmdy0301() {
		return cmdy0301;
	}

	public void setCmdy0301(String cmdy0301) {
		this.cmdy0301 = cmdy0301;
	}

	public Double getCmdy0302() {
		return cmdy0302;
	}

	public void setCmdy0302(Double cmdy0302) {
		this.cmdy0302 = cmdy0302;
	}

	public String getCmdy0303() {
		return cmdy0303;
	}

	public void setCmdy0303(String cmdy0303) {
		this.cmdy0303 = cmdy0303;
	}

	public String getCmdy0304() {
		return cmdy0304;
	}

	public void setCmdy0304(String cmdy0304) {
		this.cmdy0304 = cmdy0304;
	}

	public String getCmdy0305() {
		return cmdy0305;
	}

	public void setCmdy0305(String cmdy0305) {
		this.cmdy0305 = cmdy0305;
	}

	public String getCmdy0306() {
		return cmdy0306;
	}

	public void setCmdy0306(String cmdy0306) {
		this.cmdy0306 = cmdy0306;
	}

	public Double getCmdy0307() {
		return cmdy0307;
	}

	public void setCmdy0307(Double cmdy0307) {
		this.cmdy0307 = cmdy0307;
	}

	public Date getCmdy0308() {
		return cmdy0308;
	}

	public void setCmdy0308(Date cmdy0308) {
		this.cmdy0308 = cmdy0308;
	}

	public String getCmdy0309() {
		return cmdy0309;
	}

	public void setCmdy0309(String cmdy0309) {
		this.cmdy0309 = cmdy0309;
	}

	public String getCmdy0310() {
		return cmdy0310;
	}

	public void setCmdy0310(String cmdy0310) {
		this.cmdy0310 = cmdy0310;
	}

	public String getCmdy0311() {
		return cmdy0311;
	}

	public void setCmdy0311(String cmdy0311) {
		this.cmdy0311 = cmdy0311;
	}

	public Double getCmdy0312() {
		return cmdy0312;
	}

	public void setCmdy0312(Double cmdy0312) {
		this.cmdy0312 = cmdy0312;
	}

	public Date getCmdy0313() {
		return cmdy0313;
	}

	public void setCmdy0313(Date cmdy0313) {
		this.cmdy0313 = cmdy0313;
	}

	public Double getCmdy0314() {
		return cmdy0314;
	}

	public void setCmdy0314(Double cmdy0314) {
		this.cmdy0314 = cmdy0314;
	}

	public Double getCmdy0315() {
		return cmdy0315;
	}

	public void setCmdy0315(Double cmdy0315) {
		this.cmdy0315 = cmdy0315;
	}

	public String getCmdy0316() {
		return cmdy0316;
	}

	public void setCmdy0316(String cmdy0316) {
		this.cmdy0316 = cmdy0316;
	}

	public String getCmdy0317() {
		return cmdy0317;
	}

	public void setCmdy0317(String cmdy0317) {
		this.cmdy0317 = cmdy0317;
	}

	public String getCmdy0318() {
		return cmdy0318;
	}

	public void setCmdy0318(String cmdy0318) {
		this.cmdy0318 = cmdy0318;
	}

	public String getCmdy0319() {
		return cmdy0319;
	}

	public void setCmdy0319(String cmdy0319) {
		this.cmdy0319 = cmdy0319;
	}

	public Double getCmdy0320() {
		return cmdy0320;
	}

	public void setCmdy0320(Double cmdy0320) {
		this.cmdy0320 = cmdy0320;
	}

	public Date getCmdy0321() {
		return cmdy0321;
	}

	public void setCmdy0321(Date cmdy0321) {
		this.cmdy0321 = cmdy0321;
	}

	public Double getCmdy0322() {
		return cmdy0322;
	}

	public void setCmdy0322(Double cmdy0322) {
		this.cmdy0322 = cmdy0322;
	}
	
	

	public String getCmdy0312t() {
		return cmdy0312t;
	}

	public void setCmdy0312t(String cmdy0312t) {
		this.cmdy0312t = cmdy0312t;
	}

	public Tbcmdy09 getTbcmdy09() {
		return tbcmdy09;
	}

	public void setTbcmdy09(Tbcmdy09 tbcmdy09) {
		this.tbcmdy09 = tbcmdy09;
	}

	public List<Tbcmdy06> getTbcmdy06List() {
		return tbcmdy06List;
	}

	public void setTbcmdy06List(List<Tbcmdy06> tbcmdy06List) {
		this.tbcmdy06List = tbcmdy06List;
	}
	

	public String getCmdy0326() {
		return cmdy0326;
	}

	public void setCmdy0326(String cmdy0326) {
		this.cmdy0326 = cmdy0326;
	}

	public String getCmdy0325() {
		return cmdy0325;
	}

	public void setCmdy0325(String cmdy0325) {
		this.cmdy0325 = cmdy0325;
	}

	@Override
	protected Serializable pkVal() {
		return this.cmdy0301;
	}

	@Override
	public String toString() {
		return "Tbcmdy03{" +
			"cmdy0301=" + cmdy0301 +
			", cmdy0302=" + cmdy0302 +
			", cmdy0303=" + cmdy0303 +
			", cmdy0304=" + cmdy0304 +
			", cmdy0305=" + cmdy0305 +
			", cmdy0306=" + cmdy0306 +
			", cmdy0307=" + cmdy0307 +
			", cmdy0308=" + cmdy0308 +
			", cmdy0309=" + cmdy0309 +
			", cmdy0310=" + cmdy0310 +
			", cmdy0311=" + cmdy0311 +
			", cmdy0312=" + cmdy0312 +
			", cmdy0313=" + cmdy0313 +
			", cmdy0314=" + cmdy0314 +
			", cmdy0315=" + cmdy0315 +
			", cmdy0316=" + cmdy0316 +
			", cmdy0317=" + cmdy0317 +
			", cmdy0318=" + cmdy0318 +
			", cmdy0319=" + cmdy0319 +
			", cmdy0320=" + cmdy0320 +
			", cmdy0321=" + cmdy0321 +
			", cmdy0322=" + cmdy0322 +
			"}";
	}
}

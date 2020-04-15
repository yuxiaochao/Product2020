package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author panlei
 * @since 2020-02-15
 */
public class Tbcmdy04 extends Model<Tbcmdy04> {

    private static final long serialVersionUID = 1L;

    @TableId("CMDY0401")
	private String cmdy0401;
	@TableField("CMDY0402")
	private String cmdy0402;
	@TableField("CMDY0403")
	private String cmdy0403;
	@TableField("CMDY0404")
	private String cmdy0404;
    /**
     * 商品类型 0：虚拟类；1：实物类
     */
	@TableField("CMDY0405")
	private Double cmdy0405;
	@TableField("CMDY0406")
	private String cmdy0406;
	@TableField("CMDY0407")
	private Double cmdy0407;
    /**
     * 有效期类型 0：时间段；1：时长
     */
	@TableField("CMDY0408")
	private Double cmdy0408;
    /**
     * 有效截止时间 针对时间段
     */
	@TableField("CMDY0409")
	private Date cmdy0409;
    /**
     * 时长（天） 针对“时长”
     */
	@TableField("CMDY0410")
	private Double cmdy0410;
	@TableField("CMDY0411")
	private Double cmdy0411;
    /**
     * 显示方式 0：不显示；1：PC显示，APP不显示；2：PC不显示，APP显示；3：PC显示，APP显示；
     */
	@TableField("CMDY0412")
	private Double cmdy0412;
    /**
     * 推荐图书 0：否；1：是
     */
	@TableField("CMDY0413")
	private Double cmdy0413;
	@TableField("CMDY0414")
	private String cmdy0414;
	@TableField("CMDY0415")
	private Double cmdy0415;
	@TableField("CMDY0417")
	private String cmdy0417;
	@TableField("CMDY0418")
	private String cmdy0418;
	@TableField("CMDY0419")
	private Date cmdy0419;
	@TableField("CMDY0420")
	private Date cmdy0420;
	@TableField("CMDY0416")
	private String cmdy0416;
	@TableField("CMDY0421")
	private String cmdy0421;
	@TableField("CMDY0422")
	private Double cmdy0422;
	@TableField("CMDY0423")
	private String cmdy0423;


	public String getCmdy0401() {
		return cmdy0401;
	}

	public void setCmdy0401(String cmdy0401) {
		this.cmdy0401 = cmdy0401;
	}

	public String getCmdy0402() {
		return cmdy0402;
	}

	public void setCmdy0402(String cmdy0402) {
		this.cmdy0402 = cmdy0402;
	}

	public String getCmdy0403() {
		return cmdy0403;
	}

	public void setCmdy0403(String cmdy0403) {
		this.cmdy0403 = cmdy0403;
	}

	public String getCmdy0404() {
		return cmdy0404;
	}

	public void setCmdy0404(String cmdy0404) {
		this.cmdy0404 = cmdy0404;
	}

	public Double getCmdy0405() {
		return cmdy0405;
	}

	public void setCmdy0405(Double cmdy0405) {
		this.cmdy0405 = cmdy0405;
	}

	public String getCmdy0406() {
		return cmdy0406;
	}

	public void setCmdy0406(String cmdy0406) {
		this.cmdy0406 = cmdy0406;
	}

	public Double getCmdy0407() {
		return cmdy0407;
	}

	public void setCmdy0407(Double cmdy0407) {
		this.cmdy0407 = cmdy0407;
	}

	public Double getCmdy0408() {
		return cmdy0408;
	}

	public void setCmdy0408(Double cmdy0408) {
		this.cmdy0408 = cmdy0408;
	}

	public Date getCmdy0409() {
		return cmdy0409;
	}

	public void setCmdy0409(Date cmdy0409) {
		this.cmdy0409 = cmdy0409;
	}

	public Double getCmdy0410() {
		return cmdy0410;
	}

	public void setCmdy0410(Double cmdy0410) {
		this.cmdy0410 = cmdy0410;
	}

	public Double getCmdy0411() {
		return cmdy0411;
	}

	public void setCmdy0411(Double cmdy0411) {
		this.cmdy0411 = cmdy0411;
	}

	public Double getCmdy0412() {
		return cmdy0412;
	}

	public void setCmdy0412(Double cmdy0412) {
		this.cmdy0412 = cmdy0412;
	}

	public Double getCmdy0413() {
		return cmdy0413;
	}

	public void setCmdy0413(Double cmdy0413) {
		this.cmdy0413 = cmdy0413;
	}

	public String getCmdy0414() {
		return cmdy0414;
	}

	public void setCmdy0414(String cmdy0414) {
		this.cmdy0414 = cmdy0414;
	}

	public Double getCmdy0415() {
		return cmdy0415;
	}

	public void setCmdy0415(Double cmdy0415) {
		this.cmdy0415 = cmdy0415;
	}

	public String getCmdy0417() {
		return cmdy0417;
	}

	public void setCmdy0417(String cmdy0417) {
		this.cmdy0417 = cmdy0417;
	}

	public String getCmdy0418() {
		return cmdy0418;
	}

	public void setCmdy0418(String cmdy0418) {
		this.cmdy0418 = cmdy0418;
	}

	public Date getCmdy0419() {
		return cmdy0419;
	}

	public void setCmdy0419(Date cmdy0419) {
		this.cmdy0419 = cmdy0419;
	}

	public Date getCmdy0420() {
		return cmdy0420;
	}

	public void setCmdy0420(Date cmdy0420) {
		this.cmdy0420 = cmdy0420;
	}

	public String getCmdy0416() {
		return cmdy0416;
	}

	public void setCmdy0416(String cmdy0416) {
		this.cmdy0416 = cmdy0416;
	}

	public String getCmdy0421() {
		return cmdy0421;
	}

	public void setCmdy0421(String cmdy0421) {
		this.cmdy0421 = cmdy0421;
	}

	public Double getCmdy0422() {
		return cmdy0422;
	}

	public void setCmdy0422(Double cmdy0422) {
		this.cmdy0422 = cmdy0422;
	}

	public String getCmdy0423() {
		return cmdy0423;
	}

	public void setCmdy0423(String cmdy0423) {
		this.cmdy0423 = cmdy0423;
	}

	@Override
	protected Serializable pkVal() {
		return this.cmdy0401;
	}

	@Override
	public String toString() {
		return "Tbcmdy04{" +
			"cmdy0401=" + cmdy0401 +
			", cmdy0402=" + cmdy0402 +
			", cmdy0403=" + cmdy0403 +
			", cmdy0404=" + cmdy0404 +
			", cmdy0405=" + cmdy0405 +
			", cmdy0406=" + cmdy0406 +
			", cmdy0407=" + cmdy0407 +
			", cmdy0408=" + cmdy0408 +
			", cmdy0409=" + cmdy0409 +
			", cmdy0410=" + cmdy0410 +
			", cmdy0411=" + cmdy0411 +
			", cmdy0412=" + cmdy0412 +
			", cmdy0413=" + cmdy0413 +
			", cmdy0414=" + cmdy0414 +
			", cmdy0415=" + cmdy0415 +
			", cmdy0417=" + cmdy0417 +
			", cmdy0418=" + cmdy0418 +
			", cmdy0419=" + cmdy0419 +
			", cmdy0420=" + cmdy0420 +
			", cmdy0416=" + cmdy0416 +
			", cmdy0421=" + cmdy0421 +
			", cmdy0422=" + cmdy0422 +
			", cmdy0423=" + cmdy0423 +
			"}";
	}
}

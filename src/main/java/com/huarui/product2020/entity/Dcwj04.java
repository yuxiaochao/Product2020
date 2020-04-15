package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 问卷试题表
 * </p>
 *
 * @author pl
 * @since 2019-12-21
 */
public class Dcwj04 extends Model<Dcwj04> {

    private static final long serialVersionUID = 1L;

    /**
     * 	pk
     */
    @TableId("DCWJ0401")
	private String dcwj0401;
    /**
     * 	分项
     */
	@TableField("DCWJ0402")
	private String dcwj0402;
    /**
     * 	试题题干
     */
	@TableField("DCWJ0403")
	private String dcwj0403;
    /**
     * 题型 0：单选；1：多选；2：填空；3：问答；4：矩阵单选；5：矩阵多选
     */
	@TableField("DCWJ0404")
	private Double dcwj0404;
    /**
     * 是否必答 0：否；1：是
     */
	@TableField("DCWJ0405")
	private Double dcwj0405;
    /**
     * 启用提示语 0：否；1：是；
     */
	@TableField("DCWJ0406")
	private String dcwj0406;
    /**
     * 提示语
     */
	@TableField("DCWJ0407")
	private String dcwj0407;
    /**
     * 启用无条件跳题 0：否；1：是；
     */
	@TableField("DCWJ0408")
	private String dcwj0408;
    /**
     * 跳题ID
     */
	@TableField("DCWJ0409")
	private Double dcwj0409;
    /**
     * 启用逻辑跳题 0：否；1：是；
     */
	@TableField("DCWJ0410")
	private Double dcwj0410;
    /**
     * 试题顺序
     */
	@TableField("DCWJ0411")
	private Double dcwj0411;
    /**
     * 选择题是否随机 0：否；1：是；
     */
	@TableField("DCWJ0412")
	private Double dcwj0412;
    /**
     * 	多选题至少选择个数 0：无限制
     */
	@TableField("DCWJ0413")
	private Double dcwj0413;
    /**
     * 多选题最多选择个数 0：无限制
     */
	@TableField("DCWJ0414")
	private Double dcwj0414;

	 /**
     * 纯文本试题题干
     */
	@TableField("DCWJ0415")
	private String dcwj0415;
	
	 /**
     * 候选项跳题 0：否；1：是；
     */
	@TableField("DCWJ0416")
	private Double dcwj0416;
	
	 /**
     * 多项填空题文本框样式 0：否；1：是；
     */
	@TableField("DCWJ0417")
	private Double dcwj0417;

	/**
	 * 问卷试题候选项表
	 */
	@TableField(exist=false)
    List<Dcwj05> dcwj05;
	
	/**
	 * 问卷试题填空要求表
	 */
	@TableField(exist=false)
    List<Dcwj06> dcwj06;
	
	public String getDcwj0401() {
		return dcwj0401;
	}

	public void setDcwj0401(String dcwj0401) {
		this.dcwj0401 = dcwj0401;
	}

	public String getDcwj0402() {
		return dcwj0402;
	}

	public void setDcwj0402(String dcwj0402) {
		this.dcwj0402 = dcwj0402;
	}

	

	public String getDcwj0403() {
		return dcwj0403;
	}

	public void setDcwj0403(String dcwj0403) {
		this.dcwj0403 = dcwj0403;
	}

	public Double getDcwj0404() {
		return dcwj0404;
	}

	public void setDcwj0404(Double dcwj0404) {
		this.dcwj0404 = dcwj0404;
	}

	public Double getDcwj0405() {
		return dcwj0405;
	}

	public void setDcwj0405(Double dcwj0405) {
		this.dcwj0405 = dcwj0405;
	}

	public String getDcwj0406() {
		return dcwj0406;
	}

	public void setDcwj0406(String dcwj0406) {
		this.dcwj0406 = dcwj0406;
	}


	
	public String getDcwj0407() {
		return dcwj0407;
	}

	public void setDcwj0407(String dcwj0407) {
		this.dcwj0407 = dcwj0407;
	}

	public String getDcwj0408() {
		return dcwj0408;
	}

	public void setDcwj0408(String dcwj0408) {
		this.dcwj0408 = dcwj0408;
	}

	public Double getDcwj0409() {
		return dcwj0409;
	}

	public void setDcwj0409(Double dcwj0409) {
		this.dcwj0409 = dcwj0409;
	}

	public Double getDcwj0410() {
		return dcwj0410;
	}

	public void setDcwj0410(Double dcwj0410) {
		this.dcwj0410 = dcwj0410;
	}

	public Double getDcwj0411() {
		return dcwj0411;
	}

	public void setDcwj0411(Double dcwj0411) {
		this.dcwj0411 = dcwj0411;
	}

	public Double getDcwj0412() {
		return dcwj0412;
	}

	public void setDcwj0412(Double dcwj0412) {
		this.dcwj0412 = dcwj0412;
	}

	public Double getDcwj0413() {
		return dcwj0413;
	}

	public void setDcwj0413(Double dcwj0413) {
		this.dcwj0413 = dcwj0413;
	}

	public Double getDcwj0414() {
		return dcwj0414;
	}

	public void setDcwj0414(Double dcwj0414) {
		this.dcwj0414 = dcwj0414;
	}

	@Override
	protected Serializable pkVal() {
		return this.dcwj0401;
	}

	
	public String getDcwj0415() {
		return dcwj0415;
	}

	public void setDcwj0415(String dcwj0415) {
		this.dcwj0415 = dcwj0415;
	}

	public Double getDcwj0416() {
		return dcwj0416;
	}

	public void setDcwj0416(Double dcwj0416) {
		this.dcwj0416 = dcwj0416;
	}

	public Double getDcwj0417() {
		return dcwj0417;
	}

	public void setDcwj0417(Double dcwj0417) {
		this.dcwj0417 = dcwj0417;
	}
	
	


	public List<Dcwj05> getDcwj05() {
		return dcwj05;
	}

	public void setDcwj05(List<Dcwj05> dcwj05) {
		this.dcwj05 = dcwj05;
	}

	public List<Dcwj06> getDcwj06() {
		return dcwj06;
	}

	public void setDcwj06(List<Dcwj06> dcwj06) {
		this.dcwj06 = dcwj06;
	}

	@Override
	public String toString() {
		return "Dcwj04{" +
			"dcwj0401=" + dcwj0401 +
			", dcwj0402=" + dcwj0402 +
			", dcwj0403=" + dcwj0403 +
			", dcwj0404=" + dcwj0404 +
			", dcwj0405=" + dcwj0405 +
			", dcwj0406=" + dcwj0406 +
			", dcwj0407=" + dcwj0407 +
			", dcwj0408=" + dcwj0408 +
			", dcwj0409=" + dcwj0409 +
			", dcwj0410=" + dcwj0410 +
			", dcwj0411=" + dcwj0411 +
			", dcwj0412=" + dcwj0412 +
			", dcwj0413=" + dcwj0413 +
			", dcwj0414=" + dcwj0414 +
			"}";
	}
}

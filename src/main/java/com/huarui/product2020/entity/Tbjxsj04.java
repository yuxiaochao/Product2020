package com.huarui.product2020.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 
 * </p>
 *
 * @author yuxiaochao
 * @since 2019-10-25
 */
public class Tbjxsj04 extends Model<Tbjxsj04> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("JXSJ0401")
	private String jxsj0401;
    /**
     * 培训班ID
     */
	@TableField("JXSJ0402")
	private String jxsj0402;
    /**
     * 课程ID或培训日程id
     */
	@TableField("JXSJ0403")
	private String jxsj0403;
    /**
     * 附件名称
     */
	@TableField("JXSJ0404")
	private String jxsj0404;
    /**
     * 大小
     */
	@TableField("JXSJ0405")
	private Double jxsj0405;
    /**
     * 文件格式
     */
	@TableField("JXSJ0406")
	private String jxsj0406;
    /**
     * 附件路径
     */
	@TableField("JXSJ0407")
	private String jxsj0407;
    /**
     * 上传人id
     */
	@TableField("JXSJ0408")
	private String jxsj0408;
    /**
     * 上传时间
     */
	@TableField("JXSJ0409")
	private Date jxsj0409;
	 /**
     * 403的类型：1课程id,2培训日程id 
     */
	@TableField("JXSJ0410")
	private Integer jxsj0410;
	@TableField(exist=false)
	private String jxsj0409n;
	@TableField(exist=false)
	private String user005;
	@TableField(exist=false)
	private List<Tbjhzd03> tbjhzd03List;
	@TableField(exist=false)
	private String jxsj0405n;
	@TableField(exist=false)
	private List<Map<String, String>> optionList;
	public String getJxsj0405n() {
		return jxsj0405n;
	}

	public void setJxsj0405n(String jxsj0405n) {
		this.jxsj0405n = jxsj0405n;
	}

	public List<Tbjhzd03> getTbjhzd03List() {
		return tbjhzd03List;
	}

	public void setTbjhzd03List(List<Tbjhzd03> tbjhzd03List) {
		this.tbjhzd03List = tbjhzd03List;
	}

	public String getJxsj0409n() {
		return jxsj0409n;
	}

	public void setJxsj0409n(String jxsj0409n) {
		this.jxsj0409n = jxsj0409n;
	}

	public String getUser005() {
		return user005;
	}

	public void setUser005(String user005) {
		this.user005 = user005;
	}

	public String getJxsj0401() {
		return jxsj0401;
	}

	public void setJxsj0401(String jxsj0401) {
		this.jxsj0401 = jxsj0401;
	}

	public String getJxsj0402() {
		return jxsj0402;
	}

	public void setJxsj0402(String jxsj0402) {
		this.jxsj0402 = jxsj0402;
	}

	public String getJxsj0403() {
		return jxsj0403;
	}

	public void setJxsj0403(String jxsj0403) {
		this.jxsj0403 = jxsj0403;
	}

	public String getJxsj0404() {
		return jxsj0404;
	}

	public void setJxsj0404(String jxsj0404) {
		this.jxsj0404 = jxsj0404;
	}

	public Double getJxsj0405() {
		return jxsj0405;
	}

	public void setJxsj0405(Double jxsj0405) {
		this.jxsj0405 = jxsj0405;
	}

	public String getJxsj0406() {
		return jxsj0406;
	}

	public void setJxsj0406(String jxsj0406) {
		this.jxsj0406 = jxsj0406;
	}

	public String getJxsj0407() {
		return jxsj0407;
	}

	public void setJxsj0407(String jxsj0407) {
		this.jxsj0407 = jxsj0407;
	}

	public String getJxsj0408() {
		return jxsj0408;
	}

	public void setJxsj0408(String jxsj0408) {
		this.jxsj0408 = jxsj0408;
	}

	public Date getJxsj0409() {
		return jxsj0409;
	}

	public void setJxsj0409(Date jxsj0409) {
		this.jxsj0409 = jxsj0409;
	}
	
	public Integer getJxsj0410() {
		return jxsj0410;
	}

	public void setJxsj0410(Integer jxsj0410) {
		this.jxsj0410 = jxsj0410;
	}

	public List<Map<String, String>> getOptionList() {
		return optionList;
	}

	public void setOptionList(List<Map<String, String>> optionList) {
		this.optionList = optionList;
	}

	@Override
	protected Serializable pkVal() {
		return this.jxsj0401;
	}

	@Override
	public String toString() {
		return "Tbjxsj04{" +
			"jxsj0401=" + jxsj0401 +
			", jxsj0402=" + jxsj0402 +
			", jxsj0403=" + jxsj0403 +
			", jxsj0404=" + jxsj0404 +
			", jxsj0405=" + jxsj0405 +
			", jxsj0406=" + jxsj0406 +
			", jxsj0407=" + jxsj0407 +
			", jxsj0408=" + jxsj0408 +
			", jxsj0409=" + jxsj0409 +
			"}";
	}
}

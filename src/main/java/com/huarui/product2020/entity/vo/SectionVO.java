package com.huarui.product2020.entity.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 章节
 */
public class SectionVO implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    /**
     * 课程id
     */
	private String courseid;
	/**
     * 章节名称
     */
	private String ccwe003;
	/**
     * 学习总结果表ID
     */
	private String lcwr0104;
	/**
     * 	用户ID
     */
	private String lcwr0103;
    /**
     * 章节ID
     */
	private String ccwe001;
    /**
     * 是否完成 0：未学 1：在学 2：已完成
     */
	private Integer lcwr0110;
    /**
     * 	章节课件总时长
     */
	private Integer cour005;
    /**
     * 	当前播放章节最大播放位置（秒）
     */
	private Integer lcwr0107;
    /**
     * 是否更新完成 （0未更新 1已更新）
     */
	private Integer lcwr0111;

	private List<SectionVO> sectionList;

    public String getCcwe003() {
        return ccwe003;
    }

    public void setCcwe003(String ccwe003) {
        this.ccwe003 = ccwe003;
    }

    public String getCcwe001() {
        return ccwe001;
    }

    public void setCcwe001(String ccwe001) {
        this.ccwe001 = ccwe001;
    }

    public Integer getLcwr0110() {
        return lcwr0110;
    }

    public void setLcwr0110(Integer lcwr0110) {
        this.lcwr0110 = lcwr0110;
    }

    public Integer getCour005() {
        return cour005;
    }

    public void setCour005(Integer cour005) {
        this.cour005 = cour005;
    }

    public Integer getLcwr0107() {
        return lcwr0107;
    }

    public void setLcwr0107(Integer lcwr0107) {
        this.lcwr0107 = lcwr0107;
    }

    public List<SectionVO> getSectionList() {
        return sectionList;
    }

    public void setSectionList(List<SectionVO> sectionList) {
        this.sectionList = sectionList;
    }

    public Integer getLcwr0111() {
        return lcwr0111;
    }

    public void setLcwr0111(Integer lcwr0111) {
        this.lcwr0111 = lcwr0111;
    }

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    public String getLcwr0104() {
        return lcwr0104;
    }

    public void setLcwr0104(String lcwr0104) {
        this.lcwr0104 = lcwr0104;
    }

    public String getLcwr0103() {
        return lcwr0103;
    }

    public void setLcwr0103(String lcwr0103) {
        this.lcwr0103 = lcwr0103;
    }
}

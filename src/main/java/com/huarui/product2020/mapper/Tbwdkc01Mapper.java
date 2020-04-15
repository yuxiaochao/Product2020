package com.huarui.product2020.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.huarui.common.utils.IPage;
import com.huarui.product2020.entity.Tbclassaskquestions01;
import com.huarui.product2020.entity.Tbwdkc01;
import com.huarui.product2020.entity.vo.SectionVO;

import java.util.List;
import java.util.Map;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author su
 * @since 2020-02-13
 */
public interface Tbwdkc01Mapper extends BaseMapper<Tbwdkc01> {

    /**
     * 查询
     * 我的课程——套包list
     */
    public List<Tbwdkc01> findbyCoursePackageList(Tbwdkc01 tbwdkc01);

    /**
     * 我的课程——完成订单加入课程
     */
    public void addCoursePackage(Map param);

    /**
     * 进入课程——课程详细信息
     */
    public Map<String, String> findbyCourseInformation(Map map);

    /**
     * 进入课程——获取 评价数、问答讨论数、笔记数
     */
    public Map<String, String> findbyCourseNumber(Map map);

    /**
     * 进入课程——课程详细信息——章节列表
     */
    public List<SectionVO> findbyCourseSectionList(Map map);

    /**
     * 进入课程——切换章节
     */
    public Map<String, Object> findbyCourseSwitchSection(Map map);


    /**
     * 课程播放——更新进度
     */
    public int updateProgress(Map map);

    /**
     * 查询
     * 课程问答——问答列表
     */
    public List<Tbclassaskquestions01> findbyCourseQuestionsAndAnswersList(IPage evaluationPage,Tbclassaskquestions01 tbclassaskquestions01);

    /**
     * 查询
     * 课程问答——浏览问题
     */
    public List<Tbclassaskquestions01> browseTheQuestions(IPage evaluationPage,Tbclassaskquestions01 tbclassaskquestions01);

    /**
     * 查询
     * 我的课程——套包list
     */
    public List<Map> courseRecord(Tbwdkc01 tbwdkc01);

    /**
     * 课程评价——获取 评价信息
     * @param cour001 课程ID
     */
    public Map<String, Object> findbyCommentInformatica(String cour001);

    /**
     * 课程回答——采纳答案
     * @param claq0201 回答内容id
     */
    public int toAdoptToAnswer(String claq0201);


    /**
     * 课程回答——问题浏览数加一
     * @param claq0101 题目ID
     */
    public int increaseTheNumberOfViews(String claq0101);



}
package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.common.utils.IPage;
import com.huarui.product2020.entity.Tbclassaskquestions01;
import com.huarui.product2020.entity.Tbwdkc01;
import com.huarui.product2020.entity.vo.SectionVO;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author su
 * @since 2020-02-13
 */
public interface ITbwdkc01Service extends IService<Tbwdkc01> {


    /**
     * 查询
     * 我的课程——套包list
     */
    public List<Tbwdkc01> findbyCoursePackageList(Tbwdkc01 tbwdkc01);

    /**
     * 我的课程——完成订单加入课程
     */
    public String addCoursePackage(Map param);

    /**
     * 进入课程——课程详细信息
     * @param wdkc0201 我的商品表ID
     * @param cmdy0503 课程ID
     */
    public Map<String, String> findbyCourseInformation(String wdkc0201, String cmdy0503);

    /**
     * 进入课程——课程详细信息——章节列表
     * @param wdkc0201 我的商品表ID
     * @param cmdy0503 课程ID
     */
    public List<SectionVO> findbyCourseSectionList(String wdkc0201, String cmdy0503);

    /**
     * 进入课程——切换章节
     * @param wdkc0201 我的商品表ID
     * @param cmdy0503 课程ID
     * @param ccwe001 章节ID
     * @param lere0101 课程结果表id
     * @param userId 用户id
     */
    public Map<String, Object> findbyCourseSwitchSection(String wdkc0201, String cmdy0503, String ccwe001, String lere0101, String userId);

    /**
     * 课程播放——记录进度
     * @param wdkc0201 我的商品表ID
     * @param cour001 课程ID
     * @param ccwe001 章节ID
     * @param lcwr0107 章节播放位置
     * @param lcwr0110 该章节是否完成 0否 1是
     * @param userid 用户id
     * @param lere0101 学习课程结果表id
     * @param kjjd0106 学习端来源 0：PC端 1：IOS手机端 2：Android手机3：IOS-Pad 4：Android-Pad
     */
    public String recordProgress(String wdkc0201, String cour001, String ccwe001, String lcwr0107, String lcwr0110, String userid, String lere0101, String kjjd0106) throws Exception;

    /**
     * 课程播放——记录进度
     * @param wdkc0201 我的商品表ID
     * @param cour001 课程ID
     * @param ccwe001 章节ID
     * @param lcwr0107 章节播放位置
     * @param lcwr0110 该章节是否完成 0否 1是
     */
    public String recordProgress02(String wdkc0201, String cour001, String ccwe001, String lcwr0107, String lcwr0110, String userid, String lere0101);

    /**
     * 课程播放——更新进度
     * @param wdkc0201 我的商品表ID
     * @param cour001 课程ID
     * @param userid 用户id
     * @param lere0101 学习课程结果表id
     */
    public String updateProgress(String wdkc0201, String cour001, String userid, String lere0101);

    /**
     * 查询
     * 课程问答——问答列表
     */
    public IPage findbyCourseQuestionsAndAnswersList(IPage evaluationPage, Tbclassaskquestions01 tbclassaskquestions01);

    /**
     * 查询
     * 课程问答——浏览问题
     */
    public IPage browseTheQuestions(IPage evaluationPage, Tbclassaskquestions01 tbclassaskquestions01);

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
    public String toAdoptToAnswer(String claq0201);

    /**
     * 课程回答——问题浏览数加一
     * @param claq0101 题目ID
     */
    public String increaseTheNumberOfViews(String claq0101);

    /**
     * 课程评价——获取 评价信息
     * @param cour001 课程ID
     */
    public Map<String, String> findbyCourseNumber(String cour001, String ccwe001);
	
}

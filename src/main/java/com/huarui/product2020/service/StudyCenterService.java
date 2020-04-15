package com.huarui.product2020.service;

import com.huarui.common.utils.IPage;

import java.util.List;
import java.util.Map;

public interface StudyCenterService {
	
	/**
	 * 选课中心
	 * @return
	 */
	public List<Map<String, Object>> queryStudyCenterPage(String userid, String type) throws Exception;
	
	/**
	 * 根据用户ID、资源编码查找主办单位
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> findOrganByUPCode(Map<String, Object> map) throws Exception;
	
	/**
	 * 目录树
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> findCatalogByUser(Map<String, Object> map) throws Exception;
	
	
	/**
	 * 选课  加入学习任务
	 * @param map
	 * @return
	 */
	public boolean selectCource(Map<String, Object> map);

	/**
	 * 课程预览页面
	 * 课件列表
	 * @param courseWarePage
	 * @param leac001
	 * @param user001 
	 * @return
	 * @throws Exception
	 */
	public IPage queryStudyCourseWareList(IPage courseWarePage, Map<String, Object> paramMap) throws Exception;

	/**
	 * 课程预览页面
	 * 课程详情
	 * @param leac001
	 * @return
	 * @throws Exception
	 */
	public Map queryStudyCourseInfo(String leac001) throws Exception;

	/**
	 * 课程详情
	 * 主讲人列表
	 * @param leac001
	 * @return
	 * @throws Exception
	 */
	public List queryCourseSpeakerList(String leac001) throws Exception;

	/**
	 * 课程详情
	 * 评论总数
	 * @param user001
	 * @param leac001
	 * @return
	 * @throws Exception
	 */
	public Map queryEvaluationNumMap(Map<String, Object> paramMap) throws Exception;

	/**
	 * 课程详情
	 * 评论列表
	 * @param evaluationPage 
	 * @param user001
	 * @param leac001
	 * @return
	 * @throws Exception
	 */
	public IPage queryCourseEvaluationList(IPage evaluationPage, Map<String, Object> paramMap) throws Exception;

	/**
	 * 学员沟通 点赞
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public int spotFabulous(Map<String, Object> paramMap) throws Exception;

	/**
	 * 在线学习 笔记列表
	 * @param noteListPage
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public IPage queryStudyNoteList(IPage noteListPage, Map<String, Object> paramMap) throws Exception;

	//评论数量
	List queryCourseEvaluationNum(Map<String, Object> paramMap);

	/**
	 * 课程信息-不同结业方式下的课程完成情况
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public Map queryCompletionStatus(Map<String, Object> paramMap) throws Exception;

	/**
	 * 课程信息-学习次数/好评数/是否已经选课
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public Map queryStudyTimesAndPraiseNum(Map<String, Object> paramMap) throws Exception;

	/**
	 * 在线学习-课程列表
	 * @param onlineStudyPage
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public IPage queryOnlineStudyList(IPage onlineStudyPage, Map<String, Object> paramMap) throws Exception;

	/**
	 * 在线学习-课程完成情况
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public Map queryCourseResultMap(Map<String, Object> paramMap) throws Exception;

	/**
	 * 课程下的所有课件
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List getCoursewareList(Map map) throws Exception;

	/**
	 * 课程下所有课件的完成状态
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List findLearnCwResultList(Map map) throws Exception;

	/**
	 * 课程的试卷信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Map queryExamInformation(Map map) throws Exception;

	/**
	 * 课件全部完成 查找最近播放的课件
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public Map findPlayWhichCourseware(Map<String, Object> paramMap) throws Exception;

	/**
	 * 选课中心-第一级目录
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List queryFirstLevelDirectory(Map<String, Object> paramMap) throws Exception;

	/**
	 * 选课中心-第二级目录
	 * @param cata001
	 * @return
	 * @throws Exception
	 */
	public List querySecondLevelDirectory(String cata001) throws Exception;

	/**
	 * 选课中心-课程列表
	 * @param selectCoursePage
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public IPage querySelectCourseList(IPage selectCoursePage, Map<String, Object> paramMap) throws Exception;

	/**
	 * 离开页面更新学员的课件学习结果表和学员学习总结果表
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public int exitCacheCoursewareProgress(Map<String, Object> paramMap) throws Exception;

	/**
	 * 课件学习完成 更新课件学习结果
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public boolean updateLearnCWRsult(Map<String, Object> paramMap) throws Exception;

	/**
	 * 课程学习-结业
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public boolean courseGraduation(Map<String, Object> paramMap) throws Exception;

	/**
	 * 课程学习-首次进入学习插入课件结果、学习结果，只操作一次
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public boolean firstInsertLearnResult(Map<String, Object> paramMap) throws Exception;

	/**
	 * 选课中心-主讲人列表
	 * @param paramMap 
	 * @return
	 * @throws Exception
	 */
	public List queryLecturerList(Map<String, Object> paramMap) throws Exception;

	/**
	 * 课程学习-结业考试
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public List queryStudyFinalExamList(Map<String, Object> paramMap) throws Exception;


	/*
	*//**
	 * 根据类删除
	 * 
	 * @param userresourcerelationEntity
	 *//*
	public int deleteByEntity(Map map);
	
	*/
	
	/*
	*//**
	 * 课程预览页面
	 * 课件列表
	 * @return
	 *//*
	public List<Map<String, Object>> queryStudyCourseWareList(Object[]args);*/

	/**
	 * 课程学习-收藏
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public int collection(Map<String, Object> paramMap) throws Exception;
	/**
	 * 课程学习-取消收藏
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public int cancelCollection(Map<String, Object> paramMap) throws Exception;

	//学习笔记-点赞 //更新数量
	void upStudyNoteFabulous(Map<String, Object> paramMap);
	//学习笔记-点赞
	void StudyNoteFabulous(Map<String, Object> paramMap);
}

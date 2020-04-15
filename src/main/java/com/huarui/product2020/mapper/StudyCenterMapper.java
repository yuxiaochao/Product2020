package com.huarui.product2020.mapper;

import java.util.List;
import java.util.Map;

import com.huarui.common.utils.IPage;

public interface StudyCenterMapper {

	/**
	 * 选课中心
	 * 
	 * @return
	 */
	public List<Map<String, Object>> queryStudyCenterPage(String userid,String type) throws Exception;
	
	/**
	 * 根据用户ID、资源编码查找主办单位
	 * @param map
	 * @return
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
	 * 
	 * @param map
	 * @return
	 */
	public long selectCource(Map<String, Object> map);

	/**
	 * 课程预览
	 * 课件列表
	 * @param courseWarePage
	 * @param leac001
	 * @param user001 
	 * @return
	 * @throws Exception
	 */
	public List queryStudyCourseWareList(IPage courseWarePage, Map<String, Object> paramMap) throws Exception;

	/**
	 * 课程预览
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
	public List queryCourseEvaluationList(IPage evaluationPage, Map<String, Object> paramMap) throws Exception;

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
	public List queryStudyNoteList(IPage noteListPage, Map<String, Object> paramMap) throws Exception;

	/**
	 * 评论总数
	 * @param paramMap
	 * @return
	 */
	List queryCourseEvaluationNum(Map<String, Object> paramMap);

	/**
	 * 课程信息-学时结业方式课程完成情况
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public Map queryHoursCompletionStatus(Map<String, Object> paramMap) throws Exception;

	/**
	 * 课程信息-考试结业方式课程完成情况
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public Map queryExamCompletionStatus(Map<String, Object> paramMap) throws Exception;

	/**
	 * 课程信息-学时和考试结业方式课程完成情况
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public Map queryHoursAndExamCompletionStatus(Map<String, Object> paramMap) throws Exception;

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
	public List queryOnlineStudyList(IPage onlineStudyPage, Map<String, Object> paramMap) throws Exception;

	/**
	 * 在线学习-课程信息
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
	public List getCoursewareList(Map map)  throws Exception;

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
	public List querySelectCourseList(IPage selectCoursePage, Map<String, Object> paramMap) throws Exception;

	/**
	 * 离开页面更新学员的课件学习结果表
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public boolean exitViewUpdateCwProgress(Map<String, Object> paramMap) throws Exception;

	/**
	 * 离开页面更新学员的学习总结果表
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public boolean exitViewUpdateLRProgress(Map<String, Object> paramMap) throws Exception;

	/**
	 * 课程学习-课件学习完成 更新课件学习结果
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public boolean updateLearnCWRsult(Map<String, Object> paramMap) throws Exception;

	/**
	 * 更新学员学习总结果表
	 * @param paramMap
	 * @return
	 */
	public boolean updateLearnResult(Map<String, Object> paramMap) throws Exception;

	/**
	 * 更新学员学时表，考试结业，获得学时是该课程下的全部学时
	 * @param paramMap
	 * @return
	 */
	public boolean updateCAllUserHours(Map<String, Object> paramMap) throws Exception;

	/**
	 * 更新学员学时表
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public boolean updateUserHours(Map<String, Object> paramMap) throws Exception;

	/**
	 * 课程学习-学员学习总结果表
	 * @param paramMap
	 * @return
	 */
	public boolean insertLearnResult(Map<String, Object> paramMap) throws Exception;

	/**
	 * 课程学习-首次学习插入记录
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public boolean insertLearnCwResult(Map<String, Object> paramMap) throws Exception;

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

	void StudyNoteFabulous(Map<String, Object> paramMap);
	//学习笔记-点赞 //更新数量
	void upStudyNoteFabulous(Map<String, Object> paramMap);
	//取消点赞
	void deStudyNoteFabulous(Map<String, Object> paramMap);
}

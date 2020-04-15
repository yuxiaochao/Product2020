package com.huarui.product2020.service;

import com.huarui.common.utils.IPage;
import com.huarui.product2020.entity.ExamTExergrade;
import com.huarui.product2020.entity.ExamTTestactivity;
import com.huarui.product2020.pojo.ExamineeGrade;

import java.util.List;
import java.util.Map;

public interface OnlineExamListService {

	/**
	 * 在线考试
	 * 考试列表
	 * @param
	 * @return
	 */
	public IPage<ExamTTestactivity> queryOnlineExamList(IPage<ExamTTestactivity> page, Map<String, Object> map) throws Exception;
	
	/**
	 * 在线考试
	 * 考试须知
	 * @param userid
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> queryExamInfo(Map<String, Object> map) throws Exception;
	
	/**
	 * 在线考试
	 * 考试结果
	 * @param userid
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> queryExamResult(String egra001) throws Exception;
	
	/**
	 * 在线考试
	 * 检查考生参考次数
	 * @param userid
	 * @return
	 * @throws Exception
	 */
	public int queryExamTimes(String userid, String tact001) throws Exception;
	
	/**
	 * 在线考试
	 * 获取指定id的答卷信息Map
	 * @param userid
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> findExamGrade(String userid, String wlgid, String tpid, int randpapers, boolean create) throws Exception;
	
	/**
	 * 在线考试
	 * 试卷试题题型
	 * @param userid
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> findTestTxById(Map<String, Object> map) throws Exception;
	
	/**
	 * 在线考试试卷内容
	 * 固定试卷
	 * @param tact001 serialNO
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> queryExamFixTopicList(Map<String, Object> map) throws Exception;
	
	/**
	 * 在线考试试卷内容
	 * 固定试卷  子题
	 * @param tact001 serialNO
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> queryExamFixTopicChildList(Map<String, Object> map) throws Exception;
	
	/**
	 * 在线考试
	 * 获取试卷信息，并且指定是固定试卷还是随机试卷
	 * @param userid
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> getTestPaperById(String tact001) throws Exception;
	
	/**
	 * 查询试卷试题答案列表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Map findTopicAnswerByExamId(Map args) throws Exception;
	
	/**
	 * 题库练习目录
	 * @param model
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> findByPageObjectForUser(Map<String, Object> args) throws Exception;
	
	/**
	 * 获取所选题库对应一级题库
	 * @return
	 */
	public List findAllExerciseList(Map<String, Object> map);
	
	/**
	 * 在线考试试卷内容
	 * 查看答卷
	 * @param tact001 serialNO
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> queryExamFixTopicList1(Map<String, Object> map) throws Exception;
	
	/**
	 * 查看试卷
	 * 获取学员固定试卷答案
	 * @param tact001 serialNO
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> queryUserAnswer(Map<String, Object> map) throws Exception;
	
	public Map<String, String> findTopicSystemAnswer(String tpid, String egid, int serialNO) throws Exception;
	
	public Map<String, String> findTopicSystemAnswer2(String tpid, String egid) throws Exception;
	
	/**
	 * 添加或更新题目学员答案
	 * @param examineeGrade
	 * @param json
	 * @param examGraduationMap
	 * @throws Exception
	 */
	public void updateExamGrade(ExamineeGrade examineeGrade, List gradeList, Map examGraduationMap) throws Exception;
	/**
	 * 在线考试
	 * 题库列表
	 * @param
	 * @return
	 */
	public List<Map<String, Object>> tk_list(Map<String, Object> map) throws Exception;
	/**
	 * 在线考试
	 * 题库练习目录
	 * @param
	 * @return
	 */
	public List<Map<String, Object>> tk_practiseDir(Map<String, Object> map) throws Exception;
	

	/**
	 * 获取全部知识点以及每个知识点里的题目数
	 * @return
	 */
	public List findKnowledgesList(Map<String, Object> map);
	
	/**
	 * 往成绩表里插入一条数据
	 * @return
	 */
	public void insertGrade(Map<String, Object> map);

	public List<Map<String, Object>> tk_practiseContent(Map<String, Object> map) throws Exception;

	public Map<String, Object> findRightAndError(String tpid);
	/**
	 * 在线考试题库列表
	 *
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> selectOnLineExerciseList(Map<String, Object> map) throws Exception;
	
	/**题型数目
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> selectCountType(String st) throws Exception;
	/**
	 * 生成随机试题试卷
	 * @param map
	 */
	public void insertPractiseContent(Map<String, Object> map);
	
	public void insert_findTopicByExerciseId(Map<String, Object> map) throws Exception;
	
	public void insert_findTopicByExerciseId1(Map<String, Object> map) throws Exception;
	
	public void insert_exerGrade(Map<String, Object> map) throws Exception;
	
	public void insertExerSampleContent(Map<String, Object> map) throws Exception;
	
	public List<Map<String, Object>> queryExamFixTopicList2(Map<String, Object> map) throws Exception;
	/**
	 * 查询练习答案列表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Map findTopicAnswerByExerciseId(Map<String, Object> map) throws Exception;
	/**
	 * 查询
	 * @param map
	 * @return
	 * @throws Exception
	 */
	
	public void update_exerAnswerTopic(Map<String, Object> map) throws Exception;
	public void insert_exerAnswerTopic(Map<String, Object> map) throws Exception;
	public Map<String, Object> queryExerciseResult(String s1) throws Exception;
	public Map selectExerSample(String s1) throws Exception;
	public List<Map<String, Object>> findExerciseTxById(Map<String, Object> map) throws Exception;
	public List<Map<String, Object>> findAnwserTopic(Map<String, Object> map) throws Exception;
	/**
	 * 添加或更新题目学员答案
	 * @param examineeGrade
	 * @param json
	 * @param examGraduationMap
	 * @throws Exception
	 */
	public void updateExerGrade(ExamTExergrade examineeGrade, List gradeList) throws Exception;
	
	public List<Map<String, Object>> queryExamFixTopicList3(Map<String, Object> map) throws Exception;
	public List<Map<String, Object>> findExerciseRecordByUserId(String st) throws Exception;
	IPage selectExerciseHistoryPage(IPage page, Map arg) throws Exception;
	/**
	 * 我的 练习记录详情(一次考试活动对应的考试记录)
	 * @param user001
	 * @param tact001
	 * @return
	 * @throws Exception
	 */
	IPage findExerciseRecordByUserId(IPage page, String user001, String tact001) throws Exception;
	
	/**
	 * 获取所选题库对应一级题库
	 * @return
	 */
	public List findExerciseList1(Map<String, Object> map);
	/**
	 * 获取全部知识点以及每个知识点里的题目数
	 * @return
	 */
	public List findKnowledgesList1(Map<String, Object> map);
	
	public Map<String, Object> findExerciseDetailsById(String st);
	
}

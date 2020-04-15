package com.huarui.product2020.mapper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.huarui.product2020.entity.ExamTExergrade;
import com.huarui.product2020.entity.ExamTTestactivity;
import com.huarui.product2020.pojo.ExamineeGrade;

public interface OnlineExamListMapper {

	/**
	 * 在线考试
	 * 考试列表
	 * @param req
	 * @return
	 */
	public List<ExamTTestactivity> queryOnlineExamList(Pagination page,Map<String, Object> map) throws Exception;
	
	/**
	 * 在线考试
	 * 考试须知
	 * @param tact001
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> queryExamInfo(Map<String, Object> map) throws Exception;
	
	/**
	 * 在线考试
	 * 考试结果
	 * @param tact001
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> queryExamResult(String egra001) throws Exception;
	
	/**
	 * 在线考试
	 * 检查考生参考次数
	 * @param tact001
	 * @return
	 * @throws Exception
	 */
	public int queryExamTimes(String userid,String tact001) throws Exception;
	
	/**
	 * 在线考试
	 * 获取指定id的答卷信息Map
	 * @param tact001
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> findExamGrade(String userid,String tact001) throws Exception;
	
	/**
	 * 在线考试
	 * 试卷试题题型
	 * @param tact001
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> findTestTxById(Map<String, Object> map) throws Exception;
	
	/**
	 * 在线考试试卷内容
	 * 固定试卷
	 * @param tact001
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> queryExamFixTopicList(Map<String, Object> map) throws Exception;
	
	/**
	 * 在线考试试卷内容
	 * 固定试卷  子题
	 * @param tact001
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> queryExamFixTopicChildList(Map<String, Object> map) throws Exception;
	
	/**
	 * 在线考试
	 * 获取试卷信息，并且指定是固定试卷还是随机试卷
	 * @param tact001
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> getTestPaperById(String tact001) throws Exception;
	
	/**
	 * 在线考试
	 * 查询试卷试题答案列表
	 * @param map
	 * @return
	 * @throws Exception
	 */
//	public List<ExamTTesttopic> findTopicByExamId(Map map);
	public List<Map<String, Object>> findTopicByExamId(Map map);
	
	public List<Map<String, Object>> findByPageObjectForUser(Map<String, Object> map);
	
	
	public Map<String, Object> insertExamGrade(Map paramMap) throws Exception;
	
	
	public int insertExamGrade(ExamineeGrade examineeGrade) throws Exception;
	
	/**
	 * 在线考试
	 * 获取指定id的答卷信息Map
	 * @param serialNO
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> findExamGradeByID(String id) throws Exception;
	
	/**
	 * 在线考试试卷内容
	 * 查看答卷
	 * @param tact001
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> queryExamFixTopicList1(Map<String, Object> map) throws Exception;
	
	/**
	 * 查看试卷
	 * 获取学员固定试卷答案
	 * @param tact001
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> findFixTopicUserAnswer(Map<String, Object> map) throws Exception;
	
	/**
	 * 获取指定 tpid 的题目 -- 用于随机试卷预生成
	 * @param tpid, egid, serialNO
	 * @return
	 * @throws Exception
	 */
//	public List findTopic(String tpid,String egid,int serialNO);
	
	/**
	 * 获取指定 tpid 的题目的子题
	 * @param tpid
	 * @param egid
	 * @param serialNO
	 * @return
	 * @throws Exception
	 */
//	public List findTopicChild(String tpid,String egid,int serialNO);
	
	/**
	 * insert 考试内容题目的答卷
	 * @param examineeGrade
	 * @return
	 * @throws Exception
	 */
	public int insertTopicAnswer(List jsonList) throws Exception;
	
	/**
	 * 更新成绩表
	 * @param examineeGrade
	 * @return
	 * @throws Exception
	 */
	public int updateExamGrade(ExamineeGrade examineeGrade) throws Exception;
	
	/**
	 * 在线考试
	 * 获取指定id的答卷信息Map
	 * @param serialNO
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> queryCourseMap(String id) throws Exception;
	
	/**
	 * 更新学员学习总结果表
	 * @param examineeGrade
	 * @return
	 * @throws Exception
	 */
	public int updateLearnResult(Map<String, Object> map) throws Exception;
	
	/**
	 * 更新学时
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int updateCAllUserHours(Map<String, Object> map) throws Exception;
	/**
	 * 更新学时
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int updateUserHours(Map<String, Object> map) throws Exception;
	/**
	 * 在线考试
	 * 题库列表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> tk_list(Map<String, Object> map) throws Exception;
	
	/**
	 * 获取所选题库对应一级题库
	 * @return
	 */
	public List<Map<String, Object>> findAllExerciseList(Map<String, Object> map);
	
	/**
	 * 每个题库（包括已选子题库）对应的答题情况
	 * @return
	 */
	public List<Map<String, Object>> queryAnswerList(Map<String, Object> map);
	
	/**
	 * 获取全部知识点以及每个知识点里的题目数
	 * @param Req
	 * @return
	 */
	public List findKnowledgesList(Map<String, Object> map);
	
	/**
	 * 往成绩表里插入一条数据
	 * @param Req
	 * @return
	 */
	public void insertGrade(Map<String, Object> map);

	/**
	 * 在线考试
	 * 题库练习目录；
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> tk_practiseDir(Map<String, Object> map) throws Exception;
	
	/**
	 * 在线考试
	 * 题库练习目录；
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> tk_practiseContent(Map<String, Object> map) throws Exception;

	/**
	 * 试题的回答情况；
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> findRightAndError(String tpid);
	/**在线练习题库列表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> selectOnLineExerciseList(Map<String, Object> map) throws Exception ;
	/**在线练习题库题型选项数目
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> selectCountType(String tkid) throws Exception ;
	/**
	 * 生成随机试题试卷
	 * @param map
	 */
	public void insert_findTopicByExerciseId(Map<String, Object> map) throws Exception;
	
	public void insert_findTopicByExerciseId1(Map<String, Object> map) throws Exception;
	
	public void insert_exerGrade(Map<String, Object> map) throws Exception;
	
	public void insertExerSampleContent(Map<String, Object> map) throws Exception;
	
	public List<Map<String, Object>> queryExamFixTopicList2(Map<String, Object> map) throws Exception;
	
	public Map findTopicAnswerByExerciseId(Map<String, Object> map) throws Exception;

	public List<Map<String, Object>> findAnwserTopic(Map<String, Object> map) throws Exception;
	
	public void update_exerAnswerTopic(Map<String, Object> map) throws Exception;
	
	public void insert_exerAnswerTopic(Map<String, Object> map) throws Exception;
	/**
	 * 在线练习
	 * 考试结果
	 * @param tact001
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> queryExerciseResult(String s1) throws Exception;
	
	public Map selectExerSample(String s1) throws Exception; 
	
	public List<Map<String, Object>> findExerciseTxById(Map<String, Object> map) throws Exception;
	/**
	 * 更新练习成绩表
	 * @param examineeGrade
	 * @return
	 * @throws Exception
	 */
	public int updateExerGrade(ExamTExergrade examineeGrade) throws Exception;
   
	/**
	 * insert 考试内容题目的答卷
	 * @param examineeGrade
	 * @return
	 * @throws Exception
	 */
	public int insertBatch_ExerAnwserTopic(List jsonList) throws Exception;
	
	public List<Map<String, Object>> queryExamFixTopicList3(Map<String, Object> map) throws Exception;
	public List<Map<String, Object>> findExerciseRecordByUserId(String st) throws Exception;
	List selectExerciseHistoryPage(Pagination page,Map arg) throws Exception;
	
	List findExerciseRecordByUserId(Pagination page,String user001, String tact001) throws Exception;
	
	/**
	 * 获取所选题库对应一级题库
	 * @return
	 */
	public List<Map<String, Object>> findExerciseList1(Map<String, Object> map);
	
	/**
	 * 获取全部知识点以及每个知识点里的题目数
	 * @param Req
	 * @return
	 */
	public List findKnowledgesList1(Map<String, Object> map);
	
	/**
	 * 每个题库（包括已选子题库）对应的答题情况
	 * @return
	 */
	public List<Map<String, Object>> queryAnswerResult(Map<String, Object> map);
	
	public Map<String,Object> findExerciseDetailsById(String st);
}

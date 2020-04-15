package com.huarui.product2020.service;

import com.huarui.common.utils.IPage;
import com.huarui.product2020.pojo.QuesGrade;
import com.huarui.product2020.pojo.QuesResult;

import java.util.List;
import java.util.Map;

public interface ResearchService {
	
	/**
	 * 问卷调查列表
	 * @param userid
	 * @return
	 * @throws Exception
	 */
	public IPage queryResearchList(IPage researchListPage, Map<String, Object> map) throws Exception;
	
	/**
	 * 问卷调查--通过ID查询
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> queryResearchByID(Map<String, Object> map) throws Exception;
	
	/**
	 * 调查次数
	 * @param userid
	 * @param ques001
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> queryJoinTimes(String userid, String ques001) throws Exception;
	
	/**
	 * 查询问卷试题列表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> findTopicByQId(Map<String, Object> map) throws Exception;
	
	/**
	 * 查询问卷调查的题目
	 * @param ques001
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> findQuesTopicForApp(String ques001) throws Exception;
	
	/**
	 * 查询问卷调查的题目
	 * @param ques001
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> findQuesTopic(String ques001) throws Exception;
	
	/**
	 * 插入问卷调查情况
	 */
	public int insertQuesGrade(QuesGrade quesGrade) throws Exception;
	
	/**
	 * 插入问卷调查结果
	 * @param list
	 * @throws Exception
	 */
	public int insertQuesResult(QuesResult quesResult) throws Exception;
	
	/**
	 * 获取本次调查待调查的教师
	 * @param userid
	 * @param ques001
	 * @return
	 * @throws Exception
	 */
//	public List<Map<String, Object>> queryProficientNameByQid(String ques001) throws Exception;
	
	/**
	 * 获取对应的题目信息
	 * @param qtop001
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> queryQuestionInfoByQtid(Map<String, Object> map) throws Exception;
	
	/**
	 * 获取对应的选中项
	 * @param qtop001
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> queryQuesResultList(Map<String, Object> map) throws Exception;
	
	/**
	 * 查询主观题题目的答题结果
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> queryOneQuestionResult(Map<String, Object> map) throws Exception;
}

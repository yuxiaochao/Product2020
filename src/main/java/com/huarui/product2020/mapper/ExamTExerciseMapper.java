package com.huarui.product2020.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.huarui.common.utils.IPageByMap;
import com.huarui.product2020.entity.ExamTBasetx;
import com.huarui.product2020.entity.ExamTExeranwsertopic;
import com.huarui.product2020.entity.ExamTExercise;
import com.huarui.product2020.entity.ExamTTopic;
import com.huarui.product2020.entity.ExerSampleEntity;

/**
 * <p>
  * ${table.comment} Mapper 接口
 * </p>
 *
 * @author Chenrui
 * @since 2017-08-13
 */
public interface ExamTExerciseMapper extends BaseMapper<ExamTExercise> {

	/**
	 * 获取用户题库练习列表
	 */
	public List<HashMap<String, Object>> findList(IPageByMap<HashMap<String, Object>> page,ExamTExercise exercise);
	
	/**
	 * 获取练习题库分类
	 */
	public List<HashMap<String, Object>> queryExerciseclassifList(ExamTExercise exercise);
	
	/**
	 * 每个题库（包括已选子题库）对应的答题情况
	 * 
	 */
	public Map<String, Object> queryAnswerMap(ExamTExercise exercise);
	
	/**
	 * 获取题库练习中的知识点列表
	 */
	public List<HashMap<String, Object>> queryKnowledgeList(ExamTExercise ercis);
	
	/**
	 * 获取题库基本信息
	 */
	public Map<String,Object> findExerciseInfo(String exer001);
	
	/**
	 * 抽题策略添加
	 */
	public Integer insertExerSample(ExerSampleEntity exerSample);
	
	/**
	 * 获取题库练习试题
	 */
	public List<Map<String,Object>> queryExrciseTopicList(Map<String,Object> paramsMap);
	
	/**
	 * 获取题库练习试题(继续上次练习)
	 */
	public List<Map<String,Object>> findExertopic(Map<String,Object> paramsMap);
	
	/**
	 * 获取题库练习题型
	 */
	public List<ExamTBasetx> findTxByExerciseId(Map<String,Object> paramsMap);
	
	/**
	 * 添加练习试题
	 */
	public Integer addExertopic(Map<String,Object> map);
	
	/**
	 * 获取练习抽题信息
	 */
	public Map<String,Object> findExerSampleInfo(ExerSampleEntity exerSample);
	
	/**
	 * 获取学员评论列表
	 */
	public List<Map<String,Object>> findReview(Map<String,Object> paramsMap);
	
	/**
	 * 获取子回复列表
	 */
	public List<Map<String,Object>> findReviewList(Map<String,Object> paramsMap);
	
	/**
	 * 提交评论
	 */
	public Integer submitComment(Map<String,Object> paramsMap);
	
	/**
	 * 删除试题评论
	 */
	public Integer delComment(String emes001);
	
	/**
	 * 查询练习试题答案列表
	 * @param arg
	 * @return
	 */
	public List<ExamTTopic> findTopicAnswerByExerciseId(Map<String, Object> arg);
	
	/**
	 * 查询此练习是否答过
	 * @param arg
	 * @return
	 */
	public ExamTExeranwsertopic findAnwserTopic(Map<String,Object> arg);
}
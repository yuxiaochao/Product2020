package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.common.utils.IPageByMap;
import com.huarui.product2020.entity.*;
import com.huarui.product2020.mapper.ExamTExerciseMapper;
import com.huarui.product2020.service.IExamTExerciseService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * ${table.comment} 服务实现类
 * </p>
 *
 * @author Chenrui
 * @since 2017-08-13
 */
@Service
public class ExamTExerciseServiceImpl extends ServiceImpl<ExamTExerciseMapper, ExamTExercise> implements IExamTExerciseService {
	
	@Autowired
	private ExamTExerciseMapper exerciseMapper;
	/**
	 * 获取用户题库练习列表
	 */
	public IPageByMap<HashMap<String, Object>> findList(IPageByMap<HashMap<String, Object>> page, ExamTExercise exercise){
		page.setRecords(exerciseMapper.findList(page,exercise)); 
		return page;
	}
	
	/**
	 * 获取题库练习中的分类列表
	 */
	public List<HashMap<String, Object>> queryExerciseclassifList(ExamTExercise exercise){
		List<HashMap<String, Object>> list = exerciseMapper.queryExerciseclassifList(exercise);
		for(Map<String, Object> map:list) {
			exercise.setExer009(ObjectUtils.toString(map.get("CATA001")));
			Map<String, Object> map1 = exerciseMapper.queryAnswerMap(exercise);
			if(map1 != null) {
				map.put("COUNTS", map1.get("COUNTS"));
				map.put("ZQ", map1.get("ZQ"));
				map.put("YD", map1.get("YD"));
				map.put("WD", map1.get("WD"));
				map.put("CW", map1.get("CW"));
				map.put("ZQL", map1.get("ZQL"));
				map.put("ZWL", map1.get("ZWL"));
			}else {
				map.put("COUNTS", 0);
				map.put("ZQ", 0);
				map.put("YD", 0);
				map.put("WD", 0);
				map.put("CW", 0);
				map.put("ZQL", "0%");
				map.put("ZWL", "0%");
			}
			
		}
		return list;
	}
	
	/**
	 * 获取题库练习中的知识点列表
	 */
	public List<HashMap<String, Object>> queryKnowledgeList(ExamTExercise ercis){
		return exerciseMapper.queryKnowledgeList(ercis);
	}
	
	/**
	 * 获取题库基本信息
	 */
	public Map<String, Object> findExerciseInfo(String exer001){
		return exerciseMapper.findExerciseInfo(exer001);
	}
	
	/**
	 * 抽题策略添加
	 */
	public Integer insertExerSample(ExerSampleEntity exerSample) {
		return exerciseMapper.insertExerSample(exerSample);
	}
	
	/**
	 * 获取题库练习试题
	 */
	public List<Map<String, Object>> queryExrciseTopicList(Map<String, Object> paramsMap){
		return exerciseMapper.queryExrciseTopicList(paramsMap);
	}
	
	/**
	 * 获取题库练习试题(继续上次练习)
	 */
	public List<Map<String, Object>> findExertopic(Map<String, Object> paramsMap){
		return exerciseMapper.findExertopic(paramsMap);
	}
	
	/**
	 * 获取题库练习题型
	 */
	public List<ExamTBasetx> findTxByExerciseId(Map<String, Object> paramsMap){
		return exerciseMapper.findTxByExerciseId(paramsMap);
	}
	
	/**
	 * 添加练习试题
	 */
	public Integer addExertopic(Map<String, Object> map) {
		return exerciseMapper.addExertopic(map);
	}
	
	/**
	 * 获取练习抽题信息
	 */
	public Map<String, Object> findExerSampleInfo(ExerSampleEntity exerSample){
		return exerciseMapper.findExerSampleInfo(exerSample);
	}
	
	/**
	 * 获取学员评论以及回复 
	 */
	public List<Map<String, Object>> findReviewList(Map<String, Object> paramsMap){
		List<Map<String, Object>> list = exerciseMapper.findReview(paramsMap);//获取学员评论列表
		for(Map<String, Object> map:list) {
			paramsMap.put("emes001", map.get("EMES001"));
			List<Map<String, Object>> childList = exerciseMapper.findReviewList(paramsMap); //获取子回复列表
			map.put("childList", childList);
		}
		return list;
	}
	
	/**
	 * 获取子评论信息
	 */
	public List<Map<String, Object>> findChildReviewList(Map<String, Object> paramsMap){
		return exerciseMapper.findReviewList(paramsMap);
	}
	
	/**
	 * 提交评论
	 */
	public Integer submitComment(Map<String, Object> paramsMap) {
		return exerciseMapper.submitComment(paramsMap);
	}
	
	/**
	 * 删除试题评论
	 */
	public Integer delComment(String emes001) {
		return exerciseMapper.delComment(emes001);
	}
	
	
	/**
	 * 查询练习试题答案列表
	 * @param args
	 * @return
	 */
	public Map findAnswerByExerciseId(Map args) {
		Map map = new HashMap();
		List<ExamTTopic> list = exerciseMapper.findTopicAnswerByExerciseId(args);
		for (ExamTTopic entity : list) {
			map.put(entity.getTopi001(), entity);
		}
		return map;
	}
	
	/**
	 * 查询此练习是否答过
	 * @param arg
	 * @return
	 */
	public ExamTExeranwsertopic findAnwserTopic(Map<String, Object> arg) {
		return exerciseMapper.findAnwserTopic(arg);
	}
}











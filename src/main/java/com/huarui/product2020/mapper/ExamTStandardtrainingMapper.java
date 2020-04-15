package com.huarui.product2020.mapper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.huarui.common.utils.IPage;
import com.huarui.product2020.entity.ExamTStandardtraining;
import com.huarui.product2020.entity.ExamTTrainsubject;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author panlei
 * @since 2018-05-22
 */
public interface ExamTStandardtrainingMapper extends BaseMapper<ExamTStandardtraining> {
	/**
	 * 获取达标训练列表
	 */
	public List<ExamTStandardtraining> findList(IPage<ExamTStandardtraining> page,Map<String,Object> map);
	
	/**
	 * 获取试题题型
	 */
	public List<ExamTTrainsubject> findTxByExamId(String est001);
	
	/**
	 * 获取试题列表 
	 */
	public List<Map<String,Object>> findTopicByExamId(Map<String,Object> paramsMap);

}
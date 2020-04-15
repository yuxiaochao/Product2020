package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.common.utils.IPage;
import com.huarui.product2020.entity.ExamTStandardtraining;
import com.huarui.product2020.entity.ExamTTrainsubject;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author panlei
 * @since 2018-05-22
 */
public interface IExamTStandardtrainingService extends IService<ExamTStandardtraining> {
	/**
	 * 获取达标训练列表
	 */
	public IPage<ExamTStandardtraining> findList(IPage<ExamTStandardtraining> page, Map<String, Object> map);
	
	/**
	 * 获取试题题型
	 */
	public List<ExamTTrainsubject> findTxByExamId(String est001);
	
	/**
	 * 获取试题列表
	 */
	public List<Map<String, Object>> findTopicByExamId(Map<String, Object> paramsMap);
}

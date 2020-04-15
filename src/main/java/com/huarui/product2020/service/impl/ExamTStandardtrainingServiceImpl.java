package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.common.utils.IPage;
import com.huarui.product2020.entity.ExamTStandardtraining;
import com.huarui.product2020.entity.ExamTTrainsubject;
import com.huarui.product2020.mapper.ExamTStandardtrainingMapper;
import com.huarui.product2020.service.IExamTStandardtrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author panlei
 * @since 2018-05-22
 */
@Service
public class ExamTStandardtrainingServiceImpl extends ServiceImpl<ExamTStandardtrainingMapper, ExamTStandardtraining> implements IExamTStandardtrainingService {
	@Autowired
	private ExamTStandardtrainingMapper standartTrainMapper;
	/**
	 * 获取达标训练列表
	 */
	public IPage<ExamTStandardtraining> findList(IPage<ExamTStandardtraining> page, Map<String, Object> map){
		page.setRecords(standartTrainMapper.findList(page,map)); 
		return page;
	}
	
	/**
	 * 获取试题题型
	 */
	public List<ExamTTrainsubject> findTxByExamId(String est001){
		return standartTrainMapper.findTxByExamId(est001);
	}
	
	/**
	 * 获取试题列表
	 */
	public List<Map<String, Object>> findTopicByExamId(Map<String, Object> paramsMap){
		return standartTrainMapper.findTopicByExamId(paramsMap);
	}
}

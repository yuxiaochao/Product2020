package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.product2020.entity.ExamTTesttopic;
import com.huarui.product2020.mapper.ExamTTesttopicMapper;
import com.huarui.product2020.service.IExamTTesttopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * ${table.comment} 服务实现类
 * </p>
 *
 * @author Chenrui
 * @since 2017-08-13
 */
@Service
public class ExamTTesttopicServiceImpl extends ServiceImpl<ExamTTesttopicMapper, ExamTTesttopic> implements IExamTTesttopicService {

	@Autowired
	private ExamTTesttopicMapper examMapper;
	
	public String selectTestPaperNum(String user001) throws Exception {
		return examMapper.selectTestPaperNum(user001);
	}

	public List selectRecentExamList(String user001) throws Exception {
		return examMapper.selectRecentExamList(user001);
	}
	
}

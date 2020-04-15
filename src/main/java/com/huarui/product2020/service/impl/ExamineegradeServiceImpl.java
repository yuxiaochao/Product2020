package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.product2020.entity.ExamTExamineegrade;
import com.huarui.product2020.mapper.ExamineegradeMapper;
import com.huarui.product2020.service.ExamineegradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ExamineegradeServiceImpl extends ServiceImpl<ExamineegradeMapper,ExamTExamineegrade>implements ExamineegradeService{
	
	@Autowired
	private ExamineegradeMapper examineegradeMapper;
	//更新成绩表信息
	public void updateExamineeGrade(Map<String, Object> map) {
		examineegradeMapper.updateExamineeGrade(map);
	}
	
}

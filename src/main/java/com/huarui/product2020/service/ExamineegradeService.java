package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.product2020.entity.ExamTExamineegrade;

import java.util.Map;

public interface ExamineegradeService extends IService<ExamTExamineegrade> {

	//更新成绩表信息
	public void updateExamineeGrade(Map<String, Object> map);
}

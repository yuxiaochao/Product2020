package com.huarui.product2020.mapper;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.huarui.product2020.entity.ExamTExamineegrade;

public interface ExamineegradeMapper extends BaseMapper<ExamTExamineegrade>{
	//更新成绩表信息
	public void updateExamineeGrade(Map<String, Object> map);

}

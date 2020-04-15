package com.huarui.product2020.service;


import com.baomidou.mybatisplus.service.IService;
import com.huarui.common.Req;
import com.huarui.product2020.entity.ExamSyllabusEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface ExamSyllabusService extends IService<ExamSyllabusEntity> {
	public List selectExamSyllabusTree(String id, Map<String, Object> map, Req req);

}
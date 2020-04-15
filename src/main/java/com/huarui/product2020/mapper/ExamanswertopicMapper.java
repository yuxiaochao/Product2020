package com.huarui.product2020.mapper;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.huarui.product2020.entity.ExamTExamanswertopic;

public interface ExamanswertopicMapper extends BaseMapper<ExamTExamanswertopic> {
	public long insertBatch(List list);

}

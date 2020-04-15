package com.huarui.product2020.mapper;

import com.huarui.common.Req;
import com.huarui.product2020.entity.ExamTTopic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  * ${table.comment} Mapper 接口
 * </p>
 *
 * @author Chenrui
 * @since 2017-08-13
 */
public interface ExamTTopicMapper extends BaseMapper<ExamTTopic> {

	List<HashMap<String, Object>> queryKnowledgeList(Map<String, Object> map);

	List<HashMap<String, Object>> testPaperTopicCount(Req req);

	void calcMark(Map<String, Object> map);

}
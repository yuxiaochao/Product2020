package com.huarui.product2020.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.huarui.product2020.entity.StudyTStat;

import java.util.Map;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author cyx
 * @since 2019-08-28
 */
public interface StudyTStatMapper extends BaseMapper<StudyTStat> {
	//课程点赞
	int addPraiseCount(Map<String, Object> paramMap);
	//课程取消赞
	int cancelPraiseCount(Map<String, Object> thumMap);
	//课程收藏
	int collectionCount(Map<String, Object> favMap);
	//课程取消收藏
	int cancelCollectionCount(Map<String, Object> statMap);

}
package com.huarui.product2020.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.huarui.product2020.entity.StudyTFav;

import java.util.Map;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author cyx
 * @since 2019-08-28
 */
public interface StudyTFavMapper extends BaseMapper<StudyTFav> {
	/**
	 * 课程学习-收藏
	 * 
	 * @param model
	 * @return
	 */
	int collection(Map<String, Object> paramMap);

}
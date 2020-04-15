package com.huarui.product2020.mapper;

import com.huarui.product2020.entity.Accommodationarrange;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  * 住宿安排 Mapper 接口
 * </p>
 *
 * @author caifenglin
 * @since 2020-01-15
 */
public interface AccommodationarrangeMapper extends BaseMapper<Accommodationarrange> {

    List<Accommodationarrange> findList(Map<String, Object> paramMap);

}
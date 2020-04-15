package com.huarui.product2020.mapper;

import com.huarui.product2020.entity.Traineearrange;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  * 学员安排 Mapper 接口
 * </p>
 *
 * @author caifenglin
 * @since 2020-01-14
 */
public interface TraineearrangeMapper extends BaseMapper<Traineearrange> {

    Integer findTodoArrangedMaleCount(Map<String, Object> paramMap);

    Integer findTodoArrangedFemaleCount(Map<String, Object> paramMap);

}
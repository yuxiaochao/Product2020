package com.huarui.product2020.mapper;

import com.huarui.product2020.entity.Tbcmdy11;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author caifl
 * @since 2020-04-03
 */
public interface Tbcmdy11Mapper extends BaseMapper<Tbcmdy11> {

    List<Tbcmdy11> findRelatedCourses(Map parameterMap);

}
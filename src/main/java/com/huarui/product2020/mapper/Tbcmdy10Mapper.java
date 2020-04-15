package com.huarui.product2020.mapper;

import com.huarui.product2020.entity.Tbcmdy10;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author caifl
 * @since 2020-04-07
 */
public interface Tbcmdy10Mapper extends BaseMapper<Tbcmdy10> {

    List<Tbcmdy10> findCourseAuditions(Map parameterMap);

    List<Tbcmdy10> findCourseAuditionsClassify(Map parameterMap);

}
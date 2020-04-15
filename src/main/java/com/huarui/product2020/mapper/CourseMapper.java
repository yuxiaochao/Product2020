package com.huarui.product2020.mapper;

import com.huarui.common.utils.IPage;
import com.huarui.product2020.entity.Course;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  * 课程库 Mapper 接口
 * </p>
 *
 * @author caifenglin
 * @since 2019-12-31
 */
public interface CourseMapper extends BaseMapper<Course> {

    List<Course> findTrainingCourseList(IPage<Course> page, Map<String, Object> paramMap);

}
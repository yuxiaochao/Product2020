package com.huarui.product2020.mapper;

import com.huarui.common.utils.IPage;
import com.huarui.product2020.entity.Teacher;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author caifenglin
 * @since 2020-01-07
 */
public interface TeacherMapper extends BaseMapper<Teacher> {

    List<Teacher> findLecturerList(IPage<Teacher> page, Map<String, Object> paramMap);

}
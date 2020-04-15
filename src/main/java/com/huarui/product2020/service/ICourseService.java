package com.huarui.product2020.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.huarui.common.utils.IPage;
import com.huarui.product2020.entity.Course;

import java.util.Map;

/**
 * <p>
 * 课程库 服务类
 * </p>
 *
 * @author caifenglin
 * @since 2019-12-31
 */
public interface ICourseService extends IService<Course> {

    /**
     * 选择课程弹框
     * @param page
     * @param paramMap
     * @return
     */
    Page<Course> findTrainingCourseList(IPage<Course> page, Map<String, Object> paramMap);
	
}

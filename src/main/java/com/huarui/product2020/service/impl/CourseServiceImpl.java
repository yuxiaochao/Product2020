package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.common.utils.IPage;
import com.huarui.product2020.entity.Course;
import com.huarui.product2020.mapper.CourseMapper;
import com.huarui.product2020.service.ICourseService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 课程库 服务实现类
 * </p>
 *
 * @author caifenglin
 * @since 2019-12-31
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements ICourseService {

    @Override
    public Page<Course> findTrainingCourseList(IPage<Course> page, Map<String, Object> paramMap) {
        page.setRecords(baseMapper.findTrainingCourseList(page,paramMap));
        return page;
    }
	
}

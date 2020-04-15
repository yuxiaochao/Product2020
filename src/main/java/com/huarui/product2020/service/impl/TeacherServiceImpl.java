package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.common.utils.IPage;
import com.huarui.product2020.entity.Teacher;
import com.huarui.product2020.mapper.TeacherMapper;
import com.huarui.product2020.service.ITeacherService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author caifenglin
 * @since 2020-01-07
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements ITeacherService {

    @Override
    public Page<Teacher> findLecturerList(IPage<Teacher> page, Map<String, Object> paramMap) {
        page.setRecords(baseMapper.findLecturerList(page,paramMap));
        return page;
    }
	
}

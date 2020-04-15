package com.huarui.product2020.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.huarui.common.utils.IPage;
import com.huarui.product2020.entity.Teacher;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author caifenglin
 * @since 2020-01-07
 */
public interface ITeacherService extends IService<Teacher> {

    Page<Teacher> findLecturerList(IPage<Teacher> page, Map<String, Object> paramMap);
	
}

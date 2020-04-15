package com.huarui.product2020.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.huarui.common.Req;
import com.huarui.common.utils.IPage;
import com.huarui.product2020.entity.Classroom;
import com.huarui.product2020.entity.ResultEntity;

import java.util.Map;

/**
 * <p>
 * 教室资源 服务类
 * </p>
 *
 * @author caifenglin
 * @since 2019-12-23
 */
public interface IClassroomService extends IService<Classroom> {

    Page<Classroom> findList(IPage<Classroom> page, Map<String, Object> paramMap);

    ResultEntity saveOrUpdate(Req req);

    Classroom findDetailById(String ids);

    Page<Classroom> findClassroomList(IPage<Classroom> page, Map<String, Object> paramMap);
	
}

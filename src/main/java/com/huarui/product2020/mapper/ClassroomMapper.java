package com.huarui.product2020.mapper;

import com.huarui.common.utils.IPage;
import com.huarui.product2020.entity.Classroom;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  * 教室资源 Mapper 接口
 * </p>
 *
 * @author caifenglin
 * @since 2019-12-23
 */
public interface ClassroomMapper extends BaseMapper<Classroom> {

    List<Classroom> findList(IPage<Classroom> page, Map<String, Object> paramMap);

    /**
     * 根据ID获取详情
     * @param id
     * @return
     */
    Classroom findDetailById(String id);

    
    /**
     * 选择教室
     * @param page
     * @param paramMap
     * @return
     */
    List<Classroom> findClassroomList(IPage<Classroom> page, Map<String, Object> paramMap);

}
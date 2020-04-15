package com.huarui.product2020.mapper;

import com.huarui.common.utils.IPage;
import com.huarui.product2020.entity.Academicbuilding;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  * 教学楼表 Mapper 接口
 * </p>
 *
 * @author caifenglin
 * @since 2019-12-23
 */
public interface AcademicbuildingMapper extends BaseMapper<Academicbuilding> {

    /**
     * 查询教学楼信息并分页
     * @param page
     * @param paramMap
     * @return
     */
    List<Academicbuilding> findList(IPage<Academicbuilding> page, Map<String, Object> paramMap);

    
    /**
     * 查询弹框选择教学楼信息并分页
     * @param page
     * @param paramMap
     * @return
     */
    List<Academicbuilding> findAcademicbuilding(IPage<Academicbuilding> page, Map<String, Object> paramMap);

}
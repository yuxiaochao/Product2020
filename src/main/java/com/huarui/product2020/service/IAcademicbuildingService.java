package com.huarui.product2020.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.huarui.common.utils.IPage;
import com.huarui.product2020.entity.Academicbuilding;

import java.util.Map;

/**
 * <p>
 * 教学楼表 服务类
 * </p>
 *
 * @author caifenglin
 * @since 2019-12-23
 */
public interface IAcademicbuildingService extends IService<Academicbuilding> {

    /**
     * 查询教学楼信息并分页
     * @param page
     * @param paramMap
     * @return
     */
    IPage<Academicbuilding> findList(IPage<Academicbuilding> page, Map<String, Object> paramMap);

    
    /**
     * 查询选择的教学楼弹框并分页
     * @param page
     * @param paramMap
     * @return
     */
    Page<Academicbuilding> findAcademicbuilding(IPage<Academicbuilding> page, Map<String, Object> paramMap);
	
}

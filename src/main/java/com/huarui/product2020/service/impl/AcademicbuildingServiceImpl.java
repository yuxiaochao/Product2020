package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.common.utils.IPage;
import com.huarui.product2020.entity.Academicbuilding;
import com.huarui.product2020.mapper.AcademicbuildingMapper;
import com.huarui.product2020.service.IAcademicbuildingService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 教学楼表 服务实现类
 * </p>
 *
 * @author caifenglin
 * @since 2019-12-23
 */
@Service
public class AcademicbuildingServiceImpl extends ServiceImpl<AcademicbuildingMapper, Academicbuilding> implements IAcademicbuildingService {

    @Override
    public IPage<Academicbuilding> findList(IPage<Academicbuilding> page, Map<String, Object> paramMap) {
        page.setRecords(baseMapper.findList(page, paramMap));
        return page;
    }

    @Override
    public Page<Academicbuilding> findAcademicbuilding(IPage<Academicbuilding> page, Map<String, Object> paramMap) {
        page.setRecords(baseMapper.findAcademicbuilding(page, paramMap));
        return page;
    }
	
}

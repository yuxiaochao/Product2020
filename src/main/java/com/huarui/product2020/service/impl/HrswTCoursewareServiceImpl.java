package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.product2020.entity.HrswTCourseware;
import com.huarui.product2020.mapper.HrswTCoursewareMapper;
import com.huarui.product2020.service.IHrswTCoursewareService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * ${table.comment} 服务实现类
 * </p>
 *
 * @author Chenrui
 * @since 2017-08-13
 */
@Service
public class HrswTCoursewareServiceImpl extends ServiceImpl<HrswTCoursewareMapper, HrswTCourseware> implements IHrswTCoursewareService {

    @Override
    public List<Map<String, String>> findbyCourseFirstSectionList(String cour001) {
        return baseMapper.findbyCourseFirstSectionList(cour001);
    }
}

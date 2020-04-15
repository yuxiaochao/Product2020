package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.product2020.entity.Tbcmdy10;
import com.huarui.product2020.mapper.Tbcmdy10Mapper;
import com.huarui.product2020.service.ITbcmdy10Service;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author caifl
 * @since 2020-04-07
 */
@Service
public class Tbcmdy10ServiceImpl extends ServiceImpl<Tbcmdy10Mapper, Tbcmdy10> implements ITbcmdy10Service {

    @Override
    public List<Tbcmdy10> findCourseAuditions(Map parameterMap) {
        return this.baseMapper.findCourseAuditions(parameterMap);
    }

    @Override
    public List<Tbcmdy10> findCourseAuditionsClassify(Map parameterMap) {
        return this.baseMapper.findCourseAuditionsClassify(parameterMap);
    }
	
}

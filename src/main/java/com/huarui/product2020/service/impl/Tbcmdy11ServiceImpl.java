package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.product2020.entity.Tbcmdy11;
import com.huarui.product2020.mapper.Tbcmdy11Mapper;
import com.huarui.product2020.service.ITbcmdy11Service;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author caifl
 * @since 2020-04-03
 */
@Service
public class Tbcmdy11ServiceImpl extends ServiceImpl<Tbcmdy11Mapper, Tbcmdy11> implements ITbcmdy11Service {

    @Override
    public List<Tbcmdy11> findRelatedCourses(Map parameterMap) {
        return this.baseMapper.findRelatedCourses(parameterMap);
    }
	
}

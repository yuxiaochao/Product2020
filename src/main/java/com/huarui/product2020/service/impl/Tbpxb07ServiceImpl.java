package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.product2020.entity.Tbpxb07;
import com.huarui.product2020.mapper.Tbpxb07Mapper;
import com.huarui.product2020.service.ITbpxb07Service;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yuxiaochao
 * @since 2019-10-25
 */
@Service
public class Tbpxb07ServiceImpl extends ServiceImpl<Tbpxb07Mapper, Tbpxb07> implements ITbpxb07Service {

    @Override
    public List<Tbpxb07> findByClassHourRequirementList(Map paramMap) {
        return baseMapper.findByClassHourRequirementList(paramMap);
    }
	
}

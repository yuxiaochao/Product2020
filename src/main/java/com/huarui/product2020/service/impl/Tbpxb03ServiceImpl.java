package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.product2020.entity.Tbpxb03;
import com.huarui.product2020.mapper.Tbpxb03Mapper;
import com.huarui.product2020.service.ITbpxb03Service;
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
public class Tbpxb03ServiceImpl extends ServiceImpl<Tbpxb03Mapper, Tbpxb03> implements ITbpxb03Service {

    @Override
    public List<Tbpxb03> findClassPersonnel(Map paramMap) {
        return baseMapper.findClassPersonnel(paramMap);
    }
	
}

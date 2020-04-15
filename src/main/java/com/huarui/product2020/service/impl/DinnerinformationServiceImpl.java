package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.product2020.entity.Dinnerinformation;
import com.huarui.product2020.mapper.DinnerinformationMapper;
import com.huarui.product2020.service.IDinnerinformationService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 就餐信息 服务实现类
 * </p>
 *
 * @author caifenglin
 * @since 2020-01-06
 */
@Service
public class DinnerinformationServiceImpl extends ServiceImpl<DinnerinformationMapper, Dinnerinformation> implements IDinnerinformationService {

    @Override
    public Page<Dinnerinformation> findList(Page<Dinnerinformation> page, Map<String, Object> paramMap) {
        page.setRecords(baseMapper.findList(page, paramMap));
        return page;
    }
	
}

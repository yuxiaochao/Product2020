package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.product2020.entity.Tbtssq01;
import com.huarui.product2020.entity.Tbtssq02;
import com.huarui.product2020.mapper.Tbtssq02Mapper;
import com.huarui.product2020.service.ITbtssq02Service;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 图书申请记录 服务实现类
 * </p>
 *
 * @author caifl
 * @since 2020-04-03
 */
@Service
public class Tbtssq02ServiceImpl extends ServiceImpl<Tbtssq02Mapper, Tbtssq02> implements ITbtssq02Service {

    @Override
    public Page<Tbtssq01> findBookApplicationListByUserId(Page<Tbtssq01> page, Map<String, Object> paramMap) {
        page.setRecords(baseMapper.findBookApplicationListByUserId(page, paramMap));
        return page;
    }

    @Override
    public Page<Tbtssq02> findListByUserId(Page<Tbtssq02> page, Map<String, Object> paramMap) {
        page.setRecords(baseMapper.findListByUserId(page, paramMap));
        return page;
    }
	
}

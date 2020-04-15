package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.product2020.entity.Tbtssq01;
import com.huarui.product2020.mapper.Tbtssq01Mapper;
import com.huarui.product2020.service.ITbtssq01Service;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 图书申请 服务实现类
 * </p>
 *
 * @author caifl
 * @since 2020-04-01
 */
@Service
public class Tbtssq01ServiceImpl extends ServiceImpl<Tbtssq01Mapper, Tbtssq01> implements ITbtssq01Service {

    @Override
    public Page<Tbtssq01> findListByUserId(Page<Tbtssq01> page, Map<String, Object> paramMap) {
        page.setRecords(baseMapper.findListByUserId(page, paramMap));
        return page;
    }
	
}

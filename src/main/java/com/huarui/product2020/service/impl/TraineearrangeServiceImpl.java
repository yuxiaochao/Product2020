package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.product2020.entity.Traineearrange;
import com.huarui.product2020.mapper.TraineearrangeMapper;
import com.huarui.product2020.service.ITraineearrangeService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 学员安排 服务实现类
 * </p>
 *
 * @author caifenglin
 * @since 2020-01-14
 */
@Service
public class TraineearrangeServiceImpl extends ServiceImpl<TraineearrangeMapper, Traineearrange> implements ITraineearrangeService {

    @Override
    public Integer findTodoArrangedMaleCount(Map<String, Object> paramMap) {
        return baseMapper.findTodoArrangedMaleCount(paramMap);
    }

    @Override
    public Integer findTodoArrangedFemaleCount(Map<String, Object> paramMap) {
        return baseMapper.findTodoArrangedFemaleCount(paramMap);
    }
	
}

package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.product2020.entity.HrTPersonnelattributes;
import com.huarui.product2020.mapper.HrTPersonnelattributesMapper;
import com.huarui.product2020.service.IHrTPersonnelattributesService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Administrator
 * @since 2019-08-06
 */
@Service
public class HrTPersonnelattributesServiceImpl extends ServiceImpl<HrTPersonnelattributesMapper, HrTPersonnelattributes> implements IHrTPersonnelattributesService {
    /**
     * 根据条件查询
     *
     * @return
     */
    public List<HrTPersonnelattributes> findByCriteria(HrTPersonnelattributes t) {
        return baseMapper.findByCriteria(t);
    }
}

package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.product2020.entity.HrTPersonnelattributes;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Administrator
 * @since 2019-08-06
 */
public interface IHrTPersonnelattributesService extends IService<HrTPersonnelattributes> {
    /**
     * 根据条件查询
     *
     * @param t
     * @return
     */
    public List<HrTPersonnelattributes> findByCriteria(HrTPersonnelattributes t);
}

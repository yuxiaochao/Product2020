package com.huarui.product2020.mapper;

import com.huarui.product2020.entity.HrTPersonnelattributes;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author Administrator
 * @since 2019-08-06
 */
public interface HrTPersonnelattributesMapper extends BaseMapper<HrTPersonnelattributes> {

    /**
     * 根据条件查询
     *
     * @param t
     * @return
     */
    public List<HrTPersonnelattributes> findByCriteria(HrTPersonnelattributes t);
}
package com.huarui.product2020.mapper;

import com.huarui.product2020.entity.Restaurantarrange;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  * 餐厅安排 Mapper 接口
 * </p>
 *
 * @author caifenglin
 * @since 2020-01-14
 */
public interface RestaurantarrangeMapper extends BaseMapper<Restaurantarrange> {

    /**
     * 根据培训班ID获取餐厅安排信息
     * @param id
     * @return
     */
    Restaurantarrange findByTrainId(String id);

}
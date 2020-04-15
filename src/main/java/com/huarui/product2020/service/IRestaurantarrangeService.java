package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.common.Req;
import com.huarui.product2020.entity.Restaurantarrange;
import com.huarui.product2020.entity.ResultEntity;

/**
 * <p>
 * 餐厅安排 服务类
 * </p>
 *
 * @author caifenglin
 * @since 2020-01-14
 */
public interface IRestaurantarrangeService extends IService<Restaurantarrange> {

    ResultEntity saveOrUpdate(Req req);

    Restaurantarrange findByTrainId(String id);
	
}

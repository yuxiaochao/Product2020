package com.huarui.product2020.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.common.Req;
import com.huarui.common.utils.ThreadUtils;
import com.huarui.product2020.entity.Restaurantarrange;
import com.huarui.product2020.entity.ResultEntity;
import com.huarui.product2020.mapper.RestaurantarrangeMapper;
import com.huarui.product2020.service.IRestaurantarrangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 餐厅安排 服务实现类
 * </p>
 *
 * @author caifenglin
 * @since 2020-01-14
 */
@Service
public class RestaurantarrangeServiceImpl extends ServiceImpl<RestaurantarrangeMapper, Restaurantarrange> implements IRestaurantarrangeService {

    
    @Autowired
    private RestaurantarrangeMapper restaurantarrangeMapper;
    
    @Override
    public ResultEntity saveOrUpdate(Req req) {
        ResultEntity result = new ResultEntity();
        String information = req.getString("information");
        
        JSONObject parseObject = JSON.parseObject(information);
        String currentMenu = parseObject.getString("currentMenu");
        
        if(currentMenu.equals("2")) {
            Restaurantarrange restaurantarrange = JSON.parseObject(information, Restaurantarrange.class);
            // 先删除
            EntityWrapper<Restaurantarrange> ew = new EntityWrapper<Restaurantarrange>();
            ew.eq("rear002", restaurantarrange.getRear002());
            restaurantarrangeMapper.delete(ew);
            
            // 后新增
            restaurantarrange.setRear001(ThreadUtils.getRTex().getUUID());
            restaurantarrange.setRear006(0);
            restaurantarrangeMapper.insert(restaurantarrange);
        }
        return result;
    }

    @Override
    public Restaurantarrange findByTrainId(String id) {
        return restaurantarrangeMapper.findByTrainId(id);
    }
	
}

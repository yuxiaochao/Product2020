package com.huarui.product2020.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.huarui.common.Req;
import com.huarui.product2020.entity.Canteen;
import com.huarui.product2020.entity.ResultEntity;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 餐厅资源 服务类
 * </p>
 *
 * @author caifenglin
 * @since 2020-01-06
 */
public interface ICanteenService extends IService<Canteen> {

    Page<Canteen> findList(Page<Canteen> page, Map<String, Object> paramMap);

    List findToExcel(Map paramMap);

    ResultEntity saveOrUpdate(Req req);
    
    String findMaxCode();

    Page<Canteen> findChooseCanteenList(Page<Canteen> page, Map<String, Object> paramMap);
	
}

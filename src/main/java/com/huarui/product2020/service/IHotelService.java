package com.huarui.product2020.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.huarui.common.Req;
import com.huarui.product2020.entity.Hotel;
import com.huarui.product2020.entity.ResultEntity;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 宿舍楼资源 服务类
 * </p>
 *
 * @author caifenglin
 * @since 2020-01-06
 */
public interface IHotelService extends IService<Hotel> {

    
    /**
     * 
     * @param page
     * @param paramMap
     * @return
     */
    Page<Hotel> findList(Page<Hotel> page, Map<String, Object> paramMap);

    List findToExcel(Map paramMap);

    /**
     * 保存或更新
     * @param req
     * @return
     */
    ResultEntity saveOrUpdate(Req req);

    Page<Hotel> findHotelList(Page<Hotel> page, Map<String, Object> paramMap);
	
}

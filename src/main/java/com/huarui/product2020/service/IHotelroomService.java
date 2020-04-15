package com.huarui.product2020.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.huarui.product2020.entity.Hotelroom;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 宿舍房间资源 服务类
 * </p>
 *
 * @author caifenglin
 * @since 2020-01-06
 */
public interface IHotelroomService extends IService<Hotelroom> {

    Page<Hotelroom> findList(Page<Hotelroom> page, Map<String, Object> paramMap);

    List findToExcel(Map paramMap);

    Hotelroom findHotelroomById(String id);
	
}

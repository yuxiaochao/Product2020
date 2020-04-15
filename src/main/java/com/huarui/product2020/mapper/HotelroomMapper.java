package com.huarui.product2020.mapper;

import com.huarui.product2020.entity.Hotelroom;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
  * 宿舍房间资源 Mapper 接口
 * </p>
 *
 * @author caifenglin
 * @since 2020-01-06
 */
public interface HotelroomMapper extends BaseMapper<Hotelroom> {

    List<Hotelroom> findList(Page<Hotelroom> page, Map<String, Object> paramMap);

    List findToExcel(Map paramMap);

    Hotelroom findHotelroomById(String id);

}
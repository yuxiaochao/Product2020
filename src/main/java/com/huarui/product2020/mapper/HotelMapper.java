package com.huarui.product2020.mapper;

import com.huarui.product2020.entity.Hotel;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
  * 宿舍楼资源 Mapper 接口
 * </p>
 *
 * @author caifenglin
 * @since 2020-01-06
 */
public interface HotelMapper extends BaseMapper<Hotel> {

    List<Hotel> findList(Page<Hotel> page, Map<String, Object> paramMap);

    List findToExcel(Map paramMap);

    List<Hotel> findHotelList(Page<Hotel> page, Map<String, Object> paramMap);


}
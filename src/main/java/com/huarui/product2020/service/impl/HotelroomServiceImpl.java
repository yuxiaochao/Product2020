package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.product2020.entity.Hotelroom;
import com.huarui.product2020.mapper.HotelroomMapper;
import com.huarui.product2020.service.IHotelroomService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 宿舍房间资源 服务实现类
 * </p>
 *
 * @author caifenglin
 * @since 2020-01-06
 */
@Service
public class HotelroomServiceImpl extends ServiceImpl<HotelroomMapper, Hotelroom> implements IHotelroomService {

    @Override
    public Page<Hotelroom> findList(Page<Hotelroom> page, Map<String, Object> paramMap) {
        page.setRecords(baseMapper.findList(page, paramMap));
        return page;
    }

    @Override
    public List findToExcel(Map paramMap) {
        return baseMapper.findToExcel(paramMap);
    }

    @Override
    public Hotelroom findHotelroomById(String id) {
        return baseMapper.findHotelroomById(id);
    }
	
}

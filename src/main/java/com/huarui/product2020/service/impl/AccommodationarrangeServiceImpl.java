package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.product2020.entity.Accommodationarrange;
import com.huarui.product2020.entity.Hotelroom;
import com.huarui.product2020.mapper.AccommodationarrangeMapper;
import com.huarui.product2020.mapper.HotelroomMapper;
import com.huarui.product2020.service.IAccommodationarrangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 住宿安排 服务实现类
 * </p>
 *
 * @author caifenglin
 * @since 2020-01-15
 */
@Service
public class AccommodationarrangeServiceImpl extends ServiceImpl<AccommodationarrangeMapper, Accommodationarrange> implements IAccommodationarrangeService {

    
    @Autowired
    private HotelroomMapper hotelroomMapper;

    @Override
    public List<Accommodationarrange> findList(Map<String, Object> paramMap) {
        
        List<Accommodationarrange> list = baseMapper.findList(paramMap);
        for (Accommodationarrange accommodationarrange : list) {
            EntityWrapper<Hotelroom> ew = new EntityWrapper<Hotelroom>();
            ew.eq("horo002", accommodationarrange.getHcar003());
            List<Hotelroom> hotelroomList = hotelroomMapper.selectList(ew);
            accommodationarrange.setHotelroomList(hotelroomList);
        }
        return list;
    }
	
}

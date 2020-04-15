package com.huarui.product2020.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.common.Req;
import com.huarui.common.utils.ThreadUtils;
import com.huarui.product2020.entity.Hotel;
import com.huarui.product2020.entity.ResultEntity;
import com.huarui.product2020.mapper.HotelMapper;
import com.huarui.product2020.service.IHotelService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 宿舍楼资源 服务实现类
 * </p>
 *
 * @author caifenglin
 * @since 2020-01-06
 */
@Service
public class HotelServiceImpl extends ServiceImpl<HotelMapper, Hotel> implements IHotelService {

    @Override
    public Page<Hotel> findList(Page<Hotel> page, Map<String, Object> paramMap) {
        page.setRecords(baseMapper.findList(page, paramMap));
        return page;
    }

    @Override
    public List findToExcel(Map paramMap) {
        return baseMapper.findToExcel(paramMap);
    }

    @Transactional
    @Override
    public ResultEntity saveOrUpdate(Req req) {
        ResultEntity result = new ResultEntity();
        String dormitoryInformation = req.getString("dormitoryInformation");
        
        if(ThreadUtils.getRTex().isNotEmpty(dormitoryInformation)) {
            Hotel hotel = JSON.parseObject(dormitoryInformation, Hotel.class);
            if(ThreadUtils.getRTex().isEmpty(hotel.getHote001())) {
                
                // 新增
                hotel.setHote001(ThreadUtils.getRTex().getUUID());
                hotel.setHote008(req.getUserId());
                hotel.setHote009(new Date());
                hotel.setHote010(new Date());
                baseMapper.insert(hotel);
                result.setData(hotel.getHote001());
            } else {
                // 编辑
                hotel.setHote010(new Date());
                baseMapper.updateById(hotel);
                result.setData(hotel.getHote001());
            }
        }
        return result;
    }

    @Override
    public Page<Hotel> findHotelList(Page<Hotel> page, Map<String, Object> paramMap) {
        page.setRecords(baseMapper.findHotelList(page, paramMap));
        return page;
    }
	
}

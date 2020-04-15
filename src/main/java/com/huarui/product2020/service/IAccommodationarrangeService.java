package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.product2020.entity.Accommodationarrange;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 住宿安排 服务类
 * </p>
 *
 * @author caifenglin
 * @since 2020-01-15
 */
public interface IAccommodationarrangeService extends IService<Accommodationarrange> {

    List<Accommodationarrange> findList(Map<String, Object> paramMap);
	
}

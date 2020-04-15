package com.huarui.product2020.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.huarui.product2020.entity.Dinnerinformation;

import java.util.Map;

/**
 * <p>
 * 就餐信息 服务类
 * </p>
 *
 * @author caifenglin
 * @since 2020-01-06
 */
public interface IDinnerinformationService extends IService<Dinnerinformation> {

    Page<Dinnerinformation> findList(Page<Dinnerinformation> page, Map<String, Object> paramMap);
	
}

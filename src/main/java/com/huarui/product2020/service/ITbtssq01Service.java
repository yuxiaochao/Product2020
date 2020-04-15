package com.huarui.product2020.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.huarui.product2020.entity.Tbtssq01;

import java.util.Map;

/**
 * <p>
 * 图书申请 服务类
 * </p>
 *
 * @author caifl
 * @since 2020-04-01
 */
public interface ITbtssq01Service extends IService<Tbtssq01> {

    Page<Tbtssq01> findListByUserId(Page<Tbtssq01> page, Map<String, Object> paramMap);
	
}

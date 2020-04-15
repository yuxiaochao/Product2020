package com.huarui.product2020.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.huarui.product2020.entity.Tbtssq01;
import com.huarui.product2020.entity.Tbtssq02;

import java.util.Map;

/**
 * <p>
 * 图书申请记录 服务类
 * </p>
 *
 * @author caifl
 * @since 2020-04-03
 */
public interface ITbtssq02Service extends IService<Tbtssq02> {

    Page<Tbtssq01> findBookApplicationListByUserId(Page<Tbtssq01> page, Map<String, Object> paramMap);

    Page<Tbtssq02> findListByUserId(Page<Tbtssq02> page, Map<String, Object> paramMap);
	
}

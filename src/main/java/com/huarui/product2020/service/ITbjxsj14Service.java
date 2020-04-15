package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.common.Req;
import com.huarui.product2020.entity.Tbjxsj14;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author YanZeYang
 * @since 2019-12-17
 */
public interface ITbjxsj14Service extends IService<Tbjxsj14> {

	String submit(Req req) throws Exception;

	Tbjxsj14 findByCriteria(Req req) throws Exception;
}

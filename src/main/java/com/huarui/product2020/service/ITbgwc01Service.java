package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.product2020.entity.Tbgwc01;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author panlei
 * @since 2020-02-18
 */
public interface ITbgwc01Service extends IService<Tbgwc01> {
	/**
	 * 获取购物车商品数量
	 */
	public int queryShoppingCartCount(String userId);
}

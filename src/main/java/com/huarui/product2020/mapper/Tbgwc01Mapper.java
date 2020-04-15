package com.huarui.product2020.mapper;

import com.huarui.product2020.entity.Tbgwc01;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author panlei
 * @since 2020-02-18
 */
public interface Tbgwc01Mapper extends BaseMapper<Tbgwc01> {
	
	/**
	 * 获取购物车商品数量
	 */
	public int queryShoppingCartCount(String userId);
	
}
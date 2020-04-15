package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.product2020.entity.Tbgwc01;
import com.huarui.product2020.mapper.Tbgwc01Mapper;
import com.huarui.product2020.service.ITbgwc01Service;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author panlei
 * @since 2020-02-18
 */
@Service
public class Tbgwc01ServiceImpl extends ServiceImpl<Tbgwc01Mapper, Tbgwc01> implements ITbgwc01Service {
	
	/**
	 * 获取购物车商品数量
	 */
	public int queryShoppingCartCount(String userId) {
		return baseMapper.queryShoppingCartCount(userId);
	}
	
}

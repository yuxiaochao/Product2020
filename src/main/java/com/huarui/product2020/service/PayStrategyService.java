package com.huarui.product2020.service;

import java.util.Map;

public interface PayStrategyService {
	
	/**
	 * 统一下单
	 */
	public Object orderPay(Map<String, String> data);
	
	/**
	 * 查询订单
	 */
	public Object orderQuery(Map<String, String> data);
	
}

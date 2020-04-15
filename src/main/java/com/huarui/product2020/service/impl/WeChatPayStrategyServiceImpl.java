package com.huarui.product2020.service.impl;

import com.huarui.common.sdk.wxpay.WXPay;
import com.huarui.common.sdk.wxpay.WeChatPayConfigImpl;
import com.huarui.product2020.service.PayStrategyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 微信支付
 * @author panlei
 *
 */
@Service
public class WeChatPayStrategyServiceImpl implements PayStrategyService {
	private final static Logger LOGGER = LoggerFactory.getLogger(WeChatPayStrategyServiceImpl.class);
	
	@Autowired
	private WeChatPayConfigImpl weChatPayConfigImpl;
	@Override
	public Map<String, String> orderPay(Map<String, String> data) {
		Map<String, String> resp = null;
		try {
			WXPay wxpay = new WXPay(weChatPayConfigImpl);
	        resp = wxpay.unifiedOrder(data);
		} catch (Exception e) {
			LOGGER.error("支付下单失败",e);
			throw new RuntimeException(e);
		}
        return resp;
	}
	@Override
	public Map<String, String> orderQuery(Map<String, String> data) {
		Map<String, String> resp = null;
		try {
			WXPay wxpay = new WXPay(weChatPayConfigImpl);
	        resp = wxpay.orderQuery(data);
		} catch (Exception e) {
			LOGGER.error("查询订单失败",e);
			throw new RuntimeException(e);
		}
        return resp;
	}

}

package com.huarui.product2020.service.impl;

import com.huarui.common.sdk.alipay.config.AlipayConfig;
import com.huarui.common.sdk.alipay.util.AlipaySubmit;
import com.huarui.product2020.service.PayStrategyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 支付宝支付
 * @author panlei
 *
 */
@Service
public class AliPayStrategyServiceImpl implements PayStrategyService {
	private final static Logger LOGGER = LoggerFactory.getLogger(AliPayStrategyServiceImpl.class);
	
	@Autowired
	private AlipayConfig alipayConfig;
	
//	@Override新版本支付宝支付功能
//	public AlipayTradePagePayResponse orderPay(Map<String, String> data) {
//		AlipayTradePagePayResponse response = null;
//		try {
//			AlipayClient alipayClient = new DefaultAlipayClient(alipayConfig.getWayUrl(),alipayConfig.getAppid(),alipayConfig.merchantPrivateKey(),AlipayConfig.format,AlipayConfig.charset,alipayConfig.alipayPublicKey(),AlipayConfig.sign_type);
//			AlipayTradePagePayRequest aliPayRequest = new AlipayTradePagePayRequest();
//			aliPayRequest.setNotifyUrl(alipayConfig.notifyUrl());
//			aliPayRequest.setReturnUrl(alipayConfig.returnUrl());
//			String bizContent = JSON.toJSONString(data);
//			aliPayRequest.setBizContent(bizContent);
//			response = alipayClient.pageExecute(aliPayRequest);
//		} catch (AlipayApiException e) {
//			e.printStackTrace();
//			LOGGER.error("支付下单失败",e);
//		}
//		return response;
//	}
	
	
	@Override//旧版本支付功能
	public String orderPay(Map<String, String> data) {
		String sHtmlText = null;
		try {
			sHtmlText = AlipaySubmit.buildRequest(data,"get","确认",alipayConfig.merchantPrivateKey());
		} catch (Exception e) {
			LOGGER.error("支付下单失败",e);
			throw new RuntimeException(e);
		}
		return sHtmlText;
	}

	@Override
	public Object orderQuery(Map<String, String> data) {
		// TODO Auto-generated method stub
		return null;
	}

}

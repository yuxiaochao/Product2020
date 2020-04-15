package com.huarui.common.sdk.wxpay;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.huarui.common.ConstantOrder;
import com.huarui.common.utils.RedisUtil;
import com.huarui.product2020.entity.HrswTSysconfig;
import com.huarui.product2020.service.IHrswTSysconfigService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Objects;

@Component
public class WeChatPayConfigImpl extends WXPayConfig {

	private final static Logger LOGGER = LoggerFactory.getLogger(WeChatPayConfigImpl.class);
	@Autowired
	private RedisUtil redisUtil;
	
	@Autowired
	private IHrswTSysconfigService hrswTSysconfigService;
	private byte[] certData;
	
	public WeChatPayConfigImpl() throws Exception {
		//获取证书
        File file = new ClassPathResource("apiclient_cert.p12").getFile();
        InputStream certStream = new FileInputStream(file);
        this.certData = new byte[(int) file.length()];
        certStream.read(this.certData);
        certStream.close();
	}
	
	
	public String getAppID() {
	    return getSysc005(ConstantOrder.weChatPay.WECHAT_APPID);
	}
	/**
	 * 微信支付商户号
	 */
	public String getMchID() {
	    return getSysc005(ConstantOrder.weChatPay.WECHAT_MCHID);
	}
	
	/**
	 * API密钥
	 */
	public String getKey() {
	    return getSysc005(ConstantOrder.weChatPay.WECHAT_KEY);
	}
	
	/**
	 * 回调地址
	 */
	public String getNotifyUrl () {
		 return getSysc005(ConstantOrder.weChatPay.WECHAT_NOTIFY_URL);
	}
	public InputStream getCertStream() {
	    ByteArrayInputStream certBis = new ByteArrayInputStream(this.certData);
	    return certBis;
	}
	public int getHttpConnectTimeoutMs() {
	    return 10000;
	}
	public int getHttpReadTimeoutMs() {
	    return 10000;
	}
	IWXPayDomain getWXPayDomain() {
		 return WXPayDomainSimpleImpl.instance();
	}
	
	public String getSysc005(String key) {
		String value = null;
		try {
			value = Objects.toString(redisUtil.get(key),"");
			if(StringUtils.isBlank(value)) {//缓存误，从数据库中获取
				EntityWrapper<HrswTSysconfig> hrswTSyconfigWarpper = new EntityWrapper<HrswTSysconfig>();
				hrswTSyconfigWarpper.where("SYSC005={0}", key);
				HrswTSysconfig hrswTSysconfig = hrswTSysconfigService.selectOne(hrswTSyconfigWarpper);
				value = hrswTSysconfig.getSysc007();
				redisUtil.set(key, value);
			}
		} catch (Exception e) {
			LOGGER.error("获取支付宝配置信息错误：KEY->"+key,e);
		}
    	return value;
	}
}

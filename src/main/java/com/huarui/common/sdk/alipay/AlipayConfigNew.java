package com.huarui.common.sdk.alipay;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.huarui.common.ConstantOrder;
import com.huarui.common.utils.RedisUtil;
import com.huarui.product2020.entity.HrswTSysconfig;
import com.huarui.product2020.service.IHrswTSysconfigService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * 新版本支付宝配置
 * @author panlei
 *
 */
@Component
public class AlipayConfigNew {
	private final static Logger LOGGER = LoggerFactory.getLogger(AlipayConfigNew.class);
	@Autowired
	private RedisUtil redisUtil;
	
	@Autowired
	private IHrswTSysconfigService hrswTSysconfigService;
	
	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public String getAppid() {
		return getSysc005(ConstantOrder.aliPay.ALIPAY_APPID);
	}
	
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public String merchantPrivateKey() {
//    	return getSysc005(Constant.aliPay.ALIPAY_PRIVATEKEY);
    	return "ebg4l2scro0x58l7p0jthh4p3eb73wor";
    }
    		
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public String alipayPublicKey() {
    	return getSysc005(ConstantOrder.aliPay.ALIPAY_PUBLICKEY);
    }

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public String notifyUrl() {
    	return getSysc005(ConstantOrder.aliPay.ALIPAY_NOTIFY_URL);
	};

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public String returnUrl() {
		return getSysc005(ConstantOrder.aliPay.ALIPAY_RETURN_URL);
	}

	// 签名方式
//	public static String sign_type = "RSA2";
	public static String sign_type = "MD5";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public String getWayUrl() {
		return getSysc005(ConstantOrder.aliPay.ALIPAY_WAY_URL);
	}
	
	public static String format = "json";
	
	//合作伙伴身份
	public String getPid() {
		return getSysc005(ConstantOrder.aliPay.ALIPAY_PID);
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

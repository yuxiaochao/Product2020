package com.huarui.common.sdk.alipay.config;

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
 * 老版本支付宝配置
 * @author panlei
 *
 */
/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *版本：3.4
 *修改日期：2016-03-08
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

@Component
public class AlipayConfig {
	private final static Logger LOGGER = LoggerFactory.getLogger(AlipayConfig.class);
	
	@Autowired
	private RedisUtil redisUtil;
	
	@Autowired
	private IHrswTSysconfigService hrswTSysconfigService;
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// partner 合作身份者ID，签约账号，以2088开头由16位纯数字组成的字符串，查看地址：https://b.alipay.com/order/pidAndKey.htm
	public String getPid() {
		return getSysc005(ConstantOrder.aliPay.ALIPAY_PID);
	}

	// seller_id 收款支付宝账号，以2088开头由16位纯数字组成的字符串，一般情况下收款账号就是签约账号
	public String getAppid() {
		return getSysc005(ConstantOrder.aliPay.ALIPAY_PID);
	}

	// key MD5密钥，安全检验码，由数字和字母组成的32位字符串，查看地址：https://b.alipay.com/order/pidAndKey.htm
    public String merchantPrivateKey() {
    	return getSysc005(ConstantOrder.aliPay.ALIPAY_PRIVATEKEY);
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
	public static String sign_type = "MD5";
	
	// 调试用，创建TXT日志文件夹路径，见AlipayCore.java类中的logResult(String sWord)打印方法。
	public static String log_path = "C:\\";
		
	// 字符编码格式 目前支持 gbk 或 utf-8
	public static String input_charset = "utf-8";
		
	// 支付类型 ，无需修改
	public static String payment_type = "1";
		
	// 调用的接口名，无需修改
	public static String service = "create_direct_pay_by_user";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
	
//↓↓↓↓↓↓↓↓↓↓ 请在这里配置防钓鱼信息，如果没开通防钓鱼功能，为空即可 ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
	
	// 防钓鱼时间戳  若要使用请调用类文件submit中的query_timestamp函数
	public static String anti_phishing_key = "";
	
	// 客户端的IP地址 非局域网的外网IP地址，如：221.0.0.1
	public static String exter_invoke_ip = "";
		
//↑↑↑↑↑↑↑↑↑↑请在这里配置防钓鱼信息，如果没开通防钓鱼功能，为空即可 ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
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


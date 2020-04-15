package com.huarui.product2020.controller.electiveCenter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.huarui.common.Constant;
import com.huarui.common.ConstantOrder;
import com.huarui.common.Req;
import com.huarui.common.sdk.alipay.config.AlipayConfig;
import com.huarui.common.sdk.alipay.util.AlipayNotify;
import com.huarui.common.sdk.alipay.util.AlipaySubmit;
import com.huarui.common.sdk.wxpay.WXPayUtil;
import com.huarui.common.sdk.wxpay.WeChatPayConfigImpl;
import com.huarui.common.utils.IPage;
import com.huarui.common.utils.RedisUtil;
import com.huarui.common.utils.ThreadUtils;
import com.huarui.common.web.BaseController;
import com.huarui.product2020.entity.*;
import com.huarui.product2020.service.*;
import com.huarui.product2020.service.impl.AliPayStrategyServiceImpl;
import com.huarui.product2020.service.impl.WeChatPayStrategyServiceImpl;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.dom4j.DocumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/huarui/order")
public class OrderController extends BaseController {
	private final static Logger LOGGER = LoggerFactory.getLogger(OrderController.class);
	@Autowired
	ITbdd01Service tbdd01Service;
	
	@Autowired
	ITbdd02Service tbdd02Service;
	
	@Autowired
	private ITbgwc02Service tbgwc02Service;
	
	@Autowired
	private ITbgwc01Service tbgwc01Service;
	
	@Autowired
	private WeChatPayStrategyServiceImpl weChatPayStrategyServiceImpl;
	
	@Autowired
	private AliPayStrategyServiceImpl aliPayStrategyServiceImpl;
	
	@Autowired
	private RedisUtil redisUtil;
	
	@Autowired
    AlipayConfig alipayConfig;
	
	@Autowired
	private WeChatPayConfigImpl weChatPayConfigImpl;
	
	@Autowired
	private ITbyhqgl07Service tbyhqgl07Service;
	
	@Autowired
	private ITbyhqgl08Service tbyhqgl08Service;
	
	//优惠券
	private ThreadLocal<Map<String, List<String>>> couponThreadLocal = new ThreadLocal<Map<String, List<String>>>() {
		public synchronized Map<String, List<String>> initialValue() {
			return new HashMap<String, List<String>>();
		}
	};
	
	//优惠券商品类型 0:套包 1:单商品
	private ThreadLocal<Map<String, Integer>> commodityTypeThreadLocal = new ThreadLocal<Map<String, Integer>>() {
		public synchronized Map<String, Integer> initialValue() {
			return new HashMap<String, Integer>();
		}
	};
		
	//促销活动
	private ThreadLocal<Map<String, String>> promotionThreadLocal = new ThreadLocal<Map<String, String>>() {
		public synchronized Map<String, String> initialValue() {
			return new HashMap<String, String>();
		}
	};
	
	@RequestMapping("/submit")
	@Transactional
	public ResultEntity list(Req req)throws Exception {
		ResultEntity result = new ResultEntity();
		try {
			
			String commodityCoupon = req.getString("commodityCoupon");
			
			JSONArray array = JSON.parseArray(commodityCoupon);
			//获取优惠券id
			List<String> couonList = queryCouponList(array);
			if(null != couonList && couonList.size() > 0) {
				String checkResult = checkCoupon(couonList,req.getUserId());
				if(StringUtils.isNotBlank(checkResult)) {
					result.setErrorMsg(checkResult);
					return result;
				}
				
				// 验证优惠券对每个商品是否超过200、套包是否超过700 
				checkResult = checkCouponPrice(array,req.getUserId());
				if(StringUtils.isNotBlank(checkResult)) {
					result.setErrorMsg(checkResult);
					return result;
				}
			}
			
			//处理订单
			String tbdd01 = handleOrder(req.getUserId(), array);
			
			//订单失效时间
			redisUtil.set(ConstantOrder.payKeys.USER_ORDER+tbdd01, "1", ConstantOrder.ORDER_INVALID_TIME);
			
			result.setData(tbdd01);
		}catch(Exception e) {
			result.setErrorMsg("数据获取失败");
			LOGGER.error("数据获取失败",e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		
		return result;
	}
	
	
	private String handleOrder(String userId, JSONArray array) {
		//根据代理机构id获取购物车数据
		BigDecimal dd0107Price = new BigDecimal("0");//订单金额
		BigDecimal actuallyPaidPrice = new BigDecimal("0");//实付金额
		Map<String, List<String>> couponMap = couponThreadLocal.get();//优惠券
		Map<String, String> promotionMap = promotionThreadLocal.get();//优惠活动
		// 获取用户购物车数据
		List<Map<String, Object>> commodityList = tbgwc02Service.queryCartListByUserId(userId);
		List<Tbgwc02> tbgwc02List = new ArrayList<Tbgwc02>();//更新tbGWC02加入商品的优惠后、购买价格
		String cardId = null;
		String dd0101 = ThreadUtils.getRTex().getUUID();
		for(int i=0;i<commodityList.size();i++) {
			Map<String, Object> commodity = commodityList.get(i);
			String commodityId = Objects.toString(commodity.get("commodityId"));//商品ID
			int amount = NumberUtils.toInt(Objects.toString(commodity.get("amount")));//数量
			String gwc0201 = Objects.toString(commodity.get("gwc0201"));//加入商品ID
			double singlePrice = NumberUtils.toDouble(Objects.toString(commodity.get("price")));
			BigDecimal singleTotalPrice = new BigDecimal(Objects.toString(commodity.get("totalprice")));
			Tbgwc02 tbgwc02Entity = new Tbgwc02();
			tbgwc02Entity.setGwc0201(gwc0201);
			tbgwc02Entity.setGwc0210(singlePrice);
			tbgwc02Entity.setGwc0212(dd0101);
			dd0107Price = dd0107Price.add(singleTotalPrice);
			if(i == 0) {
				cardId = Objects.toString(commodity.get("gwc0101"));
			}
			//单商品总价格
			if(couponMap.containsKey(commodityId)) {//判断商品是否使用优惠券活动
				List<String> couponIdList = couponMap.get(commodityId);
				//获取优惠券总价格 
				double couponPrice = tbyhqgl07Service.queryCouponPrice(couponIdList);
				BigDecimal price = singleTotalPrice.subtract(new BigDecimal(couponPrice));//优惠后价格
				BigDecimal unitPrice = new BigDecimal(price.doubleValue()).divide(new BigDecimal(amount),2, BigDecimal.ROUND_HALF_UP);//优惠后单价
				tbgwc02Entity.setGwc0209(unitPrice.doubleValue());//优惠后单价格
				actuallyPaidPrice = actuallyPaidPrice.add(price);
			}else {//验证该商品是否使用促销活动
				if(promotionMap.containsKey(commodityId)) {
					double eventDiscount = NumberUtils.toDouble(Objects.toString(commodity.get("eventDiscount")));//促销活动
					BigDecimal price = singleTotalPrice.multiply(new BigDecimal(eventDiscount).divide(new BigDecimal(10),2, BigDecimal.ROUND_HALF_UP)); //促销后价格
					BigDecimal unitPrice = new BigDecimal(price.doubleValue()).divide(new BigDecimal(amount),2, BigDecimal.ROUND_HALF_UP);//优惠后单价
					tbgwc02Entity.setGwc0209(unitPrice.doubleValue()); //优惠后单价格
					tbgwc02Entity.setGwc0211(Objects.toString(commodity.get("xxkgl0801")));
					actuallyPaidPrice = actuallyPaidPrice.add(price);
				}else {
					tbgwc02Entity.setGwc0209(singlePrice); //优惠后单价格
					actuallyPaidPrice = actuallyPaidPrice.add(singleTotalPrice);
				}
			}
			tbgwc02List.add(tbgwc02Entity);
		}
		//更新加入商品数据
		updateAddCommodity(tbgwc02List);
		
		actuallyPaidPrice = actuallyPaidPrice.setScale(2, BigDecimal.ROUND_HALF_UP);
		dd0107Price = dd0107Price.setScale(2, BigDecimal.ROUND_HALF_UP);
		
		//添加订单
		JSONObject dd01Object = new JSONObject();
		dd01Object.put("actuallyPaidPrice", actuallyPaidPrice.doubleValue());
		dd01Object.put("cardId", cardId);
		dd01Object.put("userId", userId);
		dd01Object.put("dd0101", dd0101);
		dd01Object.put("dd0107Price", dd0107Price);
		
		addTbdd01(dd01Object);
		
		//处理优惠券信息
		handleCouponInfo(userId,dd0101,array);
		
		return dd0101;
	}
	
	private void handleCouponInfo(String agencyId, String dd0101, JSONArray array) {
		Map<String, List<String>> couponMap = couponThreadLocal.get();//优惠券
		Map<String, Integer> commodityTypeMap = commodityTypeThreadLocal.get();//商品类型 0:套包 1:单商品
		List<Tbyhqgl08> yhqgl08List = new ArrayList<Tbyhqgl08>();
		List<String> couponALlList = new ArrayList<String>();
		
		for(Map.Entry<String, List<String>> entry : couponMap.entrySet()){
			List<String> couponList = entry.getValue();
			String commodityId = entry.getKey(); //商品ID
			int commodityType = commodityTypeMap.get(commodityId);//商品类型
			couponALlList.addAll(couponList);
			
			for(String couponId: couponList) {
				Tbyhqgl08 yhqgl08Entity = new Tbyhqgl08();
				yhqgl08Entity.setYhqgl0802(couponId);
				yhqgl08Entity.setYhqgl0803(dd0101);
				if(commodityType == 0) {
					yhqgl08Entity.setYhqgl0804(commodityId);
				}else {
					yhqgl08Entity.setYhqgl0805(commodityId);
				}
				yhqgl08List.add(yhqgl08Entity);
			}
			
		}
		
		if(couponALlList.size() > 0) {
			tbyhqgl07Service.updateCoupon(couponALlList,agencyId);
		}
	
		if(yhqgl08List.size() > 0) {
			tbyhqgl08Service.insertBatch(yhqgl08List);
		}
		
	}
	
	private void updateAddCommodity(List<Tbgwc02> tbgwc02List) {
		tbgwc02Service.updateGwc02(tbgwc02List);
	}
	
	private void addTbdd01(JSONObject dd01Object) {
		
		String orderNumber = generateOrder();
		//更新购物车状态
		Tbgwc01 tbgwc01Entity = new Tbgwc01();
		tbgwc01Entity.setGwc0101(dd01Object.getString("cardId"));
		tbgwc01Entity.setGwc0105(0D);
		tbgwc01Service.updateById(tbgwc01Entity);
		
		//添加订单数据
		Tbdd01 tbDD01Entity = new Tbdd01();
		tbDD01Entity.setDd0101(dd01Object.getString("dd0101"));
		tbDD01Entity.setDd0102(dd01Object.getString("userId"));
		tbDD01Entity.setDd0103(dd01Object.getString("cardId"));
		tbDD01Entity.setDd0104(orderNumber);
		tbDD01Entity.setDd0105(new Date());
		tbDD01Entity.setDd0106(ConstantOrder.orderStatus.ORDER_STATUS_0);
		tbDD01Entity.setDd0107(dd01Object.getDouble("dd0107Price"));
		tbDD01Entity.setDd0110(dd01Object.getDouble("actuallyPaidPrice"));
		tbDD01Entity.setDd0111(dd01Object.getDouble("actuallyPaidPrice"));
		tbdd01Service.insert(tbDD01Entity);
	}
	
	/**
	 * 验证优惠券对每个商品是否超过200、套包是否超过700 
	 */
	private String checkCouponPrice(JSONArray array, String userId){
		String msg = null;
		for(int i=0;i<array.size();i++) {
			JSONObject commodityCouponObj = array.getJSONObject(i);
			int activityType = commodityCouponObj.getIntValue("activityType");//1 促销活动 0 优惠券
			if(activityType == 1) {
				continue;
			}
			String commodityId = commodityCouponObj.getString("commodityId"); //商品ID
			Map<String, List<String>> couponMap = couponThreadLocal.get();
			if(!couponMap.containsKey(commodityId)) {//该商品未使用优惠券
				continue;
			}
			List<String> couponList = couponMap.get(commodityId);
			msg = checkCommodity(commodityCouponObj,userId,couponList);
			
			if(StringUtils.isNotBlank(msg)) {
				break;
			}
		}
		
		return msg;
	}
	
	//校验商品优惠券价格
	private String checkCommodity(JSONObject commodityCouponObj, String userId, List<String> couponList) {
		String commodityId = commodityCouponObj.getString("commodityId"); //id
		String commodityType = commodityCouponObj.getString("commodityType");  //0：套包 1：单商品
		Map<String, String> params = new HashMap<String, String>();
		params.put("commodityId", commodityId);
		params.put("commodityType", commodityType);
		params.put("userId", userId); //代理机构id
		Map<String, Object> map = tbyhqgl07Service.checkCouponPrice(couponList,params);
		if(null == map) {
			return "校验商品优惠券异常，请联系管理员.";
		}
		float totalPrice = NumberUtils.toFloat(Objects.toString(map.get("totalPrice")));
		String commodityName = Objects.toString(map.get("commodityName"));
		
		DecimalFormat decimalFormat = new DecimalFormat("0.00#");
		if(StringUtils.equals(commodityType, "0")) {
			if(totalPrice > ConstantOrder.packagePrice) {
				return "商品：'"+commodityName+"'最多优惠"+ decimalFormat.format(ConstantOrder.packagePrice);
			}
		}else {
			if(totalPrice > ConstantOrder.commodityPrice) {
				return "商品：'"+commodityName+"'最多优惠"+ decimalFormat.format(ConstantOrder.commodityPrice);
			}
		}
		return null;
	}
	
	/**
	 * 获取所有优惠券
	 */
	private List<String> queryCouponList(JSONArray array) {
		List<String> couponList = new ArrayList<String>();
		for(int i=0;i<array.size();i++) {
			List<String> couponList1 = new ArrayList<String>();
			JSONObject commodityCouponObj = array.getJSONObject(i);
			int activityType = commodityCouponObj.getIntValue("activityType");//1 促销活动 0 优惠券
			String commodityId = commodityCouponObj.getString("commodityId"); //商品ID
			int commodityType = commodityCouponObj.getIntValue("commodityCouponObj"); //商品类型 0:套包 1:单商品
			if(activityType == 1) {
				Map<String, String> promotionMap = promotionThreadLocal.get();
				promotionMap.put(commodityId, commodityId);
				promotionThreadLocal.set(promotionMap);
				continue;
			}
			String couponArray = commodityCouponObj.getString("couponArray");
			JSONArray couponJsonArray = JSON.parseArray(couponArray);
			if(null != couponJsonArray && couponJsonArray.size() > 0) {
				for(int j=0;j<couponJsonArray.size();j++) {
					JSONObject coupon = couponJsonArray.getJSONObject(j);
					couponList1.add(coupon.getString("couponId"));
				}
				Map<String, List<String>> couponMap = couponThreadLocal.get();
				couponMap.put(commodityId, couponList1);//存储每个商品对应的优惠券
				couponList.addAll(couponList1);//获取所有商品优惠券
				couponThreadLocal.set(couponMap);

				Map<String, Integer> commodityTypeMap = commodityTypeThreadLocal.get();
				commodityTypeMap.put(commodityId,commodityType);
				commodityTypeThreadLocal.set(commodityTypeMap);
			}
			
		}
		return couponList;
	}
	
	/**
	 * 验证优惠券是否被篡改 
	 */
	private String checkCoupon(List<String> couonList, String userId) {
		String checkResult = null;
		int count = tbyhqgl07Service.checkCouponCount(couonList, userId);
		if(couonList.size() != count) {
			checkResult = "校验数据已被篡改,提交订单失败。";
		}
		return checkResult;
	}
	
	/**
	 * 生成订单
	 */
	public String generateOrder() {
		DateFormat d = new SimpleDateFormat("yyyyMMdd");
		String time = d.format(new Date());
		DecimalFormat df = new DecimalFormat("000000");
		long num = redisUtil.incr("order"+ time, ConstantOrder.ORDER_NUMBER_INVALID_TIME);
    	String orderNum = time+df.format(num);
    	return orderNum;
	}
	
	@RequestMapping("/info")
	public ResultEntity OrderInfo(Req req)throws Exception {
		ResultEntity result = new ResultEntity();
		try {
			//根据订单ID获取订单详情 
			Map<String, Object> orderInfo = tbgwc02Service.queryOrderInfoById(req.getString("dd0101"),req.getUserId());
			if(null == orderInfo) {
				result.setErrorMsg("当前订单已关闭，请重新下单！");
				LOGGER.info("当前订单已关闭，请重新下单！");
				return result;
			}
			result.setData(orderInfo);
		}catch(Exception e) {
			result.setErrorMsg("获取订单信息失败！");
			LOGGER.error("获取订单信息失败！",e);
		}
		return result;
	}
	
	
	/**
	 * 手动查询订单否已经完成
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/orderquery")
	public ResultEntity OrderQuery(Req req)throws Exception {
		ResultEntity result = new ResultEntity();
		try {
			//根据订单ID获取订单详情 
			String dd0101 = req.getString("dd0101");
			EntityWrapper<Tbdd01> wrapper = new EntityWrapper<Tbdd01>();
			wrapper.where("DD0101={0} AND DD0102={1}", dd0101,req.getUserId());
			Tbdd01 tbdd01 = tbdd01Service.selectOne(wrapper);
			if(null == tbdd01) {
				result.setErrorMsg("当前订单不存在，请重新下单！");
				return result;
			}
			
			if(tbdd01.getDd0106() == ConstantOrder.orderStatus.ORDER_STATUS_1) { //已付款
				result.setData(Constant.SUCCESS);
			}else {//未付款，查询微信订单
				result.setData(Constant.FAIL);
			}
		}catch(Exception e) {
			result.setErrorMsg("获取订单信息失败！");
			LOGGER.error("获取订单信息失败！",e);
		}
		
		return result;
	}
	
	@RequestMapping("/payOrder")
	public ResultEntity payOrder(Req req, HttpServletRequest request)throws Exception {
		ResultEntity result = new ResultEntity();
		try {
			//根据订单ID获取订单详情 
			String dd0101 = req.getString("dd0101");
			Map<String, Object> orderInfo = tbgwc02Service.queryOrderInfoById(dd0101,req.getUserId());
			if(null == orderInfo) {
				result.setErrorMsg("当前订单已提交或已关闭，请重新下单！");
				LOGGER.info("当前订单已提交或已关闭，请重新下单！");
				return result;
			}
			//支付方式
			int payType = NumberUtils.toInt(req.getString("payType"));
			if(payType == 2) {//微信
				Map<String, String> data = weChatData(orderInfo,request);
				if(null == data) {
					result.setErrorMsg("支付订单失败！");
					return result;
				}
				
				Map<String, String> resp = weChatPayStrategyServiceImpl.orderPay(data);
				if(null == resp ) {
					result.setErrorMsg("支付订单失败！");
					return result;
				}
				handleResult(resp,result);
				if(StringUtils.isNotBlank(result.getErrorMsg())) {
					return result;
				}
				
				//将微信二维码路径储存
				Tbdd01 tbdd01 = new Tbdd01();
				tbdd01.setDd0101(dd0101);
				tbdd01.setDd0108(resp.get("code_url"));
				tbdd01Service.updateById(tbdd01);
			}else if(payType == 1) {//支付宝
				Map<String, String> data = aliPayData(orderInfo,request);
				String resp = aliPayStrategyServiceImpl.orderPay(data);
				if(StringUtils.isBlank(resp) ) {
					result.setErrorMsg("支付订单失败！");
					return result;
				}
				LOGGER.info("支付宝下单成功");
				result.setData(resp);
				
				
//	暂时注释新支付宝接口			if(resp.isSuccess()){
//					LOGGER.info("支付宝下单成功");	
//					result.setData(resp.getBody());
//				} else {
//					LOGGER.info("支付宝下单成功 错误信息"+resp.getSubMsg());
//					result.setErrorMsg("支付订单失败！");
//					return result;
//				}
			}
			
		}catch(Exception e) {
			result.setErrorMsg("支付订单失败！");
			LOGGER.error("支付订单失败！",e);
		}
		
		return result;
	}
	
	//组装支付宝格式数据
	private Map<String, String> aliPayData(Map<String, Object> orderInfo, HttpServletRequest request) throws MalformedURLException, DocumentException, IOException {
		BigDecimal total_fee = new BigDecimal(NumberUtils.toDouble(ObjectUtils.toString(orderInfo.get("dd0111"))));
		String out_trade_no = Objects.toString(orderInfo.get("dd0104"),"");
		if(StringUtils.isBlank(out_trade_no) || total_fee.doubleValue() == 0) {
			return null;
		}
		
		String subject = Objects.toString(orderInfo.get("cmdy0404"),"");
		
		Map<String, String> jsonObject = new HashMap<String, String>();
		jsonObject.put("service", AlipayConfig.service);
		jsonObject.put("partner",alipayConfig.getPid());
		jsonObject.put("seller_id",alipayConfig.getAppid());
		jsonObject.put("_input_charset", AlipayConfig.input_charset);
		jsonObject.put("payment_type", AlipayConfig.payment_type);
		jsonObject.put("notify_url",alipayConfig.notifyUrl());
		jsonObject.put("return_url",alipayConfig.returnUrl());
		jsonObject.put("anti_phishing_key", AlipaySubmit.query_timestamp(alipayConfig.getPid()));
		jsonObject.put("exter_invoke_ip", ThreadUtils.getRTex().getIpAddr(request));
		jsonObject.put("out_trade_no", out_trade_no);
		jsonObject.put("subject", subject);
		jsonObject.put("total_fee", Objects.toString(total_fee.doubleValue()));
		
		
		/**新版本支付代码**/
//		jsonObject.put("out_trade_no", out_trade_no);
//		jsonObject.put("product_code", "FAST_INSTANT_TRADE_PAY");
//		jsonObject.put("total_amount", Objects.toString(total_fee.doubleValue()));
//		jsonObject.put("subject",subject);
//		jsonObject.put("timeout_express", "2h");
		return jsonObject;
	}
	
	
	/**
	 * 组装微信支付格式数据
	 */
	private Map<String, String> weChatData(Map<String, Object> orderInfo, HttpServletRequest request){
		BigDecimal total_fee = new BigDecimal(NumberUtils.toDouble(ObjectUtils.toString(orderInfo.get("dd0111")))*100);
		String out_trade_no = Objects.toString(orderInfo.get("dd0104"),"");
		if(StringUtils.isBlank(out_trade_no) || total_fee.doubleValue() == 0) {
			return null;
		}
		
		Map<String, String> data = new HashMap<String, String>();
        data.put("body", ThreadUtils.getRTex().splitStr(Objects.toString(orderInfo.get("cmdy0404"),""),40));
        data.put("out_trade_no", out_trade_no);
        data.put("device_info", "WEB");
        data.put("fee_type", "CNY");
        data.put("total_fee", total_fee.toString());
        data.put("spbill_create_ip", ThreadUtils.getRTex().getIpAddr(request));
        data.put("notify_url", weChatPayConfigImpl.getNotifyUrl());
        data.put("trade_type", "NATIVE");  // 此处指定为扫码支付
        
        data.put("product_id", Objects.toString(orderInfo.get("dd0101"),""));
        LOGGER.info("微信组装数据"+JSON.toJSONString(data));
        return data;
	}
	
	/**
	 * 处理微信支付返回结构
	 */
	private ResultEntity handleResult(Map<String, String> resp, ResultEntity result) {
		LOGGER.info("微信支付返回结果数据 "+resp);
		if(Objects.equals(Objects.toString(resp.get("return_code")), Constant.SUCCESS) ) {
			if(Objects.equals(Objects.toString(resp.get("result_code")), Constant.FAIL)) {
				String err_code = Objects.toString(resp.get("err_code"));
				String err_code_des = Objects.toString(resp.get("err_code_des"));
				if(Objects.equals(err_code, "SYSTEMERROR")) {
					
				}else {
					result.setErrorMsg(err_code_des);
					LOGGER.info("微信支付错误:错误代码 "+err_code+",错误代码描述 " + err_code_des);
				}
			}
		}else {
			result.setErrorMsg("支付订单失败！");
			LOGGER.info("微信支付错误:"+resp.get("return_msg"));
			
		}
		return result;
	}
	
	/**
	 * 微信支付回调
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/weChatCallBack")
	@Transactional
	public void weChatCallBack(HttpServletRequest request, HttpServletResponse response)throws Exception {
		try {
			LOGGER.info("-----------微信回调开始-------");
			InputStream in = request.getInputStream();
			BufferedReader br = new BufferedReader( new InputStreamReader( in, "UTF-8" ) );
			StringBuffer result = new StringBuffer();
			String line = "";
			while ( ( line = br.readLine() ) != null )
			{
				result.append(line);
			}
			Map<String, String> resultMap = WXPayUtil.xmlToMap( result.toString() );
			LOGGER.info("-----------微信回调参数："+resultMap);
			if(null == resultMap) {
				LOGGER.info("-----------微信回调结果数据失败----------");
				return;
			}
			in.close();
			boolean flag = handleWeChatCallBack(resultMap);
			if(flag) {
				Map<String, String> clallMap = new HashMap<String, String>();
				clallMap.put("return_code", Constant.SUCCESS);
				clallMap.put("return_msg", "OK");
				String resXml = WXPayUtil.mapToXml(clallMap);
				BufferedOutputStream out = new BufferedOutputStream(
                        response.getOutputStream());
                out.write(resXml.getBytes());
                out.flush();
                out.close();
                LOGGER.info("-----------微信回调返回数据微信结束-------");
			}
			LOGGER.info("-----------微信回调结束-------");
		}catch(Exception e) {
			LOGGER.error("---------微信回调失败--------------",e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
	}
	
	private boolean handleWeChatCallBack(Map<String, String> resultMap) {
		boolean flag = false;
		if(Objects.equals(Objects.toString(resultMap.get("return_code")), Constant.SUCCESS) ) {
			if(Objects.equals(Objects.toString(resultMap.get("result_code")), Constant.FAIL)) {
				String err_code = Objects.toString(resultMap.get("err_code"));
				String err_code_des = Objects.toString(resultMap.get("err_code_des"));
				if(Objects.equals(err_code, "SYSTEMERROR")) {
					
				}else {
					LOGGER.error("微信支付错误:错误代码 "+err_code+",错误代码描述 " + err_code_des);
				}
			}else {
				//更新订单数据
				//获取订单号
				String dd0104 =  resultMap.get("out_trade_no");
				//根据订单号查询订单信息
				EntityWrapper<Tbdd01> wrapper = new EntityWrapper<Tbdd01>();
				wrapper.where("DD0104={0}", dd0104);
				Tbdd01 tbdd01 = tbdd01Service.selectOne(wrapper);
				if(null == tbdd01) {
					return flag;
				}
				
				double dd0106 = tbdd01.getDd0106();
				//校验订单是否已经完成
				if(dd0106 == ConstantOrder.orderStatus.ORDER_STATUS_1) {
					return true;
				}
				
				//校验订单价格是否正确
				double total_fee = NumberUtils.toLong(resultMap.get("total_fee"));
				double dd0111 = tbdd01.getDd0111() * 100;
				
				if(dd0111 != total_fee) {
					LOGGER.error("-----------微信回调数据异常--------------价格数据不正确，数据信息:"+resultMap);
					return flag;
				}
			
				//检验支付信息是否存在
				EntityWrapper<Tbdd02> wrapper1 = new EntityWrapper<Tbdd02>();
				wrapper1.where("DD0202={0} AND DD0205 = 1", tbdd01.getDd0101());
				int num = tbdd02Service.selectCount(wrapper1);
				if(num == 0) {
					
					Tbdd01 tbdd01N = new Tbdd01();
					tbdd01N.setDd0101(tbdd01.getDd0101());
					tbdd01N.setDd0106(ConstantOrder.orderStatus.ORDER_STATUS_1);//已付款
					tbdd01Service.updateById(tbdd01N);
					
					Tbdd02 tbdd02 = new Tbdd02();
					tbdd02.setDd0202(tbdd01.getDd0101());
					tbdd02.setDd0203(tbdd01.getDd0103());
					if(total_fee > 0) {
						tbdd02.setDd0204(total_fee/100);
					}else {
						tbdd02.setDd0204(0d);
					}
					tbdd02.setDd0205(1d);
					tbdd02.setDd0206(new Date());
					tbdd02Service.insert(tbdd02);
					
					//将购买的课程放入我的课程中
					tbdd01Service.addCourse(tbdd01.getDd0101());
					
					redisUtil.removePattern("coursePackageList_"+tbdd01.getDd0102()+"*");
					redisUtil.removePattern("userProgressCourse_"+tbdd01.getDd0102());
				}
				flag = true;
			}
		}else {
			LOGGER.error("-----------微信回调失败----------,错误信息："+resultMap.get("return_msg"));
		}
		return flag;
	}
	
	
	/**
	 * 旧版本支付宝支付回调
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/aliPayCallBack")
	@Transactional
	public void aliPayCallBack(HttpServletRequest request, HttpServletResponse response)throws Exception {
		LOGGER.info("-----------支付宝回调开始--------------");
		BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
		//获取支付宝POST过来反馈信息
		Map<String, String> params = new HashMap<String, String>();
		Map<String, String[]> requestParams = request.getParameterMap();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			//乱码解决，这段代码在出现乱码时使用
//			valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			params.put(name, valueStr);
		}
		LOGGER.info("-----------支付宝回调参数--------------"+params);
		boolean signVerified = AlipayNotify.verify(params, alipayConfig.getPid(), alipayConfig.merchantPrivateKey());
		LOGGER.info("-----------参数验证情况--------------"+signVerified);
		if(signVerified) {//验证成功
			//商户订单号
			String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
		
			//交易状态
			String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");
			
			//价格
			double total_fee = NumberUtils.toDouble(new String(request.getParameter("total_fee").getBytes("ISO-8859-1"),"UTF-8"));
			
			//卖家支付宝用户号
			String seller_id =  new String(request.getParameter("seller_id").getBytes("ISO-8859-1"),"UTF-8");
			
			//查询订单是否存在
			EntityWrapper<Tbdd01> wrapper = new EntityWrapper<Tbdd01>();
			wrapper.where("DD0104={0}", out_trade_no);
			Tbdd01 tbdd01 = tbdd01Service.selectOne(wrapper);
			
			boolean flag = checkOrder(out_trade_no, total_fee, seller_id, seller_id,tbdd01);
			
			if(flag) {
				if(trade_status.equals("TRADE_FINISHED")){
					//判断该笔订单是否在商户网站中已经做过处理
					//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
					//如果有做过处理，不执行商户的业务程序
						
					//注意：
					//退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
					
					payInfo(tbdd01, total_fee, out);
				}else if (trade_status.equals("TRADE_SUCCESS")){
					//判断该笔订单是否在商户网站中已经做过处理
					//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
					//如果有做过处理，不执行商户的业务程序
					
					//注意：
					//付款完成后，支付宝系统发送该交易状态通知
					//查看订单是否已
					payInfo(tbdd01, total_fee, out);
				}
			}else {
				out.write("fail".getBytes());
			}
		}else {//验证失败
			out.write("fail".getBytes());
		
			//调试用，写文本函数记录程序运行情况是否正常
			//String sWord = AlipaySignature.getSignCheckContentV1(params);
			//AlipayConfig.logResult(sWord);
		}
		 out.flush();
         out.close();
	}
	
	private void payInfo(Tbdd01 tbdd01, double total_fee, BufferedOutputStream out) throws IOException {
		try {
			//检验支付信息是否存在
			EntityWrapper<Tbdd02> wrapper1 = new EntityWrapper<Tbdd02>();
			wrapper1.where("DD0202={0} AND DD0205 = 0", tbdd01.getDd0101());
			int num = tbdd02Service.selectCount(wrapper1);
			if(num == 0) {
				
				Tbdd01 tbdd01N = new Tbdd01();
				tbdd01N.setDd0101(tbdd01.getDd0101());
				tbdd01N.setDd0106(ConstantOrder.orderStatus.ORDER_STATUS_1);//已付款
				tbdd01Service.updateById(tbdd01N);
				
				Tbdd02 tbdd02 = new Tbdd02();
				tbdd02.setDd0202(tbdd01.getDd0101());
				tbdd02.setDd0203(tbdd01.getDd0103());
				tbdd02.setDd0204(total_fee);
				tbdd02.setDd0205(0d);
				tbdd02.setDd0206(new Date());
				tbdd02Service.insert(tbdd02);
				
				//将购买的课程放入我的课程中
				tbdd01Service.addCourse(tbdd01.getDd0101());
				
				redisUtil.removePattern("coursePackageList_"+tbdd01.getDd0102()+"*");
				redisUtil.removePattern("userProgressCourse_"+tbdd01.getDd0102());
			}
			out.write("success".getBytes());
		} catch (Exception e) {
			LOGGER.error("支付宝回调数据失败",e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			out.write("fail".getBytes());
		}
	}
	
	/* 实际验证过程建议商户务必添加以下校验：
	1、需要验证该通知数据中的out_trade_no是否为商户系统中创建的订单号，
	2、判断total_amount是否确实为该订单的实际金额（即商户订单创建时的金额），
	3、校验通知中的seller_id（或者seller_email) 是否为out_trade_no这笔单据的对应的操作方（有的时候，一个商户可能有多个seller_id/seller_email）
	4、验证app_id是否为该商户本身。
	*/
	private boolean checkOrder(String out_trade_no, double total_amount, String seller_id, String app_id, Tbdd01 tbdd01) {
		if(null == tbdd01) {
			LOGGER.error("-----------支付宝回调失败,订单数据不存在----------订单号："+out_trade_no);
			return false;
		}
		
		//检查订单价格是否正确
		if(tbdd01.getDd0111() != total_amount) {
			LOGGER.error("-----------支付宝回调失败,订单价格与返回的价格不匹配----------订单号："+out_trade_no);
			return false;
		}
		
		//检验seller_id
		if(!StringUtils.equals(seller_id, alipayConfig.getPid())) {
			LOGGER.error("-----------支付宝回调失败,卖家ID不匹配----------订单号："+out_trade_no);
			return false;
		}
		
		//验证app_id是否为该商户本身
		if(!StringUtils.equals(app_id, alipayConfig.getAppid())) {
			LOGGER.error("-----------支付宝回调失败,app_id不匹配----------订单号："+out_trade_no);
			return false;
		}
		
		return true;
		
	}
	
	
	
	/**
	 * 新版本支付宝支付回调
	 * @param request
	 * @param response
	 * @throws Exception
	 */
//	@RequestMapping("/aliPayCallBack")
//	public void aliPayCallBack(HttpServletRequest request,HttpServletResponse response)throws Exception {
//		LOGGER.info("-----------支付宝回调开始--------------");
//		BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
//		//获取支付宝POST过来反馈信息
//		Map<String,String> params = new HashMap<String,String>();
//		Map<String,String[]> requestParams = request.getParameterMap();
//		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
//			String name = (String) iter.next();
//			String[] values = (String[]) requestParams.get(name);
//			String valueStr = "";
//			for (int i = 0; i < values.length; i++) {
//				valueStr = (i == values.length - 1) ? valueStr + values[i]
//						: valueStr + values[i] + ",";
//			}
//			//乱码解决，这段代码在出现乱码时使用
////			valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
//			params.put(name, valueStr);
//		}
//		LOGGER.info("-----------支付宝回调参数--------------"+params);
//		boolean signVerified = AlipaySignature.rsaCheckV1(params, alipayConfig.alipayPublicKey(), AlipayConfig.charset, AlipayConfig.sign_type); //调用SDK验证签名
//		LOGGER.info("-----------参数验证情况--------------"+signVerified);
//		if(signVerified) {//验证成功
//			//商户订单号
//			String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
//		
//			//交易状态
//			String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");
//			
//			//价格
//			double total_amount = NumberUtils.toDouble(new String(request.getParameter("total_amount").getBytes("ISO-8859-1"),"UTF-8"));
//			
//			//卖家支付宝用户号
//			String seller_id =  new String(request.getParameter("seller_id").getBytes("ISO-8859-1"),"UTF-8");
//			
//			//appid
//			String app_id =  new String(request.getParameter("app_id").getBytes("ISO-8859-1"),"UTF-8");
//			
//			//查询订单是否存在
//			EntityWrapper<Tbdd01> wrapper = new EntityWrapper<Tbdd01>();
//			wrapper.where("DD0104={0}", out_trade_no);
//			Tbdd01 tbdd01 = tbdd01Service.selectOne(wrapper);
//			
//			boolean flag = checkOrder(out_trade_no, total_amount, seller_id, app_id,tbdd01);
//			
//			if(flag) {
//				if(trade_status.equals("TRADE_FINISHED")){
//					//判断该笔订单是否在商户网站中已经做过处理
//					//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
//					//如果有做过处理，不执行商户的业务程序
//						
//					//注意：
//					//退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
//				}else if (trade_status.equals("TRADE_SUCCESS")){
//					//判断该笔订单是否在商户网站中已经做过处理
//					//如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
//					//如果有做过处理，不执行商户的业务程序
//					
//					//注意：
//					//付款完成后，支付宝系统发送该交易状态通知
//					//查看订单是否已
//					
//					Tbdd01 tbdd01N = new Tbdd01();
//					tbdd01N.setDd0101(tbdd01.getDd0101());
//					tbdd01N.setDd0106(1d);//已付款
//					tbdd01Service.updateById(tbdd01N);
//					
//					//检验支付信息是否存在
//					EntityWrapper<Tbdd02> wrapper1 = new EntityWrapper<Tbdd02>();
//					wrapper1.where("DD0202={0} AND DD0205 = 0", tbdd01.getDd0101());
//					int num = tbdd02Service.selectCount(wrapper1);
//					if(num == 0) {
//						Tbdd02 tbdd02 = new Tbdd02();
//						tbdd02.setDd0202(tbdd01.getDd0101());
//						tbdd02.setDd0203(tbdd01.getDd0103());
//						tbdd02.setDd0204(total_amount);
//						tbdd02.setDd0205(0d);
//						tbdd02Service.insert(tbdd02);
//						
//						//将购买的课程放入我的课程中
//						tbdd01Service.addCourse(tbdd01.getDd0101());
//					}
//					
//				}
//				
//				out.write("success".getBytes());
//			}else {
//				out.write("fail".getBytes());
//			}
//		}else {//验证失败
//			out.write("fail".getBytes());
//		
//			//调试用，写文本函数记录程序运行情况是否正常
//			//String sWord = AlipaySignature.getSignCheckContentV1(params);
//			//AlipayConfig.logResult(sWord);
//		}
//		 out.flush();
//         out.close();
//	}
//	
//	/* 实际验证过程建议商户务必添加以下校验：
//	1、需要验证该通知数据中的out_trade_no是否为商户系统中创建的订单号，
//	2、判断total_amount是否确实为该订单的实际金额（即商户订单创建时的金额），
//	3、校验通知中的seller_id（或者seller_email) 是否为out_trade_no这笔单据的对应的操作方（有的时候，一个商户可能有多个seller_id/seller_email）
//	4、验证app_id是否为该商户本身。
//	*/
//	public boolean checkOrder(String out_trade_no,double total_amount,String seller_id,String app_id,Tbdd01 tbdd01) {
//		if(null == tbdd01) {
//			LOGGER.error("-----------支付宝回调失败,订单数据不存在----------订单号："+out_trade_no);
//			return false;
//		}
//		
//		//检查订单价格是否正确
//		if(tbdd01.getDd0107() != total_amount) {
//			LOGGER.error("-----------支付宝回调失败,订单价格与返回的价格不匹配----------订单号："+out_trade_no);
//			return false;
//		}
//		
//		//检验seller_id
//		if(!StringUtils.equals(seller_id, alipayConfig.getPid())) {
//			LOGGER.error("-----------支付宝回调失败,卖家ID不匹配----------订单号："+out_trade_no);
//			return false;
//		}
//		
//		//验证app_id是否为该商户本身
//		if(!StringUtils.equals(app_id, alipayConfig.getAppid())) {
//			LOGGER.error("-----------支付宝回调失败,app_id不匹配----------订单号："+out_trade_no);
//			return false;
//		}
//		
//		return true;
//		
//	}
	
	
	/**
	 * 我的订单
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("serial")
	@RequestMapping("/myorderquery")
	public ResultEntity MyOrderQuery(Req req)throws Exception {
		ResultEntity result = new ResultEntity();
		try {
			IPage<Tbdd01> page = new IPage<Tbdd01>(req.getCurrentPage(),req.getPageSize()){};
			//入参
			EntityWrapper<Tbdd01> wrapper = new EntityWrapper<Tbdd01>();
			wrapper.isWhere(true);
			wrapper.where("B.GWC0105 = 0 AND A.DD0102={0}", req.getUserId());
			String dd0106 = req.getString("dd0106");
			if(StringUtils.isNotBlank(dd0106)) {
				wrapper.where("A.DD0106={0}", dd0106);
			}
			wrapper.where("B.GWC0107 = 0");
			wrapper.orderBy("A.DD0105 DESC");
			IPage<Tbdd01> dcwj02Page = (IPage<Tbdd01>)tbdd01Service.selectPage(page,wrapper);
			result.setData(dcwj02Page);
			
		}catch(Exception e) {
			result.setErrorMsg("获取我的订单数据失败！");
			LOGGER.error("获取我的订单数据失败！",e);
		}
		return result;
	}
	
	/**
	 * 获取全部订单、待付款、已付款、已失效的数量以及购物车数量
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/myordercountquery")
	public ResultEntity MyOrderCountQuery(Req req)throws Exception {
		ResultEntity result = new ResultEntity();
		try {
			//购物车数量
			int cartCount = tbgwc01Service.queryShoppingCartCount(req.getUserId());
			//获取全部订单、待付款、已付款、已失效的数量 
			Map<String, Integer> tbdd01Map = tbdd01Service.myOrderCountQuery(req.getUserId());
			tbdd01Map.put("cartNum", cartCount);
			result.setData(tbdd01Map);
		}catch(Exception e) {
			result.setErrorMsg("获取数据失败！");
			LOGGER.error("获取全部订单、待付款、已付款、已失效的数量以及购物车数量失败！",e);
		}
		return result;
	}
	
	/**
	 * 取消订单
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/cancleorder")
	@Transactional
	public ResultEntity CancleOrder(Req req)throws Exception {
		ResultEntity result = new ResultEntity();
		try {
			//购物车数量
			Tbdd01 tbdd01 = new Tbdd01();
			tbdd01.setDd0101(req.getString("dd0101"));
			tbdd01.setDd0102(req.getUserId());
			tbdd01.setDd0106(ConstantOrder.orderStatus.ORDER_STATUS_2);
			boolean flag = tbdd01Service.updateById(tbdd01);
			if(flag) {
				//根据订单id获取下发卡号表id
				EntityWrapper<Tbyhqgl08> wrapper = new EntityWrapper<Tbyhqgl08>();
				wrapper.where("YHQGL0803={0}", req.getString("dd0101"));
				List<Tbyhqgl08> tbyhqgl08List = tbyhqgl08Service.selectList(wrapper);
				List<Tbyhqgl07> tbyhqgl07List = new ArrayList<Tbyhqgl07>();
				for(Tbyhqgl08 tbyhqgl08:tbyhqgl08List) {
					Tbyhqgl07 tbyhqgl07 = new Tbyhqgl07();
					tbyhqgl07.setYhqgl0701(tbyhqgl08.getYhqgl0802());
					tbyhqgl07.setYhqgl0710(0D);
					tbyhqgl07List.add(tbyhqgl07);
				}
				//取消订单时删除商品对应的优惠券
				tbyhqgl08Service.delete(wrapper);
				if(tbyhqgl07List.size() > 0) {
					tbyhqgl07Service.updateBatchById(tbyhqgl07List);
				}
			}
			
		}catch(Exception e) {
			result.setErrorMsg("取消订单失败！");
			LOGGER.error("取消订单失败！",e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return result;
	}
	
}

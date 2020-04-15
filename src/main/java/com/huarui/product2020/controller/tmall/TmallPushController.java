package com.huarui.product2020.controller.tmall;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.huarui.common.ConstantOrder;
import com.huarui.common.utils.RedisUtil;
import com.huarui.common.utils.ThreadUtils;
import com.huarui.common.web.BaseController;
import com.huarui.product2020.entity.*;
import com.huarui.product2020.service.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/huarui/tmall")
@Transactional
public class TmallPushController extends BaseController {
	private final static Logger LOGGER = LoggerFactory.getLogger(com.huarui.product2020.controller.tmall.TmallPushController.class);
	
	@Autowired
	private ITbzdfh01Service tbzdfh01Service;
	
	@Autowired
	private IHrswTUserService hrswTUserService;
	
	@Autowired
	private ITbzdfh02Service tbzdfh02Service;
	
	@Autowired
	private RedisUtil redisUtil;
	
	@Autowired
	private ITbgwc01Service tbgwc01Service;
	
	@Autowired
	private ITbgwc02Service tbgwc02Service;
	
	@Autowired
	private ITbcmdy06Service tbcmdy06Service;
	
	@Autowired
	private ITbdd01Service tbdd01Service;
	
	@Autowired
	private ITbdd02Service tbdd02Service;
	
	@Autowired
	private ITbzdfh03Service tbzdfh03Service;
	
	@Autowired
	private ITbzdfh04Service tbzdfh04Service;
	
	
	/**
	 * 天猫发货回调地址
	 * @throws IOException
	 */
	@RequestMapping("/autodelivery")
	public void automaticDelivery(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//获取推送参数
		LOGGER.info("--------------自动发货开始----------------");
		//	时间戳
		int timestamp = NumberUtils.toInt(Objects.toString(request.getParameter("timestamp")));
		//  推送类型
		int aopic = NumberUtils.toInt(Objects.toString(request.getParameter("aopic")));
		//  签名
		String sign = Objects.toString(request.getParameter("sign"));
		// 交易信息
		String json = Objects.toString(request.getParameter("json"));
		
		/***测试**/
		//sign="C09E772FE97A62B602DAB5840349F2EABB";
		//json = "{\"BuyerArea\":\"移动\",\"Platform\":\"TAOBAO\",\"PlatformUserId\":\"3089584892\",\"ReceiverName\":\"潘磊\",\"ReceiverMobile\":\"15801182646\",\"ReceiverPhone\":null,\"ReceiverAddress\":\"电子城街道融侨馨苑东区3号楼4单元\",\"ExtendedFields\":{\"ReceiverTown\":\"电子城街道\",\"ReceiverCity\":\"西安市\",\"ReceiverDistrict\":\"雁塔区\",\"ReceiverState\":\"陕西省\"},\"Tid\":911118114722863887,\"Status\":\"WAIT_SELLER_SEND_GOODS\",\"SellerNick\":\"药师在线旗舰店\",\"BuyerNick\":\"潘磊琰\",\"Type\":null,\"BuyerMessage\":\"admin\",\"Price\":\"1.00\",\"Num\":1,\"TotalFee\":\"1.00\",\"Payment\":\"1.00\",\"PayTime\":null,\"PicPath\":\"https://img.alicdn.com/bao/uploaded/i4/3089584892/O1CN01s1cHaw1m0a8xmgTKh_!!0-item_pic.jpg\",\"PostFee\":\"0.00\",\"Created\":\"2020-03-26 22:08:48\",\"TradeFrom\":\"TAOBAO\",\"Orders\":[{\"Oid\":911118114722863887,\"NumIid\":613990636089,\"OuterIid\":null,\"OuterSkuId\":null,\"Title\":\"新系统测试\",\"Price\":\"1.00\",\"Num\":1,\"TotalFee\":\"1.00\",\"Payment\":\"1.00\",\"PicPath\":\"https://img.alicdn.com/bao/uploaded/i4/3089584892/O1CN01s1cHaw1m0a8xmgTKh_!!0-item_pic.jpg\",\"SkuId\":\"4500233799581\",\"SkuPropertiesName\":\"付款方式:中药;类型:套包\",\"DivideOrderFee\":null,\"PartMjzDiscount\":null}],\"SellerMemo\":null,\"SellerFlag\":0,\"CreditCardFee\":null}";
		/***测试**/
		
		
		//签名和交易信息为空，不做处理
		if(StringUtils.isBlank(sign) || StringUtils.isBlank(json)) {
			LOGGER.info("-------签名或交易信息为空----------签名:{}---交易信息:{}",sign,json);
			return;
		}
		
		//获取签名
		String appSecretSign =getAppSecretSign(json,timestamp);
		
		/***测试**/
		//aopic = 2;
		//appSecretSign = "C09E772FE97A62B602DAB5840349F2EABB";
		/***测试**/
		
		
		//获取订单id
		JSONObject json1 = JSON.parseObject(json);
		String orderId = json1.getString("Tid");

		//记录日志
		String zdfh0101 = saveLog(timestamp,aopic,sign,json,appSecretSign,orderId);
		
		if(StringUtils.isBlank(appSecretSign)) {
			LOGGER.info("-------参数签名失败----------");
			updateLog(zdfh0101, ConstantOrder.autoDelivery.LOG_TYPE_2,"参数签名失败");
			return;
		}
		
		//验证签名
		if(!checkSign(sign,appSecretSign)) {
			LOGGER.info("-------验证签名失败-----签名：{},参数签名：{}-----",sign,appSecretSign);
			updateLog(zdfh0101, ConstantOrder.autoDelivery.LOG_TYPE_2,"验证签名失败");
			return;
		}
		
		//校验订单是否存在，为了避免消息重复推送
		if(checkOrder(orderId) > 0) {
			LOGGER.info("-------消息重复推送，订单已处理----------");
			updateLog(zdfh0101, ConstantOrder.autoDelivery.LOG_TYPE_2,"消息重复推送，订单已处理");
			return;
		}
		
		
		JSONObject jsonReturn = new JSONObject();
		JSONObject jsonDoMemoUpdate = new JSONObject();
		jsonDoMemoUpdate.put("Flag", 2);
		jsonDoMemoUpdate.put("Memo", "");//用来备注发送的学习卡
		jsonReturn.put("DoDummySend", false);
		jsonReturn.put("AliwwMsg", "药师在线旗舰店感谢您的购买");
		response.setCharacterEncoding("utf-8");       
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		int zdfh0405 = 1;
		try{
		//查询配置是否自动发货
			if(ConstantOrder.autoDelivery.TMALL_AUTOMATIC_DELIVERY) {
				String aliwwMsg = "";
				String[] arrGet = startClassOrIssueCard(json);
				String allPushed = arrGet[1];
				aliwwMsg = arrGet[0];
				if("true".equals(allPushed)){
					jsonReturn.put("DoDummySend", true);
				}
				String type = arrGet[2];
				if("course".equals(type)){
					jsonReturn.put("AliwwMsg", "您购买的课程已经开通，请登录药师在线官网学习。");
					zdfh0405 = 0;
				}else{
					jsonReturn.put("AliwwMsg", aliwwMsg);
				}
				jsonDoMemoUpdate.put("Memo", aliwwMsg);//用来备注发送的学习卡
			}
			jsonReturn.put("DoMemoUpdate", jsonDoMemoUpdate);
			String strReturn = jsonReturn.toString();
			saveReturnLog(appSecretSign, strReturn,orderId,zdfh0405);//保存返回信息
			updateLog(zdfh0101, ConstantOrder.autoDelivery.LOG_TYPE_1,"处理成功");//修改状态
			out.print(strReturn);
		} catch (Exception e) {
			LOGGER.error("-------自动发货异常----------",e);
			updateLog(zdfh0101, ConstantOrder.autoDelivery.LOG_TYPE_2,"异常");
			jsonDoMemoUpdate.put("Memo", "自动开课失败，请联系客服。");//用来备注发送的学习卡
			jsonReturn.put("DoMemoUpdate", jsonDoMemoUpdate);
			jsonReturn.put("AliwwMsg", "自动开课失败，请联系客服。");
			out.print(jsonReturn.toJSONString());
		}finally {
			out.close();
		}
		LOGGER.info("--------------自动发货结束----------------");
		
	}
	
	
	/**
	 * 根据入参获取签名
	 * @return
	 */
	@SuppressWarnings("static-access")
	private String getAppSecretSign(String json, int timestamp) {
		StringBuilder appSecretSign = new StringBuilder();
		appSecretSign.append(ConstantOrder.autoDelivery.APP_SECRET).append("json").append(json.replace("\\", ""));
		appSecretSign.append("timestamp").append(timestamp).append(ConstantOrder.autoDelivery.APP_SECRET);
		try {
			return ThreadUtils.getRTex().byte2hex(ThreadUtils.getRTex().encryptMD5(appSecretSign.toString()));
		} catch (NoSuchAlgorithmException e) {
			LOGGER.error("getAppSecretSign->参数签名失败",e);
			return "";
		} catch (UnsupportedEncodingException e) {
			LOGGER.error("getAppSecretSign->参数签名失败",e);
			return "";
		}
	}
	private boolean checkSign(String sign, String appSecretSign) {
		
		return StringUtils.equalsIgnoreCase(sign, appSecretSign);
	}

	//保存日志
	private String saveLog(int timestamp, int aopic, String sign, String json, String appSecretSign, String orderId) {
		Tbzdfh01 tbzdfh01 = new Tbzdfh01();
		tbzdfh01.setZdfh0102((double) timestamp);
		tbzdfh01.setZdfh0103((double)aopic);
		tbzdfh01.setZdfh0104(sign);
		tbzdfh01.setZdfh0105(json);
		tbzdfh01.setZdfh0106(appSecretSign);
		tbzdfh01.setZdfh0107(new Date());
		tbzdfh01.setZdfh0108(ConstantOrder.autoDelivery.LOG_TYPE_0);
		tbzdfh01.setZdfh0109(orderId);
		tbzdfh01Service.insert(tbzdfh01);
		return tbzdfh01.getZdfh0101();
	}
	
	private void updateLog(String zdfh0101, double zdfh0108, String zdfh0110) {
		Tbzdfh01 tbzdfh01 = new Tbzdfh01();
		tbzdfh01.setZdfh0101(zdfh0101);
		tbzdfh01.setZdfh0108(zdfh0108);
		tbzdfh01.setZdfh0110(zdfh0110);
		tbzdfh01Service.updateById(tbzdfh01);
	}
	
	/**
	 * 校验订单是否存在，为了避免消息重复推送
	 */
	private int checkOrder(String orderId) {
		EntityWrapper<Tbzdfh01> tbzdfh01Wrapper = new EntityWrapper<Tbzdfh01>();
		tbzdfh01Wrapper.where("ZDFH0109={0}", orderId).where("ZDFH0108=1");
		return tbzdfh01Service.selectCount(tbzdfh01Wrapper);
	}
	
	/**
	 * 根据备注确认开课或发卡
	 */
	private String[] startClassOrIssueCard(String json) {
		String[] arrReturn = new String[3];
		JSONObject json1 = JSON.parseObject(json);
		String buyerMessage = json1.getString("BuyerMessage");
		String user001 = null;
		if(StringUtils.isNotBlank(buyerMessage)) {
			user001 = checkUsername(buyerMessage);
		}
		
		if(StringUtils.isNotBlank(user001)) {//本系统用户
			//开课
			arrReturn = startClass(json,user001);
		}else {
			//天猫自动发卡
			arrReturn = issueCard(json);
		}
		
		
		return arrReturn;
	}
	
	/**
	 * 根据备注验证是否系统用户
	 * 返回用户id
	 */
	private String checkUsername(String buyerMessage) {
		String user001 = null;
		EntityWrapper<HrswTUser> userWrapper = new EntityWrapper<HrswTUser>();
		userWrapper.where("USER004={0}", buyerMessage).where("USER017=1");
		HrswTUser hrswTUser = hrswTUserService.selectOne(userWrapper);
		if(null != hrswTUser) {
			user001 = hrswTUser.getUser001();
		}
		return user001;
	}
	
	private String[] startClass(String json, String user001){
		String[] arrReturn = parsingJsonData(json,user001,0);
		return arrReturn;
	}
	
	/**
	 * 解析天猫推送数据
	 * tmallType 0:自动开课 1：自动发卡
	 */
	private String[] parsingJsonData(String json, String user001, int tmallType) {
		String[] arrReturn = new String[3];
		String allPushed = "true";
		JSONObject json1 = JSON.parseObject(json);
		//商品总价格
		double totalFee = json1.getDoubleValue("TotalFee");
		//实付总价格
		double payment = json1.getDoubleValue("Payment");
		//天猫订单号
		String orederId = json1.getString("Tid");
		
		JSONArray array = JSON.parseArray(json1.getString("Orders"));
		String strReturn = null;
		JSONArray jsonArray = new JSONArray();
		for (int i = 0; i < array.size(); i++) {
			JSONObject jsonOrder = array.getJSONObject(i);
			String skuPropertiesName = jsonOrder.getString("SkuPropertiesName");
			String title = jsonOrder.getString("Title");
			double price = jsonOrder.getDoubleValue("Price");//单商品价格
			double childPayment = jsonOrder.getDoubleValue("Payment");//多单品实付金额
			int num = jsonOrder.getIntValue("Num"); //数量 
			childPayment = childPayment/num; //单商品实付金额
			
			//获取商品id
			EntityWrapper<Tbzdfh02> tbzdfh02Wrapper = new EntityWrapper<Tbzdfh02>();
			tbzdfh02Wrapper.like(true,"ZDFH0202", title);
			tbzdfh02Wrapper.like("ZDFH0203", skuPropertiesName);
			Tbzdfh02 tbzdfh02 = tbzdfh02Service.selectOne(tbzdfh02Wrapper);
			if(null != tbzdfh02) {
				//获取商品id
				String zdfh0204 = tbzdfh02.getZdfh0204();
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("price", price);
				jsonObject.put("num", num);
				jsonObject.put("zdfh0204", zdfh0204);
				jsonObject.put("type", tbzdfh02.getZdfh0205());//0:套包 1：单商品
				jsonObject.put("childPayment", childPayment);
				jsonArray.add(jsonObject);
			}else {
				allPushed = "false";
			}
		}
		
		if(jsonArray.size() > 0) {
			if(tmallType == 0) {//自动开课
				strReturn = generateOrder(jsonArray,user001,totalFee,payment);
				arrReturn[2] = "course";
			}else {//自动发卡
				strReturn = createCard(jsonArray,orederId);
				arrReturn[2] = "card";
			}
			
		}
		arrReturn[0] = strReturn;
		arrReturn[1] = allPushed;
		return arrReturn;
	}
	
	/**
	 * 生成订单号
	 * @return
	 */
	private String generateOrder(JSONArray jsonArray, String user001, double totalFee, double payment) {
		//添加购物车
		Date date = new Date();
		Tbgwc01 tbgwc01 = new Tbgwc01();
		tbgwc01.setGwc0102(user001);
		tbgwc01.setGwc0103(date);
		tbgwc01.setGwc0105(0D);
		tbgwc01.setGwc0107(0D);
		tbgwc01Service.insert(tbgwc01);
		
		//订单id
		String orderId = ThreadUtils.getRTex().getUUID();
		List<Tbgwc02> tbGWC02List = new ArrayList<Tbgwc02>();
		for(int i=0;i<jsonArray.size();i++) {
			JSONObject jsObject = jsonArray.getJSONObject(i);
			//根据商品id获取商品信息
			String zdfh0204 = jsObject.getString("zdfh0204");
			//购买类型 0:套包 1:单商品
			int type = jsObject.getIntValue("type");
			Map<String, String> tbcmdy06Map = tbcmdy06Service.getCommodityById(zdfh0204,type);
			String cmdy0301 = null; //商品包id
			if(null != tbcmdy06Map) {
				cmdy0301 = tbcmdy06Map.get("cmdy0301");
			}
			//购物车添加商品
			Tbgwc02 tbgwc02 = new Tbgwc02();
			tbgwc02.setGwc0202(cmdy0301);
			if(type == ConstantOrder.autoDelivery.COMMODITY_TYPE_0) {
				tbgwc02.setGwc0203(zdfh0204);
			}else {
				tbgwc02.setGwc0204(zdfh0204);
			}
			tbgwc02.setGwc0205(jsObject.getDouble("price"));
			tbgwc02.setGwc0206(jsObject.getDouble("num"));
			tbgwc02.setGwc0207(date);
			tbgwc02.setGwc0208(tbgwc01.getGwc0101());
			tbgwc02.setGwc0209(jsObject.getDouble("childPayment"));
			tbgwc02.setGwc0210(jsObject.getDouble("price"));
			tbgwc02.setGwc0212(orderId);
			tbGWC02List.add(tbgwc02);
		}
		
		String orderNo = null;
		if(tbGWC02List.size() > 0) {
			tbgwc02Service.insertBatch(tbGWC02List);
			orderNo= generateOrder();
			Tbdd01 tbDD01 = new Tbdd01();
			tbDD01.setDd0101(orderId);
			tbDD01.setDd0102(user001);
			tbDD01.setDd0103(tbgwc01.getGwc0101());
			tbDD01.setDd0104(orderNo);
			tbDD01.setDd0105(date);
			tbDD01.setDd0106(1D);
			tbDD01.setDd0107(totalFee);
			tbDD01.setDd0110(payment);
			tbDD01.setDd0111(payment);
			tbdd01Service.insert(tbDD01);
			
			Tbdd02 tbDD02 = new Tbdd02();
			tbDD02.setDd0202(tbDD01.getDd0101());
			tbDD02.setDd0203(tbgwc01.getGwc0101());
			tbDD02.setDd0204(payment);
			tbDD02.setDd0205(4D);
			tbDD02.setDd0206(date);
			tbdd02Service.insert(tbDD02);
			
			//将购买的课程放入我的课程中
			tbdd01Service.addCourse(tbDD01.getDd0101());
			
			//清除学员课程缓存
			redisUtil.removePattern("coursePackageList_"+user001+"*");
			redisUtil.removePattern("userProgressCourse_"+user001);
		}
		
		return orderNo;
	}
	
	/**
	 * 生成订单
	 */
	private String generateOrder() {
		DateFormat d = new SimpleDateFormat("yyyyMMdd");
		String time = d.format(new Date());
		DecimalFormat df = new DecimalFormat("000000");
		long num = redisUtil.incr("order"+ time, 24);
    	String orderNum = time+df.format(num);
    	return orderNum;
	}
	
	
	
	/**
	 * 天猫自动发卡
	 */
	private String[] issueCard(String json) {
		String[] arrReturn = parsingJsonData(json,"",1);
		return arrReturn;
	}
	
	public String createCard(JSONArray jsonArray, String orederId){
		List<Tbzdfh03> tbzdfh03List = new ArrayList<Tbzdfh03>();
		StringBuilder cardAndPwd = new StringBuilder();
		for(int i=0;i<jsonArray.size();i++) {
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			//获取商品数量
			int num = jsonObject.getIntValue("num");
			//获取商品价格
			double price = jsonObject.getDoubleValue("price");
			//实付金额
			double childPayment = jsonObject.getDoubleValue("childPayment");
			//获取商品类型 0：单商品 1：套包 购买
			int type = jsonObject.getIntValue("type");
			//商品id
			String zdfh0204 = jsonObject.getString("zdfh0204");
			
			//生成对应的卡号密码
			for(int j=0;j<num;j++) {
				Tbzdfh03 tbzdfh03 = new Tbzdfh03();
				tbzdfh03.setZdfh0302(ConstantOrder.autoDelivery.CARD_TYPE_0);
				tbzdfh03.setZdfh0303(price);
				tbzdfh03.setZdfh0304(childPayment);
				if(type == ConstantOrder.autoDelivery.COMMODITY_TYPE_0) {//套包
					tbzdfh03.setZdfh0305(zdfh0204);
				}else {
					tbzdfh03.setZdfh0306(zdfh0204);
				}
				tbzdfh03.setZdfh0307(ConstantOrder.autoDelivery.CARD_NODE);
				tbzdfh03.setZdfh0308(new Date());
				tbzdfh03.setZdfh0311(orederId);
				
				String[] cardAndPwdStr = generateCardAndPwd();
				tbzdfh03.setZdfh0312(cardAndPwdStr[0]);
				tbzdfh03.setZdfh0313(cardAndPwdStr[1]);
				
				cardAndPwd.append("卡号：").append(cardAndPwdStr[0]);
				cardAndPwd.append("\t密码：").append(cardAndPwdStr[1]).append(";");
				tbzdfh03List.add(tbzdfh03);
			}
			
		}
		
		if(tbzdfh03List.size() > 0) {
			tbzdfh03Service.insertBatch(tbzdfh03List);
		}
		
		String cardAndPwdStr = null;
		if(cardAndPwd.length() > 0) {
			cardAndPwdStr = StringUtils.substringBeforeLast(cardAndPwd.toString(), ";");
		}
		return cardAndPwdStr;
	}
	
	private String[] generateCardAndPwd() {
		String[] cardAndPwd = new String[2];
		DateFormat df = new SimpleDateFormat("yy"); //只是一年，有2位数
		String year = df.format(Calendar.getInstance().getTime());
		
		
		StringBuilder cardNum = new StringBuilder();
		//卡号
		cardNum.append(year).append("TMk").append(ThreadUtils.getRTex().getRandomStr(7));
		cardAndPwd[0] = cardNum.toString();
				
		//密码
		cardAndPwd[1] = ThreadUtils.getRTex().getRandomNum(6);
		return cardAndPwd;
	}
	
	/**
	 * 添加返回日志信息
	 * @param appSecretSign
	 * @param strReturn
	 * @param orderId
	 */
	private void saveReturnLog(String appSecretSign, String strReturn, String orderId, int zdfh0405) {
		Tbzdfh04 tbzdfh04 = new Tbzdfh04();
		tbzdfh04.setZdfh0402(appSecretSign);
		tbzdfh04.setZdfh0403(strReturn);
		tbzdfh04.setZdfh0404(orderId);
		tbzdfh04.setZdfh0405(zdfh0405);
		tbzdfh04Service.insert(tbzdfh04);
	}
	
}







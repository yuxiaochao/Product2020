package com.huarui.product2020.controller.electiveCenter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.huarui.common.Req;
import com.huarui.common.utils.CaptchaUtil;
import com.huarui.common.utils.RedisUtil;
import com.huarui.common.utils.VerifyCodeUtils;
import com.huarui.common.web.BaseController;
import com.huarui.product2020.entity.*;
import com.huarui.product2020.service.*;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/huarui/center")
public class ElectiveCenterController extends BaseController {

	private final static Logger LOGGER = LoggerFactory.getLogger(ElectiveCenterController.class);

	@Autowired
	private ITbcmdy01Service tbcmdy01Service;

	@Autowired
	private ITbcmdy03Service tbcmdy03Service;

	@Autowired
	private ITbgwc01Service tbgwc01Service;

	@Autowired
	private ITbgwc02Service tbgwc02Service;

	@Autowired
	private ITbcmdy10Service tbcmdy10Service;
	
	@Autowired
	private ITbcmdy11Service tbcmdy11Service;

	@Autowired
	private ITbcmdy06Service itbcmdy06Service;

	@Autowired
	private ITbyhqgl07Service tbyhqgl07Service;

	@Autowired
	private ITbyhqgl01Service tbyhqgl01Service;

	@Autowired
	private RedisUtil redisUtil;

	final ThreadLocal<List<Tbcmdy01>> nodesLocal = new ThreadLocal<List<Tbcmdy01>>() {
		public List<Tbcmdy01> initialValue() {
			return new LinkedList<Tbcmdy01>();
		}
	};

	@RequestMapping("/list")
	public ResultEntity list(Req req) throws Exception {

		ResultEntity result = new ResultEntity();
		try {
			// 获取专业字典所有数据
			EntityWrapper<Tbcmdy01> wrapper = new EntityWrapper<Tbcmdy01>();
			wrapper.orderBy("CMDY0106");
			List<Tbcmdy01> tbcmdy01All = tbcmdy01Service.selectList(wrapper);
			nodesLocal.set(tbcmdy01All);
			List<Tbcmdy01> tbcmdy01List = getNodes();
			result.setData(tbcmdy01List);
		} catch (Exception e) {
			result.setErrorMsg("数据获取失败");
			LOGGER.error("数据获取失败", e);
		} finally {
			nodesLocal.remove();
		}
		return result;
	}

	public List<Tbcmdy01> getNodes() {
		List<Tbcmdy01> nodes = getTopLevelNodes();
		nodes.forEach(o -> {
			getChildren(o, o);
		});
		return nodes;
	}

	public void getChildren(Tbcmdy01 node, Tbcmdy01 node1) {
		List<Tbcmdy01> child = nodesLocal.get().stream().filter(o -> o.getCmdy0108().equals(node.getCmdy0101()))
				.collect(Collectors.toList());
		if (child != null && child.size() > 0) {
			child.stream().forEach(o -> {
				getChildren(o, node1);
			});
		} else {
			// 获取商品上架数据
			List<Tbcmdy03> tbcmdy03List = tbcmdy03Service.queryCmdy03List(node.getCmdy0101());
			node.setTbcmdy03List(tbcmdy03List);
			setChildren(node, node1);
		}
	}

	public void setChildren(Tbcmdy01 node, Tbcmdy01 node1) {
		if (null != node1.getChilds()) {
			node1.getChilds().add(JSON.parseObject(JSON.toJSONString(node), Tbcmdy01.class));
		} else {
			List<Tbcmdy01> childs = new LinkedList<Tbcmdy01>();
			childs.add(JSON.parseObject(JSON.toJSONString(node), Tbcmdy01.class));
			node1.setChilds(childs);
		}
	}

	public List<Tbcmdy01> getTopLevelNodes() {
		return nodesLocal.get().stream().filter(o -> o.getCmdy0108().equals("-1")).collect(Collectors.toList());
	}

	/**
	 * 根据上架商品ID获取商品数据
	 * 
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/courseInfo")
	public ResultEntity courseInfo(Req req) throws Exception {
		ResultEntity result = new ResultEntity();
		try {
			String cmdy0301 = req.getString("cmdy0301");
			if (StringUtils.isBlank(cmdy0301)) {
				result.setErrorMsg("未选择分类");
				LOGGER.info("上架商品ID为空");
				return result;
			}
			// 获取商品上架数据
			Tbcmdy03 tbcmdy03 = tbcmdy03Service.queryCmdy03Info(cmdy0301);
			result.setData(tbcmdy03);
		} catch (Exception e) {
			result.setErrorMsg("数据获取失败");
			LOGGER.error("数据获取失败", e);
		}
		return result;
	}

	/**
	 * 获取用户购物车数据
	 * 
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/shoppingCart")
	public ResultEntity shoppingCart(Req req) throws Exception {
		ResultEntity result = new ResultEntity();
		try {
			// 获取用户购物车数据
			List<Map<String, Object>> cartList = tbgwc02Service.queryCartListByUserId(req.getUserId());
			// 获取所有商品的总价格
			DecimalFormat decimalFormat = new DecimalFormat("0.00#");
			BigDecimal totalPrice = new BigDecimal(0d);//合计
			BigDecimal actuallyPaidPrice = new BigDecimal(0d); //实付金额
			
			for (Map<String, Object> cartMap : cartList) {
				BigDecimal cmdy0605 = new BigDecimal(
						NumberUtils.toDouble(ObjectUtils.toString(cartMap.get("totalprice"), "0")));
				BigDecimal activitySinglePrice = new BigDecimal(
						NumberUtils.toDouble(ObjectUtils.toString(cartMap.get("activityTotalPrice"), "0")));
				totalPrice = totalPrice.add(cmdy0605);
				actuallyPaidPrice = actuallyPaidPrice.add(activitySinglePrice);
			}
			JSONObject res = new JSONObject();
			res.put("cartList", cartList);
			res.put("totalPrice", decimalFormat.format(totalPrice.doubleValue()));
			res.put("actuallyPaidPrice", decimalFormat.format(actuallyPaidPrice.doubleValue()));
			result.setData(res);
		} catch (Exception e) {
			result.setErrorMsg("数据获取失败");
			LOGGER.error("数据获取失败", e);
		}
		return result;
	}

	/**
	 * 获取用户购物车数量
	 */
	@RequestMapping("/cartCount")
	public ResultEntity shoppingCartCount(Req req) throws Exception {
		ResultEntity result = new ResultEntity();
		try {
			// 获取用户购物车数量
			int cartCoun = tbgwc01Service.queryShoppingCartCount(req.getUserId());
			result.setData(cartCoun);
		} catch (Exception e) {
			result.setErrorMsg("数据获取失败");
			LOGGER.error("数据获取失败", e);
		}
		return result;
	}

	/**
	 * 加入购物车
	 * 
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/addCart")
	@Transactional
	public ResultEntity addCart(Req req) throws Exception {
		ResultEntity result = new ResultEntity();
		try {
			String cmdy0301 = req.getString("cmdy0301"); // 基本信息ID
			JSONArray cmdy07 = JSON.parseArray(req.getString("cmdy07"));// 商品与套包关联数据
			boolean selAllSub = req.getBoolean("selAllSub"); // 是否全科
			JSONObject cmdy06 = JSON.parseObject(req.getString("cmdy06")); // 套包数据
			String userId = req.getUserId();
			// 查询购物车ID
			String gwc0101 = tbgwc02Service.queryCartId(userId);
			if (selAllSub) {
				addPackageCart(gwc0101, userId, cmdy0301, cmdy06);
			} else {
				addCommodityCart(gwc0101, userId, cmdy0301, cmdy07);
			}

			// 查询购物车商品数量
			// 获取用户购物车数量
			int cartCoun = tbgwc01Service.queryShoppingCartCount(req.getUserId());
			result.setData(cartCoun);
		} catch (Exception e) {
			result.setErrorMsg("数据获取失败");
			LOGGER.error("数据获取失败", e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return result;
	}

	/**
	 * 套包加入购物车
	 * 
	 * @throws Exception
	 */
	public void addPackageCart(String gwc0101, String userId, String cmdy0301, JSONObject cmdy06) throws Exception {
		if (StringUtils.isBlank(gwc0101)) { // 无购物车
			Tbgwc01 tbgwc01 = new Tbgwc01();
			tbgwc01.setGwc0102(userId);
			tbgwc01.setGwc0103(new Date());
			tbgwc01.setGwc0105(1d);
			tbgwc01Service.insert(tbgwc01);
			addPackageTbgwc02(cmdy0301, tbgwc01.getGwc0101(), cmdy06);

		} else {// 已有购物车
				// 查询购物车是否存在该套包，若存在则不加入购物车则加入
			Map<String, String> paramMap = new HashMap<String, String>();
			paramMap.put("gwc0101", gwc0101);
			paramMap.put("gwc0202", cmdy0301);
			paramMap.put("gwc0203", cmdy06.getString("cmdy0601"));
			List<Tbgwc02> tbgwc02List = tbgwc02Service.queryCartCommodity(paramMap);
			if (null == tbgwc02List || tbgwc02List.size() == 0) {
				addPackageTbgwc02(cmdy0301, gwc0101, cmdy06);
			}
		}
	}

	// 添加套包
	public void addPackageTbgwc02(String cmdy0301, String gwc0101, JSONObject cmdy06) throws Exception {
		// 根据套包id获取套包
		EntityWrapper<Tbcmdy06> wrapper = new EntityWrapper<Tbcmdy06>();
		wrapper.where("CMDY0601={0}", cmdy06.getString("cmdy0601"));
		Tbcmdy06 tbcmdy06 = itbcmdy06Service.selectOne(wrapper);
		if (null == tbcmdy06) {
			throw new Exception("该套包不存在！");
		}
		Tbgwc02 tbgwc02 = new Tbgwc02();
		tbgwc02.setGwc0202(cmdy0301);
		tbgwc02.setGwc0203(cmdy06.getString("cmdy0601"));
		tbgwc02.setGwc0205(tbcmdy06.getCmdy0605());
		tbgwc02.setGwc0206(1d);
		tbgwc02.setGwc0207(new Date());
		tbgwc02.setGwc0208(gwc0101);
		tbgwc02Service.insert(tbgwc02);
	}

	/**
	 * 商品加入购物车
	 * 
	 * @throws Exception
	 */
	public void addCommodityCart(String gwc0101, String userId, String cmdy0301, JSONArray cmdy07Array)
			throws Exception {
		if (StringUtils.isBlank(gwc0101)) { // 无购物车
			Tbgwc01 tbgwc01 = new Tbgwc01();
			tbgwc01.setGwc0102(userId);
			tbgwc01.setGwc0103(new Date());
			tbgwc01.setGwc0105(1d);
			tbgwc01Service.insert(tbgwc01);

			// 获取多个商品，用逗号隔开
			StringBuilder gwc0204s = new StringBuilder();
			for (int i = 0; i < cmdy07Array.size(); i++) {
				JSONObject cmdy07Object = cmdy07Array.getJSONObject(i);
				gwc0204s.append(cmdy07Object.get("cmdy0701")).append(",");
			}

			String gwc0204 = null;
			if (gwc0204s.length() > 0) {
				gwc0204 = gwc0204s.substring(0, gwc0204s.length() - 1);
			}
			addCommodityTbgwc02(cmdy0301, tbgwc01.getGwc0101(), gwc0204);

		} else {// 已有购物车
			handleCommodityData(gwc0101, userId, cmdy0301, cmdy07Array);
		}
	}

	public void handleCommodityData(String gwc0101, String userId, String cmdy0301, JSONArray cmdy07Array)
			throws Exception {
		// 获取多个商品，用逗号隔开
		StringBuilder gwc0204s = new StringBuilder();
		for (int i = 0; i < cmdy07Array.size(); i++) {
			JSONObject cmdy07Object = cmdy07Array.getJSONObject(i);
			gwc0204s.append(cmdy07Object.get("cmdy0701")).append(",");
		}
		// 查询购物车是否存在该套包，若存在则不加入购物车则加入
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("gwc0101", gwc0101);
		paramMap.put("gwc0202", cmdy0301);
		String gwc0204 = "";
		if (gwc0204s.length() > 0) {
			gwc0204 = gwc0204s.substring(0, gwc0204s.length() - 1);
			paramMap.put("gwc0204", gwc0204);
			List<Tbgwc02> tbgwc02List = tbgwc02Service.queryCartCommodity(paramMap);
			if (tbgwc02List.size() > 0) {
				excludeExisCart(tbgwc02List, cmdy0301, gwc0101, cmdy07Array);
			} else {// 购物车不存在，则全部加入购物车
				addCommodityTbgwc02(cmdy0301, gwc0101, gwc0204);
			}
		}
	}

	// 处理已存在购物车的商品，不加入购物车中
	public void excludeExisCart(List<Tbgwc02> tbgwc02List, String cmdy0301, String gwc0101, JSONArray cmdy07Array)
			throws Exception {
		Map<String, Integer> tbgwc0204 = new HashMap<String, Integer>();
		for (Tbgwc02 tbgwc02 : tbgwc02List) {
			tbgwc0204.put(tbgwc02.getGwc0204(), 1);
		}

		StringBuilder gwc0204Sb = new StringBuilder();
		for (Iterator iterator = cmdy07Array.iterator(); iterator.hasNext();) {
			JSONObject cmdy07Object = (JSONObject) iterator.next();
			if (tbgwc0204.containsKey(cmdy07Object.getString("cmdy0701"))) {
				iterator.remove();
			} else {
				gwc0204Sb.append(cmdy07Object.getString("cmdy0701")).append(",");
			}
		}
		String gwc0204s = gwc0204Sb.toString();
		if (gwc0204s.length() > 0) {
			gwc0204s = gwc0204s.substring(0, gwc0204s.length() - 1);
			addCommodityTbgwc02(cmdy0301, gwc0101, gwc0204s);
		}
	}

	public void addCommodityTbgwc02(String cmdy0301, String gwc0101, String gwc0204s) throws Exception {
		if (StringUtils.isBlank(gwc0204s)) {
			throw new Exception("所购买商品不存在！");
		}
		// 根据单商品id获取商品价格
		List<Map<String, String>> commodityPriceList = tbgwc02Service.queryCommodityPrice(gwc0204s);
		List<Tbgwc02> tbgwc02List = new ArrayList<Tbgwc02>();
		for (Map<String, String> map : commodityPriceList) {
			Tbgwc02 tbgwc02 = new Tbgwc02();
			tbgwc02.setGwc0202(cmdy0301);
			tbgwc02.setGwc0204(map.get("cmdy0701"));
			tbgwc02.setGwc0205(NumberUtils.toDouble(Objects.toString(map.get("price"))));
			tbgwc02.setGwc0206(1d);
			tbgwc02.setGwc0207(new Date());
			tbgwc02.setGwc0208(gwc0101);
			tbgwc02List.add(tbgwc02);
		}
		tbgwc02Service.insertBatch(tbgwc02List);
	}

	/**
	 * 根据ID删除购物车数据
	 * 
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteCommodity")
	public ResultEntity deleteCommodity(Req req) throws Exception {
		ResultEntity result = new ResultEntity();
		try {
			String gwc0201 = req.getString("gwc0201"); // 加入商品ID
			tbgwc02Service.deleteById(gwc0201);
		} catch (Exception e) {
			result.setErrorMsg("删除数据失败");
			LOGGER.error("删除购物车数据失败", e);
		}
		return result;
	}

	/**
	 * 根据订单id获取商品列表
	 * 
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/couponList")
	public ResultEntity couponList(Req req) throws Exception {
		ResultEntity result = new ResultEntity();
		String dd0101 = req.getString("dd0101");
		try {
			// 根据订单id获取商品列表
			List<Map<String, String>> courseList = tbgwc02Service.couponList(dd0101);
			result.setData(courseList);
		} catch (Exception e) {
			result.setErrorMsg("数据获取失败");
			LOGGER.error("根据订单id获取优惠券信息失败", e);
		}
		return result;
	}
	
	/**
	 * 根据订单ID获取优惠券信息
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/commoditylist")
    public ResultEntity commodityList(Req req) throws Exception {
        ResultEntity result = new ResultEntity();
        try {
            // 根据订单id获取商品列表
            List<Map<String, String>> courseList = tbgwc02Service.commoditylist(req.getString("dd0101"));
            result.setData(courseList);
        } catch (Exception e) {
            result.setErrorMsg("数据获取失败");
            LOGGER.error("根据订单id获取商品列表失败", e);
        }
        return result;
    }
	

	 /**
     * 相关课程
     * @return
     */
    @RequestMapping("/relatedCourses")
    public ResultEntity relatedCourses(Req req) {
        ResultEntity result = new ResultEntity();
        // 商品ID
        Map parameterMap = req.getParameterMap();
        try {
            // 根据商品ID获取相关课程
            List<Tbcmdy11> list = tbcmdy11Service.findRelatedCourses(parameterMap);
            result.setData(list);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
    
    /**
     * 试听课程
     * @return
     */
    @RequestMapping("/courseAuditions")
    public ResultEntity courseAuditions(Req req) {
        ResultEntity result = new ResultEntity();
        // 商品ID
        String cmdy1002 = req.getString("cmdy1002");
        Map parameterMap = req.getParameterMap();
        try {
            List<Tbcmdy10> list = tbcmdy10Service.findCourseAuditions(parameterMap);
            // 试听课程
            result.setData(list);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
    
    /**
     * 试听课程
     * @return
     */
    @RequestMapping("/courseClassify")
    public ResultEntity courseClassify(Req req) {
        ResultEntity result = new ResultEntity();
        // 商品ID
        String cmdy1002 = req.getString("cmdy1002");
        Map parameterMap = req.getParameterMap();
        try {
            List<Tbcmdy10> list = tbcmdy10Service.findCourseAuditionsClassify(parameterMap);
            result.setData(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

	/**
	 * 优惠券验证码
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/captcha")
	public void createCode(HttpServletRequest request, HttpServletResponse response, Req req) throws IOException {
		try {
			OutputStream outputStream = response.getOutputStream();
			int w = 200, h = 80;
			String code = VerifyCodeUtils.generateVerifyCode(4);
			request.getSession().setAttribute(CaptchaUtil.SESSION_COUPON_CODE_NAME, code);
			VerifyCodeUtils.outputImage(w, h, outputStream, code);
			outputStream.flush();
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据用户获取优惠券
	 */
	@RequestMapping("/queryCouponList")
	public ResultEntity queryCouponList(Req req) {
		ResultEntity result = new ResultEntity();
		try {
			List<Map<String, String>> couponList = tbyhqgl07Service.queryCouponList(req.getUserId());
			result.setData(couponList);
		} catch (Exception e) {
			LOGGER.error("获取商品优惠券失败！", e);
			result.setErrorMsg("获取商品优惠券失败！");
		}

		return result;
	}

	/**
	 * 激活优惠券
	 * 
	 * @return
	 */
	@RequestMapping("/couponActivation")
	public ResultEntity couponActivation(Req req, HttpServletRequest request) {
		ResultEntity result = new ResultEntity();
		try {
			String yhqgl0303 = req.getString("cartNumber"); // 卡号
			String yhqgl0304 = req.getString("passWord"); // 密码
			String couponCode = req.getString("code"); // 验证码

			// 校验验证码
			if(!request.getSession().getAttribute(CaptchaUtil.SESSION_COUPON_CODE_NAME).equals(couponCode)){
				result.setErrorMsg("验证码不正确");
				return result;
			}

			// 根据卡号、密码查询对应的信息
			Map<String, String> yhqgl01Map = tbyhqgl01Service.getCouponByCardAndPwd(yhqgl0303, yhqgl0304);
			if (null == yhqgl01Map) {
				result.setErrorMsg("输入有误，如有误请联系管理员");
				return result;
			}
			String yhqgl0301 = yhqgl01Map.get("yhqgl0301"); // 优惠券卡号id
			String yhqgl0601 = yhqgl01Map.get("yhqgl0601");// 优惠券下发与优惠券关联id

			EntityWrapper<Tbyhqgl07> wrapper = new EntityWrapper<Tbyhqgl07>();
			wrapper.where("YHQGL0702={0} AND YHQGL0703={1}", yhqgl0601,yhqgl0301);
			wrapper.where("YHQGL0704 = 0");
			
			Tbyhqgl07 tbyhqgl07 = new Tbyhqgl07();
			tbyhqgl07.setYhqgl0704(1D);
			tbyhqgl07.setYhqgl0705(req.getUserId());
			tbyhqgl07.setYhqgl0706(new Date());
			tbyhqgl07.setYhqgl0710(0D);
			tbyhqgl07Service.update(tbyhqgl07, wrapper);

			
			List<Map<String, String>> couponList = tbyhqgl07Service.queryCouponList(req.getUserId());
			result.setData(couponList);
		} catch (Exception e) {
			result.setErrorMsg("优惠券激活失败！");
			LOGGER.error("优惠券激活失败", e);
		}
		return result;
	}
	
	/**
	 * 根据商品获取优惠券 
	 */
	@RequestMapping("/queryCoupon")
	public ResultEntity queryCoupon( Req req) {
		ResultEntity result = new ResultEntity();
		try {
			String commodityId = req.getString("commodityId");
			String commodityType = req.getString("commodityType");
			List<Map<String, String>> couponList = tbyhqgl07Service.queryCoupon(commodityId,req.getUserId(),commodityType);
			result.setData(couponList);
		} catch (Exception e) {
			LOGGER.error("获取商品优惠券失败！",e);
			result.setErrorMsg("获取商品优惠券失败！");
		}
		return result;
	}

}

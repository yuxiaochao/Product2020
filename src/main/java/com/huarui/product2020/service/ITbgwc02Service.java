package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.product2020.entity.Tbgwc02;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author panlei
 * @since 2020-02-18
 */
public interface ITbgwc02Service extends IService<Tbgwc02> {
	/**
	 * 选择的商品是否添加在购物车中 
	 */
	public List<Tbgwc02> queryCartCommodity(Map<String, String> paramMap);
	
	/**
	 * 查下购物车id
	 * @param req
	 * @return
	 */
	public String queryCartId(String userId);
	
	/**
	 * 获取用户购物车数据
	 */
	public List<Map<String, Object>> queryCartListByUserId(String userId);
	
	/**
	 * 获取用户购物车以及商品价格 
	 */
	public Map<String, Object> queryCartAndPriceByUserId(String userId);
	
	/**
	 * 根据订单ID获取订单详情
	 */
	public Map<String, Object> queryOrderInfoById(String dd0101, String userId);
	
	/**
	 * 根据订单id获取商品列表 
	 */
	public List<Map<String, String>> commoditylist(String dd0101);
	
	/**
	 * 根据单商品id获取商品价格
	 */
	public List<Map<String, String>> queryCommodityPrice(String gwc0204s);
	
	/**
	 * 根据ID修改加入商品数据
	 */
	public void updateGwc02(List<Tbgwc02> tbgwc02List);

	
	/**
	 * 根据商品ID获取优惠券信息
	 * @param dd0101
	 * @return
	 */
    public List<Map<String, String>> couponList(String dd0101);
}

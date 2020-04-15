package com.huarui.product2020.mapper;

import com.huarui.product2020.entity.Tbgwc02;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author panlei
 * @since 2020-02-18
 */
public interface Tbgwc02Mapper extends BaseMapper<Tbgwc02> {

	/**
	 * 选择的商品是否添加在购物车中 
	 */
	public List<Tbgwc02> queryCartCommodity(Map<String,String> paramMap);
	
	/**
	 * 查下购物车id
	 * @param req
	 * @return
	 */
	public String queryCartId(String userId);
	
	/**
	 * 获取用户购物车数据
	 */
	public List<Map<String,Object>> queryCartListByUserId(String userId);
	
	/**
	 * 获取用户购物车以及商品价格 
	 */
	public Map<String,Object> queryCartAndPriceByUserId(String userId);
	
	/**
	 * 根据订单ID获取订单详情
	 */
	public Map<String, Object> queryOrderInfoById(@Param("dd0101") String dd0101,@Param("userId")String userId);
	
	/**
	 * 根据订单id获取商品列表 
	 */
	public List<Map<String,String>> commoditylist(String dd0101);
	
	/**
	 * 根据单商品id获取商品价格
	 */
	public List<Map<String,String>> queryCommodityPrice(@Param("gwc0204s")String gwc0204s);
	
	/**
	 * 根据ID修改加入商品数据
	 */
	public void updateGwc02(@Param("tbgwc02List")List<Tbgwc02> tbgwc02List);

	/**
	 * 根据订单ID获取优惠券信息
	 * @param dd0101
	 * @return
	 */
    public List<Map<String, String>> couponList(String dd0101);
}
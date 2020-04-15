package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.product2020.entity.Tbgwc02;
import com.huarui.product2020.mapper.Tbgwc02Mapper;
import com.huarui.product2020.service.ITbgwc02Service;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author panlei
 * @since 2020-02-18
 */
@Service
public class Tbgwc02ServiceImpl extends ServiceImpl<Tbgwc02Mapper, Tbgwc02> implements ITbgwc02Service {
	
	/**
	 * 选择的商品是否添加在购物车中 
	 */
	public List<Tbgwc02> queryCartCommodity(Map<String, String> paramMap) {
		return baseMapper.queryCartCommodity(paramMap);
	}
	
	/**
	 * 查下购物车id
	 * @param req
	 * @return
	 */
	public String queryCartId(String userId) {
		return baseMapper.queryCartId(userId);
	}
	
	/**
	 * 获取用户购物车数据
	 */
	public List<Map<String, Object>> queryCartListByUserId(String userId){
		return baseMapper.queryCartListByUserId(userId);
	}
	
	/**
	 * 获取用户购物车以及商品价格 
	 */
	public Map<String, Object> queryCartAndPriceByUserId(String userId){
		return baseMapper.queryCartAndPriceByUserId(userId);
	}

	/**
	 * 根据订单ID获取订单详情
	 */
	public Map<String, Object> queryOrderInfoById(String dd0101, String userId) {
		return baseMapper.queryOrderInfoById(dd0101,userId);
	}
	
	/**
	 * 根据订单id获取商品列表 
	 */
	public List<Map<String, String>> commoditylist(String dd0101){
		return baseMapper.commoditylist(dd0101);
	}
	
	/**
	 * 根据单商品id获取商品价格
	 */
	public List<Map<String, String>> queryCommodityPrice(String gwc0204s){
		return baseMapper.queryCommodityPrice(gwc0204s);
	}
	
	/**
	 * 根据ID修改加入商品数据
	 */
	public void updateGwc02(List<Tbgwc02> tbgwc02List) {
		baseMapper.updateGwc02(tbgwc02List);
	}

    @Override
    public List<Map<String, String>> couponList(String dd0101) {
        return baseMapper.couponList(dd0101);
    }
}

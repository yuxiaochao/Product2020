package com.huarui.product2020.mapper;

import com.huarui.product2020.entity.Tbcmdy06;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author panlei
 * @since 2020-02-15
 */
public interface Tbcmdy06Mapper extends BaseMapper<Tbcmdy06> {

	/**
	 * 根据商品id获取数据(单商品)
	 */
	public Map<String,String> getCommodityById(String zdfh0204);
	
	/**
	 * 根据商品id获取数据(套包)
	 */
	public Map<String,String> getPackageCommodityById(String zdfh0204);
	
}
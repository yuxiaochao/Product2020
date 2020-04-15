package com.huarui.product2020.mapper;

import com.huarui.product2020.entity.Tbdd01;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author panlei
 * @since 2020-02-18
 */
public interface Tbdd01Mapper extends BaseMapper<Tbdd01> {
	
	/**
	 * 获取全部订单、待付款、已付款、已失效的数量 
	 */
	public Map<String,Integer> myOrderCountQuery(String userId);
	
	/**
	 * 将购买的课程放入我的课程中
	 */
	public void addCourse(String dd0101);

}
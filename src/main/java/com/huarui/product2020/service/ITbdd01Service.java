package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.product2020.entity.Tbdd01;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author panlei
 * @since 2020-02-18
 */
public interface ITbdd01Service extends IService<Tbdd01> {
	
	/**
	 * 获取全部订单、待付款、已付款、已失效的数量 
	 */
	public Map<String, Integer> myOrderCountQuery(String userId);
	
	/**
	 * 将购买的课程放入我的课程中
	 */
	public void addCourse(String dd0101);
}

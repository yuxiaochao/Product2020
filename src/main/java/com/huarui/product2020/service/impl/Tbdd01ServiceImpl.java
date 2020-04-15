package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.product2020.entity.Tbdd01;
import com.huarui.product2020.mapper.Tbdd01Mapper;
import com.huarui.product2020.service.ITbdd01Service;
import org.springframework.stereotype.Service;

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
public class Tbdd01ServiceImpl extends ServiceImpl<Tbdd01Mapper, Tbdd01> implements ITbdd01Service {
	
	
	/**
	 * 获取全部订单、待付款、已付款、已失效的数量 
	 */
	public Map<String, Integer> myOrderCountQuery(String userId){
		return baseMapper.myOrderCountQuery(userId);
	}
	
	/**
	 * 将购买的课程放入我的课程中
	 */
	public void addCourse(String dd0101) {
		baseMapper.addCourse(dd0101);
	}
}

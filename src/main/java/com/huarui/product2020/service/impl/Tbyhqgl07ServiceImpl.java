package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.product2020.entity.Tbyhqgl07;
import com.huarui.product2020.mapper.Tbyhqgl07Mapper;
import com.huarui.product2020.service.ITbyhqgl07Service;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author panlei
 * @since 2020-04-07
 */
@Service
public class Tbyhqgl07ServiceImpl extends ServiceImpl<Tbyhqgl07Mapper, Tbyhqgl07> implements ITbyhqgl07Service {

	@Autowired
	private Tbyhqgl07Mapper tbyhqgl07Mapper;
	
	/**
	 * 根据用户id获取用户优惠券
	 */
	public List<Map<String, String>> queryCouponList(String userId){
		return tbyhqgl07Mapper.queryCouponList(userId);
	}
	
	/**
	 * 根据商品、用户获取优惠券
	 */
	public List<Map<String, String>> queryCoupon(String commodityId, String userId, String commodityType){
		if(StringUtils.equals(commodityType, "0")) {
			return tbyhqgl07Mapper.queryPackageCoupon(commodityId,userId,commodityType);
		}else {
			return tbyhqgl07Mapper.queryCommodityCoupon(commodityId,userId,commodityType);
		}
	}
	
	/**
	 *  验证优惠券是否被篡改 
	 */
	public Integer checkCouponCount(List<String> yhqgl0701, String userId) {
		return tbyhqgl07Mapper.checkCouponCount(yhqgl0701,userId); 
	}
	
	/**
	 * 验证优惠券对每个商品是否超过200、套包是否超过700 
	 */
	public Map<String, Object> checkCouponPrice(List<String> couponList, Map<String, String> params){
		//获取商品类型
		String commodityType = params.get("commodityType");
		if(StringUtils.equals(commodityType, "0")) {
			return tbyhqgl07Mapper.checkPackageCouponPrice(couponList,params);
		}else {
			return tbyhqgl07Mapper.checkCommodityCouponPrice(couponList,params);
		}
	}
	
	/**
	 * 获取优惠券总价格 
	 */
	public double queryCouponPrice(List<String> couponIdList) {
		return tbyhqgl07Mapper.queryCouponPrice(couponIdList); 
	}
	
	/**
	 * 更加优惠券下发id更新数据
	 */
	public void updateCoupon(List<String> couponALlList, String userId) {
		tbyhqgl07Mapper.updateCoupon(couponALlList,userId);
	}

	/**
	 * 优惠券激活记录列表
	 */
	@Override
	public List findActivationRecordList(Map<String, Object> param) {
		return tbyhqgl07Mapper.findActivationRecordList(param);
	}

	/**
	 * 优惠券激活
	 * @param entity
	 * @return
	 */
	@Override
	public boolean updateActivation(Tbyhqgl07 entity) {
		boolean boo = false;
		int update = tbyhqgl07Mapper.updateActivation(entity);
		if(0 < update) {
			boo = true;
		}
		return boo;
	}
}

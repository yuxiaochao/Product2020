package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.product2020.entity.Tbyhqgl07;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author panlei
 * @since 2020-04-07
 */
public interface ITbyhqgl07Service extends IService<Tbyhqgl07> {
	
	/**
	 * 根据用户id获取用户优惠券
	 */
	public List<Map<String, String>> queryCouponList(String userId);
	
	/**
	 * 根据商品、用户获取优惠券
	 */
	public List<Map<String, String>> queryCoupon(String commodityId, String userId, String commodityType);
	
	/**
	 *  验证优惠券是否被篡改 
	 */
	public Integer checkCouponCount(List<String> yhqgl0701, String userId);
	
	/**
	 * 验证优惠券对每个商品是否超过200、套包是否超过700 
	 */
	public Map<String, Object> checkCouponPrice(List<String> couponList, Map<String, String> params);
	
	/**
	 * 获取优惠券总价格 
	 */
	public double queryCouponPrice(List<String> couponIdList);
	
	/**
	 * 更加优惠券下发id更新数据
	 */
	public void updateCoupon(List<String> couponALlList, String userId);

	/**
	 * 优惠券激活记录列表
	 */
	public List findActivationRecordList(Map<String, Object> param);

	/**
	 * 优惠券激活
	 * @param entity
	 * @return
	 */
	public boolean updateActivation(Tbyhqgl07 entity);
	
}

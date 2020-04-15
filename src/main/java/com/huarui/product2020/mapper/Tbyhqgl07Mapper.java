package com.huarui.product2020.mapper;

import com.huarui.product2020.entity.Tbyhqgl07;

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
 * @since 2020-04-07
 */
public interface Tbyhqgl07Mapper extends BaseMapper<Tbyhqgl07> {
	
	/**
	 * 根据用户id获取用户优惠券
	 */
	public List<Map<String,String>> queryCouponList(@Param("userId")String userId);
	

	/**
	 * 根据商品、用户获取优惠券(套包）
	 */
	public List<Map<String,String>> queryPackageCoupon(@Param("commodityId")String commodityId,@Param("userId")String userId,@Param("commodityType")String commodityType);
	
	/**
	 * 根据商品、用户获取优惠券（单商品）
	 */
	public List<Map<String,String>> queryCommodityCoupon(@Param("commodityId")String commodityId,@Param("userId")String userId,@Param("commodityType")String commodityType);
	
	/**
	 *  验证优惠券是否被篡改 
	 */
	public Integer checkCouponCount(@Param("yhqgl0701")List<String> yhqgl0701,@Param("userId")String userId);
	
	/**
	 * 验证优惠券对套包是否超过700
	 */
	public Map<String,Object> checkPackageCouponPrice(@Param("couponList")List<String> couponList,@Param("params")Map<String,String> params);
	
	/**
	 *  验证优惠券对单商品是否超过200
	 */
	public Map<String,Object> checkCommodityCouponPrice(@Param("couponList")List<String> couponList,@Param("params")Map<String,String> params);
	
	/**
	 * 获取优惠券总价格 
	 */
	public double queryCouponPrice(@Param("couponIdList")List<String> couponIdList);
	
	/**
	 * 更加优惠券下发id更新数据
	 */
	public void updateCoupon(@Param("couponALlList")List<String> couponALlList,@Param("userId")String userId);

	/**
	 * 优惠券激活记录列表
	 */
	public List findActivationRecordList(Map<String, Object> param);


	/**
	 * 优惠券激活
	 * @param entity
	 * @return
	 */
	public int updateActivation(Tbyhqgl07 entity);

}
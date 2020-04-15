package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.common.ConstantOrder;
import com.huarui.product2020.entity.Tbcmdy06;
import com.huarui.product2020.mapper.Tbcmdy06Mapper;
import com.huarui.product2020.service.ITbcmdy06Service;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author panlei
 * @since 2020-02-15
 */
@Service
public class Tbcmdy06ServiceImpl extends ServiceImpl<Tbcmdy06Mapper, Tbcmdy06> implements ITbcmdy06Service {
	
	/**
	 * 根据商品id获取数据
	 */
	public Map<String, String> getCommodityById(String zdfh0204, int type){
		if(type == ConstantOrder.autoDelivery.COMMODITY_TYPE_0) {//套包
			return baseMapper.getPackageCommodityById(zdfh0204);
		}else { //单商品
			return baseMapper.getCommodityById(zdfh0204);
		}
	}
}

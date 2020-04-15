package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.product2020.entity.Tbcmdy06;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author panlei
 * @since 2020-02-15
 */
public interface ITbcmdy06Service extends IService<Tbcmdy06> {
	
	/**
	 * 根据商品id获取数据
	 */
	public Map<String, String> getCommodityById(String zdfh0204, int type);
	
}

package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.product2020.entity.Tbxxkgl02;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author su
 * @since 2020-03-27
 */
public interface ITbxxkgl02Service extends IService<Tbxxkgl02> {

	/**
	 * 查找学习卡绑定的商品
	 * @param param1
	 * @return
	 */
	List<Map<String, Object>> findBindCommodity(Map<String, Object> param1);
	
}

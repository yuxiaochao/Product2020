package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.product2020.entity.Tbyhqgl03;

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
public interface ITbyhqgl03Service extends IService<Tbyhqgl03> {

	/**
	 * 根据卡号密码查找优惠券
	 * @param param
	 * @return
	 */
	List<Tbyhqgl03> findYHQList(Map<String, Object> param);
	
}

package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.common.Req;
import com.huarui.product2020.entity.Tbjxsj12;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author YanZeYang
 * @since 2019-12-10
 */
public interface ITbjxsj12Service extends IService<Tbjxsj12> {
	/**
	 * 开班仪式、结业仪式基础数据以及附件保存
	 * @param req
	 * @return 基础数据表id
	 */
	String edit(Req req);
	
}

package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.common.Req;
import com.huarui.product2020.entity.Tbpxjk01;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author YanZeYang
 * @since 2020-01-15
 */
public interface ITbpxjk01Service extends IService<Tbpxjk01> {
	
	public Integer insertReported(Req req);
	
}

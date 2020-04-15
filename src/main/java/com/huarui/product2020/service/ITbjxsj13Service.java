package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.common.Req;
import com.huarui.product2020.entity.Tbjxsj13;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author YanZeYang
 * @since 2019-12-11
 */
public interface ITbjxsj13Service extends IService<Tbjxsj13> {
	/**
	 * 已上传列表
	 * @param req
	 * @return
	 */
	List<Tbjxsj13> findAllUploads(Req req);
	
}

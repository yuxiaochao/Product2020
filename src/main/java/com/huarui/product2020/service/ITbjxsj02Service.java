package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.common.Req;
import com.huarui.common.utils.IPage;
import com.huarui.product2020.entity.Tbjxsj02;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yuxiaochao
 * @since 2019-10-25
 */
public interface ITbjxsj02Service extends IService<Tbjxsj02> {

	List<Tbjxsj02> findByPage(IPage<Tbjxsj02> page, Req req);
	
}

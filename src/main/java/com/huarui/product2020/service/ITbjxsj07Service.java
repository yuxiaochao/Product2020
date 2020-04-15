package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.common.Req;
import com.huarui.common.utils.IPage;
import com.huarui.product2020.entity.Tbjxsj07;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yuxiaochao
 * @since 2019-10-25
 */
public interface ITbjxsj07Service extends IService<Tbjxsj07> {

	List<Tbjxsj07> findByPage(IPage<Tbjxsj07> page, Req req);

	HashMap findById(String string);
	
}

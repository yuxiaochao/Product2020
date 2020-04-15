package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.common.Req;
import com.huarui.common.utils.IPage;
import com.huarui.product2020.entity.Tbjxsj05;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yuxiaochao
 * @since 2019-10-25
 */
public interface ITbjxsj05Service extends IService<Tbjxsj05> {

	List<Tbjxsj05> findByPage(IPage<Tbjxsj05> page, Req req);

	void submmit(Req req);
	
}

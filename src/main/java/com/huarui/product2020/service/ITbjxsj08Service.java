package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.common.Req;
import com.huarui.product2020.entity.Tbjxsj08;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yuxiaochao
 * @since 2019-10-25
 */
public interface ITbjxsj08Service extends IService<Tbjxsj08> {

	Map selectGroups(String pxb0101);

	void submit(Req req);
	
}

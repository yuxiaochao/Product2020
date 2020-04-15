package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.common.Req;
import com.huarui.product2020.entity.ResultEntity;
import com.huarui.product2020.entity.Tbjxsj01;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yuxiaochao
 * @since 2019-10-25
 */
public interface ITbjxsj01Service extends IService<Tbjxsj01> {
	
	ResultEntity querySubmit(Req req) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SecurityException, NoSuchFieldException;

	List<String> findAllSelect(Req req);
	
}

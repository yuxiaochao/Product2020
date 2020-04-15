package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.product2020.entity.Tbusif02;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yuxiaochao
 * @since 2020-02-16
 */
public interface ITbusif02Service extends IService<Tbusif02> {

	Map<String, Object> getMailingAddress(String webUserId);
	
}

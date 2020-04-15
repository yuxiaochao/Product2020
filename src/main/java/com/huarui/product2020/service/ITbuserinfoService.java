package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.product2020.entity.Tbuserinfo;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yuxiaochao
 * @since 2020-02-19
 */
public interface ITbuserinfoService extends IService<Tbuserinfo> {

	//查询个人资料
	Map<String, Object> selectUserInfo(String webUserId);

	
}

package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.product2020.entity.Tbyhqgl01;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author panlei
 * @since 2020-04-07
 */
public interface ITbyhqgl01Service extends IService<Tbyhqgl01> {
	/**
	 * 根据卡号、密码查询对应的信息 
	 */
	public Map<String, String> getCouponByCardAndPwd(String yhqgl0303, String yhqgl0304);
}

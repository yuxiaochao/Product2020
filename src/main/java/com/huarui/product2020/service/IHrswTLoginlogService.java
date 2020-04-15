package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.product2020.entity.HrswTLoginlog;

import java.util.List;

/**
 * <p>
 * ${table.comment} 服务类
 * </p>
 *
 * @author Chenrui
 * @since 2017-08-13
 */
public interface IHrswTLoginlogService extends IService<HrswTLoginlog> {

	List queryLoginLogByUserID(String userID) throws Exception;
	
}

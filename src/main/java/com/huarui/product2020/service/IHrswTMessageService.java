package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.product2020.entity.HrswTMessage;

/**
 * <p>
 * ${table.comment} 服务类
 * </p>
 *
 * @author Chenrui
 * @since 2017-08-13
 */
public interface IHrswTMessageService extends IService<HrswTMessage> {

	/**
	 * 门户 用户未读消息数
	 * @param user001 用户ID
	 * @return
	 * @throws Exception
	 */
	String selectMessageNum(String user001) throws Exception;
	
}

package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.product2020.entity.HrswTChatmessage;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author panlei
 * @since 2018-12-27
 */
public interface IHrswTChatmessageService extends IService<HrswTChatmessage> {
	
	/**
	 * 检查未发送消息
	 * @param map
	 * @return
	 */
	public List<HrswTChatmessage> checkUnsentMsg(Map map);
}

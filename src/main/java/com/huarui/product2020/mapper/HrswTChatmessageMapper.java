package com.huarui.product2020.mapper;

import com.huarui.product2020.entity.HrswTChatmessage;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author panlei
 * @since 2018-12-27
 */
public interface HrswTChatmessageMapper extends BaseMapper<HrswTChatmessage> {
	/**
	 * 检查未发送消息
	 * @param map
	 * @return
	 */
	public List<HrswTChatmessage> checkUnsentMsg(Map map);
}
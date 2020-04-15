package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.product2020.entity.HrswTChatmessage;
import com.huarui.product2020.mapper.HrswTChatmessageMapper;
import com.huarui.product2020.service.IHrswTChatmessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author panlei
 * @since 2018-12-27
 */
@Service
public class HrswTChatmessageServiceImpl extends ServiceImpl<HrswTChatmessageMapper, HrswTChatmessage> implements IHrswTChatmessageService {
	@Autowired
	private HrswTChatmessageMapper hrswTChatmessageMapper;
	
	public List<HrswTChatmessage> checkUnsentMsg(Map map) {
		return hrswTChatmessageMapper.checkUnsentMsg(map);
	}
	
}

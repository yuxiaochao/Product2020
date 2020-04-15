package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.product2020.entity.HrswTMessage;
import com.huarui.product2020.mapper.HrswTMessageMapper;
import com.huarui.product2020.service.IHrswTMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * ${table.comment} 服务实现类
 * </p>
 *
 * @author Chenrui
 * @since 2017-08-13
 */
@Service
public class HrswTMessageServiceImpl extends ServiceImpl<HrswTMessageMapper, HrswTMessage> implements IHrswTMessageService {

	@Autowired
	private HrswTMessageMapper messageMapper;
	
	public String selectMessageNum(String user001) throws Exception {
		return messageMapper.selectMessageNum(user001);
	}
	
}

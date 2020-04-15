package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.product2020.entity.HrswTNetmeeting;
import com.huarui.product2020.mapper.HrswTNetmeetingMapper;
import com.huarui.product2020.service.IHrswTNetmeetingService;
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
 * @since 2018-03-12
 */
@Service
public class HrswTNetmeetingServiceImpl extends ServiceImpl<HrswTNetmeetingMapper, HrswTNetmeeting> implements IHrswTNetmeetingService {
	@Autowired
	private HrswTNetmeetingMapper mapper;
	@Override
	public List<Map<String, String>> findnetmeetingByMeetingID(Map<String, String> map) {
		return mapper.findnetmeetingByMeetingID(map);
	}
	
}

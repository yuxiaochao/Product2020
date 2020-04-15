package com.huarui.product2020.service.impl;


import com.huarui.common.utils.IPage;
import com.huarui.product2020.mapper.WorkMapper;
import com.huarui.product2020.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class WorkServiceImpl implements WorkService {

	@Autowired
	private WorkMapper workMapper;
	
	
	@Override
	public List queryMeetingList(IPage page, Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return workMapper.queryMeetingList(page, map);
	}

	@Override
	public List queryTaskList(IPage page, Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return workMapper.queryTaskList(page, map);
	}

}

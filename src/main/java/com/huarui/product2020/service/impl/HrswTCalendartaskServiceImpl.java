package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.product2020.entity.HrswTCalendartask;
import com.huarui.product2020.mapper.HrswTCalendartaskMapper;
import com.huarui.product2020.service.IHrswTCalendartaskService;
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
 * @since 2018-10-17
 */
@Service
public class HrswTCalendartaskServiceImpl extends ServiceImpl<HrswTCalendartaskMapper, HrswTCalendartask> implements IHrswTCalendartaskService {

	@Autowired
	private HrswTCalendartaskMapper mapper;
	@Override
	public List queryTaskList(Map map) throws Exception {
		return mapper.queryTaskList(map);
	}
	@Override
	public List queryTaskInfo(Map map) throws Exception {
		return mapper.queryTaskInfo(map);
	}
	@Override
	public List queryTaskUserInfo(Map map) throws Exception {
		return mapper.queryTaskUserInfo(map);
	}
	@Override
	public Integer selectNoReaderTask(Map map) throws Exception {
		// TODO Auto-generated method stub
		return mapper.selectNoReaderTask(map);
	}
	
}

package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.product2020.entity.HrswTCalendarmemorandum;
import com.huarui.product2020.mapper.HrswTCalendarmemorandumMapper;
import com.huarui.product2020.service.IHrswTCalendarmemorandumService;
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
public class HrswTCalendarmemorandumServiceImpl extends ServiceImpl<HrswTCalendarmemorandumMapper, HrswTCalendarmemorandum> implements IHrswTCalendarmemorandumService {

	@Autowired
	private HrswTCalendarmemorandumMapper mapper;
	
	
	@Override
	public List queryScheduleList(Map map) throws Exception {
		return mapper.queryScheduleList(map);
	}


	@Override
	public List meetingRoomList(Map map) throws Exception {
		return mapper.meetingRoomList(map);
	}


	@Override
	public List workGroupList(Map map) throws Exception {
		return mapper.workGroupList(map);
	}


	@Override
	public List workGroupUserList(Map map) throws Exception {
		return mapper.workGroupUserList(map);
	}


	@Override
	public List initAllCalendarInfo(Map map) throws Exception {
		return mapper.initAllCalendarInfo(map);
	}


	@Override
	public List getScheduleRemindList(Map map) throws Exception {
		return mapper.getScheduleRemindList(map);
	}


	@Override
	public List initAllCalendarWeekInfo(Map map) throws Exception {
		return mapper.initAllCalendarWeekInfo(map);
	}


	@Override
	public List initLeadershipList(Map map) throws Exception {
		return mapper.initLeadershipList(map);
	}
	
	@Override
	public List initLeadershipList01(Map map) throws Exception {
		return mapper.initLeadershipList01(map);
	}


	@Override
	public List getScheduleUserList(Map map) throws Exception {
		return mapper.getScheduleUserList(map);
	}
	
}
















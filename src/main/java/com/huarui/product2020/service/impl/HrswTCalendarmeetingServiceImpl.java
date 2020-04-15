package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.common.utils.IPage;
import com.huarui.product2020.entity.HrswTCalendarmeeting;
import com.huarui.product2020.mapper.HrswTCalendarmeetingMapper;
import com.huarui.product2020.service.IHrswTCalendarmeetingService;
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
public class HrswTCalendarmeetingServiceImpl extends ServiceImpl<HrswTCalendarmeetingMapper, HrswTCalendarmeeting> implements IHrswTCalendarmeetingService {


	@Autowired
	private HrswTCalendarmeetingMapper hrswTCalendarmeetingMapper;


	@Autowired
	private HrswTCalendarmeetingMapper mapper;

	


	@Override
	public IPage queryMeetingList(IPage page, Map<String, Object> map) throws Exception {
      
		List meetingList = hrswTCalendarmeetingMapper.queryMeetingList(page, map);
		
		page.setRecords(meetingList);
		
		return page;
	}


	@Override
	public IPage queryTaskList(IPage page, Map<String, Object> map) throws Exception {
        
		List taskList = hrswTCalendarmeetingMapper.queryTaskList(page, map);
		
		page.setRecords(taskList);
		
		return page;
		
	}


	@Override
	public int totalNumber(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return hrswTCalendarmeetingMapper.totalNumber(map);
	}


	@Override
	public List selectTaskOrMeetingPeople(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return hrswTCalendarmeetingMapper.selectTaskOrMeetingPeople(map);
	}


	@Override
	public Integer selectSignNumber(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return hrswTCalendarmeetingMapper.selectSignNumber(map);
	}


	@Override
	public List queryMeetingList(Map map) throws Exception {
		return mapper.queryMeetingList(map);
	}

	
	@Override
	public List queryMeetingInfo(Map map) throws Exception {
		return mapper.queryMeetingInfo(map);
	}


	@Override
	public Integer selectSignNumberofMeet(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return hrswTCalendarmeetingMapper.selectSignNumberofMeet(map);
	}


	@Override
	public IPage selectTaskList(IPage page, Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		List taskList = hrswTCalendarmeetingMapper.selectTaskList(page, map);
		
		page.setRecords(taskList);
		
		return page;
	}


	@Override
	public List selectTaskDetails(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return hrswTCalendarmeetingMapper.selectTaskDetails(map);
	}

	@Override
	public List queryMeetingList02(Map map) throws Exception {
		return mapper.queryMeetingList02(map);
	}

	@Override
	public List queryMeetingInfo02(Map map) throws Exception {
		return mapper.queryMeetingInfo02(map);
	}


	@Override
	public Integer selectNoReaderMeet(Map map) throws Exception {
		// TODO Auto-generated method stub
		return hrswTCalendarmeetingMapper.selectNoReaderMeet(map);
	}


	@Override
	public Integer signCompletionNum(Map map) throws Exception {
		// TODO Auto-generated method stub
		return hrswTCalendarmeetingMapper.signCompletionNum(map);
	}


	@Override
	public List selectAccomplishedpersonofMeet(Map map) throws Exception {
		// TODO Auto-generated method stub
		return hrswTCalendarmeetingMapper.selectAccomplishedpersonofMeet(map);
	}

}

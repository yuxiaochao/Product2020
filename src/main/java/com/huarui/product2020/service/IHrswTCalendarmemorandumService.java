package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.product2020.entity.HrswTCalendarmemorandum;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author panlei
 * @since 2018-10-17
 */
public interface IHrswTCalendarmemorandumService extends IService<HrswTCalendarmemorandum> {
	
	List queryScheduleList(Map map)throws Exception;
	
	List meetingRoomList(Map map)throws Exception;
	
	List initLeadershipList(Map map)throws Exception;
	
	List initLeadershipList01(Map map)throws Exception;
	
	List workGroupList(Map map)throws Exception;
	
	List workGroupUserList(Map map)throws Exception;
	
	List initAllCalendarInfo(Map map)throws Exception;
	
	List initAllCalendarWeekInfo(Map map)throws Exception;
	
	List getScheduleRemindList(Map map)throws Exception;
	
	List getScheduleUserList(Map map)throws Exception;
	
	
}

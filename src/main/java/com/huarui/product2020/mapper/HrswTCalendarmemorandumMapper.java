package com.huarui.product2020.mapper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.huarui.product2020.entity.HrswTCalendarmemorandum;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author panlei
 * @since 2018-10-17
 */
public interface HrswTCalendarmemorandumMapper extends BaseMapper<HrswTCalendarmemorandum> {

	List queryScheduleList(Map map)throws Exception;
	
	List meetingRoomList(Map map)throws Exception;
	
	List workGroupList(Map map)throws Exception;
	
	List workGroupUserList(Map map)throws Exception;	
	
	List initAllCalendarInfo(Map map)throws Exception;
	
	List initAllCalendarWeekInfo(Map map)throws Exception;
	
	List initLeadershipList(Map map)throws Exception;
	
	List initLeadershipList01(Map map)throws Exception;
	
	List getScheduleRemindList(Map map)throws Exception;
	
	List getScheduleUserList(Map map)throws Exception;
}
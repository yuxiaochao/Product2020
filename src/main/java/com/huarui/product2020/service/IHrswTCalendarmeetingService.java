package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.common.utils.IPage;
import com.huarui.product2020.entity.HrswTCalendarmeeting;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author panlei
 * @since 2018-10-17
 */
public interface IHrswTCalendarmeetingService extends IService<HrswTCalendarmeeting> {
	
	
	
	
	/**
	 * 会议-签过到的人员信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List selectAccomplishedpersonofMeet(Map map) throws Exception;
	
	/**
	 * 会议完成人数情况
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Integer signCompletionNum(Map map)  throws Exception;


	/**
	 * 
	 * @param page
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public IPage selectTaskList(IPage page, Map<String, Object> map) throws Exception;

	public List selectTaskDetails(Map<String, Object> map) throws Exception;

	/**
	 * 工作-本周 会议 1
	 * 
	 * @param page
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public IPage queryMeetingList(IPage page, Map<String, Object> map) throws Exception;

	/**
	 * 工作-本周 任务 2
	 * 
	 * @param page
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public IPage queryTaskList(IPage page, Map<String, Object> map) throws Exception;

	/**
	 * 参加 会议/任务总人数
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int totalNumber(Map<String, Object> map) throws Exception;

	/**
	 * 查询 参会人员 (会议/任务)
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List selectTaskOrMeetingPeople(Map<String, Object> map) throws Exception;

	/**
	 * 查询签到人数(任务)
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Integer selectSignNumber(Map<String, Object> map) throws Exception;

	/**
	 * 查询签到人数(会议)
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Integer selectSignNumberofMeet(Map<String, Object> map) throws Exception;

	List queryMeetingList(Map map) throws Exception;

	List queryMeetingInfo(Map map) throws Exception;

	List queryMeetingInfo02(Map map) throws Exception;

	List queryMeetingList02(Map map) throws Exception;

	public Integer selectNoReaderMeet(Map map) throws Exception;
}

package com.huarui.product2020.mapper;

import java.util.List;
import java.util.Map;

import com.huarui.common.utils.IPage;

public interface WorkMapper {
	
	/**
	 * 工作-本周会议列表
	 * @param page
	 * @param map
	 * @return
	 * @throws Exception
	 */
   public List queryMeetingList(IPage page,Map<String, Object> map) throws Exception;
   
   /**
	 * 工作-本周任务列表
	 * @param page
	 * @param map
	 * @return
	 * @throws Exception
	 */
  public List queryTaskList(IPage page,Map<String, Object> map) throws Exception;

}

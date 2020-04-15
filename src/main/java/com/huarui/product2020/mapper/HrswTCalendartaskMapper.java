package com.huarui.product2020.mapper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.huarui.product2020.entity.HrswTCalendartask;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author panlei
 * @since 2018-10-17
 */
public interface HrswTCalendartaskMapper extends BaseMapper<HrswTCalendartask> {

	List queryTaskList(Map map)throws Exception;
	
	List queryTaskInfo(Map map)throws Exception;
	
	List queryTaskUserInfo(Map map)throws Exception;
	
	public Integer selectNoReaderTask(Map map) throws Exception;
}
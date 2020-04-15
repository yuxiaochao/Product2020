package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.product2020.entity.HrswTCalendartask;

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
public interface IHrswTCalendartaskService extends IService<HrswTCalendartask> {
	List queryTaskList(Map map)throws Exception;
	
	List queryTaskInfo(Map map)throws Exception;
	
	List queryTaskUserInfo(Map map)throws Exception;
	
	public Integer selectNoReaderTask(Map map) throws Exception;
}

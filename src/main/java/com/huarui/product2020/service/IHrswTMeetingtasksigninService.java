package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.product2020.entity.HrswTMeetingtasksignin;
import com.huarui.product2020.entity.HrswTTaskresult;

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
public interface IHrswTMeetingtasksigninService extends IService<HrswTMeetingtasksignin> {

	
	/**
	 * 出勤签到
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public boolean signIn(HrswTMeetingtasksignin signInfo) throws Exception;
	
	/**
	 * 查询 任务 是否已完成签到
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public String selectTaskStye(Map map)throws Exception;
	
	/**
	 * 任务结果表
	 * @param taskInfo
	 * @return
	 * @throws Exception
	 */
	public boolean updateTaskResult(HrswTTaskresult taskInfo) throws Exception;
	
	/**
	 * 任务评价
	 * @return
	 * @throws Exception
	 */
	public List taskResult(Map map) throws Exception;
}

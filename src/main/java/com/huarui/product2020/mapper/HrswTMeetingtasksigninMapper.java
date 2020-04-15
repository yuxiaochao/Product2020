package com.huarui.product2020.mapper;

import com.huarui.product2020.entity.HrswTMeetingtasksignin;
import com.huarui.product2020.entity.HrswTTaskresult;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author panlei
 * @since 2018-10-17
 */
public interface HrswTMeetingtasksigninMapper extends BaseMapper<HrswTMeetingtasksignin> {

	
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
package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.product2020.entity.HrswTAttendanceplan;

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
public interface IHrswTAttendanceplanService extends IService<HrswTAttendanceplan> {

	/***
	 * 查询 出勤计划
	 * @return
	 * @throws Exception
	 */
	public List selectAttendanceplan(Map map) throws Exception;

	/**
	 * 查询 签到时间
	 * @return
	 * @throws Exception
	 */
	public List selectTime(Map map) throws Exception;

	public List onWorkInfo(Map map) throws Exception;
	
	public List offWorkInfo(Map map) throws Exception;
	
	public List getAllSign(Map map) throws Exception;

}

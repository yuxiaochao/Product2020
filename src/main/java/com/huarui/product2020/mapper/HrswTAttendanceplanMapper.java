package com.huarui.product2020.mapper;

import com.huarui.product2020.entity.HrswTAttendanceplan;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author panlei
 * @since 2018-10-17
 */
public interface HrswTAttendanceplanMapper extends BaseMapper<HrswTAttendanceplan> {

	/***
	 * 查询 出勤计划
	 * 
	 * @return
	 * @throws Exception
	 */
	public List selectAttendanceplan(Map map) throws Exception;

	/**
	 * 查询 签到时间
	 * 
	 * @return
	 * @throws Exception
	 */
	public List selectTime(Map map) throws Exception;

	public List onWorkInfo(Map map) throws Exception;

	public List offWorkInfo(Map map) throws Exception;
	
	public List getAllSign(Map map) throws Exception;

}
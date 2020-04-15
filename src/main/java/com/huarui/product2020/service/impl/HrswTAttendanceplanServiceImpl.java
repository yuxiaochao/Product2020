package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.product2020.entity.HrswTAttendanceplan;
import com.huarui.product2020.mapper.HrswTAttendanceplanMapper;
import com.huarui.product2020.service.IHrswTAttendanceplanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author panlei
 * @since 2018-10-17
 */
@Service
public class HrswTAttendanceplanServiceImpl extends ServiceImpl<HrswTAttendanceplanMapper, HrswTAttendanceplan> implements IHrswTAttendanceplanService {

	@Autowired
	private HrswTAttendanceplanMapper attendancePlanMapper;
	
	@Override
	public List selectAttendanceplan(Map map) throws Exception {
		// TODO Auto-generated method stub
		return attendancePlanMapper.selectAttendanceplan(map);
	}

	@Override
	public List selectTime(Map map) throws Exception {
		// TODO Auto-generated method stub
		return attendancePlanMapper.selectTime(map);
	}

	@Override
	public List onWorkInfo(Map map) throws Exception {
		return attendancePlanMapper.onWorkInfo(map);
	}

	@Override
	public List offWorkInfo(Map map) throws Exception {
		return attendancePlanMapper.offWorkInfo(map);
	}

	@Override
	public List getAllSign(Map map) throws Exception {
		return attendancePlanMapper.getAllSign(map);
	}
	
}

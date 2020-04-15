package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.product2020.entity.HrswTMeetingtasksignin;
import com.huarui.product2020.entity.HrswTTaskresult;
import com.huarui.product2020.mapper.HrswTMeetingtasksigninMapper;
import com.huarui.product2020.service.IHrswTMeetingtasksigninService;
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
public class HrswTMeetingtasksigninServiceImpl extends ServiceImpl<HrswTMeetingtasksigninMapper, HrswTMeetingtasksignin> implements IHrswTMeetingtasksigninService {

	@Autowired
	private HrswTMeetingtasksigninMapper signinMapper;
	
	
	@Override
	public boolean signIn(HrswTMeetingtasksignin signInfo) throws Exception {
		// TODO Auto-generated method stub
		return signinMapper.signIn(signInfo);
	}


	@Override
	public boolean updateTaskResult(HrswTTaskresult taskInfo) throws Exception {
		// TODO Auto-generated method stub
		return signinMapper.updateTaskResult(taskInfo);
	}


	@Override
	public String selectTaskStye(Map map) throws Exception {
		// TODO Auto-generated method stub
		return signinMapper.selectTaskStye(map);
	}


	@Override
	public List taskResult(Map map) throws Exception {
		// TODO Auto-generated method stub
		return signinMapper.taskResult(map);
	}
	
}

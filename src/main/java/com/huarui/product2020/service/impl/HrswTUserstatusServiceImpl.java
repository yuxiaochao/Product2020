package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.product2020.entity.HrswTUserstatus;
import com.huarui.product2020.mapper.HrswTUserstatusMapper;
import com.huarui.product2020.service.IHrswTUserstatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author panlei
 * @since 2018-10-17
 */
@Service
public class HrswTUserstatusServiceImpl extends ServiceImpl<HrswTUserstatusMapper, HrswTUserstatus> implements IHrswTUserstatusService {

	@Autowired
	private HrswTUserstatusMapper userstatusMapper;
	
	@Override
	public boolean insertInfo(HrswTUserstatus userInfo) throws Exception {
		return userstatusMapper.insertInfo(userInfo);
	}
	
}

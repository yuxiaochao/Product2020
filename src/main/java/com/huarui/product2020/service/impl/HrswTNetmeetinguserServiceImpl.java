package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.product2020.entity.HrswTNetmeetinguser;
import com.huarui.product2020.mapper.HrswTNetmeetinguserMapper;
import com.huarui.product2020.service.IHrswTNetmeetinguserService;
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
 * @since 2018-03-13
 */
@Service
public class HrswTNetmeetinguserServiceImpl extends ServiceImpl<HrswTNetmeetinguserMapper, HrswTNetmeetinguser> implements IHrswTNetmeetinguserService {
    @Autowired
	private HrswTNetmeetinguserMapper mapper;

	@Override
	public List<Map<String, String>> findnetmeetingByUID(Map<String, String> userid) {
		// TODO Auto-generated method stub
		return mapper.findnetmeetingByUID(userid);
	}





	



	
	
	

}

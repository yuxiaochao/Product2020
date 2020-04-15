package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.product2020.entity.HrswTJobrightsassigchild;
import com.huarui.product2020.mapper.HrswTJobrightsassigchildMapper;
import com.huarui.product2020.service.IHrswTJobrightsassigchildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yuxiaochao
 * @since 2019-01-05
 */
@Service
public class HrswTJobrightsassigchildServiceImpl extends ServiceImpl<HrswTJobrightsassigchildMapper, HrswTJobrightsassigchild> implements IHrswTJobrightsassigchildService {

	@Autowired
	private HrswTJobrightsassigchildMapper mapper;
	
	@Override
	public List selectPrincipal(Map map) throws Exception {
		return mapper.selectPrincipal(map);
	}

	@Override
	public List selectSupervisor(Map map) throws Exception {
		return mapper.selectSupervisor(map);
	}

	@Override
	public Map selectOrganType(Map map) throws Exception {
		return mapper.selectOrganType(map);
	}
	
}

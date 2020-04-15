package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.product2020.entity.HrswTLoginlog;
import com.huarui.product2020.mapper.HrswTLoginlogMapper;
import com.huarui.product2020.service.IHrswTLoginlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * ${table.comment} 服务实现类
 * </p>
 *
 * @author Chenrui
 * @since 2017-08-13
 */
@Service
public class HrswTLoginlogServiceImpl extends ServiceImpl<HrswTLoginlogMapper, HrswTLoginlog> implements IHrswTLoginlogService {

	@Autowired
	private HrswTLoginlogMapper loginMapper;
	
	public List queryLoginLogByUserID(String userID) throws Exception {
		return loginMapper.queryLoginLogByUserID(userID);
	}
	
}

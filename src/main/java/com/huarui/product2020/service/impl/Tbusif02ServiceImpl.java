package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.product2020.entity.Tbusif02;
import com.huarui.product2020.mapper.Tbusif02Mapper;
import com.huarui.product2020.service.ITbusif02Service;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yuxiaochao
 * @since 2020-02-16
 */
@Service
public class Tbusif02ServiceImpl extends ServiceImpl<Tbusif02Mapper, Tbusif02> implements ITbusif02Service {

	@Override
	public Map<String, Object> getMailingAddress(String webUserId) {
		return baseMapper.getMailingAddress(webUserId);
	}
	
}

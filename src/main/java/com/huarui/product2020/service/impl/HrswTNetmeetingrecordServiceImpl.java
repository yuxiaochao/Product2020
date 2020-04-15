package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.product2020.entity.HrswTNetmeetingrecord;
import com.huarui.product2020.mapper.HrswTNetmeetingrecordMapper;
import com.huarui.product2020.service.IHrswTNetmeetingrecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class HrswTNetmeetingrecordServiceImpl extends ServiceImpl<HrswTNetmeetingrecordMapper, HrswTNetmeetingrecord> implements IHrswTNetmeetingrecordService {
     @Autowired
	private HrswTNetmeetingrecordMapper Mapper;
	
	@Override
	public int insertnetmeetingrecord(Map<String, Object> map) {

		return Mapper.insertnetmeetingrecord(map);
	}
	
}

package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.product2020.entity.HrswTMessagereader;
import com.huarui.product2020.mapper.HrswTMessagereaderMapper;
import com.huarui.product2020.service.IHrswTMessagereaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * ${table.comment} 服务实现类
 * </p>
 *
 * @author Chenrui
 * @since 2017-08-13
 */
@Service
public class HrswTMessagereaderServiceImpl extends ServiceImpl<HrswTMessagereaderMapper, HrswTMessagereader> implements IHrswTMessagereaderService {

	@Autowired
	private HrswTMessagereaderMapper messagereaderMapper;
	
	@Override
	public boolean insertMessagereader(HrswTMessagereader info) throws Exception {
		// TODO Auto-generated method stub
		return messagereaderMapper.insertMessagereader(info);
	}
	
}

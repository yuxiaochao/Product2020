package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.product2020.entity.HrswTTaglibrary;
import com.huarui.product2020.mapper.HrswTTaglibraryMapper;
import com.huarui.product2020.service.IHrswTTaglibraryService;
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
public class HrswTTaglibraryServiceImpl extends ServiceImpl<HrswTTaglibraryMapper, HrswTTaglibrary> implements IHrswTTaglibraryService {

	@Autowired
	private HrswTTaglibraryMapper mapper;
	
	@Override
	public List taskLabelList(Map map) throws Exception {
		return mapper.taskLabelList(map);
	}
	
}

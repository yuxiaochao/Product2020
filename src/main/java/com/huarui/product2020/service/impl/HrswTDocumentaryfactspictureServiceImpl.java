package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.product2020.entity.HrswTDocumentaryfactspicture;
import com.huarui.product2020.mapper.HrswTDocumentaryfactspictureMapper;
import com.huarui.product2020.service.IHrswTDocumentaryfactspictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhangyalong
 * @since 2018-12-19
 */
@Service
public class HrswTDocumentaryfactspictureServiceImpl extends ServiceImpl<HrswTDocumentaryfactspictureMapper, HrswTDocumentaryfactspicture> implements IHrswTDocumentaryfactspictureService {

	@Autowired
	private HrswTDocumentaryfactspictureMapper factspictureMapper;
	
	@Override
	public boolean deletePictrue(Map map) throws Exception {
		// TODO Auto-generated method stub
		return factspictureMapper.deletePictrue(map);
	}
	
}

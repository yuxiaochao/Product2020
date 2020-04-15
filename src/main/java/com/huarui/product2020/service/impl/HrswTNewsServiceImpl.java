package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.product2020.entity.HrswTNews;
import com.huarui.product2020.mapper.HrswTNewsMapper;
import com.huarui.product2020.service.IHrswTNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * ${table.comment} 服务实现类
 * </p>
 *
 * @author Chenrui
 * @since 2017-08-13
 */
@Service
public class HrswTNewsServiceImpl extends ServiceImpl<HrswTNewsMapper, HrswTNews> implements IHrswTNewsService {

	@Autowired
	private HrswTNewsMapper newsMapper;
	
	public List selectSlidePictureList(int news007) throws Exception {
		return newsMapper.selectSlidePictureList(news007);
	}

	public Map selectPortalInfoList(String user001) throws Exception {
		return newsMapper.selectPortalInfoList(user001);
	}
	
}

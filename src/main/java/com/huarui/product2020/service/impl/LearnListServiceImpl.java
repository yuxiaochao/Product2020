package com.huarui.product2020.service.impl;

import com.huarui.common.utils.IPage;
import com.huarui.product2020.mapper.LearnListMapper;
import com.huarui.product2020.service.LearnListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LearnListServiceImpl implements LearnListService {
	@Autowired
	private LearnListMapper learnMapper;
	
	/**
	 * 在线学习列表
	 */
	public IPage findByLearnList(IPage researchListPage, Map paramMap) throws Exception {
		researchListPage.setRecords(learnMapper.findByLearnList(researchListPage,paramMap));
		return researchListPage;
	}
}

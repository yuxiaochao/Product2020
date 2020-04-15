package com.huarui.product2020.mapper;

import java.util.List;
import java.util.Map;

import com.huarui.common.utils.IPage;

	public interface LearnListMapper{

	/**
	 * 在线学习
	 * 学习列表
	 * @param req
	 * @return
	 */
	public List<Map<String, Object>>  findByLearnList(IPage researchListPage,Map paramMap) throws Exception;
}

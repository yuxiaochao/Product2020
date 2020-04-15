package com.huarui.product2020.service;

import com.huarui.common.utils.IPage;

import java.util.Map;

public interface LearnListService{

/**
 * 在线学习
 * 学习列表
 * @param ew
 * @return
 */
public IPage findByLearnList(IPage researchListPage, Map paramMap) throws Exception;


}

package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.common.utils.IPage;
import com.huarui.product2020.entity.QuesTQuestionnaire;
import com.huarui.product2020.mapper.QuesTQuestionnaireMapper;
import com.huarui.product2020.service.IQuesTQuestionnaireService;
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
public class QuesTQuestionnaireServiceImpl extends ServiceImpl<QuesTQuestionnaireMapper, QuesTQuestionnaire> implements IQuesTQuestionnaireService {

	@Autowired
	private QuesTQuestionnaireMapper quesMapper;
	
	public String selectResearchNum(String user001) throws Exception {
		return quesMapper.selectResearchNum(user001);
	}

	public List selectRecentQuestionnaireList(String user001) throws Exception {
		return quesMapper.selectRecentQuestionnaireList(user001);
	}

	public IPage selectResearchHistoryPage(IPage page, Map args) throws Exception {
		page.setRecords(quesMapper.selectResearchHistoryPage(page,args));
		return page;
	}
	
}

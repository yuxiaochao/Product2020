package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.common.utils.IPage;
import com.huarui.product2020.entity.QuesTQuestionnaire;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * ${table.comment} 服务类
 * </p>
 *
 * @author Chenrui
 * @since 2017-08-13
 */
public interface IQuesTQuestionnaireService extends IService<QuesTQuestionnaire> {

	/**
	 * 门户 调查消息未读数
	 * @param user001 用户ID
	 * @return
	 * @throws Exception
	 */
	String selectResearchNum(String user001) throws Exception;

	/** 
	 * 门户 近期问卷调查列表
	 * @param user001 用户ID
	 * @return
	 * @throws Exception
	 */
	List selectRecentQuestionnaireList(String user001) throws Exception;

	/**
	 * 我的 调查记录
	 * @param args 用户ID
	 * @return
	 * @throws Exception
	 */
	IPage selectResearchHistoryPage(IPage page, Map args) throws Exception;
	
}

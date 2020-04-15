package com.huarui.product2020.mapper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.huarui.product2020.entity.QuesTQuestionnaire;

/**
 * <p>
  * ${table.comment} Mapper 接口
 * </p>
 *
 * @author Chenrui
 * @since 2017-08-13
 */
public interface QuesTQuestionnaireMapper extends BaseMapper<QuesTQuestionnaire> {

	/**
	 * 门户 问卷调查未读数
	 * @param user001 用户ID
	 * @return
	 * @throws Exception
	 */
	String selectResearchNum(String user001) throws Exception;

	/**
	 * 门户 最近问卷调查列表
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
	List selectResearchHistoryPage(Pagination page, Map args) throws Exception;

}
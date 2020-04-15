package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.common.utils.IPage;
import com.huarui.product2020.entity.ExamTBasetx;
import com.huarui.product2020.entity.ExamTErrortopic;
import com.huarui.product2020.entity.ExerSampleEntity;

import java.io.IOException;
import java.sql.SQLException;
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
public interface IExamTErrortopicService extends IService<ExamTErrortopic> {

	/**
	 * 错题中心 错题列表
	 * @param errorTopicPage
	 * @param user001
	 * @return
	 * @throws Exception
	 */
	IPage selectErrorTopicPage(IPage errorTopicPage, String user001) throws Exception;
	
	/**
	 * 获取用户错题数量
	 * @param user001
	 * @return
	 * @throws Exception
	 */
	public Integer queryErrorTopicCount(String user001) throws Exception;
	
	
	/**
	 * 错题中心 错题内容列表
	 * @param user001 用户ID
	 * @param erto003 知识点
	 * @return
	 * @throws Exception
	 */
	Map selectErrorTopicNumWithKnowledge(Map<String, Object> paramMap) throws Exception;
	

	/**
	 * 错题中心 错题内容列表
	 * @param user001 用户ID
	 * @param erto003 知识点
	 * @return
	 * @throws Exception
	 */
	List selectErrorTopicContentList(Map<String, Object> paramMap) throws Exception;

	/**
	 * 错题中心
	 * 子题
	 * @param ttop006
	 * @return
	 * @throws Exception
	 */
	List<Map<String, Object>> selectErrorChildTopicContentList(String ttop006) throws Exception;
	/**
	 * 删除错题
	 * 
	 * @param ttop006
	 * @return
	 * @throws Exception
	 */
    boolean deleteByTopicId(String erto002) throws Exception;

	IPage selectExerciseErrorTopicPage(IPage errorTopicPage, Map<String, Object> params) throws Exception;
	
	/**
	 * 根据错题实体类获取错题信息
	 * @param errorTopic
	 * @return
	 */
	public ExamTErrortopic queryErrorTopicByEntity(ExamTErrortopic errorTopic);
	
	/**
	 * 插入错题
	 * @param errorTopic
	 * @return
	 */
	public boolean addErrorTopic(ExamTErrortopic errorTopic);
	
	/**
	 * 验证是否有未完成的随机错题 
	 */
	public Map<String, Object> checkRandomErrorTopic(Map<String, Object> params);
	
	/**
	 * 获取上次未完成的错题
	 */
	public List<Map<String, Object>> queryErrorTopicList(Map<String, Object> params) throws SQLException, IOException;
	
	/**
	 * 错题中抽题试题
	 */
	public List<Map<String, Object>> queryQuestionErrorTopicList(Map<String, Object> params);
	
	/**
	 * 获取错题题型
	 */
	public List<ExamTBasetx> findErrorTopicTx(Map<String, Object> paramMap);
	
	/**
	 * 根据id获取抽题信息
	 */
	public ExerSampleEntity querySampleInfoById(String exsa001);
}

package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.common.utils.IPage;
import com.huarui.product2020.entity.ExamTTestactivity;

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
public interface IExamTTestactivityService extends IService<ExamTTestactivity> {

	/**
	 * 我的 考试记录
	 * @param arg 用户ID
	 * @return
	 * @throws Exception
	 */
	IPage selectExamHistoryPage(IPage page, Map arg) throws Exception;

	/**
	 * 我的 学习记录
	 * @param user001 用户ID
	 * @return
	 * @throws Exception
	 */
	IPage selectStudyHistoryPage(IPage page, String user001) throws Exception;

	/**
	 * 我的 考试记录信息
	 * @param user001 用户ID
	 * @param tact001 考试活动ID
	 * @return
	 * @throws Exception
	 */
	Map selectExamHistoryInfo(String user001, String tact001) throws Exception;

	/**
	 * 我的 考试记录详情(一次考试活动对应的考试记录)
	 * @param user001
	 * @param tact001
	 * @return
	 * @throws Exception
	 */
	IPage selectExamHistoryDetailsPage(IPage page, String user001, String tact001) throws Exception;

	/**
	 * 我的 学习记录详情 课程信息
	 * @param arg
	 * @return
	 * @throws Exception
	 */
	Map studyHistoryCourseInfo(Map arg) throws Exception;

	/**
	 * 学习记录-单个课程对应的学习记录
	 * @param arg
	 * @return
	 * @throws Exception
	 */
	List courseStudyHistoryList(Map arg) throws Exception;
	
}

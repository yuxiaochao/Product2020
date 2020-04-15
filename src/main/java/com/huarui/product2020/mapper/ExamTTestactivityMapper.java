package com.huarui.product2020.mapper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.huarui.common.Req;
import com.huarui.common.utils.IPage;
import com.huarui.product2020.entity.ExamTTestactivity;

/**
 * <p>
  * ${table.comment} Mapper 接口
 * </p>
 *
 * @author Chenrui
 * @since 2017-08-13
 */
public interface ExamTTestactivityMapper extends BaseMapper<ExamTTestactivity> {

	/**
	 * 我的 考试记录
	 * @param arg 用户ID
	 * @return
	 * @throws Exception
	 */
	List selectExamHistoryPage(Pagination page,Map arg) throws Exception;

	/**
	 * 我的 学习记录
	 * @param user001 用户ID
	 * @return
	 * @throws Exception
	 */
	List selectStudyHistoryPage(Pagination page,String user001) throws Exception;

	/**
	 * 我的 考试记录信息
	 * @param user001
	 * @param tact001
	 * @return
	 * @throws Exception
	 */
	Map selectExamHistoryInfo(String user001, String tact001) throws Exception;

	/**
	 * 我的 考试记录详情(一次考试活动对应的考试记录)
	 * @param model
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	List selectExamHistoryDetailsPage(Pagination page,String user001, String tact001) throws Exception;

	/**
	 * 我的 学习记录课程信息
	 * @param arg
	 * @return
	 * @throws Exception
	 */
	Map studyHistoryCourseInfo(Map arg) throws Exception;

	/**
	 * 学习记录-单个课程对应的学习记录列表
	 * @param arg
	 * @return
	 * @throws Exception
	 */
	List courseStudyHistoryList(Map arg) throws Exception;

	List<ExamTTestactivity> findByPage(IPage<ExamTTestactivity> page, Req req);

}
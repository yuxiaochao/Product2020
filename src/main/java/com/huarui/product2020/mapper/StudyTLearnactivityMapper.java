package com.huarui.product2020.mapper;

import com.huarui.product2020.entity.StudyTLearnactivity;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  * ${table.comment} Mapper 接口
 * </p>
 *
 * @author Chenrui
 * @since 2017-08-13
 */
public interface StudyTLearnactivityMapper extends BaseMapper<StudyTLearnactivity> {

	/**
	 * 门户 在线学习未读消息数
	 * @param user001 用户ID
	 * @return
	 * @throws Exception
	 */
	String selectStudyNum(String user001) throws Exception;

	/**
	 * 门户 最新课程列表
	 * @param user001 用户ID
	 * @return
	 * @throws Exception
	 */
	List selectNewestCourseList(String user001) throws Exception;

	/**
	 * 门户 最热课程列表
	 * @param user001 用户ID
	 * @return
	 * @throws Exception
	 */
	List selectHottestCourseList(String user001) throws Exception;

}
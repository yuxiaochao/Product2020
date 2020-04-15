package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.product2020.entity.StudyTLearnactivity;

import java.util.List;

/**
 * <p>
 * ${table.comment} 服务类
 * </p>
 *
 * @author Chenrui
 * @since 2017-08-13
 */
public interface IStudyTLearnactivityService extends IService<StudyTLearnactivity> {

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

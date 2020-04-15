package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.product2020.entity.ExamTTesttopic;

import java.util.List;

/**
 * <p>
 * ${table.comment} 服务类
 * </p>
 *
 * @author Chenrui
 * @since 2017-08-13
 */
public interface IExamTTesttopicService extends IService<ExamTTesttopic> {

	/**
	 * 门户 在线考试消息
	 * @param user001 用户ID
	 * @return
	 * @throws Exception
	 */
	String selectTestPaperNum(String user001) throws Exception;

	/**
	 * 门户 最近考试列表
	 * @param user001 用户ID
	 * @return
	 * @throws Exception
	 */
	List selectRecentExamList(String user001) throws Exception;
	
}

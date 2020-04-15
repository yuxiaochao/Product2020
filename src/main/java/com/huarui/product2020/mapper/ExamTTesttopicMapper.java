package com.huarui.product2020.mapper;

import com.huarui.product2020.entity.ExamTTesttopic;

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
public interface ExamTTesttopicMapper extends BaseMapper<ExamTTesttopic> {

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
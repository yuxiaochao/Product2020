package com.huarui.product2020.mapper;

import com.huarui.product2020.entity.ExamTTesttactic;

import java.util.ArrayList;
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
public interface ExamTTesttacticMapper extends BaseMapper<ExamTTesttactic> {

	void insertBatch(ArrayList<ExamTTesttactic> examTTesttacticList);

	List<ExamTTesttactic> findTestPaperByExamId(String ids);

}
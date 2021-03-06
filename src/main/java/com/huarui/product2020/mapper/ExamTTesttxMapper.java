package com.huarui.product2020.mapper;

import com.huarui.product2020.entity.ExamTTesttx;

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
public interface ExamTTesttxMapper extends BaseMapper<ExamTTesttx> {

	List<ExamTTesttx> findByExamId(String ids);

}
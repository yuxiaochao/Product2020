package com.huarui.product2020.mapper;

import com.huarui.product2020.entity.ExamTExergrade;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  * ${table.comment} Mapper 接口
 * </p>
 *
 * @author Chenrui
 * @since 2017-08-13
 */
public interface ExamTExergradeMapper extends BaseMapper<ExamTExergrade> {

	/**
	 * 根据抽题id更新成绩状态
	 */
	public Integer updateExergradeById(String exsa001);
}
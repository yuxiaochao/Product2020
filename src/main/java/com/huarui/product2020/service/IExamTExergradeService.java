package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.product2020.entity.ExamTExergrade;

/**
 * <p>
 * ${table.comment} 服务类
 * </p>
 *
 * @author Chenrui
 * @since 2017-08-13
 */
public interface IExamTExergradeService extends IService<ExamTExergrade> {
	/**
	 * 根据抽题id更新成绩状态
	 */
	public Integer updateExergradeById(String exsa001);
	
}

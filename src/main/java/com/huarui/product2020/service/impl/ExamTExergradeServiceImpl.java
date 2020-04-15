package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.product2020.entity.ExamTExergrade;
import com.huarui.product2020.mapper.ExamTExergradeMapper;
import com.huarui.product2020.service.IExamTExergradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * ${table.comment} 服务实现类
 * </p>
 *
 * @author Chenrui
 * @since 2017-08-13
 */
@Service
public class ExamTExergradeServiceImpl extends ServiceImpl<ExamTExergradeMapper, ExamTExergrade> implements IExamTExergradeService {
	
	@Autowired
	private ExamTExergradeMapper exgradeMapper;
	/**
	 * 根据抽题id更新成绩状态
	 */
	public Integer updateExergradeById(String exsa001) {
		return exgradeMapper.updateExergradeById(exsa001);
	}

}

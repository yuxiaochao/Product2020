package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.product2020.entity.ExamTExamanswertopic;
import com.huarui.product2020.mapper.ExamanswertopicMapper;
import com.huarui.product2020.service.ExamanswertopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamanswertopicServiceImpl extends ServiceImpl<ExamanswertopicMapper, ExamTExamanswertopic> implements ExamanswertopicService {
	@Autowired
	private ExamanswertopicMapper examanswertopicDAO;
	
	/**
	 * 批量插入对象
	 * 
	 * @param list
	 * @return
	 */
	public boolean insertBatch(List list){
		boolean flag = false;
		long n = examanswertopicDAO.insertBatch(list);
		if(n > 0) {
			flag = true;
		}
		return flag;
	}

}

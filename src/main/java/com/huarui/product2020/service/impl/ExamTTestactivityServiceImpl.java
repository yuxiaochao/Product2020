package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.common.utils.IPage;
import com.huarui.product2020.entity.ExamTTestactivity;
import com.huarui.product2020.mapper.ExamTTestactivityMapper;
import com.huarui.product2020.service.IExamTTestactivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * ${table.comment} 服务实现类
 * </p>
 *
 * @author Chenrui
 * @since 2017-08-13
 */
@Service
public class ExamTTestactivityServiceImpl extends ServiceImpl<ExamTTestactivityMapper, ExamTTestactivity> implements IExamTTestactivityService {

	@Autowired
	private ExamTTestactivityMapper examMapper;
	
	public IPage selectExamHistoryPage(IPage page , Map arg) throws Exception {
		page.setRecords(examMapper.selectExamHistoryPage(page,arg));
        return page;
	}

	public IPage selectStudyHistoryPage(IPage page , String user001) throws Exception {
		page.setRecords(examMapper.selectStudyHistoryPage(page,user001));
        return page;
	}

	public Map selectExamHistoryInfo(String user001, String tact001) throws Exception {
		return examMapper.selectExamHistoryInfo(user001,tact001);
	}

	public IPage selectExamHistoryDetailsPage(IPage page, String user001, String tact001) throws Exception {
		page.setRecords(examMapper.selectExamHistoryDetailsPage(page,user001,tact001));
        return page;
	}

	public Map studyHistoryCourseInfo(Map arg) throws Exception {
		return examMapper.studyHistoryCourseInfo(arg) ;
	}

	public List courseStudyHistoryList(Map arg) throws Exception {
		return examMapper.courseStudyHistoryList(arg);
	}

	
	
}

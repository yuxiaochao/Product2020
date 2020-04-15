package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.product2020.entity.StudyTLearnactivity;
import com.huarui.product2020.mapper.StudyTLearnactivityMapper;
import com.huarui.product2020.service.IStudyTLearnactivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * ${table.comment} 服务实现类
 * </p>
 *
 * @author Chenrui
 * @since 2017-08-13
 */
@Service
public class StudyTLearnactivityServiceImpl extends ServiceImpl<StudyTLearnactivityMapper, StudyTLearnactivity> implements IStudyTLearnactivityService {

	@Autowired
	private StudyTLearnactivityMapper studyMapper;
	
	public String selectStudyNum(String user001) throws Exception {
		return studyMapper.selectStudyNum(user001);
	}

	public List selectNewestCourseList(String user001) throws Exception {
		return studyMapper.selectNewestCourseList(user001);
	}

	public List selectHottestCourseList(String user001) throws Exception {
		return studyMapper.selectHottestCourseList(user001);
	}
	
}

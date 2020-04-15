package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.common.utils.IPage;
import com.huarui.product2020.entity.StudyTUsernote;
import com.huarui.product2020.mapper.StudyTUsernoteMapper;
import com.huarui.product2020.service.IStudyTUsernoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class StudyTUsernoteServiceImpl extends ServiceImpl<StudyTUsernoteMapper, StudyTUsernote> implements IStudyTUsernoteService {

	@Autowired
	private StudyTUsernoteMapper noteMapper;
	
	public IPage selectNoteListByUser(IPage page , Map args) throws Exception {
		page.setRecords(noteMapper.selectNoteListByUser(page,args));
		return page;
	}

	public IPage selectMyNoteListByUser(IPage page , Map args) throws Exception {
		page.setRecords(noteMapper.selectMyNoteListByUser(page ,args));
		return page;
	}

	public IPage selectShareNoteListByUser(IPage page, Map args) throws Exception {
		page.setRecords(noteMapper.selectShareNoteListByUser(page,args));
		return page;
	}
	
}

package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.common.utils.IPage;
import com.huarui.product2020.entity.StudyTUsernote;

import java.util.Map;

/**
 * <p>
 * ${table.comment} 服务类
 * </p>
 *
 * @author Chenrui
 * @since 2017-08-13
 */
public interface IStudyTUsernoteService extends IService<StudyTUsernote> {

	/**
	 * 我的 笔记列表
	 * @param args 用户ID
	 * @return
	 * @throws Exception
	 */
	IPage selectNoteListByUser(IPage page , Map args) throws Exception;

	/**
	 * 我的 我的笔记列表
	 * @param noteListPage
	 * @param args
	 * @return
	 * @throws Exception
	 */
	IPage selectMyNoteListByUser(IPage noteListPage, Map args) throws Exception;

	/**
	 * 我的 共享笔记列表
	 * @param noteListPage
	 * @param args
	 * @return
	 * @throws Exception
	 */
	IPage selectShareNoteListByUser(IPage noteListPage, Map args) throws Exception;
	
}

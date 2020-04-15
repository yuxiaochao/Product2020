package com.huarui.product2020.mapper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.huarui.common.utils.IPage;
import com.huarui.product2020.entity.StudyTUsernote;

/**
 * <p>
  * ${table.comment} Mapper 接口
 * </p>
 *
 * @author Chenrui
 * @since 2017-08-13
 */
public interface StudyTUsernoteMapper extends BaseMapper<StudyTUsernote> {

	/**
	 * 我的笔记 笔记列表
	 * @param args 用户ID
	 * @return
	 * @throws Exception
	 */
	List selectNoteListByUser(Pagination page,Map args) throws Exception;

	/**
	 * 我的 我的笔记列表
	 * @param noteListPage
	 * @param user001 用户ID
	 * @return
	 * @throws Exception
	 */
	List selectMyNoteListByUser(IPage noteListPage, Map args) throws Exception;

	/**
	 * 我的 共享笔记列表
	 * @param noteListPage
	 * @param user001
	 * @return
	 * @throws Exception
	 */
	List selectShareNoteListByUser(IPage noteListPage, Map args) throws Exception;

}
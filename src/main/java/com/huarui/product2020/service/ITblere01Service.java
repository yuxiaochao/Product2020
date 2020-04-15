package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.product2020.entity.Tblere01;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author su
 * @since 2020-02-13
 */
public interface ITblere01Service extends IService<Tblere01> {
	/**
	 * 查询用户的课程学习进度
	 * @param lere0103 用户id
	 * @return
	 */
	List<Tblere01> selectUserProgressCourse(String lere0103);
	/**
	 * 保存用户的课程学习进度
	 * @param tblere01List
	 */
	void setUserProgressCourse(String userid, List<Tblere01> tblere01List);
}

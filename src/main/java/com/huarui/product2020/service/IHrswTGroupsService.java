package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.product2020.entity.HrswTGroups;
import com.huarui.product2020.entity.HrswTUserGroup;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author panlei
 * @since 2017-09-05
 */
public interface IHrswTGroupsService extends IService<HrswTGroups> {
	
	/**
	 * 根据群组id获取群组信息
	 */
	public HrswTGroups findGroupsById(HrswTGroups groups);
	
	/**
	 * 添加群组
	 */
	public int insertGroups(HrswTGroups groups);
	
	/**
	 * 根据主键id更新群组
	 */
	public int updateGroupsById(HrswTGroups groups);
	
	/**
	 * 群组添加人员
	 */
	public int insertUserToGroup(List<HrswTUserGroup> userGroup);
}

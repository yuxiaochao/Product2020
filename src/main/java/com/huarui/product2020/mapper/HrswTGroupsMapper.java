package com.huarui.product2020.mapper;

import java.util.List;

import com.huarui.product2020.entity.HrswTGroups;
import com.huarui.product2020.entity.HrswTUserGroup;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author panlei
 * @since 2017-09-05
 */
public interface HrswTGroupsMapper extends BaseMapper<HrswTGroups> {

	/**
	 * 根据群组id获取群组信息
	 */
	public HrswTGroups findGroupsById(HrswTGroups groups);
	
	/**
	 * 添加群组
	 */
	public int insertGroups(HrswTGroups groups);
	
	/**
	 * 更新群组
	 */
	public int updateGroupsById(HrswTGroups groups);
	
	/**
	 * 群组添加人员
	 */
	public int insertUserToGroup(List<HrswTUserGroup> userGroup);
}
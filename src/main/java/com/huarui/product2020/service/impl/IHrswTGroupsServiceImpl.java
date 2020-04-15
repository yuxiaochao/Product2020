package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.product2020.entity.HrswTGroups;
import com.huarui.product2020.entity.HrswTUserGroup;
import com.huarui.product2020.mapper.HrswTGroupsMapper;
import com.huarui.product2020.service.IHrswTGroupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IHrswTGroupsServiceImpl extends ServiceImpl<HrswTGroupsMapper,HrswTGroups > implements IHrswTGroupsService{
	
	@Autowired
	private HrswTGroupsMapper groupsMapper;
	
	/**
	 * 根据群组id获取群组信息
	 */
	public HrswTGroups findGroupsById(HrswTGroups groups){
		return groupsMapper.findGroupsById(groups);
	}
	
	/**
	 * 添加群组
	 */
	public int insertGroups(HrswTGroups groups){
		return groupsMapper.insertGroups(groups);
	}
	
	/**
	 * 更新群组
	 */
	public int updateGroupsById(HrswTGroups groups){
		return groupsMapper.updateGroupsById(groups);
	}
	
	/**
	 * 群组添加人员
	 */
	public int insertUserToGroup(List<HrswTUserGroup> userGroup){
		return groupsMapper.insertUserToGroup(userGroup);
	}
	
}

package com.huarui.product2020.service.impl;

import com.huarui.common.utils.IPage;
import com.huarui.product2020.mapper.GroupMapper;
import com.huarui.product2020.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GroupServiceImpl implements GroupService{
	
	@Autowired
	private GroupMapper groupMapper;
	
	
	/**
	 * 获取群组列表
	 */
	public List<Map<String, Object>> findGroupList(IPage page, Map<String, Object> map){
		return groupMapper.findGroupList(page,map);
	}
	
	/**
	 * 根据群组key获取群组成员
	 */
	public List<Map<String, Object>> findUserGroupById(Map<String, Object> map){
		return groupMapper.findUserGroupById(map);
	}
	
	/**
	 * 删除群组成员(通过群ID和用户ID)
	 */
	public int deleteMemberToMyGroup(Map<String, Object> map){
		return groupMapper.deleteMemberToMyGroup(map);
	}
	
	/**
	 * 通过群ID删除群组成员
	 */
	public int deleteGroupMemberById(Map<String, Object> map){
		return groupMapper.deleteGroupMemberById(map);
	}
	
	/**
	 * 通过群ID删除群
	 */
	public int deleteGroupById(Map<String, Object> map){
		return groupMapper.deleteGroupById(map);
	}
	
	/**
	 *  查询群成员信息
	 */
	public List<Map<String, Object>> queryGroupMemberInfo(Map<String, Object> map){
		return groupMapper.queryGroupMemberInfo(map);
	}
	
	/**
	 *  查询群信息
	 */
	public Map<String, Object> queryGroupInfo(Map<String, Object> map){
		return groupMapper.queryGroupInfo(map);
	}
	
	/**
	 * 查询我的所有群
	 */
	public Map<String, Object> queryAllMyGroupMap(Map<String, Object> map){
		return groupMapper.queryAllMyGroupMap(map);
	}
	
	/**
	 * 查询不在当前群中的好友
	 */
	public List<Map<String, Object>> queryMemberNotInGroup(Map<String, Object> map){
		return groupMapper.queryMemberNotInGroup(map);
	}
	
	/**
	 * 查询不在当前群中科室成员
	 */
	public List<Map<String, Object>> queryDepartmentNotInGroup(Map<String, Object> map){
		return groupMapper.queryDepartmentNotInGroup(map);
	}
	
	/**
	 * 查询群公告
	 */
	public List<Map<String, Object>> queryNoticeList(Map<String, Object> map){
		return groupMapper.queryNoticeList(map);
	}
	
	/**
	 * 查询群公告详情
	 */
	public Map<String, Object> queryNoticeDetails(Map<String, Object> map){
		return groupMapper.queryNoticeDetails(map);
	}
	
	/**
	 * 发布群公告
	 */
	public int publishGroupNotice(Map<String, Object> map){
		return groupMapper.publishGroupNotice(map);
	}
	
	/**
	 * 修改群公告
	 */
	public int editGroupNotice(Map<String, Object> map){
		return groupMapper.editGroupNotice(map);
	}
	
	/**
	 * 删除群公告
	 */
	public int deleteGroupNotice(Map<String, Object> map){
		return groupMapper.deleteGroupNotice(map);
	}
	
	/**
	 * 群公告置顶
	 */
	public int supportNotice(Map<String, Object> map){
		return groupMapper.supportNotice(map);
	}
	
	/**
	 * 群聊——根据关键字查询好友
	 */
	public List<Map<String, Object>> queryMyFriends(Map<String, Object> map){
		return groupMapper.queryMyFriends(map);
	}
	
	/**
	 * 群聊——根据关键字查询群
	 */
	public List<Map<String, Object>> queryMyGroups(IPage page, Map<String, Object> map){
		return groupMapper.queryMyGroups(page,map);
	}
	
	/**
	 * 查询用户表中环信注册信息
	 */
	public List<Map<String, Object>> registeredHuanXin(){
		return groupMapper.registeredHuanXin();
	}
	
	/**
	 * 已注册环信
	 */
	public int updateTbuserHuanXin(Map<String, Object> map){
		return groupMapper.updateTbuserHuanXin(map);
	}
	
	/**
	 * Mybatis测试
	 */
	public List<Map<String, Object>> queryUserTest(Map<String, Object> map){
		return groupMapper.queryUserTest(map);
	}

	@Override
	public List findPeopleStstu(IPage page, Map map) throws Exception {
		// TODO Auto-generated method stub
		return groupMapper.findPeopleStstu(page,map);
	}

	@Override
	public List<Map<String, Object>> findGroupList02(Map<String, Object> param) throws Exception {
		// TODO Auto-generated method stub
		return groupMapper.findGroupList02(param);
	}
}

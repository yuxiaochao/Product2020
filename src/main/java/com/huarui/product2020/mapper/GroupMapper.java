package com.huarui.product2020.mapper;

import java.util.List;
import java.util.Map;

import com.huarui.common.utils.IPage;

public interface GroupMapper {
	
	/**
	 * 群成员 状态
	 * @param map
	 * @return
	 */
	public List findPeopleStstu(IPage page,Map map);
	
	/**
	 * 获取群组列表--分页
	 */
	public List<Map<String,Object>> findGroupList(IPage page,Map<String,Object> param);
	
	/**
	 * 获取群组列表--全部（不分页）
	 */
	public List<Map<String,Object>> findGroupList02(Map<String,Object> param);
	
	/**
	 * 根据群组key获取群组成员
	 */
	public List<Map<String,Object>> findUserGroupById(Map<String,Object> param);
	
	/**
	 * 删除群组成员
	 */
	public int deleteMemberToMyGroup(Map<String,Object> param);
	
	/**
	 * 通过群ID删除群组成员
	 */
	public int deleteGroupMemberById(Map<String,Object> param);
	
	/**
	 * 通过群ID删除群
	 */
	public int deleteGroupById(Map<String,Object> param);
	
	/**
	 *  查询群成员信息
	 */
	public List<Map<String,Object>> queryGroupMemberInfo(Map<String,Object> param);
	
	/**
	 *  查询群信息
	 */
	public Map<String,Object> queryGroupInfo(Map<String,Object> param);
	
	/**
	 *  查询我的所有群
	 */
	public Map<String,Object> queryAllMyGroupMap(Map<String,Object> param);
	
	/**
	 * 查询不在当前群中的好友
	 */
	public List<Map<String,Object>> queryMemberNotInGroup(Map<String,Object> param);
	
	/**
	 * 查询不在当前群中的科室成员
	 */
	public List<Map<String,Object>> queryDepartmentNotInGroup(Map<String,Object> param);
	
	/**
	 * 查询群公告
	 */
	public List<Map<String,Object>> queryNoticeList(Map<String,Object> param);
	
	/**
	 * 查询群公告详情
	 */
	public Map<String,Object> queryNoticeDetails(Map<String,Object> param);
	
	/**
	 * 发布群公告
	 */
	public int publishGroupNotice(Map<String,Object> param);
	
	/**
	 * 修改群公告
	 */
	public int editGroupNotice(Map<String,Object> param);
	
	/**
	 * 删除群公告
	 */
	public int deleteGroupNotice(Map<String,Object> param);
	
	/**
	 * 群公告置顶
	 */
	public int supportNotice(Map<String,Object> param);
	
	/**
	 * 群聊——根据关键字查询好友
	 */
	public List<Map<String,Object>> queryMyFriends(Map<String,Object> param);
	
	/**
	 * 群聊——根据关键字查询群
	 */
	public List<Map<String,Object>> queryMyGroups(IPage page,Map<String,Object> param);
	
	/**
	 * 查询用户表中环信注册信息
	 */
	public List<Map<String,Object>> registeredHuanXin();
	
	/**
	 * 已注册环信
	 */
	public int updateTbuserHuanXin(Map<String,Object> param);
	
	/**
	 * Mybatis测试
	 */
	public List<Map<String,Object>> queryUserTest(Map<String,Object> param);
}

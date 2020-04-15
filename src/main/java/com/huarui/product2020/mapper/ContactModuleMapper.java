package com.huarui.product2020.mapper;

import java.util.List;
import java.util.Map;

import com.huarui.common.utils.IPage;

public interface ContactModuleMapper {

	
	/**
	 * 查询用户
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> queryUserList(IPage page ,Map<String, Object> map) throws Exception;
	
	/**
	 * 关键字搜索群
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> queryGroupByKeyword(Map<String, Object> map) throws Exception;
	
	/**
	 * 添加申请好友记录
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int addApplyRecord(Map<String, Object> map) throws Exception;
	
	/**
	 * 查询好友申请列表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>>queryApplyRecord(Map<String, Object> map) throws Exception;
	
	/**
	 * 联系人
	 * 查询我对别人的好友申请（我对别人的申请）
	 * @param
	 * @return
	 */
	public List<Map<String, Object>> queryApplicationForAdding(Map<String, Object> map) throws Exception;
	
	/**
	 * 修改好友申请状态
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int updateApplyRecordStatus(Map<String, Object> map) throws Exception;
	
	/**
	 * 点赞好友
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int thumbsUp(Map<String, Object> map) throws Exception;
	
	/**
	 * 同意成为好友
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int agreeBecomeFriend(Map<String, Object> map) throws Exception;
	
	/**
	 * 查询好友详情信息
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object>queryFriendInfo(Map<String, Object> map) throws Exception;
	
	/**
	 * 查看该成员是否在自己的好友中
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>>checkMyFriends(Map<String, Object> map) throws Exception;
	
	/**
	 * 删除好友
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int deleteFriends(Map<String, Object> map) throws Exception;
	
	
	
	
	
	/**
	 * 联系人
	 * 获取好友列表
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> queryFrienfList(Map<String, Object> map) throws Exception;
	
	/**
	 * 群聊
	 * 查询我的群组
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> queryMyGroupList(Map<String, Object> map) throws Exception;
	
	/**
	 * 群聊
	 * 根据群组key获取群组成员
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> queryGroupMemberById(Map<String, Object> map) throws Exception;
	
	/**
	 * 通讯录打开机构列表——根据机构id查询该机构下的子机构，默认显示2级机构
	 * @param
	 * @return
	 */
	public List<Map<String, Object>> queryOrganListById(IPage page,Map<String, Object> map) throws Exception;
	
	/**
	 * 通讯录打开机构列表——查询机构下人员信息
	 * @param
	 * @return
	 */
	public List<Map<String, Object>> queryUserinfoByOrganid(IPage page,Map<String, Object> map) throws Exception;
	
	
	/**
	 * 通讯录——常用联系人
	 * @param
	 * @return
	 */
	public List<Map<String, Object>> topContacts(IPage page,Map<String, Object> map) throws Exception;
	
	/**
	 * 聊天——保存聊天的消息（包括聊天、群聊、系统消息等）
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int saveTheMessage(Map<String, Object> map) throws Exception;
	
	/**
	 * 聊天——统计聊天数据
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public void statisticalChatData(Map<String, Object> map) throws Exception;
	
	/**
	 * 聊天——查看聊天的历史记录
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List chatRecord(IPage page,Map<String, Object> map) throws Exception;
	
	/**
	 * 聊天——查看系统消息
	 * @param
	 * @return
	 */
	public List<Map<String, Object>> systemMessagesList(IPage page,Map<String, Object> map) throws Exception;

	/**
	 * 聊天——系统消息-删除某一条
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int delectOneSystemMessages(Map map) throws Exception;
}

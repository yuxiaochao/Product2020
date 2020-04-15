package com.huarui.product2020.service.impl;

import com.huarui.common.utils.IPage;
import com.huarui.common.utils.ThreadUtils;
import com.huarui.product2020.mapper.ContactModuleMapper;
import com.huarui.product2020.service.ContactModuleService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ContactModuleServiceImpl implements ContactModuleService {

	@Autowired
	private ContactModuleMapper contactMapper;

	/**
	 * 通过用户姓名模糊查询用户
	 */
	public IPage queryUserList(IPage page, Map<String, Object> map) throws Exception {
		List<Map<String, Object>> userList = contactMapper.queryUserList(page, map);
		if (userList != null && userList.size() > 0) {
			for (int i = 0; i < userList.size(); i++) {
				Map userMap = userList.get(i);
				String friendid = ObjectUtils.toString(userMap.get("USER001"));
				map.put("friendID", friendid);
				// 查看该成员是否在自己的好友中
				List myFriendList = contactMapper.checkMyFriends(map);
				if (myFriendList != null && myFriendList.size() > 0) {
					// 是自己的好友
					userMap.put("ismyfriend", "1");
				} else {
					String myID = ObjectUtils.toString(map.get("user001"));
					if (friendid.equals(myID)) {
						// 自己
						userMap.put("ismyfriend", "2");
					} else {
						// 不是自己的好友
						userMap.put("ismyfriend", "0");
					}
				}
			}
		}
		page.setRecords(userList);
		return page;
	}

	/**
	 * 关键字搜索群
	 */
	public List<Map<String, Object>> queryGroupByKeyword(Map<String, Object> map) throws Exception {
		return contactMapper.queryGroupByKeyword(map);
	}

	/**
	 * 添加好友 发起好友申请
	 */
	public int addApplyRecord(Map<String, Object> map) throws Exception {
		return contactMapper.addApplyRecord(map);
	}

	/**
	 * 查询好友申请列表
	 */
	public List<Map<String, Object>> queryApplyRecord(Map<String, Object> map) throws Exception {
		return contactMapper.queryApplyRecord(map);
	}

	/**
	 * 联系人 查询我对别人的好友申请（我对别人的申请）
	 * 
	 * @param
	 * @return
	 */
	public List<Map<String, Object>> queryApplicationForAdding(Map<String, Object> map) throws Exception {
		return contactMapper.queryApplicationForAdding(map);
	}

	/**
	 * 添加申请好友记录
	 */
	public int agreeBecomeFriend(Map<String, Object> map) throws Exception {
		String agreestate = ObjectUtils.toString(map.get("appl005"));
		// 修改好友申请状态
		contactMapper.updateApplyRecordStatus(map);
		// 好友申请为 “同意”
		int status = 1;
		if ("1".equals(agreestate)) {
			// 同意加为好友
			map.put("uuid", ThreadUtils.getRTex().getUUID());
			status = contactMapper.agreeBecomeFriend(map);
		}
		return status;
	}

	/**
	 * 添加申请好友记录
	 */
	public int thumbsUp(Map<String, Object> map) throws Exception {
		int status = 1;
		status = contactMapper.thumbsUp(map);
		return status;
	}

	/**
	 * 查询好友详情信息
	 */
	public Map<String, Object> queryFriendInfo(Map<String, Object> map) throws Exception {
		return contactMapper.queryFriendInfo(map);
	}

	/**
	 * 查看该成员是否在自己的好友中
	 */
	public List<Map<String, Object>> checkMyFriends(Map<String, Object> map) throws Exception {
		return contactMapper.checkMyFriends(map);
	}

	/**
	 * 删除好友
	 */
	public int deleteFriends(Map<String, Object> map) throws Exception {
		String cont001s = ObjectUtils.toString(map.get("cont001"));
		String[] cont001Array = cont001s.split(",");
		int success = 1;
		for (int i = 0; i < cont001Array.length; i++) {
			String cont001 = cont001Array[i];
			Map param = new HashMap();
			param.put("cont001", cont001);
			success = contactMapper.deleteFriends(param);
		}

		return success;
	}

	/**
	 * 联系人 获取好友列表
	 */
	public List<Map<String, Object>> queryFrienfList(Map<String, Object> map) throws Exception {
		return contactMapper.queryFrienfList(map);
	}

	/**
	 * 群聊 查询我的群组
	 */
	public List<Map<String, Object>> queryMyGroupList(Map<String, Object> map) throws Exception {
		return contactMapper.queryMyGroupList(map);
	}

	/**
	 * 群聊 根据群组key获取群组成员
	 */
	public List<Map<String, Object>> queryGroupMemberById(Map<String, Object> map) throws Exception {
		return contactMapper.queryGroupMemberById(map);
	}

	/**
	 * 通讯录打开机构列表——根据机构id查询该机构下的子机构，默认显示2级机构
	 */
	public List<Map<String, Object>> queryOrganListById(IPage page, Map<String, Object> map) throws Exception {
		return contactMapper.queryOrganListById(page, map);
	}

	/**
	 * 通讯录打开机构列表——查询机构下人员信息
	 */
	public List<Map<String, Object>> queryUserinfoByOrganid(IPage page, Map<String, Object> map) throws Exception {
		return contactMapper.queryUserinfoByOrganid(page, map);
	}

	/**
	 * 通讯录——常用联系人
	 * 
	 * @param
	 * @return
	 */
	public List<Map<String, Object>> topContacts(IPage page, Map<String, Object> map) throws Exception {
		return contactMapper.topContacts(page, map);
	}

	/**
	 * 聊天——保存聊天的消息（包括聊天、群聊、系统消息等）
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int saveTheMessage(Map<String, Object> map) throws Exception {
		return contactMapper.saveTheMessage(map);
	}

	/**
	 * 聊天——统计聊天数据
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public void statisticalChatData(Map<String, Object> map) throws Exception {
		contactMapper.statisticalChatData(map);
	}

	/**
	 * 聊天——查看系统消息
	 * 
	 * @param
	 * @return
	 */
	public List<Map<String, Object>> systemMessagesList(IPage page, Map<String, Object> map) throws Exception {
		return contactMapper.systemMessagesList(page, map);
	}

	@Override
	public List chatRecord(IPage page, Map<String, Object> map) throws Exception {
		return contactMapper.chatRecord(page, map);
	}

	@Override
	public boolean delectOneSystemMessages(Map map) throws Exception {
		// TODO Auto-generated method stub
		  boolean flage=false;
		int essages = contactMapper.delectOneSystemMessages(map);
		 if(essages==1){
			 flage=true;
		 }else {
			 flage=false;
		 }
		 
		 return flage;
	}
}

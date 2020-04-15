package com.huarui.product2020.service.impl;

import com.huarui.common.utils.IPage;
import com.huarui.product2020.mapper.UserDiscussMapper;
import com.huarui.product2020.service.UserDiscussService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserDiscussServiceImpl implements UserDiscussService{
	
	@Autowired
	private UserDiscussMapper discussMapper;
	
	
	/**
	 * 吐槽一下
	 * 查询吐槽列表
	 */
	public IPage queryDiscussList(IPage discussList, Map<String, Object> map) throws Exception {
		List<Map<String, Object>> list = discussMapper.queryDiscussList(discussList,map);
		String tpdsids = "";
		if(list != null && list.size()>0) {
			for(int i=0;i<list.size();i++) {
				Map discussMap = list.get(i);
				String tpdsid = ObjectUtils.toString(discussMap.get("TPDSID"));
				tpdsids += tpdsid;
				if(i<list.size()-1) {
					tpdsids += ",";
				}
			}
		}
		String[] tpdsidArray = tpdsids.split(",");
		map.put("tpdsidArray", tpdsidArray);
		List<Map<String, Object>> replyList = discussMapper.queryDiscussReplys(map);
		
		
		//评论列表
		for(int i=0;i<list.size();i++) {
			Map discussMap = list.get(i);
			String tpdsid = ObjectUtils.toString(discussMap.get("TPDSID"));
			
			List<Map<String, Object>> replyL = new ArrayList();
			//回复列表
			for(int j=0;j<replyList.size();j++) {
				Map replyMap = replyList.get(j);
				String parentid = ObjectUtils.toString(replyMap.get("PARENTID"));
				//即 评论回复对应评论ID
				if(tpdsid.equals(parentid)) {
					replyL.add(replyMap);
					//discussMap.put("reply"+j, replyMap);
				}
			}
			discussMap.put("reply", replyL);
//			replyL.add(i, discussMap);
//			list.addAll(replyL);
		}
//			System.out.println(replyL);
		
		discussList.setRecords(list);
		return discussList;
	}
	
	/**
	 * 吐槽一下
	 * 发布吐槽 
	 */
	public int publishDiscuss(Map<String, Object> map) throws Exception {
		return discussMapper.publishDiscuss(map);
	}
	
	/**
	 * 吐槽一下
	 * 发布吐槽回复内容 
	 */
	public int publishReplyDiscuss(Map<String, Object> map) throws Exception {
		return discussMapper.publishReplyDiscuss(map);
	}
	
	/**
	 * 吐槽一下
	 * 查询吐槽回复列表
	 */
	public List<Map<String, Object>> queryDiscussReplyList(Map<String, Object> map) throws Exception {
		return discussMapper.queryDiscussReplyList(map);
	}
	
	/**
	 * 吐槽一下
	 * 点赞 
	 */
	public int addDiscussEnjoy(Map<String, Object> map) throws Exception {
		return discussMapper.addDiscussEnjoy(map);
	}
	
	/**
	 * 吐槽一下
	 * 取消赞 
	 */
	public int cancelDiscussEnjoy(Map<String, Object> map) throws Exception {
		return discussMapper.cancelDiscussEnjoy(map);
	}
	
	/**
	 * 吐槽一下
	 * 插入点赞人的记录 
	 */
	public int insertDiscussEnjoyUser(Map<String, Object> map) throws Exception {
		return discussMapper.insertDiscussEnjoyUser(map);
	}
	
	/**
	 * 查询该评论下的点赞人的名字  
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> queryEnjoyUserNameList(String tpdsid) throws Exception {
		return discussMapper.queryEnjoyUserNameList(tpdsid);
	}
	
	/**
	 * 查询点赞数量和当前用户的点赞状态，分别放入结果中
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> queryEnjoyStatusNameList(String tpdsid, String userid) throws Exception {
		return discussMapper.queryEnjoyStatusNameList(tpdsid,userid);
	}

	@Override
	public void deleteDiscussList(Map<String, Object> map) throws Exception {
		discussMapper.deleteDiscussList(map);
	}
    
	@Override
	public void deleteEnjoyList(Map<String, Object> map) throws Exception {
		discussMapper.deleteEnjoyList(map);
		
	}
	
}

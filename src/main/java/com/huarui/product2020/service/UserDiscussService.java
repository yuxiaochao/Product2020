package com.huarui.product2020.service;

import com.huarui.common.utils.IPage;

import java.util.List;
import java.util.Map;

public interface UserDiscussService {

	/**
	 * 吐槽一下
	 * 查询吐槽列表
	 * @param userid
	 * @return
	 * @throws Exception
	 */
	public IPage queryDiscussList(IPage discussList, Map<String, Object> map) throws Exception;
	
	/**
	 * 吐槽一下
	 * 发布吐槽
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int publishDiscuss(Map<String, Object> map) throws Exception;
	
	/**
	 * 吐槽一下
	 * 发布吐槽回复
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int publishReplyDiscuss(Map<String, Object> map) throws Exception;
	
	/**
	 * 吐槽一下
	 * 查询吐槽回复列表
	 * @param userid
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> queryDiscussReplyList(Map<String, Object> map) throws Exception;
	
	/**
	 * 吐槽一下
	 * 点赞
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int addDiscussEnjoy(Map<String, Object> map) throws Exception;
	
	/**
	 * 吐槽一下
	 * 取消赞
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int cancelDiscussEnjoy(Map<String, Object> map) throws Exception;
	
	/**
	 * 吐槽一下
	 * 插入点赞人的记录
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int insertDiscussEnjoyUser(Map<String, Object> map) throws Exception;
	
	/**
	 * 吐槽一下
	 * 查询评论下的点赞人的名字
	 * @param userid
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> queryEnjoyUserNameList(String tpdsid) throws Exception;
	
	/**
	 * 吐槽一下
	 * 查询点赞数量和当前用户的点赞状态，分别放入结果中
	 * @param userid
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> queryEnjoyStatusNameList(String tpdsid, String userid) throws Exception;
	
	public  void  deleteEnjoyList(Map<String, Object> map) throws Exception;
    
	public  void  deleteDiscussList(Map<String, Object> map) throws Exception;

}

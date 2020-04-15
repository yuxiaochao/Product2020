package com.huarui.common.web;

import com.huarui.common.utils.RedisUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseController {

	@Autowired
	private RedisUtil redisUtil;
	
	/**
	 * 日志对象
	 */
	protected Logger logger = LogManager.getLogger(BaseController.class);
	
	/**
	 * 成功
	 */
	public static final String SUCCESS = "SUCCESS";
	/**
	 * 失败
	 */
	public static final String FAIL = "FAIL";
	
	/**
	 * 序号
	 */
	private int serialNumber;
	
	
	/**
	 * 建立Tree节点
	 * @param text
	 * @param id
	 * @param pid
	 * @param leaf
	 * @param config
	 * @return
	 */
	public Map<String, Object> getTreeNode(String text, String id, String pid, Boolean leaf, Boolean isOpen, String config) {
		Map<String, Object> treeMap = new HashMap<String, Object>();
		treeMap.put("id", id);
		treeMap.put("name", text);
		treeMap.put("title", text);
		treeMap.put("pid", pid);
		treeMap.put("tid", id);
		treeMap.put("isParent", leaf);
		treeMap.put("open", isOpen);
		treeMap.put("config", config);
		return treeMap;
	}
	
	/**
	 * 建立Tree节点
	 * @param text
	 * @param id
	 * @param pid
	 * @param config
	 * @return
	 */
	public Map<String, Object> getTreeNode(String text, String id, String pid, String config) {
		Map<String, Object> treeMap = new HashMap<String, Object>();
		treeMap.put("id", id);
		treeMap.put("name", text);
		treeMap.put("title", text);
		treeMap.put("pId", pid);
		treeMap.put("config", config);
		return treeMap;
	}

	public int getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	
}

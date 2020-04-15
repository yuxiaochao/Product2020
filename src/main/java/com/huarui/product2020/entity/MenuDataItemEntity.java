package com.huarui.product2020.entity;

import java.io.Serializable;
import java.util.List;


public class MenuDataItemEntity implements Serializable {

	private static final long serialVersionUID = -1229472039987944413L;
	
	/**
	 * 主键
	 */
	private String id;
	
	/**
	 * 父id
	 */
	private String parentId;
	
	/**
	 * 菜单key
	 */
	private String key;

	/**
	 * 父菜单key
	 */
	private String parentKey;
	
	/**
	 * 菜单名称
	 */
	private String name;

	/**
	 * 父菜单名称
	 */
	private String parentName;
	
	/**
	 * 菜单路径
	 */
	private String path;
	
	
	/**
	 * 菜单图标
	 */
	private String icon;
	
	
	/**
	 * 子菜单数据
	 */
	private List<MenuDataItemEntity> children;
	
	/**
	 * 菜单角色
	 */
	private List<String> authority;
	
	private String chidrenName;

	private String userid;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	


	public List<String> getAuthority() {
		return authority;
	}

	public void setAuthority(List<String> authority) {
		this.authority = authority;
	}

	public List<MenuDataItemEntity> getChildren() {
		return children;
	}

	public void setChildren(List<MenuDataItemEntity> children) {
		this.children = children;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getChidrenName() {
		return chidrenName;
	}

	public void setChidrenName(String chidrenName) {
		this.chidrenName = chidrenName;
	}

	public String getParentKey() {
		return parentKey;
	}

	public void setParentKey(String parentKey) {
		this.parentKey = parentKey;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
}



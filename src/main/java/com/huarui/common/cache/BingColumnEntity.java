package com.huarui.common.cache;

import com.huarui.common.constant.MappingEnumConstant.DataModel;
import com.huarui.common.constant.MappingEnumConstant.SortType;


/**
 * 绑定数据的实体类
 * 
 * @author baiyu
 *
 */
public class BingColumnEntity {

	/**
	 * 显示名称
	 */
	private String displayName;

	/**
	 * 对应的别名
	 */
	private String aliasName;
	/**
	 * 对应属性名称
	 */
	private String dataName;

	/**
	 * excel显示名称
	 */
	private String excelDisplayName;

	/**
	 * 隐藏类型
	 */
	private String hideType = "";

	/**
	 * 搜索类型 如果为 disable 禁用排序 否则启用排序
	 */
	private String sortType = SortType.DISABLE.toString();
	/**
	 * 顺序号
	 */
	private int order = 0;

	/**
	 * 设置列固定宽度
	 */
	private int fixedWidth = 0;

	/**
	 * 字段是否可见
	 */
	private boolean visible = true;

	/**
	 * 数据类型
	 */
	private String dataModel = DataModel.NONE.toString();



	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getAliasName() {
		return aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}

	public String getDataName() {
		return dataName;
	}

	public void setDataName(String dataName) {
		this.dataName = dataName;
	}

	public String getHideType() {
		return hideType;
	}

	public void setHideType(String hideType) {
		this.hideType = hideType;
	}

	public String getSortType() {
		return sortType;
	}

	public void setSortType(String sortType) {
		this.sortType = sortType;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public int getFixedWidth() {
		return fixedWidth;
	}

	public void setFixedWidth(int fixedWidth) {
		this.fixedWidth = fixedWidth;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public String getDataModel() {
		return dataModel;
	}

	public void setDataModel(String dataModel) {
		this.dataModel = dataModel;
	}


	public String getExcelDisplayName() {
		return excelDisplayName;
	}

	public void setExcelDisplayName(String excelDisplayName) {
		this.excelDisplayName = excelDisplayName;
	}


	public int getOrderNum() {
		return getOrder();
	}

}

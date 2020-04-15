package com.huarui.common.cache;

import java.util.List;

public class BingDataEntity {
	/**
	 * 该列对应的主键字段
	 */
	private String pk;

	/**
	 * 绑定实体类的class名称
	 */
	private String entityClass;

	/**
	 * 实体类绑定的字段
	 */
	private List<BingColumnEntity> bingColumns;

	public String getPk() {
		return pk;
	}

	public void setPk(String pk) {
		this.pk = pk;
	}

	public String getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(String entityClass) {
		this.entityClass = entityClass;
	}

	public List<BingColumnEntity> getBingColumns() {
		return bingColumns;
	}

	public void setBingColumns(List<BingColumnEntity> bingColumns) {
		this.bingColumns = bingColumns;
	}

}
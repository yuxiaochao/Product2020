package com.huarui.common.cache;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 元数据字段描述实体类
 * 
 * @author baiyu
 *
 */
public class FieldProp {

	/**
	 * fied对应实体类的名称
	 */
	private String entityClassName = "";

	/**
	 * 对应属性名称
	 */
	private String fieldName;

	/**
	 * 对应属性的字段类型名称
	 */
	private Class<?> fieldType;

	/**
	 * 是否是主键
	 */
	private boolean isPK;
	/**
	 * 当前列的序号
	 */
	private int order;

	/**
	 * Spring DateTimeFormat注解
	 */
	private DateTimeFormat dateTimeFormat;

	public String getEntityClassName() {
		return entityClassName;
	}

	public void setEntityClassName(String entityClassName) {
		this.entityClassName = entityClassName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public Class<?> getFieldType() {
		return fieldType;
	}

	public void setFieldType(Class<?> fieldType) {
		this.fieldType = fieldType;
	}

	public boolean isPK() {
		return isPK;
	}

	public void setPK(boolean isPK) {
		this.isPK = isPK;
	}


	public DateTimeFormat getDateTimeFormat() {
		return dateTimeFormat;
	}

	public void setDateTimeFormat(DateTimeFormat dateTimeFormat) {
		this.dateTimeFormat = dateTimeFormat;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

}

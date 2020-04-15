package com.huarui.common.cache;

import java.util.List;

/**
 * 实体类元数据描述实体类
 * 
 * @author baiyu
 *
 */
public class EntityProp {
	
	public EntityProp(Class entityClass) {
		if (null != entityClass) {
			setEntityName(entityClass.getSimpleName());
			setEntityClassName(entityClass.getName());
		}
	}

	/**
	 * 实体类名称
	 */
	private String entityName;
	/**
	 * 实体类class名称
	 */
	private String entityClassName;
	/**
	 * 该列对应的主键字段
	 */
	private String pk;

	/**
	 * 实体类字段描述列表
	 */
	private List<FieldProp> fieldProps;

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getEntityClassName() {
		return entityClassName;
	}

	public void setEntityClassName(String entityClassName) {
		this.entityClassName = entityClassName;
	}

	public String getPk() {
		return pk;
	}

	public void setPk(String pk) {
		this.pk = pk;
	}


	public List<FieldProp> getFieldProps() {
		return fieldProps;
	}

	public void setFieldProps(List<FieldProp> fieldProps) {
		this.fieldProps = fieldProps;
	}

}

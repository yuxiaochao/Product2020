package com.huarui.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 描述注解 用于描述实体类的名字以及详情，用于显示表格数据
 * 
 * @author Administrator
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
public @interface Column {

	/**
	 * 是否是主键
	 * 
	 * @return
	 */
	boolean isPK() default false;

	/**
	 * 是否可见 默认不可见
	 * 
	 * @return
	 */
	boolean visible() default true;

	/**
	 * 别名 用户其他参数注入
	 * 
	 * @return
	 */
	String aliasName() default "";

	/**
	 * 字段显示名称 默认为原字段名称
	 * 
	 * @return
	 */
	String displayName() default "";

	/**
	 * 字段排序默认0 按照固有顺序
	 * 
	 * @return
	 */
	int order() default 0;

	/**
	 * 设置固定宽度
	 * 
	 * @return
	 */
	int fixedWidth() default 0;

	/**
	 * 查询类型
	 * 
	 * @return
	 */
//	QueryType queryType() default QueryType.NONE;

	/**
	 * 默认排序类型
	 * 
	 * @return
	 */
//	SortType sortType() default SortType.DISABLE;

	/**
	 * 数据模型
	 * 
	 * @return
	 */
//	DataModel dataModel() default DataModel.NONE;

	/**
	 * 隐藏类型
	 * 
	 * @return
	 */
//	ColumnHideType hideType() default ColumnHideType.TABLEPHONE;

	

	/**
	 * 字段描述
	 * 
	 * @return
	 */
	String remark() default "";

	/**
	 * 样式
	 * 
	 * @return
	 */
	String style() default "";

}

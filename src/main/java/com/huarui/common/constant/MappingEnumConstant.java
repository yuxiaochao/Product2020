package com.huarui.common.constant;

public class MappingEnumConstant {

	/**
	 * 列隐藏类型
	 * 
	 * @author baiyu
	 * 
	 *         NONE ：不隐藏
	 *
	 *         PHONE ：手机隐藏
	 *
	 *         TABLE：1024*768隐藏
	 *
	 *         TABLEPHONE：table和手机兼容
	 *
	 *         ALL：全部隐藏
	 */
	public enum ColumnHideType {
		NONE, PHONE, TABLE, TABLEPHONE, ALL
	}

	/**
	 * 搜索框显示类型类型
	 * 
	 * NONE:不显示搜索框
	 * 
	 * TEXT:普通文本狂
	 * 
	 * SELECT:普通下拉选择
	 * 
	 * SELECT2R:智能感知只读
	 * 
	 * SELECT2RW：智能感知读写
	 * 
	 * DATEPICKER 日期选择
	 */
	public enum SearchType {
		NONE, TEXT, SELECT, SELECT2R, DATEPICKER, DATETIMEPICKER, DATEPICKERBETWEEN, DATETIMEPICKERBETWEEN
	}

	/**
	 * 数据转换类型
	 * 
	 * @author 鹏白云
	 *
	 */
	public enum ConverterType {
		DECODE, DATE, MATCH
	}

	/**
	 * 数据查询类型
	 * 
	 * EQ 等于 GT 大于 GE 大于等于 LT 小于 LE 小于等于 NE 不等于 LIKE 模糊查询  BETWEEN (BETWEEN AND)在xxx 与 xxx 之间
	 * 
	 * @author 鹏白云
	 *
	 */
	public enum QueryType {
		NONE, EQ, GT, GE, LT, LE, NE, LIKE, BETWEEN, IN
	}

	/**
	 * 数据模型
	 * 
	 * NONE:没有
	 * 
	 * INPUT:输入
	 * 
	 * SELECT:下拉列表
	 * 
	 * SELECT2R:智能感知只读
	 * 
	 * SELECT2RW：智能感知读写
	 * 
	 * RADIO:单选
	 * 
	 * CHECKBOX: 复选
	 * 
	 * 
	 * @author 鹏白云
	 *
	 */
	public enum DataModel {
		NONE, INPUT, SELECT, SELECT2R, SELECT2RW, RADIO, CHECKBOX
	}

	/**
	 * 排序类型
	 * 
	 * DISABLE 禁用
	 * 
	 * NONE 不进行默认排序
	 * 
	 * AES 默认升序
	 * 
	 * DES 默认降序
	 * 
	 * @author 鹏白云
	 *
	 */
	public enum SortType {
		DISABLE, NONE, AES, DES
	}

	/**
	 * 数据校验类型
	 * 
	 * NONE:不做验证
	 * 
	 * NOTNULL:非空验证
	 * 
	 * NUMBER:数字验证
	 * 
	 * MOBILE：手机号码验证
	 * 
	 * EMAIL：电子邮件验证
	 * 
	 * DATE:日期格式验证 2016-08-05
	 * 
	 * URL:url验证
	 * 
	 * CARDID:身份证验证
	 * 
	 * @author baiyu
	 *
	 */
	public enum VerifyType {
		NONE, Null, NotNull, NotEmpty, Sequence, Min, Max, Pattern, Number, Mobile, Email, Date, Url, IP, CardID
	}

	/**
	 * 验证作用域 ALL 作用于所有场景
	 * 
	 * SUBMIT 作用于提交表单
	 * 
	 * EXCELIMP 作用于EXCEL导入
	 * 
	 * SAVE 作用于数据保存
	 * 
	 * @author baiyu
	 *
	 */
	public enum VerifyScope {
		ALL, SUBMIT, INSERT, UPDATE, DELETE, EXCELIMP
	}

	/**
	 * 初始化数据的类型 AUTO 自动 字符串初始化为空字符串，date初始化为当前日期 CUSTOM 自定义初始化数据
	 * 
	 * @author 鹏白云
	 *
	 */
	public enum InitDataType {
		AUTO, CUSTOM, NOWDATE, EMPTY
	}

	/**
	 * 数据库校验类型 NONE：不做任何校验
	 * 
	 * UNIQUE：唯一性验证,不允许重复
	 * 
	 * @author baiyu
	 *
	 */
	public enum DBVerifyType {
		NONE, UNIQUE
	}

}

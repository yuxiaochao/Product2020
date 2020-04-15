package com.huarui.common.utils.excel;

import com.huarui.common.utils.ThreadUtils;
import com.huarui.annotation.Column;

import java.util.List;

/**
 * 数据验证实体类
 * 
 * @author baiyu
 *
 */
public class Validate {
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


	public Validate(String fieldName, Column column) {
		setFieldName(fieldName);
		if (null != column) {
			//setAliasName(column.aliasName());
			setDisplayName(column.displayName());
		}
		setErrorInfo(null);
	}

	public Validate(String fieldName, Column column, List<VerifyType> verifyTypes) {
		setFieldName(fieldName);
		if (null != column) {
			//setAliasName(column.aliasName());
			setDisplayName(column.displayName());
		}
		setVerifyTypes(verifyTypes);
		setErrorInfo(null);
	}

	public Validate(String fieldName, String fieldValue, String errorInfo) {
		setFieldName(fieldName);
		setFieldValue(fieldValue);
		setErrorInfo(errorInfo);
	}

	/**
	 * 所属字段的字段名称
	 */
	private String fieldName;
	/**
	 * 所属字段的显示名称
	 */
	private String displayName;

	/**
	 * 所属字段的值
	 */
	private String fieldValue;

	/**
	 * 错误信息
	 */
	private String errorInfo;

	/**
	 * 该字段的验证信息
	 */
	private List<VerifyType> verifyTypes;

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getErrorInfo() {
		return errorInfo;
	}

	public void setErrorInfo(String errorInfo) {
		if (ThreadUtils.getRTex().isEmpty(errorInfo)) {
			String name = getFieldName();
			if (!ThreadUtils.getRTex().isEmpty(getDisplayName())) {
				name = getDisplayName();
			}

			StringBuilder sb = new StringBuilder();
			if (null != verifyTypes && verifyTypes.size() > 0) {
				for (VerifyType verifyType : verifyTypes) {
					if (verifyType.Null == verifyType) {
						sb.append(name).append("属性必须为NULL");
					} else if (verifyType.NotNull == verifyType) {
						sb.append("[").append(name).append("]属性属性不能为NULL");
					} else if (verifyType.NotEmpty == verifyType) {
						sb.append("[").append(name).append("]属性不能为空");
					} else if (verifyType.Sequence == verifyType) {
						sb.append("[").append(name).append("]属性不是序列之一");
					} else if (verifyType.Number == verifyType) {
						sb.append("[").append(name).append("]属性不是数字类型");
					} else if (verifyType.Mobile == verifyType) {
						sb.append("[").append(name).append("]属性不是手机号码格式");
					} else if (verifyType.Email == verifyType) {
						sb.append("[").append(name).append("]属性不是EMAIL格式");
					} else if (verifyType.Date == verifyType) {
						sb.append("[").append(name).append("]属性不是合法日期格式");
					} else if (verifyType.Url == verifyType) {
						sb.append("[").append(name).append("]属性不是有效URL格式");
					} else if (verifyType.IP == verifyType) {
						sb.append("[").append(name).append("]属性不是有效IP地址格式");
					} else if (verifyType.CardID == verifyType) {
						sb.append("[").append(name).append("]属性不是有效身份证格式");
					} else if (verifyType.Min == verifyType) {
						sb.append("[").append(name).append("]属性最小于最小值");
					} else if (verifyType.Max == verifyType) {
						sb.append("[").append(name).append("]属性大于最大值");
					} else if (verifyType.Pattern == verifyType) {
						sb.append("[").append(name).append("]属性不匹配指定的正则表达式");
					}
					sb.append(",");
				}
			}
			this.errorInfo = ThreadUtils.getRTex().removeLastStr(sb.toString(), ",");
		} else {
			this.errorInfo = errorInfo;
		}
	}

	public List<VerifyType> getVerifyTypes() {
		return verifyTypes;
	}

	public void setVerifyTypes(List<VerifyType> verifyTypes) {
		this.verifyTypes = verifyTypes;
	}

	public String getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}
}

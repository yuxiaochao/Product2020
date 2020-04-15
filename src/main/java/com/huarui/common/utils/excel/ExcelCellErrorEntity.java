package com.huarui.common.utils.excel;

/**
 * Excel 错误描述
 * 
 * @author baiyu
 *
 */
public class ExcelCellErrorEntity {

	/**
	 * 数据名次
	 */
	private String dataName;
	/**
	 * 数据值
	 */
	private String dataValue;
	/**
	 * 错误信息
	 */
	private String errorInfo;
	public String getDataName() {
		return dataName;
	}
	public void setDataName(String dataName) {
		this.dataName = dataName;
	}
	public String getDataValue() {
		return dataValue;
	}
	public void setDataValue(String dataValue) {
		this.dataValue = dataValue;
	}
	public String getErrorInfo() {
		return errorInfo;
	}
	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}
	
	

}

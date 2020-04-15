package com.huarui.common.utils.excel;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;

/**
 * Excel样式接口
 * 
 * @author 鹏白云
 *
 */
public interface ExcelStyle {

	/**
	 * 获取Excel标题样式
	 */
	public CellStyle getTtileStyle(CellStyle cellStyle, Font cellFont);

	/**
	 * 获取Excel字段名称标题
	 */
	public CellStyle getFieldNameStyle(CellStyle cellStyle, Font cellFont);

	/**
	 * 获取excel数据列的样式
	 */
	public CellStyle getColumnStyle(CellStyle cellStyle, Font cellFont);
}

package com.huarui.common.utils.excel;

import org.apache.poi.ss.usermodel.*;

public class BaseExcelStyle implements ExcelStyle {

	public CellStyle getTtileStyle(CellStyle cellStyle, Font cellFont) {
		cellStyle.setAlignment(HorizontalAlignment.CENTER);
		cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		cellStyle.setBorderBottom(BorderStyle.THIN); // 下边框
		cellStyle.setBorderLeft(BorderStyle.THIN);// 左边框
		cellStyle.setBorderTop(BorderStyle.THIN);// 上边框
		cellStyle.setBorderRight(BorderStyle.THIN);// 右边框
		cellStyle.setWrapText(true);// 设置自动换行
		cellFont.setFontHeightInPoints((short) 14); // 字体高度
		cellFont.setFontName("宋体"); // 字体
		cellFont.setBold(true);
		cellStyle.setFont(cellFont);
		return cellStyle;
	}

	public CellStyle getFieldNameStyle(CellStyle cellStyle, Font cellFont) {
		cellStyle.setAlignment(HorizontalAlignment.CENTER);
		cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		cellStyle.setBorderBottom(BorderStyle.THIN); // 下边框
		cellStyle.setBorderLeft(BorderStyle.THIN);// 左边框
		cellStyle.setBorderTop(BorderStyle.THIN);// 上边框
		cellStyle.setBorderRight(BorderStyle.THIN);// 右边框
		cellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.index);
		cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);;
		cellFont.setFontHeightInPoints((short) 12); // 字体高度
		cellFont.setFontName("宋体"); // 字体
		cellFont.setBold(true);
		cellStyle.setFont(cellFont);
		return cellStyle;
	}

	public CellStyle getColumnStyle(CellStyle cellStyle, Font cellFont) {
		cellStyle.setAlignment(HorizontalAlignment.LEFT);
		cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		cellStyle.setBorderBottom(BorderStyle.THIN); // 下边框
		cellStyle.setBorderLeft(BorderStyle.THIN);// 左边框
		cellStyle.setBorderTop(BorderStyle.THIN);// 上边框
		cellStyle.setBorderRight(BorderStyle.THIN);// 右边框
		cellFont.setFontHeightInPoints((short) 12); // 字体高度
		cellFont.setFontName("宋体"); // 字体
		cellStyle.setFont(cellFont);
		return cellStyle;
	}

}

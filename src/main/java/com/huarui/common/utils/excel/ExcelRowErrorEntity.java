package com.huarui.common.utils.excel;

import com.baomidou.mybatisplus.activerecord.Model;

import java.util.List;

public class ExcelRowErrorEntity {

	/**
	 * excel错误行号
	 */
	private int rowNum;

	/**
	 * Excel错误列表
	 */
	private List<ExcelCellErrorEntity> excelCellErrorList;
	/**
	 * row数据
	 */
	private Model rowData;

	public int getRowNum() {
		return rowNum;
	}

	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}

	public List<ExcelCellErrorEntity> getExcelCellErrorList() {
		return excelCellErrorList;
	}

	public void setExcelCellErrorList(List<ExcelCellErrorEntity> excelCellErrorList) {
		this.excelCellErrorList = excelCellErrorList;
	}

	public Model getRowData() {
		return rowData;
	}

	public void setRowData(Object rowData) {
		this.rowData = (Model) rowData;
	}
}

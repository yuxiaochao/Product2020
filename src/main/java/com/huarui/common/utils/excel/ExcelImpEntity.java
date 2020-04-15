package com.huarui.common.utils.excel;


import com.huarui.common.utils.ThreadUtils;
import com.huarui.common.utils.excel.ExcelUtil.ExcelVersion;

import java.io.Serializable;
import java.util.Map;

public class ExcelImpEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	/**
//	 * 上传文件
//	 */
//	private String excelFileName;
	/**
	 * 上传文件绝对路径
	 */
	private String excelAbsolutePath;

	/**
	 * 定义excel模板名称
	 */
	private String excelTemplateName;
	/**
	 * Excel 版本
	 */
	private ExcelVersion excelVersion;
	/**
	 * 封装类型 用于excel封装
	 * 
	 * 可用封装 List.class
	 * 
	 * Map.class
	 * 
	 * BaseEntity.class
	 */
	private Class holderClass = null;

	/**
	 * 起始行数 默认值为0
	 */
	private int startRowNum = 0;

	/**
	 * excel开始列数默认为0
	 */
	private int startColumnNum = 0;
	/**
	 * 结束行数为-1 表示自动设置
	 */
	private int endRowNum = -1;

	/**
	 * 结束列数为-1 表示自动设置
	 */
	private int endColumnNum = -1;
	/**
	 * excel数据表格Sheet名称
	 */
	private String sheetName;

	/**
	 * 默认启动自动验证
	 */
	private boolean autoVerify = true;

//	/**
//	 * 用户导入excel cache 前缀
//	 */
//	private String cacheKey;
	
	/**
	 * 参数
	 */
	private Map parameterMap;
	/**
	 * 设置Excel每一列对应哪个字段
	 */
	private CorrespondingFieldsEntity correspondingFieldsEntity;

	public CorrespondingFieldsEntity getCorrespondingFieldsEntity() {
		return correspondingFieldsEntity;
	}

	public void setCorrespondingFieldsEntity(CorrespondingFieldsEntity correspondingFieldsEntity) {
		this.correspondingFieldsEntity = correspondingFieldsEntity;
	}

	public String getExcelTemplateName() {
		return excelTemplateName;
	}

	public void setExcelTemplateName(String excelTemplateName) {
		this.excelTemplateName = excelTemplateName;
	}

	public Class getHolderClass() {
		return holderClass;
	}

	public void setHolderClass(Class holderClass) {
		this.holderClass = holderClass;
	}

	public int getStartRowNum() {
		return startRowNum;
	}

	public void setStartRowNum(int startRowNum) {
		this.startRowNum = startRowNum;
	}

	public int getStartColumnNum() {
		return startColumnNum;
	}

	public void setStartColumnNum(int startColumnNum) {
		this.startColumnNum = startColumnNum;
	}

	public int getEndRowNum() {
		return endRowNum;
	}

	public void setEndRowNum(int endRowNum) {
		this.endRowNum = endRowNum;
	}

	public int getEndColumnNum() {
		return endColumnNum;
	}

	public void setEndColumnNum(int endColumnNum) {
		this.endColumnNum = endColumnNum;
	}

	public String getSheetName() {
		return sheetName;
	}

	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}

	public boolean isAutoVerify() {
		return autoVerify;
	}

	public void setAutoVerify(boolean autoVerify) {
		this.autoVerify = autoVerify;
	}

	public ExcelVersion getExcelVersion() {
		return excelVersion;
	}

	public void setExcelVersion(ExcelVersion excelVersion) {
		this.excelVersion = excelVersion;
	}

	public Map getParameterMap() {
		return parameterMap;
	}

	public void setParameterMap(Map parameterMap) {
		this.parameterMap = parameterMap;
	}

	public String getExcelAbsolutePath() {
		return excelAbsolutePath;
	}

	public void setExcelAbsolutePath(String excelAbsolutePath) {
		if (ThreadUtils.getRTex().isNotEmpty(excelAbsolutePath)) {
			String excelExt = ThreadUtils.getFileUtils().getFileExt(excelAbsolutePath);
			if ("xls".equalsIgnoreCase(excelExt)) {
				setExcelVersion(excelVersion.XLS);
			} else if ("xlsx".equalsIgnoreCase(excelExt)) {
				setExcelVersion(excelVersion.XLSX);
			}
		}
		this.excelAbsolutePath = excelAbsolutePath;
	}
}

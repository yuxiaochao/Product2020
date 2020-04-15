package com.huarui.common.utils.excel;
import com.huarui.common.utils.ThreadUtils;
import com.huarui.common.utils.excel.ExcelUtil.ExcelVersion;

/**
 * excel导出excel实体类
 * 
 */
public class ExcelExpEntity {

	/**
	 * Excel导出标题
	 */
	private String title;

	/**
	 * Excel 导出sheet名称
	 */
	private String sheetName = "第${num}页";

	/**
	 * 默认版本 xls
	 */
	private ExcelVersion version = ExcelVersion.XLS;

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
	 * excel导出样式设置
	 */
	private BaseExcelStyle excelStyle = new BaseExcelStyle();
	/**
	 * 设置一个sheet中数据的行数
	 */
	private int sheetLineNumber = 1000;

	/**
	 * Excel的导出文件名
	 */
	private String fileName;

	/**
	 * excel模板名称
	 */
	private String excelTemplateName;
	/**
	 * excel模版起始行数
	 */
	private int startRowNum = -1;
	/**
	 * Excel模版起始列数
	 */
	private int startColNum = -1;

	/**
	 * 设置Excel每一列对应哪个字段
	 */
	private CorrespondingFieldsEntity correspondingFieldsEntity;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSheetName() {
		return sheetName;
	}

	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}

	public ExcelVersion getVersion() {
		return version;
	}

	public void setVersion(ExcelVersion version) {
		this.version = version;
	}

	public Class getHolderClass() {
		return holderClass;
	}

	public void setHolderClass(Class holderClass) {
		if (null != holderClass) {
				if (ThreadUtils.getRTex().isEmpty(fileName)) {
					setFileName("");
				}
				if (ThreadUtils.getRTex().isEmpty(title)) {
					setTitle("");
				}
				setStartColNum(0);
				setStartRowNum(3);
				if (ThreadUtils.getRTex().isEmpty(excelTemplateName)) {
					setExcelTemplateName("");
					String ext = ThreadUtils.getFileUtils().getFileExt("");
					if (ExcelVersion.XLS.toString().equalsIgnoreCase(ext)) {
						setVersion(ExcelVersion.XLS);
					} else if (ExcelVersion.XLSX.toString().equalsIgnoreCase(ext)) {
						setVersion(ExcelVersion.XLSX);
					}
				}
		}
		this.holderClass = holderClass;
	}

	public BaseExcelStyle getExcelStyle() {
		return excelStyle;
	}

	public void setExcelStyle(BaseExcelStyle excelStyle) {
		this.excelStyle = excelStyle;
	}

	public int getSheetLineNumber() {
		return sheetLineNumber;
	}

	public void setSheetLineNumber(int sheetLineNumber) {
		this.sheetLineNumber = sheetLineNumber;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
	    if(ThreadUtils.getRTex().isNotEmpty(fileName) && !fileName.endsWith(ThreadUtils.getRTex().toString(getVersion()).toLowerCase())) {
	        fileName += "." + ThreadUtils.getRTex().toString(getVersion()).toLowerCase();
	    }
		this.fileName = fileName;
	}

	public String getExcelTemplatName() {
		return excelTemplateName;
	}

	public void setExcelTemplateName(String excelTemplatName) {
		this.excelTemplateName = excelTemplatName;
	}

	public int getStartRowNum() {
		return startRowNum;
	}

	public void setStartRowNum(int startRowNum) {
		this.startRowNum = startRowNum;
	}

	public int getStartColNum() {
		return startColNum;
	}

	public void setStartColNum(int startColNum) {
		this.startColNum = startColNum;
	}

	public CorrespondingFieldsEntity getCorrespondingFieldsEntity() {
		return correspondingFieldsEntity;
	}

	public void setCorrespondingFieldsEntity(CorrespondingFieldsEntity correspondingFieldsEntity) {
		this.correspondingFieldsEntity = correspondingFieldsEntity;
	}
}

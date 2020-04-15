package com.huarui.common.utils.excel;

/**
 * 设置每列的基本参数
 */
public class ExcelColumn {

    /**
     * 字段类型 stirng字符串   date时间类型   decode转换类型
     */
    public enum ExcelType {
        string, date, decode
    }

    public ExcelColumn(String columnName){
        this.columnName = columnName;
        this.excelType = ExcelType.string;
    }

    public ExcelColumn(String columnName, String columnTitleName){
        this.columnName = columnName;
        this.excelType = ExcelType.string;
        this.columnTitleName = columnTitleName;
    }

    public ExcelColumn(String columnName, ExcelType excelType, String conversionRules){
        this.columnName = columnName;
        this.excelType = excelType;
        this.conversionRules = conversionRules;
    }

    public ExcelColumn(String columnName, String columnTitleName, ExcelType excelType, String conversionRules){
        this.columnName = columnName;
        this.excelType = excelType;
        this.conversionRules = conversionRules;
        this.columnTitleName = columnTitleName;
    }

    /**
     * 字段类型
     */
    private ExcelType excelType;
    /**
     * 表字段名称
     */
    private String columnName;
    /**
     * 字段中文名称
     */
    private String columnTitleName;
    /**
     * 字段值转换规则
     */
    private String conversionRules;

    public ExcelType getExcelType() {
        return excelType;
    }

    public void setExcelType(ExcelType excelType) {
        this.excelType = excelType;
    }

    public String getConversionRules() {
        return conversionRules;
    }

    public void setConversionRules(String conversionRules) {
        this.conversionRules = conversionRules;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnTitleName() {
        return columnTitleName;
    }

    public void setColumnTitleName(String columnTitleName) {
        this.columnTitleName = columnTitleName;
    }
}

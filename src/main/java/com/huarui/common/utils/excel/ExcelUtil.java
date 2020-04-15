package com.huarui.common.utils.excel;

import com.baomidou.mybatisplus.activerecord.Model;
import com.huarui.common.utils.ThreadUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.util.HtmlUtils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * excel 工具类
 * 
 * @author baiyu
 *
 */
public class ExcelUtil {

	public enum ExcelVersion {
		XLS, XLSX
	}

	/**
	 * imp 导入   exp导出
	 */
	public enum ExcelForward {
		Imp, Exp
	}


	public Workbook getWorkbook(ExcelVersion version, InputStream in) throws IOException {
		Workbook workbook = null;
		if (null == in) {
			if (version == ExcelVersion.XLS) {
				workbook = new HSSFWorkbook();
			} else if (version == ExcelVersion.XLSX) {
				workbook = new XSSFWorkbook();
			}
		} else {
			if (version == ExcelVersion.XLS) {
				workbook = new HSSFWorkbook(in);
			} else if (version == ExcelVersion.XLSX) {
				workbook = new XSSFWorkbook(in);
			}
		}
		return workbook;
	}

	/**
	 * 获取excel Sheet
	 * 
	 * @param excelImp
	 * @return
	 * @throws IOException
	 */
	public Sheet getSheet(ExcelImpEntity excelImp) throws IOException {
		Sheet sheet = null;
		if (null != excelImp && ThreadUtils.getRTex().isNotEmpty(excelImp.getExcelAbsolutePath())) {
			String excelExt = ThreadUtils.getFileUtils().getFileExt(excelImp.getExcelAbsolutePath());
			InputStream inputStream = ThreadUtils.getFileUtils().fileToInputStream(excelImp.getExcelAbsolutePath());
			Workbook wb = getWorkbook(excelImp.getExcelVersion(), inputStream);

			if (!ThreadUtils.getRTex().isEmpty(excelImp.getSheetName())) {
				sheet = wb.getSheet(excelImp.getSheetName());
			} else {
				sheet = wb.getSheetAt(0);
			}
			if (null != sheet) {
				if (-1 == excelImp.getEndRowNum()) {
					excelImp.setEndRowNum((sheet.getLastRowNum() + 1));
				}
				if (-1 == excelImp.getEndColumnNum()) {
					excelImp.setEndColumnNum(sheet.getRow(0).getPhysicalNumberOfCells());
				}
				if (excelImp.getStartRowNum() < 0 || excelImp.getStartRowNum() >= excelImp.getEndRowNum()) {
					excelImp.setStartRowNum(0);
				}
				if (excelImp.getStartColumnNum() < 0 || excelImp.getStartColumnNum() >= excelImp.getEndColumnNum()) {
					excelImp.setStartColumnNum(0);
				}
			}
		}
		return sheet;
	}

	/**
	 * 创建一个新的Excel
	 * 
	 * @param excelExp
	 * @param forward ExcelForward
	 * @throws IOException
	 */
	public Workbook createNewWorkbook(ExcelExpEntity excelExp, ExcelForward forward) throws IOException {
		Workbook workbook = null;
		if (null != excelExp) {
			InputStream in = null;
			if (ThreadUtils.getRTex().isNotEmpty(excelExp.getExcelTemplatName())) {
				if(forward.equals(ExcelForward.Imp)){
					in = ThreadUtils.getFileUtils().getExcelImportTemplateFile(excelExp.getExcelTemplatName());
				}else if(forward.equals(ExcelForward.Exp)){
					in = ThreadUtils.getFileUtils().getExcelExportTemplateFile(excelExp.getExcelTemplatName());
				}
			}
			workbook = getWorkbook(excelExp.getVersion(), in);

		}
		return workbook;
	}

	/**
	 * 创建一个新的sheet
	 * 
	 * @param workbook
	 * @param sheetName
	 * @return
	 */
	public Sheet createNewSheet(Workbook workbook, String sheetName, int sheetNum) {
		Sheet sheet = null;
		String sheetCurrentName = null;
		if (null != workbook) {
			if (ThreadUtils.getRTex().isEmpty(sheetName)) {
				sheetName = "Sheet";
			}
			if (sheetName.contains("${num}")) {
				sheetCurrentName = sheetName.replace("${num}", ThreadUtils.getRTex().toString(sheetNum));
			} else {
				sheetCurrentName = sheetName + sheetNum;
			}
			sheet = workbook.createSheet(sheetCurrentName);
		}
		return sheet;
	}

	/**
	 * 创建一个新的Row
	 * 
	 * @param sheet
	 * @param rowNum
	 * @return
	 */
	public Row createNewRow(Sheet sheet, int rowNum) {
		Row row = null;
		if (null != sheet) {
			if (rowNum < 0) {
				rowNum = 0;
			}
			row = sheet.createRow(rowNum);
		}
		return row;
	}

	/**
	 * 获取一个Row
	 * 
	 * @param sheet
	 * @param rowNum
	 * @return
	 */
	public Row generateTemplateRow(Sheet sheet, int rowNum) {
		Row row = null;
		if (null != sheet) {
			if (rowNum < 0) {
				rowNum = 0;
			}
			row = sheet.getRow(rowNum);
		}
		if (row == null) {
			row = sheet.createRow(rowNum);
		}
		row.setHeightInPoints(25);
		
		return row;
	}

	/**
	 * 创建一个Cell
	 * 
	 * @param row
	 * @param columnNum
	 * @return
	 */
	public Cell createNewCell(Row row, Object value, int columnNum) {
		Cell cell = null;
		if (null != row) {
			if (columnNum < 0) {
				columnNum = 0;
			}
			cell = row.createCell(columnNum);
			setCellValue(cell, value);
		}
		return cell;
	}

	public Cell generateTemplateCell(Row row, Object value, int columnNum) {
		Cell cell = null;
		if (null != row) {
			if (columnNum < 0) {
				columnNum = 0;
			}
			cell = row.getCell(columnNum);
			if (null == cell) {
				cell = row.createCell(columnNum);
			}
			setCellValue(cell, value);
		}
		return cell;
	}


	/**
	 * 将row转换为实体类
	 * 
	 * @param row
	 * @param baseEntityClazz
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws InstantiationException
	 */
	public Model getRowForBaseEntity(Row row, Class baseEntityClazz, CorrespondingFieldsEntity correspondingFields)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, ParseException {
		Model baseEntity = null;
		Map entityMap = new HashMap();
//						Cell cell = row.getCell(impIndex);
//						if (null != cell) {
//						    cell.setCellType(1);
//							Object cellValue = getCellValue(cell);
//							if (ThreadUtils.getRTex().isNotEmpty(cellValue)) {
//								cellValue = excelValueToEntityValue(cellValue, fieldProp);
//								entityMap.put(fieldProp.getFieldName(), cellValue);
//							}
//						}



		Map<String, Object> stringObjectMap = ThreadUtils.getEntityUtil().entity2Map(correspondingFields);
		Set<Map.Entry<String, Object>> entries = stringObjectMap.entrySet();
		for (Map.Entry<String, Object> entry : entries) {
			String key = entry.getKey();
			Object value = entry.getValue();
			if(ThreadUtils.getRTex().isAllEmpty(value)){
				continue;
			}
			ExcelColumn excelColumn = (ExcelColumn)entry.getValue();
			String columnName = excelColumn.getColumnName();
			ExcelColumn.ExcelType excelType = excelColumn.getExcelType();
			String conversionRules = excelColumn.getConversionRules();

			if(ThreadUtils.getRTex().isNotEmpty(columnName)){
				int columnIndex = ThreadUtils.getRTex().toInteger(key.replace("column", ""),0);
				Cell cell = row.getCell(columnIndex);
				if(cell != null) {
				    cell.setCellType(1);
				    Object cellValue = getCellValue(cell);
				    if (ThreadUtils.getRTex().isNotEmpty(cellValue)) {
				        switch (excelType){
				        case string:
				            entityMap.put(columnName, (String)cellValue);
				            break;
				        case date:
				            SimpleDateFormat sf = new SimpleDateFormat(conversionRules);
				            Date parse = sf.parse((String) cellValue);
				            entityMap.put(columnName, parse);
				            break;
				        case decode:
				            cellValue = ThreadUtils.getRTex().getDecodeKey(conversionRules, (String)cellValue, false);
				            entityMap.put(columnName, cellValue);
				            break;
				        }
				    }
				}
			}
		}


		if (null != entityMap && entityMap.size() > 0) {
			baseEntity = (Model) ThreadUtils.getEntityUtil().map2Entity(baseEntityClazz, entityMap);
		}
		return baseEntity;
	}

	/**
	 * 将row转换为实体类
	 *
	 * @param row
	 * @param baseEntityClazz
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws InstantiationException
	 */
	public Map getRowForBaseMap(Row row, Class baseEntityClazz, CorrespondingFieldsEntity correspondingFields)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, ParseException {
		Map entityMap = new HashMap();

		Map<String, Object> stringObjectMap = ThreadUtils.getEntityUtil().entity2Map(correspondingFields);
		Set<Map.Entry<String, Object>> entries = stringObjectMap.entrySet();
		for (Map.Entry<String, Object> entry : entries) {
			String key = entry.getKey();
			Object value = entry.getValue();
			if(ThreadUtils.getRTex().isAllEmpty(value)){
				continue;
			}
			ExcelColumn excelColumn = (ExcelColumn)entry.getValue();
			String columnName = excelColumn.getColumnName();

			if(ThreadUtils.getRTex().isNotEmpty(columnName)){
				int columnIndex = ThreadUtils.getRTex().toInteger(key.replace("column", ""),0);
				Cell cell = row.getCell(columnIndex);
				if(cell != null) {
				    cell.setCellType(1);
	                Object cellValue = getCellValue(cell);
	                entityMap.put(columnName, (String)cellValue);
				}
			}
		}

		return entityMap;
	}

	/**
	 * 获取excel cell
	 * 
	 * @param cell
	 * @return
	 */
	public Object getCellValue(Cell cell) {
		Object value = null;
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_STRING: // 字符串类型
			value = cell.getStringCellValue().trim();
			break;
		case Cell.CELL_TYPE_BOOLEAN: // boolean类型
			value = cell.getBooleanCellValue();
			break;
		case Cell.CELL_TYPE_NUMERIC: // 数字类型
			if (HSSFDateUtil.isCellDateFormatted(cell)) {
				// 如果是date类型则 ，获取该cell的date值
				value = HSSFDateUtil.getJavaDate(cell.getNumericCellValue()).toString();
			} else { // 纯数字
				/*DecimalFormat df = new DecimalFormat("0");
				value = df.format(cell.getNumericCellValue());*/
				value = cell.getNumericCellValue();
			}
			break;
		case HSSFCell.CELL_TYPE_FORMULA: // 公式
			value = cell.getCellFormula();
			break;
		case Cell.CELL_TYPE_BLANK: // 空值
			value = "";
			break;
		case Cell.CELL_TYPE_ERROR: // 错误
			value = "";
			break;
		}
		return value;
	}

	/**
	 * 设置cell单元格数据
	 * 
	 * @param cell
	 * @param value
	 */
	public void setCellValue(Cell cell, Object value) {
		if (null != cell && null != value) {
			if (value instanceof String) {
				cell.setCellValue(HtmlUtils.htmlUnescape(ThreadUtils.getRTex().toString(value)));
			} else if (value instanceof Boolean) {
				cell.setCellValue((Boolean) value);
			} else if (value instanceof Calendar) {
				cell.setCellValue((Calendar) value);
			} else if (value instanceof Double) {
				cell.setCellValue((Double) value);
			} else if (value instanceof Integer || value instanceof Long || value instanceof Short
					|| value instanceof Float) {
				cell.setCellValue(Double.parseDouble(ThreadUtils.getRTex().toString(value)));
			} else if (value instanceof HSSFRichTextString) {
				cell.setCellValue((HSSFRichTextString) value);
			} else {
				cell.setCellValue(ThreadUtils.getRTex().toString(value));
			}
		}
	}

	/**
	 * 生产Excel错误信息
	 * 
	 * @param validateList
	 * @return
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 */
	public ExcelRowErrorEntity buildExcelError(Object excelData, List<Validate> validateList, int rowNum)
			throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, SecurityException,
            NoSuchFieldException {
		Map entityMap = null;
		ExcelRowErrorEntity excelRowError = new ExcelRowErrorEntity();
		if (excelData instanceof Model) {
			List<ExcelCellErrorEntity> excelCellErrorList = new ArrayList<ExcelCellErrorEntity>();
			for (Validate validate : validateList) {

				ExcelCellErrorEntity excelCellError = new ExcelCellErrorEntity();
				excelCellError.setDataName(validate.getFieldName());
				excelCellError.setDataValue(validate.getFieldValue());
				excelCellError.setErrorInfo(validate.getErrorInfo());
//					excelCellError.setDataValue(getExcelDisplayValue(fieldProp.getFieldName(), excelData));
//					excelCellError.setErrorInfo(getExcelErrorInfo(fieldProp.getFieldName(), validateList));
				excelCellErrorList.add(excelCellError);
			}
			excelRowError.setExcelCellErrorList(excelCellErrorList);
			excelRowError.setRowNum(rowNum);
			excelRowError.setRowData(excelData);
		}
		return excelRowError;
	}

	/**
	 * 获取excel错误信息
	 * 
	 * @param dataName
	 * @param validateList
	 * @return
	 */
	public String getExcelErrorInfo(String dataName, List<Validate> validateList) {
		String errorInfo = null;
		if (ThreadUtils.getRTex().isNotEmpty(dataName) && null != validateList) {
			for (Validate validate : validateList) {
				if (dataName.equals(validate.getFieldName())) {
					errorInfo = validate.getErrorInfo();
					break;
				}
			}
		}
		return errorInfo;
	}


	/**
	 * 获取Excel对实体类的文本显示数据 即数据格式化
	 * 
	 * @param fieldName
	 * @param entity
	 * @return
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws NoSuchFieldException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public String getExcelDisplayValue(String fieldName, Object entity, ExcelColumn excelColumn) throws SecurityException,
            IllegalArgumentException, NoSuchFieldException, IllegalAccessException {
		Object value = null;
		if (null != entity && ThreadUtils.getRTex().isNotEmpty(fieldName)) {
			if (entity instanceof Model) {
				value = ThreadUtils.getReflectUtil().getFieldValue(entity, fieldName);
				if (null != value) {
					ExcelColumn.ExcelType excelType = excelColumn.getExcelType();
					String conversionRules = excelColumn.getConversionRules();

					switch (excelType){
						case string:
							break;
						case date:
							if(value instanceof Date){
								SimpleDateFormat sf = new SimpleDateFormat(conversionRules);
								value = sf.format((Date) value);
							}
							break;
						case decode:
							value = ThreadUtils.getRTex().getDecodeKey(conversionRules, value);
							break;
					}
//					Converter dataConverter = getExcelDateConverter(fieldProp);
//					value = ThreadUtils.getEntityUtil().dataConverter(value, fieldProp, dataConverter);

				}
			}
		}
		return ThreadUtils.getRTex().toString(value);
	}


	/**
	 * 获取数据需要几个Sheet
	 * 
	 * @param dataLineNum
	 * @param sheetLineNum
	 * @return
	 */
	public int getSheetNum(int dataLineNum, int sheetLineNum) {
		int sheetNum = 1;
		if (sheetLineNum <= 0) {
			sheetLineNum = 1000;
		}
		if (dataLineNum > sheetLineNum) {
			int mod = dataLineNum % sheetLineNum;
			sheetNum = (dataLineNum / sheetLineNum);
			if (mod > 0) {
				sheetNum++;
			}
		}
		return sheetNum;
	}

	public void generateColumnTemplateRow(Row row, Model entity, ExcelExpEntity excelExp) throws SecurityException,
            IllegalArgumentException, NoSuchFieldException, IllegalAccessException, InvocationTargetException {
		if (null != row && null != entity && null != excelExp) {
			//字段设置及转换器
			CorrespondingFieldsEntity correspondingFieldsEntity = excelExp.getCorrespondingFieldsEntity();

			int rowNum = row.getRowNum();
			int startRowNum = excelExp.getStartRowNum();
			boolean isAddFirstColumn = false;


			Map<String, Object> stringObjectMap = ThreadUtils.getEntityUtil().entity2Map(correspondingFieldsEntity);
			Set<Map.Entry<String, Object>> entries = stringObjectMap.entrySet();
			for (Map.Entry<String, Object> entry : entries) {
				String key = entry.getKey();
				Object value = entry.getValue();
				int columnIndex = ThreadUtils.getRTex().toInteger(key.replace("column", ""), 0);
				if (ThreadUtils.getRTex().isAllEmpty(value)) {
					if (ThreadUtils.getRTex().isAllEmpty(value)) {
						if(columnIndex == 0){
							isAddFirstColumn = true;
						}
						continue;
					}
					continue;
				}
				ExcelColumn excelColumn = (ExcelColumn) value;
				String columnName = excelColumn.getColumnName();

				if(ThreadUtils.getRTex().isNotEmpty(columnName)) {

					String columnValue = getExcelDisplayValue(columnName, entity, excelColumn);

					generateTemplateCell(row, columnValue, columnIndex);
				}
			}
			//是否增加第一列为序号
			if(isAddFirstColumn){
				generateTemplateCell(row, rowNum - startRowNum + 1, 0);
			}
		}
	}

	/**
	 * 数据填充单元格
	 *
	 * @param entity
	 * @param excelExp
	 * @param rowNum
	 * @param cellStyle
	 * @param cellFont
	 * @throws IllegalArgumentException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws NoSuchFieldException
	 * @throws InvocationTargetException
	 */
	public void createColumnNewRow(Row row, Model entity, ExcelExpEntity excelExp, int rowNum, CellStyle cellStyle,
								   Font cellFont) throws IllegalArgumentException, SecurityException, IllegalAccessException,
            NoSuchFieldException, InvocationTargetException {
		if (null != row && null != entity && null != excelExp) {
			//字段设置及转换器
			CorrespondingFieldsEntity correspondingFieldsEntity = excelExp.getCorrespondingFieldsEntity();

			ExcelStyle excelStyle = excelExp.getExcelStyle();
			boolean isAddFirstColumn = false;
			int startRowNum = excelExp.getStartRowNum();

			Map<String, Object> stringObjectMap = ThreadUtils.getEntityUtil().entity2Map(correspondingFieldsEntity);
			Set<Map.Entry<String, Object>> entries = stringObjectMap.entrySet();
			for (Map.Entry<String, Object> entry : entries) {
				String key = entry.getKey();
				Object value = entry.getValue();
				int columnIndex = ThreadUtils.getRTex().toInteger(key.replace("column", ""), 0);
				if (ThreadUtils.getRTex().isAllEmpty(value)) {
					if(columnIndex == 0){
						isAddFirstColumn = true;
					}
					continue;
				}
				ExcelColumn excelColumn = (ExcelColumn) value;
				String columnName = excelColumn.getColumnName();

				String columnValue = getExcelDisplayValue(columnName, entity, excelColumn);

				Cell cell = createNewCell(row, columnValue, columnIndex);
				if (null != excelStyle) {
					cell.setCellStyle(excelStyle.getColumnStyle(cellStyle, cellFont));
				}
			}
			//是否增加第一列为序号
			if(isAddFirstColumn){
				Cell cell = createNewCell(row, rowNum - startRowNum + 2, 0);
				if (null != excelStyle) {
					cell.setCellStyle(excelStyle.getColumnStyle(cellStyle, cellFont));
				}
			}
		}
	}

	/**
	 * 设置excel标题
	 */
	public void createTitle(Sheet sheet, ExcelExpEntity excelExp, CellStyle cellStyle, Font cellFont) throws InvocationTargetException, IllegalAccessException {
		if (null != sheet && null != excelExp) {
			String title = excelExp.getTitle();
			if (ThreadUtils.getRTex().isNotEmpty(title)) {
				int titleSize = 0;

				CorrespondingFieldsEntity correspondingFieldsEntity = excelExp.getCorrespondingFieldsEntity();
				titleSize = getColumnMaxNum(correspondingFieldsEntity);

//				if (titleSize > 1) {
//					titleSize--;
//				}
				sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, titleSize));
				Row row = createNewRow(sheet, 0);
				row.setHeightInPoints(50);
				Cell cell = createNewCell(row, title, 0);
				ExcelStyle excelStyle = excelExp.getExcelStyle();
				if (null != excelStyle) {
					cell.setCellStyle(excelStyle.getTtileStyle(cellStyle, cellFont));
				}

			}

		}

	}

	/**
	 * 设置字段名称
	 *
	 * @param sheet
	 * @param rowNum
	 */
	public void createFieldNewRow(Sheet sheet, ExcelExpEntity excelExp, int rowNum, CellStyle cellStyle,
								  Font cellFont) throws InvocationTargetException, IllegalAccessException {
		if (null != sheet && null != excelExp) {
			ExcelStyle excelStyle = excelExp.getExcelStyle();
			int startRowNum = excelExp.getStartRowNum();
			Row row = createNewRow(sheet, rowNum);
			row.setHeightInPoints(30);
			if (null != row) {
				int cellNum = 0;
				boolean isAddFirstColumn = false;
				CorrespondingFieldsEntity correspondingFieldsEntity = excelExp.getCorrespondingFieldsEntity();
				List<Map.Entry<String, Object>> columnOrderedList = getColumnOrderedList(correspondingFieldsEntity);
				for (Map.Entry<String, Object> entry : columnOrderedList) {
					String key = entry.getKey();
					Object value = entry.getValue();
					cellNum = ThreadUtils.getRTex().toInteger(key.replace("column", ""), 0);
					if (ThreadUtils.getRTex().isAllEmpty(value)) {
						if(cellNum == 0){
							isAddFirstColumn = true;
						}
						continue;
					}

					ExcelColumn excelColumn = (ExcelColumn) value;
					String excelTitleValue = excelColumn.getColumnTitleName();

					if(ThreadUtils.getRTex().isNotEmpty(excelTitleValue)) {

						Cell cell = createNewCell(row, excelTitleValue, cellNum);
						if (null != excelStyle) {
							cell.setCellStyle(excelStyle.getFieldNameStyle(cellStyle, cellFont));
						}
						sheet.autoSizeColumn(cellNum);
					}
				}
				//是否增加第一列为序号
				if(isAddFirstColumn){
					Cell cell = createNewCell(row, "序号", 0);
					if (null != excelStyle) {
						cell.setCellStyle(excelStyle.getFieldNameStyle(cellStyle, cellFont));
					}
					sheet.autoSizeColumn(cellNum);
				}
			}
		}
	}

	/**
	 * 获取列数量
	 * @return
	 */
	public int getColumnNum(CorrespondingFieldsEntity correspondingFieldsEntity)
			throws InvocationTargetException, IllegalAccessException {
		int columnNum = 0;

		Map<String, Object> stringObjectMap = ThreadUtils.getEntityUtil().entity2Map(correspondingFieldsEntity);
		Set<Map.Entry<String, Object>> entries = stringObjectMap.entrySet();
		for (Map.Entry<String, Object> entry : entries) {
			String key = entry.getKey();
			Object value = entry.getValue();
			if (ThreadUtils.getRTex().isAllEmpty(value)) {
				continue;
			}
			columnNum++;
		}
		return columnNum;
	}

	/**
	 * 获取列最大的一列下标
	 * @return
	 */
	public int getColumnMaxNum(CorrespondingFieldsEntity correspondingFieldsEntity)
			throws InvocationTargetException, IllegalAccessException {
		int columnMaxNum = 0;

		Map<String, Object> stringObjectMap = ThreadUtils.getEntityUtil().entity2Map(correspondingFieldsEntity);
		Set<Map.Entry<String, Object>> entries = stringObjectMap.entrySet();
		for (Map.Entry<String, Object> entry : entries) {
			String key = entry.getKey();
			Object value = entry.getValue();
			if (ThreadUtils.getRTex().isAllEmpty(value)) {
				continue;
			}
			int columnIndex = ThreadUtils.getRTex().toInteger(key.replace("column", ""),0);
			if(columnMaxNum < columnIndex){
				columnMaxNum = columnIndex;
			}
		}
		return columnMaxNum;
	}

	/**
	 * 有序排列的Column List
	 * @return
	 */
	public List<Map.Entry<String, Object>> getColumnOrderedList(CorrespondingFieldsEntity correspondingFieldsEntity)
			throws InvocationTargetException, IllegalAccessException {
		Map<String, Object> stringObjectMap = ThreadUtils.getEntityUtil().entity2Map(correspondingFieldsEntity);
		/* 获取set集合 */
		Set<Map.Entry<String, Object>> entries = stringObjectMap.entrySet();
		/* 将Set集合转为List,这样获得的list并不能有序排列*/
		List<Map.Entry<String, Object>> entrieList = new ArrayList<Map.Entry<String, Object>>(entries);

		/*将list有序排列*/
		Collections.sort(entrieList, new Comparator<Map.Entry<String, Object>>() {
			public int compare(Map.Entry<String, Object> arg0, Map.Entry<String, Object> arg1) {
				String key0 = arg0.getKey();
				String key1 = arg1.getKey();
				int columnIndex0 = ThreadUtils.getRTex().toInteger(key0.replace("column", ""), 0);
				int columnIndex1 = ThreadUtils.getRTex().toInteger(key1.replace("column", ""), 0);
				return columnIndex0 - columnIndex1;
			}
		});
		return entrieList;
	}

}

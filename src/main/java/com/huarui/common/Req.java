package com.huarui.common;

import com.baomidou.mybatisplus.activerecord.Model;
import com.huarui.common.utils.ThreadUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class Req implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(Req.class);

	/**
	 * 唯一校验字段
	 */
	private String uniqueValidate;
	/**
	 * 每页显示几条
	 */
	private int pageSize = 10;
	/**
	 * 当前第几页
	 */
	private int currentPage = 1;
	/**
	 * 参数列表
	 */
	private Map parameterMap = new HashMap();

	/**
	 * 附加参数列表
	 */
	public Map extraParameterMap = new HashMap();

	/**
	 * 查询类型
	 */
	private Map<String, String> queryTypeMap = new HashMap<String, String>();

	/**
	 * 排序表达式
	 */
	private String sortExpression;

	/**
	 * 实体类Class名称
	 */
	private String entityClassName;

	/**
	 * 获得该用户ID
	 */
	private String userId;
	/**
	 * 获得该用户账号
	 */
	private String userName;
	/**
	 * 获得该用户名称
	 */
	private String userAlias;
	/**
	 * 获得该用户所在机构ID
	 */
	private String userOrganId;
	/**
	 * 获得该用户所在机构名称
	 */
	private String userOrganName;
	/**
	 * 获得该用户是否为管理员 
	 */
	private boolean isManagement;
	
	/**
	 * 获得该角色来源   1,'运营单位',2,'认证单位',3,'报名单位'
	 */
	private int companySource;
	/**
	 * 认证单位类型 默认-1 0 中电联 1省级鉴定中心 2市级鉴定站
	 */
	private int authenticationOrganType;
	/**
	 * 得到主办单位
	 */
	private String userManagerOrganId;
	
	/**
	 * 操作的主键
	 */
	public String ids;
	
	/**
	 * 获取字符串类型参数
	 * 
	 * @param key
	 * @return
	 */
	public String getString(String key) {
		String value = null;
		if (null != parameterMap) {
			value = ThreadUtils.getRTex().toString(getWebKey(key));
		}
		return value;
	}

	/**
	 * 获取Integer类型参数
	 * 
	 * @param key
	 * @return
	 */
	public Integer getInteger(String key) {
		Integer value = null;
		if (null != parameterMap) {
			value = ThreadUtils.getRTex().toInteger(getWebKey(key));
		}
		return value;
	}
	
	/**
	 * 获取Float类型参数
	 * 
	 * @param key
	 * @return
	 */
	public Float getFloat(String key) {
		Float value = null;
		if (null != parameterMap) {
			value = ThreadUtils.getRTex().toFloat(ThreadUtils.getRTex().toString(getWebKey(key)));
		}
		return value;
	}

	/**
	 * 获取key的值
	 * 
	 * @param key
	 * @return
	 */
	public Object getWebKey(String key) {
		Object value = parameterMap.get(key);
		if (null == value) {
			value = extraParameterMap.get(key);
		}
		return value;
	}

	/**
	 * 获取Boolean类型参数
	 * 
	 * @param key
	 * @return
	 */
	public boolean getBoolean(String key) {
		boolean value = false;
		if (null != parameterMap) {
			value = ThreadUtils.getRTex().toBoolean(ThreadUtils.getRTex().toString(getWebKey(key)));
		}
		return value;
	}
	
	/**
	 * 获取Object类型参数
	 * 
	 * @param key
	 * @return
	 */
	public Object getObject(String key) {
		Object value = null;
		if (null != parameterMap) {
			value = getWebKey(key);
		}
		return value;
	}


	/**
	 * 获取实体类对象
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 */
	public <T> T getEntity(Class<T> clazz)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
            InvocationTargetException, SecurityException, NoSuchFieldException {
		Model baseEntity = null;
		if (null != clazz && Model.class.isAssignableFrom(clazz)) {
			Map parmsMap =  getParameterMap();
			baseEntity = (Model) ThreadUtils.getEntityUtil().map2Entity(clazz, parmsMap);
		} else {
			logger.info("clazz为空或类型不是BaseEntity,不能进行实体转换！");
		}
		return (T)baseEntity;
	}

	/**
	 * 获取Excel导入类名称
	 * 
	 * @return
	 */
	public String getExcelImporter() {
		String excelImporter = getString("EXCELIMPORTER");
		if(ThreadUtils.getRTex().isEmpty(excelImporter)) {
			excelImporter = getString("EXCELIMPOTER");
		}
		if (ThreadUtils.getRTex().isEmpty(excelImporter)) {
			if (ThreadUtils.getRTex().isNotEmpty(entityClassName)) {
				String entityName = entityClassName.toLowerCase().replace("entity", "");
				if (ThreadUtils.getRTex().isNotEmpty(entityName)) {
					excelImporter = entityName + "ExcelImport";
				}
			}
		}
		if (ThreadUtils.getRTex().isNotEmpty(excelImporter)) {
			excelImporter = ThreadUtils.getRTex().toLowerCaseFirstOne(excelImporter);
		}
		return excelImporter;
	}

	/**
	 * 获取Excel导出类名称
	 * 
	 * @return
	 */
	public String getExcelExporter() {
		String excelExporter = getString("EXCELEXPORTER");
		if (ThreadUtils.getRTex().isEmpty(excelExporter)) {
			if (ThreadUtils.getRTex().isNotEmpty(entityClassName)) {
				String entityName = entityClassName.toLowerCase().replace("entity", "");
				if (ThreadUtils.getRTex().isNotEmpty(entityName)) {
					excelExporter = entityName + "ExcelExport";
				}
			}
		}
		if (ThreadUtils.getRTex().isNotEmpty(excelExporter)) {
			excelExporter = ThreadUtils.getRTex().toLowerCaseFirstOne(excelExporter);
		}
		return excelExporter;
	}


	/**
	 * 向参数列表加入参数
	 * 
	 * @param key
	 * @param value
	 */
	public void putParameter(String key, Object value) {
		if (null == parameterMap) {
			parameterMap = new HashMap();
		}
		parameterMap.put(key, value);
	}
	
	/**
	 * 设置参数查询方式
	 * 
	 * @param key
	 * @param value
	 */
	public void putQueryTypeParameter(String key, String value) {
		if (null == queryTypeMap) {
			queryTypeMap = new HashMap();
		}
		queryTypeMap.put(key, value);
	}

	/**
	 * 
	 * @param paramsMap
	 */
	public void putParameter(Map paramsMap) {
		if (null == parameterMap) {
			parameterMap = new HashMap();
		}
		parameterMap.putAll(paramsMap);
	}

	public String getUniqueValidate() {
		return uniqueValidate;
	}

	public void setUniqueValidate(String uniqueValidate) {
		this.uniqueValidate = uniqueValidate;
	}
	/**
	 * 每页显示几条
	 */
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	/**
	 * 当前第几页
	 */
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}


	public Map getParameterMap() {
		return parameterMap;
	}

	public Map getExtraParameterMap() {
		return extraParameterMap;
	}

	public void setExtraParameterMap(Map extraParameterMap) {
		this.extraParameterMap = extraParameterMap;
	}

	public void setParameterMap(Map parameterMap) {
		this.parameterMap = parameterMap;
	}

	public Map<String, String> getQueryTypeMap() {
		return queryTypeMap;
	}

	public void setQueryTypeMap(Map<String, String> queryTypeMap) {
		this.queryTypeMap = queryTypeMap;
	}

	public String getSortExpression() {
		return sortExpression;
	}

	public void setSortExpression(String sortExpression) {
		this.sortExpression = sortExpression;
	}

	public String getEntityClassName() {
		return entityClassName;
	}

	public void setEntityClassName(String entityClassName) {
		this.entityClassName = entityClassName;
	}


	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	
	@Override
	public Object clone() {
        try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}  
        return new Req();
    }
	/**
	 * 获得该用户ID
	 */
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获得该用户账号
	 */
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 获得该用户名称
	 */
	public String getUserAlias() {
		return userAlias;
	}

	public void setUserAlias(String userAlias) {
		this.userAlias = userAlias;
	}
	/**
	 * 获得该用户所在机构ID
	 */
	public String getUserOrganId() {
		return userOrganId;
	}

	public void setUserOrganId(String userOrganId) {
		this.userOrganId = userOrganId;
	}
	/**
	 * 获得该用户所在机构名称
	 */
	public String getUserOrganName() {
		return userOrganName;
	}

	public void setUserOrganName(String userOrganName) {
		this.userOrganName = userOrganName;
	}
	/**
	 * 获得该用户是否为管理员 
	 */
	public boolean isManagement() {
		return isManagement;
	}

	public void setManagement(boolean isManagement) {
		this.isManagement = isManagement;
	}
	/**
	 * 获得该角色来源   1,'运营单位',2,'认证单位',3,'报名单位'
	 */
	public int getCompanySource() {
		return companySource;
	}

	public void setCompanySource(int companySource) {
		this.companySource = companySource;
	}
	/**
	 * 认证单位类型 默认-1 0 中电联 1省级鉴定中心 2市级鉴定站
	 */
	public int getAuthenticationOrganType() {
		return authenticationOrganType;
	}

	public void setAuthenticationOrganType(int authenticationOrganType) {
		this.authenticationOrganType = authenticationOrganType;
	}
	/**
	 * 得到主办单位
	 */
	public String getUserManagerOrganId() {
		return userManagerOrganId;
	}

	public void setUserManagerOrganId(String userManagerOrganId) {
		this.userManagerOrganId = userManagerOrganId;
	} 
	
}

package com.huarui.common.cache;

import com.baomidou.mybatisplus.activerecord.Model;
import com.huarui.common.utils.ThreadUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 实体类缓存工具类
 * 
 * @author baiyu
 *
 */
public class EntityCache {

	private static final Logger logger = LoggerFactory.getLogger(EntityCache.class);

	/**
	 * 初始化实体类描述缓存
	 * 
	 * @param classNameList
	 * @throws ClassNotFoundException
	 */
	public void initEntityCache(List<String> classNameList) throws ClassNotFoundException {
		for (String className : classNameList) {
			getEntityProp(className);
		}
		logger.info("实体类缓存创建成功");
	}

	/**
	 * 初始化实体类绑定缓存
	 * 
	 * @param classNameList
	 * @throws ClassNotFoundException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws NoSuchFieldException
	 * @throws IllegalArgumentException
	 * @throws SecurityException
	 */
	public void initBingDataEntity(List<String> classNameList) throws ClassNotFoundException, SecurityException,
            IllegalArgumentException, NoSuchFieldException, IllegalAccessException, InvocationTargetException {
		for (String className : classNameList) {
			ThreadUtils.getEntityUtil().getBingDataEntity(className);

		}
		logger.info("实体类绑定缓存创建成功");
	}

	/**
	 * 获取一个实体类的描述
	 * 
	 * @param clazz
	 * @return
	 */
	public EntityProp getEntityProp(Class clazz) {
		EntityProp entityProp = null;
		if (null != clazz && Model.class.isAssignableFrom(clazz)) {
			entityProp = SystemCache.getEntityPropCache().get(clazz.getName());
			if (null == entityProp) {
				entityProp = putEntityProp(clazz);
			}
		}
		return entityProp;
	}

	/**
	 * 获取一个实体类的描述
	 * 
	 * @param className
	 * @return
	 * @throws ClassNotFoundException
	 */
	public EntityProp getEntityProp(String className) throws ClassNotFoundException {
		Class entityClass = ThreadUtils.getEntityUtil().getModeEntityForName(className);
		return getEntityProp(entityClass);
	}

	/**
	 * 向缓存放入一个实体类
	 * 
	 * @param clazz
	 * @return
	 */
	private EntityProp putEntityProp(Class clazz) {
		EntityProp entityProp = ThreadUtils.getEntityUtil().BaseEntityClassToEntityProp(clazz);
		if (null != entityProp) {
			SystemCache.getEntityPropCache().put(entityProp.getEntityClassName(), entityProp);
			logger.info("创建缓存对象：" + clazz.getName());
		}
		return entityProp;
	}

	/**
	 * 得到实体类的主键
	 * 
	 * @return
	 */
	public String getEntityPK(Class clazz) {
		EntityProp entityProp = getEntityProp(clazz);
		String pk = null;
		if (null != entityProp) {
			pk = entityProp.getPk();
		}
		return pk;
	}

	/**
	 * 得到实体类的主键
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 */
	public String getEntityPK(String className) throws ClassNotFoundException {
		Class clazz = ThreadUtils.getEntityUtil().getModeEntityForName(className);
		String pk = null;
		if (clazz != null) {
			EntityProp entityProp = getEntityProp(clazz);
			if (null != entityProp) {
				pk = entityProp.getPk();
			}
		}
		return pk;
	}

	/**
	 * 获取实体类的所有属性列表
	 * 
	 * @param clazz
	 * @return
	 */
	public List<String> getEntityPropertys(Class clazz) {
		EntityProp entityProp = getEntityProp(clazz);
		String pk = null;
		List<String> entityPropertys = new ArrayList<String>();
		if (null != entityProp) {
			List<FieldProp> fieldProps = entityProp.getFieldProps();
			for (FieldProp fieldProp : fieldProps) {
				if (ThreadUtils.getRTex().isNotEmpty(fieldProp.getFieldName())) {
					entityPropertys.add(fieldProp.getFieldName());
				}
			}
		}
		return entityPropertys;
	}

	/**
	 * 获取实体类的所有属性列表
	 * 
	 * @param clazz
	 * @return
	 */
	public String getEntityPropertyForAliasName(Class clazz, String aliasName) {
		String property = null;
		if (null != clazz && ThreadUtils.getRTex().isNotEmpty(aliasName)) {
			Map<String, String> aliasMap = getEntityAliasMap(clazz);
			if (null != aliasMap) {
				property = aliasMap.get(aliasName);
			}
		}

		return property;
	}

	/**
	 * 获取实体类的所有字段描述列表
	 * 
	 * @param clazz
	 * @return
	 */
	public List<FieldProp> getEntityFieldProps(Class clazz) {
		EntityProp entityProp = getEntityProp(clazz);
		if (null != entityProp) {
			return entityProp.getFieldProps();

		}
		return null;
	}


	/**
	 * 获取实体类的所有字段描述列表
	 * 
	 * @param clazz
	 *            实体类的Class
	 * @param fieldName
	 *            字段名称
	 * @return
	 */
	public FieldProp getEntityFieldProp(Class clazz, String fieldName) {
		EntityProp entityProp = getEntityProp(clazz);
		FieldProp fieldProp = null;
		if (null != entityProp) {
			List<FieldProp> fieldProps = entityProp.getFieldProps();
			for (FieldProp field : fieldProps) {
				if (null != field) {
					if (field.getFieldName().equals(fieldName)) {
						fieldProp = field;
						break;
					}
				}
			}
		}
		return fieldProp;
	}

	/**
	 * 获取实体类的所有字段描述列表
	 * 
	 * @param fieldName
	 *            字段名称
	 * @return
	 * @throws ClassNotFoundException
	 */
	public FieldProp getEntityFieldProp(String className, String fieldName) throws ClassNotFoundException {
		EntityProp entityProp = getEntityProp(className);
		FieldProp fieldProp = null;
		if (null != entityProp) {
			List<FieldProp> fieldProps = entityProp.getFieldProps();
			for (FieldProp field : fieldProps) {
				if (null != field) {
					if (field.getFieldName().equals(fieldName)) {
						fieldProp = field;
						break;
					}
				}
			}
		}
		return fieldProp;
	}

	/**
	 * 获取实体类的所有字段描述列表
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 */
	public List<FieldProp> getEntityFieldProps(String className) throws ClassNotFoundException {
		Class clazz = ThreadUtils.getEntityUtil().getModeEntityForName(className);
		return getEntityFieldProps(clazz);
	}


	/**
	 * 获取实体类的所有别名列表
	 * 
	 * @param clazz
	 * @return
	 */
	public Map<String, String> getEntityAliasMap(Class clazz) {
		EntityProp entityProp = getEntityProp(clazz);
		String pk = null;
		Map<String, String> entityAliasMap = new HashMap<String, String>();
		if (null != entityProp) {
			List<FieldProp> fieldProps = entityProp.getFieldProps();
			for (FieldProp fieldProp : fieldProps) {
				String aliasName = fieldProp.getFieldName();
				String value = fieldProp.getFieldName();
				entityAliasMap.put(aliasName, value);
			}
		}
		return entityAliasMap;
	}

	/**
	 * 获取实体类的所有别名列表
	 * 
	 * @param clazz
	 * @return
	 */
	public Map<String, String> getEntityPropertyAliasMap(Class clazz) {
		EntityProp entityProp = getEntityProp(clazz);
		String pk = null;
		Map<String, String> entityPropertyAliasMap = new HashMap<String, String>();
		if (null != entityProp) {
			List<FieldProp> fieldProps = entityProp.getFieldProps();
			for (FieldProp fieldProp : fieldProps) {
				String aliasName = fieldProp.getFieldName();
				entityPropertyAliasMap.put(aliasName, aliasName);
			}
		}
		return entityPropertyAliasMap;
	}
	
	/**
	 * 获取实体类的所有别名列表
	 * 
	 * @param clazz
	 * @return
	 */
	public List<String> getEntityAlias(Class clazz) {
		EntityProp entityProp = getEntityProp(clazz);
		String pk = null;
		List<String> entityAlias = new ArrayList<String>();
		if (null != entityProp) {
			List<FieldProp> fieldProps = entityProp.getFieldProps();
			for (FieldProp fieldProp : fieldProps) {
				String aliasName = fieldProp.getFieldName();
				if (ThreadUtils.getRTex().isNotEmpty(aliasName)) {
					entityAlias.add(aliasName);
				}
			}
		}
		return entityAlias;
	}

}

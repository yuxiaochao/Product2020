package com.huarui.common.utils;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.huarui.common.cache.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * 实体类工具
 * 
 * @author Administrator
 * 
 */
public class EntityUtil {
	private static final Logger logger = LoggerFactory.getLogger(EntityUtil.class);

	/**
	 * Map转实体类
	 * 
	 * @param entity
	 * @return
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public Object map2Entity(Object entity, Map paramsMap)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		if (null != entity && null != paramsMap) {
			List<String> list = ThreadUtils.getEntityCaches().getEntityPropertys(entity.getClass());
			for (String key : list) {
				if (paramsMap.containsKey(key)) {
					Object value = paramsMap.get(key);
					ThreadUtils.getReflectUtil().setEntityMethod(entity, key, value);
				}else if(paramsMap.containsKey(key.toUpperCase())){
					//自定义字段字段名称为大写，需要进行判断
					Object value = paramsMap.get(key.toUpperCase());
					ThreadUtils.getReflectUtil().setEntityMethod(entity, key, value);
				}
			}
		}
		return entity;
	}

	/**
	 * Map转实体类
	 * 
	 * @return
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 */
	public Object map2Entity(Class clazz, Map paramsMap)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Object entity = null;
		if (null != clazz && null != paramsMap) {
			entity = clazz.newInstance();
			entity = map2Entity(entity, paramsMap);
		}
		return entity;
	}

	/**
	 * Map转实体类
	 * 
	 * @param entity
	 * @return
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public Object map2Entity(Object entity, Map paramsMap, boolean alias) throws NoSuchFieldException,
            SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		if (null != entity) {
			if (!alias) {
				entity = map2Entity(entity, paramsMap);
			} else {
				if (null != entity) {
					Map<String, String> fieldAliasMap = ThreadUtils.getEntityCaches()
							.getEntityAliasMap(entity.getClass());
					Map<String, Object> aliasMap = new HashMap<String, Object>();
					Set<String> fieldAliasKeys = fieldAliasMap.keySet();
					for (String aliasName : fieldAliasKeys) {
						if (ThreadUtils.getRTex().isNotEmpty(aliasName)) {
							Object value = paramsMap.get(aliasName);
							aliasMap.put(fieldAliasMap.get(aliasName), value);
						}
					}
					entity = map2Entity(entity, aliasMap);
				}
			}
		}
		return entity;
	}

	/**
	 * 实体类转Map
	 * 
	 * @param entity
	 * @return
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public Map<String, Object> entity2Map(Object entity)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Map<String, Object> dataMap = new LinkedHashMap<String, Object>();
		if (null != entity) {
			List<String> methodList = ThreadUtils.getEntityCaches().getEntityPropertys(entity.getClass());
			for (String methodName : methodList) {
				String key = methodName;
/*				String value = ThreadUtils.getRTex().toString(ThreadUtils.getReflectUtil().getEntityMethod(entity, methodName), "");
				if (!ThreadUtils.getRTex().isEmpty(value)) {
					dataMap.put(key, value);
				}*/
				Object value = ThreadUtils.getReflectUtil().getEntityMethod(entity, methodName);
				dataMap.put(key, value);
			}
		}
		return dataMap;
	}

	/**
	 * 实体类转Map
	 * 
	 * @param entity
	 * @return
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public Map<String, Object> entity2Map(Object entity, boolean alias) throws NoSuchFieldException, SecurityException,
            IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		if (null != entity) {
			dataMap = entity2Map(entity);
			if (alias) {
				if (null != entity) {
					Map fieldAliasMap = ThreadUtils.getEntityCaches().getEntityAliasMap(entity.getClass());
					if (null != fieldAliasMap) {
						Map<String, Object> aliasMap = new HashMap<String, Object>();
						Set<String> fieldAliasKeys = fieldAliasMap.keySet();
						for (String aliasName : fieldAliasKeys) {
							if (ThreadUtils.getRTex().isNotEmpty(aliasName)) {
								Object value = dataMap.get(fieldAliasMap.get(aliasName));
								aliasMap.put(aliasName, value);
							}
						}
						dataMap.putAll(aliasMap);
					}
				}
			}
		}
		return dataMap;
	}
	
	public BingDataEntity getBingDataEntity(String className) throws ClassNotFoundException, SecurityException,
            IllegalArgumentException, NoSuchFieldException, IllegalAccessException, InvocationTargetException {
		Class clazz = getModeEntityForName(className);
		BingDataEntity bingDataEntity = null;
		if (null != clazz) {
			bingDataEntity = getBingDataEntity(clazz);
		}
		return bingDataEntity;
	}
	
	/**
	 * 根据实体类简单F名称得到模型实体类
	 * 
	 * @param entityClassName
	 * @return
	 * @throws ClassNotFoundException
	 */
	public Class getModeEntityForName(String entityClassName) throws ClassNotFoundException {
		Class clazz = null;
		if (ThreadUtils.getRTex().isNotEmpty(entityClassName)) {
			if (!entityClassName.matches("com.*.entity.*")) {
				entityClassName = ThreadUtils.getRTex().toUpperCaseFirstOne(entityClassName);
				entityClassName = "com.huarui.product2020.entity." + entityClassName;
			}
			try {
				clazz = ThreadUtils.getReflectUtil().getClassForName(entityClassName);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return clazz;
	}
	
	public BingDataEntity getBingDataEntity(Class clazz) {
		BingDataEntity bingDataEntity = null;
		if (null != clazz) {
			bingDataEntity = SystemCache.getBingDataEntityCache().get(clazz.getName());
			if (null == bingDataEntity) {
				EntityProp entityProp = ThreadUtils.getEntityCaches().getEntityProp(clazz);
				if (null != entityProp) {
					bingDataEntity = new BingDataEntity();
					bingDataEntity.setPk(entityProp.getPk());
					bingDataEntity.setEntityClass(clazz.getName());
					List<FieldProp> fieldProps = entityProp.getFieldProps();
					if (null != fieldProps) {
						List<BingColumnEntity> bingColumnList = new ArrayList<BingColumnEntity>();
						for (FieldProp fieldProp : fieldProps) {
							BingColumnEntity bingColumn = getBingColumnEntity(fieldProp);
							if (null != bingColumn) {
								bingColumnList.add(bingColumn);
							}
						}
						bingDataEntity.setBingColumns(bingColumnList);
						SystemCache.getBingDataEntityCache().put(clazz.getName(), bingDataEntity);
						logger.info(clazz.getName() + "实体类绑定缓存创建成功");
					}
				}
			}
		}
		return bingDataEntity;
	}

	/**
	 * 实体类属性转字段绑定
	 * 
	 * @param fieldProp
	 * @return
	 */
	public BingColumnEntity getBingColumnEntity(FieldProp fieldProp) {
		BingColumnEntity bingColumn = null;
		if (null != fieldProp) {

			String fieldName = fieldProp.getFieldName();
			if (!fieldName.endsWith("Text")) {
				bingColumn = new BingColumnEntity();
				bingColumn.setDataName(fieldProp.getFieldName());

			}
		}
		return bingColumn;
	}
	
	/**
	 * beseEntity 转实体类描述
	 * 
	 * @param baseEntityClass
	 */
	public EntityProp BaseEntityClassToEntityProp(Class baseEntityClass) {
		EntityProp entityProp = null;
		if (null != baseEntityClass && Model.class.isAssignableFrom(baseEntityClass)) {
			entityProp = new EntityProp(baseEntityClass);
			List<FieldProp> fieldPropList = getFieldPropForEntityClass(baseEntityClass);
			entityProp.setPk(getEntityPK(baseEntityClass));
			entityProp.setFieldProps(fieldPropList);
		}
		return entityProp;
	}
	
	/**
	 * 获取实体类字段的描述注解信息
	 * 
	 * @param baseEntityClass
	 * @return
	 */
	public String getEntityPK(Class baseEntityClass) {
		String pkColumn = "";
		List<FieldProp> fieldPropList = getFieldPropForEntityClass(baseEntityClass);
		for (FieldProp fieldProp : fieldPropList) {
			if (fieldProp.isPK()) {
				pkColumn = fieldProp.getFieldName();
			}
		}
		return pkColumn;
	}
	
	/**
	 * 获取所有实体类字段的描述注解信息
	 * 
	 * @param baseEntityClass
	 * @return
	 */
	public List<FieldProp> getFieldPropForEntityClass(Class baseEntityClass) {
		List<FieldProp> fieldPropList = null;
		if (null != baseEntityClass && Model.class.isAssignableFrom(baseEntityClass)) {
			fieldPropList = new ArrayList<FieldProp>();
			List<String> propertyList = ThreadUtils.getReflectUtil().getEntityPropertyCollection(baseEntityClass);
			for (String property : propertyList) {
				Field field = ThreadUtils.getReflectUtil().getEntityField(baseEntityClass, property);
				FieldProp fieldProp = new FieldProp();
				if (null != field && (!field.getName().contains("serialVersionUID"))) {
					fieldProp.setFieldName(field.getName());
					fieldProp.setEntityClassName(baseEntityClass.getName());
					fieldProp.setFieldType(field.getType());
					fieldPropList.add(fieldProp);
				}

			}
		}
		return fieldPropList;
	}
	
	/**
	 * 获取某个实体的主键
	 * @return
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 */
	public <T extends Model<T>> String getEntityPk(Class<T> clazz) throws Exception {
		String value = "";
		List<String> entityPropertyCollection = ThreadUtils.getReflectUtil().getEntityPropertyCollection(clazz);
		for (String fieldName : entityPropertyCollection) {
			Field field = ThreadUtils.getReflectUtil().getField(clazz, fieldName);
			Annotation annotation = ThreadUtils.getReflectUtil().getAnnotation(field, TableId.class);
			if (null != annotation) {
				value = ((TableId)annotation).value();
				break;
			}
		}
		
		return value;
	}

	/**
	 * 对象数据 签名
	 *
	 * @param entity
	 * @return
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public String entityToString(Object entity)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Map entityMap = new HashMap();
		if (null != entity) {
			entityMap = entity2Map(entity);
		}

		return entityMap.toString();
	}
	

}

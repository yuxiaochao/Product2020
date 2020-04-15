package com.huarui.common.utils;

import com.huarui.common.cache.Entity;
import org.apache.commons.beanutils.ConvertUtils;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.net.URL;
import java.net.URLClassLoader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;


public class ReflectUtil {
	/**
	 * 得到泛型的类型
	 * 
	 * @param clazz
	 * @return
	 */
	public Class getGenericParmeterType(Class clazz) {
		Type type = clazz.getGenericSuperclass();
		Class<?> genericClass = null;
		if (type instanceof ParameterizedType) {
			ParameterizedType pt = (ParameterizedType) type;
//			Type[] types = pt.getActualTypeArguments();
//			genericClass = (Class<?>) types[0];
			Type claz = pt.getActualTypeArguments()[0];
            if( claz instanceof Class){
                genericClass = (Class<?>) claz;
            }
		}
		return genericClass;
	}

	/**
	 * 得到实体类的 字段
	 * 
	 * @param clazz
	 * @param filedName
	 * @return
	 */
	public Field getEntityField(Class clazz, String filedName) {
		Field[] fs = clazz.getDeclaredFields();
		Field fd = null;
		for (Field field : fs) {
			String name = field.getName();
			if (name.equals(filedName)) {
				fd = field;
				break;
			}
		}
		return fd;
	}

	/**
	 * 得到实体类所有属性
	 */
	public List<String> getEntityPropertyCollection(Class clazz) {
		Field[] fs = clazz.getDeclaredFields();
		List<String> propertys = new ArrayList<String>(fs.length);
		for (Field field : fs) {
			propertys.add(field.getName());
		}
		return propertys;
	}

	/**
	 * 得到实体类所有属性
	 */
	public List<String> getEntityPropertyCollection(Class clazz, boolean isalias) {
		List<String> propertys = getEntityPropertyCollection(clazz);
		List<String> allPropertys = new ArrayList<String>();
		allPropertys.addAll(propertys);
		if (isalias) {
			List<String> aliasList = ThreadUtils.getEntityCaches().getEntityAlias(clazz);
			if (null == aliasList || aliasList.size() <= 0) {
				aliasList = getEntityPropertyCollection(clazz);
			}
			if (null != aliasList) {
				allPropertys.addAll(aliasList);
			}
		}
		return allPropertys;
	}

	/**
	 * 得到实体类属性的类型
	 * 
	 * @param clazz
	 * @param propertys
	 * @return
	 */
	public Class[] getEntityPropertyType(Class clazz, String... propertys) {
		String[] propertyTypes = propertys;
		Class[] propertyClassTypes = new Class[propertyTypes.length];
		for (int i = 0; i < propertyTypes.length; i++) {
			Field field = getEntityField(clazz, propertyTypes[i]);
			propertyClassTypes[i] = field.getType();
		}

		return propertyClassTypes;
	}

	/**
	 * 得到所有名称和属性类型列表
	 * 
	 * @return
	 */
	public Map<String, String> getEntityPropertyOrTypeCollection(Class clazz) {
		Field[] fs = clazz.getDeclaredFields();
		Map<String, String> propertysType = new HashMap<String, String>(fs.length);
		for (Field field : fs) {
			String fieldType = field.getType().getName();
			String fieldName = field.getName();
			propertysType.put(fieldName, fieldType);
		}
		return propertysType;
	}

	/**
	 * 执行一个方法得到一个值
	 * 
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public Object getMethodValue(Object entity, String methodName)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Object value = null;
		Method method = getMethod(entity, methodName, null);
		if (null != method) {
			value = method.invoke(entity);
		}
		return value;
	}

	/**
	 * 根据方法名称获取方法实例
	 * 
	 * @param entity
	 * @param methodName
	 * @return
	 */
	public Method getMethod(Object entity, String methodName, Class[] fieldTypes) {
		Method method = null;
		if (ThreadUtils.getRTex().isAnyEmpty(entity, methodName)) {
			return null;
		}
		Method[] methods = getMethods(entity);
		if (null == methods) {
			return null;
		}
		for (Method _method : methods) {
			if (methodName.equals(_method.getName())) {
				if (null == fieldTypes) {
					method = _method;
					break;
				} else {
					Class[] clazzs = _method.getParameterTypes();
					if (checkParameterType(clazzs, fieldTypes)) {
						method = _method;
						break;
					}
				}

			}
		}
		return method;
	}

	public boolean checkParameterType(Class[] clazz1, Class[] clazz2) {
		if (ThreadUtils.getRTex().isAllEmpty(clazz1, clazz2)) {
			return true;
		}
		if (clazz1.length != clazz2.length) {
			return false;
		}
		boolean flag = true;
		for (int i = 0; i < clazz1.length; i++) {
			String cls1Name = clazz1[i].getName();
			String cls2Name = clazz2[i].getName();
			if (!cls1Name.equals(cls2Name)) {
				flag = false;
				break;
			}
		}
		return flag;
	}

	/**
	 * 根据所有的方法实例
	 * 
	 * @param entity
	 * @return
	 */
	public Method[] getMethods(Object entity) {
		Method[] methods = null;
		if (null != entity) {
			methods = entity.getClass().getMethods();
		}
		return methods;
	}

	/**
	 * 执行一个方法得并向一个属性中赋值
	 * 
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public Object setMethodValue(Object entity, String methodName, Class[] fieldTypes, Object[] values)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method method = getMethod(entity, methodName, fieldTypes);
		if (method != null) {
			method.invoke(entity, values);
		}
		return entity;
	}

	/**
	 * 判断一个对象是否包含一个属性
	 * 
	 * @return
	 */
	public boolean containProperty(Class clazz, String property) {
		boolean flag = false;
		if (null != clazz) {
			List<String> propertyList = getEntityPropertyCollection(clazz);
			if (null != propertyList) {
				flag = propertyList.contains(property);
			}
			propertyList = null;
		}
		return flag;
	}

	/**
	 * 判断一个对象是否包含一个属性
	 * 
	 * @return
	 */
	public boolean containProperty(Class clazz, String property, boolean isalias) {
		boolean flag = false;
		if (null != clazz) {
			List<String> propertyList = ThreadUtils.getReflectUtil().getEntityPropertyCollection(clazz, true);
			if (null != propertyList) {
				flag = propertyList.contains(property);
			}
			propertyList = null;
		}
		return flag;
	}

	/**
	 * 根据属性生成方法名称
	 * 
	 * @param entity
	 * @param property
	 * @param prefix
	 * @return
	 */
	public String generateMethod(Object entity, String property, String prefix) {
		String methodName = null;
		if (null != entity) {
			if (containProperty(entity.getClass(), property)) {
				Map<String, String> propertyTypeList = getEntityPropertyOrTypeCollection(entity.getClass());
				if (propertyTypeList.containsKey(property)) {
					String fieldType = propertyTypeList.get(property);
					Entity ent = new Entity();
					ent.setFieldName(property);
					ent.setFieldType(fieldType);
					methodName = createMethodName(ent, prefix);
				}
			}
		}
		return methodName;
	}

	/**
	 * Object 类型转换
	 * 
	 * @param obj
	 * @param type
	 * @return
	 */
	public Object converObjectToType(Object obj, Class type) {
		if (null!=obj) {
			// 日期字符串转Date
	        if (type.equals(Date.class) && obj instanceof String) {
	        	try {
	        		long timeLong = Long.parseLong(ThreadUtils.getRTex().toString(obj));
	        		Date date=new Date();
	        		date.setTime(timeLong);
	        		obj = date;
	        	}catch (Exception e) {
	        		String date = ThreadUtils.getRTex().toString(obj);
		        	String dateString = DateFormatToString.getDateFormat(date);
		        	SimpleDateFormat sdf = new SimpleDateFormat(dateString);
		        	try {
		        		obj = sdf.parse(date);
					} catch (ParseException e2) {
						e2.printStackTrace();
					}
				}
	        	
	        }else {
	        	obj = ConvertUtils.convert(obj, type);
	        }
		}
		return obj;
	}

	/**
	 * 获取类型的默认值
	 * 
	 * @param type
	 * @return
	 */
	public Object getDefaultValue(Class type) {
		Object defValue = null;
		if (null != type) {
			if (String.class.isAssignableFrom(type)) {
				defValue = "";
			} else if (Integer.class.isAssignableFrom(type)) {
				defValue = 0;
			} else if (Boolean.class.isAssignableFrom(type)) {
				defValue = false;
			} else if (Long.class.isAssignableFrom(type)) {
				defValue = 0L;
			} else if (Double.class.isAssignableFrom(type)) {
				defValue = 0;
			} else if (Date.class.isAssignableFrom(type)) {
				defValue = null;
			}
		}
		return defValue;
	}


	/**
	 * 将Object 转换成指定的数据类型
	 * 
	 * @param types
	 * @param values
	 * @return
	 */
	public Object[] converObjectToTypes(Class[] types, Object[] values) {
		int size = Math.min(types.length, values.length);
		for (int i = 0; i < size; i++) {
			final Class<?> sourceType = values[i].getClass();
			if(!sourceType.equals(types[i])) {//类型不相等时才转换
				values[i] = converObjectToType(values[i], types[i]);
			}
		}
		return values;
	}

	/**
	 * 将Object 转换成指定的数据类型
	 * 
	 * @param values
	 * @return
	 */
	public Object[] converParameterType(Class[] fieldTypes, Object[] values) {
		return converObjectToTypes(fieldTypes, values);
	}

	/**
	 * 生成Get方法名称
	 * 
	 * @return
	 */
	public String generateGetMethod(Object entity, String property) {
		return generateMethod(entity, property, "get");
	}

	/**
	 * 生成Set方法名称
	 * 
	 * @return
	 */
	public String generateSetMethod(Object entity, String property) {
		return generateMethod(entity, property, "set");
	}

	/**
	 * 创建一个方法
	 * 
	 * @param entity
	 * @param prefix
	 * @return
	 */
	public String createMethodName(Entity entity, String prefix) {
		String property = entity.getFieldName();
		String type = entity.getFieldType();
		String method = "";
		if ("get".equals(prefix)) {
			if ("java.lang.Boolean".equals(type)) {
				method = "is" + ThreadUtils.getRTex().toUpperCaseFirstOne(property);
			} else if ("boolean".equals(type)) {
				return "is" + ThreadUtils.getRTex().toUpperCaseFirstOne(property);
			} else {
				method = prefix + ThreadUtils.getRTex().toUpperCaseFirstOne(property);
			}
		} else if ("set".equals(prefix)) {
			method = prefix + ThreadUtils.getRTex().toUpperCaseFirstOne(property);
		} else {
			method = prefix + property;
		}
		return method;

	}

	/**
	 * 执行一个属性的Get方法
	 * 
	 * @param entity
	 * @param methodName
	 * @return
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public Object getEntityMethod(Object entity, String methodName)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String getMethod = generateGetMethod(entity, methodName);
		return getMethodValue(entity, getMethod);
	}

	/**
	 * 执行一个Set方法 将一个值填入实体类中
	 * 
	 * @param entity
	 * @return
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public Object setEntityMethod(Object entity, String fieldName, Object value)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Object obj = null;
		if (null != entity) {
			String getMethod = generateSetMethod(entity, fieldName);
			Class[] fieldTypes = getEntityPropertyType(entity.getClass(), fieldName);
			Class fieldType = fieldTypes[0];
			Object[] values = { value };
			values = converParameterType(fieldTypes, values);
			obj = setMethodValue(entity, getMethod, fieldTypes, values);
		}
		return obj;
	}

//	/**
//	 * 特殊类型转换类
//	 * 
//	 * @return
//	 */
//	public Object specialTypeConver(Class entityClazz, Class fieldType, Object value, String methodName) {
//		Object newValue = value;
//		// 字符串日期与date类型转换
//		if (String.class.isAssignableFrom(value.getClass()) && Date.class.isAssignableFrom(fieldType)) {
//			newValue = null;
//			if (ThreadUtils.getRTex().isAllNotEmpty(entityClazz, fieldType, value, methodName)) {
//
//				FieldProp fieldProp = ThreadUtils.getEntityCaches().getEntityFieldProp(entityClazz, methodName);
//				if (null != fieldProp) {
//					String dateConverter = "";
//					DataConverter dataConverter = fieldProp.getDataConverter();
//					DateTimeFormat dateTimeFormat = fieldProp.getDateTimeFormat();
//					if (null != dataConverter && dataConverter.converter() == ConverterType.DATE) {
//						dateConverter = dataConverter.expression();
//					} else if (null != dateTimeFormat) {
//						dateConverter = dateTimeFormat.pattern();
//					}
//					if (ThreadUtils.getRTex().isNotEmpty(value)) {
//						if (ThreadUtils.getRTex().isNotEmpty(dateConverter)) {
//							newValue = ThreadUtils.getRDate().dateFormat(ThreadUtils.getRTex().toString(value),
//									dateConverter);
//						} else {
//							newValue = ThreadUtils.getRDate().autoDateFormat(ThreadUtils.getRTex().toString(value));
//						}
//					}
//
//				}
//			}
//		}
//		return newValue;
//	}

	/**
	 * 执行一个Set方法 将一个值填入实体类中
	 * 
	 * @param entity
	 * @param methodName
	 * @return
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public Object setEntityMethod(Object entity, String methodName, Object value, boolean isalias)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Map map = ThreadUtils.getEntityCaches().getEntityPropertyAliasMap(entity.getClass());
		if (map.containsKey(methodName)) {
			setEntityMethod(entity, methodName, value);
		} else if (map.containsValue(methodName)) {
			methodName = ThreadUtils.getRTex().getKeyForMap(map, methodName);
			setEntityMethod(entity, methodName, value);
		}
		return entity;
	}

	/**
	 * 根据Class 得到Annotation数组
	 * 
	 * @param clazz
	 * @return
	 */
	public Annotation[] getAnnotations(Class clazz) {
		Annotation[] annotations = clazz.getAnnotations();
		return annotations;
	}

	/**
	 * 得到一个类的注解
	 * 
	 * @param clazz
	 * @param annotationClass
	 * @return
	 */
	public Annotation getAnnotation(Class clazz, Class annotationClass) {
		return clazz.getAnnotation(annotationClass);
	}

	
	/**
	 * 获取Object的类型
	 * @param value
	 * @return
	 */
	public Class getObjectType(Object value){
		Class sourceType = Object.class;
		if(null!=value){
			if(value instanceof String){
				sourceType = String.class;
			}else if(value instanceof Integer){
				sourceType = Integer.class;
			}else if(value instanceof Long){
				sourceType = Long.class;
			}else if(value instanceof Date){
				sourceType = Date.class;
			}
		}
		return sourceType;
	}
	
	/**
	 * 得到一个字段的注解
	 * 
	 * @param field
	 * @param annotationClass
	 * @return
	 */
	public Annotation getAnnotation(Field field, Class annotationClass) {
		return field.getAnnotation(annotationClass);
	}

	/**
	 * 检查实体类是否包含某个注解
	 * 
	 * @param annotationClass
	 * @return
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 */
	public boolean containerAnnotation(Object obj, Class annotationClass)
			throws NoSuchFieldException, SecurityException {
		boolean flag = false;
		if (null != obj) {
			Annotation[] annotations = getAnnotations(obj.getClass());
			if (annotations.length > 0) {
				flag = true;
			} else {
				Annotation annotation = null;
				List<String> fieldNames = getEntityPropertyCollection(obj.getClass());
				for (String fieldName : fieldNames) {
					Field field = getField(obj, fieldName);
					annotation = getAnnotation(field, annotationClass);
					if (null != annotation) {
						flag = true;
						break;
					}
				}
			}
		}
		return flag;
	}

	/**
	 * 得到对象的返回类型
	 * 
	 * @return
	 */
	public Class<?> getMethodType(Object obj, String methodName) {
		Class<?> returnType = null;
		if (null != obj) {
			Method[] methods = obj.getClass().getMethods();
			for (Method method : methods) {
				if (method.getName().equals(methodName)) {
					returnType = method.getReturnType();
					break;
				}
			}
		}

		return returnType;
	}

	/**
	 * 利用反射获取指定对象的指定属性的值
	 * 
	 * @param obj
	 *            目标对象
	 * @param fieldName
	 *            目标属性
	 * @return 目标属性的值
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 */
	public Object getFieldValue(Object obj, String fieldName)
			throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		Object result = null;
		Field field = getField(obj, fieldName);
		if (field != null) {
			field.setAccessible(true);
			result = field.get(obj);
		}
		return result;
	}

	/**
	 * 利用反射获取指定对象里面的指定属性
	 * 
	 * @param obj
	 *            目标对象
	 * @param fieldName
	 *            目标属性
	 * @return 目标字段
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 */
	public Field getField(Object obj, String fieldName) {
		Field field = null;
		if (obj != null) {
			for (Class<?> clazz = obj.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
				try {
					clazz.getDeclaredFields();
					field = clazz.getDeclaredField(fieldName);
				} catch (NoSuchFieldException e) {
					continue;
				}
				if (null != field) {
					break;
				}
			}
		}
		return field;
	}

	/**
	 * 利用反射获取指定对class里面的指定属性
	 *
	 * @param clazz
	 *            目标对象
	 * @param fieldName
	 *            目标属性
	 * @return 目标字段
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 */
	public Field getField(Class clazz, String fieldName) {
		Field field = null;
		if (clazz != null) {
				try {
					clazz.getDeclaredFields();
					field = clazz.getDeclaredField(fieldName);
				} catch (NoSuchFieldException e) {
					e.printStackTrace();
				}
		}
		return field;
	}

	/**
	 * 利用反射获取指定对象里面的所有指定属性 包括父类的属性
	 * 
	 * @param obj
	 *            目标对象
	 * @param fieldName
	 *            目标属性
	 * @return 目标字段
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 */
	private Field getAllField(Object obj, String fieldName) throws NoSuchFieldException, SecurityException {
		Field field = null;
		if (obj != null) {
			for (Class<?> clazz = obj.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
				field = clazz.getField(fieldName);
				if (null != field) {
					break;
				}

			}
		}
		return field;
	}

	/**
	 * 利用反射设置指定对象的指定属性为指定的值
	 * 
	 * @param obj
	 *            目标对象
	 * @param fieldName
	 *            目标属性
	 * @param fieldValue
	 *            目标值
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 */
	public void setFieldValue(Object obj, String fieldName, Object fieldValue)
			throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		Field field = getField(obj, fieldName);
		if (field != null) {
			field.setAccessible(true);
			field.set(obj, fieldValue);
		}
	}

	/**
	 * 利用反射设置指定对象的指定属性为指定的值
	 * 
	 * @param obj
	 *            目标对象
	 * @param fieldName
	 *            目标属性
	 * @param fieldValue
	 *            目标值
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 */
	public void setObjectValue(Object obj, String fieldName, Object fieldValue)
			throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		Field field = getAllField(obj, fieldName);
		if (field != null) {
			field.setAccessible(true);
			field.set(obj, fieldValue);
		}
	}

	/**
	 * 根据字符串创建class对象
	 * 
	 * @param className
	 * @return
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public Object getObjectForName(String className)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Object value = null;
		Class clazz = getClassForName(className);
		if (null != clazz) {
			value = clazz.newInstance();
		}
		return value;
	}

	/**
	 * 根据字符串创建class对象
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public Object getObjectForClass(Class clazz) throws InstantiationException, IllegalAccessException {
		Object value = null;
		if (null != clazz) {
			value = clazz.newInstance();
		}
		return value;
	}
	
	
	
	

	/**
	 * 根据字符串获取class
	 * 
	 * @param className
	 * @return
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public Class getClassForName(String className) throws ClassNotFoundException {
		Class clazz = null;
		if (ThreadUtils.getRTex().isNotEmpty(className)) {
			clazz = Class.forName(className);
		}
		return clazz;
	}

	/**
	 * 通过反射,获得定义Class时声明的父类的范型参数的类型. 如public BookManager extends GenricManager
	 * <Book>
	 * 
	 * @param clazz
	 *            The class to introspect
	 * @return the first generic declaration, or <code>Object.class</code> if
	 *         cannot be determined
	 */
	public Class getSuperClassGenricType(Class clazz) {
		return getSuperClassGenricType(clazz, 0);
	}

	/**
	 * 通过反射,获得定义Class时声明的父类的范型参数的类型. 如public BookManager extends GenricManager
	 * <Book>
	 * 
	 * @param clazz
	 *            clazz The class to introspect
	 * @param index
	 *            the Index of the generic ddeclaration,start from 0.
	 */
	public Class getSuperClassGenricType(Class clazz, int index) throws IndexOutOfBoundsException {

		Type genType = clazz.getGenericSuperclass();

		if (!(genType instanceof ParameterizedType)) {
			return Object.class;
		}

		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

		if (index >= params.length || index < 0) {
			return Object.class;
		}
		if (!(params[index] instanceof Class)) {
			return Object.class;
		}
		return (Class) params[index];
	}

	/**
	 * 
	 * @return
	 */
	public boolean isCollection(Object obj) {
		boolean flag = false;
		if (obj instanceof List) {
			flag = true;
		} else if (obj instanceof Set) {
			flag = true;
		}
		return flag;
	}

	/**
	 * 
	 * @param clazz
	 * @return
	 */
	public boolean isCollection(Class clazz) {
		String className = clazz.getName();
		boolean falg = false;
		if ("java.util.List".equals(className)) {
			falg = true;
		} else if ("java.util.Set".equals(className)) {
			falg = true;
		}
		return falg;
	}

	/**
	 * 获取某包下（包括该包的所有子包）所有类
	 * 
	 * @param packageName
	 *            包名
	 * @return 类的完整名称
	 */
	public static List<String> getPackageClassName(String packageName) {
		return getPackageClassName(packageName, true);
	}

	/**
	 * 获取某包下所有类
	 * 
	 * @param packageName
	 *            包名
	 * @param childPackage
	 *            是否遍历子包
	 * @return 类的完整名称
	 */
	public static List<String> getPackageClassName(String packageName, boolean childPackage) {
		List<String> fileNames = null;
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		String packagePath = packageName.replace(".", "/");
		URL url = loader.getResource(packagePath);
		if (url != null) {
			String type = url.getProtocol();
			if (type.equals("file")) {
				fileNames = getClassNameByFile(url.getPath(), null, childPackage);
			} else if (type.equals("jar")) {
				fileNames = getClassNameByJar(url.getPath(), childPackage);
			}
		} else {
			fileNames = getClassNameByJars(((URLClassLoader) loader).getURLs(), packagePath, childPackage);
		}
		return fileNames;
	}

	/**
	 * 从项目文件获取某包下所有类
	 * 
	 * @param filePath
	 *            文件路径
	 * @param className
	 *            类名集合
	 * @param childPackage
	 *            是否遍历子包
	 * @return 类的完整名称
	 */
	private static List<String> getClassNameByFile(String filePath, List<String> className, boolean childPackage) {
		List<String> myClassName = new ArrayList<String>();
		File file = new File(filePath);
		File[] childFiles = file.listFiles();
		for (File childFile : childFiles) {
			if (childFile.isDirectory()) {
				if (childPackage) {
					myClassName.addAll(getClassNameByFile(childFile.getPath(), myClassName, childPackage));
				}
			} else {
				String childFilePath = childFile.getPath();
				if (childFilePath.endsWith(".class")) {
					childFilePath = childFilePath.substring(childFilePath.indexOf("\\classes") + 9,
							childFilePath.lastIndexOf("."));
					childFilePath = childFilePath.replace("\\", ".");
					myClassName.add(childFilePath);
				}
			}
		}

		return myClassName;
	}

	/**
	 * 从jar获取某包下所有类
	 * 
	 * @param jarPath
	 *            jar文件路径
	 * @param childPackage
	 *            是否遍历子包
	 * @return 类的完整名称
	 */
	private static List<String> getClassNameByJar(String jarPath, boolean childPackage) {
		List<String> myClassName = new ArrayList<String>();
		String[] jarInfo = jarPath.split("!");
		String jarFilePath = jarInfo[0].substring(jarInfo[0].indexOf("/"));
		String packagePath = jarInfo[1].substring(1);
		try {
			JarFile jarFile = new JarFile(jarFilePath);
			Enumeration<JarEntry> entrys = jarFile.entries();
			while (entrys.hasMoreElements()) {
				JarEntry jarEntry = entrys.nextElement();
				String entryName = jarEntry.getName();
				if (entryName.endsWith(".class")) {
					if (childPackage) {
						if (entryName.startsWith(packagePath)) {
							entryName = entryName.replace("/", ".").substring(0, entryName.lastIndexOf("."));
							myClassName.add(entryName);
						}
					} else {
						int index = entryName.lastIndexOf("/");
						String myPackagePath;
						if (index != -1) {
							myPackagePath = entryName.substring(0, index);
						} else {
							myPackagePath = entryName;
						}
						if (myPackagePath.equals(packagePath)) {
							entryName = entryName.replace("/", ".").substring(0, entryName.lastIndexOf("."));
							myClassName.add(entryName);
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return myClassName;
	}

	/**
	 * 从所有jar中搜索该包，并获取该包下所有类
	 * 
	 * @param urls
	 *            URL集合
	 * @param packagePath
	 *            包路径
	 * @param childPackage
	 *            是否遍历子包
	 * @return 类的完整名称
	 */
	private static List<String> getClassNameByJars(URL[] urls, String packagePath, boolean childPackage) {
		List<String> myClassName = new ArrayList<String>();
		if (urls != null) {
			for (int i = 0; i < urls.length; i++) {
				URL url = urls[i];
				String urlPath = url.getPath();
				// 不必搜索classes文件夹
				if (urlPath.endsWith("classes/")) {
					continue;
				}
				String jarPath = urlPath + "!/" + packagePath;
				myClassName.addAll(getClassNameByJar(jarPath, childPackage));
			}
		}
		return myClassName;
	}

	public boolean isBasicType(Object obj) {
		boolean flag = false;
		if (obj instanceof Boolean) {
			flag = true;
		} else if (obj instanceof Byte) {
			flag = true;
		} else if (obj instanceof Short) {
			flag = true;
		} else if (obj instanceof Character) {
			flag = true;
		} else if (obj instanceof Integer) {
			flag = true;
		} else if (obj instanceof Long) {
			flag = true;
		} else if (obj instanceof Float) {
			flag = true;
		} else if (obj instanceof Double) {
			flag = true;
		}
		return flag;
	}
}

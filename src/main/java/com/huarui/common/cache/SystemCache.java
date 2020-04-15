package com.huarui.common.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class SystemCache {
	
	private static Map<String, EntityProp> ENTITY_PROP_CACHE = new ConcurrentHashMap<String, EntityProp>();
	
	private static Map<String, String> SYSTEM_CACHE = new ConcurrentHashMap<String, String>();

	private static Map<String, String> COUNT_SQL_CACHE = new ConcurrentHashMap<String, String>();

	private static Map<String, String> PAGE_SQL_CACHE = new ConcurrentHashMap<String, String>();

	private static Map<String, String> ENTITY_SQL_CACHE = new ConcurrentHashMap<String, String>();

	private static Map<String, BingDataEntity> BINGDATA_ENTITY_CACHE = new ConcurrentHashMap<String, BingDataEntity>();

	public static Map<String, EntityProp> getEntityPropCache() {
		return ENTITY_PROP_CACHE;
	}

	public static Map<String, String> getCountSqlCache() {
		return COUNT_SQL_CACHE;  
	}

	public static Map<String, String> getPageSqlCache() {
		return PAGE_SQL_CACHE;
	}

	public static Map<String, String> getEntitySqlCache() {
		return ENTITY_SQL_CACHE;
	}

	public static Map<String, BingDataEntity> getBingDataEntityCache() {
		return BINGDATA_ENTITY_CACHE;
	}

	
	public static Map<String, String> getSystemCache(){
		return SYSTEM_CACHE;
	}

}

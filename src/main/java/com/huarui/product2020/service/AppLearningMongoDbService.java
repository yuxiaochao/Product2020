package com.huarui.product2020.service;

import com.huarui.product2020.entity.base.StudyMgdbUserProgessEntity;

import java.util.Map;


public interface AppLearningMongoDbService {
	
	/**
	 * 查询播放缓存
	 * @param map
	 * @return
	 */
	public StudyMgdbUserProgessEntity findeOnePlayCache(Map map);
	
	/**
	 * 缓存当前课件进度
	 * @param args
	 * @return
	 * @throws Exception
	 */
	public int cacheCoursewareProgress(Map map) throws Exception;

}

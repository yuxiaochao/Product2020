package com.huarui.product2020.service.impl;

import com.huarui.common.mongodb.AppLearningMongoDbDAO;
import com.huarui.product2020.entity.base.StudyMgdbUserProgessEntity;
import com.huarui.product2020.service.AppLearningMongoDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class AppLearningMongoDbServiceImpl implements AppLearningMongoDbService {
	
	@Autowired
	private AppLearningMongoDbDAO appLearningMongoDbDAO;
	
	/**
	 * 查询播放缓存
	 * @param map
	 * @return
	 */
	public StudyMgdbUserProgessEntity findeOnePlayCache(Map map) {
		return appLearningMongoDbDAO.findeOnePlayCache(map);
	}
	
	/**
	 * 缓存当前课件进度
	 * @return
	 * @throws Exception
	 */
	public int cacheCoursewareProgress(Map map) throws Exception {
		return appLearningMongoDbDAO.cacheCoursewareProgress(map);
	}

}

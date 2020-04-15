package com.huarui.common.mongodb;

import com.huarui.common.utils.ThreadUtils;
import com.huarui.product2020.entity.base.StudyMgdbUserProgessEntity;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;


@Repository
public class AppLearningMongoDbDAOImpl implements AppLearningMongoDbDAO {


	@Autowired
	private MongoTemplate mongoTemplate;
	
	/**
	 * 查询播放缓存
	 * @param map
	 * @return
	 */
	public StudyMgdbUserProgessEntity findeOnePlayCache(Map map) {
		StudyMgdbUserProgessEntity cacheMap = null;
		String upro003 = ObjectUtils.toString(map.get("upro003")); /* 用户ID*/
		String upro002 = ObjectUtils.toString(map.get("upro002")); /* 学习课程结果表id*/
		String upro004 = ObjectUtils.toString(map.get("upro004")); /* 章节ID*/
		try{
			Query query = new Query(Criteria.where("upro003").is(upro003).and("upro002").is(upro002).and("upro004").is(upro004));
			cacheMap = mongoTemplate.findOne(query, StudyMgdbUserProgessEntity.class);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return cacheMap;
	}

	/**
	 * 缓存当前课件进度
	 * @return
	 * @throws Exception
	 */
	public int cacheCoursewareProgress(Map map) throws Exception {
		String upro003 = ObjectUtils.toString(map.get("upro003")); /* 用户ID*/
		String upro002 = ObjectUtils.toString(map.get("upro002")); /* 学习课程结果表id*/
		String upro004 = ObjectUtils.toString(map.get("upro004")); /* 章节ID*/
		int upro005 = Integer.parseInt(new java.text.DecimalFormat("###").format(Double.valueOf(ObjectUtils.toString(map.get("upro005"),"0"))));
		Date nowTime=new Date();
		SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String upro008 = ObjectUtils.toString(map.get("upro008")); /* 登陆日志*/
		String upro009 = ObjectUtils.toString(map.get("upro009")); /* 学习端类型*/
		String upro010 = ObjectUtils.toString(map.get("upro010")); /* 是否学完 （0未完成 1已完成）*/
		int num = 1;
		try{
			Query query = new Query(Criteria.where("upro003").is(upro003).and("upro002")
					.is(upro002).and("upro004").is(upro004));

			Update update = new Update().set("upro005",upro005).set("upro010", upro010).
					set("upro007", time.format(nowTime)).set("upro008", upro008)
					.set("upro009", upro009); /*eturnNew(false).upsert(false) 只做更新操作，防止每次都更新开始时间*/

			StudyMgdbUserProgessEntity studyMgdbUserProgessEntity = mongoTemplate
					.findAndModify(query, update,new FindAndModifyOptions()
							.returnNew(false).upsert(false),StudyMgdbUserProgessEntity.class);

			if(studyMgdbUserProgessEntity == null) {
				update = new Update().set("upro001", ThreadUtils.getRTex().getUUID())
						.set("upro005",upro005).set("upro006",time.format(nowTime)).set("upro010", 0)
						.set("upro007", time.format(nowTime)).set("upro008", upro008).set("upro009", upro009);
				mongoTemplate.findAndModify(query, update,new FindAndModifyOptions().returnNew(true).upsert(true),StudyMgdbUserProgessEntity.class);
			}
		}catch(Exception e){
			num = 0;
			e.printStackTrace();
		} finally {
		}
		return num;
	}

}

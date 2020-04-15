package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.common.Req;
import com.huarui.common.utils.IPage;
import com.huarui.product2020.entity.ExamTTestactivity;
import com.huarui.product2020.entity.ExamTTesttx;
import com.huarui.product2020.entity.ResultEntity;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface TeachingDesignTestPaperService extends IService<ExamTTestactivity> {

	ResultEntity insertOrUpdateTestPaper(Req req) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SecurityException, NoSuchFieldException, Exception;

	List<HashMap<String, Object>> queryKnowledgeList(Map<String, Object> map);

	List<HashMap<String, Object>> testPaperTopicCount(Req req);

	List<ExamTTesttx> queryTestTx(String ids);

	List<Map<String, Object>> queryTestPaperTactic(Req req);

	List<ExamTTestactivity> findByPage(IPage<ExamTTestactivity> page, Req req);
	/**
	 * 根据试卷id删除试卷以及关联表
	 * @param tact001
	 * @return
	 */
	void deleteTestPaper(String tact001);
	
}

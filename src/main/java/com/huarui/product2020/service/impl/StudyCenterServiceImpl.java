package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.huarui.common.utils.IPage;
import com.huarui.common.utils.RText;
import com.huarui.common.utils.ThreadUtils;
import com.huarui.product2020.entity.StudyTFav;
import com.huarui.product2020.mapper.StudyCenterMapper;
import com.huarui.product2020.mapper.StudyTFavMapper;
import com.huarui.product2020.mapper.StudyTStatMapper;
import com.huarui.product2020.service.StudyCenterService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudyCenterServiceImpl implements StudyCenterService {
	
	@Autowired
	private StudyCenterMapper studyCenterDAO;

	@Autowired
	private StudyTStatMapper studyTStatMapper;

	@Autowired
	private StudyTFavMapper studyTFavMapper;
	
	 /**
	 * 选课中心
	 * @return
	 */
	public List<Map<String, Object>> queryStudyCenterPage(String userid, String type) throws Exception {
		return studyCenterDAO.queryStudyCenterPage(userid,type);
	}
	
	/**
	 * 根据用户ID、资源编码查找主办单位
	 */
	public List<Map<String, Object>> findOrganByUPCode(Map<String, Object> map) throws Exception {
		return studyCenterDAO.findOrganByUPCode(map);
	}
	
	public List<Map<String, Object>> findCatalogByUser(Map<String, Object> map) throws Exception {
		return studyCenterDAO.findCatalogByUser(map);
	}
	
	/**
	 * 选课 加入任务
	 */
	public boolean selectCource(Map<String, Object> map) {
		boolean  flag = false;
		long result = studyCenterDAO.selectCource(map);
		if(result >=1) {
			flag = true;
		}
		return flag;
	}

	public IPage queryStudyCourseWareList(IPage courseWarePage, Map<String, Object> paramMap) throws Exception {
		courseWarePage.setRecords(studyCenterDAO.queryStudyCourseWareList(courseWarePage, paramMap));
		return courseWarePage;
	}

	public Map queryStudyCourseInfo(String leac001) throws Exception {
		return studyCenterDAO.queryStudyCourseInfo(leac001);
	}

	public List queryCourseSpeakerList(String leac001) throws Exception {
		return studyCenterDAO.queryCourseSpeakerList(leac001);
	}

	public Map queryEvaluationNumMap(Map<String, Object> paramMap) throws Exception {
		return studyCenterDAO.queryEvaluationNumMap(paramMap);
	}

	public IPage queryCourseEvaluationList(IPage evaluationPage, Map<String, Object> paramMap) throws Exception {
		evaluationPage.setRecords(studyCenterDAO.queryCourseEvaluationList(evaluationPage,paramMap));
		return evaluationPage;
	}

	public int spotFabulous(Map<String, Object> paramMap) throws Exception {
		return studyCenterDAO.spotFabulous(paramMap);
	}

	public IPage queryStudyNoteList(IPage noteListPage, Map<String, Object> paramMap) throws Exception {
		noteListPage.setRecords(studyCenterDAO.queryStudyNoteList(noteListPage,paramMap));
		return noteListPage;
	}

	@Override
	public List queryCourseEvaluationNum(Map<String, Object> paramMap) {
		return studyCenterDAO.queryCourseEvaluationNum(paramMap);
	}

	public Map queryCompletionStatus(Map<String, Object> paramMap) throws Exception {
		Map map = null;
		int leac018 = NumberUtils.toInt(ObjectUtils.toString(paramMap.get("LEAC018")));
		if(leac018 == 0) {
			map = studyCenterDAO.queryHoursCompletionStatus(paramMap);
		}else if(leac018 == 1) {
			map = studyCenterDAO.queryExamCompletionStatus(paramMap);
		}else {
			map = studyCenterDAO.queryHoursAndExamCompletionStatus(paramMap);
		}
		return map;
	}

	public Map queryStudyTimesAndPraiseNum(Map<String, Object> paramMap) throws Exception {
		return studyCenterDAO.queryStudyTimesAndPraiseNum(paramMap);
	}

	public IPage queryOnlineStudyList(IPage onlineStudyPage, Map<String, Object> paramMap) throws Exception {
		onlineStudyPage.setRecords(studyCenterDAO.queryOnlineStudyList(onlineStudyPage,paramMap));
		return onlineStudyPage;
	}

	public Map queryCourseResultMap(Map<String, Object> paramMap) throws Exception {
		return studyCenterDAO.queryCourseResultMap(paramMap);
	}

	public List getCoursewareList(Map map) throws Exception {
		return studyCenterDAO.getCoursewareList(map);
	}

	public List findLearnCwResultList(Map map) throws Exception {
		return studyCenterDAO.findLearnCwResultList(map);
	}

	public Map queryExamInformation(Map map) throws Exception {
		return studyCenterDAO.queryExamInformation(map);
	}

	public Map findPlayWhichCourseware(Map<String, Object> paramMap) throws Exception {
		return studyCenterDAO.findPlayWhichCourseware(paramMap);
	}

	public List queryFirstLevelDirectory(Map<String, Object> paramMap) throws Exception {
		return studyCenterDAO.queryFirstLevelDirectory(paramMap);
	}

	public List querySecondLevelDirectory(String cata001) throws Exception {
		return studyCenterDAO.querySecondLevelDirectory(cata001);
	}

	public IPage querySelectCourseList(IPage selectCoursePage, Map<String, Object> paramMap) throws Exception {
		selectCoursePage.setRecords(studyCenterDAO.querySelectCourseList(selectCoursePage,paramMap));
		return selectCoursePage;
	}

	public int exitCacheCoursewareProgress(Map<String, Object> paramMap) throws Exception {
		 String lere001 = ThreadUtils.getRTex().getUUID();
		 String lere005 = "0";
		 int lere006 = 0;
			paramMap.put("lere001", lere001);
			paramMap.put("lere006", lere006);
			String lcwr001 = ThreadUtils.getRTex().getUUID();
			String lcwr004 = lere001;
			paramMap.put("lcwr001", lcwr001);
			paramMap.put("lcwr004", lcwr004);
		int lere008 = NumberUtils.toInt(ObjectUtils.toString(paramMap.get("LERE008")));
		int num = 0;
		num = studyCenterDAO.exitViewUpdateCwProgress(paramMap) == true ? 1 : 0;
		if(lere008 == 0) {
			num = studyCenterDAO.exitViewUpdateLRProgress(paramMap) == true ? 1 : 0;
		}
		return num;
	}

	public boolean updateLearnCWRsult(Map<String, Object> paramMap) throws Exception {
		return studyCenterDAO.updateLearnCWRsult(paramMap);
	}

	public boolean courseGraduation(Map<String, Object> paramMap) throws Exception {
		boolean flag = false;
		int leac018 = NumberUtils.toInt(ObjectUtils.toString(paramMap.get("LEAC018")));
		flag = studyCenterDAO.updateLearnResult(paramMap);
		if(leac018 == 1) {
			flag = studyCenterDAO.updateCAllUserHours(paramMap);
		}else if(leac018 == 0 || leac018 == 2) {
			flag = studyCenterDAO.updateUserHours(paramMap);
		}
		return flag;
	}

	public boolean firstInsertLearnResult(Map<String, Object> paramMap) throws Exception {
		String lere001 = ThreadUtils.getRTex().getUUID();
		Float lere005 = 0f;
		Float lere006 = 0f;
		int lere008 = 0;
		paramMap.put("lere001", lere001);
		paramMap.put("lere005", lere005);
		paramMap.put("lere006", lere006);
		paramMap.put("lere008", lere008);
		boolean flag1 = studyCenterDAO.insertLearnResult(paramMap);
		
		String lcwr001 = ThreadUtils.getRTex().getUUID();
		String lcwr004 = lere001;
		Float lcwr007 = 0f;
		Float lcwr008 = 0f;
		int lcwr010 = 0;
		boolean flag2 = studyCenterDAO.insertLearnCwResult(paramMap);
		
		if(flag1 && flag2){
			return true;
		}else{
			return false;
		}
	}

	public List queryLecturerList(Map<String, Object> paramMap) throws Exception {
		return studyCenterDAO.queryLecturerList(paramMap);
	}

	public List queryStudyFinalExamList(Map<String, Object> paramMap) throws Exception {
		return studyCenterDAO.queryStudyFinalExamList(paramMap);
	}

	@Override
	@Transactional
	public int collection(Map<String, Object> paramMap) throws Exception {
		//study_t_stat(学习收藏点赞统计表)  对应课程收藏数加1
		Map<String, Object> favMap = new HashMap<String, Object>();
		favMap.put("stat001", new RText().getUUID());
		favMap.put("stat002", paramMap.get("fav002"));
		studyTStatMapper.collectionCount(favMap);
		return studyTFavMapper.collection(paramMap);
	}

	@Override
	@Transactional
	public int cancelCollection(Map<String, Object> paramMap) throws Exception {
		//study_t_stat(学习收藏点赞统计表)  对应课程收藏数减1
		Map<String, Object> statMap = new HashMap<String, Object>();
		statMap.put("stat002", paramMap.get("fav002"));
		studyTStatMapper.cancelCollectionCount(statMap);

		EntityWrapper<StudyTFav> entityWrapper = new EntityWrapper<>();
		entityWrapper.eq("FAV003", paramMap.get("fav003"));
		entityWrapper.eq("FAV002", paramMap.get("fav002"));
		return studyTFavMapper.delete(entityWrapper);
	}

	//学习笔记-点赞
	@Override
	public void StudyNoteFabulous(Map<String, Object> paramMap) {
		String FabulousType = ObjectUtils.toString(paramMap.get("FabulousType"));
		if (FabulousType.equals("0")) {
			studyCenterDAO.StudyNoteFabulous(paramMap);
		}
		if (FabulousType.equals("1")) {
			studyCenterDAO.deStudyNoteFabulous(paramMap);
		}
	}


	//学习笔记-点赞 //更新数量
	@Override
	public void upStudyNoteFabulous(Map<String, Object> paramMap) {
		studyCenterDAO.upStudyNoteFabulous(paramMap);
	}


}


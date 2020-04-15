package com.huarui.product2020.service.impl;

import com.huarui.common.utils.IPage;
import com.huarui.common.utils.ThreadUtils;
import com.huarui.product2020.entity.ExamTExergrade;
import com.huarui.product2020.entity.ExamTTestactivity;
import com.huarui.product2020.mapper.OnlineExamListMapper;
import com.huarui.product2020.pojo.ExamineeGrade;
import com.huarui.product2020.service.OnlineExamListService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OnlineExamListServiceImpl implements OnlineExamListService{
	
	@Autowired
	private OnlineExamListMapper onlineExamMapper;
	
	/**
	 * 在线考试
	 * 考试列表
	 */
	public IPage<ExamTTestactivity> queryOnlineExamList(IPage<ExamTTestactivity> page, Map<String, Object> map) throws Exception {
		 page.setRecords(onlineExamMapper.queryOnlineExamList(page,map));
		 return page;
	}
	
	/**
	 * 在线考试
	 * 考试须知
	 */
	public Map<String, Object> queryExamInfo(Map<String, Object> map) throws Exception {
		return onlineExamMapper.queryExamInfo(map);
	}
	
	/**
	 * 在线考试
	 * 考试结果
	 */
	public Map<String, Object> queryExamResult(String egra001) throws Exception {
		return onlineExamMapper.queryExamResult(egra001);
	}
	
	/**
	 * 在线考试
	 * 检查考生参考次数
	 */
	public int queryExamTimes(String userid, String tact001) throws Exception {
		return onlineExamMapper.queryExamTimes(userid,tact001);
	}
	
	/**
	 * 在线考试
	 * 获取指定id的答卷信息Map
	 */
	public Map<String, Object> findExamGrade(String userid, String wlgid, String tpid, int randpapers,
                                             boolean create) throws Exception {
		Map map = onlineExamMapper.findExamGrade(userid, tpid);
		if (create && map == null) {
			String id = ThreadUtils.getRTex().getUUID();
			int flag = insertExamGrade(userid, wlgid, tpid, randpapers,id);
			if(flag == 1) {
				map = onlineExamMapper.findExamGradeByID(id); 
			}
		}else {
			// 更新考试成绩表状态为正常状态
			String egra001 = ObjectUtils.toString(map.get("EGRA001"));
			Map examineegrade =new HashMap<>();
			examineegrade.put("EGRA001", egra001);
			examineegrade.put("EGRA019", 1);
			examineegrade.put("EGRA020", new Date());
		}
		
		return map;
	}
	
	/**
	 * 在线考试
	 * 试卷试题题型
	 */
	public List<Map<String, Object>> findTestTxById(Map<String, Object> map) throws Exception {
		return onlineExamMapper.findTestTxById(map);
	}
	
	/**
	 * 在线考试试卷内容
	 * 固定试卷
	 */
	public List<Map<String, Object>> queryExamFixTopicList(Map<String, Object> map) throws Exception {
		return onlineExamMapper.queryExamFixTopicList(map);
	}
	
	/**
	 * 在线考试试卷内容
	 * 固定试卷  子题
	 */
	public List<Map<String, Object>> queryExamFixTopicChildList(Map<String, Object> map) throws Exception {
		return onlineExamMapper.queryExamFixTopicChildList(map);
	}
	
	/**
	 * 在线考试
	 * 获取试卷信息，并且指定是固定试卷还是随机试卷
	 */
	public Map<String, Object> getTestPaperById(String tact001) throws Exception {
		return onlineExamMapper.getTestPaperById(tact001);
	}
	
	/**
	 * 在线考试
	 * 查询试卷试题答案列表
	 */
	public Map findTopicAnswerByExamId(Map args) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> list = onlineExamMapper.findTopicByExamId(args);
		for (Map<String, Object> entity : list) {
			map.put(ObjectUtils.toString(entity.get("TTOP001")), entity);
		}
		return map;
	}
	
	/**
	 * 题库练习目录
	 * @param model
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> findByPageObjectForUser(Map<String, Object> map) throws Exception {
		return onlineExamMapper.findByPageObjectForUser(map);
	}
	
	
	/**
	 * 获取所选题库对应一级题库
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List findAllExerciseList(Map<String, Object> map) {
		List<Map<String, Object>> list = onlineExamMapper.findAllExerciseList(map);
		for (Map exerciseMap : list) {
			Map<String, Object> paramMap = new HashMap<>();
			map.put("CATA001", ObjectUtils.toString(exerciseMap.get("CATA001")));
			List<Map<String, Object>> countList = onlineExamMapper.queryAnswerList(map);
			if(countList == null || countList.size() == 0){
				exerciseMap.put("total", "0");
				exerciseMap.put("alreadyDone", "0");
				exerciseMap.put("accuracy", "0");
				exerciseMap.put("progress", "0%");
			}else{
				for (Map<String, Object> countMap : countList) {
					exerciseMap.put("total", countMap.get("COUNTS"));
					exerciseMap.put("alreadyDone", countMap.get("YD"));
					exerciseMap.put("accuracy", countMap.get("ZQL"));
					exerciseMap.put("progress", countMap.get("JD"));
				}
			}
		}
		return list;
	}
	
	/**
	 * 获取全部知识点以及每个知识点里的题目数
	 * @return
	 */
	public List findKnowledgesList(Map<String, Object> map) {
		return onlineExamMapper.findKnowledgesList(map);
	}
	
	// 添加一个答卷信息
	public int insertExamGrade(String userid, String wlgid, String tpid, int randpapers, String id) throws Exception {
		ExamineeGrade examineeGrade = new ExamineeGrade();
		examineeGrade.setEGRA002(userid);
		examineeGrade.setEGRA003(wlgid);
		examineeGrade.setEGRA004(tpid);

		Random rnd = new Random();
		int serialNO = rnd.nextInt(randpapers) + 1;
		examineeGrade.setEGRA005(serialNO);
		examineeGrade.setEGRA001(id);
		examineeGrade.setEGRA006(1);//考试次数
		examineeGrade.setEGRA007(2);
		examineeGrade.setEGRA008(new Date());
		examineeGrade.setEGRA009(new Date());
		examineeGrade.setEGRA010(0);
		examineeGrade.setEGRA011(0);
		examineeGrade.setEGRA012(0);
		examineeGrade.setEGRA013(0);
		examineeGrade.setEGRA015(0);
		return onlineExamMapper.insertExamGrade(examineeGrade);
	}
	
	/**
	 * 在线考试试卷内容
	 * 固定试卷
	 */
	public List<Map<String, Object>> queryExamFixTopicList1(Map<String, Object> map) throws Exception {
		return onlineExamMapper.queryExamFixTopicList1(map);
	}
	
	/**
	 * 查看试卷
	 * 查看已答的试题情况
	 */
	public List<Map<String, Object>> queryUserAnswer(Map<String, Object> map) throws Exception {
		int examMode =  NumberUtils.toInt(ObjectUtils.toString(map.get("examMode")),0);
		List queryList = new ArrayList();
//		if (examMode == 0) { //固定试卷答案
			String egra001 = ObjectUtils.toString(map.get("egra001"));
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("egra001", egra001);
			queryList = onlineExamMapper.findFixTopicUserAnswer(paramMap);
//		}else {
			//随机试卷 
//			Object[] paperArgs = new Object[]{args[0]};
//			queryList = examDAO.findRandTopicUserAnswer(paperArgs);
//		}
		return queryList;
	}
	
	/**
	 * 获取 题目Map key为题目id value为题目答案
	 * @throws Exception
	 */
	public Map<String, String> findTopicSystemAnswer(String tpid, String egid, int serialNO) throws Exception {
		Map<String, String> map =
				(HashMap<String, String>) findTAMap(tpid, egid, serialNO);
		return map;
	}
	
	
	private Map<String, String> findTAMap(String tpid, String egid, int serialNO) throws Exception {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("tact001", tpid);
		paramMap.put("egra001", egid);
		paramMap.put("serialNO", serialNO);
		List topic = onlineExamMapper.queryExamFixTopicList(paramMap);
//		List topic = onlineExamMapper.findTopic(tpid, egid, serialNO);
		
		Map<String, Object> paramMap2 = new HashMap<String, Object>();
		paramMap2.put("tact001", tpid);
		paramMap2.put("egra001", egid);
		paramMap2.put("serialNO", serialNO);
		List topicChild = onlineExamMapper.queryExamFixTopicChildList(paramMap2);
//		List topicChild = onlineExamMapper.findTopicChild(tpid, egid, serialNO);
		
		Map<String, String> map = new HashMap<String, String>();
		for (Iterator iterator = topic.iterator(); iterator.hasNext();) {
			Map obj = (Map) iterator.next();
			int _basetype = NumberUtils.toInt(ObjectUtils.toString(obj.get("BASETYPE")), 0);
			String _topickey = ObjectUtils.toString(obj.get("TOPICKEY"));
			if (_basetype == 1 || _basetype == 2) {
				_topickey = StringUtils.upperCase(StringUtils.trim(_topickey));
			}
			map.put(ObjectUtils.toString(obj.get("ID")), _topickey);
			map.put(ObjectUtils.toString(obj.get("ID") + "-k"),ObjectUtils.toString(obj.get("TOPICK"), ""));
		}
		for (Iterator iterator = topicChild.iterator(); iterator.hasNext();) {
			Map obj = (Map) iterator.next();
			int _basetype = NumberUtils.toInt(ObjectUtils.toString(obj.get("BASETYPE")), 0);
			String _topickey = ObjectUtils.toString(obj.get("TOPICKEY"));
			if (_basetype == 1 || _basetype == 2) {
				_topickey = StringUtils.upperCase(StringUtils.trim(_topickey));
			}
			map.put(ObjectUtils.toString(obj.get("ID")), _topickey);
			map.put(ObjectUtils.toString(obj.get("ID") + "-k"), StringUtils.trim(ObjectUtils.toString(obj.get("TOPICK"), "")));
		}
		return map;
	}
	
	// 添加或更新题目学员答案
		public void updateExamGrade(ExamineeGrade examineeGrade,
                                    List gradeList, Map examGraduationMap) throws Exception {
				onlineExamMapper.insertTopicAnswer(gradeList);
			if (examineeGrade != null)
				onlineExamMapper.updateExamGrade(examineeGrade);
			int tact005 = NumberUtils.toInt(ObjectUtils.toString(examGraduationMap.get("TACT005")));
//			if(tact005 == 3) {
				try {
					String tact001 = ObjectUtils.toString(examGraduationMap.get("TACT001"));
					Map courseMap =onlineExamMapper.queryCourseMap(tact001);
					if(courseMap != null) {
						int leac018 = NumberUtils.toInt(ObjectUtils.toString(courseMap.get("LEAC018")));
						float totalscore = NumberUtils.toFloat(ObjectUtils.toString(examGraduationMap.get("TOTALSCORE")));
						float tact021 = NumberUtils.toFloat(ObjectUtils.toString(courseMap.get("TACT021")));
						if(totalscore >= tact021) {
							String leac001 = ObjectUtils.toString(courseMap.get("LEAC001"));
							String user001 = ObjectUtils.toString(examGraduationMap.get("USER001"));
//							appLearningModuleDAO.updateLearnResult(new Object[]{courseMap.get("LEAC001"),examGraduationMap.get("USER001")});
							Map resultMap = new HashMap();
							resultMap.put("leac001", leac001);
							resultMap.put("user001", user001);
							onlineExamMapper.updateLearnResult(resultMap);
							Object[] args = {courseMap.get("LEAC001"),
									examGraduationMap.get("USER001"),1,null, ThreadUtils.getRTex().getUUID()};
							Map param2 = new HashMap();
							param2.put("LEAC001",leac001);
							param2.put("USER001",user001);
							param2.put("UHOU005",1);
							param2.put("UUID", ThreadUtils.getRTex().getUUID());
							if(leac018 == 1) {
//								onlineExamMapper.updateCAllUserHours(param2);
							}else if(leac018 == 2) {
//								onlineExamMapper.updateUserHours(param2);
							}						
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
//			}
		}

		@Override
		public List<Map<String, Object>> tk_list(Map<String, Object> map) throws Exception {
			
			return onlineExamMapper.tk_list(map);
		}

		@Override
		public List<Map<String, Object>> tk_practiseDir(Map<String, Object> map) throws Exception {
			
			return  onlineExamMapper.tk_practiseDir(map);
		}

		@Override
		public List<Map<String, Object>> tk_practiseContent(Map<String, Object> map) throws Exception {
		
			return 	onlineExamMapper.tk_practiseContent(map);
		}

		
		//往成绩表里插入一条数据
		@Override
		public void insertGrade(Map<String, Object> map) {
			onlineExamMapper.insertGrade(map);
		}

		/**
		 * 试题的回答情况；
		 * @param map
		 * @return
		 * @throws Exception
		 */
		@Override
		public Map<String, Object> findRightAndError(String tpid){
			return 	onlineExamMapper.findRightAndError(tpid);
		}

		@Override
		public List<Map<String, Object>> selectOnLineExerciseList(Map<String, Object> map) throws Exception {
			
			return  onlineExamMapper.selectOnLineExerciseList(map);
		}

		@Override
		public List<Map<String, Object>> selectCountType(String tkid) throws Exception {
			
			return onlineExamMapper.selectCountType(tkid);
		}

		@Override
		public void insertPractiseContent(Map<String, Object> map) {
			//onlineExamMapper.insertPractiseContent(map);
			
		}
		@Override
		public void insert_findTopicByExerciseId(Map<String, Object> map) throws Exception {
			onlineExamMapper.insert_findTopicByExerciseId(map);
		}
		

		@Override
		public void insertExerSampleContent(Map<String, Object> map) throws Exception {
			onlineExamMapper.insertExerSampleContent(map);
			
		}
	
		@Override
		public List<Map<String, Object>> queryExamFixTopicList2(Map<String, Object> map) throws Exception {
			return onlineExamMapper.queryExamFixTopicList2(map);
		}
	    
		@Override
		public void insert_exerGrade(Map<String, Object> map) throws Exception {
			onlineExamMapper.insert_exerGrade(map);
			
		}
		/**
		 * 查询练习答案列表
		 */
		@Override
		public Map findTopicAnswerByExerciseId(Map<String, Object> map) throws Exception {
			return onlineExamMapper.findTopicAnswerByExerciseId(map);
}

		@Override
		public List<Map<String, Object>> findAnwserTopic(Map<String, Object> map) throws Exception {
			return onlineExamMapper.findAnwserTopic(map);
		}

		@Override
		public void update_exerAnswerTopic(Map<String, Object> map) throws Exception {
			onlineExamMapper.update_exerAnswerTopic(map);
			
		}

		@Override
		public void insert_exerAnswerTopic(Map<String, Object> map) throws Exception {
			onlineExamMapper.insert_exerAnswerTopic(map);
			
		}

		public Map<String, String> findTopicSystemAnswer2(String tpid, String egid) throws Exception {
			Map<String, String> map =
					(HashMap<String, String>) findTAMap2(tpid, egid);
			return map;
		}
		private Map<String, String> findTAMap2(String tpid, String egid) throws Exception {
			Map paramMap = new HashMap();
			paramMap.put("exto002", tpid);
			paramMap.put("exto004", egid);
			List topic = onlineExamMapper.queryExamFixTopicList2(paramMap);
			Map<String, String> map = new HashMap<String, String>();
			for (Iterator iterator = topic.iterator(); iterator.hasNext();) {
				Map obj = (Map) iterator.next();
				int _basetype = NumberUtils.toInt(ObjectUtils.toString(obj.get("BASETYPE")), 0);
				String _topickey = ObjectUtils.toString(obj.get("TOPICKEY"));
				if (_basetype == 1 || _basetype == 2) {
					_topickey = StringUtils.upperCase(StringUtils.trim(_topickey));
				}
				map.put(ObjectUtils.toString(obj.get("ID")), _topickey);
				map.put(ObjectUtils.toString(obj.get("ID") + "-k"),ObjectUtils.toString(obj.get("TOPICK"), ""));
			
			}
			
			return map;
		}

		@Override
		public Map<String, Object> queryExerciseResult(String s1) throws Exception {
		
			return onlineExamMapper.queryExerciseResult(s1);
		}

		@Override
		public Map selectExerSample(String s1) throws Exception {
			
			return onlineExamMapper.selectExerSample(s1);
		}

		@Override
		public List<Map<String, Object>> findExerciseTxById(Map<String, Object> map) throws Exception {
			return onlineExamMapper.findExerciseTxById(map);
		}
		
		public void updateExerGrade(ExamTExergrade examineeGrade,
				List gradeList) throws Exception {
			if(gradeList!=null) {
				onlineExamMapper.insertBatch_ExerAnwserTopic(gradeList);
			}
			if (examineeGrade != null)
				onlineExamMapper.updateExerGrade(examineeGrade);
		}

		public List<Map<String, Object>> queryExamFixTopicList3(Map<String, Object> map) throws Exception {
			return onlineExamMapper.queryExamFixTopicList3(map);
		}

		@Override
		public List<Map<String, Object>> findExerciseRecordByUserId(String st) throws Exception {
			
			return onlineExamMapper.findExerciseRecordByUserId(st);
		}
		
		public IPage selectExerciseHistoryPage(IPage page , Map arg) throws Exception {
			page.setRecords(onlineExamMapper.selectExerciseHistoryPage(page,arg));
	        return page;
		}
		
		public IPage findExerciseRecordByUserId(IPage page, String user001, String tact001) throws Exception {
			page.setRecords(onlineExamMapper.findExerciseRecordByUserId(page,user001,tact001));
	        return page;
		}

		/**
		 * 获取所选题库对应一级题库
		 * @return
		 */
		@SuppressWarnings("unchecked")
		public List findExerciseList1(Map<String, Object> map) {
			List<Map<String, Object>> list = onlineExamMapper.findExerciseList1(map);
			for (Map exerciseMap : list) {
				Map<String, Object> paramMap = new HashMap<>();
				map.put("CATA001", ObjectUtils.toString(exerciseMap.get("CATA001")));
				List<Map<String, Object>> countList = onlineExamMapper.queryAnswerResult(map);
				if(countList == null || countList.size() == 0){
					exerciseMap.put("total", "0");
					exerciseMap.put("alreadyDone", "0");
					exerciseMap.put("accuracy", "0");
					exerciseMap.put("progress", "0%");
				}else{
					for (Map<String, Object> countMap : countList) {
						exerciseMap.put("total", countMap.get("COUNTS"));
						exerciseMap.put("alreadyDone", countMap.get("YD"));
						exerciseMap.put("accuracy", countMap.get("ZQL"));
						exerciseMap.put("progress", countMap.get("JD"));
						
					}
				}
			}
			return list;
		}
		
		/**
		 * 获取全部知识点以及每个知识点里的题目数
		 * @return
		 */
		public List findKnowledgesList1(Map<String, Object> map) {
			return onlineExamMapper.findKnowledgesList1(map);
		}
      
		public Map<String, Object> findExerciseDetailsById(String st) {
			return onlineExamMapper.findExerciseDetailsById(st);
		}

		@Override
		public void insert_findTopicByExerciseId1(Map<String, Object> map) throws Exception {
			onlineExamMapper.insert_findTopicByExerciseId1(map);
		}
}










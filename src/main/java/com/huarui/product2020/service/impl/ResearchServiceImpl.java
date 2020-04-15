package com.huarui.product2020.service.impl;

import com.huarui.common.utils.IPage;
import com.huarui.common.utils.ThreadUtils;
import com.huarui.product2020.mapper.ResearchMapper;
import com.huarui.product2020.pojo.QuesGrade;
import com.huarui.product2020.pojo.QuesResult;
import com.huarui.product2020.service.ResearchService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Clob;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class ResearchServiceImpl implements ResearchService{

	@Autowired
	private ResearchMapper researchMapper;
	
	/**
	 * 问卷调查列表
	 */
	public IPage queryResearchList(IPage researchListPage, Map<String, Object> map) throws Exception {
		researchListPage.setRecords(researchMapper.queryResearchList(researchListPage,map));
		return researchListPage;
	}
	
	/**
	 * 问卷调查--通过ID查询
	 */
	public Map<String, Object> queryResearchByID(Map<String, Object> map) throws Exception {
		return researchMapper.queryResearchByID(map);
	}
	
	/**
	 * 调查次数
	 */
	public List<Map<String, Object>> queryJoinTimes(String userid, String ques001) throws Exception {
		return researchMapper.queryJoinTimes(userid,ques001);
	}
	
	/**
	 * 查询问卷试题列表
	 */
	public List<Map<String, Object>> findTopicByQId(Map<String, Object> map) throws Exception {
		return researchMapper.findTopicByQId(map);
	}
	
	/**
	 * 查询问卷调查的题目
	 */
	public List<Map<String, Object>> findQuesTopic(String ques001) throws Exception {
		return researchMapper.findQuesTopic(ques001);
	}
	
	/**
	 * 查询问卷调查的题目
	 */
	public List<Map<String, Object>> findQuesTopicForApp(String ques001) throws Exception {
		//查询问卷调查的题目
		List<Map<String, Object>> list = researchMapper.findQuesTopic(ques001);
		if(list != null && list.size() > 0){
			for (int i = 0; i < list.size(); i++) {
				Map topicMap = list.get(i);
				topicMap.put("QTOP013", ThreadUtils.getRTex().oracleClob2Str((Clob)topicMap.get("QTOP013")));
				topicMap.put("TOPIC", ThreadUtils.getRTex().oracleClob2Str((Clob)topicMap.get("TOPIC")));
			}
		}
		List newList = new ArrayList();
		String optionChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Map topic = (Map) iterator.next();
			//题型 TOPI005
			int basetype = NumberUtils.toInt(ObjectUtils.toString(topic.get("BASETYPE"))); 
			//题目选项 TOPI010
			String topicoption = ObjectUtils.toString(topic.get("TOPICOPTION"),"");
			//下面可以获得该题目的ID,例如： ques_t_QuesTopic   QTID    QID  
			String qtid = ObjectUtils.toString(topic.get("QTID"),"");
			if(basetype==1 || basetype==2 || basetype==6 || basetype==3) {	//单选题、多选题、优选题 、判断题
				String[] topicoptionArray = topicoption.split("\\$\\$");
				topicoption = "";
				for (int i = 0; i < topicoptionArray.length; i++) {
//					topicoption += optionChar.substring(i, i+1) + "." +  topicoptionArray[i] + "|" + optionChar.substring(i, i+1) + ";";
					topicoption += optionChar.substring(i, i+1) + "." +  topicoptionArray[i] + ";";
				}
				topicoption = StringUtils.removeEnd(topicoption, ";");
				//在这里将问卷调查的结果拼接进来
//				String assessMentinfo = "";
//				try {
//					assessMentinfo = recordPercentage(new Object[] {ques001,qtid});
//					assessMentinfo = StringUtils.removeEnd(assessMentinfo, ";");
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//				topicoption += assessMentinfo;
			}
			topic.put("TOPICOPTION", topicoption);
			newList.add(topic);
		}
		
		
		return list;
	}
	

	/**
	 * 插入问卷调查情况
	 */
	public int insertQuesGrade(QuesGrade quesGrade) throws Exception {
		return researchMapper.insertQuesGrade(quesGrade);
	}
	
	/**
	 * 插入问卷调查结果
	 */
	public int insertQuesResult(QuesResult quesResult) {
		return researchMapper.insertQuesResult(quesResult);
	}
	
	/**
	 * 获取本次调查待调查的教师
	 */
//	public List <Map<String, Object>> queryProficientNameByQid(String ques001) throws Exception{
//		return researchMapper.queryProficientNameByQid(ques001);
//	}
	
	/**
	 * queryQuestionInfoByQtid
	 */
	public Map<String, Object> queryQuestionInfoByQtid(Map<String, Object> map) throws Exception {
		return researchMapper.queryQuestionInfoByQtid(map);
	}
	
	/**
	 * queryQuestionInfoByQtid
	 */
	public List<Map<String, Object>> queryQuesResultList(Map<String, Object> map) throws Exception {
		return researchMapper.queryQuesResultList(map);
	}
	
	/**
	 * 问卷调查
	 * 查询主观题题目的答题结果
	 */
	public List<Map<String, Object>> queryOneQuestionResult(Map<String, Object> map) throws Exception {
		return researchMapper.queryOneQuestionResult(map);
	}
	
}

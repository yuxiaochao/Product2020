package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.common.utils.IPage;
import com.huarui.common.utils.ThreadUtils;
import com.huarui.product2020.entity.ExamTBasetx;
import com.huarui.product2020.entity.ExamTErrortopic;
import com.huarui.product2020.entity.ExamTExergrade;
import com.huarui.product2020.entity.ExerSampleEntity;
import com.huarui.product2020.mapper.ExamTErrortopicMapper;
import com.huarui.product2020.mapper.ExamTExerciseMapper;
import com.huarui.product2020.mapper.ExamTExergradeMapper;
import com.huarui.product2020.service.IExamTErrortopicService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * ${table.comment} 服务实现类
 * </p>
 *
 * @author Chenrui
 * @since 2017-08-13
 */
@Service
public class ExamTErrortopicServiceImpl extends ServiceImpl<ExamTErrortopicMapper, ExamTErrortopic>
		implements IExamTErrortopicService {

	@Autowired
	private ExamTErrortopicMapper errorTopicMapper;
	
	@Autowired
	private ExamTExerciseMapper exerciseMapper;

	@Autowired
	private ExamTExergradeMapper exergradeService;
	
	
	public IPage selectErrorTopicPage(IPage errorTopicPage, String user001) throws Exception {
		List list = errorTopicMapper.selectErrorTopicPage(errorTopicPage, user001);
		errorTopicPage.setRecords(list);
		return errorTopicPage;
	}
	
	/**
	 * 获取用户错题数量
	 * @param user001
	 * @return
	 * @throws Exception
	 */
	public Integer queryErrorTopicCount(String user001) throws Exception {
		return errorTopicMapper.queryErrorTopicCount(user001);
	}
   
	public IPage selectExerciseErrorTopicPage(IPage errorTopicPage, Map<String, Object> user001) throws Exception {
		List list = errorTopicMapper.selectExerciseErrorTopicPage(errorTopicPage, user001);
		errorTopicPage.setRecords(list);
		return errorTopicPage;
	}
	
	public Map selectErrorTopicNumWithKnowledge(Map<String, Object> paramMap) throws Exception {
		Map map = errorTopicMapper.selectErrorTopicNumWithKnowledge(paramMap);
		return map;
	}

	public List selectErrorTopicContentList(Map<String, Object> paramMap) throws Exception {
		return errorTopicMapper.selectErrorTopicContentList(paramMap);
	}

	public List<Map<String, Object>> selectErrorChildTopicContentList(String ttop006) throws Exception {
		return errorTopicMapper.selectErrorChildTopicContentList(ttop006);
	}

	@Override
	public boolean deleteByTopicId(String erto002) throws Exception {

		return errorTopicMapper.deleteByTopicId(erto002);
	}
	
	/**
	 * 根据错题实体类获取错题信息
	 * @param errorTopic
	 * @return
	 */
	public ExamTErrortopic queryErrorTopicByEntity(ExamTErrortopic errorTopic) {
		return errorTopicMapper.queryErrorTopicByEntity(errorTopic);
	}

	/**
	 * 插入错题
	 * @param errorTopic
	 * @return
	 */
	public boolean addErrorTopic(ExamTErrortopic errorTopic) {
		return errorTopicMapper.addErrorTopic(errorTopic);
	}

	/**
	 * 验证是否有未完成的随机错题 
	 */
	public Map<String, Object> checkRandomErrorTopic(Map<String, Object> params){
		List<Map<String, Object>> list =  errorTopicMapper.checkRandomErrorTopic(params);
		Map<String, Object> map = new HashMap<String, Object>();
		if(!list.isEmpty() && list.size() > 0) {
			map = (Map<String, Object>)list.get(0);
		}
		return map;
	}
	
	/**
	 * 获取上次未完成的错题
	 * @throws IOException
	 * @throws SQLException
	 */
	public List<Map<String, Object>> queryErrorTopicList(Map<String, Object> params) throws SQLException, IOException {
		List<Map<String, Object>> list =  errorTopicMapper.queryErrorTopicList(params);
		for(Map<String, Object> map : list) {
			//试题内容
			Clob topic_clob = (Clob) map.get("TOPIC");
			String topic = ClobToString(topic_clob);
			map.put("TOPIC", topic);

			Clob topicoption_clob = (Clob) map.get("TOPICOPTION");
			String topicoption = ClobToString(topicoption_clob);
			map.put("TOPICOPTION", topicoption);

			//题解
			Clob topicmark_clob = (Clob) map.get("TOPREMARK");
			String topicmark = ClobToString(topicmark_clob);
			map.put("TOPREMARK", topicmark);
			
			//主观题答案
			Clob ttop021 = (Clob) map.get("TTOP021");
			String ttop021k = ClobToString(ttop021);
			map.put("TTOP021", ttop021k);
			map.put("TTOP021K", ttop021k);
			String dou = "";
			int baseType = NumberUtils.toInt(ObjectUtils.toString(map.get("BTX003"),""));
			if(baseType == 0) {
				String[] ttop021s = ttop021k.split("[$][$]");
				String answers = "";
				for(int j=0;j<ttop021s.length;j++) {
					answers += dou + ttop021s[j];
					dou = "、";
				}
				//将答案分割
				map.put("TTOP021K", answers);
			}
			
			
			
			Map<String, Object> paramsMap = new HashMap<String, Object>();
			paramsMap.put("topicId", map.get("ID"));
			List<Map<String, Object>> reviewList = exerciseMapper.findReview(paramsMap);//获取学员评论列表
			for(Map<String, Object> map1:reviewList) {
				paramsMap.put("emes001", map1.get("EMES001"));
				List<Map<String, Object>> childList = exerciseMapper.findReviewList(paramsMap); //获取子回复列表
				map1.put("childList", childList);
			}
			map.put("reviewList", ThreadUtils.getRTex().formatList(reviewList));
		}
		return list;
	}
	
	/**
	 * 错题中抽题试题
	 */
	public List<Map<String, Object>> queryQuestionErrorTopicList(Map<String, Object> params){
		List<Map<String, Object>> list =  errorTopicMapper.queryQuestionErrorTopicList(params);
		//将试题放入抽题策略中
		String topi003 = ObjectUtils.toString(params.get("topi003"),"");//知识点
		String user001 = ObjectUtils.toString(params.get("user001"));//用户id
		Integer randomTopicNum = NumberUtils.toInt(ObjectUtils.toString(params.get("randomTopicNum")));
		String exsa001 = ObjectUtils.toString(params.get("exsa001"));
		int exsa010 = 4;
		if(StringUtils.isNotBlank(topi003)) {
			exsa010 = 5;
		}
		//往成绩表里插入一条数据
		ExamTExergrade eg = new ExamTExergrade();
		eg.setExgr003(user001);
		eg.setExgr004("");
		eg.setExgr005(new Date());
		eg.setExgr007(1);
		exergradeService.insert(eg);
		
		ExerSampleEntity exerSample = new ExerSampleEntity();
		exerSample.setExsa001(exsa001);
		exerSample.setExsa002("");
		exerSample.setExsa003(eg.getExgr001());
		exerSample.setExsa004(user001);
		exerSample.setExsa005("");
		exerSample.setExsa006(topi003);
		exerSample.setExsa007(randomTopicNum);
		exerSample.setExsa008(1);
		exerSample.setExsa009(new Date());
		exerSample.setExsa010(exsa010);
		exerciseMapper.insertExerSample(exerSample);
		
		try {
			addErrorTopicToExercise(list,"",eg.getExgr001(),exerSample.getExsa001());
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	/**
	 * 将错题加入练习试题中
	 * @throws IOException
	 * @throws SQLException
	 */
	public void addErrorTopicToExercise(List<Map<String, Object>> topicList, String exer001, String exgr001, String exsa001) throws SQLException, IOException {
		Map<String, Object> paramsMap = new HashMap<>();
		for(Map<String, Object> map : topicList) {
			paramsMap.put("EXTO001", ThreadUtils.getRTex().getUUID());
			paramsMap.put("EXTO002", exer001);
			paramsMap.put("EXTO003", exgr001);
			paramsMap.put("EXTO004", exsa001);
			paramsMap.put("EXTO005", ObjectUtils.toString(map.get("ID")));
			paramsMap.put("EXTO006", ObjectUtils.toString(map.get("TOPI002")));
			paramsMap.put("EXTO007", ObjectUtils.toString(map.get("TTOP008")));
			paramsMap.put("EXTO008", ObjectUtils.toString(map.get("TOPI004")));
			paramsMap.put("EXTO009", ObjectUtils.toString(map.get("BTXTITLE")));
			paramsMap.put("EXTO010", ObjectUtils.toString(map.get("TOPIC")));
			paramsMap.put("EXTO011", ObjectUtils.toString(map.get("TOPI007")));
			paramsMap.put("EXTO012", ObjectUtils.toString(map.get("TOPI008")));
			paramsMap.put("EXTO013", ObjectUtils.toString(map.get("TOPI009")));
			paramsMap.put("EXTO014", ObjectUtils.toString(map.get("TOPI010")));
			paramsMap.put("EXTO015", ObjectUtils.toString(map.get("TOPICMARK")));
			paramsMap.put("EXTO016", ObjectUtils.toString(map.get("TOPICCOUNT")));
			paramsMap.put("EXTO017", ObjectUtils.toString(map.get("TOPICOPTION")));
			paramsMap.put("EXTO018", ObjectUtils.toString(map.get("TOPI014")));
			paramsMap.put("EXTO019", ObjectUtils.toString(map.get("TOPICK")));
			paramsMap.put("EXTO020", ObjectUtils.toString(map.get("TTOP021")));
			paramsMap.put("EXTO021", ObjectUtils.toString(map.get("TOPICKEY")));
			paramsMap.put("EXTO022", ObjectUtils.toString(map.get("TOPREMARK")));
			paramsMap.put("EXTO023", ObjectUtils.toString(map.get("PARENTID")));
			paramsMap.put("EXTO024", ObjectUtils.toString(map.get("TOPI020")));
			paramsMap.put("EXTO025", ObjectUtils.toString(map.get("TOPI021")));
			paramsMap.put("EXTO026", ObjectUtils.toString(map.get("TOPI022")));
			exerciseMapper.addExertopic(paramsMap);
			//试题内容
			Clob topic_clob = (Clob) map.get("TOPIC");
			String topic = ClobToString(topic_clob);
			map.put("TOPIC", topic);

			Clob topicoption_clob = (Clob) map.get("TOPICOPTION");
			String topicoption = ClobToString(topicoption_clob);
			map.put("TOPICOPTION", topicoption);

			//题解
			Clob topicmark_clob = (Clob) map.get("TOPREMARK");
			String topicmark = ClobToString(topicmark_clob);
			map.put("TOPREMARK", topicmark);
			
			//主观题答案
			Clob ttop021 = (Clob) map.get("TTOP021");
			String ttop021k = ClobToString(ttop021);
			map.put("TTOP021", ttop021k);
			map.put("TTOP021K", ttop021k);
			String dou = "";
			int baseType = NumberUtils.toInt(ObjectUtils.toString(map.get("BTX003"),""));
			if(baseType == 0) {
				String[] ttop021s = ttop021k.split("[$][$]");
				String answers = "";
				for(int j=0;j<ttop021s.length;j++) {
					answers += dou + ttop021s[j];
					dou = "、";
				}
				//将答案分割
				map.put("TTOP021K", answers);
			}
			
		}		
	}
	
	// Oracle.sql.Clob类型转换成String类型

	public String ClobToString(Clob clob) throws SQLException, IOException {

		String reString = "";
		if (clob != null) {
			Reader is = clob.getCharacterStream();// 得到流
			BufferedReader br = new BufferedReader(is);
			String s = br.readLine();
			StringBuffer sb = new StringBuffer();
			while (s != null) {// 执行循环将字符串全部取出付值给StringBuffer由StringBuffer转成STRING
				sb.append(s);
				s = br.readLine();
			}
			reString = sb.toString();
		}
		return reString;
	}
	
	/**
	 * 获取错题题型
	 */
	public List<ExamTBasetx> findErrorTopicTx(Map<String, Object> paramMap){
		return errorTopicMapper.findErrorTopicTx(paramMap);
	}
	
	/**
	 * 根据id获取抽题信息
	 */
	public ExerSampleEntity querySampleInfoById(String exsa001) {
		return errorTopicMapper.querySampleInfoById(exsa001);
	}
}














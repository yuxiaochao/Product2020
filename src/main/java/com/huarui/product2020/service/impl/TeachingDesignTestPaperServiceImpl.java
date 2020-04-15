package com.huarui.product2020.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.common.Req;
import com.huarui.common.utils.IPage;
import com.huarui.common.utils.ThreadUtils;
import com.huarui.product2020.entity.*;
import com.huarui.product2020.mapper.*;
import com.huarui.product2020.service.TeachingDesignTestPaperService;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@SuppressWarnings("all")
public class TeachingDesignTestPaperServiceImpl extends ServiceImpl<ExamTTestactivityMapper, ExamTTestactivity> implements TeachingDesignTestPaperService {
	@Autowired
	ExamTTestactivityMapper examTTestactivityMapper;
	@Autowired
	ExamTTopicMapper examTTopicMapper;
	@Autowired
	ExamTBasetxMapper examTBasetxMapper;
	@Autowired
	ExamTTesttxMapper examTTesttxMapper;
	@Autowired
	ExamTTesttacticMapper examTTesttacticMapper;
	@Autowired
	ExamTUserresourcerelationMapper examTUserresourcerelationMapper;
	@Autowired
	private HrswTOrganMapper organMapper;
	@Override
	public ResultEntity insertOrUpdateTestPaper(Req req) throws Exception {
		ResultEntity resultEntity = new ResultEntity();
		String currentMenu=req.getString("currentMenu");
		if(ThreadUtils.getRTex().isEmpty(req.getString("data1"))) {
			req.putParameter("data1", new ArrayList());
		}
		if(ThreadUtils.getRTex().isEmpty(req.getString("data2"))) {
			req.putParameter("data2", new ArrayList());
		}
		if(ThreadUtils.getRTex().isEmpty(req.getString("data3"))) {
			req.putParameter("data3", new ArrayList());
		}
		if(ThreadUtils.getRTex().isEmpty(req.getString("data4"))) {
			req.putParameter("data4", new ArrayList());
		}
		String tact001 = req.getString("tact001");
		String tact001New= ThreadUtils.getRTex().getUUID();
		if("1".equals(currentMenu)) {
			//String tact017 = req.getString("tact017");
			String tact010 = req.getString("tact010");
			String tact011 = req.getString("tact011");
			/*if("true".equals(tact017)) {
				req.putParameter("tact017", 2);
			}else if("false".equals(tact017)) {
				req.putParameter("tact017", 1);
			}*/
			if(ThreadUtils.getRTex().isNotEmpty(tact010)&&!"null".equals(tact010)) {
        		Date date=new Date();
        		date.setTime(Long.parseLong(tact010));
        		String format = DateFormatUtils.format(date, "yyyy-MM-dd HH:mm");
				req.putParameter("tact010", format);
			}else {
				req.putParameter("tact010", "");
			}
			if(ThreadUtils.getRTex().isNotEmpty(tact011)&&!"null".equals(tact011)) {
				Date date=new Date();
        		date.setTime(Long.parseLong(tact011));
        		String format = DateFormatUtils.format(date, "yyyy-MM-dd HH:mm");
				req.putParameter("tact011", format);
			}else {
				req.putParameter("tact011", "");
			}
			ExamTTestactivity examTTestactivity = req.getEntity(ExamTTestactivity.class);
			if(ThreadUtils.getRTex().isNotEmpty(tact001)&&!("null".equals(tact001))) {
				examTTestactivityMapper.updateById(examTTestactivity);
			}else {
				examTTestactivity.setTact001(tact001New);
				examTTestactivity.setTact038(1);//1、组卷中 2、发布 3、归档 4、待发布
				examTTestactivityMapper.insert(examTTestactivity);
			}
			resultEntity.setData(examTTestactivity.getTact001());
		}else if("2".equals(currentMenu)) {
			//1更新试题表
			String dataForm = req.getString("dataForm");
			ExamTTestactivity entity = JSON.parseObject(dataForm, ExamTTestactivity.class);
			JSONObject parseObject = JSON.parseObject(dataForm);
			JSONArray jsonArray = parseObject.getJSONArray("data4");
			if(ThreadUtils.getRTex().isNotEmpty(jsonArray)) {
				JSONObject object = (JSONObject)jsonArray.get(0);
				//JSONObject parseObject2 = JSON.parseObject((String)"");
				String tact020 = object.getString("tact020");
				String tact021 = object.getString("tact021");
				entity.setTact020(Float.parseFloat(tact020));
				entity.setTact021(Float.parseFloat(tact021));
			}
			if (entity.getTact022() == 1) {//出题方式：1、固定 2、随机
				entity.setTact023((long)1);//随机试卷份数
			} else if(entity.getTact022() == 2) {
				entity.setTact023((long)10);
			}
			examTTestactivityMapper.updateById(entity);
			//2
			queue_exampaper(req,entity);
		}else if("3".equals(currentMenu)) {
			req.putParameter("data1", new ArrayList());
			ExamTTestactivity examTTestactivity = req.getEntity(ExamTTestactivity.class);
			ExamTTestactivity selectById = examTTestactivityMapper.selectById(examTTestactivity.getTact001());
			Integer tact038 = selectById.getTact038();
			if(2!=tact038&&3!=tact038) {
				examTTestactivity.setTact038(4);//1、组卷中 2、发布 3、归档 4、待发布
			}
			examTTestactivityMapper.updateById(examTTestactivity);
		}else if("4".equals(currentMenu)) {
			ExamTTestactivity examTTestactivity = new ExamTTestactivity();
			examTTestactivity.setTact001(req.getString("tact001"));
			examTTestactivity.setTact038(2);
			examTTestactivityMapper.updateById(examTTestactivity);
		}
		
		
		ExamTUserresourcerelation userresourcerelationEntity = new ExamTUserresourcerelation();
		if(ThreadUtils.getRTex().isEmpty(tact001)||"null".equals(tact001)) {
			userresourcerelationEntity.setUrre004(tact001New);
		}else {
			userresourcerelationEntity.setUrre004(tact001);
		}
		ExamTUserresourcerelation selectOne = examTUserresourcerelationMapper.selectOne(userresourcerelationEntity);
		if(ThreadUtils.getRTex().isNotEmpty(selectOne)) {
			selectOne.setUrre010(new Date());
			examTUserresourcerelationMapper.update(selectOne, new EntityWrapper<ExamTUserresourcerelation>(userresourcerelationEntity));
		}else {
			userresourcerelationEntity.setUrre001(ThreadUtils.getRTex().getUUID());
			userresourcerelationEntity.setUrre009(req.getUserId());
			userresourcerelationEntity.setUrre010(new Date());
			userresourcerelationEntity.setUrre011(1);
			examTUserresourcerelationMapper.insert(userresourcerelationEntity);
		}
		return resultEntity;
	}
	public void queue_exampaper(Req req, ExamTTestactivity entity) throws Exception {
		// 试卷题型
		insertTestTx(req, entity);
		// 抽题策略
		insertTestTactic(req, entity);
		// 折算分数
		calcMark(entity);
	}
	/**
	 * 折算分数
	 * @param entity
	 * @return
	 */
	private long calcMark(ExamTTestactivity entity) {
		long result = 0;
		
		Long num = 1l;
		if (entity.getTact022() == 2) {//出题方式：1、固定 2、随机
			num = entity.getTact023();
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("scoretype", entity.getTact026());
		map.put("pnum", num);
		map.put("score", entity.getTact020());
		map.put("examid", entity.getTact001());
		if(ThreadUtils.getRTex().isNotEmpty(entity.getTact020())) {
			examTTopicMapper.calcMark(map);
		}
		return result;
	}
	private long insertTestTx(Req req, ExamTTestactivity entity) {
		long result = 0;
		List<ExamTTesttx> data1 = entity.getData1();
		String tact001 = entity.getTact001();
		Integer tact026 = entity.getTact026();
		examTTesttxMapper.delete(new EntityWrapper<ExamTTesttx>().eq("TTX002", tact001));
		if(ThreadUtils.getRTex().isNotEmpty(data1)) {
			for (ExamTTesttx examTTesttx : data1) {
				String ttx008 = examTTesttx.getTtx008();
				if(ThreadUtils.getRTex().isNotEmpty(ttx008)) {
					ExamTBasetx examTBasetx = examTBasetxMapper.selectById(ttx008);
					examTTesttx.setTtx001(ThreadUtils.getRTex().getUUID());
					examTTesttx.setTtx002(tact001);
					examTTesttx.setTtx003(((int)(long)examTBasetx.getBtx003()));
					examTTesttx.setTtx004(examTBasetx.getBtx002());
					if(1==tact026) {//	分数定义模式：1、使用题库中的试题分数，并按试卷总分进行相应折算 2、忽略试题原分数，按题型指定分数
						examTTesttx.setTtx007(1f);
					}
					examTTesttxMapper.insert(examTTesttx);	 
				}
			}
		}
		return result;
	}
	private long insertTestTactic(Req req, ExamTTestactivity entity) {
		long result = 0;
		String[] arr= {"tiankong","danxuan","duoxuan","panduan","wenda","zuhe","youxuan","budingxiang","geren","tuanti"};
		List<String> asList = Arrays.asList(arr);
		String dataForm = req.getString("dataForm");
		JSONObject parseObject = JSON.parseObject(dataForm);
		/*Map jsonSerializeObject = ThreadUtils.getRTex().jsonSerializeObject(dataForm, Map.class);
		List<Map> object3 = (List<Map>)jsonSerializeObject.get("data2");
		Map map = object3.get(0);
		Map object4 = (Map)map.get("danxuan");
		String string2 = ThreadUtils.getRTex().toString(object4.get("usernum"));*/
		JSONArray jsonArray = parseObject.getJSONArray("data2");
		ArrayList<ExamTTesttactic> examTTesttacticList = new ArrayList<ExamTTesttactic>();
		if(ThreadUtils.getRTex().isNotEmpty(jsonArray)) {
			for (Object object : jsonArray) {
				String jsonString = JSON.toJSONString(object);
				JSONObject parseObject3 = JSON.parseObject(jsonString);
				for (String string : asList) {
					JSONObject jsonArray2 = parseObject3.getJSONObject(string);
					if(ThreadUtils.getRTex().isNotEmpty(jsonArray2)) {
						ExamTTesttactic parseObject2 = JSON.parseObject(jsonString, ExamTTesttactic.class);
						String ttac003 = parseObject2.getTtac003();
						if(ThreadUtils.getRTex().isNotEmpty(ttac003)) {
							long object2 = (long)((int)jsonArray2.get("usernum"));
							String ttac012 = (String)jsonArray2.get("ttac012");
							parseObject2.setTtac001(ThreadUtils.getRTex().getUUID());
							parseObject2.setTtac002(entity.getTact001());
							parseObject2.setTtac008(object2);
							parseObject2.setTtac012(ttac012);
							examTTesttacticList.add(parseObject2);
						}
					}
				}
			}
			examTTesttacticMapper.delete(new EntityWrapper<ExamTTesttactic>().eq("TTAC002", entity.getTact001()));
			if(examTTesttacticList.size()>0) {
				examTTesttacticMapper.insertBatch(examTTesttacticList);
			}
		}
		return result;
	}
	@Override
	public List<HashMap<String, Object>> queryKnowledgeList(Map<String, Object> map) {
		List<HashMap<String, Object>> queryKnowledgeList = examTTopicMapper.queryKnowledgeList(map);
		return queryKnowledgeList;
	}
	@Override
	public List<HashMap<String, Object>> testPaperTopicCount(Req req) {
		String[] arrs= {"0","1","2","3","4","5","6","7","8","9"};
		List<String> asList = Arrays.asList(arrs);
		List<HashMap<String, Object>> list = examTTopicMapper.testPaperTopicCount(req);
		for (String str : asList) {
			boolean flag=true;
			for (HashMap<String, Object> hashMap : list) {
				String object = hashMap.get("TOPI005").toString();
				if(str.equals(object)) {
					flag=false;
				}
			}
			if(flag) {
				HashMap<String, Object> hashMap = new HashMap<String, Object>();
				hashMap.put("TOPI005", str);
				hashMap.put("TOPICCOUNT", 0);
				list.add(hashMap);
			}
		}
		return list;
	}

	/**
	 * 对应题型
	 * 
	 * @param ids
	 * @return
	 */
	@Override
	public List<ExamTTesttx> queryTestTx(String ids) {
		return examTTesttxMapper.findByExamId(ids);
	}
	@Override
	public List<Map<String, Object>> queryTestPaperTactic(Req req) {
		String ids = req.getIds();
		List<ExamTTesttactic> testtacticList = examTTesttacticMapper.findTestPaperByExamId(ids);
		
		HrswTOrgan organ = organMapper.findById(req.getUserOrganId());

		List<Map<String, Object>> tacticSubjectList  = new ArrayList<Map<String, Object>>();
		for (ExamTTesttactic testtacticEntity : testtacticList) {
			Map<String, Object> testtacticMap = new HashMap<String, Object>();
			testtacticMap.put("ttac003", testtacticEntity.getTtac003());//来源
			testtacticMap.put("ttac004", testtacticEntity.getTtac004());//知识点
//			testtacticMap.put("ttac010", testtacticEntity.getTtac010());//认知层次
//			testtacticMap.put("ttac011", testtacticEntity.getTtac011());//考试要求
			testtacticMap.put("ttac005", testtacticEntity.getTtac005());//难度
			testtacticMap.put("ttac016", testtacticEntity.getTtac016());//大纲目录id
			testtacticMap.put("ttac016text", testtacticEntity.getTtac016text());//大纲目录名称
//			testtacticMap.put("ttac013", testtacticEntity.getTtac013());//难度
			
			if (tacticSubjectList == null || tacticSubjectList.size() == 0) {
				tacticSubjectList.add(testtacticMap);
				continue;
			}
			
			boolean flag = true;
			for (Map<String, Object> tacticSubjectMap : tacticSubjectList) {
				if ((ThreadUtils.getRTex().isEmpty(testtacticEntity.getTtac012())
						|| testtacticEntity.getTtac003().equals(tacticSubjectMap.get("ttac003")))
						&& (ThreadUtils.getRTex().isEmpty(testtacticEntity.getTtac004())
								|| testtacticEntity.getTtac004().equals(tacticSubjectMap.get("ttac004")))
						&& (ThreadUtils.getRTex().isEmpty(testtacticEntity.getTtac005())
								|| testtacticEntity.getTtac005().equals(tacticSubjectMap.get("ttac005")))
						) {
					flag = false;
					//break;
				}
			}
			
			if (flag) {
				tacticSubjectList.add(testtacticMap);
			}
			
		}
		
		for (Map<String, Object> tacticSubjectMap : tacticSubjectList) {
			req.putParameter("topi032", 2);//题库分类 1正考题库 2练习题库
			req.putParameter("userid", req.getUserId());
			req.putParameter("ttac003", tacticSubjectMap.get("ttac003"));//来源
			req.putParameter("ttac004", tacticSubjectMap.get("ttac004"));//知识点
			req.putParameter("ttac005", tacticSubjectMap.get("ttac005"));//难度
			req.putParameter("ttac016", tacticSubjectMap.get("ttac016"));//大纲目录id
			if("2".equals(organ.getOrga026())) {// 0 中电联 1省级鉴定中心 2市级鉴定站
				req.putParameter("orgaId", organ.getOrga002());
			} else {
				req.putParameter("orgaId", req.getUserOrganId());
			}
			List<HashMap<String, Object>> testPaperTopicCount = testPaperTopicCount(req);
			
			List<ExamTTesttactic> childList  = new ArrayList<ExamTTesttactic>();
			
			for (ExamTTesttactic testtacticEntity : testtacticList) {
				
				if ((ThreadUtils.getRTex().isEmpty(testtacticEntity.getTtac012())
						|| testtacticEntity.getTtac003().equals(tacticSubjectMap.get("ttac003")))
						&& (ThreadUtils.getRTex().isEmpty(testtacticEntity.getTtac004())
								|| testtacticEntity.getTtac004().equals(tacticSubjectMap.get("ttac004")))
						&& (ThreadUtils.getRTex().isEmpty(testtacticEntity.getTtac005())
								|| testtacticEntity.getTtac005().equals(tacticSubjectMap.get("ttac005")))
						) {
					//设置每条策略对应的总题数
					for (HashMap<String, Object> hashMap : testPaperTopicCount) {
						if((hashMap.get("TOPI005")+"").equals(testtacticEntity.getTtac006()+"")){
							testtacticEntity.setAutonum(Integer.parseInt(hashMap.get("TOPICCOUNT")+""));
						}
					}
					childList.add(testtacticEntity);
				}
				
			}
			tacticSubjectMap.put("childList", childList);
		}
		
		return tacticSubjectList;
	
	}
	@Override
	public List<ExamTTestactivity> findByPage(IPage<ExamTTestactivity> page, Req req) {
		List<ExamTTestactivity> findByPage = examTTestactivityMapper.findByPage(page,req);
		return findByPage;
	}
	@Override
	@Transactional
	public void deleteTestPaper(String tact001) {
		if(ThreadUtils.getRTex().isNotEmpty(tact001)) {
			examTTestactivityMapper.deleteById(tact001);//试卷
			examTTesttxMapper.delete(new EntityWrapper<ExamTTesttx>().eq("ttx002", tact001));//试卷题型
			examTTesttacticMapper.delete(new EntityWrapper<ExamTTesttactic>().eq("ttac002", tact001));//试卷策略
		}
	}
}

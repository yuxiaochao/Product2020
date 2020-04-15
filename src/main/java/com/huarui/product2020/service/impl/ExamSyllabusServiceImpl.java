package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.common.Req;
import com.huarui.common.utils.ThreadUtils;
import com.huarui.product2020.entity.ExamSyllabusEntity;
import com.huarui.product2020.entity.HrswTOrgan;
import com.huarui.product2020.mapper.ExamSyllabusMapper;
import com.huarui.product2020.mapper.HrswTOrganMapper;
import com.huarui.product2020.service.ExamSyllabusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ExamSyllabusServiceImpl  extends ServiceImpl<ExamSyllabusMapper,ExamSyllabusEntity>implements ExamSyllabusService{

	@Autowired
	private ExamSyllabusMapper examSyllabusMapper;
	@Autowired
	private HrswTOrganMapper organMapper;
	
	@Override
	public List selectExamSyllabusTree(String id, Map<String, Object> map, Req req) {
		
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("id", "-1");
		hashMap.put("name", "大纲目录");
		hashMap.put("title", "大纲目录");
		hashMap.put("isParent", true);
		hashMap.put("open", "true");
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		list.add(hashMap);
		
		ExamSyllabusEntity t = new ExamSyllabusEntity();
		t.setExsy003(id);
 		t.setExsy006(Integer.parseInt(map.get("exsy006").toString()));
		t.setExsy005(1);/****测试用的，记得去掉啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊****/
 		//如果是鉴定站，使用上级鉴定中心创建的考试大纲，如果是鉴定中心和中电联，使用自己创建的考试大纲
 		HrswTOrgan organ = organMapper.findHrswTOrganById(req.getUserManagerOrganId());
 		if(ThreadUtils.getRTex().isNotEmpty(organ)) {
 			if("2".equals(organ.getOrga026())) {//2市级鉴定站
 				t.setExsy007(organ.getOrga002());
 			} else if ("1".equals(organ.getOrga026())) {//1省级鉴定中心
 				t.setExsy007(req.getUserManagerOrganId());
 			} else if ("0".equals(organ.getOrga026())) {//0 中电联
 				t.setExsy007(req.getUserManagerOrganId());
 			}
 		}
		List<ExamSyllabusEntity> syllabusList = examSyllabusMapper.findByCriteria(t);
		for (ExamSyllabusEntity syllabus : syllabusList) {
			Map<String, Object> organMap = new HashMap<String, Object>();
            organMap.put("id", syllabus.getExsy001());
            organMap.put("pid", id);
            organMap.put("name", syllabus.getExsy002());
            organMap.put("title", syllabus.getExsy002());
            
            String child = ThreadUtils.getRTex().toString(syllabus.getChildCount(), "0");
			if ("0".equals(child)) {
				organMap.put("isParent", false);
				organMap.put("open", "false");
			} else {
				organMap.put("isParent", true);
				organMap.put("open", "true");
			}
            
            list.add(organMap);
		}
		return list;
	}
}
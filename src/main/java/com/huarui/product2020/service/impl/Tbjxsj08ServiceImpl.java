package com.huarui.product2020.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.common.Req;
import com.huarui.common.utils.ThreadUtils;
import com.huarui.product2020.entity.Tbjxsj08;
import com.huarui.product2020.entity.Tbjxsj09;
import com.huarui.product2020.entity.Tbpxb06;
import com.huarui.product2020.mapper.Tbjxsj08Mapper;
import com.huarui.product2020.mapper.Tbjxsj09Mapper;
import com.huarui.product2020.mapper.Tbpxb06Mapper;
import com.huarui.product2020.service.ITbjxsj08Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yuxiaochao
 * @since 2019-10-25
 */
@Service
public class Tbjxsj08ServiceImpl extends ServiceImpl<Tbjxsj08Mapper, Tbjxsj08> implements ITbjxsj08Service {
	@Autowired
	private Tbpxb06Mapper tbpxb06Mapper;
	@Autowired
	private Tbjxsj08Mapper tbjxsj08Mapper;
	@Autowired
	private Tbjxsj09Mapper tbjxsj09Mapper;
	@Override
	@Transactional
	public Map selectGroups(String pxb0101) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		Wrapper<Tbpxb06> wrapper = new EntityWrapper<Tbpxb06>().eq("PXB0602", pxb0101);
		Integer count = tbpxb06Mapper.selectCount(wrapper);//学员总人数
		
		Wrapper<Tbjxsj09> wrapper2 = new EntityWrapper<Tbjxsj09>().eq("JXSJ0902", pxb0101);
		Integer count2 = tbjxsj09Mapper.selectCount(wrapper2);//已分配人数
		
		Integer count3=count-count2;//未分配人数
		
		List<HashMap> list=tbjxsj08Mapper.findList(pxb0101);//当前培训班下的所有小组列表
		ArrayList<String> list2 = new ArrayList<String>();
		if(ThreadUtils.getRTex().isNotEmpty(list)) {
			for (HashMap map2 : list) {
				list2.add((String)map2.get("JXSJ0801"));
			}
		}
		if(list2.size()>0) {
			List<HashMap> list3=tbjxsj09Mapper.findBatchByIds(list2);//当前培训班下已分配小组的成员
			for (HashMap map2 : list) {
				String jxsj0801=(String)map2.get("JXSJ0801");
				ArrayList<HashMap> list4 = new ArrayList<HashMap>();
				for (HashMap map3 : list3) {
					String jxsj0903=(String) map3.get("JXSJ0903");
					if(jxsj0801.equals(jxsj0903)) {
						list4.add(map3);
					}
				}
				map2.put("member", list4);
			}
		}
		
		List<HashMap> list3=tbpxb06Mapper.findNoAllocatedStudents(pxb0101);//当前培训班下未分配小组的成员
		
		HashMap hashMap = new HashMap();
		hashMap.put("studentTotal", count);
		hashMap.put("AllocatedNum", count2);
		hashMap.put("noAllocatedNum", count3);
		hashMap.put("groupList", list);
		hashMap.put("noAllocated", list3);
		
		map.put("studentGroupInfo", hashMap);
		
		return map;
	}
	@Override
	@Transactional
	public void submit(Req req) {
		String studentGroup = req.getString("studentGroup");
		if(ThreadUtils.getRTex().isNotEmpty(studentGroup)) {
			Map map = JSON.parseObject(studentGroup, Map.class);
			String pxb0101 =(String) map.get("pxb0101");
			if(ThreadUtils.getRTex().isNotEmpty(pxb0101)) {
				Wrapper<Tbjxsj08> wrapper = new EntityWrapper<Tbjxsj08>().eq("JXSJ0802", pxb0101);
				tbjxsj08Mapper.delete(wrapper);
				Wrapper<Tbjxsj09> wrapper2 = new EntityWrapper<Tbjxsj09>().eq("JXSJ0902", pxb0101);
				tbjxsj09Mapper.delete(wrapper2);
				List<Map> list =(List<Map>) map.get("group");
				if(ThreadUtils.getRTex().isNotEmpty(list)&&list.size()>0) {
					List<Tbjxsj08> list3=new ArrayList<Tbjxsj08>();
					List<Tbjxsj09> list4=new ArrayList<Tbjxsj09>();
					for (Map map2 : list) {
						Tbjxsj08 tbjxsj08 = new Tbjxsj08();
						String jxsj0801 = ThreadUtils.getRTex().getUUID();
						String jxsj0803 = (String)map2.get("JXSJ0803");
						tbjxsj08.setJxsj0801(jxsj0801);
						tbjxsj08.setJxsj0802(pxb0101);
						tbjxsj08.setJxsj0803(jxsj0803);
						list3.add(tbjxsj08);
						List<Map> list2 = (List<Map>)map2.get("list");
						for (Map map3 : list2) {
							Tbjxsj09 tbjxsj09 = new Tbjxsj09();
							String jxsj0901 = ThreadUtils.getRTex().getUUID();
							Integer jxsj0904=(Integer) map3.get("JXSJ0904");
							String jxsj0905=(String) map3.get("JXSJ0905");
							tbjxsj09.setJxsj0901(jxsj0901);
							tbjxsj09.setJxsj0902(pxb0101);
							tbjxsj09.setJxsj0903(jxsj0801);
							tbjxsj09.setJxsj0904(jxsj0904);
							tbjxsj09.setJxsj0905(jxsj0905);
							list4.add(tbjxsj09);
						}
					}
					tbjxsj08Mapper.insertBatch(list3);
					tbjxsj09Mapper.insertBatch(list4);
				}
			}
		}
	}
	
}

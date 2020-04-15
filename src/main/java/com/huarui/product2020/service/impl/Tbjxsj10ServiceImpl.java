package com.huarui.product2020.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.common.Req;
import com.huarui.common.utils.IPage;
import com.huarui.common.utils.ThreadUtils;
import com.huarui.product2020.entity.Tbjxsj10;
import com.huarui.product2020.entity.Tbjxsj15;
import com.huarui.product2020.mapper.Tbjxsj10Mapper;
import com.huarui.product2020.mapper.Tbjxsj15Mapper;
import com.huarui.product2020.mapper.Tbpxb02Mapper;
import com.huarui.product2020.service.ITbjxsj10Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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
public class Tbjxsj10ServiceImpl extends ServiceImpl<Tbjxsj10Mapper, Tbjxsj10> implements ITbjxsj10Service {
	@Autowired
	private Tbjxsj10Mapper tbjxsj10Mapper;
	@Autowired
	private Tbjxsj15Mapper tbjxsj15Mapper;
	@Autowired
	private Tbpxb02Mapper tbpxb02Mapper;
	@Override
	public List<Tbjxsj10> findByPage(Req req) {
		return tbjxsj10Mapper.findByPage(req);
	}
	@Override
	public String edit(Req req) {

		String data="";
		String records = req.getString("records");
		Tbjxsj10 tbjxsj10 = JSON.parseObject(records, Tbjxsj10.class);
		Map map = JSON.parseObject(records);
		List list = (List) map.get("fileList");
		String jxsj1001=tbjxsj10.getJxsj1001();
		String jxsj1007=tbjxsj10.getJxsj1007();
		if(ThreadUtils.getRTex().isNotEmpty(jxsj1007)) {
			String[] split = jxsj1007.split("_");
			if(split.length==2) {
				tbjxsj10.setJxsj1007(split[0]);
				tbjxsj10.setJxsj1012(Integer.parseInt(split[1]));
			}
		}
		tbjxsj10.setJxsj1011(new Date());
		if(ThreadUtils.getRTex().isNotEmpty(jxsj1001)) {
			tbjxsj10Mapper.updateById(tbjxsj10);
			tbjxsj15Mapper.delete(new EntityWrapper<Tbjxsj15>().eq("TBJXSJ1502", jxsj1001));
			data=jxsj1001;
		}else {
			jxsj1001= ThreadUtils.getRTex().getUUID();
			tbjxsj10.setJxsj1001(jxsj1001);
			tbjxsj10.setJxsj1008(req.getUserId());
			tbjxsj10.setJxsj1010(new Date());
			tbjxsj10Mapper.insert(tbjxsj10);
			data=jxsj1001;
		}
		if(ThreadUtils.getRTex().isNotEmpty(list)&&list.size()>0) {
			List<Tbjxsj15> tbjxsj15List = new ArrayList<Tbjxsj15>();
			for (Object object : list) {
				Tbjxsj15 tbjxsj15=JSON.parseObject(JSON.toJSONString(object),Tbjxsj15.class);
				tbjxsj15.setTbjxsj1501(ThreadUtils.getRTex().getUUID());
				tbjxsj15.setTbjxsj1502(jxsj1001);
				tbjxsj15List.add(tbjxsj15);
			}
			tbjxsj15Mapper.insertBatch(tbjxsj15List);
		}
		return data;
	
	}
	/**
	 * 案例分析弹窗课程
	 * @param req
	 * @return
	 */
	@Override
	public IPage findAllCaseCourse(Req req) {
		int start = req.getCurrentPage();
		int limit = req.getPageSize();
		IPage page = new IPage(start, limit){};
		List<Map<String, String>> list = tbpxb02Mapper.findAllCaseCourse(req, page);
		page.setRecords(list);
		return page;
	}
	
}

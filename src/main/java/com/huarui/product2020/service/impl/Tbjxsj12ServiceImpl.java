package com.huarui.product2020.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.common.Req;
import com.huarui.common.utils.ThreadUtils;
import com.huarui.product2020.entity.Tbjxsj12;
import com.huarui.product2020.entity.Tbjxsj13;
import com.huarui.product2020.mapper.Tbjxsj12Mapper;
import com.huarui.product2020.mapper.Tbjxsj13Mapper;
import com.huarui.product2020.service.ITbjxsj12Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author YanZeYang
 * @since 2019-12-10
 */
@Service
public class Tbjxsj12ServiceImpl extends ServiceImpl<Tbjxsj12Mapper, Tbjxsj12> implements ITbjxsj12Service {
	@Autowired
	private Tbjxsj12Mapper tbjxsj12Mapper;
	@Autowired
	private Tbjxsj13Mapper tbjxsj13Mapper;
	/**
	 * 开班仪式、结业仪式基础数据以及附件保存
	 * @param req
	 */
	@Override
	@Transactional
	public String edit(Req req) {
		String data="";
		String records = req.getString("records");
		Tbjxsj12 tbjxsj12 = JSON.parseObject(records, Tbjxsj12.class);
		Map map = JSON.parseObject(records);
		List list = (List) map.get("tact004");
		String tbjxsj1201=tbjxsj12.getTbjxsj1201();
		if(ThreadUtils.getRTex().isNotEmpty(tbjxsj1201)) {
			tbjxsj12Mapper.updateById(tbjxsj12);
			tbjxsj13Mapper.delete(new EntityWrapper<Tbjxsj13>().eq("tbjxsj1302", tbjxsj1201));
			data=tbjxsj1201;
		}else {
			tbjxsj1201= ThreadUtils.getRTex().getUUID();
			tbjxsj12.setTbjxsj1201(tbjxsj1201);
			tbjxsj12Mapper.insert(tbjxsj12);
			data=tbjxsj1201;
		}
		if(ThreadUtils.getRTex().isNotEmpty(list)) {
			List<Tbjxsj13> tbjxsj13List = new ArrayList<Tbjxsj13>();
			for (Object object : list) {
				Tbjxsj13 tbjxsj13=JSON.parseObject(JSON.toJSONString(object),Tbjxsj13.class);
				tbjxsj13.setTbjxsj1301(ThreadUtils.getRTex().getUUID());
				tbjxsj13.setTbjxsj1302(tbjxsj1201);
				tbjxsj13List.add(tbjxsj13);
			}
			tbjxsj13Mapper.insertBatch(tbjxsj13List);
		}
		return data;
	}
	
}

package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.common.Req;
import com.huarui.common.utils.ThreadUtils;
import com.huarui.product2020.entity.Tbjxsj14;
import com.huarui.product2020.mapper.Tbjxsj14Mapper;
import com.huarui.product2020.service.ITbjxsj14Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author YanZeYang
 * @since 2019-12-17
 */
@Service
public class Tbjxsj14ServiceImpl extends ServiceImpl<Tbjxsj14Mapper, Tbjxsj14> implements ITbjxsj14Service {
	@Autowired
	private Tbjxsj14Mapper tbjxsj14Mapper;
	@Override
	public String submit(Req req) throws Exception {
		String tbjxsj1401 = req.getString("tbjxsj1401");
		String tbjxsj1402 = req.getString("tbjxsj1402");
		switch(tbjxsj1402) {
			case "true":
				req.putParameter("tbjxsj1402", 0);
				break;
			case "false":
				req.putParameter("tbjxsj1402", 1);
				break;
			default:
				req.putParameter("tbjxsj1402", 1);
		}
		Tbjxsj14 tbjxsj14 = req.getEntity(Tbjxsj14.class);
		if(ThreadUtils.getRTex().isNotEmpty(tbjxsj1401)) {
			tbjxsj14Mapper.updateById(tbjxsj14);
		}else {
			tbjxsj14Mapper.insert(tbjxsj14);
		}
		return tbjxsj14.getTbjxsj1401();
	}
	@Override
	public Tbjxsj14 findByCriteria(Req req) throws Exception {
		Tbjxsj14 tbjxsj14 = req.getEntity(Tbjxsj14.class);
		Tbjxsj14 selectOne = tbjxsj14Mapper.selectOne(tbjxsj14);
		return selectOne;
	}
}

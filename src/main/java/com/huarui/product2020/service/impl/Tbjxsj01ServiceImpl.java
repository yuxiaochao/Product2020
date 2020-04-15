package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.common.Req;
import com.huarui.common.utils.ThreadUtils;
import com.huarui.product2020.entity.ResultEntity;
import com.huarui.product2020.entity.Tbjxsj01;
import com.huarui.product2020.mapper.Tbjxsj01Mapper;
import com.huarui.product2020.service.ITbjxsj01Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yuxiaochao
 * @since 2019-10-25
 */
@Service
public class Tbjxsj01ServiceImpl extends ServiceImpl<Tbjxsj01Mapper, Tbjxsj01> implements ITbjxsj01Service {
	@Autowired
	private Tbjxsj01Mapper tbjxsj01Mapper;
	@Override
	@Transactional
	public ResultEntity querySubmit(Req req) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SecurityException, NoSuchFieldException {
		ResultEntity result = new ResultEntity();
		String jxsj0103str = req.getString("jxsj0103");
		String jxsj0102 = req.getString("jxsj0102");
		if(ThreadUtils.getRTex().isNotEmpty(jxsj0102)) {
			Integer delete = tbjxsj01Mapper.delete(new EntityWrapper<Tbjxsj01>().eq("jxsj0102", jxsj0102));
			if(ThreadUtils.getRTex().isNotEmpty(jxsj0103str)) {
				ArrayList<Tbjxsj01> tbjxsj01List = new ArrayList<Tbjxsj01>();
				String[] JXSJ0103Arrays = jxsj0103str.split(",");
				for (String JXSJ0103 : JXSJ0103Arrays) {
					Tbjxsj01 tbjxsj01 = new Tbjxsj01();
					tbjxsj01.setJxsj0102(jxsj0102);
					tbjxsj01.setJxsj0104(1);
					tbjxsj01.setJxsj0101(ThreadUtils.getRTex().getUUID());
					tbjxsj01.setJxsj0103(Integer.parseInt(JXSJ0103));
					tbjxsj01List.add(tbjxsj01);
				}
				tbjxsj01Mapper.insertBatch(tbjxsj01List);
			}
		}
		return result;
	}
	@Override
	public List<String> findAllSelect(Req req) {
		return tbjxsj01Mapper.findAllSelect(req);
	}
}

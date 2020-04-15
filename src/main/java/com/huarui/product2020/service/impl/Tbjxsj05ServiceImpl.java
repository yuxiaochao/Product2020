package com.huarui.product2020.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.common.Req;
import com.huarui.common.utils.IPage;
import com.huarui.common.utils.ThreadUtils;
import com.huarui.product2020.entity.Tbjxsj05;
import com.huarui.product2020.entity.Tbjxsj06;
import com.huarui.product2020.mapper.Tbjxsj05Mapper;
import com.huarui.product2020.mapper.Tbjxsj06Mapper;
import com.huarui.product2020.service.ITbjxsj05Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
public class Tbjxsj05ServiceImpl extends ServiceImpl<Tbjxsj05Mapper, Tbjxsj05> implements ITbjxsj05Service {
	@Autowired
	private Tbjxsj05Mapper tbjxsj05Mapper;
	@Autowired
	private Tbjxsj06Mapper tbjxsj06Mapper;
	@Override
	public List<Tbjxsj05> findByPage(IPage<Tbjxsj05> page, Req req) {
		req.putParameter("pxb0204", 0);//课程形式（面授:0;线上:1;直播:2）
		List<Tbjxsj05> findByPage = tbjxsj05Mapper.findByPage(page,req);
		return findByPage;
	}
	@Override
	@Transactional
	public void submmit(Req req) {
		String tbJXSJ05=req.getString("tbJXSJ05");
		String tbJXSJ06List=req.getString("tbJXSJ06List");
		if(ThreadUtils.getRTex().isNotEmpty(tbJXSJ05)) {
			Tbjxsj05 entity = JSON.parseObject(tbJXSJ05, Tbjxsj05.class);
			String jxsj0501 = entity.getJxsj0501();
			if(ThreadUtils.getRTex().isNotEmpty(jxsj0501)) {
				tbjxsj05Mapper.updateById(entity);
			}else {
				tbjxsj05Mapper.insert(entity);
			}
		}
		List<Tbjxsj06> list = JSON.parseArray(tbJXSJ06List, Tbjxsj06.class);
		ArrayList<Tbjxsj06> list2 = new ArrayList<Tbjxsj06>();
		for (Tbjxsj06 tbjxsj06 : list) {
			String jxsj0602 = tbjxsj06.getJxsj0602();
			if(ThreadUtils.getRTex().isNotEmpty(jxsj0602)&& ThreadUtils.getRTex().isNotEmpty(jxsj0602)) {
				list2.add(tbjxsj06);
			}
		}
		if(list2.size()>0) {
			for (Tbjxsj06 tbjxsj06 : list2) {
				String jxsj0601 = tbjxsj06.getJxsj0601();
				if(ThreadUtils.getRTex().isNotEmpty(jxsj0601)) {
					tbjxsj06Mapper.updateById(tbjxsj06);
				}else {
					tbjxsj06Mapper.insert(tbjxsj06);
				}
			}
		}
	}
}

package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.common.Req;
import com.huarui.common.utils.IPage;
import com.huarui.product2020.entity.Tbjxsj07;
import com.huarui.product2020.mapper.Tbjxsj07Mapper;
import com.huarui.product2020.service.ITbjxsj07Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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
public class Tbjxsj07ServiceImpl extends ServiceImpl<Tbjxsj07Mapper, Tbjxsj07> implements ITbjxsj07Service {
	@Autowired
	private Tbjxsj07Mapper tbjxsj07Mapper;
	@Override
	public List<Tbjxsj07> findByPage(IPage<Tbjxsj07> page, Req req) {
		return tbjxsj07Mapper.findByPage(page,req);
	}
	@Override
	public HashMap findById(String id) {
		// TODO Auto-generated method stub
		return tbjxsj07Mapper.findById(id);
	}
	
}

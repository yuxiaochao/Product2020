package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.common.Req;
import com.huarui.common.utils.IPage;
import com.huarui.product2020.entity.Tbjxsj02;
import com.huarui.product2020.mapper.Tbjxsj02Mapper;
import com.huarui.product2020.service.ITbjxsj02Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class Tbjxsj02ServiceImpl extends ServiceImpl<Tbjxsj02Mapper, Tbjxsj02> implements ITbjxsj02Service {
	@Autowired
	private Tbjxsj02Mapper tbjxsj02Mapper;
	@Override
	public List<Tbjxsj02> findByPage(IPage<Tbjxsj02> page, Req req) {
		return tbjxsj02Mapper.findByPage(page,req);
	}
	
}

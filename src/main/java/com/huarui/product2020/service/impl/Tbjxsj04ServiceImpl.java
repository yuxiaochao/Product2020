package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.common.Req;
import com.huarui.common.utils.IPage;
import com.huarui.product2020.entity.Tbjxsj04;
import com.huarui.product2020.mapper.Tbjxsj04Mapper;
import com.huarui.product2020.service.ITbjxsj04Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class Tbjxsj04ServiceImpl extends ServiceImpl<Tbjxsj04Mapper, Tbjxsj04> implements ITbjxsj04Service {
	@Autowired
	private Tbjxsj04Mapper tbjxsj04Mapper;
	@Override
	public List<Map> findByPage(IPage page, Req req) {
		return tbjxsj04Mapper.findByPage(page,req);
	}
	
}

package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.common.Req;
import com.huarui.product2020.entity.Tbjxsj13;
import com.huarui.product2020.mapper.Tbjxsj13Mapper;
import com.huarui.product2020.service.ITbjxsj13Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author YanZeYang
 * @since 2019-12-11
 */
@Service
public class Tbjxsj13ServiceImpl extends ServiceImpl<Tbjxsj13Mapper, Tbjxsj13> implements ITbjxsj13Service {
	@Autowired
	private Tbjxsj13Mapper tbjxsj13Mapper;
	/**
	 * 已上传列表
	 */
	@Override
	public List<Tbjxsj13> findAllUploads(Req req) {
		return tbjxsj13Mapper.findAllUploads(req);
	}
	
}

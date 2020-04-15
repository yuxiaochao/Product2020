package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.product2020.entity.Tbjhzd03;
import com.huarui.product2020.mapper.Tbjhzd03Mapper;
import com.huarui.product2020.service.ITbjhzd03Service;
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
public class Tbjhzd03ServiceImpl extends ServiceImpl<Tbjhzd03Mapper, Tbjhzd03> implements ITbjhzd03Service {
	@Autowired
	private Tbjhzd03Mapper tbjhzd03Mapper;
	@Override
	public List<Tbjhzd03> findByPage() {
		// TODO Auto-generated method stub
		return tbjhzd03Mapper.findByPage();
	}
	
}

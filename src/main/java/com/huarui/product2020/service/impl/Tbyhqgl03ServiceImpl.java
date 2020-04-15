package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.product2020.entity.Tbyhqgl03;
import com.huarui.product2020.mapper.Tbyhqgl03Mapper;
import com.huarui.product2020.service.ITbyhqgl03Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author panlei
 * @since 2020-04-07
 */
@Service
public class Tbyhqgl03ServiceImpl extends ServiceImpl<Tbyhqgl03Mapper, Tbyhqgl03> implements ITbyhqgl03Service {

	@Autowired
	private Tbyhqgl03Mapper tbyhqgl03Mapper;
	
	/**
	 * 根据卡号密码查找优惠券
	 * @param param
	 * @return
	 */
	@Override
	public List<Tbyhqgl03> findYHQList(Map<String, Object> param) {
		return tbyhqgl03Mapper.findYHQList(param);
	}
	
}

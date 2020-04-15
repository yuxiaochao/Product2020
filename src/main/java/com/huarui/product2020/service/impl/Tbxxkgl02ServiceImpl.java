package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.product2020.entity.Tbxxkgl02;
import com.huarui.product2020.mapper.Tbxxkgl02Mapper;
import com.huarui.product2020.service.ITbxxkgl02Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author su
 * @since 2020-03-27
 */
@Service
public class Tbxxkgl02ServiceImpl extends ServiceImpl<Tbxxkgl02Mapper, Tbxxkgl02> implements ITbxxkgl02Service {

	@Autowired
	private Tbxxkgl02Mapper xxkgl02Mapper;
	
	/**
	 * 查找学习卡绑定的商品
	 * @param param1
	 * @return
	 */
	@Override
	public List<Map<String, Object>> findBindCommodity(Map<String, Object> param1) {
		return xxkgl02Mapper.findBindCommodity(param1);
	}
	
}

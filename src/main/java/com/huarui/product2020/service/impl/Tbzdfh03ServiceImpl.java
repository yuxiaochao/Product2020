package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.product2020.entity.Tbzdfh03;
import com.huarui.product2020.mapper.Tbzdfh03Mapper;
import com.huarui.product2020.service.ITbzdfh03Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 天猫商品自动开卡记录 服务实现类
 * </p>
 *
 * @author panlei
 * @since 2020-03-25
 */
@Service
public class Tbzdfh03ServiceImpl extends ServiceImpl<Tbzdfh03Mapper, Tbzdfh03> implements ITbzdfh03Service {

	@Autowired
	private Tbzdfh03Mapper tbzdfh03Mapper;
	
	/**
	 * 查询tbZDFH03 天猫商品自动开卡对应的商品
	 * @param param1
	 * @return
	 */
	@Override
	public List<Map<String, Object>> findBindCommodity(Map<String, Object> param1) {
		return tbzdfh03Mapper.findBindCommodity(param1);
	}

	/**
	 * 天猫商品自动开卡激活绑定商品,更新状态
	 * @param entity
	 * @return
	 */
	@Override
	public boolean updateActivation(Tbzdfh03 entity) {
		boolean boo = false;
		int update = tbzdfh03Mapper.updateActivation(entity);
		if(0 < update) {
			boo = true;
		}
		return boo;
	}
	
}

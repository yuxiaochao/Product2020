package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.product2020.entity.Tbkcgm06;
import com.huarui.product2020.mapper.Tbkcgm06Mapper;
import com.huarui.product2020.service.ITbkcgm06Service;
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
 * @since 2020-04-15
 */
@Service
public class Tbkcgm06ServiceImpl extends ServiceImpl<Tbkcgm06Mapper, Tbkcgm06> implements ITbkcgm06Service {

	@Autowired
	private Tbkcgm06Mapper tbkcgm06Mapper;
	
	/**
	 * 查询tbKCGM06商品密码卡对应的商品
	 * @param param1
	 * @return
	 */
	@Override
	public List<Map<String, Object>> findBindCommodity(Map<String, Object> param1) {
		return tbkcgm06Mapper.findBindCommodity(param1);
	}

	/**
	 * 商品密码卡激活绑定商品,更新状态
	 * @param entity
	 * @return
	 */
	@Override
	public boolean updateActivation(Tbkcgm06 entity) {
		boolean boo = false;
		int update = tbkcgm06Mapper.updateActivation(entity);
		if(0 < update) {
			boo = true;
		}
		return boo;
	}
	
}

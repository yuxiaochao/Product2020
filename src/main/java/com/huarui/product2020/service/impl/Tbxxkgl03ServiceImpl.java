package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.product2020.entity.Tbxxkgl03;
import com.huarui.product2020.mapper.Tbxxkgl03Mapper;
import com.huarui.product2020.service.ITbxxkgl03Service;
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
public class Tbxxkgl03ServiceImpl extends ServiceImpl<Tbxxkgl03Mapper, Tbxxkgl03> implements ITbxxkgl03Service {

	@Autowired
	private Tbxxkgl03Mapper xxkgl03Mapper;
	
	/**
	 * 根据卡号和密码查找对应的学习卡
	 * @param param
	 * @return
	 */
	@Override
	public List<Tbxxkgl03> findStudyCardList(Map<String, Object> param) {
		return xxkgl03Mapper.findStudyCardList(param);
	}

	/**
	 * 根据学习卡id查找学习卡信息
	 * @param xxkgl0301
	 * @return
	 */
	@Override
	public Tbxxkgl03 findById(String xxkgl0301) {
		return xxkgl03Mapper.findById(xxkgl0301);
	}
	
}

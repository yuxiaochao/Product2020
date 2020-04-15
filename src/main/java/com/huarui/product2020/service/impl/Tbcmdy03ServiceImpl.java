package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.product2020.entity.Tbcmdy03;
import com.huarui.product2020.mapper.Tbcmdy03Mapper;
import com.huarui.product2020.service.ITbcmdy03Service;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author panlei
 * @since 2020-02-15
 */
@Service
public class Tbcmdy03ServiceImpl extends ServiceImpl<Tbcmdy03Mapper, Tbcmdy03> implements ITbcmdy03Service {
	
	/**
	 * 根据专业字典ID获取选课中心数据
	 */
	public List<Tbcmdy03> queryCmdy03List(String cmdy0304){
		return baseMapper.queryCmdy03List(cmdy0304);
	}
	
	/**
	 * 根据上架商品ID获取商品数据
	 */
	public Tbcmdy03 queryCmdy03Info(String cmdy0301){
		return baseMapper.queryCmdy03Info(cmdy0301);
	}
	
}

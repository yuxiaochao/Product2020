package com.huarui.product2020.mapper;

import com.huarui.product2020.entity.Tbcmdy03;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author panlei
 * @since 2020-02-15
 */
public interface Tbcmdy03Mapper extends BaseMapper<Tbcmdy03> {

	/**
	 * 根据专业字典ID获取选课中心数据
	 */
	public List<Tbcmdy03> queryCmdy03List(String cmdy0304);
	

	/**
	 * 根据上架商品ID获取商品数据
	 */
	public Tbcmdy03 queryCmdy03Info(String cmdy0301);
}
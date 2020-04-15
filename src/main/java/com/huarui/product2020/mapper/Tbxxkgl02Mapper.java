package com.huarui.product2020.mapper;

import com.huarui.product2020.entity.Tbxxkgl02;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author su
 * @since 2020-03-27
 */
public interface Tbxxkgl02Mapper extends BaseMapper<Tbxxkgl02> {

	/**
	 * 查找学习卡绑定的商品
	 * @param param1
	 * @return
	 */
	List<Map<String, Object>> findBindCommodity(Map<String, Object> param1);

}
package com.huarui.product2020.mapper;

import com.huarui.product2020.entity.Tbkcgm06;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author su
 * @since 2020-04-15
 */
public interface Tbkcgm06Mapper extends BaseMapper<Tbkcgm06> {

	/**
	 * 查询tbKCGM06商品密码卡对应的商品
	 * @param param1
	 * @return
	 */
	List<Map<String, Object>> findBindCommodity(Map<String, Object> param1);

	/**
	 * 商品密码卡激活绑定商品,更新状态
	 * @param entity
	 * @return
	 */
	int updateActivation(Tbkcgm06 entity);

}
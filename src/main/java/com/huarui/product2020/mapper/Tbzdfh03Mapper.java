package com.huarui.product2020.mapper;

import com.huarui.product2020.entity.Tbzdfh03;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  * 天猫商品自动开卡记录 Mapper 接口
 * </p>
 *
 * @author panlei
 * @since 2020-03-25
 */
public interface Tbzdfh03Mapper extends BaseMapper<Tbzdfh03> {

	/**
	 * 查询tbZDFH03 天猫商品自动开卡对应的商品
	 * @param param1
	 * @return
	 */
	List<Map<String, Object>> findBindCommodity(Map<String, Object> param1);

	/**
	 * 天猫商品自动开卡激活绑定商品,更新状态
	 * @param entity
	 * @return
	 */
	int updateActivation(Tbzdfh03 entity);

}
package com.huarui.product2020.mapper;

import com.huarui.product2020.entity.Tbyhqgl03;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author panlei
 * @since 2020-04-07
 */
public interface Tbyhqgl03Mapper extends BaseMapper<Tbyhqgl03> {

	/**
	 * 根据卡号密码查找优惠券
	 * @param param
	 * @return
	 */
	List<Tbyhqgl03> findYHQList(Map<String, Object> param);

}
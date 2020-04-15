package com.huarui.product2020.mapper;

import com.huarui.product2020.entity.Tbxxkgl03;

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
public interface Tbxxkgl03Mapper extends BaseMapper<Tbxxkgl03> {

	/**
	 * 根据卡号和密码查找对应的学习卡
	 * @param param
	 * @return
	 */
	List<Tbxxkgl03> findStudyCardList(Map<String, Object> param);

	/**
	 * 根据学习卡id查找学习卡信息
	 * @param xxkgl0301
	 * @return
	 */
	Tbxxkgl03 findById(String xxkgl0301);

}
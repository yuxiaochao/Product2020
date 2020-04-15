package com.huarui.product2020.mapper;

import com.huarui.product2020.entity.Dcwj04;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  * 问卷试题表 Mapper 接口
 * </p>
 *
 * @author pl
 * @since 2019-12-21
 */
public interface Dcwj04Mapper extends BaseMapper<Dcwj04> {
	
	/**
	 * 根据问卷id获取问卷试题
	 */
	public List<Dcwj04> queryTopicById(String dcwj0201);

}
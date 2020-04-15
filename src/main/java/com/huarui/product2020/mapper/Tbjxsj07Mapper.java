package com.huarui.product2020.mapper;

import com.huarui.common.Req;
import com.huarui.common.utils.IPage;
import com.huarui.product2020.entity.Tbjxsj07;

import java.util.HashMap;
import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author yuxiaochao
 * @since 2019-10-25
 */
public interface Tbjxsj07Mapper extends BaseMapper<Tbjxsj07> {

	List<Tbjxsj07> findByPage(IPage<Tbjxsj07> page, Req req);

	HashMap findById(String id);

}
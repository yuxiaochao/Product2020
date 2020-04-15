package com.huarui.product2020.mapper;

import com.huarui.product2020.entity.Tbjhzd03;

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
public interface Tbjhzd03Mapper extends BaseMapper<Tbjhzd03> {

	List<Tbjhzd03> findByPage();

}
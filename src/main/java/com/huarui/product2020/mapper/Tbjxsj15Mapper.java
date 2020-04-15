package com.huarui.product2020.mapper;

import com.huarui.product2020.entity.Tbjxsj15;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author YanZeYang
 * @since 2019-12-30
 */
public interface Tbjxsj15Mapper extends BaseMapper<Tbjxsj15> {

	void insertBatch(List<Tbjxsj15> tbjxsj15List);

}
package com.huarui.product2020.mapper;

import com.huarui.product2020.entity.Tbjxsj08;

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
public interface Tbjxsj08Mapper extends BaseMapper<Tbjxsj08> {

	List<HashMap> findList(String pxb0101);

	void insertBatch(List<Tbjxsj08> list3);

}
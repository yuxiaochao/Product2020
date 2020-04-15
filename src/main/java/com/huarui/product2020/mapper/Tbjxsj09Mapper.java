package com.huarui.product2020.mapper;

import com.huarui.product2020.entity.Tbjxsj09;

import java.util.ArrayList;
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
public interface Tbjxsj09Mapper extends BaseMapper<Tbjxsj09> {

	List<HashMap> findBatchByIds(List<String> list2);

	void insertBatch(List<Tbjxsj09> list4);

}
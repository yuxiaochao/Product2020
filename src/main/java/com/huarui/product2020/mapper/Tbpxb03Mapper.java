package com.huarui.product2020.mapper;

import com.huarui.product2020.entity.Tbpxb03;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author yuxiaochao
 * @since 2019-10-25
 */
public interface Tbpxb03Mapper extends BaseMapper<Tbpxb03> {

    List<Tbpxb03> findClassPersonnel(Map paramMap);

}
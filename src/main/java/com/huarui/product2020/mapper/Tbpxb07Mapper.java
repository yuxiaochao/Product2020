package com.huarui.product2020.mapper;

import com.huarui.product2020.entity.Tbpxb07;

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
public interface Tbpxb07Mapper extends BaseMapper<Tbpxb07> {

    List<Tbpxb07> findByClassHourRequirementList(Map paramMap);

}
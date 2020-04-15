package com.huarui.product2020.mapper;

import com.huarui.product2020.entity.Dinnerinformation;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
  * 就餐信息 Mapper 接口
 * </p>
 *
 * @author caifenglin
 * @since 2020-01-06
 */
public interface DinnerinformationMapper extends BaseMapper<Dinnerinformation> {

    List<Dinnerinformation> findList(Page<Dinnerinformation> page, Map<String, Object> paramMap);

}
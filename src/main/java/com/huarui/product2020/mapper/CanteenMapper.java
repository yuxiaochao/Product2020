package com.huarui.product2020.mapper;

import com.huarui.product2020.entity.Canteen;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
  * 餐厅资源 Mapper 接口
 * </p>
 *
 * @author caifenglin
 * @since 2020-01-06
 */
public interface CanteenMapper extends BaseMapper<Canteen> {

    List<Canteen> findList(Page<Canteen> page, Map<String, Object> paramMap);

    List findToExcel(Map paramMap);

    String findMaxCode();

    List<Canteen> findChooseCanteenList(Page<Canteen> page, Map<String, Object> paramMap);

}
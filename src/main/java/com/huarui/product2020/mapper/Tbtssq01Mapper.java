package com.huarui.product2020.mapper;

import com.huarui.product2020.entity.Tbtssq01;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
  * 图书申请 Mapper 接口
 * </p>
 *
 * @author caifl
 * @since 2020-04-01
 */
public interface Tbtssq01Mapper extends BaseMapper<Tbtssq01> {

    List<Tbtssq01> findListByUserId(Page<Tbtssq01> page, Map<String, Object> paramMap);

}
package com.huarui.product2020.mapper;

import com.huarui.common.Req;
import com.huarui.product2020.entity.Tbjxsj10;

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
public interface Tbjxsj10Mapper extends BaseMapper<Tbjxsj10> {

	List<Tbjxsj10> findByPage(Req req);

}
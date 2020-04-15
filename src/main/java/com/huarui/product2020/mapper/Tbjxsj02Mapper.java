package com.huarui.product2020.mapper;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.huarui.common.Req;
import com.huarui.common.utils.IPage;
import com.huarui.product2020.entity.Tbjxsj02;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author yuxiaochao
 * @since 2019-10-25
 */
public interface Tbjxsj02Mapper extends BaseMapper<Tbjxsj02> {

	List<Tbjxsj02> findByPage(IPage<Tbjxsj02> page, Req req);

}
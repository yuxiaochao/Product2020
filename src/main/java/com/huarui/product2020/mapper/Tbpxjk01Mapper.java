package com.huarui.product2020.mapper;

import com.huarui.common.Req;
import com.huarui.product2020.entity.Tbpxjk01;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author YanZeYang
 * @since 2020-01-15
 */
public interface Tbpxjk01Mapper extends BaseMapper<Tbpxjk01> {
	public void insertBatch(Req req);
}
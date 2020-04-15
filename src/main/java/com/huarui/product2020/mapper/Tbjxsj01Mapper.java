package com.huarui.product2020.mapper;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.huarui.common.Req;
import com.huarui.product2020.entity.Tbjxsj01;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author yuxiaochao
 * @since 2019-10-25
 */
public interface Tbjxsj01Mapper extends BaseMapper<Tbjxsj01> {
	/**
	 * 批量插入
	 * @param tbjxsj01List
	 */
	void insertBatch(List<Tbjxsj01> tbjxsj01List);
	/**
	 * 所有启动的功能
	 * @param req
	 * @return
	 */
	List<String> findAllSelect(Req req);

}
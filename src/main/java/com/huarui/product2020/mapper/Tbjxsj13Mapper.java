package com.huarui.product2020.mapper;

import com.huarui.common.Req;
import com.huarui.product2020.entity.Tbjxsj13;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author YanZeYang
 * @since 2019-12-11
 */
public interface Tbjxsj13Mapper extends BaseMapper<Tbjxsj13> {
	/**
	 * 批量插入
	 * @param tbjxsj13List
	 */
	void insertBatch(List<Tbjxsj13> tbjxsj13List);
	/**
	 * 查询已上传列表
	 * @param req
	 * @return
	 */
	List<Tbjxsj13> findAllUploads(Req req);

}
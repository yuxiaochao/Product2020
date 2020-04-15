package com.huarui.product2020.mapper;

import com.huarui.common.Req;
import com.huarui.common.utils.IPage;
import com.huarui.product2020.entity.ExamTTestactivity;
import com.huarui.product2020.entity.Tbjxsj05;

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
public interface Tbjxsj05Mapper extends BaseMapper<Tbjxsj05> {

	List<Tbjxsj05> findByPage(IPage<Tbjxsj05> page, Req req);

}
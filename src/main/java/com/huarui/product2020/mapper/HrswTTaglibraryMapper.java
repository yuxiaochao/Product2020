package com.huarui.product2020.mapper;

import com.huarui.product2020.entity.HrswTTaglibrary;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author panlei
 * @since 2018-10-17
 */
public interface HrswTTaglibraryMapper extends BaseMapper<HrswTTaglibrary> {

	List taskLabelList(Map map)throws Exception;

}
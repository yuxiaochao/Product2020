package com.huarui.product2020.mapper;

import com.huarui.product2020.entity.HrswTNetmeetingrecord;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author panlei
 * @since 2018-03-13
 */
public interface HrswTNetmeetingrecordMapper extends BaseMapper<HrswTNetmeetingrecord> {

	public int insertnetmeetingrecord(Map<String, Object> map); 
	
	
}
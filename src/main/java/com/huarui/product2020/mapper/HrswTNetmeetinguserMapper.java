package com.huarui.product2020.mapper;

import com.huarui.product2020.entity.HrswTNetmeetinguser;

import java.util.List;
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
public interface HrswTNetmeetinguserMapper extends BaseMapper<HrswTNetmeetinguser> {

	
	public List<Map<String, String>> findnetmeetingByUID(Map<String, String> userid);
}
package com.huarui.product2020.mapper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.huarui.product2020.entity.HrswTNetmeeting;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author panlei
 * @since 2018-03-12
 */
public interface HrswTNetmeetingMapper extends BaseMapper<HrswTNetmeeting> {

	
	public List<Map<String,String>> findnetmeetingByMeetingID(Map<String, String> map);
}
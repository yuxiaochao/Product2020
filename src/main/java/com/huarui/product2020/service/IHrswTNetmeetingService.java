package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.product2020.entity.HrswTNetmeeting;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author panlei
 * @since 2018-03-12
 */
public interface IHrswTNetmeetingService extends IService<HrswTNetmeeting> {
	public List<Map<String, String>> findnetmeetingByMeetingID(Map<String, String> map);

}

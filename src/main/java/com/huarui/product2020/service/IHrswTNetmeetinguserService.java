package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.product2020.entity.HrswTNetmeetinguser;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author panlei
 * @since 2018-03-13
 */
public interface IHrswTNetmeetinguserService extends IService<HrswTNetmeetinguser> {
	
	public List<Map<String, String>> findnetmeetingByUID(Map<String, String> userid);
}

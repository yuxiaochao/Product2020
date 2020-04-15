package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.product2020.entity.HrswTNetmeetingrecord;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author panlei
 * @since 2018-03-13
 */
public interface IHrswTNetmeetingrecordService extends IService<HrswTNetmeetingrecord> {
	public int insertnetmeetingrecord(Map<String, Object> map);
}

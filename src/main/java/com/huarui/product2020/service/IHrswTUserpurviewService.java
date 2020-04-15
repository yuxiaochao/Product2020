package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.product2020.entity.HrswTUserpurview;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * ${table.comment} 服务类
 * </p>
 *
 * @author Chenrui
 * @since 2017-08-13
 */
public interface IHrswTUserpurviewService extends IService<HrswTUserpurview> {
	/**
	 * 主办单位
	 * @param ids
	 * @return
	 */
	public List<Map<String, Object>> findOrganByUserId(String ids);

	/**
	 * 根据用户ID、资源编码查找主办单位
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> findOrganByUPCode(Map<String, Object> map);
}

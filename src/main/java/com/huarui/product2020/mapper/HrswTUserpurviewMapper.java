package com.huarui.product2020.mapper;

import com.huarui.product2020.entity.HrswTUserpurview;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  * ${table.comment} Mapper 接口
 * </p>
 *
 * @author Chenrui
 * @since 2017-08-13
 */
public interface HrswTUserpurviewMapper extends BaseMapper<HrswTUserpurview> {
	/**
	 * 根据用户ID查找主办单位
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
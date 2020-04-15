package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.product2020.entity.HrswTUserpurview;
import com.huarui.product2020.mapper.HrswTUserpurviewMapper;
import com.huarui.product2020.service.IHrswTUserpurviewService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * ${table.comment} 服务实现类
 * </p>
 *
 * @author Chenrui
 * @since 2017-08-13
 */
@Service
public class HrswTUserpurviewServiceImpl extends ServiceImpl<HrswTUserpurviewMapper, HrswTUserpurview> implements IHrswTUserpurviewService {
	/**
	 * 主办单位
	 * @param ids
	 * @return
	 */
	public List<Map<String, Object>> findOrganByUserId(String ids) {
		return baseMapper.findOrganByUserId(ids);
	}

	/**
	 * 根据用户ID、资源编码查找主办单位
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> findOrganByUPCode(Map<String, Object> map) {
		return baseMapper.findOrganByUPCode(map);
	}
}

package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.common.Req;
import com.huarui.product2020.entity.HrswTOrgan;

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
public interface IHrswTOrganService extends IService<HrswTOrgan> {
	
	/**
	 * 登录系统时验证用户机构是否禁用
	 * @param organID 机构ID
	 * @return
	 */
	public int findUserOrgStatus(String organID) throws Exception;
	
	/**
	 * 获取异步机构树 JSON数据
	 * 
	 * @param id
	 * @param map
	 * @return
	 */
	public List syncOrganTree(String id, Map<String, Object> map, Req req);

	public HrswTOrgan findById(String userOrganId);
	
	
}

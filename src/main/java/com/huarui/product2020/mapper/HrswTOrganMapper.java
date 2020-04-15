package com.huarui.product2020.mapper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.huarui.product2020.entity.HrswTOrgan;

/**
 * <p>
  * ${table.comment} Mapper 接口
 * </p>
 *
 * @author Chenrui
 * @since 2017-08-13
 */
public interface HrswTOrganMapper extends BaseMapper<HrswTOrgan> {

	/**
	 * 登录系统时验证用户机构是否禁用
	 * @param organID 机构ID
	 * @return
	 */
	int findUserOrgStatus(String organID);
	
	/**
	 * 认证机构
	 * 
	 * @param map
	 * @return
	 */
	public List<HrswTOrgan> authenticaOrganTree(Map<String, Object> map);
	
	/**
	 * 报名机构
	 * 
	 * @param map
	 * @return
	 */
	public List<HrswTOrgan> registrationOrganTree(Map<String, Object> map);
	
	
	/**
	 * 运营单位
	 * 
	 * @param map
	 * @return
	 */
	public List<HrswTOrgan> operationOrganTree(Map<String, Object> map);
	
	/**
	 * 获取下一级子节点
	 * 
	 * @param organEntity
	 * @return
	 */
	public List<Map<String, Object>> findOrganTree(Map<String, Object> map);
	/**
	 * 根据id查寻对象
	 * 
	 * @param id
	 * @return
	 */
	public HrswTOrgan findHrswTOrganById(String id);

	HrswTOrgan findById(String userOrganId);
}
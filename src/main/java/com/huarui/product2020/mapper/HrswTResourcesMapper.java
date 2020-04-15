package com.huarui.product2020.mapper;

import com.huarui.common.Req;
import com.huarui.product2020.entity.HrswTResources;
import com.huarui.product2020.entity.MenuDataItemEntity;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author Administrator
 * @since 2019-07-20
 */
public interface HrswTResourcesMapper extends BaseMapper<HrswTResources> {
	/**
	 * 获取功能菜单
	 * 
	 * @return
	 */
	public List<Map<String, Object>> findResourcesTree(Req req);
	
	/**
	 * 获取业Top务顶层菜单
	 * 
	 * @return
	 */
	public List<HrswTResources> findTopMenu(String userId);
	
	/**
	 * 根据父id获取菜单数据
	 * 
	 * @return
	 */
	public List<MenuDataItemEntity> findMenuByParentId(@Param("id") String id);
	
	
	/**
	 * 获取头部菜单
	 */
	public List<MenuDataItemEntity> findHeadMenu();
	
	/**
	 *获取业务管理菜单数据
	 */
	public List<MenuDataItemEntity> findBusinessMenu(@Param("id") String id, @Param("userid") String userid);

	/**
	 *获取业务管理菜单数据
	 */
	public List<MenuDataItemEntity> findBusinessMenu2(@Param("id") String id, @Param("userid") String userid);

	/**
	 *获取2 、 3级的菜单（不包含业务管理）
	 */
	public List<MenuDataItemEntity> findLeftMenuNotInBusiness(@Param("userid") String id);

	/**
	 *获取业务管理下3 、 4级的菜单
	 */
	public List<MenuDataItemEntity> findLeftMenuInBusiness(@Param("userid") String id);
	
}
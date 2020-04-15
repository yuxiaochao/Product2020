package com.huarui.product2020.service;

import com.baomidou.mybatisplus.service.IService;
import com.huarui.common.Req;
import com.huarui.product2020.entity.HrswTResources;
import com.huarui.product2020.entity.MenuDataItemEntity;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Administrator
 * @since 2019-07-20
 */
public interface IHrswTResourcesService extends IService<HrswTResources> {
	/**
	 * 获取异步资源树 JSON数据
	 * 
	 * @return
	 */
	public List syncResourcesTree(Req req, String userid);
	
	/**
	 * 获取顶级Top菜单
	 * 
	 * @return
	 */
	public List<HrswTResources> findTopMenu(String userId);
	
	/**
	 * 根据父id获取菜单数据
	 * 
	 * @return
	 */
	public List<MenuDataItemEntity> findMenuByParentId(String id);
	
	/**
	 * 获取头部菜单
	 */
	public List<MenuDataItemEntity> findHeadMenu();
	
	/**
	 *获取业务管理菜单数据 
	 */
	public List<MenuDataItemEntity> findBusinessMenu(String id, String userid);

	/**
	 *获取2 、 3级的菜单（不包含业务管理）
	 */
	public List<MenuDataItemEntity> findLeftMenuNotInBusiness(String id);

	/**
	 *获取业务管理下3 、 4级的菜单
	 */
	public List<MenuDataItemEntity> findLeftMenuInBusiness(String id);
	
}

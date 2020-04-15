package com.huarui.product2020.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.huarui.common.Req;
import com.huarui.common.utils.ThreadUtils;
import com.huarui.product2020.entity.HrswTResources;
import com.huarui.product2020.entity.MenuDataItemEntity;
import com.huarui.product2020.mapper.HrswTResourcesMapper;
import com.huarui.product2020.service.IHrswTResourcesService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Administrator
 * @since 2019-07-20
 */
@Service
public class HrswTResourcesServiceImpl extends ServiceImpl<HrswTResourcesMapper, HrswTResources> implements IHrswTResourcesService {
	
	/**
	 * 获取异步机构树 JSON数据
	 * 
	 * @param id
	 * @return
	 */
//	@RedisCached(cacheKey = "syncResourcesTree", SerializerMode = SerializerMode.JSON)
	@Cacheable(value="resourceTree_cache",key="'syncResourcesTree_' + #userid")
	public List syncResourcesTree(Req req, String userid) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		Map<String, Object> resourceMap = new HashMap<String, Object>();
		resourceMap.put("id", "-1");
		resourceMap.put("pId", "-2");
		resourceMap.put("name", "功能菜单");
		resourceMap.put("title", "功能菜单");
		resourceMap.put("isParent", true);
		resourceMap.put("open", true);

		list.add(resourceMap);
		//获得该角色来源 1,'运营单位',2,'认证单位',3,'报名单位'
		Integer source = null;
		req.putParameter("source", source);
		List<Map<String, Object>> resourcelist = baseMapper.findResourcesTree(req);

		for (Map<String, Object> resourceEntity : resourcelist) {
			resourceMap = new HashMap<String, Object>();
			resourceMap.put("id", resourceEntity.get("RESO001"));
			resourceMap.put("pId", resourceEntity.get("RESO009"));
			resourceMap.put("name", resourceEntity.get("RESO002"));
			resourceMap.put("title", resourceEntity.get("RESO002"));

			String child = ThreadUtils.getRTex().toString(resourceEntity.get("CHILDCOUNT"), "0");
			if ("0".equals(child)) {
				resourceMap.put("isParent", false);
				resourceMap.put("open", false);
			} else {
				if ("1".equals(resourceEntity.get("RESO005"))) {
					resourceMap.put("open", true);
				}
				resourceMap.put("isParent", true);
			}
			list.add(resourceMap);
		}
		
		return list;
	}
	
	/**
	 * 获取顶层Top菜单
	 */
	@Cacheable(value="top_menu_cache",key="'top_menu_' + #userId")
	public List<HrswTResources> findTopMenu(String userId) {
		return baseMapper.findTopMenu(userId);
	}
	
	/**
	 * 根据父id获取菜单数据
	 * 
	 * @return
	 */
	public List<MenuDataItemEntity> findMenuByParentId(String id){
		return baseMapper.findMenuByParentId(id);
	}

	/**
	 * 获取头部菜单
	 */
	public List<MenuDataItemEntity> findHeadMenu(){
		return baseMapper.findHeadMenu();
	}
	
	/**
	 *获取业务管理菜单数据 
	 */
	public List<MenuDataItemEntity> findBusinessMenu(String id, String userid){
		return baseMapper.findBusinessMenu(id, userid);
	}

	@Override
	public List<MenuDataItemEntity> findLeftMenuNotInBusiness(String id) {
		return baseMapper.findLeftMenuNotInBusiness(id);
	}

	@Override
	public List<MenuDataItemEntity> findLeftMenuInBusiness(String id) {
		return baseMapper.findLeftMenuInBusiness(id);
	}


}
